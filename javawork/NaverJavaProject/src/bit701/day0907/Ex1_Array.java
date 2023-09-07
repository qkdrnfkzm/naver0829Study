package bit701.day0907;

import java.util.Scanner;

public class Ex1_Array {

	public static void main(String[] args) {

		//System.out.println("배열 복습 예제");

		/*
		 * 처음에 인원수(count)를 입력 후 그 인원수 만큼
		 * name, kor, eng 를 배열 할당한 후
		 * 이원수 만큼 이름, 국어점수, 영어점수를 입력하면
		 * 아래와 같이 출력이 되도록 프로그램을 작성하세요
		 * 
		 * 	번호	이름	국어	영어	총점	평균
		 * ----------------------------------------------
		 * 	1		김		89		90		179		89.5
		 *  2		이		70		80		150		75
		 */

		Scanner sc = new Scanner(System.in);

		int count;
		String[] name;
		int[] kor,eng,tot;
		double[] avg;

		System.out.println("인원수를 입력하세요");
		count=Integer.parseInt(sc.nextLine());

		name = new String[count];
		kor = new int[count];
		eng = new int[count];
		tot= new int[count];
		avg = new double[count];

		for (int i = 0; i < count ; i++) {

			System.out.println(i+1+"번의 이름을 입력하세요");
			name[i]=sc.nextLine();

			System.out.println(i+1+"번의 국어점수를 입력하세요");
			kor[i]=Integer.parseInt(sc.nextLine());

			System.out.println(i+1+"번의 영어점수를 입력하세요");
			eng[i]=Integer.parseInt(sc.nextLine());

			tot[i]=kor[i]+eng[i];
			avg[i]=tot[i]/2.0;
		}


		System.out.println("번호\t이름\t국어\t영어\t총점\t평균");
		System.out.println("-".repeat(45));


		for (int i = 0; i < count; i++) {
			System.out.println(i+1+"\t"+name[i]+"\t"+kor[i]+"\t"+eng[i]+"\t"+tot[i]+"\t"+avg[i]);

		}

	}

}
