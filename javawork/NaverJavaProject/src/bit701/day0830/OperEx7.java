package bit701.day0830;

public class OperEx7 {

	public static void main(String[] args) {
		//비교연산자와 논리연산자, 결과값은 무조건 참(true), 거짓(false)
		int kor=100, eng=90, mat=100;
		System.out.println(kor>=80);						//true
		System.out.println(kor>=80 || kor!=mat);			//true - 앞의 수식이 참일 경우 뒷 수식은 비교하지 않는다.
		System.out.println(kor<80 || kor!=mat);				//false
		System.out.println(kor>=80 && kor!=mat);			//false
		System.out.println(kor<80 && kor!=mat);				//false
		System.out.println(!(kor==mat));					//false
		System.out.println(kor>=95 && eng>=95 && mat>=95);	//false
		System.out.println(kor>=95 && eng>=95 || mat>=95);	//true - and 먼저 연산 후 or연산하기 때문
		System.out.println(kor>=95 || eng>=95 && mat>=95);	//true

		//윤년인지 아닌지 알아보기
		int year=2023;
		System.out.println(year%4==0 && year%100!=0 || year%400==0);

	}

}
