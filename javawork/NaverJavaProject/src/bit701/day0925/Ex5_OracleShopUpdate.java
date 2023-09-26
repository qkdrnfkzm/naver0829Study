package bit701.day0925;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DbConnect;

public class Ex5_OracleShopUpdate {

	DbConnect db = new DbConnect();

	private void shopUpdate() {

		Scanner sc = new Scanner(System.in);
		// s_no 값으로 수정(가격, 색상)
		System.out.print("수정할 상품번호 : ");
		String no = sc.nextLine();
		System.out.print("수정할 가격 : ");
		int price = Integer.parseInt(sc.nextLine());
		System.out.print("수정할 색상 : ");
		String color = sc.nextLine();

		String sql = "Update shop set s_price = " + price + ", s_color = '" + color + "' where s_no='" + no + "'";
		System.out.println(sql);

		Connection conn = null;
		Statement stmt = null;
		conn = db.getOracleConnection();
		try {
			stmt = conn.createStatement();
			int n = stmt.executeUpdate(sql);
			if (n == 0) {
				System.out.println(no + " 상품은 없습니다");
			} else {
				System.out.println(no + " 상품을 수정했습니다");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}
	}

	public static void main(String[] args) {
		Ex5_OracleShopUpdate ex = new Ex5_OracleShopUpdate();
		ex.shopUpdate();
	}
}
