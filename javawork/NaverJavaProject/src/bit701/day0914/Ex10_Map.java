package bit701.day0914;

import java.util.HashMap;
import java.util.Map;

public class Ex10_Map {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Map:key와 value의 쌍으로 저장되는 형태(이때 key 는 set 타입)
		Map<String,String> map = new HashMap<String, String>();
		map.put("name", "김태희");
		map.put("age", "30세");
		map.put("addr", "강남구");
		map.put("name", "송혜교");//같은 key값이 존재할 경우 덮어쓴다
		System.out.println("갯수: " + map.size());
		//key값을 알아야 value값을 얻을 수 있다
		System.out.println("이름: " + map.get("name"));
		System.out.println("나이: " + map.get("age"));
		System.out.println("주소: " + map.get("addr"));
		System.out.println("혈액형: " + map.get("blood"));//해당 key값이 없을경우 null 값이 반환
		
		System.out.println("addr 키값을 제거해보자");
		map.remove("addr");
		System.out.println("주소: " + map.get("addr"));//제거되었으므로 null 값 반환
	}

}
