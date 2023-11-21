create table photodb (
	num smallint auto_increment primary key,
    title varchar(30),
    photo varchar(200),
    photo80 varchar(200),
    photo150 varchar(200),
    writeday datetime
);