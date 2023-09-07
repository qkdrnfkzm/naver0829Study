package bit701.day0906;

import java.util.Scanner;

public class Ex6_ArrayScoreInput {

	public static void main(String[] args) {

		/* score에 5개의 배열할당 후 키보드로 직접 점수를 입력하여 배열에 저장 후
		 * 총점과 평균을 구하세요
		 */

		Scanner sc  =  new Scanner(System.in);
		
		//변수선언
		int[] score = new int[5];
		int sum = 0;
		double avg = 0;
		
		//입력
		System.out.println("5개의 점수를입력하세요");
		for(int i = 0;i<score.length;i++) {
			System.out.print(i+"번 점수입력:");
			score[i] = sc.nextInt();
			
			//범위를 벗어난 점수가 입력 되었을 때
			if(score[i]<0 ||score[i]>100) {
				System.out.println("*오류 : 0~100사이의 점수만 입력해주세요");
				i--;		//미리 1감소 후 다음 명령 실행
				continue;	//for문의 i++로 이동
			}else {
				sum+= score[i];
			}
		}
		
		//평균 계산
		avg = (double)sum/score.length;
		
		//출력
		System.out.print("입력한 점수들 : ");
		for(int i:score) {
			System.out.print(i+"\t");	
		}
		
		System.out.println("\n합계: "+sum);
		System.out.println("평균: "+avg);



	}

}
