package bit701.day0901;

public class Ex6_1 {

	public static void main(String[] args) {
		
		for(int i=2;i<=9;i++)
		{
			System.out.println(i+"단");
			for(int j=1;j<=9;j++)
			{
				System.out.println(i+" X "+j+" = "+i*j+"\t");
			}
		}
		
		for(int i=2;i<=9;i++)
		{
			System.out.print("   "+i+"단\t\t");
		}
		System.out.println();
		
		
		
		for(int i=1;i<=9;i++)
		{
			for(int j=2;j<=9;j++)
			{	
				
				System.out.print(j+" X "+i+" = "+j*i+"\t");
			}
			System.out.println();
		}
		
	}
}
