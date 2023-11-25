package day1109.test.anno;

import org.springframework.stereotype.Component;

@Component
public class AnnoKoreaTire implements AnnoTire {

	@Override
	public String getTireName() {
		// TODO Auto-generated method stub
		return "어노테이션 한국 타이어";
	}

}
