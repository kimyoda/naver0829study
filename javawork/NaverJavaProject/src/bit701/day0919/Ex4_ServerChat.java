package bit701.day0919;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ex4_ServerChat extends JFrame implements Runnable {
	JTextArea area;
	//접속하는 클라이언트들을 저장할 Vector 
	Vector<ClientMember> listMember = new Vector<ClientMember>();

	public Ex4_ServerChat() {
		super("채팅서버");
		this.setBounds(700, 100, 400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDesign();
		this.setVisible(true);
	}

	//1번 쓰레드의 run 메소드
	//Runnable로 인해 run Override가 생긴다
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//서버소캣 생성
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(6000);
			area.append("서버 소켓 생성 성공!!\n");

			//접속하는 클라이언트들 허용
			while(true) {
				//대기중이다가
				//접속요청하는 클라이언트 허용, 허용이 되면 Socket이 만들어진다
				Socket socket = serverSocket.accept();
				//허용된 클라이언트들을 벡터에 추가한다
				ClientMember clientMember = new ClientMember(socket);
				listMember.add(clientMember);
				//각 클라이언트의 run 메소드 호출
				clientMember.start();

				area.append("접속허용 IP : " +socket.getInetAddress().getHostAddress()+"\n");
				this.autoScroll();
			}

		} catch (IOException e) {
			area.append("서버 소켓 생성 실패: " + e.getMessage());
		}
	}


	//접속한 클라이언트와 대화를 주고받을 내부클래스(무조건 Thread로)
	class ClientMember extends Thread {

		Socket mySocket;
		BufferedReader br;
		PrintWriter pw;
		String nickName;

		public ClientMember(Socket socket) {
			// TODO Auto-generated constructor stub
			mySocket = socket;
			//대화를 주고받을 수 있게 io 클래스 얻기
			InputStream is = null;
			try {
				is = mySocket.getInputStream();
				br = new BufferedReader(new InputStreamReader(is));//Stream을 Reader로 바꿔서 InputStreamReader로 바꾸었다
				pw = new PrintWriter(mySocket.getOutputStream());
				//어떤 리더가 들어있느냐에 따라서 파일, 키보드 등 다양하게 변환 가능 다양성
			} catch (IOException e) {
				//e.printStackTrace();
			}

		}

		@Override
		public void run() {
			// TODO Auto-generated method stub

			//언제 클라이언트들이 메세지를 보낼 지 모르므로 while문을 열어놓는다
			while(true) {
				//클라이언트들이 보낸 메세지를 읽는다
				try {
					String message = br.readLine();
					//확인용:클라이언트가 보낸 메세지 출력하기
					area.append(message+"\n");
					Ex4_ServerChat.this.autoScroll();
					//처음 접속 시 : 1|닉네임 메세지: 2|메세지
					String []arr = message.split("\\|");
					//System.out.println(arr[0] + "," + arr[1]);

					switch(arr[0]) {
					case "1" :{
						this.nickName = arr[1];
						//접속한 모든 클라이언트들한테 누가 입장했는지를 알린다
						for(ClientMember mem:listMember) {
							mem.pw.println(this.nickName + " >>님이 입장하였습니다\n");
							mem.pw.flush();//이때 비로소 전송이 된다
						}
						break;
					}
					case "2" : {
						//보낸 메세지가 arr[1]에 들어있다
						//접속한 모든 클라이언트들한테 누가 어떤 메세지를 보냈는지 알린다
						for(ClientMember mem:listMember) {
							mem.pw.println(this.nickName + arr[1] +"\n");
							mem.pw.flush();//이때 비로소 전송이 된다
						}
						break;
					}

					}
				} catch (IOException|ArrayIndexOutOfBoundsException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
			}
		}
	}

	public void autoScroll() {//자동으로 스크롤바가 내려가게 만드는 기능
		int n = area.getDocument().getLength();//총 라인 수
		area.setCaretPosition(n);//마지막줄로 위치변경
	}

	private void setDesign() {
		area = new JTextArea();
		this.add(new JScrollPane(area));//스크롤을 추가하는 것
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex4_ServerChat serverChat = new Ex4_ServerChat();
		Thread th = new Thread(serverChat);
		th.start();//1번 run 메소드 호출

	}


}
