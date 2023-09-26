package bit701.day0925;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DbConnect;

public class Ex2_MysqlSawonInsert {

	// DB 드라이브, 연결을 위한 클래스 호출
	DbConnect db = new DbConnect();

	// 콘솔창에 키보드로 입력 받아 insert문 실행
	private void sawonInert() {
		Scanner sc = new Scanner(System.in);

		System.out.print("이름 : ");
		String name = sc.nextLine();

		System.out.print("1-100 사이 점수 : ");
		int score = Integer.parseInt(sc.nextLine());

		System.out.print("성별 : ");
		String gender = sc.nextLine();

		System.out.print("부서 : ");
		String dept = sc.nextLine();

		String sql = "insert into sawon values (null, '" + name + "', " + score + ", '" + gender + "', '" + dept + "')";
		System.out.println(sql);

		Connection conn = null;
		Statement stmt = null;

		conn = db.getMysqlConnection();
		try {
			stmt = conn.createStatement();
			//실행
			stmt.execute(sql);
			System.out.println("데이터 입력 완료");
		} catch (SQLException e) {
			System.out.println("sql문 오류" + e.getMessage());
		} finally {
			// db 클래스에 작성해 놓은 dbclose 메소드로 stmt, conn 클로즈
			db.dbClose(stmt, conn);
		}
	}

	public static void main(String[] args) {
		Ex2_MysqlSawonInsert ex = new Ex2_MysqlSawonInsert();
		ex.sawonInert();
	}

}
