package bit701.day0831;

import java.util.Scanner;

public class Ex10_Exam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 *  상품명과 수량, 단가를 각각 입력받은후 총금액을 출력하시오
 *  그리고 수량이 5개 이상일경우 10프로 할인된 최종 금액도 출력해주세요
 *  
 *  (예)
 *  상풍명: 딸기
 *  수량:6
 *  단가:1000
 *  
 *  총금액: 6000원
 *  5개 이상 10프로 할인된 금액 : 5400원
 */
//5개 이상일때
//5개 이하일 때
//10프로 할인된 최종 금액출력
	Scanner sc=new Scanner(System.in);
	System.out.println("상풍명을 입력하세요");
	String product = sc.nextLine();
	
	System.out.println("수량:");
	int num  = sc.nextInt();
	
	System.out.println("단가:");
	int price = sc.nextInt();
	
	
	int total = price*num;
	System.out.println("총금액" + total + "원");
	
	
	if(num>=5) {
	System.out.println("5개 이상 10프로 할인된 금액:"+ (total - (total/10)));
//	System.out.println("5개 이상 10프로 할인된 금액:"+  원);
			
	}
	}
}
