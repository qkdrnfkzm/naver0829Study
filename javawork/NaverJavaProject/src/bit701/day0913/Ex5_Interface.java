package bit701.day0913;

//interface는 기능 구연을 할 메소드들의 목록을 나열해 놓는 일을 한다
//interface에는 상수와 추상 메소드만 구현이 가능하다
//그래서 구분을 할 필요가 없기 떄문에 final, abstract라는 단어는 쓰지 않는다. 어차피 100% 상수와 추상 메소드로만 구성이 되어있기 때문이다.
//interface도 new로 생성할 수 없다.

interface InterA{
	int SCORE=100;			//final 상수
	public void play();	//abstract 메소드
	public void study();
}

//일반 클래스가 interface를 구현할 경우 implements로 구현
//인터페이스를 구현한 경우 반드시 모든 메소드를 오버라이드 해야만 한다
class My implements InterA{
	
	int myscore=SCORE;

	@Override
	public void play() {
		System.out.println("SCORE:"+SCORE);	//상수 출력
	}

	@Override
	public void study() {
		//SCORE=90;	//오류 : final 상수는 변경할 수 없음
		myscore=90;
		System.out.println("점수변경함:"+myscore);
	}
	
	//My클래스만이 갖고있는 메소드
	public void ProcessMy() {
		System.out.println("My 클래스가 단독으로 처리하는 작업");
	}
}


public class Ex5_Interface {

	public static void main(String[] args) {
		My m = new My();
		m.play();
		m.study();
		m.ProcessMy();
		System.out.println("-----------");
		
		InterA a = new My();
		a.play();
		a.study();
		//a.ProcessMy();	//오류 : 오버라이드 메소드가 아니므로 My로 선언시에만 호출이 가능하다
		
	}
}
