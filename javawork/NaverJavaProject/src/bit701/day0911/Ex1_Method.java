package bit701.day0911;
class Hello{

	public static final String MESSAGE = "오늘은 월요일";

	private String name;
	private int age;

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return this.name;
	}
	public int getAge() {
		return age;
	}

	public void show() {
		System.out.println("name="+name+" ,age="+age);
	}
}

public class Ex1_Method {

	public static void main(String[] args) {
		Hello hello = new Hello();
		hello.show();
		System.out.println();

		//값 변경
		hello.setName("이영자");
		hello.setAge(34);

		//출력
		//static 멤버 변수 출력
		System.out.println("static 변수 출력: "+hello.MESSAGE);
		System.out.println("이름:"+hello.getName());
		System.out.println("나이:"+hello.getAge());
		System.out.println();
		hello.show();

	}

}
