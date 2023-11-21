create table memodb (
  num smallint auto_increment primary key,
  nickname varchar(30),
  photo varchar(100),
  memo varchar(1000),
  likes smallint default 0,
  writeday datetime
)