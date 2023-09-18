package bit701.day0914;

import java.util.Date;
import java.util.Scanner;

public class Ex3_Exception {
	
	public static void dataInput() throws NumberFormatException,NullPointerException {
		
		Scanner sc = new Scanner(System.in);
		//Date date=null;	//이 경우 NullPointerException 발생
		Date date = new Date();
		
		System.out.println("년도:"+(date.getYear()+1900));
		System.out.println("두개의 숫자를 입력하시오");
		int su1 = Integer.parseInt(sc.nextLine());
		int su2 = Integer.parseInt(sc.nextLine());
		System.out.printf("%d+%d=%d\n",su1,su2,su1+su2);
	}
	
	public static void main(String[] args) {
		try {
			dataInput();
//		} catch (NumberFormatException e) {
//			System.out.println("숫자로만 입력해주세요 : "+e.getMessage());
//		} catch (NullPointerException e) {
//			System.out.println("날짜 생성이 되지 않았습니다 : "+e.getMessage());
		} catch (NumberFormatException | NullPointerException e) {
			System.out.println("날짜생성이 되지 않았거나, 숫자가 입력되지 않음 : "+e.getLocalizedMessage());
		}
		System.out.println("정상종료");
	}
}
