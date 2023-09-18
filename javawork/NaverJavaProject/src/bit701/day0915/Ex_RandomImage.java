package bit701.day0915;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex_RandomImage extends JFrame {
	
	JButton btnCar,btnShop,btnFood,btnEnt;
	String initImage = "D:\\naver0829\\image\\home.jpg";
	Image image;
	MyCanvas myCanvas = new MyCanvas();
	
	
	public Ex_RandomImage(String title) {
		super(title);					//jFrame의 문자열을 받는 생성자를 호출
		this.setLocation(300, 100);		//프레임의 시작 위치
		this.setSize(500,600);			//프레임의 너비, 높이
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
	
	class MyCanvas extends Canvas{
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawImage(image, 50, 50, 400, 400, this);
			
		}
	}
	
	
	private void setDesign() {
		JPanel jp = new JPanel();
		btnCar = new JButton("자동자");
		btnShop= new JButton("쇼핑");
		btnFood = new JButton("음식");
		btnEnt = new JButton("연예인");
		
		jp.add(btnCar);
		jp.add(btnShop);
		jp.add(btnFood);
		jp.add(btnEnt);
		
		this.add(jp,"North");
		
		image = new ImageIcon(initImage).getImage();
		this.add(myCanvas,"Center");
		
		btnCar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int ran = (int)(Math.random()*15)+1;
				String path = "D:\\naver0829\\image\\mycar\\mycar"+ran+".png";
				image = new ImageIcon(path).getImage();
				myCanvas.repaint();
			}
		});
		btnShop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int ran = (int)(Math.random()*34)+1;
				String path;
				if(ran==24) {
					path = "D:\\naver0829\\image\\shop\\"+ran+".gif";
				}else {
					path = "D:\\naver0829\\image\\shop\\"+ran+".jpg";
				}
				image = new ImageIcon(path).getImage();
				myCanvas.repaint();
			}
		});
		btnFood.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int ran = (int)(Math.random()*12)+1;
				String path = "D:\\naver0829\\image\\음식사진\\"+ran+".jpg";
				image = new ImageIcon(path).getImage();
				myCanvas.repaint();
			}
		});
		btnEnt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int ran = (int)(Math.random()*20)+1;
				String path = "D:\\naver0829\\image\\연예인사진 (2)\\"+ran+".jpg";
				image = new ImageIcon(path).getImage();
				myCanvas.repaint();
			}
		});
	}

	public static void main(String[] args) {
		Ex_RandomImage s = new Ex_RandomImage("랜덤 이미지");
				
	}
}
