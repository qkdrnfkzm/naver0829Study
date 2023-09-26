--23.09.22--
/*
프로시져(procedure)
:프로시져는 특정 작업을 수행하는 일종의 서브 프로그램으로
데이타베이스에 저장되는 객체이다
반복되는 코드같은 경우 프로시져에 저장해두었다가 호출해서
실행만 하면 되므로 재사용성이 높다
 
형식
-- create : 새로 생성, 기존 프로시져가 있을 경우 오류 발생
-- create or replace : 새로 생성, 기존 프로시져가 있을 경우 덮어쓴다
 
create [or replace] procedure 프로시져명
   [파라미터 모드 데이타타입,....]
is
       	변수 선언
begin
            	코드;
end;
/
 
호출:   exec 프로시져명
            	exec 프로시져명(값..)

*/
-- 예제1
-- 초 간단 프로시저 생성해보기
create or replace PROCEDURE mytest
is
begin
    dbms_output.put_line('첫 프로시저 생성');
end;
/
--mytest 프로시저 호출
--exec mytest;


-- 예제2 : 숫자를 인자로 보내면 구구단 출력
create or replace procedure gugu(dan number)
is
begin
    if dan<2 or dan>9 then
        dbms_output.put_line('잘못된 숫자입니다. 2~9 사이값 요구');
    else
        dbms_output.put_line('  ** '||dan||' **');
        for a in 1..9 loop
        dbms_output.put_line(dan||' X ' || a||' = ' || dan*a);
        end loop;
    end if;
end;
/
--실행
exec gugu(11);
exec gugu(8);

--shop 데이터 추가
insert into shop values (seq_shop.nextval, '레이스블라우스',32000,'PINK');
insert into shop values (seq_shop.nextval, '청반바지',17000,'BLUE');
insert into shop values (seq_shop.nextval, '조끼',29000,'RED');
insert into shop values (seq_shop.nextval, '청바지',69000,'BLACK');
COMMIT;
--shop 테이블 s_color 타입 길이 변경
alter table shop modify s_color varchar2(30);

-- 예제3 : 상품명을 인자로 보내면 그 단어가 포함된 모든 상품들 출력하기

CREATE OR REPLACE PROCEDURE SANGPUM (sang VARCHAR2)
IS
    CURSOR s1
    IS
    SELECT * FROM shop WHERE s_name LIKE ( '%' || sang || '%' );
    V_CNT NUMBER(2);
BEGIN
    SELECT COUNT(*) INTO V_CNT FROM SHOP WHERE S_NAME LIKE ('%' || sang || '%');
    IF V_CNT>0 THEN
        dbms_output.put_line(sang || '상품 조회하기');
        dbms_output.put_line('총 '||V_CNT||'개');
        dbms_output.put_line('상품번호  상품명 가격  색상');
        dbms_output.put_line('-------------------------');
        FOR s IN s1 LOOP
            dbms_output.put_line(s.s_no || '     ' || s.s_name || '     ' || s.s_price || '     ' || s.s_color);
            EXIT WHEN s1%notfound;
        END LOOP;
    ELSE 
        dbms_output.put_line(sang || '상품이 없습니다.');
    END IF;
END;
/

EXEC SANGPUM('바지');




-- 예제 4
/*
    EXEC ADDUPDATE('레이스조끼', 'BLACK') : 해당 상품이 없으면 추가 / 해당 상품이 있으면 가격과 색상 변경
*/
create or replace procedure ADDUPDATE(SNA VARCHAR2,SP NUMBER, SC VARCHAR2)
is
    CURSOR S1
    IS
    SELECT * FROM SHOP WHERE S_NAME LIKE SNA;
    VCNT NUMBER(2);
begin
    SELECT COUNT(*) INTO VCNT FROM SHOP WHERE S_NAME LIKE SNA;
    IF VCNT=0 THEN
        INSERT INTO SHOP VALUES (SEQ_SHOP.NEXTVAL, SNA, SP, SC);
        DBMS_OUTPUT.PUT_LINE(SNA||' 상품 추가 완료');
    ELSE
        UPDATE SHOP SET S_PRICE=SP, S_COLOR=SC WHERE S_NAME=SNA;
        DBMS_OUTPUT.PUT_LINE(SNA||' 상품 수정 완료');
    END IF;
    FOR S IN S1 LOOP
        dbms_output.put_line('상품번호  상품명 가격  색상');
        dbms_output.put_line('-------------------------');
        dbms_output.put_line(s.s_no || '     ' || s.s_name || '     ' || s.s_price || '     ' || s.s_color);
        EXIT WHEN S1%NOTFOUND;
    END LOOP;
end;
/

EXEC ADDUPDATE('조끼',30000,'BLACK');
EXEC ADDUPDATE('바람막이',72000,'BLACK');


drop table person;
drop table food;
drop table student;
