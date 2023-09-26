package bit701.day0925;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DbConnect;

public class Ex1_OracleShopInsert {
	// DbConnect 클래스 호출
	DbConnect db = new DbConnect();

	// 콘솔창에 키보드로 입력 받아 insert문 실행
	public void shopInsert() {
		Scanner sc = new Scanner(System.in);

		System.out.print("상품명 입력 : ");
		String sname = sc.nextLine();

		System.out.print("가격 입력 : ");
		String sprice = sc.nextLine();

		System.out.print("색상 입력 : ");
		String scolor = sc.nextLine();

		String sql = "insert into shop values (seq_shop.nextval, '" + sname + "', " + sprice + ", '" + scolor + "')";
		// System.out.println(sql);

		Connection conn = null;
		Statement stmt = null;

		// DB연결
		conn = db.getOracleConnection();
		// Statement
		try {
			stmt = conn.createStatement();
			// 실행
//			boolean b = stmt.execute(sql); // 반환타입 : boolean -> false
//			int n = stmt.executeUpdate(sql); // 반환타입 : int -> sql문을 성공한 갯수
//			System.out.println("데이터 2번 insert 됨");
			stmt.execute(sql);
			System.out.println("shop에 데이터 추가됨");

		} catch (SQLException e) {
			System.out.println("sql문 오류" + e.getMessage());
		} finally {
			// db 클래스에 작성해 놓은 dbclose 메소드로 stmt, conn 클로즈
			db.dbClose(stmt, conn);
		}
	}

	public static void main(String[] args) {
		Ex1_OracleShopInsert ex = new Ex1_OracleShopInsert();
		ex.shopInsert();
	}

}
