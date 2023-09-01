package bit701.day0901;

import java.util.Scanner;

public class Ex5_ForExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		//1. 숫자n을 입력받은 후 1부터 n까지의 총 합계를 출력하시오
		//입력
//		int n;
//		int sum=0;
//		System.out.println("합계를 구할 숫자 입력");
//		n=sc.nextInt();
//		//1부터 n까지의 총 합 구하기
//		//계산
//		for(int a=1; a<=n; a++)
//			sum+=a;
//		//출력
//		System.out.println("1부터"+n+"까지의 합은" +sum+"입니다"); 문제해답
		
		/*2. 구구단 숫자 2-9 사이의 숫자를 입력받은 후 범위를 벗어날 경우
		 "잘못 입력하여 종료합니다"라고 종료!
		 제대로 입력 시 해당 구구단 출력
		 ** 5단 **
		 5 x 1 = 5
		 5 x 2 = 10
		 .... 5 x 9 = 45
		*/
		//입력
		int dan;
		System.out.println("출력할 구구단은?");
		dan=sc.nextInt();
		if(dan<2 || dan>9)
		{
			System.out.println("잘못된 숫자입니다");
			return;
		}
		System.out.println("\t**"+dan+"단 **\n");
		
		for(int i=1;i<=9;i++)
		{
			System.out.printf("%6d X %d = %2d\n", dan,i,dan*i);
		}
		//문제1번 내식대로 풀이(인터넷참고)
//		Scanner sc=new Scanner(System.in);
//		
//		System.out.println("숫자 n을 입력하세요");
//		int n = sc.nextInt();
//		
//		int sum = 0;
//		for(int i=1;i<=n;i++)
//			sum +=1;
//		System.out.println();
//		System.out.println("1부터" +n+" 까지의 합은 15입니다\n"+sum);//"="을 30번 반복
//		
		//문제2번 푸는중
		
		//입력
		
//		System.out.println("숫자를 입력하세요");
//		
//		//계산
//		Exit:// 레이블명은 자기 마음대로 지정한다
//			for(int i=0;i<=10;i++)
//			{
//				System.out.println("i="+i);
//				for(int j=1;j<=5;j++)
//				{
//					System.out.printf("%3d", j);
//					if(j==3)
//						break Exit;//j가 3이되면 두개의 반복문을 모두 빠져나간다
//				}
//				System.out.println();
//			}
//			System.out.println("-".repeat(30));
//		//출력
	}

}
