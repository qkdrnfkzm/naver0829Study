package bit701.day0901;

import java.util.Scanner;

public class Ex6_ForExam {

	public static void main(String[] args) {

		/*구구단을 출력할 시작 단 입력
		 * 4
		 * 구구단을 출력할 끝단 입력
		 * 6
		 * 
		 * ex)
		 * 		4단		5단		6단			//단일 for문
		 * 		4X1=4	5X1=5	6X1=6		//다중 for문
		 * 		4X2=8	5X2=10	6X2=12
		 * 		.
		 * 		.
		 * 		.
		 * 		4X9=36	5X9=45	6X9=54
		 * 	
		*/	
		Scanner sc = new Scanner(System.in);
		int start,end;
		
		System.out.println("구구단을 출력할 시작 단 입력");
		start=sc.nextInt();
		System.out.println("구구단을 출력할 끝 단 입력");
		end=sc.nextInt();
		
		
		//스타트가 엔드보다 클 경우 두 변수의 값을바꿔보자
		if(start>end)
		{
			int temp=start;
			start=end;
			end=temp;	
		}
		
		
		for(int dan=start;dan<=end;dan++)
		{
			System.out.printf("%4d단\t\t",dan);
		}
		System.out.println();
				
		for(int i=1;i<=9;i++)
		{
			for(int dan=start;dan<=end;dan++)
			{
				System.out.printf("%d X %d = %d\t",dan,i,dan*i);
			}
			System.out.println();
		}
		
		
		


	}

}
