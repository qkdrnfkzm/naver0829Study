package bit701.day0908;

public class Ex5_SawonCall {

	public static void main(String[] args) {

		Sawon sa = new Sawon();
		sa.setSawonNo("bit1234");
		sa.setName("홍길동");
		sa.setAge(23);
		
		System.out.println("**신입 사원 #1 정보 **");
		Ex5_SawonCall.printSawon(sa);	//같은 클래스내의 메서드는 클래스명 생략 가능  ==printSawon(sa);
		
		
		Sawon sa2 = new Sawon();
		sa2.setSawonNo("bit9999");
		sa2.setName("강호동");
		sa2.setAge(35);
		
		System.out.println("**신입 사원 #2 정보 **");
		printSawon(sa2);
		
	}
	
	
	public static void printSawon(Sawon s){
		System.out.println("사원번호 : "+s.getSawonNo());
		System.out.println("사원명 : "+s.getName());
		System.out.println("나이 : "+s.getAge());
	}

}
