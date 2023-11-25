drop table board_file;

create table board_file (
	idx smallint auto_increment primary key,
    num smallint,
    photoname varchar(100),
    constraint fk_board_num foreign key(num) references boarddb(num) on delete cascade    
);
