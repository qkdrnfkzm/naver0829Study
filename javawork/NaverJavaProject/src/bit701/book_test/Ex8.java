package bit701.book_test;

import java.util.Iterator;
import java.util.Scanner;

public class Ex8 {
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int su;
		
		MyStudent[] stu;
		
		System.out.print("머리수:");
		su = Integer.parseInt(sc.nextLine());
		
		stu = new MyStudent[su];
		
		for (int i = 0; i < stu.length; i++) {
			System.out.println(i+1+"번 이름");
			String name = sc.nextLine();
			System.out.println(i+1+"번 국어");
			int kor = Integer.parseInt(sc.nextLine());
			System.out.println(i+1+"번 영어");
			int eng = Integer.parseInt(sc.nextLine());
			
			stu[i] = new MyStudent(name, kor, eng);
		}
		
		System.out.println("이름\t국어\t영어\t합계\t평균\t등급");
		for (int i = 0; i < stu.length; i++) {
			System.out.println(stu[i].getName()+"\t"+stu[i].getKor()+"\t"+stu[i].getEng()+"\t"+stu[i].getTotal()+"\t"+stu[i].getAvg()+"\t"+stu[i].getGrade());
		}
		
	}
	
	
	
	

}
