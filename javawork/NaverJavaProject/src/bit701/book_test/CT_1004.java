package bit701.book_test;

import java.util.Scanner;

public class CT_1004 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = "";
		//String 값을 char로 변환 -> 아스키 코드값 비교 후 연산 -> char을 문자열로 변환 후 출력
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) < 97) {
				b += (char) (a.charAt(i) + 32);
			} else {
				b += (char) (a.charAt(i) - 32);
			}
		}
		System.out.println(b);
	}
}