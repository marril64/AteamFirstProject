package kr.co.ict.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class StoreInfoDAO {
private DataSource ds = null;
	
	private static StoreInfoDAO dao = new StoreInfoDAO();
	
	private StoreInfoDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static StoreInfoDAO getInstance() {
		if (dao == null) {
			dao = new StoreInfoDAO();
		}
		return dao;
	}
	public List<StoreInfoVO> getstoreinfoList(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;//ResultSet은 실행쿼리문이 SELECT 구문인 경우 결과값을 받기 위해 필요합니다.
		// 결과로 DB에서 꺼내올 board들의 목록도 미리 선언해둡니다.
		List<StoreInfoVO> storeinfoList = new ArrayList<>();
		
		// 필요한 모든 변수가 선언되었다면 try블럭을 선언합니다.
		try {
			con = ds.getConnection();
			// 쿼리문 저장
			String sql = "SELECT * FROM storeinfo";
			// PreparedStatement에 쿼리문 입력
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				// 글 하나의 정보를 담을 수 있는 VO 생성
				StoreInfoVO storeinfo = new StoreInfoVO();
				// 디버깅으로 비어있는것 확인
				System.out.println("집어넣기 전 : " + storeinfoList);
				// setter로 다 집어넣기
				// int를 받아올때는 rs.getInt(), Date를 받아올때는 getDate()를 씁니다.
				storeinfo.setStroeNum(rs.getInt(1));
				storeinfo.setStoreName(rs.getString(2));
				storeinfo.setMenu(rs.getString(3));
				storeinfo.setStoreContent(rs.getString(4));
				storeinfo.setStoreAdd(rs.getString(5));
				storeinfo.setStorePhone(rs.getInt(6));
				storeinfo.setStoreTime(rs.getString(7));
	
				
				// 다 집어넣은 후 디버깅
				System.out.println("집어넣은 후 : " + storeinfo);
				// userList에 쌓기
				storeinfoList.add(storeinfo);
			}
			System.out.println("리스트에 쌓인 자료 체크 : " + storeinfoList);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
				rs.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return storeinfoList;
	}// getreviewrList() 끝나는 지점.
	public StoreInfoVO getstroeinfoDetail(int storeNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;//ResultSet은 실행쿼리문이 SELECT 구문인 경우 결과값을 받기 위해 필요합니다.
		StoreInfoVO storeinfo = new StoreInfoVO();
		
		try {
			con = ds.getConnection();
			String sql = "SELECT * FROM reviewr WHERE reviewNum=?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, storeNum);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				storeinfo.setStroeNum(rs.getInt(1));
				storeinfo.setStoreName(rs.getString(2));
				storeinfo.setMenu(rs.getString(3));
				storeinfo.setStoreContent(rs.getString(4));
				storeinfo.setStoreAdd(rs.getString(5));
				storeinfo.setStorePhone(rs.getInt(6));
				storeinfo.setStoreTime(rs.getString(7));
	
			}else {
				System.out.println("계정이 없습니다.");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
				rs.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return storeinfo;
	}
	public ReviewrVO storeinfoDelete(int storeNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		StoreInfoVO storeinfo = new StoreInfoVO();
		try {
			con = ds.getConnection();
			
			String sql = "DELETE FROM storeinfo WHERE storeNum=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, storeNum);
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}return storeinfo;
		}
	}
	public ReviewrVO reviewupdate(String ruser, String reviewrName ,String content ,int score) {
		Connection con = null;
		PreparedStatement pstmt = null;
		StoreInfoVO reviewr = new StoreInfoVO();
		try {
			con = ds.getConnection();
			
			String sql = "UPDATE storeinfo SET storeName=?,storecontent=? storeadd=? WHERE ruser=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(2, storeName);
			pstmt.setString(4, storeContent);
			pstmt.setInt(3, score);
			pstmt.setString(4, ruser);
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}return storeinfo;
	}
	public void reviewrInsert(String reviewName,String content,String ruser,int score,int boardNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		
		try {
			con = ds.getConnection();
			
			String sql = "INSERT INTO reviewr(boardNum,reviewName,reviewcontent,ruser,score) VALUES(?,?,?,?,?);";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			pstmt.setString(2, reviewName);
			pstmt.setString(3, content);
			pstmt.setString(4, ruser);
			pstmt.setInt(5, score);
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
