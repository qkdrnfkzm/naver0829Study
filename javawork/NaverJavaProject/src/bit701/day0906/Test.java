package bit701.day0906;


import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		String[] name = {"강", "이", "은", "안", "조","송","피"};
		String searchName = "";
		boolean bFind = false;
		
		System.out.println("검색");
		searchName=sc.nextLine();
		
		for (int i = 0; i < name.length; i++) {
			if(searchName.equals(name[i])) {
				System.out.println(i+1+"번째");
				bFind=true;
				break;
			}
			
		}
		if(!bFind) {
			System.out.println("없어요");
		}
		
		
	}

}
