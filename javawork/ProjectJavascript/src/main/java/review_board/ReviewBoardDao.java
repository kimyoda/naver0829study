package review_board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import mysql.db.DbConnect;

public class ReviewBoardDao {
	DbConnect db = new DbConnect();
	
	// 목록
	public List<ReviewBoardDto> getAlllist() {
		List<ReviewBoardDto> list = new Vector<ReviewBoardDto>();
		
		String sql = "select * from reviewboard order by num desc";
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ReviewBoardDto dto = new ReviewBoardDto();
				dto.setId(rs.getInt("id"));
				dto.setWriter_id(rs.getString("writer_id"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setView_cnt(rs.getInt("view_cnt"));
				dto.setDelete_yn(rs.getString("delete_yn"));
				dto.setCreate_dt(rs.getTimestamp("create_dt"));
				dto.setModify_dt(rs.getTimestamp("modify_dt"));
				dto.setDelete_dt(rs.getTimestamp("delete_dt"));
				
				// list에 추가
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return list;
	}
	
	
	// insert
	public void insertBoard(ReviewBoardDto dto) {
		String sql = """
				insert into reviewboard (writer_id, title, content, view_cnt, delete_yn, 
				create_dt, modify_dt, delete_dt) values 
				(?, ?, ?, ?, ?, ?, ?, ?)
					""";
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			// 바인딩
			pstmt.setString(1, dto.getWriter_id());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getTitle());
			pstmt.setString(4, dto.getContent());
			pstmt.setInt(5, dto.getView_cnt());
			pstmt.setTimestamp(6, dto.getCreate_dt());
			pstmt.setTimestamp(7, dto.getModify_dt());
			pstmt.setTimestamp(8, dto.getDelete_dt());
			// 실행
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	// 내용보기
	public ReviewBoardDto getData(String num) {
		
		ReviewBoardDto dto = new ReviewBoardDto();
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from reviewboard where num=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			// 바인딩
			pstmt.setString(1, num);
			// 실행
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setWriter_id(rs.getString("writer_id"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setView_cnt(rs.getInt("view_cnt"));
				dto.setDelete_yn(rs.getString("delete_yn"));
				dto.setCreate_dt(rs.getTimestamp("create_dt"));
				dto.setModify_dt(rs.getTimestamp("modify_dt"));
				dto.setDelete_dt(rs.getTimestamp("delete_dt"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn); 
		}
		
		return dto;
	}
	
	 // 수정
	public void updateBoard(ReviewBoardDto dto) {
	    String sql = "update reviewboard set writer_id=?, title=?, "
	    		+ "content=?, modify_dt = now() where id=?";

// 사진은 수정하지 않았을 경우 null 값을 가진다

		// null이 아닐경우에만 photo를 수정한다
//		if (dto.get()== null) {
//			// 사진 수정 안함
//			sql = "update simpleboard set writer=?, subject=?, content=? where num=?";
//		} else {
//			// 사진을 수정하는 경우
//			sql = "update simpleboard set writer=?, subject=?, content=?, photo='" + dto.getPhoto() + "' " + " where num=?";
//	
//
//		}
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,dto.getWriter_id());
			pstmt.setString(2,dto.getTitle());
			pstmt.setString(3,dto.getContent());
			pstmt.setInt(4,dto.getId());
			//
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	
	
	// 조회수 증가
	public void updateView_cnt(String num) {
		String sql = "update reviewboard set view_cnt = view_cnt+1 where num=?";
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	// 삭제
	public void deleteBoard(String num) {
		String sql = "delete from reviewboard where num=?";
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
}
