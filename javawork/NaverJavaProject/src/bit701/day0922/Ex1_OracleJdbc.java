package bit701.day0922;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex1_OracleJdbc {

	static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
	static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:xe";

	public Ex1_OracleJdbc() {
		try {
			Class.forName(ORACLE_DRIVER);
//			System.out.println("오라클 드라이버 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버 오류 : " + e.getMessage());
		}
	}

	public void shopAllDatas() {
		Connection conn = null;

		Statement stmt = null;
		ResultSet rs = null; // select 일 경우에만 필요
		String sql = "select * from shop order by s_no";

		try {
			conn = DriverManager.getConnection(ORACLE_URL, "angel", "a1234");
//			System.out.println("오라클 연결 성공");

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql); // select 일 경우는 무조건 executeQuery(반환 타입이 ResultSet이기 떄문)

			// rs.next() : 다음데이터로 이동 하고 true 반환, 이동 할 데이터가 없을 경우 false 반환
//			System.out.println("---방법1---");
//			System.out.println("상품번호\t상품명\t가격\t색상");
//			System.out.println("-".repeat(30));
//			while(rs.next()) {
//				//데이터를 가져 올 때 인덱스로 가져오거나 컬럼명으로 가져온다
//				//일다 인덱스로 가져와
//				String no = rs.getString(1);
//				String name = rs.getString(2);
//				int price = rs.getInt(3);
//				String color = rs.getString(4);
//				System.out.println(no+"\t"+name+"\t"+price+"\t"+color);
//			}

			int total = 0;

			System.out.println("---방법2---");
			System.out.println("상품번호\t상품명\t가격\t색상");
			System.out.println("-".repeat(30));
			while (rs.next()) {
				// 데이터를 가져 올 때 인덱스로 가져오거나 컬럼명으로 가져온다
				// 일다 인덱스로 가져와
				String no = rs.getString("s_no");
				String name = rs.getString("s_name");
				int price = rs.getInt("s_price");
				String color = rs.getString("s_color");

				total += price;

				System.out.println(no + "\t" + name + "\t" + price + "\t" + color);
			}
			System.out.println("총 금액 : " + total);

		} catch (SQLException e) {
			System.out.println("오라클 연결 실패" + e.getMessage());
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException | NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public static void main(String[] args) {
		Ex1_OracleJdbc ex = new Ex1_OracleJdbc();
		ex.shopAllDatas();
	}
}
