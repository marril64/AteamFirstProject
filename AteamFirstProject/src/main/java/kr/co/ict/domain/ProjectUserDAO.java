package kr.co.ict.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ProjectUserDAO {
	
	private DataSource ds = null;
	
	private static ProjectUserDAO dao = new ProjectUserDAO();
	
	private ProjectUserDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ProjectUserDAO getInstance() {
		if (dao == null) {
			dao = new ProjectUserDAO();
		}
		return dao;
	}
	
	public List<ProjectUserVO> getUserList() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ProjectUserVO> userList = new ArrayList<>();
		
		try {
			con = ds.getConnection();
			String sql = "SELECT * FROM reuser ORDER BY userNum DESC";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProjectUserVO user = new ProjectUserVO();
				
				user.setUserNum(rs.getInt(1));
				user.setId(rs.getString(2));
				user.setPw(rs.getString(3));
				user.setPhone(rs.getInt(4));
				user.setRhit(rs.getString(5));
				user.setUserbookmark(rs.getString(6));
				user.setRuser(rs.getString(7));

				userList.add(user);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return userList;
	} // 모든 유저 정보 출력
	
	public Boolean userJoinCheck(String id, String pw, int phone, String nick) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Boolean check = null;
		
		try {
			con = ds.getConnection();
			String idCheck = "SELECT * FROM reuser WHERE id = ?";
			pstmt = con.prepareStatement(idCheck);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				check = false;
			} else {
				String nickCheck = "SELECT * FROM reuser WHERE nick = ?";
				pstmt = con.prepareStatement(nickCheck);
				pstmt.setString(1, nick);
				rs = pstmt.executeQuery();
				
				if (rs.next()) {
					check = false;
				} else {
					String insert = "INSERT INTO reuser (id, pw, phone, nick) VALUES (?, ?, ?, ?)";
					pstmt = con.prepareStatement(insert);
					
					pstmt.setString(1, id);
					pstmt.setString(2, pw);
					pstmt.setInt(3, phone);
					pstmt.setString(4, nick);
					
					pstmt.executeUpdate();
					check = true;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return check;
	} // id, nick 체크 후 회원가입 기능
	
	public Boolean userDelete(String id, String pw) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Boolean check = null;
		
		try {
			con = ds.getConnection();
			String idCheck = "SELECT * FROM reuser WHERE id = ?";
			pstmt = con.prepareStatement(idCheck);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				if (rs.getString(3).equals(pw)) {
					String sql = "DELETE FROM reuser WHERE id = ?";
					
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, id);
					
					pstmt.executeUpdate();
					check = true;
				} else {
					check = false;
				}
				
			} else {
				check = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return check;
	} // id, pw 체크 후 회원탈퇴 기능
	
}