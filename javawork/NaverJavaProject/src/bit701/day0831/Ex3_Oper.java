package bit701.day0831;

import java.util.Scanner;

public class Ex3_Oper {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//점수를 입력 받아서 1~100점이 아닌 경우는 프로그램종료
		//90이상은 "합격", 80이상은 "재시험", 나머지는 "불합격"
		
		System.out.println("점수를 입력하세요");
		int score = sc.nextInt();
		
		if (score<1 || score>100) {
			System.out.println("잘못된 값 입력으로 종료합니다!");
			return;		//return은 원래 해당 메서드만 종료하는 명령어인데 main메서드 종료는 곧 프로그램 종료를 의미한다.
		}
		System.out.println("입력된 점수는 "+score+"점 입니다.");
		
		String msg="";
		
		//if문
		if(score>=90) {
			msg="합격";
		}else if(score>=80) {
			msg="재시험";
		}else {
			msg="불합격";
		}
		System.out.println("결과 : "+msg);
		
		//삼항연산자
		msg=score>=90?"합격":score>=80?"재시험":"불합격";
		System.out.println("결과 : "+msg);

	}

}
