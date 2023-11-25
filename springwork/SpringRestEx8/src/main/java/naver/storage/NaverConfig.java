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
	
	// accessKey와 secretKey는 현재 네이버 2차인증으로 인해 내꺼 접속이 불가하여 강사님껄로 우선 대체 후 차후 변경
	@Value("8yt6c0uo9is9HLAN1BZH")
	private String accessKey;
	
	@Value("tmFGzatUiqw0C91hSR9Cx9jwPX5DWSzwLFRn3XC0")
	private String secretKey;
}
