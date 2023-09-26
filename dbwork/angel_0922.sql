--23.09.22--
/*
���ν���(procedure)
:���ν����� Ư�� �۾��� �����ϴ� ������ ���� ���α׷�����
����Ÿ���̽��� ����Ǵ� ��ü�̴�
�ݺ��Ǵ� �ڵ尰�� ��� ���ν����� �����صξ��ٰ� ȣ���ؼ�
���ุ �ϸ� �ǹǷ� ���뼺�� ����
 
����
-- create : ���� ����, ���� ���ν����� ���� ��� ���� �߻�
-- create or replace : ���� ����, ���� ���ν����� ���� ��� �����
 
create [or replace] procedure ���ν�����
   [�Ķ���� ��� ����ŸŸ��,....]
is
       	���� ����
begin
            	�ڵ�;
end;
/
 
ȣ��:   exec ���ν�����
            	exec ���ν�����(��..)

*/
-- ����1
-- �� ���� ���ν��� �����غ���
create or replace PROCEDURE mytest
is
begin
    dbms_output.put_line('ù ���ν��� ����');
end;
/
--mytest ���ν��� ȣ��
--exec mytest;


-- ����2 : ���ڸ� ���ڷ� ������ ������ ���
create or replace procedure gugu(dan number)
is
begin
    if dan<2 or dan>9 then
        dbms_output.put_line('�߸��� �����Դϴ�. 2~9 ���̰� �䱸');
    else
        dbms_output.put_line('  ** '||dan||' **');
        for a in 1..9 loop
        dbms_output.put_line(dan||' X ' || a||' = ' || dan*a);
        end loop;
    end if;
end;
/
--����
exec gugu(11);
exec gugu(8);

--shop ������ �߰�
insert into shop values (seq_shop.nextval, '���̽����콺',32000,'PINK');
insert into shop values (seq_shop.nextval, 'û�ݹ���',17000,'BLUE');
insert into shop values (seq_shop.nextval, '����',29000,'RED');
insert into shop values (seq_shop.nextval, 'û����',69000,'BLACK');
COMMIT;
--shop ���̺� s_color Ÿ�� ���� ����
alter table shop modify s_color varchar2(30);

-- ����3 : ��ǰ���� ���ڷ� ������ �� �ܾ ���Ե� ��� ��ǰ�� ����ϱ�

CREATE OR REPLACE PROCEDURE SANGPUM (sang VARCHAR2)
IS
    CURSOR s1
    IS
    SELECT * FROM shop WHERE s_name LIKE ( '%' || sang || '%' );
    V_CNT NUMBER(2);
BEGIN
    SELECT COUNT(*) INTO V_CNT FROM SHOP WHERE S_NAME LIKE ('%' || sang || '%');
    IF V_CNT>0 THEN
        dbms_output.put_line(sang || '��ǰ ��ȸ�ϱ�');
        dbms_output.put_line('�� '||V_CNT||'��');
        dbms_output.put_line('��ǰ��ȣ  ��ǰ�� ����  ����');
        dbms_output.put_line('-------------------------');
        FOR s IN s1 LOOP
            dbms_output.put_line(s.s_no || '     ' || s.s_name || '     ' || s.s_price || '     ' || s.s_color);
            EXIT WHEN s1%notfound;
        END LOOP;
    ELSE 
        dbms_output.put_line(sang || '��ǰ�� �����ϴ�.');
    END IF;
END;
/

EXEC SANGPUM('����');




-- ���� 4
/*
    EXEC ADDUPDATE('���̽�����', 'BLACK') : �ش� ��ǰ�� ������ �߰� / �ش� ��ǰ�� ������ ���ݰ� ���� ����
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
        DBMS_OUTPUT.PUT_LINE(SNA||' ��ǰ �߰� �Ϸ�');
    ELSE
        UPDATE SHOP SET S_PRICE=SP, S_COLOR=SC WHERE S_NAME=SNA;
        DBMS_OUTPUT.PUT_LINE(SNA||' ��ǰ ���� �Ϸ�');
    END IF;
    FOR S IN S1 LOOP
        dbms_output.put_line('��ǰ��ȣ  ��ǰ�� ����  ����');
        dbms_output.put_line('-------------------------');
        dbms_output.put_line(s.s_no || '     ' || s.s_name || '     ' || s.s_price || '     ' || s.s_color);
        EXIT WHEN S1%NOTFOUND;
    END LOOP;
end;
/

EXEC ADDUPDATE('����',30000,'BLACK');
EXEC ADDUPDATE('�ٶ�����',72000,'BLACK');


drop table person;
drop table food;
drop table student;
