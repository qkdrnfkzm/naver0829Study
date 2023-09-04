package bit701.day0901;

import java.util.Iterator;

public class Ex3_For {

	public static void main(String[] args) {
		
		for(int a=1;a<0;a++) {				//초기값이 1인데 조건이 0보다 작을경우 반복하므로 한번도 실행하지 안음
			System.out.println("a="+a);
		}
		System.out.println("=".repeat(30));	//"="을 30번 반복
		
		
		for(int a=1;a<=10;a++)
			System.out.printf("%3d",a);
		System.out.println();
		System.out.println("=".repeat(30));
		
		
		for(int a=1;a<20;a+=3)				// 증감식에 대입연산자 사용 가능
			System.out.printf("%3d",a);
		System.out.println();
		System.out.println("=".repeat(30));
		
		
		for(int a=10;a>=1;a--)
			System.out.printf("%3d",a);
		System.out.println();
		System.out.println("=".repeat(30));
		
		
		//다중 for문
		for(int i=1;i<=3;i++) 
		{
			System.out.println("i="+i);
			
			for(int j=1;j<=5;j++)
			{
				System.out.printf("%3d",j);
			}
			
			System.out.println();
		}
		
	}

}
