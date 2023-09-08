package bit701.day0908;

public class Ex8BookCarExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Ex7BookCar 객체 생성
		Ex7BookCar myCar = new Ex7BookCar();
		
		//Ex7BookCar 객체의 필드값 읽기
		System.out.println("모델명: " + myCar.mdoel);
		System.out.println("시동여부: " + myCar.start);
		System.out.println("현재속도: " + myCar.speed);
	}

}
