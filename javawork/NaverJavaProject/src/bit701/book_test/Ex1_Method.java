package bit701.book_test;

class Hello{
	public static final String MESSAGE="집에 가고싶다";
	
	private String name;
	private int age;
	
	public void setName(String name) {
		this.name=name;
	}
	public void setAge(int age) {
		this.age=age;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	
	public void show() {
		System.out.println("이름:"+name+"\t 나이:"+age);
	}
}


public class Ex1_Method {
	
	public static void main(String[] args) {
		
		Hello h = new Hello();
		
		h.setName("가");
		h.setAge(23);
		
		h.show();
		
		System.out.println(h.MESSAGE);
		System.out.println("이름 : "+h.getName());
		System.out.println("나이 : "+h.getAge());
	}

}
