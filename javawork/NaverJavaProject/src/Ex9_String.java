
public class Ex9_String {

	public static void main(String[] args) {
		
		String str1 = "apple";
		String str2 = "Apple";
		String str3 = "Have a Good Day";
		String str4 = "   Happy   ";
		
		System.out.println(str3.length());				//문자열의 총 길이(공백 포함) : 15
		System.out.println(str1.toLowerCase());			//문자열을 모두 소문자로 변환
		System.out.println(str2.toUpperCase());			//문자열을 모두 대문자로 변환
		System.out.println(str3.substring(5));			//문자열의 5번째 문자부터 끝까지 출력 (0~)
		System.out.println(str3.substring(7,11));		//문자열의 7번재 문자부터 10(11-1)번재 문자 까지 출력 (0~)
		System.out.println(str3.charAt(0));				//0번째 char형태 문자 출력
		System.out.println(str3.charAt(7));				//7번재 char형태 문자 출력
		System.out.println(str1.indexOf('a'));			//a가 있는 index값 출력
		System.out.println(str3.lastIndexOf('a'));		//a가 있는 마지막 index값 출력
		System.out.println(str4.length());				//문자열의 총 길이(공백 포함) : 15
		System.out.println(str4.trim().length());		//문자열의 총 길이(앞, 뒤 공백 제외) : 5
		System.out.println(str3.startsWith("Have"));	//문자열이 해당 문자열("Have")로 시작하는지 boolean값
		System.out.println(str3.endsWith("day"));		//문자열이 해당 문자열("day")로 끝나는지 boolean값
		System.out.println(str1.equals(str2));			//str1이 str2와 값이 같은지 boolean값(대,소문자 구분)
		System.out.println(str1.equalsIgnoreCase(str2));//str1이 str2와 값이 같은지 boolean값(대,소문자 구분하지 않음)
		System.out.println(str1.compareTo(str2));		//str1과 str2의 ASCII코드 값의 차이(양수 값: str1이 더 큰값 / 음수 값 : str2가 더 큰값)
		System.out.println(str1.compareTo("apple"));	//완전 같을 경우 0
		

	}

}
