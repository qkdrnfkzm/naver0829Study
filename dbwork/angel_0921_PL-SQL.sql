--PL-SQL이란
--SQL 언어에 절차적 언어요소를 추가해서 프로그래밍 한것을 PL-SQL 이라고 한다

--예제1
DECLARE
    --변수 선언하는 영역
    v_no NUMBER(4, 1);   --4자리에 소숫점 이하 1자리 값을 넣는 변수 선언
BEGIN
    --SQL구문이나 PL-SQL문으로 코딩하는 영역( := 대입, = 비교,동등)
    v_no := 12.7;
    dbms_output.put_line(v_no); --출력
END;
/

--예제2
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
                         || '님은 '
                         || vban
                         || '입니다');
END;
/

--예제 3 person과 food 테이블을 조인하여 p_num이 9인 사람의 이름, 주문한 메뉴, 가격을 출력하시오
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
                         || '님이 주문하신 메뉴는 '
                         || vmenu
                         || ', 가격은 '
                         || vprice
                         || '원 입니다');

    dbms_output.put_line('주문자 : ' || vname);
    dbms_output.put_line('메  뉴 : ' || vmenu);
    dbms_output.put_line('가  격 : '
                         || vprice
                         || '원');
END;
/

--예제4
--상품명을 변수에 저장한 후 해당 상품명의 가격과 색상을 출력

DECLARE
    vname   VARCHAR2(20) := '티셔츠';
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

    dbms_output.put_line('상품명 : ' || vname);
    dbms_output.put_line('가  격 : ' || vprice);
    dbms_output.put_line('색  상 : ' || vcolor);
    dbms_output.put_line('가 격2 : ' || vprice2);
END;
/

/*
if 조건식 then
    문장1;
else
    문장2;
end if;

다중if
if 조건식1 then
    문장1;
els if 조건2 then
    문장2;
    ...
end if;    
*/

--예제 6 조건식
ACCEPT year prompt '태어난 년도를 입력하세요';

DECLARE
    v_year NUMBER(4) := '&year'; --입력한 값을 대입
    v_mod  NUMBER(2) := MOD(v_year, 12); --년도를 12로 나눈 나머지
    v_ddi  VARCHAR2(10);
BEGIN
    IF v_mod = 0 THEN
        v_ddi := '원숭이';
    ELSIF v_mod = 1 THEN
        v_ddi := '닭';
    ELSIF v_mod = 2 THEN
        v_ddi := '개';
    ELSIF v_mod = 3 THEN
        v_ddi := '돼지';
    ELSIF v_mod = 4 THEN
        v_ddi := '쥐';
    ELSIF v_mod = 5 THEN
        v_ddi := '소';
    ELSIF v_mod = 6 THEN
        v_ddi := '호랑이';
    ELSIF v_mod = 7 THEN
        v_ddi := '토끼';
    ELSIF v_mod = 8 THEN
        v_ddi := '용';
    ELSIF v_mod = 9 THEN
        v_ddi := '뱀';
    ELSIF v_mod = 10 THEN
        v_ddi := '말';
    ELSIF v_mod = 11 THEN
        v_ddi := '양';
    END IF;

    dbms_output.put_line(v_year
                         || '년 생은 '
                         || v_ddi
                         || '띠 입니다');
END;
/

--예제 7 db컬럼의 타입을 가져오는 방법 type

ACCEPT iname prompt '이름?';

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

    dbms_output.put_line('학생명 : ' || vname);
    dbms_output.put_line('키 : ' || vheight);
    dbms_output.put_line('자바점수 : ' || vjava);
    dbms_output.put_line('스프링점수 : ' || vspring);
    dbms_output.put_line('총점 : ' ||(vjava + vspring));
END;
/

/*
반복문 : loop
loop
    문장들;
    exit when 조건
end loop;
*/
--예제 8 반복문
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

--문제 : 단을 입력하면 해당 단을 출력하세요
accept idan prompt '단을입력하세요';

DECLARE
    vdan NUMBER(2) := '&idan';
    vsu  NUMBER(2) := 0;
BEGIN
dbms_output.put_line('** '||vdan||'단 **');
    LOOP
        vsu := vsu + 1;
        dbms_output.put_line(vdan || ' X ' || vsu || ' = ' || vdan * vsu);
        EXIT WHEN vsu = 9;
    END LOOP;
END;
/

--예제 9 Exception 처리
--상품명을 입력받아 상품명의 가격과 색상을 출력
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
    dbms_output.put_line('상품명 : ' || vsangpum);
    dbms_output.put_line('가  격 : ' || vprice);
    dbms_output.put_line('색  상 : ' || vcolor);
    dbms_output.put_line('가 격2 : ' || vprice2);
    exception
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT . PUT_LINE ( VSANGPUM | | ' 상품은 DB에 없습니다' ) ; 
    WHEN TOO_MANY_ROWS THEN 
        DBMS_OUTPUT . PUT_LINE ( VSANGPUM | | ' 상품이 두개이상 존재합니다' ) ; 
    WHEN OTHERS THEN
        DBMS_OUTPUT . PUT_LINE ( VSANGPUM | | ' 상품에 대한 오류발생-뭔지모름' ) ;
END;
/

/*
    반복문
    for 변수 in[reverse] 시작값..최종값 loop
    문장들;
    end loop
*/
--예제10, 예제 8 구구단 복사 후 for문으로 변경
accept idan prompt '단을입력하세요';

DECLARE
    vdan NUMBER(2) := '&idan';
    vsu  NUMBER(2) := 0;
BEGIN
    dbms_output.put_line('** '||vdan||'단 **');
    for vsu in 1..9 loop
        dbms_output.put_line(vdan || ' X ' || vsu || ' = ' || vdan * vsu);
    end loop;
END;
/

--예제 11 레코드 단위로 데이터 가져오기

DECLARE
    vnum student.num%TYPE :=1;
    vstu angel.student%rowtype; --레코드 단위로 읽어올 경우
BEGIN
    select * into vstu
    from student
    where num=vnum;
    DBMS_OUTPUT.PUT_LINE('이름 : '||vstu.name);
    DBMS_OUTPUT.PUT_LINE('키 : '||vstu.height);
    DBMS_OUTPUT.PUT_LINE('자바 : '||vstu.java);
    DBMS_OUTPUT.PUT_LINE('스피링 : '||vstu.spring);
    DBMS_OUTPUT.PUT_LINE('반 : '||vstu.ban);
END;
/

--DB의 여러데이터를 조회할 경우
/*
Cursor : SQL문을 실행할 때 마다 명령이 분석되고 실행되어 결과를 보관하기 위한 특별한 메모리 영역을 사용하는데 이 영역을 참조하는것이 커서이다
SELECT 문에서 여러 데이터 조회시 사용되는 객체이다

커서 속성
    sql%rowcount : 실행된 갯수 반환
    sql%found : 가장 최근의 sql문이 하나 이상의 행에 영향을 준 경우 true
    sql%notfound : 결과행이 없는 경우
    sql%isopen : 항상 false(항상 close를 하기 때문에 항상 false)
*/

--예제 12
DECLARE
    v_sno number(3) := 20;
    v_shop angel.shop%rowtype;
BEGIN
    select * into v_shop from shop
    where s_no=v_sno;
    DBMS_OUTPUT.PUT_LINE('상품명 : '||v_shop.s_name);
    DBMS_OUTPUT.PUT_LINE('조회된 실행 갯수 : '||sql%rowcount); -- -> 1
    --student의 java 점수 변경하기
    update student set java=99;
    DBMS_OUTPUT.PUT_LINE('수정된 실행 갯수 : '||sql%rowcount); -- -> 3
END;
/

--예제 13 여러 레코드 조회
DECLARE
    CURSOR s1
    is
    select * from shop;
BEGIN
    DBMS_OUTPUT.PUT_LINE('상품번호  상품명 색상  가격');
    DBMS_OUTPUT.PUT_LINE('-------------------------');
    for s in s1 loop
    DBMS_OUTPUT.PUT_LINE(s.s_no||'  '||s.s_name||'  '||s.s_color||'  '||s.s_price);
    exit when s1%notfound;  --더이상 데이터가 없으면 빠져 나간다
    end loop;
END;
/

--예제 14
--상품명, 색상, 가격을 입력하면 shop db에 추가 하기
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
    DBMS_OUTPUT.PUT_LINE('상품정보를 추가했습니다');
END;
/

--문제 : food 테이블
/*
    fname, fprice, no 입력을 받아서
    no가 1이면 fname, fprice로 데이터 추가를 하고
    no가 2면 food 전체 데이터 출력
*/

--accept ino prompt '1 or 2 입력';
--accept imenu prompt '추가할 메뉴 이름';
--accept iprice prompt '추가할 메뉴 가격';
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
        DBMS_OUTPUT.PUT_LINE('상품번호  상품명 상품가격');
        DBMS_OUTPUT.PUT_LINE('----------------------');
        for s in s1 loop
            DBMS_OUTPUT.PUT_LINE(s.f_num||'   '||s.fname||'   '||s.fprice);
        exit when s1%notfound;
        end loop;      
    end if;
END;
/

