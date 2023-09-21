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











