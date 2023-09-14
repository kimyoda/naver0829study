package bit701.day0914;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Ex14_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new Vector<String>();
		list.add("장미꽃");
		list.add("안개꽃");
		list.add("장미꽃");
		list.add("국화꽃");
		list.add("할미꽃");
		System.out.println("출력 1 방법");
		for(int i = 0; i<list.size(); i++) {//제일 많이쓰는 방법2
			String s = list.get(i);
			System.out.println(s+" ");
		}
		System.out.println("\n========\n출력 2 방법");
		for(String s:list) {//제일 많이 쓰는 방법
			System.out.println(s + " ");
				
		}
		System.out.println("\n==========\n출력 3방법");
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next()+" ");
		}
		System.out.println("\n===========\n출력 4방법");
		Object []data = list.toArray();
		for(Object ob:data) {
			System.out.println((String)ob + " ");
		}
	}

}
