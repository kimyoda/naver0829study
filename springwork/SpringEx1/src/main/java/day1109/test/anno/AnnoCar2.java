package day1109.test.anno;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component("mycar2")
@AllArgsConstructor // 생성자 주입방식으로 자동주입한다

public class AnnoCar2 {

	AnnoKoreaTire koreaTire;
	AnnoCandaTire candaTire;
	
	public void myCarInfo() {
		System.out.println("내 차의 타이어는 " + koreaTire.getTireName() + " 입니다");
		System.out.println("겨울용 타이어는 " + candaTire.getTireName() + " 입니다");
	}
}
