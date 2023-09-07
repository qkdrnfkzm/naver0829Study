package bit701.day0906;

public class Ex3_Array {

	public static void main(String[] args) {

		//다양한 타입으로 배열에 저장

		char[] arr1 = {'A','p','p','l','e'};
		double[] arr2;
		arr2 = new double[] {2.1,3.4,1.7};
		String[] arr3=new String[3];
		arr3[0]="사과";
		arr3[1]="오렌지";
		arr3[2]="딸기";

		System.out.println("***arr1 출력***");
		for(int i=0;i<arr1.length;i++) 
			System.out.printf("%c",arr1[i]);

		System.out.println("\n***arr2 출력***");
		for(int i=0;i<arr2.length;i++)
			System.out.printf("%f\t",arr2[i]);

		System.out.println("\n***arr3 출력***");
		for(int i=0;i<arr3.length;i++) 
			System.out.println(arr3[i]);
		
		System.out.println();
		
		System.out.println("***arr1 출력***");
		for(char i:arr1) 
			System.out.printf("%c",i);

		System.out.println("\n***arr2 출력***");
		for(double i:arr2)
			System.out.printf("%f\t",i);

		System.out.println("\n***arr3 출력***");
		for(String i:arr3) 
			System.out.println(i);
	}

}
