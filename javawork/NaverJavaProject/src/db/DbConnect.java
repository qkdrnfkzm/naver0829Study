package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnect {

	// MySql
	static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL = "jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";

	// Oracle
	static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
	static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:xe";

	// 드라이브 연결
	public DbConnect() {
		// MySql 드라이브 연결
		try {
			Class.forName(MYSQL_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("MYSQL 드라이브 오류 : " + e.getMessage());
		}

		// Oracle 드라이브 연결
		try {
			Class.forName(ORACLE_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Oracle 드라이브 오류 : " + e.getMessage());
		}
	}// DbConnect

	// MySql 연결
	public Connection getMysqlConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(MYSQL_URL, "root", "1234");
		} catch (SQLException e) {
			System.out.println("MYSQL 연결 실패 : " + e.getMessage());
		}
		return conn;
	}// getMysqlConnect

	// Oracle 연결
	public Connection getOracleConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(ORACLE_URL, "angel", "a1234");
		} catch (SQLException e) {
			System.out.println("Oracle 연결 실패 : " + e.getMessage());
		}
		return conn;
	}// getOracleConnect

	// close #1 (insert, delete 등) - Statement, Connection
	public void dbClose(Statement stmt, Connection conn) {
		try {
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			System.out.println("close 오류 : " + e.getMessage());
		}
	}// close #1

	// close #2 (select) - ResultSet, Statement, Connection
	public void dbClose(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			System.out.println("close 오류 : " + e.getMessage());
		}
	}// close #2

	// close #3 (insert, delete 등) - PreparedStatement, Connection
	public void dbClose(PreparedStatement pstmt, Connection conn) {
		try {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			System.out.println("close 오류 : " + e.getMessage());
		}
	}// close #3

	// close #4 (select) - ResultSet, PreparedStatement, Connection
	public void dbClose(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			System.out.println("close 오류 : " + e.getMessage());
		}
	}// close #4

}
