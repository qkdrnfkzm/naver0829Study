package bit701.day0925;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DbConnect;

public class Ex4_MysqlSawonDelete {
	DbConnect db = new DbConnect();

	private void sawonDelete() {

		// 사원명 입력 후 해당 사원 입력
		// 결과값이 0이면 xxx사원은 없습니다
		// n이면 총 n명의 xxx 사원정보를 삭제 했습니다

		Scanner sc = new Scanner(System.in);

		System.out.print("삭제할 사원명 입력 : ");
		String name = sc.nextLine();

		String sql = "delete from sawon where name = '" + name + "'";
		System.out.println(sql);

		Connection conn = null;
		Statement stmt = null;
		conn = db.getMysqlConnection();
		try {
			stmt = conn.createStatement();
			int n = stmt.executeUpdate(sql);
			if (n == 0) {
				System.out.println(name + "사원은 없습니다");
			} else {
				System.out.println(n + "명의 " + name + " 사원을 삭제 했습니다");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}
	}

	public static void main(String[] args) {
		Ex4_MysqlSawonDelete ex = new Ex4_MysqlSawonDelete();
		ex.sawonDelete();
	}
}
