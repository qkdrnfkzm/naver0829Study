package bit701.day0915;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex4_SwingButton extends JFrame {
	
	JButton btn1, btn2, btn3;
	
	public Ex4_SwingButton(String title) {
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
	
	//버튼 이벤트를 이번에는 내부클래스로 만들어보자
	class MyColorButton implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btn1) {
				Ex4_SwingButton.this.getContentPane().setBackground(Color.orange);
			}else {
				Ex4_SwingButton.this.getContentPane().setBackground(Color.magenta);
			}
		}
	}
	
	private void setDesign() {
		//자바에서 제공하는 레이아웃을 안쓰고 직접 위치 지정을 할 경우
		this.setLayout(null);
		
		//버튼1 생성
		btn1 = new JButton("오렌지색");
		btn1.setBounds(20, 50, 100, 50);	//x, y, width, height
		this.add(btn1);
		
		//버튼2 생성
		btn2 = new JButton("분홍색");
		btn2.setBounds(130,50,100,50);
		this.add(btn2);
		
		//버튼 1,2는 내부 클래스 MyColorButton의 이벤트를 호출해보자
		btn1.addActionListener(new MyColorButton());
		btn2.addActionListener(new MyColorButton());
		
		//버튼 3은 익명 내부클래스로 이벤트 발생
		//버튼 3 생성
		btn3 = new JButton("버튼 글자색 변경");
		btn3.setBounds(40,130,180,50);
		this.add(btn3);
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btn1.setBackground(Color.green);
				btn1.setForeground(Color.red);
				
				btn2.setBackground(Color.black);
				btn2.setForeground(Color.yellow);
				
				btn3.setBackground(Color.cyan);
				btn3.setForeground(Color.blue);
			}
		});
	}

	public static void main(String[] args) {
		Ex4_SwingButton s = new Ex4_SwingButton("안녕");
	}
}