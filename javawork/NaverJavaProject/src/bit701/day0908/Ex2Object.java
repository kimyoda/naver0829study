package bit701.day0908;
//파일명과 같은 이름만 다른 패키지에서 호출이 가능하다

import bit701.day0906.Ex13_ArraySort;

class Bitcamp{
		//인스턴스 멤버 변수
		String name;
		String address;
		//클래스 멤버변수 - Bitcamp로 생성된 여러 객체가 같은 데이타를 가질경우 static으로 선언한다.
		static final String STUDYNAME="네이버 클라우드 3기 자바웹";//static 뒤의 변수 선언은 대문자로 한다.
	
}
public class Ex2Object {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bitcamp stu1 = new Bitcamp();
		stu1.name = "이미자";
		stu1.address = "여의도";
		
		Bitcamp stu2 = new Bitcamp();
		stu2.name = "이기자";
		stu2.address = "제주도";
		
		System.out.println("** 학생 정보 1 **");
		System.out.println("이름:"+stu1.name);
		System.out.println("주소:"+stu1.address);
		System.out.println("스터디명:"+Bitcamp.STUDYNAME);
		
		System.out.println("=".repeat(30));
		System.out.println("** 학생 정보 2 **");
		System.out.println("이름:"+stu2.name);
		System.out.println("주소:"+stu2.address);
		System.out.println("스터디명:"+Bitcamp.STUDYNAME);
	}

}
