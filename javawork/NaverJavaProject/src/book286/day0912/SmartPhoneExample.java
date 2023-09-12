package book286.day0912;

class Phone {
	//필드선언
	public String model;
	public String color;

	//메소드 선언
	public void bell() {
		System.out.println("벨이 울립니다.");
	}

	public void sendVoice(String message) {
		System.out.println("자기: " + message);
	}

	public void receiveVoice(String message) {
		System.out.println("상대방: " + message);
	}

	public void hangUp() {
		System.out.println("전화를 끊습니다");
	}

}


class SmartPhone extends Phone {
	//필드선언
	public boolean wifi;

	//생성자 선언
	public SmartPhone(String model, String color) {
		//super 생략
		this.model = model;
		this.color = color;
	}
	//메소드 선언
	public void setWifi(boolean wifi) {
		this.wifi = wifi;
		System.out.println("와이파이 상태를 변경헀습니다");
	}

	public void internet() {
		System.out.println("인터넷에 연결합니다.");
	}


}
public class SmartPhoneExample {
	public static void main(String[] args) {
		//객체생성
		SmartPhone myPhone = new SmartPhone("갤럭시", "은색");

		//Phone으로부터 상속받은 필드 일긱
		System.out.println("모델: " + myPhone.model);
		System.out.println("색상: " + myPhone.color);

		//SmartPhone의 필드 읽기
		System.out.println("와이파이 상태: " + myPhone.wifi);

		//Phone으로부터 상속받은 메소드 호출
		myPhone.bell();
		myPhone.sendVoice("여보세요");
		myPhone.receiveVoice("안녕하세요! 저는 김요한인데요.");
		myPhone.sendVoice("아~ 안녕하세요");
		myPhone.hangUp();

		//메소드 호출
		myPhone.setWifi(true);
		myPhone.internet();
	}
}



