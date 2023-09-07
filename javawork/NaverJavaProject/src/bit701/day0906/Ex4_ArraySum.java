package bit701.day0906;

public class Ex4_ArraySum {

	public static void main(String[] args) {

		//배열의 5개의 정수를 저장 후 총점과 평균 구하기
		int[] score = {78,100,90,89,69,77,48,68};
		int sum = 0, sum2 = 0;
		double avg = 0;

		//방법1
		for(int i = 0;i<score.length;i++) {
			sum+= score[i];
		}

		avg = (double)sum/score.length;
		System.out.println("총점수 갯수:"+score.length);
		System.out.println("합계:"+sum);
		System.out.println("평균:"+avg);

		System.out.println();
		
		//방법2
		for(int i:score) {
			sum2+= i;
		}
		avg = (double)sum/score.length;
		System.out.println("총점수 갯수:"+score.length);
		System.out.println("합계:"+sum);
		System.out.println("평균:"+avg);

	}

}
