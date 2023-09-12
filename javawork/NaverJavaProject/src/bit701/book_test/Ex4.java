package bit701.book_test;

class Car{
	private String carName;
	private int carPrise;
	
	Car(){
		System.out.println("디폴트");
		carName="토레스";
		carPrise=3500;
	}
	
	Car(String carName){
		System.out.println("생성자1");
		this.carName=carName;
		carPrise=3500;
	}
	Car(String carName, int carPrise){
		System.out.println("생성자2");
		this.carName=carName;
		this.carPrise=carPrise;
	}
	
	public void carShow() {
		System.out.println("차명 : "+carName+", 가격 : "+carPrise);
	}
}

public class Ex4 {
	public static void main(String[] args) {
		Car c1 = new Car();
		c1.carShow();
		
		Car c2 = new Car("렉스턴");
		c2.carShow();
		
		Car c3 = new Car("티볼리",2800);
		c3.carShow();
		
		

	}
}
