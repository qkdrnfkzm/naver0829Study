package bit701.day0911;

public class Ex7_Constructor {

	public static void main(String[] args) {

		//방법 1
		Student[] stu1 = new Student[3]; //3개로 배열할당, 초기값은 null
		
		stu1[0] = new Student();
		stu1[1] = new Student("강호동");
		stu1[2] = new Student("이수근", 1987, 98);
		
		for (int i = 0; i < stu1.length; i++) {
			stu1[i].studentInfo();
		}
		
		System.out.println("=".repeat(50));
		
		//방법 2
		Student[] stu2= {
				new Student(),
				new Student("유재석"),
				new Student("강호동",1979,88),
				new Student("은지원",1999,100)
		};
		
		for (Student s : stu2) {
			s.studentInfo();
		}
	}
}
