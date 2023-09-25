package bit701.day0925;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import db.DbConnect;

public class Ex9_StudentCrud {

	DbConnect db = new DbConnect();
	Scanner sc = new Scanner(System.in);

	public int getMenu() {
		System.out.println("1.추가  2.삭제  3. 수정  4. 전체출력  5. 검색  6.종료");
		int menu = Integer.parseInt(sc.nextLine());
		return menu;
	}

	//insert
	public void insertStudent() {
		//이름
		System.out.println("이름");
		String name = sc.nextLine();

		//혈액형
		System.out.println("혈액형");
		String blood = sc.nextLine();

		//폰번호
		System.out.println("핸드폰번호");
		String phone = sc.nextLine();


		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;

		String sql = "insert into student values (null, ?, ?, ?,now())";



		try {
			pstmt = conn.prepareStatement(sql);
			//? 갯수만큼 값을 넣어줘야한다.
			pstmt.setString(1, name);
			pstmt.setString(2, blood.toUpperCase());//대문자로 변환해서넣기
			pstmt.setString(3, phone);

			//실행
			pstmt.execute();
			System.out.println("추가되었습니다");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}


	}

	//delete
	public void deleteStudent() {
		System.out.println("삭제할 학생의 이름은");
		String name = sc.nextLine();

		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;

		String sql = "delete from student where name = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			//?가 갯수만큼 바인딩
			pstmt.setNString(1, name);
			//삭제된 인원을 알고싶을 경우 executeUpdate
			int n = pstmt.executeUpdate();
			if(n==0) {
				System.out.println("삭제할 학생이 존재하지 않습니다");
			} else {
				System.out.println("삭제했습니다!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}

	//update
	public void updateStudent() {
		//번호
		System.out.println("수정할 num 값?");
		String num = sc.nextLine();
		//이름
		System.out.println("수정할 학생 이름?");
		String name = sc.nextLine();
		//혈액형
		System.out.println("수정할 학생 혈액형은?");
		String blood = sc.nextLine();
		//폰?
		System.out.println("수정할 학생 번호는");
		int phone = Integer.parseInt(sc.nextLine());

		
		String sql = "update Student set name = ?, blood = ?, phone = ? where num = ?";

		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			//총5개
			pstmt.setString(1, name);
			pstmt.setString(2, blood.toUpperCase());
			pstmt.setInt(3, phone);
			pstmt.setString(4, num);

			//실행
			int n = pstmt.executeUpdate();
			if(n==0) {
				System.out.println("해당 데이타가 없습니다");
			} else {
				System.out.println("수정했습니다");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}

	}

	//전체출력
	public void selectAllStudent() {
		
		String sql = "select * from student order by num";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		conn = db.getMysqlConnection();
		
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			System.out.println("번호\t학생명\t혈액형\t핸드폰번호\t날짜");
			System.out.println("=".repeat(50));
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			while(rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String blood = rs.getString("blood");
				String phone = rs.getString("phone");
				//String writeday = rs.getString("writeday");//날짜타입도 String
				Timestamp ts = rs.getTimestamp("writeday");
				System.out.println(num + "\t" + name + "\t" + blood + "\t" + phone + "\t" + sdf.format(ts));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}


	}
	

	//검색-번호 끝 4자리로 검색
	public void searchPhone() {
		
		System.out.println("전화번호끝 4자리를 입력하세요");
		String searchPhone=sc.nextLine();
		

		String sql = "select * from student where phone like ?";

		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, "%" + searchPhone);
			

			//실행
			rs = pstmt.executeQuery();
			
			System.out.println("전화번호 " + searchPhone + "검색결과");
			System.out.println("번호\t학생명\t혈액형\t핸드폰번호\t날짜");
			System.out.println("=".repeat(50));

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			while(rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String blood = rs.getString("blood");
				String phone = rs.getString("phone");
				//String writeday = rs.getString("writeday");//날짜타입도 String
				Timestamp ts = rs.getTimestamp("writeday");
				System.out.println(num + "\t" + name + "\t" + blood + "\t" + phone + "\t" + sdf.format(ts));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}

		} 



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex9_StudentCrud ex = new Ex9_StudentCrud();

		while(true) {
			System.out.println("-".repeat(40));
			int menu =ex.getMenu();
			System.out.println("-".repeat(40));
			switch(menu) {
			case 1: {
				ex.insertStudent();
				break;
			}
			case 2: {
				ex.deleteStudent();
				break;
			}
			case 3: {
				ex.updateStudent();
				break;
			}
			case 4: {
				ex.selectAllStudent();
				break;
			}
			case 5: {
				ex.searchPhone();
				break;
			}
			default:
				System.out.println("** 프로그램을 종료합니다 **");
				System.exit(0);
			}
		}
	}

}
