package bit701.day0918;

//자바에서의 함수형 프로그램인 람다 표현식은 인터페이스를 사용하는 익명 내부클래스의 또다른 표현식이다.
//단, 인터페이스는 단 하나의 추상 메서드만 가지고 있어야 한다

@FunctionalInterface
interface Orange{
	public void write();
	//public void show();	//@FunctionalInterface : 메소드가 하나인지 아닌지 검증하는 역할	

}

interface addData{
	public void add(int x, int y);
}


public class Ex4_Lambda {

	//우리가 알고 있는 익명 내부 클래스 형태로 객체를 생성해보자
	public void abstMethod1() {

		Orange or = new Orange() {

			@Override
			public void write() {
				System.out.println("안녕하세요");
			}
		};
		or.write();
	}

	//람다식으로 오버라이드
	public void abstMethod2() {
		Orange or = ()->System.out.println("반갑습니다");	//메소드의 코드가 한줄일 경우 {} 생략
		or.write();

		//오버라이드 메소드의 코드가 2줄 이상일 경우 {} 안에서 주면 된다
		Orange or2 = ()->{
			System.out.println("람다람다");
			System.out.println("여러줄 썻어요");
		};
		or2.write();
	}

	//람다식으로 오버라이드
	public void abstMethod3() {
		
		//기존 방식
		addData ad1 = new addData() {
			@Override
			public void add(int x, int y) {
				System.out.println(x+"+"+y+"="+(x+y));
			}
		};
		ad1.add(100,200);
		
		//람다식으로 변경
		addData ad2 = (int x, int y) -> System.out.println(x+"+"+y+"="+(int)(x+y));
		ad2.add(200,300);

	}

	public static void main(String[] args) {
		Ex4_Lambda ex = new Ex4_Lambda();
		ex.abstMethod1();
		ex.abstMethod2();
		ex.abstMethod3();
	}

}
