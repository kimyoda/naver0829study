package bit701.day0905;

import java.util.Scanner;

public class Ex5_Book159 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//970303-2222123
		//97년 03월 03일생으로 맏늘고
		//내국인 1,2,3,4
		//여성 5,6,: 외국인
		// 8 or q일 경우 종료 "프로그램을 종료합니다"
		//		String ssn = "9506241230123";
		//		char sex = ssn.charAt(6);
		//		switch (sex) {
		//			case '1':
		//			case '3':
		//				System.out.println("남자입니다");
		//				break;
		//			case '2':
		//			case '4':
		//				System.out.println("여자입니다");
		//				break;
		//		}
		//		String nn;
		//
		//		
		//		Scanner sc = new Scanner(System.in);
		//		int num = 0;
		//		
		//		while(true) {
		//			System.out.println("주민번호를 입력하세요");
		//			nn=sc.nextLine();
		//			
		//            if (nn.equalsIgnoreCase("q")) {
		//                System.out.println("프로그램을 종료합니다.");
		//                break; // 무한 루프 종료
		//            }
		//            
		//			System.out.println("주민번호 : " + num);
		//			sc.nextLine();	
		//			System.out.printf("저는 %d년 %d월 %d일생\n");
		//
		//			String yearStr = nn.substring(0,2);
		//			String monthStr = nn.substring(2,4);
		//			String dayStr = nn.substring(4,6);
		//			
		//			int year = Integer.parseInt(yearStr);
		//			int month = Integer.parseInt(monthStr);
		//			int day = Integer.parseInt(dayStr);
		//			
		//			char genderChar = nn.charAt(7);
		//			
		//
		//			
		//			Exit:
		//			switch(genderChar) {
		//			case '1':
		//			case '3':
		//				System.out.println("내국인 남성");
		//				break;
		//
		//			case '2':
		//			case '4':
		//				System.out.println("내국인 여성");
		//				break;
		//				
		//			case '5':
		//			case '6':
		//		        System.out.println("외국인");
		//		        break Exit;
		//			default:
		//				System.out.println("잘못된 주민번호 형식입니다.");	
		//			}
		//
		//			
		//		}
		//		System.out.println("프로그램을 종료하려면 q를 입력하세요");
		Scanner sc=new Scanner(System.in);
		String jumiNo;

		while(true) {
			System.out.println("주민등록번호 입력");
			jumiNo=sc.nextLine();
			//q or Q 입력시 종료
			if(jumiNo.equalsIgnoreCase("q")) {
				System.out.println("Program End!!!");
				break;
			}
			String yearStr=jumiNo.substring(0,2);
			String monStr=jumiNo.substring(2,4);
			String dayStr=jumiNo.substring(4,6);
			char gender=jumiNo.charAt(7);
			System.out.println(yearStr+"년"+monStr+"월"+dayStr+"일");

			if(gender =='1' || gender == '2' || gender == '3' || gender == '4') 
				System.out.println("내국인");
			else if(gender == '5' || gender == '6')
				System.out.println("외국인");
			else
				System.out.println("8번째 값을 잘못  입력했어요");

			switch(gender) {
			case '1': case '3': case'5'://주민번호에서 성별 정보는 '1'~'4'로 문자로 표현됨
				System.out.println("남자!");
				break;
			case '2': case '4': case'6':
				System.out.println("여자!");
				break;	
			default:
				System.out.println("성별 알수 없음!!");
			}
		}
	}	
}
