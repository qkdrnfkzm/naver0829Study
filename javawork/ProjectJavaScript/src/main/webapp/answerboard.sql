create table simpleboard(
num smallint auto_increment primary key,
writer varchar(20),
subject varchar(1000),
content varchar(1000),
photo varchar(30),
readcount smallint default 0,
writeday datetimeanswersboard
);

-- 댓글 DB
create table answersboard (
idx smallint auto_increment primary key,
num smallint,
nickname varchar(20),
content varchar(1000),
writeday datetime,
constraint answer_fk_num foreign key(num) references simpleboard(num) on delete cascade
);