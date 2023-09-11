package bit701.day0911;

import java.util.Scanner;

public class Ex9_SawonInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		sawon []sa = new sawon[3];
		
		//3명의 사원에 대한 정보 입력후 배열하기
		for(int i=0; i<sa.length; i++) {
			System.out.println(i+"번 사원명:");
			String name = sc.nextLine();
			System.out.println("\t기본급은?");
			int gibon = Integer.parseInt(sc.nextLine());
			System.out.println("\t수당은?");
			int sudang = Integer.parseInt(sc.nextLine());
			System.out.println("\t가족수는?");
			int familysu = Integer.parseInt(sc.nextLine()); 
			
			//개체 생성
			sa[i] = new sawon(name, gibon, sudang, familysu);
		}
		//개
//		System.out.println("정보를 입력할 인원수는?");
//		int sa1Length = Integer.parseInt(sc.nextLine());
//		Sawon[] sa1 = new Sawon[sa1Length];
//		for(int i = 0; i < sa1.Length.; i++) {
//			System.out.println(i+ "사원의 이름은?");
//			String name = sc.nextLine();
//			System.out.println(i + "번의 국어점수는?");
//			int kor = Integer.parseInt(sc.nextLine());
//			System.out.println(i + "번의 영어점수는?");
//			int eng = Integer.parseInt(sc.nextLine());
//			
//			//MyStudent 해당 배열번지를 생성
//			stu[i] = new MyStudent(name, kor, eng);	
//		}
		//출력
		System.out.println("이름\t기본급\t수당\t가족수\t가족수당\t세금\t실수령액");
		System.out.println("=".repeat(60));
		for(sawon s:sa) {
			System.out.println(s.getName()+"\t"+s.getGibon()+"\t"+s.getSudang()+"\t"+s.getFamilySu()+"\t"+
		s.getFamilySudang()+"\t\t"+s.getTax()+"\t"+s.getNetPay());
		}
	}
	
}
