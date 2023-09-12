package bit701.day0911;

import java.util.Scanner;

//교제 p281 20번 문제
public class Book_BankApplication {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Account[] account = new Account[2];

		//배열 10개가 꽉차면 "더이상 계좌 생성이 안됩니다" 라고 출력

		String accountNo;
		String accountName;
		int money;
		int menu;
		int idx=0;

		while (true) {
			System.out.println("-".repeat(50));
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("-".repeat(50));
			System.out.print("선택>");

			menu = Integer.parseInt(sc.nextLine());

			if(menu==5) {
				System.out.println("프로그램 종료");
				break;
			}

			switch(menu) {
			case 1:{
				if(idx>=2) {
					System.out.println("**더이상 계좌 생성이 불가능합니다**");
					break;
				}
				System.out.println("----------\n계좌생성\n----------");
				System.out.print("계좌번호 : ");
				accountNo= sc.nextLine();
				System.out.print("계좌주 : ");
				accountName = sc.nextLine();
				System.out.print("초기입금금액 : ");
				money = Integer.parseInt(sc.nextLine());
				account[idx] = new Account(accountNo, accountName, money);
				idx++;
				System.out.println("계좌가 생성되었습니다.");
				break;
			}
			case 2:{
				System.out.println("----------\n계좌목록\n----------");
				for (int i = 0; i < idx; i++) {
					account[i].accountWrite();
				}
				break;
			}
			case 3:{
				System.out.println("----------\n예금\n----------");
				System.out.print("계좌번호 : ");
				accountNo= sc.nextLine();
				System.out.print("예금액 : ");
				money = Integer.parseInt(sc.nextLine());
				//계좌번호를 찾은 후 그 배열 번지의 money에 추가
				for (int i = 0; i < idx; i++) {
					if(account[i].isAccount(accountNo)) {
						account[i].addMoney(money);
						break;
					}
				}
				System.out.println("예금 되었습니다.");
				break;
			}
			case 4:{
				System.out.println("----------\n출금\n----------");
				System.out.print("계좌번호 : ");
				accountNo= sc.nextLine();
				System.out.print("출금액 : ");
				money = Integer.parseInt(sc.nextLine());
				for (int i = 0; i < idx; i++) {
					if(account[i].isAccount(accountNo)) {
						account[i].subMoney(money);
						break;
					}
				}
				System.out.println("출금 되었습니다.");
				break;
			}

			}//switch
			System.out.println();
		}//waile

	}//main

}//class

