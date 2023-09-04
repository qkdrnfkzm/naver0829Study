package bit701.day0901;

import java.util.Iterator;

public class Ex4_BreakContinue {

	public static void main(String[] args) {

		for(int a=1;a<=10;a++)
		{
			System.out.printf("%3d",a);
			if(a==5) {		//if문을 활용하여 반복문을 빠져나간다
				break;
			}
		}
		System.out.println();
		System.out.println("-".repeat(30));

		
		for(int a=1;a<=10;a++)
		{
			if(a%2==0) {	//짝수일 경우 출력하지 않고 다음 반복으로 가고자 할 경우
				continue;	//a++ 증감식으로 이동
			}
			System.out.printf("%3d",a);
		}
		System.out.println();
		System.out.println("-".repeat(30));
		
		
//		위 반복문과 동일
//		for(int a=1;a<=10;a+=)
//		{
//			System.out.printf("%3d",a);
//		}
//		System.out.println();
//		System.out.println("-".repeat(30));
		
		
		//다중 for문일 경우 한번에 2개의 반복문을 빠져나가고자 할 경우
		Exit:
			for(int i=1;i<=3;i++)
			{
				System.out.println("i="+i);
				for(int j=1;j<=5;j++)
				{
					System.out.printf("%3d",j);
					if(j==3) break Exit;
				}
				System.out.println();
			}
			System.out.println("-".repeat(30));
		
	}

}
