package bit701.day0904;

import java.util.Scanner;

public class Ex5_RandomWhile {

	public static void main(String[] args) {
		
		/*
		 * 1~100사이의 난수를 발생 후 숫자 알아 맞추기
		 * ex) 65 발생 시
		 * 	1. 60 -> 60보다 큽니다.
		 *	2. 70 -> 70보다 작습니다.
		 *  .
		 *  .
		 *  5. 65 -> 정답입니다(65) -> 맞출경우 종료
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int rad = (int)(Math.random()*100)+1;
		int count = 0;
		int num;
		
		while(true) {
			System.out.print(++count+" : ");
			num=sc.nextInt();
			if(num>rad)	{
				System.out.println("\t"+num+"보다 작습니다.");
			} else if(num<rad)	{
				System.out.println("\t"+num+"보다 큽니다.");
			} else {
				System.out.println("\t정답입니다("+rad+")");
				break;
			}
			
		}
		System.out.println("\n*프로그램 종료*");

	}

}
