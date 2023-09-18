package bit701.day0914;

import java.util.Scanner;

//사용자 정의 예외 클래스 생성
class NickNameException extends Exception{
	public NickNameException(String msg) {
		super(msg);
	}
}
//-------------------------------------------------------
public class Ex4_UserException {
	public static void dataInput() throws NickNameException, InterruptedException{
		Scanner sc = new Scanner(System.in);
		String nickName;
		System.out.println("닉네임이 무엇인가요");
		nickName = sc.nextLine();
		if(nickName.equals("바보") || nickName.equals("멍충이")){
			throw new NickNameException("고운말을 씁시다");	//강제로 예외 발생
		}
		Thread.sleep(1000);		//1초 후 출력
		System.out.println("당신의 닉네임은 "+nickName+"입니다");
	}
	
	public static void main(String[] args) throws InterruptedException {
		try {
			dataInput();
		} catch (NickNameException e) {
			System.out.println(e.getMessage());
		}
	}
}
