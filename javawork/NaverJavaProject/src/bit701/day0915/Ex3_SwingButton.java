package bit701.day0915;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex3_SwingButton extends JFrame implements ActionListener{
	
	JButton btn1, btn2;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn1) {
			System.out.println("버튼 1클릭");
			this.getContentPane().setBackground(Color.cyan);
		}else {
			System.out.println("버튼 2클릭");
			this.getContentPane().setBackground(Color.magenta);
		}
	}
	
	public Ex3_SwingButton(String title) {
		super(title);					//jFrame의 문자열을 받는 생성자를 호출
		this.setLocation(300, 100);		//프레임의 시작 위치
		this.setSize(300,300);			//프레임의 너비, 높이
		//this.getContentPane().setBackground(new Color(200,244,211));
		
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
	
	private void setDesign() {
		btn1 = new JButton("버튼 #1");	//버튼 생성
		this.add(btn1,"South");		//BorderLayout(기본) 인 경우는 위치를 지정해야함, North, South, East, West, Center
		
		btn2 = new JButton("버튼 #2");
		this.add(btn2,"North");
		
		//버튼1,2에 이벤트가 발생되도록 추가해보자
		btn1.addActionListener(this);		//()의 this는 이벤트 메소드가 구현된 클래스의 인스턴스
		btn2.addActionListener(this);		//둘다 같은 이벤트 메소드가 호출된다
	}

	public static void main(String[] args) {
		Ex3_SwingButton s = new Ex3_SwingButton("버튼");
	}
}