package bit701.day0915;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex9Saturdaypratice extends JFrame{
	/* 문제: 패널을 사용해서 버튼 4개를 만들고 버튼을 누르면 각각 사진이 나오도록 하고
	 * 이쁜동물이미지 사진은 랜덤으로 나올 수 있게 출력하기
	 * 주석넣기(전체)
	 * 1. 부모클래스를 넣고 상속받는 클래스넣기
	 * 2. 패널을 만들어서 버튼을 각각 만들어주기
	 * 3. 버튼에 해당하는 각각의 이미지 주소를 넣은 버튼 이미지를 만들기
	 * 4. Mycanvs에 해당하는 새로운 생성자 만들기
	 * 5. 사진을 이미지로 변환하여 할당
	 * 6. 그리고 모든 하나씩 코드를 짤 때 System.out.println()을 하여 출력해서 확인해보자
	 * 
	 */
	JButton btn1, btn2, btn3, btn4;
	JButton btnImageFile;
	JButton btnImageFile2;
	JButton btnImageFile3;
	JButton btnImageFile4;
	String initImage = "D:\\naver0829\\img\\mycar\\mycar10.png";
	String initImage2 = "D:\\naver0829\\img\\음식사진\\3.jpg";
	String initImage3 = "D:\\naver0829\\img\\연예인사진\\soojee.jpg";
	String initImage4 = "D:\\naver0829\\img\\이쁜동물이미지\\C4.png";
	Mycanvas myCanvas = new Mycanvas();
	Image image;



	public Ex9Saturdaypratice(String title) {
		/* 1. JFrame의 문자열을 받는 생성자 호출
		 * 2. 프레임의 시작위치
		 * 3. 너비, 높이
		 * 4. 디자인이나 이벤트를 구현할 메서드 호출
		 * 5. 윈도우 이벤트를 발생, 익명내부클래스 형태로 이벤트 구현한다
		 * 6. 오버라이딩하여 닫아준다.
		 */
		super(title);
		this.setLocation(300, 100);
		this.setSize(600, 600);
		this.setDesign();
		this.setVisible(true);


		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				//실제종료
				System.exit(0);
				super.windowClosing(e);
			}
		});


	}

	class Mycanvas extends Canvas {
		/* 1. 사진이미지를 할당하는 클래스를 설정한다
		 * 2. paint메서드를 활용하여  사진 크기를 조정한다
		 * 3. if문을 활용하여 변수를 설정하고 image에 값을 할당한다
		 * 4. 변수명을 다시한번 확인하기
		 */
			@Override
			public void paint(Graphics g) {
				super.paint(g);
				if(image.getWidth(this) >= 300) {
					g.drawImage(image, 70, 10, 370, 450, this);
				} else {
					g.drawImage(image, 60, 10, this);
				}
			}
	}

	private void setDesign() {
		/* 1. 위의 J패널을 생성한다
		 * 2. 각 맞는 버튼 4개를 생성한다
		 * 3. 그리고 버튼을 추가해준다
		 * 4. 그 버튼의 위치를 조정해준다
		 * 5. 이미지를 다시 정의하여 변환하여 사용한다
		 * 6. myCanvas에 해당하는 클래스를 설정한다
		 * 7. 밑의 각 버튼에 맞는 오버라이드를 해준다.
		 */
		JPanel j = new JPanel();
		btnImageFile = new JButton("연예인사진");
		btnImageFile2 = new JButton("차사진");
		btnImageFile3 = new JButton("음식사진1");
		btnImageFile4 = new JButton("이쁜동물 사진랜덤");
		j.add(btnImageFile);
		j.add(btnImageFile2);
		j.add(btnImageFile3);
		j.add(btnImageFile4);
		this.add(j, "North");
		image = new ImageIcon(initImage).getImage();
		this.add("Center", myCanvas);
		
		btnImageFile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				image = new ImageIcon(initImage).getImage();
				myCanvas.repaint();
			}
		});
		
		btnImageFile2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				image = new ImageIcon(initImage2).getImage();
				myCanvas.repaint();
			}
		});
		
		btnImageFile3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				image = new ImageIcon(initImage3).getImage();
				myCanvas.repaint();
			}
		}); 
			
		
		btnImageFile4.addActionListener(new ActionListener() {
			/* 1. 4번은 난수를 설정해야한다.
			 * 2. 이쁜동물이미지에는 총 1~8까지의 숫자가 있어 그에 해당하는 난수를 구해야한다.
			 * 3. 난수를 구하기 위해선 예전에 했던 Lotto의 로직을 떠올려보자
			 * 4. 배열값을 할당하고 for문을 만들고 난수를 구한다.
			 * 5. 그 난수에 값을 할당하고 랜덤이미지에 값을 할당한다
			 * 6. 그외에 출력은 위의 방식과 같다
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				image = new ImageIcon(initImage4).getImage();
				//랜덤난수 설정하기
				int []random = new int[8];
				for(int i = 0; i<random.length; i++) {
					random[i] = (int)(Math.random() *8) + 1;
				}
				int ran = (int)(Math.random() * random.length);
				int selectrandom = random[ran];
				String randomAnimalImages = "D:\\naver0829\\img\\이쁜동물이미지\\C" + selectrandom + ".png";
				image = new ImageIcon(randomAnimalImages).getImage();
				myCanvas.repaint();
			}
		});

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex9Saturdaypratice p = new Ex9Saturdaypratice("로직연습");
	}

}
