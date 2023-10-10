package ct.ct3;

class Solution_2 {
	public int solution(int n) {

		int answer = 0;

		for (int i = 0; i < n; i++) {
			answer++;
			for (int j = 0; j < n; j++) {
				if (answer % 10 == 3 || answer % 3 == 0 || answer / 10 == 3) {
					answer++;
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		Solution_2 s = new Solution_2();
		int n = 40;
		System.out.println(n + " : " + s.solution(n));
	}
}