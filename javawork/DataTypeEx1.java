public class DataTypeEx1{
  public static void main(String []args)
  {
	//이 라인은 비실행문 입니다.
	/*
	23.08.30
	데이터 삽입 예제	
	*/
	//byte는 1byte 크기의 정수형 타입입니다.
	//크기는 -128~127 의 숫자만 저장이 가능합니다.
	
	byte a=127;
	System.out.println("a="+a);

	byte b=(byte)200;	//오류, 강제 형변환
	System.out.println("b="+b);	//강제 형변환 했을 경우 값 손실 발생
	/*
	강제 형변환 했을경우 200이 -56이 나오는 이유
	200(10) -> 11001000(2)
	1의 보수 (0과 1전환) => 00110111(2)
	2의 보수 (1의보수+1) => 00111000(2) -> 56(10)
	*/

	//실행시 인자로 넘어오는 문자열을 확인해보자
	System.out.println(args[0]);//배열의 첫 문자 출력
	

  }
}