package bit701.book_test;

class Car2{
	String carName;
	String carColor;
	
	private Car2() {
		carName = "아우디";
		carColor = "화이트";
	}
	public static Car2 getInstence() {
		return new Car2();
	}
	
	@Override
	public String toString() {
		return "자동차명:"+carName+", 색상:"+carColor;
	}
}

public class Ex5 {
	public static void main(String[] args) {
		Car2 car1 = Car2.getInstence();
		System.out.println(car1.toString());
		System.out.println(car1);
	}
	

}
