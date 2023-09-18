package bit701.day0913;

//봉인된(sealed) 클래스 지정하는 방법 - jdk15에서 추가된 기능
//무분별한 자식 클래스 생성을 막기 위한 기능
sealed class Person permits Employee,Manager{
	public String name;
	public void work() {
		System.out.println("하는 일이 결정되지 않았습니다");
	}
}
//클래스 앞의 final : Employee 클래스는 더이상 상속시킬 수 없다
final class Employee extends Person{
	@Override
	public void work() {
		System.out.println("제품을 생산합니다");
	}
}
//non-sealed : 상속이 가능한 클래스(봉인 해제)
non-sealed class Manager extends Person{
	@Override
	public void work() {
		System.out.println("생산 관리를 합니다");
	}
}
class Director extends Manager{
	@Override
	public void work() {
		System.out.println("제품을 기획합니다");
	}
}


public class Book330 {
	public static void main(String[] args) {
		Person p = new Person();
		p.work();
		System.out.println();
		
		Employee e = new Employee();
		e.work();
		System.out.println();
		
		Manager m = new Manager();
		m.work();
		System.out.println();
		
		Director d = new Director();
		d.work();
	}
}
