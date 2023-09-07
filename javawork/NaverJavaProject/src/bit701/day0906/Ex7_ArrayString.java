package bit701.day0906;

import java.util.Scanner;

public class Ex7_ArrayString {

	public static void main(String[] args) {
		
		//입력한 숫자 만큼 String 배열을 할당하고 이름을 입력 받아서 출력하기
		Scanner sc  =  new Scanner(System.in);
		String[] name;
		int count;
		
		System.out.println("할당할 갯수를 입력하세요");
		count = Integer.parseInt(sc.nextLine());
		name = new String[count];
		
		//할당한 갯수만큼 이름 입력
		for(int i = 0;i<name.length;i++) {
			System.out.println(i+"번째 이름");
			name[i] = sc.nextLine();
		}
		
		//출력
		System.out.println("번호\t이름");
		for(int i = 0;i<name.length;i++) {
			System.out.println(i+1+"\t"+name[i]);
		}
		
	}
}
