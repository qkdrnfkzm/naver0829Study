package bit701.day0830;

public class DataEx1 {

	public static void main(String[] args) {
		 //TODO Auto-generated method stub
		System.out.print("apple\t");
		System.out.print("banana\t");
		System.out.println("orange\n");
		
		// printf : 변환 기호에 의한 출력, 정수 : %d,  실수 : %f, 문자 : %c, 문자열 : %s
		// \n : 줄넘김, \t : 다음탭위치로 이동
		int age = 23;
		double weight = 56.721;
		char blood='A';
		String name = "캐서린";
		
		System.out.printf("이름=%s\n",name);
		System.out.printf("나이=%d세\n",age);
		System.out.printf("몸무게=%fKg\n",weight);
		System.out.printf("몸무게=%7.1fKg\n",weight);	//%7.1f : 전체자릿수 : 7, 소숫점자리수 : 1 // 자릿수 부족분은 공백
		System.out.printf("혈액형=%c형\n",blood);
		System.out.println("------------------------------------");
		System.out.printf("이름 : %s\n혈액형 : %c\n나이 : %d\n",name,blood,age);
		
		
	}

}
