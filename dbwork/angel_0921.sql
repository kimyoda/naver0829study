--2023-09-21 DB ����ȭ
--DB ����ȭ(Normalization)
--����ȭ��? �Ѹ���� db ������ �޸𸮸� �������� �ʱ����ؼ�
--� ���̺��� �ĺ��ڸ� ������ �������� ���̺�� ������ ������ ����ȭ�� �Ѵ�
--����ȭ�� ����Ÿ���̽��� �ߺ��� �ּ�ȭ�ǵ��� ����� �����ͺ��̽��̴�
--���� : �޸𸮸� ������ �� �ִ�. ����ȭ�� �ý������� ���ؼ� ������ ���ϴ�
--���� : ��ȸ������ �ſ� ���� �ý����� ��쿡�� ���̺��� join ������ �ݺ������� �̷����� ������ ���� ���� �ӵ��� ��¦ �ʾ��� �� �ִ�.

--student�� num�� �ܺ�Ű�� ���� ���ο� ���̺� stuinfo�� ������
--�ܺ�Ű�� ���̺� �����ÿ� �����ص� �ǰ� ���߿� alter ���̺�� �����ص��ȴ�
ALTER TABLE stunifo RENAME TO stuinfo;

create table stuninfo (
    idx number(5) CONSTRAINT stuinfo_pk_idx primary key,
    num number(5),
    addr varchar2(20),
    hp varchar2(20));
    
-- student1�� num�� �ܺ�Ű�� ����(�̶� ����: student1�� num�� �ݵ�� primary key��� �Ѵ�)
--ppt 29�������� ����
alter table stuinfo add CONSTRAINT stuinfo_fk_num FOREIGN key(num) references student1(num);   

--stuinfo�� ����Ÿ�� �߰��غ���, ���¹�ȣ�� 9������ insert �� � ������ ������ Ȯ���ʿ�
--�����޼���: ���Ἲ ��������(ANGEL.STUINFO_FK_NUM)�� ����Ǿ����ϴ�- �θ� Ű�� �����ϴ�
--student ���̺��� �θ����̺�: �ű⿡ num 12�� ��� ������ ���� ��
insert into stuinfo values (seq_stu.nextval, 12, '����� ������', '010-2323-4545');
--���� �踻���� �����ϰ�� �踻���� num�� �̹Ƿ� 8���� �߰��ؾ߸� �Ѵ�, STUNIFO�� ���� ���� ��ȸ�� �� student1�� ��ȸ
insert into stuinfo values (seq_stu.nextval, 8, '����� ������', '010-2323-4545');
insert into stuinfo values (seq_stu.nextval, 7, '���ֵ�', '010-1234-1234');--����
insert into stuinfo values (seq_stu.nextval, 3, '�λ�', '010-8989-7878');--��ȿ��

--stuinfo�� ��ȸ
select * from stuinfo;

--student1�� ��ȸ
select * from student1;

--���������� ��ϵ� �л��� ���ؼ� ��� ������ ����غ���(innter join, equi join), ���� ���� student1�� stu1
select
    stu1.name, stu1.java, stu1.spring, stu1.ban, info.addr,info.hp
from student1 stu1, stuinfo info
where stu1.num = info.num;

--�÷���տ� ������ ������̺� �Ҽ����� �ٿ��µ� 
-- ���ʿ� ���� �÷��� ���ٸ� �����ص� �ȴ�
select
    name, java, spring, ban, addr, hp--��������
from student1 stu1, stuinfo info
where stu1.num = info.num;--�����Ұ���(num�� �Ѵ� ���� �ֱ� ������)


--���������� ��ϵǾ����� ���� �л����� ����غ���(outer join)
--sub table dp (+) : ����� �ȵ� �÷��� null ������ ����Ѵ�.
select
    stu1.name, stu1.java, stu1.spring, stu1.ban, info.addr,info.hp
from student1 stu1, stuinfo info
where stu1.num = info.num(+);

--���� ����� null�� �л��� ����ϰ��� �ϴ� ���
select
    stu1.name, stu1.java, stu1.spring, stu1.ban, info.addr,info.hp
from student1 stu1, stuinfo info
where stu1.num = info.num(+) and info.addr is null;

--sub ���̺� ����� ����Ÿ�� �ִµ� �θ����̺�(student1)�� �شپ� ����Ÿ�� �����ϰ��� �� ���
--�����޼���: ���Ἲ ��������(ANGEL.STUINFO_FK_NUM)�� ����Ǿ����ϴ�- �ڽ� ���ڵ尡 �߰ߵǾ����ϴ�
delete from student1 where num = 3;--����

delete from student1 where num = 1;--������, stuinfo�� ����Ÿ�� ���

--student�� 3�� ����Ÿ�� ��������
--�ڽ� ���̺�(stuinfo�� num�� 3�� ����Ÿ�� ���� ���� �� student ����)
delete from stuinfo where num = 3;-- �ڽ����̺� ���� ����
delete from student1 where num = 3;-- �θ����̺� ����

select * from student1;

--�θ� ���̺� drop
--���� �߻� : �ܷ� Ű�� ���� �����Ǵ� ����/�⺻ Ű�� ���̺� �ֽ��ϴ� 
drop table student1;

--�ڽ� ���̺��� ������ �ɱ��?
drop table stuinfo;

----------------------------------------------------------------------
-- ��ǰ������ ���� shop ���̺�
-- ��ٱ��Ͽ� ���� cart ���̺��� ����µ� ��ǰ���� ������ ���ؼ� shop�� num�� �ܺ�Ű�� ����
-- ��ǰ�� �����ϸ� ��ٱ����� �ش� ����Ÿ�� �ڵ����� �����ǵ��� on delete casacde �����غ���
-- �������� ���� �ϳ� ������
create SEQUENCE seq_shop start with 10 increment by 10 nocache;  

--shop table ����
create table shop (
    sang_no number(5) CONSTRAINT shop_pk_no primary key,
    sang_name varchar2(100),
    sang_price number(7),
    sang_color varchar2(20)
);

--�ܺ�Ű�� ����� cart ���̺��� ���� - shop�� ��ǰ�� ����� ��ٱ��� ����� �ڵ����� ����������
-- cascade�� �����ؼ� �����غ���
create table cart (
    cart_no number(5) CONSTRAINT cart_pk_no primary key,
    sang_no number(5),
    cnt number(5),
    cartday date
);

alter table cart add CONSTRAINT cart_fk_shopno FOREIGN key(sang_no) REFERENCES shop(sang_no) on delete cascade;

--model (ERD) Ȯ���غ�����

-- 5���� ��ǰ�� ����غ���
INSERT INTO shop values(seq_shop.nextval, '���콺', '23000', 'yellow');
INSERT INTO shop values(seq_shop.nextval, 'û����', '45000', 'black');
INSERT INTO shop values(seq_shop.nextval, '���̳�Ƽ', '11000', 'white');
INSERT INTO shop values(seq_shop.nextval, '���̳�Ƽ', '23000', 'red');
INSERT INTO shop values(seq_shop.nextval, 'üũ����', '130000', 'gray');
commit;

--cart�� ���콺, ���̳�Ƽ(white), üũ���� 3���� ���ؼ� �߰�-��¥�� ���糯¥(sysdate)
insert into cart values (seq_shop.nextval, 10, 2, sysdate);
insert into cart values (seq_shop.nextval, 30, 3, '2023-09-20');
insert into cart values (seq_shop.nextval, 50, 1, sysdate);
commit;

select * from cart;
--��ȸ(innner join)

--��ǰ��,����,����,����,������(yyyy-mm-dd hh24:mi)
select sang_name, sang_price, sang_color, cnt, to_char(cartday,'yyyy-mm-dd hh24:mi') cartday
from shop s, cart c
where s.sang_no=c.sang_no;
--�ƹ��� cart�� ���� ���� ��ǰ�� ��ȸ
--��ǰ��, ����, ����
select sang_name, sang_price, sang_color
from shop s, cart c
where s.sang_no=c.sang_no(+) and c.cnt is null;

--cascade�� ���������Ƿ� cart�� ��� ��ǰ�� ������ �ȴ�(�̶� cart�� �ڵ����� ������)
delete from shop where sang_no = 10;

--�θ� ���̺� drop ���Ѻ���
drop table shop; --��������, ���� ���� -ORA-02449: �ܷ� Ű�� ���� �����Ǵ� ����/�⺻ Ű�� ���̺� �ֽ��ϴ�

--���̺� ������ sub ���̺� ���� ���� �� �θ� ���̺� ����
drop table cart;
drop table shop;

--�������� ��������
drop SEQUENCE seq_shop; 


-----------------------------
--����
-- ������:seq_food ����
create SEQUENCE seq_food;
-- ��������� �޴� ���̺�(���̺��: food)
-- food_num ���� (5) �⺻Ű, fname ���ڿ�(20): �޴���, fprice ����(7) : ����
Alter table food drop CONSTRAINT shop_pk_no;  
create table food (
    food_num number(5) CONSTRAINT food_pk_no primary key,
    fname varchar2(20),
    fprice varchar(7)
);
DROP TABLE food;
-- ��������� �޴� ���̺�(���̺��: food)
-- food_num ���� (5) �⺻Ű, fname ���ڿ�(20): �޴���, fprice ����(7) : ����
create table food (
    food_num number(5) CONSTRAINT food_pk_no primary key,
    fname varchar2(20),
    fprice varchar2(7)
);

-- sub ���̺���: �� ���̺�(person)
-- person_num ����(5) �⺻Ű, food_num �ܺ�Ű ����(cascade ����)
-- person_name ���ڿ�(10) : ����
DROP TABLE person;
create table person (
    person_num number(5) CONSTRAINT person_pk_no primary key,
    food_num number(5),
    person_name varchar2(10),
    bookingday date
);
-- ������: bookingday: date Ÿ��
alter table person add CONSTRAINT person_fk_foodnum FOREIGN key(food_num) REFERENCES food(food_num) on delete cascade;

--food�� 5���� �޴��� �������(���İ�Ƽ, ������, ���, ���Ƕ��̽�, ��� ����..)
INSERT INTO food values(seq_food.nextval, '���İ�Ƽ', '12000');
INSERT INTO food values(seq_food.nextval, '������', '8000');
INSERT INTO food values(seq_food.nextval, '���', '9000');
INSERT INTO food values(seq_food.nextval, '���Ƕ��̽�', '6000');
INSERT INTO food values(seq_food.nextval, '���', '5000');
commit;

--�ֹ��� �������� �߰��غ���(���� �޴��� ������ �ֹ��ϱ⵵ ��..)
insert into person values (seq_food.nextval, 1, '�̻��', sysdate);
insert into person values (seq_food.nextval, 3, '��ȣ��', sysdate);
insert into person values (seq_food.nextval, 4, '���缮', sysdate);
insert into person values (seq_food.nextval, 2, '���翵', sysdate);
insert into person values (seq_food.nextval, 5, '��Ż��', sysdate);
commit;
-- �޴� �� ���İ�Ƽ�� ���� �� �ֹ��� ���̺����� �������� �� Ȯ��
delete from food where food_num = 1;
select * from food;
-- ��ȸ : ������, �ֹ��ڸ� , ���ĸ�, ����, ������(���� �ѱ۷�)
select
 f.food_num �޴���ȣ, person_name �ֹ��ڸ�, fname �޴���, fprice ����, 
 to_char(bookingday,'yyyy-mm-dd') ������ from food f, person p where f.food_num = p.food_num;




