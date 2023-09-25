--PL-SQL�̶�?
-- SQL �� ������ ����Ҹ� �߰��ؼ� ���α׷��� �Ѱ��� PL-SQL �̶�� �Ѵ�.
-- ���� 1
DECLARE
    -- ���� �����ϴ� ���� 
    v_no NUMBER(4, 1); --4�ڸ��� �Ҽ������� 1�ڸ� ���� �ִ� ���� ����

BEGIN 
    --sql�����̳� pl-sql ������ �ڵ��ϴ� ����(:=: ����, =: ��, ����)
    v_no := 12.7;
    dbms_output.put_line(v_no);--���
END;
/

--���� 2 
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
                         || '���� '
                         || vban
                         || '�Դϴ�');--���

END;
/
--����3 person��  food ���̺��� �����Ͽ� person_num�� 27�� ����� �̸�, �ֹ��� �޴�, ������ ����Ͻÿ�
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

    dbms_output.put_line('�ֹ���:' || vname);--���
    dbms_output.put_line('�޴�:' || vfood);--���
    dbms_output.put_line('����:' || vprice);--���

END;
/

--����4
-- ��ǰ���� ������ ������ �� �ش� ��ǰ���� ���ݰ� ������ ���
DECLARE
    vsangpum VARCHAR2(20) := 'û����';
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

    dbms_output.put_line('��ǰ��:' || vsangpum);--���
    dbms_output.put_line('��  ��:' || vcolor);--���
    dbms_output.put_line('��  ��:' || vprice);--���
    dbms_output.put_line('��  ��:' || vprice2);--���

END;
/

/*
if ���ǽ� then
   ����1;
else 
    ����2;
end if;

���� if��(�߿� e����)
if ���ǽ�1 then
    ����1;
elsif ����2 then
    ����2;
    ...
end if;    

*/

--����5
--�⵵�� �´� �챸�ϱ�

--Ű����� �⵵�� �Է¹ް��� �� ���
accpet year prompt '�¾ �⵵�� �Է��ϼ���';
DECLARE
    --v_year number(4) := 1989;
    v_year number(4) := '&year'; --�Է��� ���� ����
    v_mod number(2) := mod(v_year,12); --�⵵�� 12�� ���� �������� ���Ѵ�
    v_ddi varchar2(10); --�� ������ ����
BEGIN 
    if v_mod=0 then v_ddi:='������';
    elsif v_mod=1 then v_ddi:='��';
    elsif v_mod=2 then v_ddi:='��';
    elsif v_mod=3 then v_ddi:='����';
    elsif v_mod=4 then v_ddi:='��';
    elsif v_mod=5 then v_ddi:='��';
    elsif v_mod=6 then v_ddi:='ȣ����';
    elsif v_mod=7 then v_ddi:='�䳢';
    elsif v_mod=8 then v_ddi:='��';
    elsif v_mod=9 then v_ddi:='��';
    elsif v_mod=10 then v_ddi:='��';
    elsif v_mod=11 then v_ddi:='��';
    end if;            
    DBMS_Output.put_line(v_year||'�����'||v_ddi||'���Դϴ�');--���
END;
/

--����6
--db Į���� Ÿ���� �������� ��� TYPE, �ι� �����������
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

dbms_output.put_line('�л���: ' || v_name);--���
dbms_output.put_line('Ű:' || v_height);--���
dbms_output.put_line('�ڹ�����:' || v_java);--���
dbms_output.put_line('����������:' || v_spring);--���
dbms_output.put_line('����:' ||(v_java + v_spring));--���
end;
/

/*
    �ݺ��� : loop
    lopp
        �����;
        exit when ����;
    end loop;    

*/
--1���� 10���� �ݺ��ؼ� ���
s_output.put_line('�л���: ' || v_name);--���
dbms_output.put_line('Ű:' || v_height);--���
dbms_output.put_line('�ڹ�����:' || v_java);--���
dbms_output.put_line('����������:' || v_spring);--���
dbms_output.put_line('����:' ||(v_java + v_spring));--���
end;
/

/*
    �ݺ��� : loop
    lopp
        �����;
        exit when ����;
    end loop;    

*/
--1���� 10���� �ݺ��ؼ� ���
--����: ���� �Է��ϸ� �ش���� ����Ͻÿ�
accept dan prompt 'dan?';
DECLARE
    v_dan number(2) := '&dan'; --dan�� ���Ѵ�
    v_idx number(1) := 1;
BEGIN 
    DBMS_Output.put_line('**'||v_dan||' �� **');--���
loop
    DBMS_Output.put_line(v_dan ||'X'||v_idx||'='||v_dan*v_idx);--���
    v_idx := v_idx+1;
    exit when v_idx=10;
    end loop;  
END;
/
--��ǰ���� ������ ������ �� �ش� ��ǰ���� ���ݰ� ������ ���
--���� 9 - Exception ó��(���� 4 ����)
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

    dbms_output.put_line('��ǰ��:' || vsangpum);--���
    dbms_output.put_line('��  ��:' || vcolor);--���
    dbms_output.put_line('��  ��:' || vprice);--���
    dbms_output.put_line('��  ��:' || vprice2);--���
    
    --����� 2�� �̻��̰ų� ������ �����߻�
    --����Ŭ���� ����ó�� �ϴ� ���
    EXCEPTION
    when NO_DATA_FOUND then
        dbms_output.put_line(vsangpum || '��ǰ�� DB�� �����ϴ�');
    when TOO_MANY_ROWS then
        dbms_output.put_line(vsangpum || '��ǰ�� DB�� �ΰ��̻� �����մϴ�');
    when others then
        dbms_output.put_line(vsangpum || '��ǰ�� ���� ���� �߻�-������');
END;
/

/*
    �ݺ���
    for ���� in [reverse] ���۰�... ������ loop
        �����;
    end loop;    


*/
--����10, ����8 ������ ������ for������ �����ϱ�
accept dan prompt 'dan?';
DECLARE
    v_dan number(2) := '&dan';
    v_idx number(1);
BEGIN 
    DBMS_Output.put_line('** '||v_dan||' �� **');--���
    for v_idx in 1..9 loop
        DBMS_Output.put_line(v_dan ||'X'||v_idx||'='||v_dan*v_idx);--��
    end loop;   
END;
/


--���ڵ� ������ ����Ÿ ��������
DECLARE
    V_num student1.num%TYPE :=7;
    V_stu1 angel.student%rowtype; --���ڵ������ �о�� ���
BEGIN 
    select * into v_stu1 
    from student1 where num=v_num;
    
    DBMS_Output.put_line('�̸�:'||v_stu1.name);
    DBMS_Output.put_line('Ű:'||v_stu1.height);
    DBMS_Output.put_line('�ڹ�:'||v_stu1.java);
    DBMS_Output.put_line('������:'||v_stu1.spring);
    DBMS_Output.put_line('��:'||v_stu1.ban);

END;
/

-- db �� ��������Ÿ�� ��ȸ�� ���
/*
    Cursor : sql ���� ������ ������ ����� �м��ǰ� ����Ǿ� ����� �����ϱ�����
    Ư���� �޸� ������ ����ϴµ� �̿����� �����ϴ� ���� Ŀ���̴�.
    
    select ������ ���� ����Ÿ ��ȸ�� ����ϴ� ��ü�̴� 
    
    Ŀ�� �Ӽ�
    sql%rowcount : ����� ������ ��ȯ
    sql%found : ���� �ֱ��� sql���� �ϳ� �̻��� �࿡ ������ �� ��� true ���� ��ȯ
    sql%notfound : ������� ���°��
    sql%isopen : �׻� false(�׻� close�� �ϱ� ������ �׻� false)
*/

--���� 12
DECLARE
    v_sno number(3) :=20;
    v_shop angel.shop%rowtype;
    
BEGIN
    select * into v_shop
    from shop where sang_no=v_sno;
    
    DBMS_Output.put_line('��ǳ��:'||v_shop.sang_name);--���
    DBMS_Output.put_line('��ȸ�� ���హ��:'||sql%rowcount);--1

    
    --student�� java���� �����ϱ�
    update student set java = 99;
    DBMS_Output.put_line('������ ���హ��:'||sql%rowcount);--1
END;
/

--���� ���ڵ� ��ȸ
--���� 13
DECLARE
    Cursor S1
    is
    select * from shop;
BEGIN 
    DBMS_Output.put_line('��ǰ��ȣ     ��ǰ��    ����     ����');--���
    DBMS_Output.put_line('---------------------------------');--���
    for s in s1 loop
        exit when s1%notfound;-- ���̻� �����Ͱ� ������ ����������
        DBMS_Output.put_line(s.sang_no || '   ' || s.sang_name || '   ' || s.sang_color || '    ' || s.sang_price);--���
    end loop;
END;
/

--���� 14
--��ǰ��, ����, ������ �Է��ϸ� shop db�� �߰��ϱ�
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
    DBMS_Output.put_line('��ǰ������ �߰��߽��ϴ�');--���
END;
/


--���� : food ���̺�
/*
 
    fname, fprice, no �Է��� �޾Ƽ� 
    no�� 1�̸� fname, fprice�� ������ �߰��� �ϰ� 
    no�� 2�� ��ü food ��ü ����Ÿ ���

*/

/*
--�Է°� ���� ��..
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
    DBMS_Output.put_line('��ǰ������ �߰��߽��ϴ�');--���
    elsif v_no =2 then 
    DBMS_Output.put_line('��ǰ��ȣ     ���ĸ�      ����          ');--���
    DBMS_Output.put_line('---------------------------------');--���
    FOR s IN S1 LOOP
            DBMS_OUTPUT.PUT_LINE(s.food_num || '     ' || s.fname || '      ' || s.fprice); -- ������ ���
    exit when s1%notfound;
    END LOOP;
    end if;            
END;
/
*/

--����� Ǯ��
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
        DBMS_output.put_line('�޴��� �߰��߽��ϴ�');
    else
        DBMS_output.put_line('�޴���ȣ    �޴���    ����');
        DBMS_output.put_line('------------------------');
    for s in s1 loop       
        DBMS_output.put_line(s.food_num||'    ' || s.fname||'    '||s.fprice);
    exit when s1%notfound;
   end loop;
  end if;
 end;
/







