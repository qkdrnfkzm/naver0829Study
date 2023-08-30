package bit701.day0830;

public class DataEx4 {

	public static void main(String[] args) {
		
		//16진수	//앞에 0x가 붙으면 16진수
		int a1=0xa3;	//a3(16) => 163(10) // a는 10, 10*16+3
		System.out.println(a1);
		
		int a2= 0xf4;	//15*16+4
		System.out.println(a2);
		
		int a3=0xa56;	//10*16^2 + 5*16^1 + 6*16^0 = 2646
		System.out.println(a3);
		
		
		//8진수		//앞에 0을 붙이면 8진수로 인식함
		int a4 = 045;	//0*8^2 + 4*8^1 + 5*8^0 = 37 
		System.out.println(a4);	

	}

}
