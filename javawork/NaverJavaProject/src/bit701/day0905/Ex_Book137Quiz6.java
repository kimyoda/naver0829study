package bit701.day0905;

public class Ex_Book137Quiz6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		* 별 뽑기
//        for (int i = 1; i <= 5; i++) {
//            for (int j = 1; j <= i; j++) { // 내부 루프 수정
//                System.out.print("*"); // println 대신 print를 사용하여 줄 바꿈 없이 출력
//            }
//            System.out.println(); // 한 행을 출력한 후에 줄 바꿈
//        }
//    }
//}
//		역 *for문
//      for (int i = 1; i <= 5; i++) {
//      for (int j = i; j <= 5; j++) { // 내부 루프 수정
//          System.out.print("*"); // println 대신 print를 사용하여 줄 바꿈 없이 출력
//      }
//      System.out.println(); // 한 행을 출력한 후에 줄 바꿈
//  }
//}
//}
//		for(int i=1; i<=5; i++) {
//			for(int j=1; j<=i; j++) {
//				System.out.print("*");
//			}//안쪽끝
//			System.out.println();
//		}//바깥끝
//	}	
//	}
	for(int i=1; i<=5; i++) {
		for(int j = 1; j<=5; j++) {
			if(i==j) {
				System.out.print(i);
			} else {
				System.out.print("*");
			}
		}
		System.out.println();
	}
	}
}

