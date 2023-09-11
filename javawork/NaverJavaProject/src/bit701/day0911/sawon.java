package bit701.day0911;

public class sawon {
	private String name; //사원명
	private int gibon; //기본급
	private int sudang; //수당
	private int familySu;//가족수당

	//멤버변수 4개를 인자로 받아서 전달할 생성자
	public sawon(String name, int gibon, int sudang, int familysu) {
		this.name = name;
		this.gibon = gibon;
		this.familySu = familySu;
		this.sudang = sudang;
	}
	//내풀이
	//	public sawon(String name, int gibon, int sudang, int familySu){
	//		this.name = name;
	//		this.gibon = gibon;
	//		this.sudang = sudang;
	//		this.familySu = familySu;

	//멤버변수 4개의 getter method
	public String getName() {
		return name;
	}
	public int getGibon() {
		return gibon;
	}
	public int getSudang() {
		return sudang;
	}
	public int getFamilySu() {
		return familySu;
	}
	//내 풀이
	//	public String getName() {
	//		return name;
	//	}
	//	public int getGibon() {
	//		return gibon;
	//	}
	//	public int getSudang() {
	//		return sudang;
	//	}
	//	public int getfamilySu() {
	//		return familySu;
	//	}
	//가족수에 따른 수당 반환하는 메서드
	//3인이상이면 10000, 나머지는 50000
	// getFamilySudang()
	public int getFamilySudang() {
		if(familySu>=3) {
			return 10000;
		} else {
			return 50000;
		}
	}
		// 내풀이
		public int getTax() {
			return gibon*5/100;
		}
		//	public String getFamilySudang() {
		//		int fs = this.getfamilySu();
		//		if(fs>=3) {
		//			return "10000";//가족 수가 3인 이상이면 10000을 반환
		//		} else {
		//			return "50000";
		//		}
		//
		//	}

		//세금반환하는 메서드
		//기본급의 5프로 반환
		// getTax()
		public int getNetPay() {
			return gibon + sudang + getFamilySu()-getTax();
		}
		// 내풀이
		//	public double getTax() {
		//		double gibon = this.getGibon();
		//		double tax = gibon * 0.05;//기본급 계산
		//		return tax; 	
		//	}
		//실제 받을 실수령액을 리턴하는 메서드
		// 기본급 + 수당 + 가족수당 - 세금
		// getNetPay()
		//내 풀이
		//	public double getNetpay() {
		//		double gibon = this.getGibon();
		//		double sudang = this.getSudang();
		//		double familySu = this.getfamilySu();
		//		double tax = this.getTax();
		//
		//		double netpay = gibon + sudang + familySu - tax;
		//		return netpay;
	}
