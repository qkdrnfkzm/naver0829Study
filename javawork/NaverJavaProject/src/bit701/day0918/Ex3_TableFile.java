package bit701.day0918;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Ex3_TableFile extends JFrame {
	
	JTable table;
	DefaultTableModel model;
	JTextField tfNamd, tfAge, tfAddr;
	JButton btnAdd;
	//파일이름
	final static String FILENAME="D:\\naver0829\\member.txt";
	FileWriter fw;
	
	public Ex3_TableFile(String title) {
		super(title);
		this.setLocation(300,100);
		this.setSize(400,300);
		this.setDesign();
		this.setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {	//윈도우 창에 X버튼 클릭시 호출되는 메소드

				//종료 전 테이블의 내용을 member.txt에 추가하도록 코드 작성
				try {
					fw = new FileWriter(FILENAME,true);	//기존파일에 추가된다(없을경우 새로 생성)
					//행 갯수
					int row = table.getRowCount();
					for (int i = 0; i < row; i++) {
						String name = (String)model.getValueAt(i,0);
						String age = (String)model.getValueAt(i,1);
						String addr = (String)model.getValueAt(i,2);
						
						fw.write(name+","+age+","+addr+"\n");
						
					}
				} catch (IOException e1) {
					System.out.println(e1.getMessage());
				} finally {
					try {
						fw.close();
					} catch (IOException e1) {
						System.out.println(e1.getMessage());
					}
				}
				
				//JOptionPane.showMessageDialog(SwingGibon.this, "프레임 종료");
				//실제종료
				System.exit(0);
				super.windowClosing(e);
			}
		});
	}

	private void setDesign() {

		JPanel p = new JPanel();
		tfNamd = new JTextField(4);
		tfAge = new JTextField(3);
		tfAddr = new JTextField(5);
		btnAdd = new JButton("추가");
		
		p.add(new JLabel("이름:"));
		p.add(tfNamd);
		p.add(new JLabel("나이:"));
		p.add(tfAge);
		p.add(new JLabel("주소:"));
		p.add(tfAddr);
		p.add(btnAdd);
		this.add(p,"North");
		
		//table 생성
		model = new DefaultTableModel(new String[] {"이름","나이","주소"},0);	//행 갯수는 추가할 것이므로 초기 0개로 설정
		table = new JTable(model);
		this.add(new JScrollPane(table),"Center");
		
		//버튼 이벤트
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//1. 입력값을 Vector에 넣는다
				Vector<String> data = new Vector<String>();
				data.add(tfNamd.getText());
				data.add(tfAge.getText());
				data.add(tfAddr.getText());
				
				//2. addRow 메소드로 행을 추가한다
				model.addRow(data);
				
				//3. 입력한 값들을 지운다
				tfNamd.setText("");
				tfAge.setText("");
				tfAddr.setText("");
			}
		});
		
	}

	public static void main(String[] args) {
		Ex3_TableFile ex = new Ex3_TableFile("JTable");
	}
}