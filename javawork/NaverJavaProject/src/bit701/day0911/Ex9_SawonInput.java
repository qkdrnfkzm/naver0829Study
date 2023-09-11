package bit701.day0911;

import java.util.Iterator;
import java.util.Scanner;

public class Ex9_SawonInput {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		Sawon[] sa = new Sawon[3];
		
		//3명의 사원에 대한 정보 입력 후 배열 생성 하기
		String name;
		int gibon, sudang, familySu;
		
		for (int i = 0; i < sa.length; i++) {
		
			System.out.println(i+"번 사원명 : ");
			name = sc.nextLine();
			System.out.println(i+"번 기본급 : ");
			gibon = Integer.parseInt(sc.nextLine());
			System.out.println(i+"번 수당 : ");
			sudang = Integer.parseInt(sc.nextLine());
			System.out.println(i+"번 가족수 : ");
			familySu= Integer.parseInt(sc.nextLine());
			
			//객체 생성
			sa[i]=new Sawon(name, gibon, sudang, familySu);
			
		}
		
		//출력
		System.out.println("이름\t기본급\t수당\t가족수\t가족수당\t세금\t실수령액");
		System.out.println("=".repeat(60));
		for(Sawon s:sa) {
			System.out.println(s.getName()+"\t"+s.getGibon()+"\t"+s.getSudang()+"\t"+s.getfamilySu()+"\t"+s.getFamilySudang()+"\t\t"+s.getTax()+"\t"+s.getNetPay());
		}

	}
	
}
