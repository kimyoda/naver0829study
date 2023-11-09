package day1109.test.anno;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component("mycar2")
@AllArgsConstructor // ������ ���Թ������ �ڵ������Ѵ�

public class AnnoCar2 {

	AnnoKoreaTire koreaTire;
	AnnoCandaTire candaTire;
	
	public void myCarInfo() {
		System.out.println("�� ���� Ÿ�̾�� " + koreaTire.getTireName() + " �Դϴ�");
		System.out.println("�ܿ�� Ÿ�̾�� " + candaTire.getTireName() + " �Դϴ�");
	}
}
