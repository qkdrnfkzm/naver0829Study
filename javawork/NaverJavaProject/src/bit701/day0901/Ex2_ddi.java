package bit701.day0901;
import java.util.Scanner;

public class Ex2_ddi {

	public static void main(String[] args) {
		
		//태어난 년도를 입력받아 띠를 구해보세요
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("태여난 년도는?");
		int year=sc.nextInt();
		//12로 나눈 나머지를 구한다
		int m=year%12;
		
		String ddi=m==0?"원숭이":m==1?"닭":m==2?"개":m==3?"돼지":m==4?"쥐":m==5?"소":m==6?"호랑이":m==7?"토끼":m==8?"용":m==9?"뱀":m==10?"말":"양";
		System.out.println(year+"년생은 "+ddi+"띠 입니다.");
		
		
		switch (m) {
		case 0: ddi = "원숭이";			
			break;
		case 1: ddi = "닭";			
			break;
		case 2: ddi = "개";		
			break;
		case 3: ddi = "돼지";			
			break;
		case 4: ddi = "쥐";			
			break;
		case 5: ddi = "소";			
			break;
		case 6: ddi = "호랑이";			
			break;
		case 7: ddi = "토끼";			
			break;
		case 8: ddi = "용";			
			break;
		case 9: ddi = "뱀";			
			break;
		case 10: ddi = "말";			
			break;
		default: ddi = "양";
			break;
		}
		System.out.println(ddi+"띠");
		

	}

}
