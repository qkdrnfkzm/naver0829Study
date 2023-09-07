package bit701.day0906;

import java.util.Scanner;

public class Ex8_ArraySearch {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String[] name = {"강", "이", "은", "안", "조","송","피"};
		String searchName = "";
		boolean bFind = false;
		//이름을 검색하여 몇번째 있는지 출력
		//없을 경우 "xxx님은 명단에 없습니다"

		//검색할 이름
		System.out.println("검색할 이름을 입력하세요");
		searchName = sc.nextLine();


		//for문 : 같은 이름이 있을 경우 출력, bFind = >true변경 후 break
		for(int i = 0;i<name.length;i++) {
			if(searchName.equals(name[i])) {
				bFind = true;
				System.out.println(searchName+"님은 "+(i+1)+"번째 있습니다.");
				break;
			}
		}

		//bFind 값에 따라 못찾은 경우 메시지 출력
		if(!bFind) {
			System.out.println(searchName+"님은 없어요");
		}

	}

}
