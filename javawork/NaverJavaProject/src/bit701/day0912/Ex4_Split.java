package bit701.day0912;

import java.util.StringTokenizer;

public class Ex4_Split {

	public static void main(String[] args) {
		
		String str1 = "red,blue,green,orange,gray";
		
		//문자열을 ,로 분리해서 배열에 담아보자
		String[] strArray=str1.split(",");
		System.out.println("총 "+strArray.length+"개로 분리됨");
		for (int i = 0; i < strArray.length; i++) {
			System.out.println(i+":"+strArray[i]);
		}
		System.out.println("-".repeat(20));
		
		String str2 ="sea.jpg";
		String[] str2Array = str2.split("\\.");		//"\\." 또는 "[.]" : split메소드는 정규표현식을 기반으로 동작하여 정규 표현식에 따라 분할 
		System.out.println(str2Array.length);
		System.out.println(str2Array[0]);
		System.out.println(str2Array[1]);
		System.out.println("-".repeat(20));
		
		String str3 = "red|green|yellow";
		String[] str3Array = str3.split("\\|");
		System.out.println(str3Array.length);
		for (int i = 0; i < str3Array.length; i++) {
			System.out.println(i+":"+str3Array[i]);
		}
		System.out.println("-".repeat(20));
		
		//자바의 클래스를 이요해서 분리하기
		StringTokenizer st = new StringTokenizer(str1,",");
		System.out.println("총 "+st.countTokens()+"개로 분리");		//.countTokens() : 하나씩 소비되기 때문에 for문에는 적합하지 않다 
		
		while(st.hasMoreElements()) {		//hasMoreElements : 다음 분리할 토큰이 있으면 true, 없으면 false
			System.out.println(st.nextToken());
		}
		System.out.println("-".repeat(20));
		
		
		StringTokenizer st2 = new StringTokenizer(str1,",");		//.countTokens() : for문이 한번 반복될 때마다 하나씩 소비되기 때문에 초기값을 변수로 지정하면 for문으로 사용할 수 있다.
		int count = st.countTokens();
		for(int i=0;i<count;i++)
		{
			System.out.println(st2.nextToken());
		}
	}
}
