package bit701.day0908;

public class Ex10BookCarExample2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Ex10BookCar2 객체 생성
		Ex9BookCar2 myCar = new Ex9BookCar2();
		
		//Ex10BookCar2 객체의 필드값 읽기
		System.out.println("제작회사: " + myCar.company);
		System.out.println("차량종류: " + myCar.model);
		System.out.println("모델명 : " + myCar.color);
		System.out.println("최고속도: " + myCar.maxSpeed);
		System.out.println("현재속도: " + myCar.speed);
		
		//Ex10BookCar2 객체의 필드값 변경
		myCar.speed = 60;
		System.out.println("수정된 속도: " + myCar.speed);
	}

}
