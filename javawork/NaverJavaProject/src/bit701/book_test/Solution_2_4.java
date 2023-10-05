package bit701.book_test;

public class Solution_2_4 {
	public int[] solution(int[] numbers) {
		int[] answer = new int[numbers.length];

		for (int i = 0; i < numbers.length; i++) {
			answer[i] = numbers[i] * 2;
			System.out.println(answer[i]);
		}
		return answer;
	}

	public static void main(String[] args) {
		Solution_2_4 s = new Solution_2_4();
		int[] a = {0,222,3,99,5};
		s.solution(a);
	}
	
	
}
