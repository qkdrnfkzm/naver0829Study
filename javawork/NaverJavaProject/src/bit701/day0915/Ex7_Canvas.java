package bit701.day0915;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Ex7_Canvas extends JFrame {
	
	//캔버스를 멤버 변수로 선언
	MyCanvas myCanvas = new MyCanvas();
	
	public Ex7_Canvas(String title) {
		super(title);					//jFrame의 문자열을 받는 생성자를 호출
		this.setLocation(300, 100);		//프레임의 시작 위치
		this.setSize(500,500);			//프레임의 너비, 높이
		
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
	
	//캔버스 내부 클래스
	class MyCanvas extends Canvas{
		
		String imageIcon = "D:\\naver0829\\workstudy\\webwork\\이쁜동물이미지\\C7.png";
		
		@Override
		public void paint(Graphics g) {
			
			super.paint(g);
			//테두리만 있는 원그리기
			g.setColor(new Color(255,100,180));	//선 색상
			g.drawOval(50, 50, 100, 100);		
			
			//채워진 원
			g.setColor(Color.ORANGE);
			g.fillOval(200, 50, 100, 100);
			
			//테두리만 있는 사각형
			g.setColor(Color.pink);
			g.drawRect(50, 200, 100, 100);
			
			//채워진 사각형
			g.setColor(new Color(200,100,100));
			g.fillRect(200, 200, 100, 100);
			
			Image image1 = new ImageIcon(imageIcon).getImage();
			//이미지 그리기
			g.drawImage(image1, 300, 220,this);
			//크기변경해서 출력
			g.drawImage(image1, 300, 30, 100, 100, this);
		}
	}
	
	private void setDesign() {
		this.add(myCanvas,"Center");
		
	}

	public static void main(String[] args) {
		Ex7_Canvas s = new Ex7_Canvas("캔버스");
	}
}
