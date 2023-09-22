--PL-SQL�̶�
--SQL �� ������ ����Ҹ� �߰��ؼ� ���α׷��� �Ѱ��� PL-SQL �̶�� �Ѵ�

--����1
DECLARE
    --���� �����ϴ� ����
    v_no NUMBER(4, 1);   --4�ڸ��� �Ҽ��� ���� 1�ڸ� ���� �ִ� ���� ����
BEGIN
    --SQL�����̳� PL-SQL������ �ڵ��ϴ� ����( := ����, = ��,����)
    v_no := 12.7;
    dbms_output.put_line(v_no); --���
END;
/

--����2
DECLARE
    vname VARCHAR2(20);
    vban  VARCHAR2(20);
BEGIN
    SELECT
        name,
        ban
    INTO
        vname,
        vban
    FROM
        student
    WHERE
        num = 1;

    dbms_output.put_line(vname
                         || '���� '
                         || vban
                         || '�Դϴ�');
END;
/

--���� 3 person�� food ���̺��� �����Ͽ� p_num�� 9�� ����� �̸�, �ֹ��� �޴�, ������ ����Ͻÿ�
DECLARE
    vname  VARCHAR2(20);
    vmenu  VARCHAR2(20);
    vprice NUMBER(7);
BEGIN
    SELECT
        pname,
        fname,
        fprice
    INTO
        vname,
        vmenu,
        vprice
    FROM
        food   f,
        person p
    WHERE
            f.f_num = p.f_num
        AND p_num = 9;

    dbms_output.put_line(vname
                         || '���� �ֹ��Ͻ� �޴��� '
                         || vmenu
                         || ', ������ '
                         || vprice
                         || '�� �Դϴ�');

    dbms_output.put_line('�ֹ��� : ' || vname);
    dbms_output.put_line('��  �� : ' || vmenu);
    dbms_output.put_line('��  �� : '
                         || vprice
                         || '��');
END;
/

--����4
--��ǰ���� ������ ������ �� �ش� ��ǰ���� ���ݰ� ������ ���

DECLARE
    vname   VARCHAR2(20) := 'Ƽ����';
    vprice  NUMBER(7);
    vcolor  VARCHAR2(10);
    vprice2 VARCHAR2(20);
BEGIN
    SELECT
        s_price,
        s_color,
        ltrim(to_char(s_price, 'L999,999'))
    INTO
        vprice,
        vcolor,
        vprice2
    FROM
        shop
    WHERE
        s_name = vname;

    dbms_output.put_line('��ǰ�� : ' || vname);
    dbms_output.put_line('��  �� : ' || vprice);
    dbms_output.put_line('��  �� : ' || vcolor);
    dbms_output.put_line('�� ��2 : ' || vprice2);
END;
/

/*
if ���ǽ� then
    ����1;
else
    ����2;
end if;

����if
if ���ǽ�1 then
    ����1;
els if ����2 then
    ����2;
    ...
end if;    
*/

--���� 6 ���ǽ�
ACCEPT year prompt '�¾ �⵵�� �Է��ϼ���';

DECLARE
    v_year NUMBER(4) := '&year'; --�Է��� ���� ����
    v_mod  NUMBER(2) := MOD(v_year, 12); --�⵵�� 12�� ���� ������
    v_ddi  VARCHAR2(10);
BEGIN
    IF v_mod = 0 THEN
        v_ddi := '������';
    ELSIF v_mod = 1 THEN
        v_ddi := '��';
    ELSIF v_mod = 2 THEN
        v_ddi := '��';
    ELSIF v_mod = 3 THEN
        v_ddi := '����';
    ELSIF v_mod = 4 THEN
        v_ddi := '��';
    ELSIF v_mod = 5 THEN
        v_ddi := '��';
    ELSIF v_mod = 6 THEN
        v_ddi := 'ȣ����';
    ELSIF v_mod = 7 THEN
        v_ddi := '�䳢';
    ELSIF v_mod = 8 THEN
        v_ddi := '��';
    ELSIF v_mod = 9 THEN
        v_ddi := '��';
    ELSIF v_mod = 10 THEN
        v_ddi := '��';
    ELSIF v_mod = 11 THEN
        v_ddi := '��';
    END IF;

    dbms_output.put_line(v_year
                         || '�� ���� '
                         || v_ddi
                         || '�� �Դϴ�');
END;
/

--���� 7 db�÷��� Ÿ���� �������� ��� type

ACCEPT iname prompt '�̸�?';

DECLARE
    vname   student.name%TYPE := '&iname';
    vheight student.height%TYPE;
    vjava   student.java%TYPE;
    vspring student.spring%TYPE;
BEGIN
    SELECT
        height,
        java,
        spring
    INTO
        vheight,
        vjava,
        vspring
    FROM
        student
    WHERE
        name = vname;

    dbms_output.put_line('�л��� : ' || vname);
    dbms_output.put_line('Ű : ' || vheight);
    dbms_output.put_line('�ڹ����� : ' || vjava);
    dbms_output.put_line('���������� : ' || vspring);
    dbms_output.put_line('���� : ' ||(vjava + vspring));
END;
/

/*
�ݺ��� : loop
loop
    �����;
    exit when ����
end loop;
*/
--���� 8 �ݺ���
DECLARE
    vno NUMBER(2) := 0;
BEGIN
    LOOP
        vno := vno + 1;
        dbms_output.put_line('no=' || vno);
        EXIT WHEN vno = 10;
    END LOOP;
END;
/

--���� : ���� �Է��ϸ� �ش� ���� ����ϼ���
accept idan prompt '�����Է��ϼ���';

DECLARE
    vdan NUMBER(2) := '&idan';
    vsu  NUMBER(2) := 0;
BEGIN
dbms_output.put_line('** '||vdan||'�� **');
    LOOP
        vsu := vsu + 1;
        dbms_output.put_line(vdan || ' X ' || vsu || ' = ' || vdan * vsu);
        EXIT WHEN vsu = 9;
    END LOOP;
END;
/

--���� 9 Exception ó��
--��ǰ���� �Է¹޾� ��ǰ���� ���ݰ� ������ ���
--accept sangpum prompt 'sangpum?'
DECLARE
    vsangpum VARCHAR2(20) := '&sangpum';
    vprice  NUMBER(7);
    vcolor  VARCHAR2(10);
    vprice2 VARCHAR2(20);
BEGIN
    SELECT s_price,s_color,ltrim(to_char(s_price, 'L999,999'))
    INTO vprice,vcolor,vprice2
    FROM shop
    WHERE s_name = vsangpum;
    dbms_output.put_line('��ǰ�� : ' || vsangpum);
    dbms_output.put_line('��  �� : ' || vprice);
    dbms_output.put_line('��  �� : ' || vcolor);
    dbms_output.put_line('�� ��2 : ' || vprice2);
    exception
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT . PUT_LINE ( VSANGPUM | | ' ��ǰ�� DB�� �����ϴ�' ) ; 
    WHEN TOO_MANY_ROWS THEN 
        DBMS_OUTPUT . PUT_LINE ( VSANGPUM | | ' ��ǰ�� �ΰ��̻� �����մϴ�' ) ; 
    WHEN OTHERS THEN
        DBMS_OUTPUT . PUT_LINE ( VSANGPUM | | ' ��ǰ�� ���� �����߻�-������' ) ;
END;
/

/*
    �ݺ���
    for ���� in[reverse] ���۰�..������ loop
    �����;
    end loop
*/
--����10, ���� 8 ������ ���� �� for������ ����
accept idan prompt '�����Է��ϼ���';

DECLARE
    vdan NUMBER(2) := '&idan';
    vsu  NUMBER(2) := 0;
BEGIN
    dbms_output.put_line('** '||vdan||'�� **');
    for vsu in 1..9 loop
        dbms_output.put_line(vdan || ' X ' || vsu || ' = ' || vdan * vsu);
    end loop;
END;
/

--���� 11 ���ڵ� ������ ������ ��������

DECLARE
    vnum student.num%TYPE :=1;
    vstu angel.student%rowtype; --���ڵ� ������ �о�� ���
BEGIN
    select * into vstu
    from student
    where num=vnum;
    DBMS_OUTPUT.PUT_LINE('�̸� : '||vstu.name);
    DBMS_OUTPUT.PUT_LINE('Ű : '||vstu.height);
    DBMS_OUTPUT.PUT_LINE('�ڹ� : '||vstu.java);
    DBMS_OUTPUT.PUT_LINE('���Ǹ� : '||vstu.spring);
    DBMS_OUTPUT.PUT_LINE('�� : '||vstu.ban);
END;
/

--DB�� ���������͸� ��ȸ�� ���
/*
Cursor : SQL���� ������ �� ���� ����� �м��ǰ� ����Ǿ� ����� �����ϱ� ���� Ư���� �޸� ������ ����ϴµ� �� ������ �����ϴ°��� Ŀ���̴�
SELECT ������ ���� ������ ��ȸ�� ���Ǵ� ��ü�̴�

Ŀ�� �Ӽ�
    sql%rowcount : ����� ���� ��ȯ
    sql%found : ���� �ֱ��� sql���� �ϳ� �̻��� �࿡ ������ �� ��� true
    sql%notfound : ������� ���� ���
    sql%isopen : �׻� false(�׻� close�� �ϱ� ������ �׻� false)
*/

--���� 12
DECLARE
    v_sno number(3) := 20;
    v_shop angel.shop%rowtype;
BEGIN
    select * into v_shop from shop
    where s_no=v_sno;
    DBMS_OUTPUT.PUT_LINE('��ǰ�� : '||v_shop.s_name);
    DBMS_OUTPUT.PUT_LINE('��ȸ�� ���� ���� : '||sql%rowcount); -- -> 1
    --student�� java ���� �����ϱ�
    update student set java=99;
    DBMS_OUTPUT.PUT_LINE('������ ���� ���� : '||sql%rowcount); -- -> 3
END;
/

--���� 13 ���� ���ڵ� ��ȸ
DECLARE
    CURSOR s1
    is
    select * from shop;
BEGIN
    DBMS_OUTPUT.PUT_LINE('��ǰ��ȣ  ��ǰ�� ����  ����');
    DBMS_OUTPUT.PUT_LINE('-------------------------');
    for s in s1 loop
    DBMS_OUTPUT.PUT_LINE(s.s_no||'  '||s.s_name||'  '||s.s_color||'  '||s.s_price);
    exit when s1%notfound;  --���̻� �����Ͱ� ������ ���� ������
    end loop;
END;
/

--���� 14
--��ǰ��, ����, ������ �Է��ϸ� shop db�� �߰� �ϱ�
accept isang prompt 'sangpum?';
accept icolor prompt 'color?';
accept iprice prompt 'price?';
DECLARE
    v_sang shop.s_name%type := '&isang';
    v_color shop.s_color%type := '&icolor';
    v_price shop.s_price%type := '&iprice';
BEGIN
    insert into shop values(seq_shop.nextval, v_sang, v_price, v_color);
    commit;
    DBMS_OUTPUT.PUT_LINE('��ǰ������ �߰��߽��ϴ�');
END;
/

--���� : food ���̺�
/*
    fname, fprice, no �Է��� �޾Ƽ�
    no�� 1�̸� fname, fprice�� ������ �߰��� �ϰ�
    no�� 2�� food ��ü ������ ���
*/

--accept ino prompt '1 or 2 �Է�';
--accept imenu prompt '�߰��� �޴� �̸�';
--accept iprice prompt '�߰��� �޴� ����';
DECLARE
    vno number(2) :='&ino';
--    vname varchar2(30):= '&imenu';
--    vprice number(7):= '&iprice';
    CURSOR s1
    is
    select * from food;
BEGIN
    if 
        vno=1
    then 
        insert into food values(seq_food.nextval, '&imenu', '&iprice');
        commit;
    elsif
        vno=2
    then
        DBMS_OUTPUT.PUT_LINE('��ǰ��ȣ  ��ǰ�� ��ǰ����');
        DBMS_OUTPUT.PUT_LINE('----------------------');
        for s in s1 loop
            DBMS_OUTPUT.PUT_LINE(s.f_num||'   '||s.fname||'   '||s.fprice);
        exit when s1%notfound;
        end loop;      
    end if;
END;
/

