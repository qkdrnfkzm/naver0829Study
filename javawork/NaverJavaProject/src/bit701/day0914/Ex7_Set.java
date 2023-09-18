package bit701.day0914;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Ex7_Set {
	public static void main(String[] args) {
		//Set 인터페이스의 특징 : 1.순차적이 아니다		2.중복허용을 안한다
		//Set<Integer> set = new HashSet<Integer>();	//HashSet : 비 순차적
		Set<Integer> set = new TreeSet<Integer>();		//TreeSet : 오름차순 정렬
		System.out.println(set.size());	//size는 데이터의 갯수
		set.add(30);
		set.add(27);
		set.add(1);
		set.add(5);
		set.add(10);
		set.add(5);
		set.add(7);
		System.out.println(set.size());	//3 => (5는 한번만 계산)
		System.out.println("------------");
		
		//컬렉션들을 출력하는 방법은 여러가지가 있다.
		//출력1
		for(Integer n:set) {
			System.out.println(n);
		}
		System.out.println("------------");
		
		//출력2
		Iterator<Integer> iter = set.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println("------------");
	}
}
