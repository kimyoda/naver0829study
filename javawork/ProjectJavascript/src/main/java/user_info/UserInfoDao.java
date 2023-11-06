package user_info;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;


import mysql.db.DbConnect;

public class UserInfoDao {
	DbConnect db = new DbConnect();
	
	// insert
	public void insertUserInfo(UserInfoDto dto) {
		String sql = "insert into USER_INFO "
				+ "(id, password, name,gender, nickname, address, "
				+ "email, phone, jumin, sign_dt) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, now())";
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			// 바인딩
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getGender());
			pstmt.setString(5, dto.getNickname());
			pstmt.setString(6, dto.getAddress());
			pstmt.setString(7, dto.getEmail());
			pstmt.setString(8, dto.getPhone());
			pstmt.setString(9, dto.getJumin());
			// 실행 
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
		
	}

	public UserInfoDto getUserById(String id) {
	    Connection conn = db.getConnection();
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    UserInfoDto user = null;

	    String sql = "SELECT * FROM USER_INFO WHERE id = ?";

	    try {
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, id);
	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	            user = new UserInfoDto();
	            user.setId(rs.getString("id"));
	            user.setPassword(rs.getString("password"));
	            user.setName(rs.getString("name"));
	            user.setGender(rs.getString("gender"));
	            user.setNickname(rs.getString("nickname"));
	            user.setAddress(rs.getString("address"));
	            user.setEmail(rs.getString("email"));
	            user.setPhone(rs.getString("phone"));
	            user.setJumin(rs.getString("jumin"));
	            user.setSign_DT(rs.getTimestamp("sign_dt"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        db.dbClose(rs, pstmt, conn);
	    }

	    return user;
	}
	
    // 회원 가입 로직
    public int UserInfoDto(String id, String password) {
        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT user_id FROM USER_INFO WHERE id = ?";
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                return 0; // 이미 존재하는 아이디
            } else {
                // 존재하지 않는 아이디인 경우, 회원 가입 진행
                sql = "INSERT INTO USER_INFO (id, password) VALUES (?, ?)";
                pstmt = conn.prepareStatement(sql);
                
                pstmt.setString(1, id);
                pstmt.setString(2, password);
                int result = pstmt.executeUpdate();

                if (result > 0) {
                    return 1; // 회원 가입 성공
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.dbClose(rs, pstmt, conn);
        }

        return -1; // DB 오류
    }

    // 로그인 로직
    public int loginUser(String id, String password) {
        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT password FROM USER_INFO WHERE id = ?";
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                if (rs.getString("password").equals(password)) {
                    return 1; // 로그인 성공
                } else {
                    return 0; // 비밀번호 불일치
                }
            }
            return -1; // 아이디 불일치
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.dbClose(rs, pstmt, conn);
        }

        return -2; // DB 오류
    }
    
    private boolean isValidJumin(String jumin) {
        // 주민등록번호는 13자리여야 합니다.
    	if (jumin.length() != 13) {
            return false;
        }

        // 숫자로만 구성되어야 합니다.
        if (!jumin.matches("^[0-9]*$")) {
            return false;
        }

        // 생년월일 부분의 유효성을 확인합니다.
        int year = Integer.parseInt(jumin.substring(0, 2));
        int month = Integer.parseInt(jumin.substring(2, 4));
        int day = Integer.parseInt(jumin.substring(4, 6));

        if (year < 0 || year > 99 || month < 1 || month > 12 || day < 1 || day > 31) {
            return false;
        }

        // 유효한 주민등록번호인 경우 true 반환
        return true;
    }
    
    private String getGenderFromJumin(String jumin) {
        // 주민등록번호가 유효한지 먼저 확인
        if (!isValidJumin(jumin)) {
            return "유효하지 않은 주민등록번호";
        }

        // 7번째 숫자를 추출
        int seventhDigit = Integer.parseInt(jumin.substring(6, 7));

        // 성별 판별
        if (seventhDigit % 2 == 0) {
            return "여자";
        } else {
            return "남자";
        }
    }
}


	
