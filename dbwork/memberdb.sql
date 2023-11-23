create table memberdb (
	num smallint auto_increment primary key,
    name varchar(20),
    pass varchar(20),
    photo varchar(100),
    hp varchar(30),
    email varchar(100),
    gaipday datetime
);

alter table memberdb add myid varchar(20);

select count(*) from memberdb where myid = 'angel1' and pass = '1234';

