package bit701.day0925;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import db.DbConnect;

public class Ex7_SawonCrud {
	DbConnect db = new DbConnect();
	Scanner sc = new Scanner(System.in);

	// 조회
	public void selectAll() {

		System.out.println("번호\t사원명\t점수\t성별\t부서");
		System.out.println("=".repeat(36));

		String sql = "select * from sawon";

		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				int score = rs.getInt("score");
				String gender = rs.getString("gender");
				String dept = rs.getString("buseo");
				System.out.println(num + "\t" + name + "\t" + score + "\t" + gender + "\t" + dept);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
	}

	// 삽입
	public void insertSawon() {
		System.out.print("이름 : ");
		String name = sc.nextLine();

		System.out.print("1-100 사이 점수 : ");
		int score = Integer.parseInt(sc.nextLine());

		System.out.print("성별 : ");
		String gender = sc.nextLine();

		System.out.print("부서 : ");
		String dept = sc.nextLine();

		String sql = "insert into sawon(name, score, gender, buseo) values (?,?,?,?)";
		// ?에 값을 넣는 것 : 바인딩 - ?는 차례 대로 1,2,3,4...

		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql); // 이떄 sql문을 검사

			// ? 갯수만큼 값을 넣어준다
			pstmt.setString(1, name);
			pstmt.setInt(2, score);
			pstmt.setString(3, gender);
			pstmt.setString(4, dept);

			// 실행
			pstmt.execute(); // 주의 : sql문을 넣지 않는다
			System.out.println("성공적으로 삽입에 성공하였습니다");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}

	// 삭제
	public void deleteSawon() {
		System.out.print("삭제할 사원명 입력 : ");
		String name = sc.nextLine();

		String sql = "delete from sawon where name=?";

		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);

			int n = pstmt.executeUpdate();
			if (n == 0) {
				System.out.println("해당 사원이 존재하지 않음");
			} else {
				System.out.println(n + "명의 정보 삭제 완료");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}

	// 수정
	public void updateSawon() {
		System.out.print("수정할 사원번호 입력 : ");
		String num = sc.nextLine();

		System.out.print("수정할 이름 : ");
		String name = sc.nextLine();

		System.out.print("수정할 점수 : ");
		String score = sc.nextLine();

		System.out.print("수정할 부서 : ");
		String dept = sc.nextLine();

		String sql = "update sawon set name=?, score=?, buseo=? where num=?";

		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, name);
			pstmt.setString(2, score);
			pstmt.setString(3, dept);
			pstmt.setString(4, num);

			int n = pstmt.executeUpdate();
			if (n == 0) {
				System.out.println("해당 데이터 없음");
			} else {
				System.out.println("수정 완료");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}

	}

	// 메뉴
	public int getMenu() {
		int menu = 0;
		System.out.println("1.추가  2.삭제  3.수정  4.전체조회  5.종료");
		menu = Integer.parseInt(sc.nextLine());
		return menu;
	}

	public static void main(String[] args) {
		Ex7_SawonCrud ex = new Ex7_SawonCrud();

		while (true) {
			int menu = ex.getMenu();
			switch (menu) {
			case 1:
				ex.insertSawon();
				break;
			case 2:
				ex.deleteSawon();
				break;
			case 3:
				ex.updateSawon();
				break;
			case 4:
				ex.selectAll();
				break;
			default:
				System.out.println("종료");
				System.exit(0); // 시스템 종료
			}
			System.out.println("-".repeat(36));
		}
	}
}
