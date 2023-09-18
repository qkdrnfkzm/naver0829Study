package bit701.day0914;

class Box<T>{
	private T content;
	public void setContent(T content) {
		this.content = content;
	}
	public T getContent() {
		return content;
	}
}

public class Ex6_Generics {
	public static void main(String[] args) {
		Box<String> box1 = new Box();
		box1.setContent("Hello");
		System.out.println(box1.getContent());
		
		Box<Double> box2 = new Box();
		box2.setContent(2.191);
		System.out.println(box2.getContent());
	}

}
