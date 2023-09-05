package bit701.day0905;

import java.util.Scanner;

public class Ex1_JuminNo {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String JuminNo;

		while(true) {
			System.out.println("주민등록 번호 입력");
			JuminNo=sc.nextLine();

			//q or Q입력시 종료
			if(JuminNo.equalsIgnoreCase("q")) {
				System.out.println("프로그램 종료");
				break;
			}
			String yearSt=JuminNo.substring(0,2);
			String monthSt=JuminNo.substring(2,4);
			String daySt=JuminNo.substring(4,6);
			char gender=JuminNo.charAt(7);
			
			System.out.println(yearSt+"년 "+monthSt+"월 "+daySt+"일");
			
			if(gender=='1' || gender=='2' || gender=='3' || gender=='4') {
				System.out.println("내국인");
			}else if(gender=='5' || gender=='6' || gender=='7' || gender=='8') {
				System.out.println("외국인");
			}else {
				System.out.println("뒷자리 첫번째를 잘못입력 하였습니다");
			}
			
			switch (gender) {
			case '1':
			case '3':
			case '5':
			case '7':
				System.out.println("남자");
				break;
			case '2':
			case '4':
			case '6':
			case '8':
				System.out.println("여자");
				break;
			default:
				System.out.println("화성인");
			}
			System.out.println("-".repeat(30));
		}

	}

}
