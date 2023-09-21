--PL-SQL이란?
-- SQL 언어에 절차적 언어요소를 추가해서 프로그래밍 한것을 PL-SQL 이라고 한다.
-- 예제 1
DECLARE
    -- 변수 선언하는 영역 
    v_no number(4,1); --4자리의 소숫점이하 1자리 값을 넣는 변수 선언
    
BEGIN 
    --sql구문이나 pl-sql 문으로 코딩하는 영역(:=: 대입, =: 비교, 동등)
    v_no:=12.7;
    DBMS_Output.put_line(v_no);--출력
END;--실행은 /로 할 것
/

