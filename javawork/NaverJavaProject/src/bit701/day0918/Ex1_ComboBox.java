package bit701.day0918;

import java.awt.Color;
import java.awt.Font;
import java.awt.datatransfer.Clipboard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Ex1_ComboBox extends JFrame {

	JPanel p = new JPanel();
	JComboBox<String> combo;
	JRadioButton rbYellow, rbMagenta, rbGray, rbBlue;
	JLabel lblMessage;

	public Ex1_ComboBox(String title) {
		super(title);
		this.setBounds(1000,100,400,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//프레임 종료 시키는 메소드
		this.setDesign();
		this.setVisible(true);

	}

	private void setDesign() {
		Vector<String> list = new Vector<String>();
		list.add("빨강");
		list.add("초록");
		list.add("분홍");
		list.add("주황");

		//콤보박스 생성
		combo = new JComboBox<String>(list);
		//상단에 추가
		//this.add(combo,"North");	//상단에 전체 추가

		JPanel pTop = new JPanel();
		pTop.add(combo);
		this.add(pTop,"North");
		
		//p 패널에 라벨 추가
		lblMessage = new JLabel("Have a Nice Day");
		lblMessage.setFont(new Font("Comic Sans MS",Font.BOLD,30));
		p.add(lblMessage);
		

		//Center에는 JPanel p 를 추가
		p.setBackground(Color.red);
		this.add(p,"Center");

		//콤보박스 이벤트
		combo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				//선택한 문자열을 얻어보자
				String selectColor = (String)combo.getSelectedItem();
//				System.out.println(selectColor);

				switch (selectColor) {
				case "빨강": {
					p.setBackground(Color.red);
					break;
				}
				case "초록": {
					p.setBackground(Color.green);
					break;
				}
				case "분홍": {
					p.setBackground(Color.pink);
					break;
				}
				case "주황": {
					p.setBackground(Color.orange);
					break;
				}
				}
			}
		});
		
		//하단의 4개의 라디오 버튼 추가하기
		ButtonGroup bg = new ButtonGroup();
		rbYellow = new JRadioButton("노랑");
		rbMagenta = new JRadioButton("핫핑크");
		rbGray = new JRadioButton("회색");
		rbBlue = new JRadioButton("파랑");
		
		bg.add(rbYellow);
		bg.add(rbMagenta);
		bg.add(rbGray);
		bg.add(rbBlue);
		
		JPanel pBottom = new JPanel();
		pBottom.add(rbYellow);
		pBottom.add(rbMagenta);
		pBottom.add(rbGray);
		pBottom.add(rbBlue);
		
		this.add(pBottom,"South");
		
		//글자색 변경 이벤트(배열이 아니므로 각각 이벤트 추가)
		rbYellow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblMessage.setForeground(Color.yellow);
			}
		});
		rbMagenta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblMessage.setForeground(Color.magenta);
			}
		});
		rbGray.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblMessage.setForeground(Color.gray);
			}
		});
		rbBlue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblMessage.setForeground(Color.blue);
			}
		});
		
		
		
		
		
		
		
		
	}

	public static void main(String[] args) {

		Ex1_ComboBox ex = new Ex1_ComboBox("ComboBox");

	}

}
