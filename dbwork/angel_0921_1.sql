--23-09-21 DB ����ȭ
--DB����ȭ(Normalization)
--����ȭ��? �Ѹ���� DB ������ �޸𸮸� �������� �ʱ� ���ؼ�
--� ���̺��� �ĺ��ڸ� ������ �������� ���̺�� ������ ������ ����ȭ��� �Ѵ�
--����ȭ�� �����ͺ��̽��� �ߺ��� �ּ�ȭ �ǵ��� ����� �����ͺ��̽��̴�
--���� : �޸𸮸� ������ �� �ִ�
--      ����ȭ�� �ý������� ���ؼ� ������ ���ϴ�
--���� : ��ȸ������ �ſ� ���� �ý����� ��쿡�� ���̺��� join ������ �ݺ������� �̷����� ������ ���� ���� �ӵ��� ��¦ �ʾ��� �� �ִ�
----------------------------------------------------------------------------------------------------------------------

--STUDENT �� NUM�� �ܺ�Ű�� ���� ���ο� ���̺� STUINFO�� ������
--�ܺ�Ű�� ���̺� �����ÿ� �����ص� �ǰ� ���߿� �����ص� �ȴ�
CREATE TABLE STUINFO (
    IDX NUMBER(5) CONSTRAINT STUINFO_PK_IDX PRIMARY KEY,
    NUM NUMBER(5),
    ADDR VARCHAR2(20),
    HP VARCHAR2(20));
    
--STUDENT�� NUM�� �ܺ�Ű�� ���� - ���� : STUDENT�� NUM�� �ݵ�� PRIMARY KEY�̿��� �Ѵ�)
ALTER TABLE STUINFO ADD CONSTRAINT STUINFO_FK_NUM FOREIGN KEY (NUM) REFERENCES STUDENT(NUM);


--STUINFO�� ������ �߰�, ���� ��ȣ�� 11������ INSERT�� � ������ ������ Ȯ�� �ʿ�
--���� �޼��� : ���Ἲ ��������(ANGEL.STUINFO_FK_NUM)�� ����Ǿ����ϴ�- �θ� Ű�� �����ϴ�
--STUDENT ���̺��� �θ����̺� : �ű⿡ NUM 11�� ��� ����
INSERT INTO STUINFO VALUES (SEQ_STU.NEXTVAL, 11, '����� ������', '010-1234-1234');
--���� ��ȫö�� ������ ��� ��ȫö�� NUM�� 3�̹Ƿ� 3���� �߰�
INSERT INTO STUINFO VALUES (SEQ_STU.NEXTVAL, 3, '����� ������', '010-1234-1234');
INSERT INTO STUINFO VALUES (SEQ_STU.NEXTVAL, 1, '����� ���ʱ�', '010-1234-5678');
INSERT INTO STUINFO VALUES (SEQ_STU.NEXTVAL, 7, '����� ���ı�', '010-2222-3333');
INSERT INTO STUINFO VALUES (SEQ_STU.NEXTVAL, 8, '���ֵ�', '010-2323-1212');
INSERT INTO STUINFO VALUES (SEQ_STU.NEXTVAL, 9, '�λ��', '010-7777-9999');


SELECT * FROM STUINFO;

--���������� ��ϵ� �л��� ���ؼ� ��� ������ ����غ���(inner join,equi join)
SELECT STU.NAME, STU.JAVA, STU.SPRING, STU.BAN, INFO.ADDR, INFO.HP 
FROM STUDENT STU, STUINFO INFO 
WHERE STU.NUM=INFO.NUM;

--�÷��� �տ� ������ ������̺� �Ҽ����� �ٿ��µ�
--���ʿ� ���� �÷��� ���ٸ� ���� ����
SELECT STU.NUM, NAME, JAVA, SPRING, BAN, ADDR, HP 
FROM STUDENT STU, STUINFO INFO 
WHERE STU.NUM=INFO.NUM;

--���������� ��ϵǾ� ���� ���� �л����� ����غ��� (OUTER JOIN)
--SUB TABLE ��(+) : ����� �ȵ� �÷��� NULL ������ ���
SELECT STU.NAME, STU.JAVA, STU.SPRING, STU.BAN, INFO.ADDR, INFO.HP 
FROM STUDENT STU, STUINFO INFO 
WHERE STU.NUM=INFO.NUM(+);

--���� ����� NULL�� �л��� ���
SELECT STU.NAME, STU.JAVA, STU.SPRING, STU.BAN, INFO.ADDR, INFO.HP 
FROM STUDENT STU, STUINFO INFO 
WHERE STU.NUM=INFO.NUM(+) AND INFO.ADDR IS NULL;


--SUB ���̺� ����� �����Ͱ� �ִµ� �θ����̺�(STUDENT) �� �ش� �����͸� �����ϰ��� �ϴ� ���
--���� : ���Ἲ ��������(ANGEL.STUINFO_FK_NUM)�� ����Ǿ����ϴ�- �ڽ� ���ڵ尡 �߰ߵǾ����ϴ�
DELETE FROM STUDENT WHERE NUM=3;

DELETE FROM STUDENT WHERE NUM=9;

--SUTDENT�� 3�� �����͸� ��������
--�ڽ����̺�(STUNIFO �� NUM�� 3�� �����͸� ���� ������ STUDENT ����)

DELETE FROM STUINFO WHERE NUM=3;
DELETE FROM STUDENT WHERE NUM=3;


DROP TABLE STUINFO;

-----------------------------------------------------------------------------------------------------------------------

--��ǰ ������ ���� SHOP ���̺�
--��ٱ��Ͽ� ���� CART ���̺� ����, ��ǰ���� ������ ���ؼ� SHOP�� NUM�� �ܺ�Ű�� ����
--��ǰ�� �����ϸ� ��ٱ����� �ش� �����Ͱ� �ڵ����� �����ǵ��� ON DELETE CASCADE�� �����غ���

--������ ���� ����
CREATE SEQUENCE SEQ_SHOP START WITH 10 INCREMENT BY 10 NOCACHE;

--SHOP TABLE ����
CREATE TABLE SHOP (
    S_NO NUMBER(5) CONSTRAINT SHOP_PK_NO PRIMARY KEY,
    S_NAME VARCHAR2(100),
    S_PRICE NUMBER(7),
    S_COLOR VARCHAR2(20));

--�ܺ�Ű�� ����� CART ���̺��� ���� SHOP�� ��ǰ�� ����� ��ٱ��� ����� �ڵ����� ���������� CASCADE�� �����ؼ� ����
CREATE TABLE CART(
    C_NO NUMBER(5) CONSTRAINT CART_PK_NO PRIMARY KEY,
    S_NO NUMBER(5),
    C_DAY DATE);
    
ALTER TABLE CART ADD CONSTRAINT CART_FK_SNO FOREIGN KEY (S_NO) REFERENCES SHOP(S_NO) ON DELETE CASCADE;

--MODEL (ERD) Ȯ���غ�����

--5���� ��ǰ�� ���
INSERT INTO SHOP VALUES (SEQ_SHOP.NEXTVAL, '���콺', 23000, 'YELLOW');
INSERT INTO SHOP VALUES (SEQ_SHOP.NEXTVAL, 'û����', 58000, 'BLUE');
INSERT INTO SHOP VALUES (SEQ_SHOP.NEXTVAL, 'Ƽ����', 32000, 'BLACK');
INSERT INTO SHOP VALUES (SEQ_SHOP.NEXTVAL, '����', 41000, 'WHITE');
INSERT INTO SHOP VALUES (SEQ_SHOP.NEXTVAL, '�ݹ���', 19000, 'GREEN');
COMMIT;

--CART�� ���콺, û����, Ƽ���� 3���� ���ؼ� �߰�+ ���糯¥
INSERT INTO CART VALUES(SEQ_SHOP.NEXTVAL,10,SYSDATE);
INSERT INTO CART VALUES(SEQ_SHOP.NEXTVAL,20,SYSDATE);
INSERT INTO CART VALUES(SEQ_SHOP.NEXTVAL,30,SYSDATE);

--��ȸ(INNER JOIN)
--��ǰ��, ����, ���� ����, ������(YYYY-MM-DD HH-MI)
SELECT S_NAME ��ǰ��, S_PRICE ����, S_COLOR ����, CNT ����, TO_CHAR(C_DAY,'YYYY-MM-DD HH:MI') ������ 
FROM SHOP S, CART C
WHERE S.S_NO = C.S_NO;

--�ƹ��� īƮ�� ���� ���� ��ǰ�� ��ȸ
--��ǰ��, ����, ����
SELECT S_NAME, S_PRICE, S_COLOR
FROM SHOP S, CART C
WHERE S.S_NO = C.S_NO(+) AND C.S_NO IS NULL;

--CASCADE�� ���������Ƿ� CART�� ��� ��ǰ�� ������ �ȴ�(�̶� CART �� �ڵ����� ������)
DELETE FROM SHOP WHERE S_NO=10;

--�θ� ���̺� DROP
DROP TABLE CART;
DROP TABLE SHOP;

DROP SEQUENCE SEQ_SHOP;

--------------------------------------------------------------------------------------------------------------------------
--����
--������ : SEQ_FOOD
CREATE SEQUENCE SEQ_FOOD NOCACHE;


--��������� �޴� ���̺� : FOOD (F_NUM ����5 �⺻Ű, �޴���-FNAME ����(20), ����-FPRICE ����(7)
CREATE TABLE FOOD(
    F_NUM NUMBER(5) PRIMARY KEY,
    FNAME VARCHAR2(20),
    FPRICE NUMBER(7));

--SUB���̺� : PERSON (P_NUM ����5 �⺻Ű, F_NUM �ܺ�Ű(CASCADE), ����-PNAME ����10, ������-BOOKINDAY DATEŸ��)
CREATE TABLE PERSON(
    P_NUM NUMBER(5) PRIMARY KEY,
    F_NUM NUMBER(5),
    PNAME VARCHAR2(10),
    BOOKINDAY DATE,
    FOREIGN KEY (F_NUM) REFERENCES FOOD(F_NUM) ON DELETE CASCADE);

--FOOD�� 5���� �޴� ���(���İ�Ƽ, ������ ��...)
INSERT INTO FOOD VALUES(SEQ_FOOD.NEXTVAL, '���İ�Ƽ',9000);
INSERT INTO FOOD VALUES(SEQ_FOOD.NEXTVAL, '����',11000);
INSERT INTO FOOD VALUES(SEQ_FOOD.NEXTVAL, '������',7000);
INSERT INTO FOOD VALUES(SEQ_FOOD.NEXTVAL, '������',8000);
INSERT INTO FOOD VALUES(SEQ_FOOD.NEXTVAL, 'ġŲ',18000);
SELECT * FROM FOOD;

--�ֹ��� ������ �߰�(�����޴��� �������� �ֹ��ϱ⵵ ��)
INSERT INTO PERSON VALUES (SEQ_FOOD.NEXTVAL,2,'���','2023-9-28');
INSERT INTO PERSON VALUES (SEQ_FOOD.NEXTVAL,6,'�缮','2023-9-30');
INSERT INTO PERSON VALUES (SEQ_FOOD.NEXTVAL,5,'����','2023-10-2');
INSERT INTO PERSON VALUES (SEQ_FOOD.NEXTVAL,3,'����','2023-10-1');
INSERT INTO PERSON VALUES (SEQ_FOOD.NEXTVAL,6,'ȫö','2023-10-15');
SELECT * FROM PERSON;

--�޴� �� ���İ�Ƽ ������ �ֹ��� ���̺����� ���������� Ȯ��
DELETE FROM FOOD WHERE F_NUM=2;
SELECT * FROM PERSON;

--��ȸ : ������(F_NUM), �ֹ��ڸ�, ���ĸ�, ����, ������ ��ȸ(���� �ѱ�)
SELECT F.F_NUM �޴���ȣ, PNAME �ֹ��ڸ�, FNAME �޴���, FPRICE ����, BOOKINDAY ������
FROM FOOD F, PERSON P
WHERE F.F_NUM = P.F_NUM;

