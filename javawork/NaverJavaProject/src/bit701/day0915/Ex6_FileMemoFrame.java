package bit701.day0915;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ex6_FileMemoFrame extends JFrame {
	
	JTextArea memoArea;
	JButton btnSave, btnOpen, btnClear;
	
	public Ex6_FileMemoFrame(String title) {
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
	
	private void setDesign() {
		
		btnSave = new JButton("파일저장");
		btnOpen = new JButton("파일열기");
		btnClear = new JButton("내용지우기");
		
		JPanel p = new JPanel();
		p.add(btnSave);
		p.add(btnOpen);
		p.add(btnClear);
		
		//Panel을 North에 추가
		this.add(p,"North");
		
		memoArea = new JTextArea("내용을 입력해 보세요");
		//this.add(memoArea,"Center");	//데이터가 길 경우 스크롤바가 생기지 않음
		this.add(new JScrollPane(memoArea),"Center");
		
		//버튼 : 내용지우기
		btnClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				memoArea.setText("");
			}
		});
		
		//버튼 : 파일저장
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FileDialog dlg = new FileDialog(Ex6_FileMemoFrame.this,"메모장저장",FileDialog.SAVE);
				dlg.setVisible(true);
//				System.out.println("디렉토리 : "+dlg.getDirectory());
//				System.out.println("파일명 : "+dlg.getFile());
				
				//취소시 메소드 종료
				if(dlg.getDirectory()==null) return;
				
				String fileName = dlg.getDirectory()+dlg.getFile()+".txt";
				String memoText = memoArea.getText();	//저장할 내용
				
				FileWriter fw = null;
				try {
					fw = new FileWriter(fileName);
					fw.write(memoText);
					//메모장에 메시지 넣기
					memoArea.setText("저장되었습니다");
				} catch (IOException e1) {
					System.out.println(e1.getMessage());
				}finally {
					try {
						fw.close();
					} catch (NullPointerException|IOException e2) {
						//close시 나올만한 Exception 두개 나열
					}
				}
			}
		});
		
		//버튼 : 파일열기
		btnOpen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FileDialog dlg = new FileDialog(Ex6_FileMemoFrame.this,"메모장 불러오기",FileDialog.LOAD);
				dlg.setVisible(true);
				
				//취소시 메소드 종료
				if(dlg.getDirectory()==null) return;
				
				String fileName = dlg.getDirectory()+dlg.getFile();
				FileReader fr=null;
				BufferedReader br = null;
				
				//메모장의 기존 내용 지우기
				memoArea.setText("");
				try {
					fr = new FileReader(fileName);
					br = new BufferedReader(fr);
					while(true) {
						String line = br.readLine();
						if(line==null) {
							break;
						}
						memoArea.append(line+"\n");
					}
				} catch (IOException e1) {
					System.out.println(e1.getMessage());
				}finally {
					try {
						br.close();
						fr.close();
					} catch (IOException|NullPointerException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
	}//setDesign()

	public static void main(String[] args) {
		Ex6_FileMemoFrame s = new Ex6_FileMemoFrame("간단한 메모장");
	}
}
