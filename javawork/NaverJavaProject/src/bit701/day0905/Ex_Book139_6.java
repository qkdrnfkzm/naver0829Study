package bit701.day0905;

public class Ex_Book139_6 {

	public static void main(String[] args) {

		for(int i=1;i<=5;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println("-".repeat(20));

		for(int i=1;i<=5;i++) {
			for(int j=i;j<=5;j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println("-".repeat(20));

		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				if(i==j) {
					System.out.print(i);	
				}else {
					System.out.print("*");
				}
			}
			System.out.println();
		}

		System.out.println("-".repeat(20));

		for(int i=5;i>=1;i--) {
			for(int j=1;j<=5;j++) {
				if(i==j) {
					System.out.print(i);	
				}else {
					System.out.print("*");
				}
			}
			System.out.println();
		}

	}
}
