package bit701.day0831;

import java.util.Calendar;
import java.util.Scanner;

public class Ex9_SwitchWeek {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//년도와 월을 입력하면 몇일까지 있는지 출력해보자
		//일단 해당 년도가 윤년인지 아닌지부터 판단해보자
		
		System.out.println("년도 4자리수 입력");
		int year = sc.nextInt();
		
		System.out.println("월(1~12) 입력");
		int month = sc.nextInt();
		
		//잘못된 값을 입력한 경우 종료
		if (month<1 || month>12) {
			System.out.println("월을 잘못 입력했습니다");
			return;
		}
		
		System.out.printf("입력한 년도와 월 : %d년 %d월\n\n",year,month);
		int days=0;
		boolean b=year%4==0 && year%100!=0 || year%400==0;
		
		if (b)System.out.println("윤년");	//조건에서 true는 생략 가능 ex) b==true -> b
		else System.out.println("평년");
		
		switch (month) {
		case 2:
			days=b?29:28;	//b가 true(윤년)이면 2월이 29일, false(평년)면 28일
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			days=30;
			break;		
		default:
			days=31;
			break;
		}
		
		System.out.printf("%d년 %d월은 %d일까지 있습니다\n\n", year,month,days);
			
		
		System.out.println(year+"년 "+month+"월 달력");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		
		
		
		
		
		
		
		Calendar cal = Calendar.getInstance();
		
		
		
	}

}
