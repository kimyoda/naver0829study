package bit701.day0911;
//교재 클래스부분 20번 문제
public class Account {
	private String accountNo;//계좌번호
	private String accountName;//계좌주
	private int money;//잔액
	
	//3개의 값을 전달받는 생성자
	public Account(String accountNo, String accountName, int money) {
		this.accountName = accountName;
		this.accountNo = accountNo;
		this.money = money;
	}
	
	//계좌번호가 맞을경우 true를 반환해주는 메서드
	public boolean isAccount(String accountNo) {
		if(accountNo.equals(this.accountNo)) {
			return true;
		} else {
			return false;
		}
	}
	//  isAccount(String accountNo): 맞을경우 true 반환, 틀릴경우 false 반환(boolean)
	//내풀이
//	public blooean isAccount {
//		while(true){
//			System.out.println("계좌를 입력해주세요");
//			if(isAccount==10) {
//				System.out.println();
//			} else {
//				System.out.println("유효하지 않은 계좌 번호입니다. 다시 입력하세요.");
//		}
//	}
	
	//외부에서 입금 시 money에 추가하는 메서드(addMoney)
	public void addMoney(int money) {
		this.money += money;
	}
//		public int addMoney() {
//			this.money += money;
//		}
//	
	//외부에서 출금시 money에서 빼는 메서드(subMoney)
	public void subMoney(int money) {
		this.money -= money;
	}
//내풀이
		//	public int subMoney() {
//		this.money -= money;
//		retunr money;
	//출력해주는 메서드   계좌번호 예금주 잔액(accountWrite)
	public void accountWrite() {
		System.out.println(accountNo +"\t" + accountName + "\t" + money);
	}
}
