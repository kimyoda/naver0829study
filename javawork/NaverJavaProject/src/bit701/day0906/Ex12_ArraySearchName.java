package bit701.day0906;

import java.util.Scanner;

public class Ex12_ArraySearchName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []names = {"강호동","유재석","한채영","이효리","이승기"
				, "강남길", "이민정", "이서진", "손미나", "유미리"};
		/*
		 *  검색할 성은? 이
		 *  4: 이효리
		 *  5: 이승기
		 *  6: 이민정
		 *  8: 이서진
		 *  총 4명
		 *  
		 *  검색할 성은? 박
		 *  '박' 씨 성을 가진 멤버는 없습니다
		 *  
		 *  검색할 성은? 끝
		 *  종료합니다
		 *  
		 *  변수:searchSung, int count
		 *  	boolean bFind;
		 *  
		 *  System.out.println(str3.startsWith("Have"));//str3가 Have로 시작하면 true가 나온다
		 */
		Scanner sc = new Scanner(System.in);
		String searchSung;
		int count;
		boolean bFind;

		while(true) {//여러 번 입력할 경우 초기값을 while안에다가 넣어야 한다.

			count=0;
			bFind=false;

			System.out.print("검색할 성은?");
			searchSung = sc.nextLine();
			//종료
			if(searchSung.equals("끝")) {
				System.out.println("** 종료합니다 **");
				break;
			}
			for(int i=0; i<names.length; i++) {
				if(names[i].startsWith(searchSung)) {

					bFind=true;
					count++;
					System.out.println(i + 1 + ":" + names[i]);
				}
			}
			if(bFind) {
				System.out.println("** 총 "+count+"명 **");
			} else {
				System.out.printf("\" %s\" 씨성을 가진 멤버는 없습니다\n", searchSung);
				System.out.println();
				}
			}
		}
}
		
		// 내풀이
//		Scanner sc = new Scanner(System.in);
//		String searchSung = "";
//		int count;
//		boolean bFind = false;
//
//		//검색할 성 입력
//		System.out.println("검색할 성을 입력해주세요");
//		searchSung = sc.nextLine();
//
//		while (true) {
//			System.out.println("검색할 성을 입력해주세요");
//			searchSung = sc.nextLine();
//
//			if(searchSung.equals("프로그램종료")) {
//				System.out.println("프로그램 종료");
//				break;
//			}
//
//			for(int i=0; i<names.length; i++) {
//				if(names[i].startsWith(searchSung)) {
//					bFind = true;
//					System.out.println(searchSung+"님은"+(i+1)+"번째에 있습니다");
//					break;
//				}
//			}
//			//bFind값에 따라 못찾은 경우 메세지 출력
//			if(!bFind) {//if(bFind==false)
//				System.out.println(searchSung +"님은 명단에 없습니다");
//			}
//
//		}