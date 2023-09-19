package bit701.book_test;

import java.time.LocalDateTime;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {

		LocalDateTime immutableDateTime = LocalDateTime.now();

		System.out.println(immutableDateTime);

		immutableDateTime.withYear(2222);

		System.out.println(immutableDateTime);

		System.out.println();

		Date mutableDate = new Date();
		System.out.println("가변 Date 객체: " + mutableDate);

		// Date 객체의 시간 변경
		mutableDate.setTime(System.currentTimeMillis() + 3600000); // 현재 시간으로부터 1시간 추가

		// 변경된 날짜 및 시간 출력
		System.out.println("가변 Date 객체: " + mutableDate);

		int i = 1;

		String[] arr;

	}

}
