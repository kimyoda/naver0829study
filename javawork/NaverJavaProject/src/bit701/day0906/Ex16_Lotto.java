package bit701.day0906;

import java.util.Random;

public class Ex16_Lotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 6개 할당된 lotto 변수에 1~45 사이의 난수를 발생하는데
		 * (중복 된 경우 다시 발생) 오름차순 정렬로 출력하시오
		 */
		//변수할당
		//강사님 풀이
		
		int []lotto = new int[6];
		//중복되지 않은 난수 발생
		for(int i=0; i<lotto.length; i++) {
			lotto[i] = (int)(Math.random() * 45) + 1;
			
			for(int j=0; j<i; j++) {
				if(lotto[i]==lotto[j]) {
					i--;
					break;//현재 반복문을 빠져나간 후 i++로 이더ㅗㅇ
				}
			}
		}
		//정렬(오름차순)
		for(int i=0; i<lotto.length-1; i++) {
			for(int j=i+1; j<lotto.length; j++) {
				if(lotto[i]>lotto[j]) {
					int temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp;
				}
			}
		}

		//출력
		for(int n:lotto) {
			System.out.printf("%4d", n);
		}

		
//		//내 풀이
//		Random r = new Random();
//		int []data = new int[6];
//
//		for(int i=0; i<data.length; i++) {
//			data[i] = r.nextInt(45)+1;
//		}
//
//
//		for(int i=0; i<data.length; i++) {
//			data[i] = r.nextInt(45)+1;
//			//중복처리 - 같은 숫자가 있을경우 다시 발생
//			for(int j=0; j<i; j++) {
//				if(data[i]==data[j]) {
//					i--;
//					break;
//				}
//			}
//		}
//
//		//출력(오름차순)
//		for(int i=0; i<data.length-1; i++) {
//			for(int j=i+1; j<data.length; j++) {
//				if(data[i]>data[j]) {
//					int temp = data[i];
//					data[i] = data[j];
//					data[j] = temp;
//				}
//			}
//		}
//		for(int i=0; i<data.length; i++) {
//			System.out.printf("%4d", data[i]);
//			if((i+1)%6==0) {
//				System.out.println();
//			}
//		}
		//		for(int n:lotto) {
		//			System.out.println(n);
		//		}
		//		

		//		
		//		Loop:
		//		for(int i=0; i<data.length; i++) {
		//			data[i] = r.nextInt(45)+1;
		//			//중복처리 - 같은 숫자가 있을경우 다시 발생
		//			for(int j=0; j<i; j++) {
		//				if(data[i]==data[j]) {
		//					i--;
		//					continue Loop;
		//				}
		//			}
		//		}
		//		for(int i=0; i<data.length; i++) {
		//			System.out.printf("%4d", data[i]);
		//			if((i+1)%6==0) {
		//				System.out.println();
		//			}
		//		}
	}

}
