package bit701.day0911;

/* 생성자의 규칙
 * 1. 반드시 클래스명과 같은 메서드명
 * 2. 리턴타입이 없다
 * 3. 오버로딩이 가능하다
 * 4. 주로 멤버변수의 초기화를 담당
*/

class Car{

	private String CarName;
	private int CarPrice;
	
	//디폴트 생성자
	Car(){
		System.out.println("디폴트 생서자 호출");
		CarName="그랜져";
		CarPrice=4500;
	}
	
	Car(String carName, int carPrice){
		System.out.println("생성자 2 호출");
		this.CarName = carName;
		this.CarPrice = carPrice;
	}

	public void carShow() {
		System.out.println("자동차명 : "+CarName+" , 단가 : "+CarPrice);
	}
	
}

public class Ex4_Constructor {

	public static void main(String[] args) {
		Car car1 = new Car();
		car1.carShow();
		
		Car car2 = new Car("아반떼",2700);
		car2.carShow();
	}

}
