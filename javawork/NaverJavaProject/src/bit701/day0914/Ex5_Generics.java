package bit701.day0914;

//<T>는 T가 타입 파라미터임을 뜻하는 기호로, 타입이 필요한 자리에 T를 사요한다
class GenericsType<T>{
	T[] v;
	
	public void set(T[] n) {
		v=n;
	}
	public void print() {
		for (T s : v) {
			System.out.println(s+" ");
		}
		System.out.println();
	}
}

public class Ex5_Generics {
	public static void main(String[] args) {
		
		String[] sarr= {"장미꽃","안개꽃","다알리아"};
		
		//T에 대체되는 타입은 클래스 타입이나 인터페이스만 가능하다(String, Integer...) / (int 등은 안됨)
		GenericsType<String> t1 = new GenericsType<>();
		t1.set(sarr);
		t1.print();
		System.out.println("-------------------------");
		
		GenericsType<Integer> t2 = new GenericsType();	//int 사용 시 에러
		//int 타입은 자동으로 Integer 타입으로 변환되어 들어간다(오토박싱)
		Integer[] narr= {1,3,5,7,9};
		t2.set(narr);
		t2.print();
	}
}
