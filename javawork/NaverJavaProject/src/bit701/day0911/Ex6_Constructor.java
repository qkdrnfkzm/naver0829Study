package bit701.day0911;


public class Ex6_Constructor {

	public static void main(String[] args) {
		Student stu1 = new Student();
		Student stu2 = new Student("신동엽");
		Student stu3 = new Student("유재석", 1988, 90);
		
		stu1.studentInfo();
		stu2.studentInfo();
		stu3.studentInfo();
		
	}
}
