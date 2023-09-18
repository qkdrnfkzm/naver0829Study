package bit701.day0913;
//익명 내부 클래스(Anonymous Inner Class)
abstract class AnonySuper{
	abstract public void show();
	abstract public void play();
}

interface BitInter{
	public void study();
	public void draw();
}

class AnonyClass{
	
	//이 형태가 바로 익명 내부 클래스 형태이다
	//탐색기에서 보면 외부클래스$1 이런식으로 class 이름이 만들어져있다
	AnonySuper anony = new AnonySuper() {
		@Override
		public void show() {
			System.out.println("오늘은 N-Time 날");
		}
		@Override
		public void play() {
			System.out.println("노는날 아닙니다");
		}
	};
	
	//interface BitInter 를 익명 내부 클래스 형태로 구현하여 메인에서 호출해보세요
	BitInter bi = new BitInter() {
		@Override
		public void study() {
			System.out.println("공부합니다");
		}
		@Override
		public void draw() {
			System.out.println("그림 그립니다");
		}
	};
}

public class Ex9_AnonymousClass {
	public static void main(String[] args) {
		AnonyClass a = new AnonyClass();
		a.anony.show();
		a.anony.play();
		System.out.println();
		
		a.bi.study();
		a.bi.draw();
		
	}
}
