package bit701.day0913;

class SuperA{
	
	public void process() {
		System.out.println("부모가 처리하는 프로세스");
	}
}

//3개의 sub클래스를 구현해보자
class SubA extends SuperA{
	@Override
	public void process() {
		super.process();
		System.out.println("그림을 그린다");
	}
}
class SubB extends SuperA{
	@Override
	public void process() {
		super.process();
		System.out.println("야구게임을 한다");
	}
}
class SubC extends SuperA{
	@Override
	public void process() {
		super.process();
		System.out.println("테니스를 친다");
	}
}

public class Ex1_Inheri {
	
	public static void main(String[] args) {
		
		//만약 서브 클래스로 선언시 3개의 일을 처리하려면 세번을 선언해야 한다		
		SubA suba = new SubA();
		suba.process();
		
		SubB subb = new SubB();
		subb.process();
		
		SubC subc = new SubC();
		subc.process();
		System.out.println("-".repeat(10));
		
		//선언은 한번만 하고 세가지의 일을 처리하려면?
		//부모로 선언하면 된다
		//부모로 선언시 그 변수에 누가 생성되어있느냐에 따라서
		//똑같은 메소드로 호출하더라도 하는일이 달라진다
		//이런식의 선언과 호출하는 방식을 다형성이라한다
		//메소드를 만들때에도 3개가 아닌 한개만 만들어도 된다
		SuperA  sub4=null;
		sub4 = new SubA();
		sub4.process();
		
		sub4 = new SubB();
		sub4.process();
		
		sub4 = new SubC();
		sub4.process();
		
	}

}
