package bit701.day0919;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ex3_Book828_Network {

	public static void main(String[] args) throws UnknownHostException {

		// 자기 컴퓨터의 ip와 컴퓨터이름을 알고자 할떄
		InetAddress local = InetAddress.getLocalHost();
		System.out.println("내 컴퓨터의 ip 주소 : " + local.getHostAddress());
		System.out.println("내 컴퓨터의 이름 : " + local.getHostName());
		System.out.println();

		// naver 서버의 ip를 알고자 할 경우
		InetAddress[] naverArr = InetAddress.getAllByName("www.naver.com");
		for (InetAddress inet : naverArr) {
			System.out.println("네이버 : " + inet.getHostAddress());
		}
		System.out.println();

		// google 서버의 ip를 알고자 할 경우
		InetAddress[] googleArr = InetAddress.getAllByName("www.google.com");
		for (InetAddress inet : googleArr) {
			System.out.println("구글 : " + inet.getHostAddress());
		}
		System.out.println();

		// nate 서버의 ip를 알고자 할 경우
		InetAddress[] nateArr = InetAddress.getAllByName("www.nate.com");
		for (InetAddress inet : nateArr) {
			System.out.println("네이트 : " + inet.getHostAddress());
		}
	}
}
