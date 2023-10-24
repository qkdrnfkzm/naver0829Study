package codingTest.CodingTest3;

public class Solution_3 {
	public int solution(int[] common) {
		int answer = 0;

		if (common[1] - common[0] == common[2] - common[1]) {
			answer = common[common.length - 1] + common[1] - common[0];
		} else if (common[1] / common[0] == common[2] / common[1]) {
			answer = common[common.length - 1] * common[1] / common[0];
		}

		return answer;
	}

	public static void main(String[] args) {
		int[] common = { 1, 11, 21, 31, 41 };

		System.out.print("[ ");
		for (int i = 0; i < common.length; i++) {
			if (i + 1 == common.length) {
				System.out.print(common[i]);
			} else {
				System.out.print(common[i] + ", ");
			}
		}
		System.out.println(" ]" + " -> " + new Solution_3().solution(common));

	}
}
