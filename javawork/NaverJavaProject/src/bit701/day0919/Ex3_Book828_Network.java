package bit701.day0919;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ex3_Book828_Network {

	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
		InetAddress local = InetAddress.getLocalHost();

		//자기 컴의 ip와 컴퓨터 이름을 알고자 할 경우
		System.out.println("내 컴퓨터의 IP 주소 : " + local.getHostAddress());
		System.out.println("내 컴퓨터의 이름 : " + local.getHostName());

		//naver 서버의 ip를 알고자 할 경우
		InetAddress []naverArr = InetAddress.getAllByName("www.naver.com");
		for(InetAddress inet:naverArr) {
			System.out.println("Naver의 서버 IP : " + inet.getHostAddress());
		}

		//google의 서버의 ip를 알고자 할 경우
		InetAddress []googleArr = InetAddress.getAllByName("www.google.com");
		for(InetAddress inet:googleArr) {
			System.out.println("Google의 서버 IP : " + inet.getHostAddress());
		}

		//nate의 서버의 ip를 알고자 할 경우
		InetAddress []nateArr = InetAddress.getAllByName("www.nate.com");
		for(InetAddress inet:nateArr) {
			System.out.println("Nate의 서버 IP : " + inet.getHostAddress());
		}
	}

}
