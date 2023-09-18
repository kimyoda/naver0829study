package bit701.day0918;
//자바에서의 함수형 프로그램인 람다 표현식은 인터페이스를
//사용하는 익명 내부클래스의 또다른 표현식이다
//단, 인터페이스는 단하나의 추상 메서드만 가지고 있어야한다


@FunctionalInterface
interface Orange {
	public void write();
	//public void show();//@FunctionalInterface는 메서드가 하나인지 아닌지 검증하는 역할, 오류를 발생시킨다
}

@FunctionalInterface
interface DataAdd {
	public void add(int x, int y);
}


public class Ex4_Lambda {

	//우리가 알고있는 익명 내부클래스 형태로 객체를 생성해보자
	public void absMethod1() {
		Orange or = new Orange() {
			
			@Override
			public void write() {
				// TODO Auto-generated method stub
				System.out.println("안녕하세요 ^^");
			}
		};
		
		or.write();
	}
	
	//람다식으로 오버라이드해보기
	
	public void absMethod2() {
		Orange or = ()->System.out.println("반가워요 ^^");//메서드의 코드가 한줄일 경우 {} 생략
		or.write();
	
		//오버라이드 메서드의 코드가 2줄 이상일 경우 {} 안에서 주면 된다
		Orange or2 = ()-> {
			System.out.println("람다람다~~");
			System.out.println("여러줄 썼어요!!!");
		};
		or2.write();
	}
	
	public void absMethod3() {
		
		//기존 방식 - 익명 내부 클래스
//		DataAdd add1 = new DataAdd() {
//			public void add(int x, int y) {
//				// TODO Auto-generated method stub
//				System.out.println(x+ "+"+ y +"="+(x+y));
//			}
//		};
		
		//람다식으로 변경해보기
		
		DataAdd add1 = (int x1, int y1)->System.out.println(x1+ "+"+ y1 +"="+(x1+y1));//메서드의 코드가 한줄일 경우 {} 생략
		add1.add(100,200);
		add1.add(5, 7);

	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex4_Lambda ex = new Ex4_Lambda();
		ex.absMethod1();
		ex.absMethod2();
		ex.absMethod3();
		
	}


}
