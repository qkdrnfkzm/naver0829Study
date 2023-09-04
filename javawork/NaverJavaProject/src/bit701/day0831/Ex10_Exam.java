package bit701.day0831;

import java.text.NumberFormat;
import java.util.Scanner;

public class Ex10_Exam {

	public static void main(String[] args) {
		
//		상품명과 수량, 단가를 각각 입력받은 후 총 금액을 출력하시오
//		그리고 수량이 5개 이상일경우 10프로 할인된 최종금액도 출력해주세요
//		
//		예)
//		상품명 : 딸기
//		수량 : 6
//		단가 : 1000
//		
//		총금액 : 6000원ㅁ
//		5개 이상으로 10프로 할인된 금액 : 5400원
		NumberFormat numFormat = NumberFormat.getInstance();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("상품명을 입력하세요");
		String name = sc.nextLine();
		System.out.println("수량을 입력하세요");
		int count = sc.nextInt();
		System.out.println("단가을 입력하세요");
		int prise = sc.nextInt();
		int total = count*prise;		

		System.out.println("상품명 : "+name);
		System.out.println("수량 : "+numFormat.format(count)+"개");
		System.out.println("단가 : "+numFormat.format(prise)+"원");
		System.out.println("총금액 : "+numFormat.format(total)+"원");
		
		if (count>=5) {
			total=(int)(total*0.9);
			System.out.printf("5개 이상으로 10프로 할인된 금액 : %d 원\n",total);
			System.out.printf("5개 이상으로 10%% 할인된 금액 : %s 원",numFormat.format(total));	
			//numFormat.format(total)에 대한 출력물은 String 형식이기 때문에 printf 사용시 %s로 변환기호 입력
			//printf에서는 %는 변환기호로 인식하기 때문에 오류
			//%출력을 원할시 %% 2회 입력
		}

	}

}
