package bit701.day0911;

//교제 p281 20번 문제
public class Account {
	
	private String accountNo;		//계좌번호
	private String accountName;		//계좌주
	private int money;				//잔액

	//3개의 값을 전달 받는 생성자
	public Account(String accountNo, String accountName, int money){
		this.accountNo=accountNo;
		this.accountName=accountName;
		this.money=money;
	}
	
	//계좌번호가 맞을 경우 true를 반환해주는 메소드 isAccount(String accountNo) : 맞을 경우 true 반환, 틀릴경우 false 반환
	public boolean isAccount(String accountNo){
		if(accountNo.equals(this.accountNo)) {
			return true;
		}else {
			return false;
		}
	}
	
	//외부에서 입금 시 money에 추가하는 메소드(addMoney)
	public void addMoney(int money) {
		this.money+=money;
	}
	
	//외부에서 출금 시 money에서 빼는 메소드(subMoney)
	public void subMoney(int money) {
		this.money-=money;
	}
	
	//출력해주는 메소드 계좌번호	예금주	잔액(AccountWrite)
	public void accountWrite() {
		System.out.println(accountNo+"\t"+accountName+"\t"+money);
	}
}
