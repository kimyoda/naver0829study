package bit701.day0914;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Ex7_Set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Set 인터페이스의 특징 : 1. 순차적이 아니다. 2. 중복허용을 안한다
//		Set<Integer> set = new HashSet<Integer>();//비순차적, 주로사용한다
		Set<Integer> set = new TreeSet<Integer>();//오름차순정렬되서 들어감
		System.out.println(set.size());//size는 데이타의 갯수(배열은 length)
		set.add(30);
		set.add(1);
		set.add(5);
		set.add(10);
		set.add(5);
		set.add(15);
		set.add(25);
		set.add(40);
		set.add(37);
		set.add(89);
		set.add(70);
		set.add(55);
		set.add(52);
		set.add(100);
		set.add(800);
		set.add(90);
		set.add(850);
		System.out.println(set.size());//5 (5는 1번만 계산)
		
		//컬렉션들을 출력하는 방법 여러가지가 있다
		//출력 1
		System.out.println("-----------------");
		for(Integer n:set) {
			System.out.println(n);	
		}
		System.out.println("-----------------");
		
		//출력2
		Iterator<Integer> iter = set.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println("-----------------");
	}

}
