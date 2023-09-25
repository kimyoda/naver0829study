package bit701.day0925;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DbConnect;

public class Ex4_MysqlSawonDelete {
	DbConnect db = new DbConnect();
	
	public void sawonDelete() {
		//사원명 입력 후 해당 사원 삭제

		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 사원명 입력");
		String name = sc.nextLine();
		String sql = "delete from sawon where name = '" + name + "'";
		System.out.println(sql);
		
		//db 연결
		Connection conn = null;
		Statement stmt = null;
		
		conn = db.getMysqlConnection();
		
		try {
			stmt = conn.createStatement();
			//실행적으로 삭제된 사원의 갯수를 알고싶으면 executeUdpate
			int n = stmt.executeUpdate(sql);
			
			if(n==0) {
				System.out.println("sawon에서" + name + "사원은 없습니다");
			} else {
				System.out.println("총" + n + "명의" + name + "의 사원정보를 삭제했습니다");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}
		
		//결과값이 0이면 xxx 사원은 없습니다
		//결과값이 n이면 총 n명의 xxx 사원정보를 삭제헀습니다
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex4_MysqlSawonDelete ex = new Ex4_MysqlSawonDelete();
		ex.sawonDelete();
	}

}
