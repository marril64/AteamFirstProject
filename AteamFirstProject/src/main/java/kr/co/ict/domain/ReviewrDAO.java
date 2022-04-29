package kr.co.ict.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ReviewrDAO {

	private DataSource ds=null;
	private static ReviewrDAO dao = new ReviewrDAO();
	
	private ReviewrDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ReviewrDAO getInstance() {
		if(dao == null) {
			dao = new ReviewrDAO();
		}
		return dao;
	}
	public List<ReviewrVO> getreviewrList(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;//ResultSet은 실행쿼리문이 SELECT 구문인 경우 결과값을 받기 위해 필요합니다.
		// 결과로 DB에서 꺼내올 board들의 목록도 미리 선언해둡니다.
		List<ReviewrVO> reviewrList = new ArrayList<>();
		
		// 필요한 모든 변수가 선언되었다면 try블럭을 선언합니다.
		try {
			con = ds.getConnection();
			// 쿼리문 저장
			String sql = "SELECT * FROM reviewr";
			// PreparedStatement에 쿼리문 입력
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				// 글 하나의 정보를 담을 수 있는 VO 생성
				ReviewrVO reviewr = new ReviewrVO();
				// 디버깅으로 비어있는것 확인
				System.out.println("집어넣기 전 : " + reviewr);
				// setter로 다 집어넣기
				// int를 받아올때는 rs.getInt(), Date를 받아올때는 getDate()를 씁니다.
				reviewr.setReviewNum(rs.getInt(1));
				reviewr.setBoardNum(rs.getInt(2));
				reviewr.setReviewName(rs.getString(3));
				reviewr.setRuser(rs.getString(4));
				reviewr.setHit(rs.getInt(5));
				reviewr.setbDate(rs.getDate(6));
				reviewr.setContent(rs.getString(7));
				reviewr.setScore(rs.getInt(8));
				
				// 다 집어넣은 후 디버깅
				System.out.println("집어넣은 후 : " + reviewr);
				// userList에 쌓기
				reviewrList.add(reviewr);
			}
			System.out.println("리스트에 쌓인 자료 체크 : " + reviewrList);
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
		return reviewrList;
	}// getreviewrList() 끝나는 지점.
	public ReviewrVO getreviewrDetail(int reviewrNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;//ResultSet은 실행쿼리문이 SELECT 구문인 경우 결과값을 받기 위해 필요합니다.
		ReviewrVO reviewr = new ReviewrVO();
		
		try {
			con = ds.getConnection();
			String sql = "SELECT * FROM reviewr WHERE reviewNum=?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, reviewrNum);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				reviewr.setReviewNum(rs.getInt(1));
				reviewr.setBoardNum(rs.getInt(2));
				reviewr.setReviewName(rs.getString(3));
				reviewr.setRuser(rs.getString(4));
				reviewr.setHit(rs.getInt(5));
				reviewr.setbDate(rs.getDate(6));
				reviewr.setContent(rs.getString(7));
				reviewr.setScore(rs.getInt(8));
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
		return reviewr;
	}
	public ReviewrVO reviewDelete(int reviewNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ReviewrVO reviewr = new ReviewrVO();
		try {
			con = ds.getConnection();
			
			String sql = "DELETE FROM reviewr WHERE reviewNum=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, reviewNum);
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
		}return reviewr;
}
	public ReviewrVO reviewupdate(String ruser, String reviewrName ,String content ,int score) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ReviewrVO reviewr = new ReviewrVO();
		try {
			con = ds.getConnection();
			
			String sql = "UPDATE reviewr SET reviewName=?,reviewcontent=? score=? WHERE ruser=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(4, ruser);
			pstmt.setString(1,reviewrName);
			pstmt.setString(2,content);
			pstmt.setInt(3, score);
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
		}return reviewr;
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
