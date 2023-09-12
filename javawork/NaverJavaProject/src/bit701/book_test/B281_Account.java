package bit701.book_test;

public class B281_Account {

	private String accNo;
	private String accName;
	private int money;
	
	//인자 받는 생성자
	public B281_Account(String accNo, String accName, int money) {
		this.accNo=accNo;
		this.accName=accName;
		this.money=money;
	}
	
	//계좌가 맞는지 boolean / isAcc(String accNo)
	public boolean isAcc(String accNo) {
		if(this.accNo.equals(accNo)) {
			return true;
		}else {
			return false;
		}
	}
	
	//입금시
	public void addMoney(int money) {
		this.money+=money;
		
	}
	
	//출금시
	public void subMoney(int money) {
		this.money-=money;
	}
	//잔액
	public void accWrite() {
		System.out.println(accNo+"\t"+accName+"\t"+money);
	}
}
