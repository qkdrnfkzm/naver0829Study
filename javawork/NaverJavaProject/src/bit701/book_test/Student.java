package bit701.book_test;

import java.util.Date;

class Student {
	
	private String name;
	private int birthYear;
	private int score;
	
	Student(){
		this("이효리",2020,60);
	}
	Student(String name){
		this(name,2020,60);
	}
	Student(String name, int birthYear, int score){
		this.name=name;
		this.birthYear=birthYear;
		this.score=score;
	}
	
	public void StudentInfo() {
		int d = new Date().getYear()+1900;
		System.out.println("학생정보");
		System.out.println("이름:"+name);
		System.out.println("생년:"+birthYear);
		System.out.println("나이:"+(d-birthYear));
		System.out.println("점수:"+score);
		System.out.println("-".repeat(30));
	}

}
