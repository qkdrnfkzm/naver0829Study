package bit701.day0906;

import java.util.Scanner;

public class Ex9_ArraySearch {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);


		String[] name = {"강", "이", "은", "안", "조","송","피"};
		String searchName = "";

		//찾을 경우 배열 인덱스 값 저장
		int find =-1;		


		//검색할 이름
		System.out.println("검색할 이름을 입력하세요");
		searchName = sc.nextLine();


		//for문 : 같은 이름이 있을 경우 출력, find에 배열 인덱스 저장
		for(int i = 0;i<name.length;i++) {
			if(searchName.equals(name[i])) {
				find=i;
				break;
			}
		}

		//bFind 값에 따라 못찾은 경우 메시지 출력
		if(find==-1) {
			System.out.println(searchName+"님은 없어요");
		}else {
			System.out.println(searchName+"님은 "+(find+1) +"번째 있습니다");
		}

	}

}
