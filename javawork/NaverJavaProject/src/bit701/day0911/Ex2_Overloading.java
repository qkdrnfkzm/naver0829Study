package bit701.day0911;

//Overloading Method : 메소드 명은 "반드시" 같아야 하고, 인자는 "반드시" 달라야 한다
class Apple{
	public static int sum(int a, int b) {
		System.out.println(1);
		return a+b;
	}
	public static int sum(int s1, int s2, int s3) {
		return s1+s2+s3;
	}
	public static double sum(double a, double b) {
		return a+b;
	}
	public static String sum(String a, String b) {
		return a+b;
	}
	public static String sum(String a, int b) {
		return a+b;
	}

	// ... Variable Argument
	public static int sum(int...n) {	//n은 배열타입 / 숫자 갯수 상관없이 int 배열타입으로 받는다
		System.out.println("총 "+n.length);
		return 0;
		
	}
}


public class Ex2_Overloading {
	public static void main(String[] args) {
		int s1 = Apple.sum(5,7);
		System.out.println(Apple.sum(s1));
		System.out.println(Apple.sum("apple","orange"));
		System.out.println(Apple.sum(1.2,4.5));
		System.out.println(Apple.sum("orange",7));
		//	System.out.println(Apple.sum(7,"orange")); //오류 : 매개변수가 int, String 생성자는 없다
		System.out.println(Apple.sum(1,3,5));
		//System.out.println(Apple.sum(1,3,5,8));	//오류 : 인자가 4개인 생성자는 없음
		
		//Variable Argument 출력
		System.out.println(Apple.sum(1,2,3,4,5,6,7,8,9,10));
	}
}