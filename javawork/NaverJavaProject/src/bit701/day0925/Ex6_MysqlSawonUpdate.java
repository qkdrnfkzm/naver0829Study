package bit701.day0925;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DbConnect;

public class Ex6_MysqlSawonUpdate {

	DbConnect db = new DbConnect();

	private void sawonUpdate() {

		Scanner sc = new Scanner(System.in);
		// num, name, score, buseo를 입력 받은 후 num에 해당하는 name, score, buseo 수정하기

		System.out.print("수정할 사원번호 입력 : ");
		String num = sc.nextLine();
		System.out.print("수정할 이름 : ");
		String name = sc.nextLine();
		System.out.print("수정할 점수 : ");
		String score = sc.nextLine();
		System.out.print("수정할 부서 : ");
		String dept = sc.nextLine();

		String sql = "update sawon set name = '" + name + "', score = '" + score + "', buseo = '" + dept + "' where num='" + num + "'";
		System.out.println(sql);
		
		Connection conn = null;
		Statement stmt = null;
		conn = db.getMysqlConnection();
		try {
			stmt = conn.createStatement();
			int n = stmt.executeUpdate(sql);
			if(n==0) {
				System.out.println("수정할 사원이 없음");
			}else {
				System.out.println("사원정보 수정 완료");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(stmt, conn);
		}
	}

	public static void main(String[] args) {
		Ex6_MysqlSawonUpdate ex = new Ex6_MysqlSawonUpdate();
		ex.sawonUpdate();
	}

}
