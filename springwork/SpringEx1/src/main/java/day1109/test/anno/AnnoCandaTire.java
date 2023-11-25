package day1109.test.anno;

import org.springframework.stereotype.Component;

@Component // xml에 자동으로 bean 등록 id가 클래스명이 아이디가 된다(첫글자가 소문자:annoCandaTire) 
public class AnnoCandaTire implements AnnoTire {

	@Override
	public String getTireName() {
		// TODO Auto-generated method stub
		return "어노테이션 캐나다 타이어";
	}

}
