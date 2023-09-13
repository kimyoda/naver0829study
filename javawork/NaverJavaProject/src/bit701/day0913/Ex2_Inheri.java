package bit701.day0913;
//1번 예제의 매서드들을 호출해보자



public class Ex2_Inheri {

	//인자를 SubA로 하면 SubA만 보낼 수 있다
//	public static void processPlay(SubA sub) {
//		sub.process();
//		
//	}
//	
//	public static void processPlay(SubB sub) {
//		sub.process();
//		
//	}
//	
//	public static void processPlay(SubC sub) {
//		sub.process();
//		
//	}
	
	//위 3개의 메서드를 하나로 줄여서 만드려면
	//인자를 부모클래스로 선언하면 된다
	public static void processPlay(SuperA sub) {
		
		//서브클래스의 메서드 중 호출할 수 있는 메서드는 오버라이딩 메서드뿐이다. 중요한 건 오버라이딩으로 처리한다.
		sub.process();//sub 변수에 누가 생성되어있느냐에 따라서 하는일이 달라진다(다형성)
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		processPlay(new SubA());
		processPlay(new SubB());
		processPlay(new SubC());
	}

}
