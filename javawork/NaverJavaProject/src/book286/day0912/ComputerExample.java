package book286.day0912;

class Calculator {
	//메소드 선언
	public double areaCircle(double r) {
		System.out.println("Calculator 객체의 areaCircle() 실행");
		return 3.14159 * r * r;
		//원주율 구하는 문제여서 반지름 r을 사용한 원의 넓이를 계산한 것,
		//첫번째 r은 반지름, 두 번째 r은 반지름음 제곱한 값

	}
}	
	class Computer extends Calculator {
	//메소드 오버라이딩
	@Override
	public double areaCircle(double r) {
		System.out.println("Computer 객체의 areaCircle() 실행");
		return Math.PI * r * r;
	}
}
	public class ComputerExample {
		public static void main(String[] args) {
			int r = 10;
			
			Calculator c1 = new Calculator();
			System.out.println("원 면적: " + c1.areaCircle(r));
			System.out.println();
			
			Computer computer = new Computer();
			System.out.println("원 면적: " + computer.areaCircle(r));
		}


	}

