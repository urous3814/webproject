package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DatabaseUtil;
public class UserDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public UserDAO() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/BBS?serverTimezone=UTC";
			String dbID = "root";
			String dbPassword = "admin";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int login(String userID, String userPassword) {
		String SQL = "SELECT userPassword FROM USER WHERE userID = ?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1,  userID);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				if (rs.getString(1).equals(userPassword)) {
					return 1; // 로그인 성공
				} else {
					return 0; // 비밀번호 불일치
				}
			} 
			return -1; // 아이디가 없음
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return -2; // 데이터베이스 오류
	}
	
	public int join(User user) {
		String SQL = "INSERT INTO USER VALUES (?, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, user.getUserID());
			pstmt.setString(2, user.getUserPassword());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getUserGender());
			pstmt.setString(5, user.getUserEmail());
			
			return pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

//	public String getUserEmail (String userID) {
//		String sql = "SELECT userEmail FROM user WHERE userID = ?";
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			conn = DatabaseUtil.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, userID);
//			rs = pstmt.executeQuery();
//			if(rs.next())
//				return rs.getString(1);
//		} catch(Exception e) {
//			e.printStackTrace();
//		} finally {
//			try { if(conn != null) conn.close(); }
//			catch (Exception e) { e.printStackTrace(); }
//			try { if(pstmt != null) pstmt.close(); }
//			catch (Exception e) { e.printStackTrace(); }
//			try { if(rs != null) rs.close(); }
//			catch (Exception e) { e.printStackTrace(); }
//		}
//		return null;
//	}

//	public boolean getUserEmailChecked (String userID) {
//		String sql = "SELECT userEmailChecked FROM user WHERE userID = ?";
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			conn = DatabaseUtil.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, userID);
//			rs = pstmt.executeQuery();
//			if(rs.next())
//				return rs.getBoolean(1);
//		} catch(Exception e) {
//			e.printStackTrace();
//		} finally {
//			try { if(conn != null) conn.close(); }
//			catch (Exception e) { e.printStackTrace(); }
//			try { if(pstmt != null) pstmt.close(); }
//			catch (Exception e) { e.printStackTrace(); }
//			try { if(rs != null) rs.close(); }
//			catch (Exception e) { e.printStackTrace(); }
//		}
//		return false;
//	}
//	public boolean setUserEmailChecked (String userID) {
//		String sql = "UPDATE user SET userEmailChecked = true WHERE userID = ?";
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			conn = DatabaseUtil.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, userID);
//			pstmt.executeUpdate();
//			return true;
//		} catch(Exception e) {
//			e.printStackTrace();
//		} finally {
//			try { if(conn != null) conn.close(); }
//			catch (Exception e) { e.printStackTrace(); }
//			try { if(pstmt != null) pstmt.close(); }
//			catch (Exception e) { e.printStackTrace(); }
//			try { if(rs != null) rs.close(); }
//			catch (Exception e) { e.printStackTrace(); }
//		}
//		return false;
//	}

}
