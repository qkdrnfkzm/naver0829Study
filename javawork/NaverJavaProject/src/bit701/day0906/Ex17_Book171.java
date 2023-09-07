package bit701.day0906;

public class Ex17_Book171 {

	public static void main(String[] args) {

		int[] scores;
		scores = new int[] {83,90,87};
		int sum1=0;
		for (int i = 0; i < scores.length; i++) {
			sum1+=scores[i];
		}
		System.out.println("총합:"+sum1);

		printItem(scores);

		System.out.println("=".repeat(30));
		printItem(new int[] {78,94,12,39,87,21,66,84});

	}

	public static void printItem(int[] scores) {

		//매개변수가 참조하는 배열의 항목을 출력
		for (int i = 0; i < scores.length; i++) {
			System.out.println("score["+i+"]:"+scores[i]);
		}
	}

}
