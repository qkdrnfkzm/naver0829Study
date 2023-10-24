package codingTest.CodingTest3;

class Solution_1 {
	public int solution(int n) {

		// 해당 숫자를 구해 배열에 입력, 해당 index 값이 3x값
		// 배열의 값을 출력

		int[] answer = new int[n + 1];
		int s = 0;
		
		for (int i = 1; i < answer.length; i++) {
			for (int j = 1; j < answer.length; j++) {
				if (s % 10 == 3 || s % 3 == 0 || s / 10 == 3 || (s / 10) % 10 == 3) {
					++s;
				}
			}
			answer[i] = s;
			s++;
			System.out.println(i + " : " + answer[i]);
		}

		return answer[n];
	}

	public static void main(String[] args) {
		Solution_1 s = new Solution_1();
		int n = 100;
		System.out.println(n + " : " + s.solution(n));

	}
}