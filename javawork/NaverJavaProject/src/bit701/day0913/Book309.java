package bit701.day0913;

class Parent{

	public void method1() {
		System.out.println("Parent-method1");
	}
	
	public void method2() {
		System.out.println("Parent-method2");
	}
}

//상속받는 클래스 구현
class Child extends Parent{//child로 하면 method3도 같이 호출된다. parent는 위에 parent가 호출되고 밑의
	//Child method2가 호출이 된다
	@Override
	public void method2() {
		System.out.println("Child-method2");
	}
	
	public void method3() {
		System.out.println("Child-method3");
	}
}

public class Book309 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Child a = new Child();
		a.method1();//상속받은 메서드, 부모1
		a.method2();//Child의 method2가 호출된다./자식1
		a.method3();//Child에만 있는 메서드/자식2
		System.out.println("-----------");
		Parent b = new Child();
		b.method1();
		b.method2();
		//b.method3();//오류 발생, Child의 오버라이드한 메서드만 호출 가능
		((Child)b).method3();//강제로 Child로 형변환후 호출이 가능은 하다
	}

}
