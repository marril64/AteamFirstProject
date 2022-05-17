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
	public List<StoreInfoVO> getstoreinfoList(int pageNum){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;//ResultSet은 실행쿼리문이 SELECT 구문인 경우 결과값을 받기 위해 필요합니다.
		// 결과로 DB에서 꺼내올 board들의 목록도 미리 선언해둡니다.
		List<StoreInfoVO> storeinfoList = new ArrayList<>();
		
		// 필요한 모든 변수가 선언되었다면 try블럭을 선언합니다.
		try {
			con = ds.getConnection();
			int num = (pageNum - 1) *10;
			// 쿼리문 저장
			// PreparedStatement에 쿼리문 입력
			String sql = "SELECT * FROM storeinfo ORDER BY storeNum DESC limit ?, 10;";
			// PreparedStatement에 쿼리문 입력
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				// 글 하나의 정보를 담을 수 있는 VO 생성
				StoreInfoVO storeinfo = new StoreInfoVO();
				System.out.println("여기까지는 정상");
				// 디버깅으로 비어있는것 확인
				System.out.println("집어넣기 전 : " + storeinfoList);
				// setter로 다 집어넣기
				// int를 받아올때는 rs.getInt(), Date를 받아올때는 getDate()를 씁니다.
				storeinfo.setStoreNum(rs.getInt(1));
				storeinfo.setStoreName(rs.getString(2));
				storeinfo.setMenu(rs.getString(6));
				storeinfo.setStoreContent(rs.getString(7));
				storeinfo.setStoreAdd(rs.getString(4));
				storeinfo.setStorePhone(rs.getInt(5));
				storeinfo.setStoreTime(rs.getString(3));
				storeinfo.setStoreHit(rs.getInt(8));
				//다시 한번 해보시겠어요? 축하드립니다!
				
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

public void storeinfoInsert(String storeName,String storeContent, String storeAdd, String storeTime, String storePhone, String menu) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			
			String sql = "INSERT INTO storeinfo (storeName,storeContent,storeAdd, storeTime, storePhone,storeNum, menu, storeHit ) VALUES (?, ?, ?, ?, ?, null, ?, null)";
			pstmt = con.prepareStatement(sql);
			// ? 채우기
			pstmt.setString(1, storeName);
			pstmt.setString(2, storeContent);
			pstmt.setString(3, storeAdd);
			pstmt.setString(4, storeTime);
			pstmt.setString(5, storePhone);	
			pstmt.setString(6, menu);		
			
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				//.close()		
				con.close();
				pstmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}	
	}// 글쓰기로직 마무리
	
	
	
	public StoreInfoVO getstoreinfoDetail(int storeNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;//ResultSet은 실행쿼리문이 SELECT 구문인 경우 결과값을 받기 위해 필요합니다.
		StoreInfoVO storeinfo = new StoreInfoVO();
		
		try {
			con = ds.getConnection();
			String sql = "SELECT * FROM storeinfo WHERE storeNum=?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, storeNum);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				storeinfo.setStoreNum(rs.getInt(1));
				storeinfo.setStoreName(rs.getString(2));
				storeinfo.setStoreTime(rs.getString(3));
				storeinfo.setStoreAdd(rs.getString(4));
				storeinfo.setStorePhone(rs.getInt(5));
				storeinfo.setMenu(rs.getString(6));
				storeinfo.setStoreContent(rs.getString(7));
				storeinfo.setStoreHit(rs.getInt(8));
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
	public StoreInfoVO storeinfoDelete(int storeNum) {
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
	public StoreInfoVO storeinfoupdate(String storeName, String storeContent, String storeAdd, String storeTime, int storePhone, String menu, int storeNum, int storeHit ) {
		Connection con = null;
		PreparedStatement pstmt = null;
		StoreInfoVO storeinfo = new StoreInfoVO();
		try {
			con = ds.getConnection();
			
			String sql = "UPDATE storeinfo SET storeName=?,storeContent=?,storeAdd=?, storeTime=?, storePhone = ?, storeNum =?, storeHit = ? WHERE storeNum =?";
			pstmt = con.prepareStatement(sql);	
			
			pstmt.setString(1, storeName);
			pstmt.setString(2, storeContent);
			pstmt.setString(3, storeAdd);
			pstmt.setString(4, storeTime);
			pstmt.setInt(5, storePhone);
			pstmt.setInt(6, storeNum);			
			pstmt.setInt(7, storeHit);			
						
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
	
	public void storeinfoInsert(String storeName, String storeContent, String storeAdd, String storeTime, int storePhone, String menu, int storeHit) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		
		try {
			con = ds.getConnection();
			
			String sql = "INSERT INTO storeinfo(storeName, StoreContent, storeAdd, storeTime, storePhone, menu, storeHit) VALUES(?,?,?,?,?,?,?);";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, storeName);
			pstmt.setString(2, storeContent);
			pstmt.setString(3, storeAdd);
			pstmt.setString(4, storeTime);
			pstmt.setInt(5, storePhone);
			pstmt.setString(6, menu);
			pstmt.setInt(7, storeHit);
			
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
	}// 글쓰기 로직 마무리
	
	// 삭제로직
		public void boardDelete(int storeNum) {
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = ds.getConnection();
				String sql = "DELETE FROM storeinfo WHERE storeNum=?";
				pstmt = con.prepareStatement(sql);
				// ? 채우기
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
				}
			}
		}
		
		// update로직을 한 번 작성해보겠습니다.
		public void StroreInfoUpdate(int storedNum, String storeName, String StoreContent, String storeAdd, String storeTime, int storePhone, String menu, int storeHit ) {
			Connection con = null;  
			PreparedStatement pstmt = null;
			
			try {
				con = ds.getConnection();
				String sql = "UPDATE storeinfo SET storeName=?, StoreContent=?, storeAdd=?, storeTime=?, storePhone=?, menu=?,storeHit=?  WHERE sotrenum=?";
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, storedNum);
				pstmt.setString(2, storeName);
				pstmt.setString(3, StoreContent);
				pstmt.setString(4, storeAdd);
				pstmt.setString(5, storeTime);
				pstmt.setInt(6, storePhone);
				pstmt.setString(7, menu);
				pstmt.setInt(8, storeHit);
				
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
		}// 게시판 수정기능 끝
		
		
		public void upHit(int bno) {
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = ds.getConnection();
				String sql = "UPDATE storeinfo SET hit = hit + 1 WHERE storenum=?";
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, bno);
				
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
		}// 조회수 증가 로직 끝
		
		//전체 글 개수를 구해오는 메서드를 생성해주세요.
		// 쿼리문 : SELECT COUNT(*) FROM boardTbl;
		// 리턴자료형  : 정수
		public int getStoreCount() {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;//ResultSet은 실행쿼리문이 SELECT 구문인 경우 결과값을 받기 위해 필요합니다.
			int storeCount = 0;
			try {
				con = ds.getConnection();
				String sql = "SELECT COUNT(*) FROM storeinfo";
				
				pstmt = con.prepareStatement(sql);
	
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					storeCount = rs.getInt(1);
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
			return storeCount;
		}
		
	}
