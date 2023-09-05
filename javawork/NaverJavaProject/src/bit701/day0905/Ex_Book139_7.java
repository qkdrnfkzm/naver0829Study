package bit701.day0905;

import java.util.Scanner;

public class Ex_Book139_7 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int money=0, total=0, num;


		Exit:
			while(true)
			{
				total=0;
				while(true) {
					System.out.println("---------------------------------");
					System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
					System.out.println("---------------------------------");
					System.out.println("선택>");
					num=sc.nextInt();
					switch(num) {
					case 1:
						System.out.println("예금액>");
						money=sc.nextInt();
						total+=money;
						break;
					case 2:
						System.out.println("출금액>");
						money=sc.nextInt();
						total-=money;
						break;
					case 3:
						System.out.println("잔고>"+total);
						break;
					case 4:
						System.out.println("프로그램 종료");
						
//						System.out.println("새로시작? 0");
//						String re = sc.nextLine();
//						System.out.println(re);
//						if(re=="y") {
//							
//							continue Exit;
//						}else {
//							break Exit;	
//						}

					}

				}
			}
	}

}
