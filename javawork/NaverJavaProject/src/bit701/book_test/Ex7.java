package bit701.book_test;

public class Ex7 {
	public static void main(String[] args) {
		
		//1
		Student[] stu1 = new Student[3];
		
		stu1[0] = new Student();
		stu1[1] = new Student("가나다");
		stu1[2] = new Student("나는",1999,99);
		
		for (int i = 0; i < stu1.length; i++) {
			stu1[i].StudentInfo();
		}
		System.out.println("==".repeat(20));
		
		//2
		Student[] stu2= {
				new Student(),
				new Student("그그그"),
				new Student("느느",1988,87)
		};
		for (Student student : stu2) {
			student.StudentInfo();
		}
	}

}
