package bit701.day0906;

public class Ex5_ArrayMax {

	public static void main(String[] args) {

		//최대값, 최소값 구하기
		int[] data;
		data = new int[] {8,17,-75,15,-98,31,-152,-873,912,53};
		int max, min;

		//첫번째 데이터를 최대값, 최소값에 저장한다
		max=data[0];	
		min=data[0];

		//대입한 값을 2번째 값부터 끝까지 비교해서 더 큰값이 나오면 max값을 변경한다

		for(int i=1;i<data.length;i++) {
			if(max<data[i]) {
				max=data[i];
			}
			if(min>data[i]) {
				min=data[i];
			}
		}

		System.out.println("최대값:"+max);
		System.out.println("최소값:"+min);

	}

}
