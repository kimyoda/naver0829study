package bit701.day0914;

import java.util.Set;
import java.util.TreeSet;

public class Ex8_Set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Set<String> set = new HashSet<String>();//비순차적 
		Set<String> set = new TreeSet<String>();//순차적, 순서대로 나온다
		set.add("red");
		set.add("blue");
		set.add("green");
		set.add("green");
		set.add("red");
		set.add("red");
		set.add("blue");
		set.add("red");
		set.add("yellow");
		System.out.println(set.size());//중복된 거 제외하고 4개
		for(String s:set) {
			System.out.println(s);
		}
	}

}
