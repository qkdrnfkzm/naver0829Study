package bit701.day0905;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int money=0, total=0, num;

		Exit:
			while(true) {
				System.out.println("1.예 | 2.출 | 3.잔 | 4.종");
				System.out.println("선택:");
				num = sc.nextInt();


				switch (num) {
				case 1: {
					System.out.println("예금액:");
					money=sc.nextInt();
					total+=money;
					break;
				}
				case 2: {
					System.out.println("출금액:");
					money=sc.nextInt();
					total-=money;
					break;
				}
				case 3: {
					System.out.println("잔액 : "+total);
					break;
				}
				case 4: {
					System.out.println("종료");
					break Exit;

				}
				}


			}

	}
}
