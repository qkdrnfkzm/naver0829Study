package bit701.book_test;

public class MyStudent {

	private String name;
	private int kor, eng;
	
	public MyStudent(String name, int kor, int eng) {
		this.name=name;
		this.kor=kor;
		this.eng=eng;
	}
	
	public String getName() {
		return name;
	}
	public int getKor() {
		return kor;
	}
	public int getEng() {
		return eng;
	}
	public int getTotal() {
		return kor+eng;
	}
	public int getAvg() {
		return getTotal()/2;
	}
	public String getGrade() {
		if(getAvg()>=90) return "A";
		else if(getAvg()>=80) return "B";
		else if(getAvg()>=70) return "C";
		else return "탈락";
	}
	
}
