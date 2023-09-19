package bit701.day0919;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ex4_ServerChat extends JFrame implements Runnable {

	JTextArea area;
	// 접속하는 클라이언트들을 저장할 Vector
	Vector<ClientMember> listMember = new Vector<ClientMember>();

	public Ex4_ServerChat() {

		super("채팅서버");
		this.setBounds(700, 100, 400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDesign();
		this.setVisible(true);
	}

	// 1번 쓰레드의 run 메소드
	@Override
	public void run() {
		// 서버소켓 생성
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(6000);
			area.append("서버 소켓 생성 성공!\n");
			while (true) { // 쓰레드 생성 후 쓰레드 내에서 반복
				// 대기중이다가 접속요청하는 클라이언트 혀용, 허용이 되면 Socket이 만들어진다
				Socket socket = serverSocket.accept();
				// 허용된 클라이언트들을 벡터에 추가한다
				ClientMember clientMember = new ClientMember(socket);
				listMember.add(clientMember);
				// 각 클라이언트들의 run메소드 호출
				clientMember.start();

				area.append("접속허용 IP : " + socket.getInetAddress().getHostAddress() + "\n");
				this.autoScroll();
			}
		} catch (IOException e) {
			area.append("서버 소켓 생성 실패 : " + e.getMessage());
		}
	}

	// 접속한 클라이언트와 대화를 주고 받을 내부 클래스
	class ClientMember extends Thread {

		Socket mySocket;
		BufferedReader br;
		PrintWriter pw;
		String nickName;

		public ClientMember(Socket socket) {
			mySocket = socket;
			// 대화를 주고 받을 수 있게 io 클래스 얻기
			InputStream is = null;
			try {
				is = mySocket.getInputStream();
				br = new BufferedReader(new InputStreamReader(is));
				pw = new PrintWriter(mySocket.getOutputStream());
			} catch (IOException e) {
//				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			// 언제 클라이 언트들이 메시지를 보낼지 모르니까 while문을 열어 놓는다
			while (true) {
				try {
					String message = br.readLine();
					// 처음 접속시 : 1|닉네임 / 메세지 : 2|메세지
					String[] arr = message.split("\\|");
					System.out.println(arr[0] + ", " + arr[1]);

					switch (arr[0]) {
					case "1": {
						this.nickName = arr[1];
						// 접속한 모든 클라이언트들한테 누가입장했는지 알린다
						for (ClientMember mem : listMember) {
							mem.pw.println(this.nickName + ">> 님이 입장하였습니다\n");
							mem.pw.flush(); // 이떄 비로소 전성 된다
						}
						break;
					}
					case "2": {
						// 보낸 메세지가 arr[1]에 들어있따
						// 접속한 모든 클라이언트들한테 누가 어떤 메세지를 보냈는지 알린다
						for (ClientMember mem : listMember) {
							mem.pw.println(this.nickName + ">>" + arr[1] + "\n");
							mem.pw.flush(); // 이떄 비로소 전성 된다
						}
						break;
					}
					}
				} catch (IOException|ArrayIndexOutOfBoundsException e) {
				}
			}
		}
	}

	public void autoScroll() {
		int n = area.getDocument().getLength(); // area 의 총 라인수
		area.setCaretPosition(n); // 마지막 줄로 커서 위치 변경
	}

	private void setDesign() {
		area = new JTextArea();
		this.add(new JScrollPane(area));
	}

	public static void main(String[] args) {
		Ex4_ServerChat severChat = new Ex4_ServerChat();
		Thread th = new Thread(severChat);
		th.start(); // 1번 run 메소드 호출
	}
}
