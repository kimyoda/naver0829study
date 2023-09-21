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











