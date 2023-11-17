package naver.storage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

// �̰� �� data�� ���ߴ��� ���庸��?
@Configuration
@Setter
@Getter
public class NaverConfig {

	@Value("https://kr.object.ncloudstorage.com")
	private String endPoint;
	
	@Value("kr-standard")
	private String regionName;
	
	// accessKey�� secretKey�� ���� ���̹� 2���������� ���� ���� ������ �Ұ��Ͽ� ����Բ��� �켱 ��ü �� ���� ����
	@Value("8yt6c0uo9is9HLAN1BZH")
	private String accessKey;
	
	@Value("tmFGzatUiqw0C91hSR9Cx9jwPX5DWSzwLFRn3XC0")
	private String secretKey;
}
