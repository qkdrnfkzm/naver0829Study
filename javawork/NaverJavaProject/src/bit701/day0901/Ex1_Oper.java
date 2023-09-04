package bit701.day0901;

public class Ex1_Oper {

	public static void main(String[] args) {
		
		//대입연산자 : =, +=, -=, *=, /=, %=
		//디입연산자나 증감연산자를 이용시 해당 변수는 반드시 값이 들어있어야 한다.
		
		int a=5;

		//a=a+3;
		a+=3;	//위의 수식과 같다
		System.out.println(a);	//8
		
		a-=1;	//a--와 같다
		System.out.println(a);	//7
		
		a*=5;
		System.out.println(a);	//35
		
		a/=3;
		System.out.println(a);	//11

		a%=4;
		System.out.println(a);	//3

	}

}
