package bit701.book_test;

class Solution {
	public int[] solution(int numer1, int denom1, int numer2, int denom2) {
		int ja = (numer1 * denom2) + (numer2 * denom1);
		int mo = denom1 * denom2;

		if (denom1 < denom2 && mo / denom1 == denom2) {
			ja = ja / denom1;
			mo = mo / denom1;

			int[] answer = { ja, mo };
			for (int i : answer) {
				System.out.println(i);
			}
			System.out.println("1");
			return answer;

		} else if (denom1 > denom2 && mo / denom2 == denom1) {
			ja = ja / denom2;
			mo = mo / denom2;

			int[] answer = { ja, mo };
			for (int i : answer) {
				System.out.println(i);
			}
			System.out.println("2");
			return answer;

		} else {
			int[] answer = { ja, mo };
			for (int i : answer) {
				System.out.println(i);
			}
			System.out.println("3");
			return answer;

		}

	}
}

public class Coding_Test0921 {
	public static void main(String[] args) {

		Solution s = new Solution();
		s.solution(3, 4, 1, 2);

	}

}
