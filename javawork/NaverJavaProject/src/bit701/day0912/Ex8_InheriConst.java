package bit701.day0912;

class SuperC{

	protected String name;
	protected int age;
	
	public SuperC() {
		System.out.println("부모의 디폴트 생성자 호출");
		name="홍길동";
		age=10;
	}
	
	SuperC(String name, int age){
		System.out.println("부모의 두번째 생성자 호출");
		this.name=name;
		this.age=age;
	}
}

class SubC extends SuperC{
	
	String hp;
	
	SubC() {
		super();	//부모의 디폴트 생성자 호출(숨겨져있음, 생략가능 단 디폴트인 경우에만)
		System.out.println("서브클래스의 디폴트 생성자 호출");
		hp="010-1234-1234";
	}
	
	SubC(String hp){
		//super(); 생략되어 있음
		System.out.println("서브클래스의 두번째 생성자 호출");
		this.hp = hp;
	}
	
//	SubC(String name, int age, String hp){
//		System.out.println("서브클래스의 세번째 생성자 호출");
//		super.name=name;
//		super.age=age;
//		this.hp=hp;
//	}// 위의 방법 보다는 아래의 방법으로 부모 생성자를 호출하는 경우가 많다
	
	SubC(String name, int age, String hp){
		super(name,age);	//부모의 두번째 생성자 호출됨, 생략안됨 - 반드시 첫줄!!!
		System.out.println("서브클래스의 세번째 생성자 호출");
		this.hp=hp;
	}
	
	public void showData() {
		//부모클래스의 멤버변수가 protected 이므로 패키지 상관없이 접근 가능
		System.out.println("이름:"+this.name);	//=("이름:"+super.name);	//모두 부모클래스에서 받아오기때문에 super.~ this.~ 모두 사용가능  
		System.out.println("나이:"+super.age);	//=("나이:"+this.age);
		System.out.println("핸드폰:"+this.hp);
		System.out.println("-".repeat(20));
	}
}


public class Ex8_InheriConst {
	public static void main(String[] args) {
		SubC sub1 = new SubC();
		sub1.showData();
		
		SubC sub2 = new SubC("010-9999-7777");
		sub2.showData();
		
		SubC sub3 = new SubC("캔디",12,"010-1234-7777");
		sub3.showData();
		
		
	}

}
