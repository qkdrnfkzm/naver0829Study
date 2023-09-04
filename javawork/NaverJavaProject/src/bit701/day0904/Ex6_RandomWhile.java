package bit701.day0904;

import java.util.Scanner;

public class Ex6_RandomWhile {

	public static void main(String[] args) {
		// 
		
		Scanner sc = new Scanner(System.in);
		
		int ran, count, num;
		
		Exit:
			while(true) {
				ran=(int)(Math.random()*100)+1;
				count = 0;
								
				while(true) {
					System.out.print(++count+" : ");
					//num = sc.nextInt();			//인트값을 그대로 사용할 경우 하단에 32라인 : sc.nextLine(); 작업시 엔터값이 미리 입력이 되었다고 인식하여 정상적으로 진행되지 않는다.
													//그렇기 때문에 String값을 입력받아 int타입으로 변환해야 한다.
					num = Integer.parseInt(sc.nextLine());
					if(num>ran) {
						System.out.println("\t"+num+"보다 작습니다");
					}else if(num<ran) {
						System.out.println("\t"+num+"보다 큽니다");
					}else {
						System.out.println("\t정답입니다("+ran+")");
						//계속할지 묻는다
						
						System.out.println("계속하려면 y를 입력해주세요, y가 아닐경우 종료");
						String ans=sc.nextLine();
						if(ans.equalsIgnoreCase("y")) {
							System.out.println("새로운 난수를 발생하겠습니다");
							continue Exit;
						}else {
							break Exit;
						}
					}
				}
			}

	}

}
