package codingTest.CodingTestS;

import java.util.Arrays;

public class day3_2 {
	public int solution(int[] arr) {
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

		int a = arr[arr.length / 2];
		System.out.println();
		System.out.println("a = " + a);
		return a;
	}

	public static void main(String[] args) {
		day3_2 c = new day3_2();

		int[] arr = { 11, 43, 66, 2, 89, 23, 26, 28, 31 };

		c.solution(arr);
	}
}
