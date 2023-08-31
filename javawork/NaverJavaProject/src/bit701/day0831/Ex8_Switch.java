package bit701.day0831;

import java.util.Scanner;

	//Switch 문은 jdk8 이전까지는 정수, 문자만 가능했으나
	//그 이후 문자열도 가능해졌다.

public class Ex8_Switch {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//숫자를 입력받아 1:one, 2:two, 3:three 그 이외 : other number
//		System.out.println("숫자를 입력해주세요");
//		int num=sc.nextInt();
		
		//switch는 num값에 따라 해당 case실행
		//단, braek가 없을경우 끝까지 실행됨
//		switch (num) {
//		case 1:
//			System.out.println("one");
//			break;	//해당 조건을 만족한 경우 switch문늘 빠져 나간다.
//		case 2:re
//			System.out.println("two");
//			break;	//해당 조건을 만족한 경우 switch문늘 빠져 나간다.
//		case 3:
//			System.out.println("three");
//			break;	//해당 조건을 만족한 경우 switch문늘 빠져 나간다.
//		default:
//			System.out.println("other number");
//		}

		System.out.println("영문 색상명을 입력하세요");
		String color = sc.nextLine();
		
		switch (color) {
		case "red":
		case "RED":
			System.out.println(color+": 빨강색");
			break;
		case "green":
		case "Green":
			System.out.println(color+": 초록색");
			break;
		case "pink":
		case "PINK":
			System.out.println(color+": 분홍색");
			break;
		default:
			System.out.println(color+": 그 이외의 색");
			break;
		}
		
	}

}
