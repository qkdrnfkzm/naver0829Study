package bit701.day0830;

public class DataEx2 {

	public static void main(String[] args) {
		System.out.println("내 이름은 "+args[0]+"입니다.");
		System.out.println("우리 집은 "+args[1]+"입니다.");
		System.out.println("내 혈액형은 "+args[2]+"형입니다.");
		System.out.println();
		System.out.println("실수형 데이터 타입");
		float f1 = 1234.567891234f; // 4바이트 float 으로 값을 지정하려면 f추가
		double d1 = 1234.567891234;
		System.out.println(f1);	//8자리까지 정확하게 출력, 나머지 반올림
		System.out.println(d1);	//15자리까지 정확하게 출력, 나머지 반올림
		
		//char 타입은 2byte, 한글, 한자 저장 가능
		char c1 = 'A';
		char c2 = '뷁';
		System.out.println(c1);
		System.out.println(c2);
				
		
	}

}
