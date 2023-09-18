package bit701.day0915;

//Thread를 상속받아 구현하는 방법
//자바는 다중상속 지원이 안되기 때문에 이미 상속받은 클래스가 있는경우 인터페이스를 이용해서 Thread를 구현해야 한다
public class Ex1_ThreadTest extends Thread {

	String name;
	int count;

	public Ex1_ThreadTest(String name, int count) {
		super();
		this.name = name;
		this.count = count;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < count; i++) {
			System.out.println(name+" : "+i);
		}
	}

	public static void main(String[] args) {
		
		Ex1_ThreadTest th1 = new Ex1_ThreadTest("one_thread", 300);
		Ex1_ThreadTest th2 = new Ex1_ThreadTest("two_thread", 300);
		Ex1_ThreadTest th3 = new Ex1_ThreadTest("three_thread", 300);
		
		th1.start(); 
		th2.start(); 
		th3.start(); 
	}
}
