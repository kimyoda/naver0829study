package day1109.test.anno;

import org.springframework.stereotype.Component;

@Component // xml�� �ڵ����� bean ��� id�� Ŭ�������� ���̵� �ȴ�(ù���ڰ� �ҹ���:annoCandaTire) 
public class AnnoCandaTire implements AnnoTire {

	@Override
	public String getTireName() {
		// TODO Auto-generated method stub
		return "������̼� ĳ���� Ÿ�̾�";
	}

}
