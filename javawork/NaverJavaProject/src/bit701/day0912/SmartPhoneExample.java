package bit701.day0912;

public class SmartPhoneExample {

	public static void main(String[] args) {
		//SmartPhone 객체 생성
		SmartPhone myPhone = new SmartPhone("갤럭시", "은색");
		
		//phone으로 상속 받은 필드 읽기
		System.out.println(myPhone.model);
		System.out.println(myPhone.color);
	}
}
