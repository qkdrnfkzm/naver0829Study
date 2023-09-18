package bit701.day0913;

abstract class Tire{
	abstract public void roll();
}

class HankookTire extends Tire{
	@Override
	public void roll() {
		System.out.println("한국 타이어가 회전합니다");
	}
}
class KumhoTire extends Tire{
	@Override
	public void roll() {
		System.out.println("금호 타이어가 회전합니다");
	}
}

class Car{
	public Tire tire;	//초기값 = null
	
	public void run(){
		tire.roll();	//tire에 new로 생성을 안한 상태에서 호출 시 NullPointerException이 발생한다
	}
}


public class Book314 {
	public static void main(String[] args) {
		Car c = new Car();
		c.tire = new HankookTire();
		c.run();
		
		c.tire = new KumhoTire();
		c.run();
	}
}
