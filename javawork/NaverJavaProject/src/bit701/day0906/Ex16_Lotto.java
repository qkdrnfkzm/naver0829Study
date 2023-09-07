package bit701.day0906;

public class Ex16_Lotto {

	public static void main(String[] args) {

		/*
		 * 6개 할당된 lotto 변수에 1~45 사이의 난수를 발생하는데
		 * 중복된 경우 다시 발생, 오름차순 정렬로 출력
		 */

		int[] lotto = new int[6];

		//중복되지 않는 난수 발생
		for(int i=0;i<lotto.length;i++){
			
			lotto[i]=(int)(Math.random()*45)+1;
			
			for (int j = 0; j < i; j++) {
								
				if (lotto[i]==lotto[j]) {
					i--;
					break;	//현재 반복문을 빠져나간 후 i++로 이동
				}
				
				if(lotto[i]<lotto[j]) {
					int temp = lotto[i];
					lotto[i]=lotto[j];
					lotto[j]=temp;
				}
			}
		}
		
		//정렬
		for(int i=0;i<lotto.length-1;i++){
			for (int j = i; j < lotto.length; j++) {
				if(lotto[i]>lotto[j]) {
					int temp = lotto[i];
					lotto[i]=lotto[j];
					lotto[j]=temp;
				}
			}
		}
		
		//출력
		for (int m : lotto) {
			System.out.printf("%3d",m);
		}

	}

}
