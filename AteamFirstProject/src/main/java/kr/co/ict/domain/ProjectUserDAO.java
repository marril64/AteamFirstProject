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
				user.setNick(rs.getString(5));
				user.setUserbookmark(rs.getString(6));
				
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
	
	public void userUpdateCheck(String id, String pw, String nick, int phone) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			String sql = "UPDATE reuser SET pw = ?, nick = ?, phone = ? WHERE id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pw);
			pstmt.setString(2, nick);
			pstmt.setInt(3, phone);
			pstmt.setString(4, id);
			
			pstmt.executeUpdate();
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
	} // id로 조회해서 유저 정보를 업데이트하는 기능
	
	public Boolean passwordCheck(String id, String pw) {
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
	} // id 조회 후 pw 체크하는 기능
	
	public ProjectUserVO getUserInfo(String userId) {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		ProjectUserVO user = new ProjectUserVO();
		try {
			con = ds.getConnection();
			String sql = "SELECT * FROM reuser WHERE id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user.setUserNum(rs.getInt(1));
				user.setId(rs.getString(2));
				user.setPw(rs.getString(3));
				user.setPhone(rs.getInt(4));
				user.setNick(rs.getString(5));
				user.setUserbookmark(rs.getString(6));
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
		return user;
	} // id로 회원정보 조회, 출력
	
	public List<StoreInfoVO> getUserBookmark (int userNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<StoreInfoVO> storeList = new ArrayList<>();
		List<Integer> arr = new ArrayList<>();
		
		try {
			con = ds.getConnection();
			String sql = "SELECT * FROM bookMark WHERE userNum = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userNum);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				arr.add(rs.getInt(2));
			}
			
			for (int i = 0; i < arr.size(); i++) {
				sql = "SELECT * FROM storeinfo WHERE storeNum = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, arr.get(i));
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					StoreInfoVO store = new StoreInfoVO();
				
					store.setStoreNum(rs.getInt(1));
					store.setStoreName(rs.getString(2));
					store.setStoreTime(rs.getString(3));
					store.setStoreAdd(rs.getString(4));
					store.setStorePhone(rs.getString(5));
					store.setMenu(rs.getString(6));
					store.setStoreContent(rs.getString(7));
						
					storeList.add(store);
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
		
		return storeList;
	} // 유저 고유번호로 즐겨찾기 조회하는 기능
	
	public void bookmarkDelete(int userNum, int storeNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			String sql = "DELETE FROM bookMark WHERE userNum = ? AND storeNum = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userNum);
			pstmt.setInt(2, storeNum);
			pstmt.executeUpdate();
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
	} // 유저 고유번호와 가게 고유번호로 즐겨찾기 삭제하는 기능
	
	public Boolean bookmarkUpdate(int userNum, int storeNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			String sql = "SELECT * FROM bookMark WHERE userNum = ? AND storeNum = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userNum);
			pstmt.setInt(2, storeNum);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				return false;
			} else {
				sql = "INSERT INTO bookMark VALUES (null, ?, ?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, storeNum);
				pstmt.setInt(2, userNum);
				pstmt.executeUpdate();
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
		
		return true;
	} // 유저 고유번호와 가게 고유번호로 즐겨찾기 추가하는 기능
	
	public void bookmarkAllDelete(int storeNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			String sql = "DELETE FROM bookMark WHERE storeNum = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, storeNum);
			pstmt.executeUpdate();
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
	} // 해당 번호의 가게를 즐겨찾기에서 완전히 삭제하는 로직.
	
}
