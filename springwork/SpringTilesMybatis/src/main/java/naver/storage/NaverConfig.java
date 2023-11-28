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
	
	// accessKey�� secretKey�� ���� ���̹� 2���������� ���� ���� ������ �Ұ��Ͽ� ���� ���̵��� ����Ű�� ��ũ��Ű�� �켱 ����
	@Value("KBWbeoPeKDJhL2RLATtd")
	private String accessKey;
	
	@Value("407hL347PDkJvmhw5olS0zH481ClFmArm2gKChPd")
	private String secretKey;
}
