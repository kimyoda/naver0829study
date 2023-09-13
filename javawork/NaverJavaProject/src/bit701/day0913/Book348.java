package bit701.day0913;

interface RemoteControl{
	//상수
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;

	//추상 메서드
	void turnOn();
	void tunrOff();
	void setVolume(int volume);
	
	//jdk8 예시 추가된 기능
	//디폴트 인스턴스 메서드 - 기능 구현이 가능하다
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("무음 처리합니다");
			setVolume(MIN_VOLUME);
		} else {
			System.out.println("무음 해제합니다");
		}
	}
}

class Television implements RemoteControl{

	private int volume; 

	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다!");
	}

	@Override
	public void tunrOff() {
		System.out.println("TV를 끕니다!");
	}

	@Override
	public void setVolume(int volume) {
		if(volume>RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		} else if(volume<MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		} else {
			this.volume = volume;
		}
		System.out.println("현재 볼륨은 "  + volume + "입니다");//여기서 volume일때 매개변수, this가 붙으면 필드에 값 저장한 volume
	}

}

public class Book348 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoteControl rc = null;
		rc = new Television();
		rc.turnOn();
		rc.tunrOff();
		rc.setVolume(5);
		//디폴트 메서드 호출
		rc.setMute(false);
		rc.setMute(true);
		
//		RemoteControl rc2=null;//인터페이스라 생성할 수 없다.
//		rc2.setMute(false);//반드시 구현하는 클래스가 있어야만 호출이 가능하다
	}

}
