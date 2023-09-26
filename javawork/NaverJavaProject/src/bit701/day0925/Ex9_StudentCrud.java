package bit701.day0925;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import db.DbConnect;

public class Ex9_StudentCrud {

	DbConnect db = new DbConnect();
	Scanner sc = new Scanner(System.in);

	public int getMenu() {
		System.out.println("1.추가  2.삭제  3.수정  4.조회  5.검색  6.종료");
		int menu = Integer.parseInt(sc.nextLine());
		return menu;
	}

	// insert
	public void insertStudent() {
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("혈액형 : ");
		String blood = sc.nextLine();
		System.out.print("휴대폰 : ");
		String phone = sc.nextLine();
		System.out.print("작성일 : ");
		String writeDay = sc.nextLine();

		String sql = "insert into student values(null,?,?,?,?)";

		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			// 바인딩
			pstmt.setString(1, name);
			pstmt.setString(2, blood.toUpperCase());
			pstmt.setString(3, phone);
			pstmt.setString(4, writeDay);
			// 실행
			pstmt.execute();
			System.out.println("insert 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}

	// delete
	public void deleteStudent() {
		// 이름으로 삭제
		System.out.print("삭제할 이름 : ");
		String name = sc.nextLine();

		String sql = "delete from student where name=?";

		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);

			int n = pstmt.executeUpdate();
			if (n == 0) {
				System.out.println("해당 학생 데이터 존재하지 않음");
			} else {
				System.out.println(n + "개의 " + name + " 학생 데이터 삭제 완료");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}

	// update
	public void updateStudent() {
		// num으로 name, blood, phone 수정
		System.out.print("수정할 학생 번호 : ");
		int num = Integer.parseInt(sc.nextLine());
		System.out.print("수정할 학생 이름 : ");
		String name = sc.nextLine();
		System.out.print("수정할 학생 혈액형 : ");
		String blood = sc.nextLine();
		System.out.print("수정할 학생 휴대폰 : ");
		String phone = sc.nextLine();

		String sql = "update student set name=?, blood=?, phone=? where num=?";

		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, blood.toUpperCase());
			pstmt.setString(3, phone);
			pstmt.setInt(4, num);

			int n = pstmt.executeUpdate();
			if (n == 0) {
				System.out.println("해당 학생 데이터 존재하지 않음");
			} else {
				System.out.println(name + " 학생 데이터 수정 완료");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}

	// selectAll
	public void selectAllStudent() {
		System.out.println("번호\t이름\t혈액형\t휴대폰\t\t작성일");

		String sql = "select * from student";

		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String blood = rs.getString("blood");
				String phone = rs.getString("phone");
				// String writeDay = rs.getString("writeday");
				Timestamp ts = rs.getTimestamp("writeday");
				// System.out.println(num+"\t"+name+"\t"+blood+"\t"+phone+"\t"+ts.toLocaleString());
				System.out.println(num + "\t" + name + "\t" + blood + "\t" + phone + "\t" + sdf.format(ts));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}

	// select - 뒷번호 4자리
	public void selectPhone() {
		// 전화번호 뒷자리 4글자로 조회
		System.out.print("검색할 휴대폰 뒷 4자리 : ");
		String hp4 = sc.nextLine();

		String sql = "select * from student where phone like ?";

		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + hp4);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String blood = rs.getString("blood");
				String phone = rs.getString("phone");
				Timestamp ts = rs.getTimestamp("writeday");
				System.out.println(num + "\t" + name + "\t" + blood + "\t" + phone + "\t" + sdf.format(ts));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}

	public static void main(String[] args) {
		Ex9_StudentCrud ex = new Ex9_StudentCrud();

		while (true) {
			System.out.println("-".repeat(51));
			int menu = ex.getMenu();
			System.out.println("-".repeat(51));

			switch (menu) {
			case 1:
				ex.insertStudent();
				break;
			case 2:
				ex.deleteStudent();
				break;
			case 3:
				ex.updateStudent();
				break;
			case 4:
				ex.selectAllStudent();
				break;
			case 5:
				ex.selectPhone();
				break;
			default:
				System.out.println("종료");
				System.exit(0);
			}
		}
	}
}
