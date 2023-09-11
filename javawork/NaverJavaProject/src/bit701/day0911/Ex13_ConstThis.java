package bit701.day0911;

/*
 * this: 자기 자신을 의미하는 인스턴스 변수, 인스턴스 멤버 메서드는 this라는 변수를 기본적으로 갖고있다
 * this() : this()는 생성자에서 다른 생성자 호출 시 사용하는 이름이다
 */
class kiwi{
	String name;
	int age;

	kiwi(){
		//System.out.println("생성자 호출");
		this("홍길동", 20);//3번째 생성자가 호출된다, this()는 반드시 첫줄에 입력되어야 한다
	}

	kiwi(String name){
		this(name,30);//3번째 생성자가 호출된다
	}

	kiwi(String name, int age){
		this.name = name;
		this.age = age;
	}

	public void writeData() {
		System.out.println("name:" + name + "\tage:"+ age);
	}
}

public class Ex13_ConstThis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		kiwi []karr = {
				new kiwi(),
				new kiwi("kim"),
				new kiwi("Lee",35)
		};
		for(kiwi k:karr) {
			k.writeData();
		}
	}

}
