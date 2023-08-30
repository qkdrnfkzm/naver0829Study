package bit701.day0830;

public class AsciiEx3 {

	public static void main(String[] args) {
		//char, int는 같은 타입이라고 봐도 된다.
		//ASCIICode내 숫자
		char a1=65;
		int a2='B';
		
		System.out.println(a1); 		//A
		System.out.println(a2); 		//66
		System.out.println((int)a1);	//65
		System.out.println((char)a2);	//B
		System.out.printf("%d의 아스키문자는 %c이다\n",(int)a1,a1);
		
		
		char b1 = 'C';
		int b2 = 68;
		
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b1+1);		// D가 나오지 않고 68로 출력되는 이유 -> 묵시적 형변환에 의해서 char+int=int, 그러므로 D가 아닌 68이 출력됨
		/*
		 * 묵시적 형변환 ( +는 실제 더하기만 의미하는게 아닌 연산을 의미함)
		 * char + int = int
		 * int + int = int
		 * long + int = long
		 * double + int = double
		 * String + int = String
		 * String + double = String
		 * 		
		*/		
		
		/*
		print, println은 모든 타입 출력이 가능하다. 
		이유는 타입 별로 여러 개를 같은 이름으로 만들어 놨기 때문이다.
		이러한 메서드를 중복 함수(overloding method)라고 한다.
		*/
		
		System.out.println((char)(b1+1)); // b1+1=68로 int 타입이지만 char로 강제 형변환해서 출력
		
		System.out.println(5/2);	//값 = 2 / int와 int의 연산이므로 무조건 결과는 int타입으로 나온다.
		System.out.println(5.0/2);	//값 = 2.5 / double과 int의 연산이므로 결과는 double
		System.out.println((double)5/2);	//2.5
		System.out.println((double)(5/2));	//2.0 - int+int=int의 결과물을 double로 변환하기 때문에 형변환을 해도 결과는 2.0		
	}	
}
