package bit701.day0912;

public class Sungjuk {
	
	private String name;
	private int kor;
	private int eng;
	
	//생성자
	public Sungjuk(String name, int kor, int eng) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
	}
	//getter method
	public String getName() {
		return name;
	}
	public int getKor() {
		return kor;
	}
	public int getEng() {
		return eng;
	}
}
