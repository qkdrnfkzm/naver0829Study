--23-09-21 DB 정규화
--DB정규화(Normalization)
--정규화란? 한마디로 DB 서버의 메모리를 낭비하지 않기 위해서
--어떤 테이블을 식별자를 가지는 여러개의 테이블로 나누는 과정을 정규화라고 한다
--정규화된 데이터베이스는 중복이 최소화 되도록 설계된 데이터베이스이다
--장점 : 메모리를 절약할 수 있다
--      구조화된 시스템으로 인해서 관리가 편하다
--단점 : 조회비율이 매우 높은 시스템의 경우에는 테이블간의 join 연산이 반복적으로 이뤄지기 때문에 질의 응답 속도가 살짝 늦어질 수 있다
----------------------------------------------------------------------------------------------------------------------

--STUDENT 의 NUM을 외부키로 갖는 새로운 테이블 STUINFO를 만들어보자
--외부키는 테이블 생성시에 설정해도 되고 나중에 설정해도 된다
CREATE TABLE STUINFO (
    IDX NUMBER(5) CONSTRAINT STUINFO_PK_IDX PRIMARY KEY,
    NUM NUMBER(5),
    ADDR VARCHAR2(20),
    HP VARCHAR2(20));
    
--STUDENT의 NUM을 외부키로 설정 - 주의 : STUDENT의 NUM은 반드시 PRIMARY KEY이여야 한다)
ALTER TABLE STUINFO ADD CONSTRAINT STUINFO_FK_NUM FOREIGN KEY (NUM) REFERENCES STUDENT(NUM);


--STUINFO에 데이터 추가, 없는 번호인 11번으로 INSERT시 어떤 오류가 나는지 확인 필요
--오류 메세지 : 무결성 제약조건(ANGEL.STUINFO_FK_NUM)이 위배되었습니다- 부모 키가 없습니다
--STUDENT 테이블이 부모테이블 : 거기에 NUM 11이 없어서 오류
INSERT INTO STUINFO VALUES (SEQ_STU.NEXTVAL, 11, '서울시 강남구', '010-1234-1234');
--만약 노홍철의 정보일 경우 노홍철의 NUM이 3이므로 3으로 추가
INSERT INTO STUINFO VALUES (SEQ_STU.NEXTVAL, 3, '서울시 강남구', '010-1234-1234');
INSERT INTO STUINFO VALUES (SEQ_STU.NEXTVAL, 1, '서울시 서초구', '010-1234-5678');
INSERT INTO STUINFO VALUES (SEQ_STU.NEXTVAL, 7, '서울시 송파구', '010-2222-3333');
INSERT INTO STUINFO VALUES (SEQ_STU.NEXTVAL, 8, '제주도', '010-2323-1212');
INSERT INTO STUINFO VALUES (SEQ_STU.NEXTVAL, 9, '부산시', '010-7777-9999');


SELECT * FROM STUINFO;

--개인정보가 등록된 학생에 한해서 모든 정보를 출력해보자(inner join,equi join)
SELECT STU.NAME, STU.JAVA, STU.SPRING, STU.BAN, INFO.ADDR, INFO.HP 
FROM STUDENT STU, STUINFO INFO 
WHERE STU.NUM=INFO.NUM;

--컬럼명 앞에 무조건 어느테이블 소속인지 붙였는데
--양쪽에 같은 컬럼이 없다면 생략 가능
SELECT STU.NUM, NAME, JAVA, SPRING, BAN, ADDR, HP 
FROM STUDENT STU, STUINFO INFO 
WHERE STU.NUM=INFO.NUM;

--개인정보가 등록되어 있지 않은 학생들을 출력해보자 (OUTER JOIN)
--SUB TABLE 에(+) : 등록이 안된 컬럼은 NULL 값으로 출력
SELECT STU.NAME, STU.JAVA, STU.SPRING, STU.BAN, INFO.ADDR, INFO.HP 
FROM STUDENT STU, STUINFO INFO 
WHERE STU.NUM=INFO.NUM(+);

--위의 결과에 NULL인 학생만 출력
SELECT STU.NAME, STU.JAVA, STU.SPRING, STU.BAN, INFO.ADDR, INFO.HP 
FROM STUDENT STU, STUINFO INFO 
WHERE STU.NUM=INFO.NUM(+) AND INFO.ADDR IS NULL;


--SUB 테이블에 연결된 데이터가 있는데 부모테이블(STUDENT) 의 해당 데이터를 삭제하고자 하는 경우
--오류 : 무결성 제약조건(ANGEL.STUINFO_FK_NUM)이 위배되었습니다- 자식 레코드가 발견되었습니다
DELETE FROM STUDENT WHERE NUM=3;

DELETE FROM STUDENT WHERE NUM=9;

--SUTDENT의 3번 데이터를 지워보자
--자식테이블(STUNIFO 의 NUM이 3인 데이터를 먼저 삭제후 STUDENT 삭제)

DELETE FROM STUINFO WHERE NUM=3;
DELETE FROM STUDENT WHERE NUM=3;


DROP TABLE STUINFO;

-----------------------------------------------------------------------------------------------------------------------

--상품 정보를 담을 SHOP 테이블
--장바구니에 담을 CART 테이블 생성, 상품정보 저장을 위해서 SHOP의 NUM을 외부키로 설정
--상품을 삭제하면 장바구니의 해당 데이터가 자동으로 삭제되도록 ON DELETE CASCADE를 설정해보자

--시퀀스 새로 생성
CREATE SEQUENCE SEQ_SHOP START WITH 10 INCREMENT BY 10 NOCACHE;

--SHOP TABLE 생성
CREATE TABLE SHOP (
    S_NO NUMBER(5) CONSTRAINT SHOP_PK_NO PRIMARY KEY,
    S_NAME VARCHAR2(100),
    S_PRICE NUMBER(7),
    S_COLOR VARCHAR2(20));

--외부키로 연결된 CART 테이블을 생성 SHOP의 상품을 지우면 장바구니 목록은 자동으로 지워지도록 CASCADE를 설정해서 생성
CREATE TABLE CART(
    C_NO NUMBER(5) CONSTRAINT CART_PK_NO PRIMARY KEY,
    S_NO NUMBER(5),
    C_DAY DATE);
    
ALTER TABLE CART ADD CONSTRAINT CART_FK_SNO FOREIGN KEY (S_NO) REFERENCES SHOP(S_NO) ON DELETE CASCADE;

--MODEL (ERD) 확인해보세요

--5개의 상품을 등록
INSERT INTO SHOP VALUES (SEQ_SHOP.NEXTVAL, '블라우스', 23000, 'YELLOW');
INSERT INTO SHOP VALUES (SEQ_SHOP.NEXTVAL, '청바지', 58000, 'BLUE');
INSERT INTO SHOP VALUES (SEQ_SHOP.NEXTVAL, '티셔츠', 32000, 'BLACK');
INSERT INTO SHOP VALUES (SEQ_SHOP.NEXTVAL, '셔츠', 41000, 'WHITE');
INSERT INTO SHOP VALUES (SEQ_SHOP.NEXTVAL, '반바지', 19000, 'GREEN');
COMMIT;

--CART에 블라우스, 청바지, 티셔츠 3개에 대해서 추가+ 현재날짜
INSERT INTO CART VALUES(SEQ_SHOP.NEXTVAL,10,SYSDATE);
INSERT INTO CART VALUES(SEQ_SHOP.NEXTVAL,20,SYSDATE);
INSERT INTO CART VALUES(SEQ_SHOP.NEXTVAL,30,SYSDATE);

--조회(INNER JOIN)
--상품명, 가격, 색상 갯수, 구입일(YYYY-MM-DD HH-MI)
SELECT S_NAME 상품명, S_PRICE 가격, S_COLOR 색상, CNT 수량, TO_CHAR(C_DAY,'YYYY-MM-DD HH:MI') 구입일 
FROM SHOP S, CART C
WHERE S.S_NO = C.S_NO;

--아무도 카트에 담지 않은 상품명 조회
--상품명, 가격, 색상
SELECT S_NAME, S_PRICE, S_COLOR
FROM SHOP S, CART C
WHERE S.S_NO = C.S_NO(+) AND C.S_NO IS NULL;

--CASCADE를 지정했으므로 CART에 담김 상품도 삭제가 된다(이때 CART 도 자동으로 지워짐)
DELETE FROM SHOP WHERE S_NO=10;

--부모 테이블 DROP
DROP TABLE CART;
DROP TABLE SHOP;

DROP SEQUENCE SEQ_SHOP;

--------------------------------------------------------------------------------------------------------------------------
--문제
--시퀀스 : SEQ_FOOD
CREATE SEQUENCE SEQ_FOOD NOCACHE;


--레스토랑의 메뉴 테이블 : FOOD (F_NUM 숫자5 기본키, 메뉴명-FNAME 문자(20), 가격-FPRICE 숫자(7)
CREATE TABLE FOOD(
    F_NUM NUMBER(5) PRIMARY KEY,
    FNAME VARCHAR2(20),
    FPRICE NUMBER(7));

--SUB테이블 : PERSON (P_NUM 숫자5 기본키, F_NUM 외부키(CASCADE), 고객명-PNAME 문자10, 예약일-BOOKINDAY DATE타입)
CREATE TABLE PERSON(
    P_NUM NUMBER(5) PRIMARY KEY,
    F_NUM NUMBER(5),
    PNAME VARCHAR2(10),
    BOOKINDAY DATE,
    FOREIGN KEY (F_NUM) REFERENCES FOOD(F_NUM) ON DELETE CASCADE);

--FOOD에 5개의 메뉴 등록(스파게티, 떡볶이 등...)
INSERT INTO FOOD VALUES(SEQ_FOOD.NEXTVAL, '스파게티',9000);
INSERT INTO FOOD VALUES(SEQ_FOOD.NEXTVAL, '피자',11000);
INSERT INTO FOOD VALUES(SEQ_FOOD.NEXTVAL, '떡볶이',7000);
INSERT INTO FOOD VALUES(SEQ_FOOD.NEXTVAL, '돈가스',8000);
INSERT INTO FOOD VALUES(SEQ_FOOD.NEXTVAL, '치킨',18000);
SELECT * FROM FOOD;

--주문한 고객정보 추가(같은메뉴를 여러명이 주문하기도 함)
INSERT INTO PERSON VALUES (SEQ_FOOD.NEXTVAL,2,'명수','2023-9-28');
INSERT INTO PERSON VALUES (SEQ_FOOD.NEXTVAL,6,'재석','2023-9-30');
INSERT INTO PERSON VALUES (SEQ_FOOD.NEXTVAL,5,'형돈','2023-10-2');
INSERT INTO PERSON VALUES (SEQ_FOOD.NEXTVAL,3,'준하','2023-10-1');
INSERT INTO PERSON VALUES (SEQ_FOOD.NEXTVAL,6,'홍철','2023-10-15');
SELECT * FROM PERSON;

--메뉴 중 스파게티 삭제시 주문한 테이블에서도 지워지는지 확인
DELETE FROM FOOD WHERE F_NUM=2;
SELECT * FROM PERSON;

--조회 : 시퀀스(F_NUM), 주문자명, 음식명, 가격, 예약일 조회(제목도 한글)
SELECT F.F_NUM 메뉴번호, PNAME 주문자명, FNAME 메뉴명, FPRICE 가격, BOOKINDAY 예약일
FROM FOOD F, PERSON P
WHERE F.F_NUM = P.F_NUM;

