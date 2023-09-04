package bit701.day0901;
import java.text.NumberFormat;
import java.util.Scanner;

public class Ex2_Score {

	public static void main(String[] args) {
		
		/*
		 * 이름, 3과목으 ㅣ점수(kor, eng, mat) 를 입력받은 후 총점과 평균(소숫점 1자리 출력 - NumberFormat)
		 * 그리고 등급을 출력(grade: 평균 90이상이면 "Excellent", 80이상이면 "Good", 나머지는 "Try" 라고 출력
		 * if-else문을 사용
		 */
		
		//선언
		Scanner sc = new Scanner(System.in);
		NumberFormat numFormat = NumberFormat.getInstance();
		numFormat.setMaximumFractionDigits(1);
		String name="";
		int kor, eng, mat, total=0;
		double avg=0;
		String grade="";
		
		
		//입력
		System.out.println("이름을 입력하세요");
		name = sc.nextLine();
		System.out.println("국어점수를 입력하세요");
		kor = sc.nextInt();
		System.out.println("영어점수를 입력하세요");
		eng = sc.nextInt();
		System.out.println("수학점수를 입력하세요");
		mat = sc.nextInt();
		
		
		//계산
		total = kor+eng+mat;
		avg=total/3.0;
		
		if(avg>=90) {
			grade="Excellent";
		}else if (avg>=80) {
			grade="Good";
		}else {
			grade="Try";
		}
		
		
		//출력
		System.out.println("이름 : "+name);
		System.out.println("국어점수 : "+kor+" 점");
		System.out.println("영어점수 : "+eng+" 점");
		System.out.println("수학점수 : "+mat+" 점");
		System.out.println("총점 : "+total+" 점");
		System.out.println("평균 : "+numFormat.format(avg)+" 점");
		System.out.println("등급 : "+grade);

	}

}
