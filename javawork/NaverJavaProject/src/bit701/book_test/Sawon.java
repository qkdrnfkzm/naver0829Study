package bit701.book_test;

public class Sawon {

	private String name;
	private int gibon;
	private int sudang;
	private int fsu;
	
	public Sawon(String name, int gibon, int sudang, int fsu)
	{
		this.name=name;
		this.gibon=gibon;
		this.sudang=sudang;
		this.fsu=fsu;
	}
	
	public String getName() {
		return name;
	}
	public int getGibon() {
		return gibon;
	}
	public int getSudang() {
		return sudang;
	}
	public int getFsu() {
		return fsu;
	}
	public int getFsudang() {
		if(getFsu()>=3) {
			return 100000;
		}else {
			return 30000;
		}
	}
	public int getTax() {
		return getGibon()*5/100;
	}
	public int getSil() {
		return getGibon()+getSudang()+getFsudang()-getTax();
	}
	
}
