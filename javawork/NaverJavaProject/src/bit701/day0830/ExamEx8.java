package bit701.day0830;

public class ExamEx8 {

	public static void main(String[] args) {

		// money 변수에 args[0] 값을 대입 후(급여 : 백만단위 - 5674321)

		/*
		 * 출력 money : 5674321원 만원짜리 : 567장 천원짜리 : 4장 백원짜리 : 3개 십원짜리 : 2개 일원짜리 : 1개
		 * 
		 * 산술연산자를 사용해서 출력해보세요
		 */

		int money = Integer.parseInt(args[0]);

		int a1 = money / 10000;
		int a2 = money % 10000;

		int b1 = a2 / 1000;
		int b2 = money % 1000;

		int c1 = b2 / 100;
		int c2 = money % 100;

		int d1 = c2 / 10;
		int d2 = money % 10;

		System.out.println("월 급여 : " + money + "원");
		System.out.println("만원짜리 : " + a1 + "장");
		System.out.println("천원짜리 : " + b1 + "장");
		System.out.println("백원짜리 : " + c1 + "개");
		System.out.println("십원짜리 : " + d1 + "개");
		System.out.println("일원짜리 : " + d2 + "개");

//		 답안
//		System.out.println("월 급여 : "+money+"원");
//		System.out.println("만원짜리 : "+money/10000+"장");
//		System.out.println("천원짜리 : "+(money%10000)/1000+"장");
//		System.out.println("백원짜리 : "+(money%1000)/100+"개");
//		System.out.println("십원짜리 : "+(money%100)/10+"개");
//		System.out.println("일원짜리 : "+money%10+"개");
		

	}

}
