package bit701.day0904;

import java.util.Random;

public class Ex4_Random {

	public static void main(String[] args) {
		
		Random r = new Random();
		
		//0~9
		for(int i=0;i<5;i++)
		{
			int n = r.nextInt(10);	//0~9까지의 난수 발생
			System.out.println(n);
		}
		System.out.println("=".repeat(30));
		
		//1~100
		for(int i=0;i<5;i++)
		{
			int n = r.nextInt(100)+1;	//1~100까지의 난수 발생
			System.out.println(n);
		}
		System.out.println("=".repeat(30));
		
		//A~Z
		for(int i=0;i<5;i++)
		{
			int n = r.nextInt(26)+65;	//1~100까지의 난수 발생
			System.out.println((char)n);
		}
		System.out.println("=".repeat(30));

	}

}
