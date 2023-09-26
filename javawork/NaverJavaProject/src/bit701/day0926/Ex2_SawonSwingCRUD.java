package bit701.day0926;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import db.DbConnect;

public class Ex2_SawonSwingCRUD extends JFrame {

	DbConnect db = new DbConnect();

	JTextField tfName, tfScore;
	JComboBox<String> cbGender, cbDept;
	JTable table;
	DefaultTableModel tableModel;
	JButton btnIns, btnDel, btnSer, btnSerAll;

	public Ex2_SawonSwingCRUD() {
		super("사원관리");
		this.setBounds(300, 300, 500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDesign();
		this.setVisible(true);

	}

	private void setDesign() {

		// 상단
		tfName = new JTextField(6);
		tfScore = new JTextField(5);
		String[] cbGen = { "남자", "여자" };
		cbGender = new JComboBox<String>(cbGen);
		String[] cbDep = { "교육부", "기획부", "인사부", "총무부", "홍보부" };
		cbDept = new JComboBox<String>(cbDep);
		// 상단 패널
		JPanel jpTop = new JPanel();
		jpTop.add(new JLabel("이름"));
		jpTop.add(tfName);
		jpTop.add(new JLabel("점수"));
		jpTop.add(tfScore);
		jpTop.add(new JLabel("성별"));
		jpTop.add(cbGender);
		jpTop.add(new JLabel("부서"));
		jpTop.add(cbDept);
		this.add(jpTop, "North");

		// 하단
		btnIns = new JButton("추가");
		btnDel = new JButton("삭제");
		btnSer = new JButton("검색");
		btnSerAll = new JButton("전체조회");
		// 하단패널
		JPanel jpBot = new JPanel();
		jpBot.add(btnIns);
		jpBot.add(btnDel);
		jpBot.add(btnSer);
		jpBot.add(btnSerAll);
		this.add(jpBot, "South");

		// 중앙
		String[] title = { "번호", "이름", "점수", "성별", "부서" };
		tableModel = new DefaultTableModel(title, 0);
		table = new JTable(tableModel);
		this.add(new JScrollPane(table), "Center");

		// 초기데이터 불러오기
		selectAllSawon();

		// 버튼 이벤트 - insert
		btnIns.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = tfName.getText();
				if (name.length() == 0) {
					JOptionPane.showMessageDialog(Ex2_SawonSwingCRUD.this, "이름을 입력해주세요");
					return;
				} 
				int score = 0;

				try {
					score = Integer.parseInt(tfScore.getText());
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(Ex2_SawonSwingCRUD.this, "점수를 입력해주세요");
					return;
				}
				String gender = cbGender.getSelectedItem().toString();
				String dept = cbDept.getSelectedItem().toString();
				
				if (score > 100 || score < 0) {
				JOptionPane.showMessageDialog(Ex2_SawonSwingCRUD.this, "0~100 사이의 점수를 입력해주세요");
					return;
				} else {
					insertSawon(name, score, gender, dept);
					selectAllSawon();
					tfName.setText("");
					tfScore.setText("");
				}
			}
		});
		// 버튼 이벤트 - delete
		btnDel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if (row == -1) {
					JOptionPane.showMessageDialog(Ex2_SawonSwingCRUD.this, "삭제할 행을 선택해 주세요");
				} else {
					String num = table.getValueAt(row, 0).toString();
					deleteSawon(num);
					selectAllSawon();
				}
			}
		});
		// 버튼 이벤트 - select
		btnSer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String serahDept = cbDept.getSelectedItem().toString();
				selectSawon(serahDept);
			}
		});
		// 버튼 이벤트 - selectAll
		btnSerAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectAllSawon();
			}
		});

	}

	// insert
	public void insertSawon(String name, int score, String gender, String dept) {

		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into sawon values (null, ?, ?, ?, ?)";

		try {
			pstmt = conn.prepareStatement(sql);
			// 바인딩
			pstmt.setString(1, name);
			pstmt.setInt(2, score);
			pstmt.setString(3, gender);
			pstmt.setString(4, dept);
			// 실행
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}

	// delete
	public void deleteSawon(String num) {
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		String sql = "delete from sawon where num=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}

	// select
	public void selectSawon(String selDept) {
		// 기존 테이블 데이터 삭제 후 조회 진행
		tableModel.setRowCount(0);

		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from sawon where dept = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, selDept);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String num = rs.getString("num");
				String name = rs.getString("name");
				String score = rs.getString("score");
				String gender = rs.getString("gender");
				String dept = rs.getString("dept");

				// Vector에 정보 넣기
				Vector<String> data = new Vector<String>();
				data.add(num);
				data.add(name);
				data.add(score);
				data.add(gender);
				data.add(dept);

				// 테이블에 추가
				tableModel.addRow(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
	}

	// selectAll
	public void selectAllSawon() {
		// 기존 테이블 데이터 삭제 후 조회 진행
		tableModel.setRowCount(0);

		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from sawon";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String num = rs.getString("num");
				String name = rs.getString("name");
				String score = rs.getString("score");
				String gender = rs.getString("gender");
				String dept = rs.getString("dept");

				// Vector에 정보 넣기
				Vector<String> data = new Vector<String>();
				data.add(num);
				data.add(name);
				data.add(score);
				data.add(gender);
				data.add(dept);

				// 테이블에 추가
				tableModel.addRow(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
	}

	public static void main(String[] args) {
		Ex2_SawonSwingCRUD ex = new Ex2_SawonSwingCRUD();
	}

}

//상단 tfname tfscore cbgender cbdept

//테이블
//추가
//삭제 - 테이블 클릭시
//조회 - 부서명 입력받아 해당 부서만 출력
//전체조회
