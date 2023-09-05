package bit701.day0905;

import java.util.Scanner;

public class Ex_Book158 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("주민등록번호를 입력하면 성별이 확인됩니다");

		String JuminNo=sc.nextLine();
		int by=Integer.parseInt(JuminNo.substring(0,2));
		String bm=JuminNo.substring(2,4);
		String bd=JuminNo.substring(4,6);
		int s = Integer.parseInt(JuminNo.substring(7,8));

		switch (s) {
		case 1:
		case 2:
		case 5:
		case 6:
			by+=1900;
			break;
		case 3:
		case 4:
		case 7:
		case 8:
			by+=2000;	
		}

		System.out.println(by+"년"+bm+"월"+bd+"일생");

		if(s<=4){
			System.out.print("내국인 ");
		}else {
			System.out.print("외국인 ");
		}

		switch (s) {
		case 1:
		case 3:
		case 5:
		case 7:
			System.out.println("남성입니다.");
			break;
		case 2:
		case 4:
		case 6:
		case 8:
			System.out.println("여성입니다.");
			break;
		}
	}
}
