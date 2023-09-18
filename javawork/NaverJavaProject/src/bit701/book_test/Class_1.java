package bit701.book_test;

class Animal{
	public void breathe() {
		System.out.println("숨을 쉽니다");
	}
	public void sound() {
	}
}

//추상클래스 상속
class Dog extends Animal{
	@Override
	public void sound() {
		System.out.println("멍멍");
	}
}
class Cat extends Animal{
	@Override
	public void sound() {
		System.out.println("야옹");
	}
}

public class Class_1 {
	public static void main(String[] args) {
		Animal dog = new Dog();
		Animal cat = new Cat();
		dog.sound();
		cat.sound();
		
	}
}

