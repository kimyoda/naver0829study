--2023-09-21 DB 정규화
--DB 정규화(Normalization)
--정규화란? 한마디로 db 서버의 메모리를 낭비하지 않기위해서
--어떤 테이블을 식별자를 가지는 여러개의 테이블로 나누는 과정을 정규화라 한다
--정규화된 데이타베이스는 중복이 최소화되도록 설계된 데이터베이스이다
--장점 : 메모리를 절약할 수 있다. 구조화된 시스템으로 인해서 관리가 편하다
--단점 : 조회비율이 매우 높은 시스템의 경우에는 테이블간의 join 연산이 반복적으로 이뤄지기 때문에 질의 응답 속도가 살짝 늦어질 수 있다.

--student의 num을 외부키로 갖는 새로운 테이블 stuinfo를 만들어보자
--외부키는 테이블 생성시에 설정해도 되고 나중에 alter 테이블로 설정해도된다
ALTER TABLE stunifo RENAME TO stuinfo;

create table stuninfo (
    idx number(5) CONSTRAINT stuinfo_pk_idx primary key,
    num number(5),
    addr varchar2(20),
    hp varchar2(20));
    
-- student1의 num을 외부키로 설정(이때 주의: student1의 num은 반드시 primary key라야 한다)
--ppt 29페이지에 있음
alter table stuinfo add CONSTRAINT stuinfo_fk_num FOREIGN key(num) references student1(num);   

--stuinfo에 데이타를 추가해보자, 없는번호인 9번으로 insert 시 어떤 오류가 나는지 확인필요
--오류메세지: 무결성 제약조건(ANGEL.STUINFO_FK_NUM)이 위배되었습니다- 부모 키가 없습니다
--student 테이블이 부모테이블: 거기에 num 12가 없어서 오류가 나는 것
insert into stuinfo values (seq_stu.nextval, 12, '서울시 강남구', '010-2323-4545');
--만약 김말자의 정보일경우 김말자의 num이 이므로 8으로 추가해야만 한다, STUNIFO를 눌러 모델을 조회한 후 student1을 조회
insert into stuinfo values (seq_stu.nextval, 8, '서울시 강남구', '010-2323-4545');
insert into stuinfo values (seq_stu.nextval, 7, '제주도', '010-1234-1234');--영숙
insert into stuinfo values (seq_stu.nextval, 3, '부산', '010-8989-7878');--이효리

--stuinfo만 조회
select * from stuinfo;

--student1만 조회
select * from student1;

--개인정보가 등록된 학생에 한해서 모든 정보를 출력해보자(innter join, equi join), 나의 경우는 student1과 stu1
select
    stu1.name, stu1.java, stu1.spring, stu1.ban, info.addr,info.hp
from student1 stu1, stuinfo info
where stu1.num = info.num;

--컬럼명앞에 무조건 어느테이블 소속인지 붙였는데 
-- 양쪽에 같은 컬럼이 없다면 생략해도 된다
select
    name, java, spring, ban, addr, hp--생략가능
from student1 stu1, stuinfo info
where stu1.num = info.num;--생략불가능(num은 둘다 갖고 있기 때문에)


--개인정보가 등록되어있지 않은 학생들을 출력해보자(outer join)
--sub table dp (+) : 등록이 안된 컬럼은 null 값으로 출력한다.
select
    stu1.name, stu1.java, stu1.spring, stu1.ban, info.addr,info.hp
from student1 stu1, stuinfo info
where stu1.num = info.num(+);

--위의 결과에 null인 학생만 출력하고자 하는 경우
select
    stu1.name, stu1.java, stu1.spring, stu1.ban, info.addr,info.hp
from student1 stu1, stuinfo info
where stu1.num = info.num(+) and info.addr is null;

--sub 테이블에 연결된 데이타가 있는데 부모테이블(student1)의 해다아 데이타를 삭제하고자 할 경우
--오류메세지: 무결성 제약조건(ANGEL.STUINFO_FK_NUM)이 위배되었습니다- 자식 레코드가 발견되었습니다
delete from student1 where num = 3;--오류

delete from student1 where num = 1;--지워짐, stuinfo에 데이타가 없어서

--student의 3번 데이타를 지워보자
--자식 테이블(stuinfo의 num이 3인 데이타를 먼저 삭제 후 student 삭제)
delete from stuinfo where num = 3;-- 자식테이블 먼저 삭제
delete from student1 where num = 3;-- 부모테이블 삭제

select * from student1;

--부모 테이블 drop
--오류 발생 : 외래 키에 의해 참조되는 고유/기본 키가 테이블에 있습니다 
drop table student1;

--자식 테이블은 삭제가 될까요?
drop table stuinfo;

----------------------------------------------------------------------
-- 상품정보를 담을 shop 테이블
-- 장바구니에 담을 cart 테이블을 만드는데 상품정보 저장을 위해서 shop의 num을 외부키로 설정
-- 상품을 삭제하면 장바구니의 해당 데이타가 자동으로 삭제되도록 on delete casacde 설정해보자
-- 시퀀스도 새로 하나 마들어보자
create SEQUENCE seq_shop start with 10 increment by 10 nocache;  

--shop table 생성
create table shop (
    sang_no number(5) CONSTRAINT shop_pk_no primary key,
    sang_name varchar2(100),
    sang_price number(7),
    sang_color varchar2(20)
);

--외부키로 연결된 cart 테이블을 생성 - shop의 상품을 지우면 장바구니 목록은 자동으로 지워지도록
-- cascade를 설정해서 생성해보자
create table cart (
    cart_no number(5) CONSTRAINT cart_pk_no primary key,
    sang_no number(5),
    cnt number(5),
    cartday date
);

alter table cart add CONSTRAINT cart_fk_shopno FOREIGN key(sang_no) REFERENCES shop(sang_no) on delete cascade;

--model (ERD) 확인해보세요

-- 5개의 상품을 등록해보자
INSERT INTO shop values(seq_shop.nextval, '블라우스', '23000', 'yellow');
INSERT INTO shop values(seq_shop.nextval, '청바지', '45000', 'black');
INSERT INTO shop values(seq_shop.nextval, '브이넥티', '11000', 'white');
INSERT INTO shop values(seq_shop.nextval, '브이넥티', '23000', 'red');
INSERT INTO shop values(seq_shop.nextval, '체크자켓', '130000', 'gray');
commit;

--cart에 블라우스, 브이넥티(white), 체크자켓 3개에 대해서 추가-날짜는 현재날짜(sysdate)
insert into cart values (seq_shop.nextval, 10, 2, sysdate);
insert into cart values (seq_shop.nextval, 30, 3, '2023-09-20');
insert into cart values (seq_shop.nextval, 50, 1, sysdate);
commit;

select * from cart;
--조회(innner join)

--상품명,가격,색상,갯수,구입일(yyyy-mm-dd hh24:mi)
select sang_name, sang_price, sang_color, cnt, to_char(cartday,'yyyy-mm-dd hh24:mi') cartday
from shop s, cart c
where s.sang_no=c.sang_no;
--아무도 cart에 담지 않은 상품명 조회
--상품명, 가격, 색상
select sang_name, sang_price, sang_color
from shop s, cart c
where s.sang_no=c.sang_no(+) and c.cnt is null;

--cascade를 지정했으므로 cart에 담긴 상품도 삭제가 된다(이때 cart도 자동으로 지워짐)
delete from shop where sang_no = 10;

--부모 테이블 drop 시켜보자
drop table shop; --에러난다, 오류 보고 -ORA-02449: 외래 키에 의해 참조되는 고유/기본 키가 테이블에 있습니다

--테이블 삭제시 sub 테이블 먼저 제거 후 부모 테이블 제거
drop table cart;
drop table shop;

--시퀀스도 지워보자
drop SEQUENCE seq_shop; 


-----------------------------
--문제
-- 시퀀스:seq_food 생성
create SEQUENCE seq_food;
-- 레스토랑의 메뉴 테이블(테이블명: food)
-- food_num 숫자 (5) 기본키, fname 문자열(20): 메뉴명, fprice 숫자(7) : 가격
Alter table food drop CONSTRAINT shop_pk_no;  
create table food (
    food_num number(5) CONSTRAINT food_pk_no primary key,
    fname varchar2(20),
    fprice varchar(7)
);
DROP TABLE food;
-- 레스토랑의 메뉴 테이블(테이블명: food)
-- food_num 숫자 (5) 기본키, fname 문자열(20): 메뉴명, fprice 숫자(7) : 가격
create table food (
    food_num number(5) CONSTRAINT food_pk_no primary key,
    fname varchar2(20),
    fprice varchar2(7)
);

-- sub 테이블은: 고객 테이블(person)
-- person_num 숫자(5) 기본키, food_num 외부키 설정(cascade 설정)
-- person_name 문자열(10) : 고객명
DROP TABLE person;
create table person (
    person_num number(5) CONSTRAINT person_pk_no primary key,
    food_num number(5),
    person_name varchar2(10),
    bookingday date
);
-- 예약일: bookingday: date 타입
alter table person add CONSTRAINT person_fk_foodnum FOREIGN key(food_num) REFERENCES food(food_num) on delete cascade;

--food에 5개의 메뉴를 등록하자(스파게티, 떡볶이, 돈까스, 오므라이스, 김밥 등등등..)
INSERT INTO food values(seq_food.nextval, '스파게티', '12000');
INSERT INTO food values(seq_food.nextval, '떡볶이', '8000');
INSERT INTO food values(seq_food.nextval, '돈까스', '9000');
INSERT INTO food values(seq_food.nextval, '오므라이스', '6000');
INSERT INTO food values(seq_food.nextval, '김밥', '5000');
commit;

--주문한 고객정보를 추가해보자(같은 메뉴를 여러명 주문하기도 함..)
insert into person values (seq_food.nextval, 1, '이상우', sysdate);
insert into person values (seq_food.nextval, 3, '강호동', sysdate);
insert into person values (seq_food.nextval, 4, '유재석', sysdate);
insert into person values (seq_food.nextval, 2, '이재영', sysdate);
insert into person values (seq_food.nextval, 5, '나탈리', sysdate);
commit;
-- 메뉴 중 스파게티를 삭제 시 주문한 테이블에서도 지워지는 지 확인
delete from food where food_num = 1;
select * from food;
-- 조회 : 시퀀스, 주문자명 , 음식명, 가격, 예약일(제목도 한글로)
select
 f.food_num 메뉴번호, person_name 주문자명, fname 메뉴명, fprice 가격, 
 to_char(bookingday,'yyyy-mm-dd') 예약일 from food f, person p where f.food_num = p.food_num;




