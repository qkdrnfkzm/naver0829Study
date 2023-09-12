package bit701.book_test;

public class Ex3 {
	
	public static int sum(int ...n) {
		System.out.println("총 "+n.length+"개");
		int sum=0;
		for (int i = 0; i < n.length; i++) {
			sum+=n[i];
		}
		return sum;
	}
	
	public static void StringWrite(String ...str) {
		System.out.println("총 "+str.length+"개");
		for (int i = 0; i < str.length; i++) {
			System.out.print(str[i]+" ");
			
		}
	}
	
	
	public static void main(String[] args) {

		StringWrite("가","나","다");
		System.out.println();
		System.out.println(sum(1,3,5,6));
	}
}
