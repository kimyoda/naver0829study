package naver.storage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

// 이건 왜 data를 안했는지 여쭤보기?
@Configuration
@Setter
@Getter
public class NaverConfig {

	@Value("https://kr.object.ncloudstorage.com")
	private String endPoint;
	
	@Value("kr-standard")
	private String regionName;
	
	// accessKey와 secretKey는 현재 네이버 2차인증으로 인해 내꺼 접속이 불가하여 원태 아이디의 인증키와 시크릿키로 우선 진행
	@Value("KBWbeoPeKDJhL2RLATtd")
	private String accessKey;
	
	@Value("407hL347PDkJvmhw5olS0zH481ClFmArm2gKChPd")
	private String secretKey;
}
