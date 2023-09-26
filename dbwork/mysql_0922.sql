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


