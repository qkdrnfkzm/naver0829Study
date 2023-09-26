package bit701.book_test;

public class CodingTest0925 {

	public static void main(String[] args) {
		String a = "apple";
		String b = "pplea";

		CodingTest0925 c = new CodingTest0925();
		//c.solution3(a, b);
		System.out.println(c.solution3(a, b));

	}

	
	
	public int solution3(String A, String B) {
		int answer = 0;
		int count = 0;

		while (count < A.length() + 1) {
			if (A.equalsIgnoreCase(B)) {
				break;
			}
			A = A.substring(A.length() - 1, A.length()) + A.substring(0, A.length() - 1);
			answer++;
			count++;
			if (count > A.length()) {
				return -1;
			}
		}
		return answer;
	}

	
	
	
	
	
}
