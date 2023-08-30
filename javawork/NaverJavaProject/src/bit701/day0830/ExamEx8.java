package bit701.day0830;

public class ExamEx8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//money 변수에 args[0] 값을 대입후(급여:백만단위:5674321)
		//출력 
		//money: 5674321 원
		//만원짜리 567장
		//천원짜리 4장
		//백원짜리 3개
		//십원짜리 2개
		//일원짜리 1개
		//산술연산자를 사용해서 출력해보세요
		
		
		int money = Integer.parseInt(args[0]);
		int a = money/10000;
		int b = (money % 10000)/ 1000;
		int c = (money % 1000 / 100)% 100;
		int d = (money % 100 / 10)% 10;
		int e = money% 10;
		System.out.println("money: " + money+ "원");
		System.out.println("만원짜리 "+ a +"장");
		System.out.println("천원짜리 "+ b +"장");
		System.out.println("백원짜리 "+ c +"개");
		System.out.println("십원짜리 "+ d +"개");
		System.out.println("일원짜리 "+ e +"개");
	}

}
