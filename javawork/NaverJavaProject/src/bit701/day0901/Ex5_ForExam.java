package bit701.day0901;

import java.util.Scanner;

public class Ex5_ForExam {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int a,sum;
		//1. 숫자 n을 입력받은 후 1부터 n 까지의 총 합계를 출력하시오
				
		System.out.println("합계를 구할 숫자를 입력하세요");
		a = sc.nextInt();
		sum=0;
		for(int i=1;i<=a;i++)
		{
			sum+=i;
		}
		System.out.println("1부터 "+a+"까지의 합은 "+sum+"입니다\n");
		
		
		
		//2. 구구단 숫자 2~9사이의 숫자를 입력 받은 후 범위를 벗어날 경우
		//	"잘못 입력하여 종료합니다" 라고 출력 후 종료
		//	정상적으로 입력시 해당 구구단 출력
		//	ex)	**5단**
		//		5 X 1 = 5
		//		.
		//		.
		//		5 X 9 = 45
		
		int dan;
		
		System.out.println("구구단을 출력 할 숫자를 입력하세요");
		dan=sc.nextInt();
		if(dan>9 || dan<2) 
		{
			System.out.println("잘못된 숫자를 입력하여 종료합니다.");
			return;
		}
		System.out.println("\t**"+dan+"단**");
		for(int j=1;j<=9;j++)
		{
			System.out.printf("%8d X %d = %d\n",dan,j,dan*j);
		}		
		

	}

}
