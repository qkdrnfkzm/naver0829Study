package bit701.day0915;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex5_ArrayButton extends JFrame {
	
	JButton[] btn = new JButton[6];
	String[] buttonTitle = {"노랑","오렌지","분홍","핫핑크","초록","빨강"};
	Color[] buttonColor = {Color.yellow,Color.orange,Color.pink,Color.magenta,Color.green,Color.red};
	
	
	public Ex5_ArrayButton(String title) {
		super(title);					//jFrame의 문자열을 받는 생성자를 호출
		this.setLocation(300, 100);		//프레임의 시작 위치
		this.setSize(300,300);			//프레임의 너비, 높이
		this.getContentPane().setBackground(new Color(200,244,211));
		
		//디자인이나 이벤트를 구현할 메소드 호출
		this.setDesign();
		
		this.setVisible(true);			//true : 프레임 보이기, false : 프레임 숨기기
		
		//윈도우 이벤트 발생
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {	//윈도우 창에 X버튼 클릭시 호출되는 메소드
				//JOptionPane.showMessageDialog(SwingGibon.this, "프레임 종료");
				//실제종료
				System.exit(0);
				super.windowClosing(e);
			}
		});
	}
	class MyButton implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			for (int i = 0; i < btn.length; i++) {
				if(e.getSource()==btn[i]) {
					Ex5_ArrayButton.this.getContentPane().setBackground(buttonColor[i]);
				}
			}
		}
	}
	
	private void setDesign() {
		//레이아웃 변경
		this.setLayout(new FlowLayout());		//순서대로 나열
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new JButton(buttonTitle[i]);
			btn[i].setBackground(buttonColor[i]);
			this.add(btn[i]);
			
			//버튼 이벤트 발생
			btn[i].addActionListener(new MyButton());
		}
	}

	public static void main(String[] args) {
		Ex5_ArrayButton s = new Ex5_ArrayButton("배열버튼");
		
	}
}
