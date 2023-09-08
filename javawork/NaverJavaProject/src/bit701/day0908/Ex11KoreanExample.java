package bit701.day0908;

public class Ex11KoreanExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Ex11KoreanExample 객체 생성
		Ex11Korean k1 = new Ex11Korean("박자바", "011225-1234567");
		
		//Ex11KoreanExample 객체 데이터 읽기
		System.out.println("k1.nation: "+k1.nation);
		System.out.println("k1.name: "+k1.name);
		System.out.println("k1.ssn: "+k1.ssn);
		System.out.println();
		
		//또 다른 Ex11KoreanExample 객체 생성
		Ex11Korean k2 = new Ex11Korean("김자바", "930525-0654321");
		System.out.println("k2.nation: "+k2.nation);
		System.out.println("k2.name: "+k2.name);
		System.out.println("k2.ssn: "+k2.ssn);
		System.out.println();		
		
	}

}
