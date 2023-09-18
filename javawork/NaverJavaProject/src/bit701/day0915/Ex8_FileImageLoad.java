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

public class Ex8_FileImageLoad extends JFrame {
	JButton btnImageFile;
	String initImage="D:\\naver0829\\image\\연예인사진\\soojee.jpg";
	Image image;
	MyCanvas myCanvas = new MyCanvas();
	
	public Ex8_FileImageLoad(String title) {
		super(title);					//jFrame의 문자열을 받는 생성자를 호출
		this.setLocation(300, 100);		//프레임의 시작 위치
		this.setSize(500,600);			//프레임의 너비, 높이
		
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
	
	//Canvas 내부 클래스
	class MyCanvas extends Canvas{
		//처음 시작시 자동호출, 프레임 크기 변경시 자동 호출
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			if(image.getWidth(this)>=300) {
				g.drawImage(image, 40, 10, 400, 450, this);	
			}else {
				g.drawImage(image, 40, 10, this);	
			}
		}
	}
	
	private void setDesign() {
		
		//상단에는 패널안에 버튼 추가 후 프레임에 패널 추가
		JPanel p = new JPanel();
		btnImageFile = new JButton("이미지 파일 가져오기");
		p.add(btnImageFile);
		this.add(p,"North");
		
		//사진을 Image로 변환
		image = new ImageIcon(initImage).getImage();
		this.add(myCanvas,"Center");
		
		btnImageFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FileDialog dlg = new FileDialog(Ex8_FileImageLoad.this,"이미지열기",FileDialog.LOAD);
				dlg.setVisible(true);
				//취소시 종료
				if(dlg.getDirectory()==null) return;
				
				//파일 경로와 파일명 가져오기
				initImage=dlg.getDirectory()+dlg.getFile();
				//image 생성
				image = new ImageIcon(initImage).getImage();
				//캔바스의 paint 메소드는 버튼을 누른다고 자동호출 되지 않는다
				//그래서 강제로 재호출을 해줘야 한다
				myCanvas.repaint();
			}
		});
	}

	public static void main(String[] args) {
		Ex8_FileImageLoad s = new Ex8_FileImageLoad("이미지 뷰어");
	}
}
