package bit701.day0926;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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

import db.DbConnect;

public class Ex1_StudentSwingCRUD extends JFrame {

	DbConnect db = new DbConnect();

	JTextField tfName, tfPhone;
	JComboBox<String> cbBlood;
	JTable table;
	DefaultTableModel tableModel;
	JButton btnAdd, btnDel, btnSearch, btnAll;

	public Ex1_StudentSwingCRUD() {
		super("학생관리");
		this.setBounds(1000, 100, 500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDesign();
		this.setVisible(true);
	}

	private void setDesign() {
		tfName = new JTextField(4);
		tfPhone = new JTextField(10);
		String[] cbTitle = { "A", "B", "O", "AB" };
		cbBlood = new JComboBox<String>(cbTitle);

		JPanel pTop = new JPanel();
		pTop.add(new JLabel("이름"));
		pTop.add(tfName);
		pTop.add(new JLabel("전화"));
		pTop.add(tfPhone);
		pTop.add(new JLabel("혈액형"));
		pTop.add(cbBlood);

		this.add(pTop, "North");

		// 하단
		btnAdd = new JButton("추가");
		btnDel = new JButton("삭제");
		btnSearch = new JButton("검색");
		btnAll = new JButton("전체조회");

		JPanel pBottom = new JPanel();
		pBottom.add(btnAdd);
		pBottom.add(btnDel);
		pBottom.add(btnSearch);
		pBottom.add(btnAll);

		// 버튼이벤트 - insert
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 데이터 가져오기
				String name = tfName.getText();
				String phone = tfPhone.getText();
				String blood = (String) cbBlood.getSelectedItem();
				// 값이 입력되지 않았을 경우
				if (name.length() == 0 || phone.length() == 0) {
					return;
				}

				// DB에 insert 하는 메소드 호출
				insertStudent(name, phone, blood);
				// DB로 부터 다시 데이터를 가져와서 출력
				StudentSelectAll();
				// 입력값 초기화
				tfName.setText("");
				tfPhone.setText("");
			}
		});
		// 버튼이벤트 - delete
		btnDel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 선택한 행번호를 얻는다 - 선택하지 않았을 경우 -1반환
				int row = table.getSelectedRow();
				// System.out.println(row);
				if (row == -1) {
					JOptionPane.showMessageDialog(Ex1_StudentSwingCRUD.this, "삭제할 행을 선택해 주세요");
				} else {
					// row행이 0번열이 num 값
					String num = table.getValueAt(row, 0).toString();
					deleteStudent(num);
					// 삭제 후 데이터 다시 불러오기
					StudentSelectAll();
				}
			}
		});
		// 버튼이벤트 - select
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 검색할 이름 입력 받기
				String searchName = JOptionPane.showInputDialog("검색할 이름을 입력해 주세요");
				System.out.println(searchName);
				if (searchName == null) {
					return; // 취소 누를 경우 메소드(이벤트) 종료
				} else {
					searchStudent(searchName);
				}
			}
		});
		// 버튼이벤트 - selectAll
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StudentSelectAll();
			}
		});

		this.add(pBottom, "South");

		// Table
		String[] title = { "번호", "이름", "혈액형", "전화", "작성일" };
		tableModel = new DefaultTableModel(title, 0);
		table = new JTable(tableModel);
		this.add(new JScrollPane(table), "Center");

		// 초기 DB 데이터 가져오기
		StudentSelectAll();
	}

	public static void main(String[] args) {
		Ex1_StudentSwingCRUD ex = new Ex1_StudentSwingCRUD();
	}

	// DB Method
	// DB에서 전체 데이터를 가져와서 테이블에 출력하는 메소드
	public void StudentSelectAll() {
		// 기존 테이블의 데이터를 모두 지운다
		tableModel.setRowCount(0);

		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from student order by num desc";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			while (rs.next()) {
				Vector<String> data = new Vector<String>();
				String num = rs.getString("num");
				String name = rs.getString("name");
				String blood = rs.getString("blood");
				String phone = rs.getString("phone");
				Timestamp ts = rs.getTimestamp("writeday");
				String writeday = sdf.format(ts);

				// Vector에 순서대로 추가
				data.add(num);
				data.add(name);
				data.add(blood);
				data.add(phone);
				data.add(writeday);

				// 테이블에 추가
				tableModel.addRow(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
	}

	// DB insert
	public void insertStudent(String name, String phone, String blood) {

		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into student values (null,?,?,?,now())";

		try {
			pstmt = conn.prepareStatement(sql);
			// ? -> 바인딩
			pstmt.setString(1, name);
			pstmt.setString(2, blood);
			pstmt.setString(3, phone);
			// 실행
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}

	// DB delete
	public void deleteStudent(String num) {
		// System.out.println(num);

		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		String sql = "delete from student where num = ?";

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

	public void searchStudent(String searchName) {
		tableModel.setRowCount(0);

		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from student where name like ? order by num desc";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + searchName + "%");
			rs = pstmt.executeQuery();

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			while (rs.next()) {
				Vector<String> data = new Vector<String>();
				String num = rs.getString("num");
				String name = rs.getString("name");
				String blood = rs.getString("blood");
				String phone = rs.getString("phone");
				Timestamp ts = rs.getTimestamp("writeday");
				String writeday = sdf.format(ts);

				// Vector에 순서대로 추가
				data.add(num);
				data.add(name);
				data.add(blood);
				data.add(phone);
				data.add(writeday);

				// 테이블에 추가
				tableModel.addRow(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
	}
}
