package bit701.day0922;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex3_MysqlGruopSawon {
	static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL = "jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";

	public Ex3_MysqlGruopSawon() {
		try {
			Class.forName(MYSQL_DRIVER);
			// System.out.println("MySql 드라이버 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("MySql 드라이버 실패 : " + e.getMessage());
		}
	}

	public void sawonBunseok() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select dept, count(*) count, max(score) maxscore, min(score) minscore, avg(score) avgscore from sawon group by dept";

		try {
			conn = DriverManager.getConnection(MYSQL_URL, "root", "1234");
			// System.out.println("MySql 연결 성공");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			System.out.println("부서\t인원수\t최고점수\t최소점수\t평균점수");
			System.out.println("-".repeat(40));
			while (rs.next()) {
				String dept = rs.getString("dept");
				int count = rs.getInt("count");
				int max = rs.getInt("maxscore");
				int min = rs.getInt("minscore");
				double avg = rs.getDouble("avgscore");
				System.out.println(dept + "\t" + count + "\t" + max + "\t" + min + "\t" + avg);
			}

		} catch (SQLException e) {
			System.out.println("MySql 연결 실패" + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Ex3_MysqlGruopSawon ex = new Ex3_MysqlGruopSawon();
		ex.sawonBunseok();
	}
}
