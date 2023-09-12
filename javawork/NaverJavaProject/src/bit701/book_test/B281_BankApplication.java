package bit701.book_test;

import java.util.Scanner;

public class B281_BankApplication {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		B281_Account[] a = new B281_Account[10];

		String accNo, accName;
		int money,menu, idx=0;

		for (int i = 0; i < a.length; i++) {
			System.out.println("-".repeat(40));
			System.out.println("1.신규 | 2.조회 | 3.입급 | 4.출금 | 5.종료");
			System.out.println("-".repeat(40));
			System.out.println("선택>");

			menu=Integer.parseInt(sc.nextLine());

			if(menu==1) {
				System.out.println("-----\n신규\n-----");
				System.out.print("계좌>");
				accNo = sc.nextLine();
				System.out.print("이름>");
				accName = sc.nextLine();
				System.out.print("초기입금액>");
				money = Integer.parseInt(sc.nextLine());
				a[idx]=new B281_Account(accNo, accName, money);
				idx++;
				System.out.println("**생성완료**");

			}else if(menu==2) {
				System.out.println("-----\n조회\n-----");
				for (int j = 0; j < idx ; j++) {
					a[j].accWrite();
				}
			}else if(menu==3) {
				System.out.println("-----\n입금\n-----");
				System.out.print("계좌>");
				accNo = sc.nextLine();
				System.out.print("입금액>");
				money = Integer.parseInt(sc.nextLine());

				for (int j = 0; j < idx; j++) {
					if(a[j].isAcc(accNo)) {
						a[j].addMoney(money);
						System.out.println("**입금완료**");
					}
				}
			}else if(menu==4) {
				System.out.println("-----\n출금\n-----");
				System.out.print("계좌>");
				accNo = sc.nextLine();
				System.out.print("출금액>");
				money = Integer.parseInt(sc.nextLine());

				for (int j = 0; j < idx; j++) {
					if(a[j].isAcc(accNo)) {
						a[j].subMoney(money);
						System.out.println("**출금완료**");
					}
				}
			}else if(menu==5) {
				System.out.println("종료");
				break;
			}
			System.out.println();
		}

	}

}
