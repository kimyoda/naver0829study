create table boarddb (
	num smallint auto_increment primary key,
    writer varchar(20),
    myid varchar(20),
    subject varchar(1000),
    content varchar(2000),
    readcount smallint default 0,
	regroup smallint,
    restep smallint,
    relevel smallint,
    writeday datetime
);

create table board_file (
	idx smallint auto_increment primary key,
    num smallint,
    photoname varchar(100),
    constraint fk_board_num foreign key(num) references boarddb(num)
);

select ifnull(max(num), 0) num from boarddb;

select * from memberdb order by num desc;

select * from memberdb order by num desc limit 5, 3



