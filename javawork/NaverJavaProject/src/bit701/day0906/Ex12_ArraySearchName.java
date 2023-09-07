package bit701.day0906;

import java.util.Scanner;

public class Ex12_ArraySearchName {

	public static void main(String[] args) {

		/*	검색할 성은? 이
		 * 		3. 이홍기
		 * 		4. 이승기
		 * 		9. 이민정
		 * 			총 3명
		 * 	
		 * 	검색할 성은? 박
		 * 		"박"씨 성을 가진 멤버는 없습니다
		 * 	
		 * 	검색할 성은? 끝
		 * 		종료합니다
		 * 
		 * 	변수 : String searchSung;
		 * 			int count;
		 * 			boolean bFind;
		 * 
		 * 	startsWith를 이용해서 프로그램을 작성해보시오
		 */

		Scanner sc = new Scanner(System.in);

		String[] names= {"강호동","유재석","이홍기","이승기","민경훈","정준하","정형돈","민효린","이민정","박명수","손호준","손흥민"};
		String searchSung;
		int count;
		boolean bFind;

		while(true) {
			count=0;
			bFind=false;

			System.out.print("검색할 성은?");
			searchSung=sc.nextLine();

			//종료
			if(searchSung.equals("끝")) {
				System.out.println("\t종료합니다");
				break;
			}

			//검색
			for(int i=0;i<names.length;i++) {
				if(names[i].startsWith(searchSung)) {
					bFind=true;
					count++;
					System.out.println(i+1+". "+names[i]);
				}
			}
			if(bFind) {
				System.out.println("\t총 "+count+"명\n");	
			}else
				System.out.println(searchSung+"씨 성은 없습니다\n");

		}

	}

}

