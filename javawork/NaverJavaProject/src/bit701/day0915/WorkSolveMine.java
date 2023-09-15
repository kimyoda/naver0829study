package bit701.day0915;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WorkSolveMine extends JFrame {
	JButton btn1, btn2, btn3, btn4;
	JButton btnImageFile;
	JButton btnImageFile2;
	JButton btnImageFile3;
	JButton btnImageFile4;
	String initImage = "D:\\naver0829\\img\\연예인사진\\shinminah.jpg";
	String initImage2 = "D:\\naver0829\\img\\mycar\\mycar5.png";
	String initImage3 = "D:\\naver0829\\img\\음식사진\\6.jpg";
	String initImage4 = "D:\\naver0829\\img\\이쁜동물이미지\\C1.png";
	Mycanvas myCanvas = new Mycanvas();
	Image image;


	//패널을 사용해서 사진은 동물만 버튼4개쓰고 사진 종류별로 바로바로 출력되게(난수 넣고) 

	public WorkSolveMine(String title) {
		super(title);//JFrame의 문자열을 받는 생성자 호출
		this.setLocation(300, 100);//프레임의 시작위치
		this.setSize(500, 600);// 프레임의 너비, 높이
		this.setVisible(true);//true: 프레임을 보이게하기, false: 프레임 숨기기

		//이미지 초기화
		//image = new ImageIcon(initImage).getImage();

		//디자인이나 이벤트를 구현할 메서드 호출
		this.setDesign();

		this.setVisible(true);


		//윈도우 이벤트 발생-익명내부클래스 형태로 이벤트 구현
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {//x버튼 클릭시 호출되는 메서드
				super.windowActivated(e);	
				//실제종료
				System.exit(0);//정상종료
				super.windowClosing(e);

			}
		});//여기서 클래스를 구현

	}


	//버튼 이벤트를 이번에는 내부클래스로 만들어보자


	class Mycanvas extends Canvas {
		//		Image image;		

		@Override
		public void paint(Graphics g) {
			super.paint(g);

			if (image.getWidth(this) >= 300) {
				g.drawImage(image, 70, 10, 370, 450, this);
			} else {
				g.drawImage(image, 60, 10, this);
			}
		}
	}


	//이미지 오버라이드
	//	@Override
	//	public void paint(Graphics g) {//paint는 처음시작시 자동호출, 그리고 프레임 크기변경 시에도 자동호출이다. 바꿀려면 호출해줘야한다.
	//		// TODO Auto-generated method stub
	//		super.paint(g);
	//
	//		//System.out.println(image.getWidth(this));
	//		if(image.getWidth(this)>=200) {				
	//			g.drawImage(image, 70, 10, 370, 450, this);
	//
	//		} else {//300미만 너비를 가진 이미지는 원래 사이즈대로 출력
	//			g.drawImage(image, 60, 10, this);
	//
	//		}
	//	}


	private void setDesign() {
		// TODO Auto-generated method stub
		//자바에서 제공하는 레이아웃을 안쓰고 직접 위치지정을 할 경우
		//this.setLayout(null);
		JPanel p = new JPanel();
		//버튼 생성
		btnImageFile = new JButton("연예인");
		btnImageFile2 = new JButton("My car");
		btnImageFile3 = new JButton("음식사진");
		btnImageFile4 = new JButton("이쁜동물사진");
		p.add(btnImageFile);
		p.add(btnImageFile2);
		p.add(btnImageFile3);
		p.add(btnImageFile4);
		this.add(p, "North");
		//파일버튼 이벤트
		image = new ImageIcon(initImage).getImage();
		this.add("Center", myCanvas);
		//버튼3은 익명내부클래스 형태로 만들어보자




		btnImageFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				image = new ImageIcon(initImage).getImage();
				myCanvas.repaint();//강제호출


			}
		});

		btnImageFile2.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				image = new ImageIcon(initImage2).getImage();
				myCanvas.repaint();//강제호출


			}
		});

		btnImageFile3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				image = new ImageIcon(initImage3).getImage();

				myCanvas.repaint();//강제호출


			}
		});
	
		
		//
		btnImageFile4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				image = new ImageIcon(initImage4).getImage();
				System.out.println();
				//랜덤난수 1~8까지 난수를 설정
				int []random = new int[8];
				for(int i=0; i<random.length; i++) {
					random[i] = (int)(Math.random() * 8) +1;
					
				}
				int randomx = (int)(Math.random() * random.length);
				int selrandom = random[randomx];
				String randomAnimalImage = "D:\\naver0829\\img\\이쁜동물이미지\\C" + selrandom + ".png";
				//동물이쁜사진을 이 난수에 맞춰서 호출 될 수 있도록 코드를 짜고 출력
				image = new ImageIcon(randomAnimalImage).getImage();
				myCanvas.repaint();//강제호출


			}
		});
	}






	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WorkSolveMine s = new WorkSolveMine("예제연습");

	}

}
