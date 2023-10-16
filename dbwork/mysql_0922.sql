#테이블 조회
show tables;	-- 전체 테이블 조회
select * from member;	-- test01 테이블 조회
desc test01;	-- 테이블 구조 확인

-- insert
insert into test01(name,age) values ('kim',40);
-- num(auto_increment)에  null 값을 줄 경우 null 값이 아닌 auto_increment로 인해 숫자가 자동으로 들어간다
insert into test01 values(null,'son',32,185.7,now(),'2020-03-03');

-- 테이블 구조 변경(add, drop column, modify, rename column)
alter table test01 add hp varchar(20) default '010-1111-1111';	-- 컬럼 추가
alter table test01 drop column age;	-- age 컬럼 제거
alter table test01 rename column birthday to birth;	-- 컬럼명 수정

alter table test01 rename member;	-- 테이블 명 변경

-- 사원 테이블 생성 + 제약조건 추가
CREATE TABLE sawon (
    num SMALLINT AUTO_INCREMENT,
    name VARCHAR(20),
    score SMALLINT,
    gender VARCHAR(10),
    buseo VARCHAR(10),
    CONSTRAINT pk_sawon_num PRIMARY KEY (num),
    CONSTRAINT ck_sawon_score CHECK (score BETWEEN 0 AND 100),
    CONSTRAINT ck_sawon_gender CHECK (gender IN ('여자' , '남자'))
);

desc sawon;

-- sawon  의 제약조건들 확인하기
select * from information_schema.table_constraints where table_name='sawon';
        
-- 데이터 추가
insert into sawon values(null, '이하나',89,'여자','홍보부');
-- 제약 조건 오류 확인
-- Error Code: 3819. Check constraint 'ck_sawon_score' is violated.
insert into sawon values(null, '이두나',829,'여자','홍보부');
-- Error Code: 3819. Check constraint 'ck_sawon_gender' is violated.
insert into sawon values(null, '이두나',829,'여','홍보부');

-- 정상적인 데이터 7개 추가
insert into sawon values(null, '유재석',98,'남자','개발부');
insert into sawon values(null, '이효리',79,'여자','인사부');
insert into sawon values(null, '박명수',67,'남자','교육부');
insert into sawon values(null, '이지은',92,'여자','홍보부');
insert into sawon values(null, '이서진',82,'남자','홍보부');
insert into sawon values(null, '송지효',59,'여자','인사부');
insert into sawon values(null, '김종국',89,'남자','개발부');


-- select limit
select * from sawon order by name;
select * from sawon order by name limit 0,3;		-- 0(첫글), 3(갯수) : 0부터 3개
select * from sawon order by name limit 3,3;		-- 3번 인덱스(4번째)부터 3개


-- 문자 함수 연습
select concat('Hello','Kitty','!!') from dual;
-- sawon의 name에서'이'를 포함한 데이터 조회
select * from sawon where name like '%이%';
select replace('Happy Day!!', 'Happy', 'Nice') from dual;	-- happy를 nice로 출력
select instr('Happy Day','Day') from dual;	-- =>7	//Day의 위치찾기(1부터)
select instr('Happy Day','Hello') from dual;	-- =>0	//없을 경우 0

-- 추출
select left('Have a Nice Day',4) from dual;		-- 왼쪽에서 4글자 => Have
select right('Have a Nice Day',8) from dual;	-- 오른쪾에서 8글자 => Nice Day
select mid('Have a Nice Day',6,6) from dual;	-- 6번째부터 6글자 => a Nice
select substring('Have a Nice Day',6,6) from dual;	-- 6번째부터 6글자 => a Nice


-- 공백제거
select ltrim('                 Hello                ') from dual;	-- 왼쪽 공백 제거
select rtrim('                 Hello                ') from dual;	-- 오른쪽 공백 제거
select trim('                 Hello                ') from dual;	-- 공백 제거

-- 대소문자 전환
select lcase('Happy') from dual;	-- 소문자로 전환
select lower('Happy') from dual;	-- 소문자로 전환
select ucase('Happy') from dual;	-- 대문자로 전환
select upper('Happy') from dual;	-- 대문자로 전환
select reverse('Happy') from dual;	-- 문자 순서 거꾸로 출력 => yppaH

-- 조건 함수
select if(1=2, 'happy','nice')from dual;
select name, score, if(score>=90,'합격','불합격') 평가 from sawon;
select studentRANK() OVER (ORDER BY score desc) "rank", name, score, if(score >= 90,'합격','불합격') "평가" from sawon;	-- 순위 구하기

-- 오라클의 NVL 이 mysql 에서는 ifnull
select name, height from member;
select name, ifnull(height,0) from member;

-- 수학 함수
select ceiling(5.3), ceiling(5.9) from dual;	-- 올림 => 6
select floor(5.3), floor(5.9) from dual;	-- 내림 => 5
select truncate(2.348,2) from dual; -- 소숫점 2자리 나머지는 무조건 내림 =>2.34
select mod(7,2) from dual;	-- 나머지 => 1

-- Group by
select rank() over (order by avg(score) desc) "순위", buseo, count(*), max(score), min(score), avg(score) from sawon group by buseo;

-- join 예제
create table bitclass (
   idx smallint primary key,
   class varchar(30),
   price int,
   gigan smallint);

create table stu (
   num smallint auto_increment primary key,
   name varchar(20),
   idx smallint,
   sugangday date,
   constraint stu_fk_idx foreign key(idx) references bitclass(idx));

-- bitclass 에 데이타 추가
insert into bitclass values (100,'Java',110000,10);
insert into bitclass values (200,'HTML5',90000,8);
insert into bitclass values (300,'jQuery',130000,12);
insert into bitclass values (400,'Oracle',180000,20);

-- stu 에 데이타 추가
insert into stu (name,idx,sugangday) values ('kim',200,now());
insert into stu (name,idx,sugangday) values ('lee',100,now());
insert into stu (name,idx,sugangday) values ('son',300,now());
insert into stu (name,idx,sugangday) values ('min',400,now());

select * from bitclass;
select * from stu;

-- inner join 1
select class, price, gigan, name, sugangday
from bitclass b, stu s
where b.idx=s.idx;

-- inner join 2
select name, class, gigan, price, sugangday
from bitclass b
inner join stu on b.idx=stu.idx;

select * from bitclass b inner join stu s on b.idx=s.idx;

-- 서브 테이블의 데이터가 추가된 상태에서 부모테이블의 테이터를 삭제해보자
delete from bitclass where idx=100;		-- 오류 발생
-- 서브 테이블의 데이터를 먼저 삭제 후 부모 테이블의 데이터 삭제
delete from stu where idx=100;

-- 연습용 join 테이블 모두 제거하기
drop table stu;
drop table bitclass;
drop table member;sawonsawon

