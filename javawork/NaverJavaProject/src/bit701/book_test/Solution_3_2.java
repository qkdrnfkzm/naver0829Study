package bit701.book_test;

public class Solution_3_2 {
	public int solution(int[] array) {
		int a = array.length/2;
        return array[a];
    }
	public static void main(String[] args) {
		Solution_3_2 s = new Solution_3_2();
		int[] a = {9,-1,0};
		s.solution(a);
		System.out.println(s.solution(a));
		
	}

}
