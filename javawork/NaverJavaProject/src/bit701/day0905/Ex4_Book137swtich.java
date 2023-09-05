package bit701.day0905;

import java.util.Scanner;

public class Ex4_Book137swtich {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int money = 0; 
		int total = 0;
		int num = 0;

		Exit:
			while(true) {
				System.out.println("=".repeat(30));
				System.out.println("1.예금 2.출금 3.잔고 4.종료");
				System.out.println("=".repeat(40));
				System.out.println("선택>");


				num= sc.nextInt();
				sc.nextLine();

				switch(num) {
				case 1:
					System.out.print("예금액 입력>");
					money = sc.nextInt();
					total += money;
					System.out.println(money + "원 예금되었습니다");
					break;

				case 2:
					System.out.print("출금액 입력>");
					money = sc.nextInt();
					total -= money;
					System.out.println(money + "원 출금되었습니다");
				case 3:
					System.out.print("잔고" + money);
					break;		

				case 4:
					break Exit;
				default:
				System.out.println("1-4로 입력할 것");	
				}	
			}
			System.out.println("프로그램 종료");

	}

}