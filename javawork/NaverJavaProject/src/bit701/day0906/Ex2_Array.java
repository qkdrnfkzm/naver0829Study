package bit701.day0906;

public class Ex2_Array {

	public static void main(String[] args) {

		// 배열 선언 시 초기값을 지정하는 경우
		int[] arr = {1,3,5,7,9};		//js는 []
		System.out.println("arr의 할당 갯수:"+arr.length);

		System.out.println("\n**출력1**");
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}

		System.out.println("\n**출력2**");
		for(int i:arr) {
			System.out.println(i);
		}

		System.out.println("-".repeat(30));
		
		//배열2
		int[] arr2;
		arr2 = new int[]{2,4,6,8,10};		//선언을 한 후 나중에 값을 한번에 저장할 경우

		for(int i=0;i<arr2.length;i++) {
			System.out.printf("[ %d : %d ]",i,arr2[i]);
		}

		System.out.println();

		for(int i:arr2) {
			System.out.printf("%3d",i);
		}

	}

}
