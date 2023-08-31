package bit701.day0831;

import java.util.Date;
import java.util.Scanner;

public class Ex2_KeyInput {

	public static void main(String[] args) {
		
		//Date 클래스를 이용해서 현재 년도를 구해보자(jdk1.1에서 deprecate 되었지만 여전히 많이 사용함)
		//권장 : Calendar를 권장
		Date date = new Date();
		int curYear=date.getYear()+1900;
		System.out.println("현재년도 : "+curYear);
		
			
		Scanner sc=new Scanner(System.in);
		
		System.out.println("당신이 태어난 년도는?");
		int birtYear = Integer.parseInt(sc.nextLine());
		
		System.out.println("당신의 거주지는?");
		String address=sc.nextLine();
		
		//나이 구하기
		int age=curYear-birtYear;
		System.out.println("나는 "+address+"에 사는, "+birtYear+"년생("+age+"세) 입니다.");
		System.out.printf("나는 %s에 사는, %d년생(%d세) 입니다.\n",address,birtYear,age);
		
		//20세 이상이면 "성인", 미만이면 "미성년자"라는 글자를 출력
		//if문 또는 조건(삼항)연산자 ex)조건식?참일때값:거짓일때값
		String msg=age>=20?"성인":"미성년자";
		
		
		String msg1="";
		//지역변수는 자동초기화가 안되고 쓰레기값이 들어있으므로
		//값이 안들어갈 경우를 대비해서 초기값을 지정하는것이 좋다.
		//지역변수는 그 구역을 빠져 나가게 되면 자동 소멸되므로 사용이 불가능하다. 
		if (age>=20) {	//한문장만 쓸경우 {} 구역설정 생략 가능하지만 두문장 이상일 경우 반드시 구역설정
			msg1="성인";
		}else {
			msg1="미성년자";
		}
				
		System.out.println("당신은 "+msg+"입니다.");		//삼항연산자 사용 출력
		System.out.println("당신은 "+msg1+"입니다.");		//if문 사용 출력
		
	}

}
