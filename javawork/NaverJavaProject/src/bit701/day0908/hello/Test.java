package bit701.day0908.hello;

public class Test {
	
	public static void main(String[] args) {
		
		Solution solution = new Solution();
		int result = solution.solution(100, 2);
		if(result==-10000) {
			System.out.println("이탈");
		}else {
			System.out.println(result);	
		}
		
		
	}
}

class Solution {
    public int solution(int num1, int num2) {
        int answer = 0;
        if(num1>0&&num1<=100&&num2>0&&num2<=100) {
        	answer = num1/num2;	
        }else {
        	answer=-10000;
        }
        
        return answer;
    }
}