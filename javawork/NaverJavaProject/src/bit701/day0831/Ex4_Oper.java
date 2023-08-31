package bit701.day0831;

import java.util.Scanner;

public class Ex4_Oper {

	public static void main(String[] args) {
		
		//점수를 입력받아 90점 이상이면 "A", 80점 이상은 "B", 70점 이상은 "C", 60점 이상은 "D", 나머지는 "F"
		//99 입력시 "99점은 A학점입니다"
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("점수를 입력하세요");
		int score = sc.nextInt();
		if (score<1 || score>100) {
			System.out.println("잘못된 점수를 입력하였습니다");
			return;
		}
		
		
		String grade="";
		
		
		//if문
		if(score>=90) {
			grade="A";
		}else if(score>=80) {
			grade="B";
		}else if(score>=70) {
			grade="C";
		}else if(score>=60) {
			grade="D";
		}else {
			grade="F";
		}
		System.out.println(score+"점은 "+grade+"학점입니다.");
		
		
		//조건연산자
		grade=score>=90?"A":score>=80?"B":score>=70?"C":score>=60?"D":"F";
		System.out.printf("%d점은 %s학점입니다.",score, grade);

	}

}
