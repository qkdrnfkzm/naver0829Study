package bit701.book_test;

public class Ex6 {
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.StudentInfo();
		
		Student s2 = new Student("바보");
		s2.StudentInfo();
		
		Student s3 = new Student("몽충",2000,90);
		s3.StudentInfo();
	}

}
