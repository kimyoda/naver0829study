package day1109.test.anno;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component // id:annoCar  
@Component("mycar") // ���̵� �����ϰ� ������ �ȿ� ���� �ְ� �����ϸ� �ȴ�.
public class AnnoCar {

	// @Autowired // �ڵ� ���� - ���� �߻�: ��Ī ������ Ŭ������ 2���̹Ƿ� ������ �߻��Ͽ���.
	// AnnoTire annoTire;
	
	// �������̽��� ������ Ŭ������ �������� ��� ��Ȯ�ϰ� Ŭ���������� �����ϸ� �ȴ�
	// �����ϰ� ������ �˾Ƽ� �ڵ������� �����ϴ�
	@Autowired
	//AnnoCandaTire annoTire;
	//AnnoKoreaTire annoTire;
	
	@Resource(name = "annoKoreaTire")  // �������̽��� ������ Ŭ������ �������� ��� �� ��� �����ش�(������ ��������)
	AnnoTire annoTire;
	
	public void myCarInfo() {
		System.out.println("�� ���� Ÿ�̾�� " + annoTire.getTireName() + " �Դϴ�");
	}
}
