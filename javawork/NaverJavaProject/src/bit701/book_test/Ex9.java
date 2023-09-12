package bit701.book_test;

import java.util.Iterator;
import java.util.Scanner;

public class Ex9 {
	public static void main(String[] args) {
		
		Scanner sc  = new Scanner(System.in);
		
		Sawon[] s = new Sawon[3];
		
		String name;
		int gibon,sudang,fsu;
		
		for (int i = 0; i < s.length; i++) {
			System.out.println(i+1+"번 사원명");
			name = sc.nextLine();
			System.out.println(i+1+"번 기본급");
			gibon = Integer.parseInt(sc.nextLine());
			System.out.println(i+1+"번 수당");
			sudang = Integer.parseInt(sc.nextLine());
			System.out.println(i+1+"번 가족수");
			fsu = Integer.parseInt(sc.nextLine());
			
			s[i] = new Sawon(name, gibon, sudang, fsu);
		}
		
		System.out.println("이름\t기본급\t수당\t가족수\t가족수당\t세금\t실수령액");
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i].getName()+"\t"+s[i].getGibon()+"\t"+s[i].getSudang()+"\t"+s[i].getFsu()+"\t"+s[i].getFsudang()+"\t\t"+s[i].getTax()+"\t"+s[i].getSil());
			
		}
	}

}
