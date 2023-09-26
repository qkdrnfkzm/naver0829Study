package bit701.book_test;

public class Coding_Test_0924 {
	public static void main(String[] args) {

		Solution1 s = new Solution1();
		s.solution(4, 14);
		

	}
}


class Solution1 {
	public int[] solution(int num, int total) {
    	int n;
    	int[] answer = new int[num];
    	n = (total-(num*num-num)/2)/num;
    	
    	for(int i=0;i<num;i++) {
    		answer[i]=n;
    		n++;    		
    	}
        return answer;
    }
}
