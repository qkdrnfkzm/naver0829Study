package bit701.day0913;

class Parent{
	public void method1(){
		System.out.println("Parent-method1");
	}
	public void method2() {
		System.out.println("Parent-method2");
	}
}

//상속받는 클래스 구현
class Child extends Parent{
	@Override
	public void method2() {
		System.out.println("Child-method2");
	}
	public void method3() {
		System.out.println("Child-method3");
	}
}


public class Book309 {

	public static void main(String[] args) {
		Child a = new Child();
		a.method1();	//상속받은 메소드
		a.method2();	//Child의 mathod2가 호출
		a.method3();	//Child에만 있는 메소드
		System.out.println("-------------");
		
		Parent b = new Child();
		b.method1();
		b.method2();
		//b.method3();	//오류 : 오버라이드한 메소드만 호출 가능
		
		((Child)b).method3();	//강제로 Child로 형변환 후 호출이 가능하긴 하다
	}

}
