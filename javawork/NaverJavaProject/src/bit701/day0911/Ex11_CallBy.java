package bit701.day0911;

class CallBy{

	String name;
	String addr;
	String hp;

	CallBy(String name, String addr, String hp){
		this.name=name;
		this.addr=addr;
		this.hp=hp;
	}
}


public class Ex11_CallBy {
	
	//Call By reference : 주소가 전달(클래스)
	//멤버값 변경 시 main의 by 변수의 멤버값도 변경된다
	public static void changeCallBy(CallBy by) {
		by.addr="서초구";
	}
	
	public static void writeData(CallBy by) {
		System.out.println("이름 : "+by.name);
		System.out.println("주소 : "+by.addr);
		System.out.println("핸드폰 : "+by.hp);
		System.out.println();
	}

	public static void main(String[] args) {

		CallBy by = new CallBy("김이사", "강남구", "010-1234-1234");
		System.out.println("**초기값 출력**");
		writeData(by);
		System.out.println("**값 변경후 출력**");
		changeCallBy(by);
		writeData(by);
		
	}

}
