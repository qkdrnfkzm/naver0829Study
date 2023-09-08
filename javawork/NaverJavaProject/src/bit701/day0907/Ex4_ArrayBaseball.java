package bit701.day0907;

import java.util.Scanner;

public class Ex4_ArrayBaseball {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[] com=new int[3];
		int[] user=new int[3];
		String strNum;
		int ball, strike;

		//1~9 사이의 중복되지 않은 숫자를 배열에 담는다
		for(int i=0;i<com.length;i++) {
			com[i]=(int)(Math.random()*9)+1;
			for (int j = 0; j < i; j++) {
				if(com[i]==com[j]) {
					i--;
					break;
				}
			}
		}

		//System.out.printf("%d%d%d\n",com[0],com[1],com[2]);

		while(true) {

			System.out.println(">>");
			strNum=sc.nextLine();

			//strNum의 각 숫자를 user 배열에 정수 형태로 넣기
			user[0]=strNum.charAt(0)-'0';		//문자'1'은 정수로 49(ASCII값) : '1'-'0'=1  (49-48=1)
			user[1]=strNum.charAt(1)-'0';
			user[2]=strNum.charAt(2)-'0';

			//user와 com을 비교하여 숫자가 있지만 자리수가 안맞을 경우는 ball증가
			//숫자와 자릿수까지 맞을경우 strike 증가
			//strike가 3이 되면 저압입니다 출력 후 종료

			//변수 초기화
			ball=0;
			strike=0;

			//난수와 입력한 데이터값 비교
			for(int i=0;i<com.length;i++) {
				for (int j = 0; j < com.length; j++) {
					if(com[i]==user[j]) {
						if(i==j) {
							strike++;
						}else {
							ball++;
						}
					}
				}
			}

			//출력
			if(strike==3) {
				System.out.println("정답입니다! > "+com[0]+com[1]+com[2]);
				break;
			}else {
				System.out.println(strike+"S "+ball+"B");	
			}

			//종료
			if(strNum.equalsIgnoreCase("q")) {
				System.out.println("게임종료");
				break;
			}
		}

	}

}
