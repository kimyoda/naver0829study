--PL-SQL이란?
-- SQL 언어에 절차적 언어요소를 추가해서 프로그래밍 한것을 PL-SQL 이라고 한다.
-- 예제 1
DECLARE
    -- 변수 선언하는 영역 
    v_no NUMBER(4, 1); --4자리의 소숫점이하 1자리 값을 넣는 변수 선언

BEGIN 
    --sql구문이나 pl-sql 문으로 코딩하는 영역(:=: 대입, =: 비교, 동등)
    v_no := 12.7;
    dbms_output.put_line(v_no);--출력
END;
/

--예제 2 
DECLARE
    vname VARCHAR2(20);
    vban  VARCHAR2(20);
BEGIN
    SELECT
        name,
        ban
    INTO
        vname,
        vban
    FROM
        student1
    WHERE
        num = 7;

    dbms_output.put_line(vname
                         || '님은 '
                         || vban
                         || '입니다');--출력

END;
/
--예제3 person과  food 테이블을 조인하여 person_num이 27인 사람의 이름, 주문한 메뉴, 가격을 출력하시오
DECLARE
    vname  VARCHAR2(20);
    vfood  VARCHAR2(20);
    vprice NUMBER(7);
BEGIN
    SELECT
        person_name,
        fname,
        fprice
    INTO
        vname,
        vfood,
        vprice
    FROM
        food   f,
        person p
    WHERE
            f.food_num = p.food_num
        AND person_num = 30;

    dbms_output.put_line('주문자:' || vname);--출력
    dbms_output.put_line('메뉴:' || vfood);--출력
    dbms_output.put_line('가격:' || vprice);--출력

END;
/

--예제4
-- 상품명을 변수에 지정한 후 해당 상품명의 가격과 색상을 출력
DECLARE
    vsangpum VARCHAR2(20) := '청바지';
    vcolor   VARCHAR2(20);
    vprice   NUMBER(7);
    vprice2  VARCHAR2(20);
BEGIN
    SELECT
        sang_price,
        sang_color,
        ltrim(to_char(sang_price, 'L999,999'))
    INTO
        vprice,
        vcolor,
        vprice2
    FROM
        shop
    WHERE
        sang_name = vsangpum;

    dbms_output.put_line('상품명:' || vsangpum);--출력
    dbms_output.put_line('색  상:' || vcolor);--출력
    dbms_output.put_line('단  가:' || vprice);--출력
    dbms_output.put_line('단  가:' || vprice2);--출력

END;
/

/*
if 조건식 then
   문장1;
else 
    문장2;
end if;

다중 if문(중요 e없음)
if 조건식1 then
    문장1;
elsif 조건2 then
    문장2;
    ...
end if;    

*/

--예제5
--년도에 맞는 띠구하기

--키보드로 년도를 입력받고자 할 경우
accpet year prompt '태어난 년도를 입력하세요';
DECLARE
    --v_year number(4) := 1989;
    v_year number(4) := '&year'; --입력한 값을 대입
    v_mod number(2) := mod(v_year,12); --년도를 12로 나눈 나머지를 구한다
    v_ddi varchar2(10); --띠 저장할 변수
BEGIN 
    if v_mod=0 then v_ddi:='원숭이';
    elsif v_mod=1 then v_ddi:='닭';
    elsif v_mod=2 then v_ddi:='개';
    elsif v_mod=3 then v_ddi:='돼지';
    elsif v_mod=4 then v_ddi:='쥐';
    elsif v_mod=5 then v_ddi:='소';
    elsif v_mod=6 then v_ddi:='호랑이';
    elsif v_mod=7 then v_ddi:='토끼';
    elsif v_mod=8 then v_ddi:='용';
    elsif v_mod=9 then v_ddi:='뱀';
    elsif v_mod=10 then v_ddi:='말';
    elsif v_mod=11 then v_ddi:='양';
    end if;            
    DBMS_Output.put_line(v_year||'년생은'||v_ddi||'띠입니다');--출력
END;
/

--예제6
--db 칼럼의 타입을 가져오는 방법 TYPE, 두번 눌러었어야함
accept iname prompt 'name?';
DECLARE
    v_name student1.name%TYPE :='&iname';
    v_height student1.height%TYPE;
    v_java student1.java%TYPE;
    v_spring student1.spring%TYPE;
    
BEGIN
SELECT
    height,
    java,
    spring
INTO
    v_height,
    v_java,
    v_spring
FROM
    student1
WHERE
    name = v_name;

dbms_output.put_line('학생명: ' || v_name);--출력
dbms_output.put_line('키:' || v_height);--출력
dbms_output.put_line('자바점수:' || v_java);--출력
dbms_output.put_line('스프링점수:' || v_spring);--출력
dbms_output.put_line('총점:' ||(v_java + v_spring));--출력
end;
/

/*
    반복문 : loop
    lopp
        문장들;
        exit when 조건;
    end loop;    

*/
--1부터 10까지 반복해서 출력
s_output.put_line('학생명: ' || v_name);--출력
dbms_output.put_line('키:' || v_height);--출력
dbms_output.put_line('자바점수:' || v_java);--출력
dbms_output.put_line('스프링점수:' || v_spring);--출력
dbms_output.put_line('총점:' ||(v_java + v_spring));--출력
end;
/

/*
    반복문 : loop
    lopp
        문장들;
        exit when 조건;
    end loop;    

*/
--1부터 10까지 반복해서 출력
--문제: 단을 입력하면 해당단을 출력하시오
accept dan prompt 'dan?';
DECLARE
    v_dan number(2) := '&dan'; --dan에 곱한다
    v_idx number(1) := 1;
BEGIN 
    DBMS_Output.put_line('**'||v_dan||' 단 **');--출력
loop
    DBMS_Output.put_line(v_dan ||'X'||v_idx||'='||v_dan*v_idx);--출력
    v_idx := v_idx+1;
    exit when v_idx=10;
    end loop;  
END;
/
--상품명을 변수로 지정한 후 해당 상품명의 가격과 색상을 출력
--예제 9 - Exception 처리(예제 4 복사)
accept sangpum prompt 'sangpum?';
DECLARE
    vsangpum VARCHAR2(20) := '&sangpum';
    vcolor   VARCHAR2(20);
    vprice   NUMBER(7);
    vprice2  VARCHAR2(20);
BEGIN
    SELECT
        sang_price,
        sang_color,
        ltrim(to_char(sang_price, 'L999,999'))
    INTO
        vprice,
        vcolor,
        vprice2
    FROM
        shop
    WHERE
        sang_name = vsangpum;

    dbms_output.put_line('상품명:' || vsangpum);--출력
    dbms_output.put_line('색  상:' || vcolor);--출력
    dbms_output.put_line('단  가:' || vprice);--출력
    dbms_output.put_line('단  가:' || vprice2);--출력
    
    --결과가 2개 이상이거나 없으면 오류발생
    --오라클에서 예외처리 하는 방법
    EXCEPTION
    when NO_DATA_FOUND then
        dbms_output.put_line(vsangpum || '상품은 DB에 없습니다');
    when TOO_MANY_ROWS then
        dbms_output.put_line(vsangpum || '상품이 DB에 두개이상 존재합니다');
    when others then
        dbms_output.put_line(vsangpum || '상품에 대한 오류 발생-뭔지모름');
END;
/

/*
    반복문
    for 변수 in [reverse] 시작값... 최종값 loop
        문장들;
    end loop;    


*/
--예제10, 예제8 구구단 복사후 for문으로 변경하기
accept dan prompt 'dan?';
DECLARE
    v_dan number(2) := '&dan';
    v_idx number(1);
BEGIN 
    DBMS_Output.put_line('** '||v_dan||' 단 **');--출력
    for v_idx in 1..9 loop
        DBMS_Output.put_line(v_dan ||'X'||v_idx||'='||v_dan*v_idx);--출
    end loop;   
END;
/


--레코드 단위로 데이타 가져오기
DECLARE
    V_num student1.num%TYPE :=7;
    V_stu1 angel.student%rowtype; --레코드단위로 읽어올 경우
BEGIN 
    select * into v_stu1 
    from student1 where num=v_num;
    
    DBMS_Output.put_line('이름:'||v_stu1.name);
    DBMS_Output.put_line('키:'||v_stu1.height);
    DBMS_Output.put_line('자바:'||v_stu1.java);
    DBMS_Output.put_line('스프링:'||v_stu1.spring);
    DBMS_Output.put_line('반:'||v_stu1.ban);

END;
/

-- db 의 여러데이타를 조회할 경우
/*
    Cursor : sql 문을 실행할 때마다 명령이 분석되고 실행되어 결과를 보관하기위한
    특별한 메모리 영역을 사용하는데 이영역을 참조하는 것이 커서이다.
    
    select 문에서 여러 데이타 조회시 사용하는 객체이다 
    
    커서 속성
    sql%rowcount : 실행된 갯수를 반환
    sql%found : 가장 최근의 sql문이 하나 이상의 행에 영향을 준 경우 true 값을 반환
    sql%notfound : 결과행이 없는경우
    sql%isopen : 항상 false(항상 close를 하기 때문에 항상 false)
*/

--예제 12
DECLARE
    v_sno number(3) :=20;
    v_shop angel.shop%rowtype;
    
BEGIN
    select * into v_shop
    from shop where sang_no=v_sno;
    
    DBMS_Output.put_line('상풍명:'||v_shop.sang_name);--출력
    DBMS_Output.put_line('조회된 실행갯수:'||sql%rowcount);--1

    
    --student의 java점수 변경하기
    update student set java = 99;
    DBMS_Output.put_line('수정된 실행갯수:'||sql%rowcount);--1
END;
/

--여러 레코드 조회
--예제 13
DECLARE
    Cursor S1
    is
    select * from shop;
BEGIN 
    DBMS_Output.put_line('상품번호     상품명    색상     가격');--출력
    DBMS_Output.put_line('---------------------------------');--출력
    for s in s1 loop
        exit when s1%notfound;-- 더이상 데이터가 없으면 빠져나간다
        DBMS_Output.put_line(s.sang_no || '   ' || s.sang_name || '   ' || s.sang_color || '    ' || s.sang_price);--출력
    end loop;
END;
/

--예제 14
--상품명, 색상, 가격을 입력하면 shop db에 추가하기
accept isang prompt 'sangpum?';
accept icolor prompt 'color?';
accept iprice prompt 'price?';
DECLARE
    v_sang shop.sang_name%TYPE:='&isang';
    v_color shop.sang_color%TYPE:='&icolor';
    v_price shop.sang_price%TYPE:='&iprice';
BEGIN 
    insert into shop values (seq_shop.nextval, v_sang, v_price, v_color);
    commit;
    DBMS_Output.put_line('상품정보를 추가했습니다');--출력
END;
/


--문제 : food 테이블
/*
 
    fname, fprice, no 입력을 받아서 
    no가 1이면 fname, fprice로 데이터 추가를 하고 
    no가 2면 전체 food 전체 데이타 출력

*/

/*
--입력값 설정 씁..
accept ifname prompt 'fname?';
accept ifprice prompt 'fprice?';
accept v_no prompt 'no?';
DECLARE --fname, fprice no
    v_fname food.fname%TYPE := '&ifname.';
    v_fprice food.fprice%TYPE := '&ifprice.';
    v_no NUMBER(2) := '&v_no.';
    
    Cursor S1
    is
    select * from food;
    
BEGIN 
    if v_no = 1 then
    insert into food values(seq_food.nextval,v_fname,v_fprice);
    commit;
    DBMS_Output.put_line('상품정보를 추가했습니다');--출력
    elsif v_no =2 then 
    DBMS_Output.put_line('상품번호     음식명      가격          ');--출력
    DBMS_Output.put_line('---------------------------------');--출력
    FOR s IN S1 LOOP
            DBMS_OUTPUT.PUT_LINE(s.food_num || '     ' || s.fname || '      ' || s.fprice); -- 데이터 출력
    exit when s1%notfound;
    END LOOP;
    end if;            
END;
/
*/

--강사님 풀이
accept iname prompt 'food name?';
accept iprice prompt 'food price?;'
accept ino prompt 'no?'
DECLARE
    v_no number(1) := '&ino';
    v_fname food.fname%TYPE := '&iname';
    v_fprice food.fprice%TYPE := '&iprice';
    
    Cursor s1
    is
    select * from food;
    
BEGIN
    if v_no = 1 then
        insert into food values (seq_food.nextval,v_fname,v_fprice);
        commit;
        DBMS_output.put_line('메뉴를 추가했습니다');
    else
        DBMS_output.put_line('메뉴번호    메뉴명    가격');
        DBMS_output.put_line('------------------------');
    for s in s1 loop       
        DBMS_output.put_line(s.food_num||'    ' || s.fname||'    '||s.fprice);
    exit when s1%notfound;
   end loop;
  end if;
 end;
/







