package bit701.day0906;

import java.util.Iterator;
import java.util.Scanner;

public class Ex11_ArrayRankInput {

	public static void main(String[] args) {

		/*
		 * 총 4명의 이름과 점수를 입력하면 이름과 점수 등수를 출력하는 프로그램을 작성 하시오 단, 점수가 0~100을 벗어날 경우 다시 입력
		 * 예)	0번 이름 : 송혜교
		 * 		0번 점수 : 99
		 *  
		 * 		1번 이름 : 강호동
		 * 		1번 점수 : 120
		 * 			다시 입력하세요
		 * 		1번 이름 : 강호동
		 * 		1번 점수 : 60
		 * 		...
		 * 
		 * 		번호	이름	점수	등수
		 * 		---------------------------
		 * 		 0 		송혜교	99		 1
		 * 		 1 		강호동	60		 2
		 */


		Scanner sc = new Scanner(System.in);

		//변수선언
		String[] name = new String[4];
		int[] score = new int[4];
		int[] rank = new int[4];

		//입력
		for(int i=0;i<name.length;i++) {
			System.out.print(i+"번 이름:");
			name[i]=sc.nextLine();
			System.out.print(i+"번 점수:");
			score[i]=Integer.parseInt(sc.nextLine());
			if(score[i]<0 || score[i]>100) {
				System.out.println("0~100사이의 점수를 입력하세요");
				i--;
				continue;
			}
			System.out.println();
		}
		//순위
		for(int i=0;i<name.length;i++) {
			rank[i]=1;
			for(int j=0;j<name.length;j++) {
				if(score[i]<score[j]) {
					rank[i]++;
				}
			}	
		}

		//출력
		System.out.println("번호\t이름\t점수\t등수");
		System.out.println("=".repeat(30));
		for(int i=0;i<name.length;i++) {
			System.out.println(i+1+"\t"+name[i]+"\t"+score[i]+"\t"+rank[i]);
		}



	}

}
