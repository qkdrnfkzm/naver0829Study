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
//		총금액 : 6000원
//		5개 이상으로 10프로 할인된 금액 : 5400원
		NumberFormat numberformat1 = NumberFormat.getInstance();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("상품명을 입력하세요");
		String name = sc.nextLine();
		System.out.println("수량을 입력하세요");
		int count = sc.nextInt();
		System.out.println("단가을 입력하세요");
		int prise = sc.nextInt();
		int total = count*prise;		

		if (count>=5) {
			System.out.println("상품명 : "+name);
			System.out.println("수량 : "+numberformat1.format(count)+"개");
			System.out.println("단가 : "+numberformat1.format(prise)+"원");
			System.out.println("총금액 : "+numberformat1.format(total)+"원");
			System.out.println("5개 이상으로 10프로 할인된 금액 : "+numberformat1.format((int)(total*0.9))+"원");
		}else {
			System.out.println("상품명 : "+name);
			System.out.println("수량 : "+numberformat1.format(count)+"개");
			System.out.println("단가 : "+numberformat1.format(prise)+"원");
			System.out.println("총금액 : "+numberformat1.format(total)+"원");	
		}

		
		

	}

}
