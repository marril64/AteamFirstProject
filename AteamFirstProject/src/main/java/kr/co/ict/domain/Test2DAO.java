package kr.co.ict.domain;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.catalina.connector.Response;

public class Test2DAO {

	private DataSource ds = null;
	
	private static Test2DAO dao = new Test2DAO();
	
	private Test2DAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Test2DAO getInstance() {
		if (dao == null) {
			dao = new Test2DAO();
		}
		return dao;
	}
	
	public List<Test2VO> test1List() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Test2VO> userList = new ArrayList<>();
		
		try {
			con = ds.getConnection();
			String sql = "SELECT * FROM test1 ORDER BY tNum DESC";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Test1VO user = new Test1VO();
				
				user.settNum(rs.getInt(1));
				user.settId(rs.getString(2));
				user.settName(rs.getString(3));
				user.settGender(rs.getString(4));
				user.settCountry(rs.getString(5));
				user.settCity(rs.getString(6));
				
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
	} // 모든 정보 조회
	
	
	
	public Boolean test1Update(int tNum, String tId, String tName, String tGender, String tCountry, String tCity) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Boolean check = null;
		
		try {
			con = ds.getConnection();
			String idCheck = "SELECT * FROM test1 WHERE tId = ?";
			pstmt = con.prepareStatement(idCheck);
			pstmt.setString(1, tId);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				check = false;
			} else {
				String sql = "UPDATE test1 SET tId = ?, tName = ?, tGender = ?, tCountry = ?, tCity = ? WHERE tNum in (?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, tId);
				pstmt.setString(2, tName);
				pstmt.setString(3, tGender);
				pstmt.setString(4, tCountry);
				pstmt.setString(5, tCity);
				pstmt.setInt(6, tNum);
				
				pstmt.executeUpdate();
				check = true;
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
	} // 업데이트
	
	public Boolean test1Join(String tId, String tName, String tGender, String tCountry, String tCity) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Boolean check = null;
		
		try {
			con = ds.getConnection();
			String idCheck = "SELECT * FROM test1 WHERE tId = ?";
			pstmt = con.prepareStatement(idCheck);
			pstmt.setString(1, tId);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				check = false;
			} else {
				String insert = "INSERT INTO test1 (tId, tName, tGender, tCountry, tCity) VALUES (?, ?, ?, ?, ?)";
				pstmt = con.prepareStatement(insert);
				
				pstmt.setString(1, tId);
				pstmt.setString(2, tName);
				pstmt.setString(3, tGender);
				pstmt.setString(4, tCountry);
				pstmt.setString(5, tCity);
				
				pstmt.executeUpdate();
				check = true;
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
	} // 추가
	
	public void test1Delete(ArrayList<Integer> tNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			
			for (int num : tNum) {
				String sql = "DELETE FROM test1 WHERE tNum in (?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, num);
				pstmt.executeUpdate();
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
	} // 삭제
	
	public List<Test1VO> test1SearchAll(String tId, String tName, String tGender, String tCity, String date1, String date2) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Test1VO> userList = new ArrayList<>();
		
		try {
			con = ds.getConnection();
			String check;
			
			if (tId != "" && tName != "" && tGender != null && !tCity.equals("국가를 선택해주십시오.") && (date1 != "" || date2 != "")) {
				check = "SELECT * FROM test1 WHERE tId = ? AND tName = ? AND tGender = ? AND tCity = ? AND (tJoin BETWEEN ? AND ?) ORDER BY tNum DESC;";
				pstmt = con.prepareStatement(check);
				pstmt.setString(1, tId);
				pstmt.setString(2, tName);
				pstmt.setString(3, tGender);
				pstmt.setString(4, tCity);
				pstmt.setString(5, date1);
				pstmt.setString(6, date2);
				rs = pstmt.executeQuery();
			}
			
			if (tGender == null || tGender.equals("회원 전체보기")) {
				if (tId == "") {
					check = "SELECT * FROM test1 WHERE tName = ? AND tCity = ? AND (tJoin BETWEEN ? AND ?) ORDER BY tNum DESC;";
					pstmt = con.prepareStatement(check);
					pstmt.setString(1, tName);
					pstmt.setString(2, tCity);
					pstmt.setString(3, date1);
					pstmt.setString(4, date2);
					rs = pstmt.executeQuery();
					if (tName == "") {
						check = "SELECT * FROM test1 WHERE tCity = ? AND (tJoin BETWEEN ? AND ?) ORDER BY tNum DESC;";
						pstmt = con.prepareStatement(check);
						pstmt.setString(1, tCity);
						pstmt.setString(2, date1);
						pstmt.setString(3, date2);
						rs = pstmt.executeQuery();
						if (tCity.equals("국가를 선택해주십시오.")) {
							check = "SELECT * FROM test1 WHERE (tJoin BETWEEN ? AND ?) ORDER BY tNum DESC;"; // 시간
							pstmt = con.prepareStatement(check);
							pstmt.setString(1, date1);
							pstmt.setString(2, date2);
							rs = pstmt.executeQuery();
							if (date1 == "" || date2 == "") {
								check = "SELECT * FROM test1 ORDER BY tNum DESC;"; // 성별 전체
								pstmt = con.prepareStatement(check);
								rs = pstmt.executeQuery();
							}
						} else if (date1 == "" || date2 == "") {
							check = "SELECT * FROM test1 WHERE tCity = ? ORDER BY tNum DESC;"; // 도시
							pstmt = con.prepareStatement(check);
							pstmt.setString(1, tCity);
							rs = pstmt.executeQuery();
						}
					} else if (tCity.equals("국가를 선택해주십시오.")) {
						check = "SELECT * FROM test1 WHERE tName = ? AND (tJoin BETWEEN ? AND ?) ORDER BY tNum DESC;";
						pstmt = con.prepareStatement(check);
						pstmt.setString(1, tName);
						pstmt.setString(2, date1);
						pstmt.setString(3, date2);
						rs = pstmt.executeQuery();
						if (date1 == "" || date2 == "") {
							check = "SELECT * FROM test1 WHERE tName = ? ORDER BY tNum DESC;"; // 이름
							pstmt = con.prepareStatement(check);
							pstmt.setString(1, tName);
							rs = pstmt.executeQuery();
						}
					} else if (date1 == "" || date2 == "") {
						check = "SELECT * FROM test1 WHERE tName = ? AND tCity = ? ORDER BY tNum DESC;";
						pstmt = con.prepareStatement(check);
						pstmt.setString(1, tName);
						pstmt.setString(2, tCity);
						rs = pstmt.executeQuery();
					}
				} else if (tName == "") {
					check = "SELECT * FROM test1 WHERE tId = ? AND tCity = ? AND (tJoin BETWEEN ? AND ?) ORDER BY tNum DESC;";
					pstmt = con.prepareStatement(check);
					pstmt.setString(1, tId);
					pstmt.setString(2, tCity);
					pstmt.setString(3, date1);
					pstmt.setString(4, date2);
					rs = pstmt.executeQuery();
					if (tCity.equals("국가를 선택해주십시오.")) {
						check = "SELECT * FROM test1 WHERE tId = ? AND (tJoin BETWEEN ? AND ?) ORDER BY tNum DESC;";
						pstmt = con.prepareStatement(check);
						pstmt.setString(1, tId);
						pstmt.setString(2, date1);
						pstmt.setString(3, date2);
						rs = pstmt.executeQuery();
						if (date1 == "" || date2 == "") {
							check = "SELECT * FROM test1 WHERE tId = ? ORDER BY tNum DESC;"; // 아이디
							pstmt = con.prepareStatement(check);
							pstmt.setString(1, tId);
							rs = pstmt.executeQuery();
						}
					} else if (date1 == "" || date2 == "") {
						check = "SELECT * FROM test1 WHERE tId = ? AND tCity = ? ORDER BY tNum DESC;";
						pstmt = con.prepareStatement(check);
						pstmt.setString(1, tId);
						pstmt.setString(2, tCity);
						rs = pstmt.executeQuery();
					}
				} else if (tCity.equals("국가를 선택해주십시오.")) {
					check = "SELECT * FROM test1 WHERE tId = ? AND tName = ? AND (tJoin BETWEEN ? AND ?) ORDER BY tNum DESC;";
					pstmt = con.prepareStatement(check);
					pstmt.setString(1, tId);
					pstmt.setString(2, tName);
					pstmt.setString(3, date1);
					pstmt.setString(4, date2);
					rs = pstmt.executeQuery();
					if (date1 == "" || date2 == "") {
						check = "SELECT * FROM test1 WHERE tId = ? AND tName = ? ORDER BY tNum DESC;";
						pstmt = con.prepareStatement(check);
						pstmt.setString(1, tId);
						pstmt.setString(2, tName);
						rs = pstmt.executeQuery();
					}
				} else if (date1 == "" || date2 == "") {
					check = "SELECT * FROM test1 WHERE tId = ? AND tName = ? AND tCity = ? ORDER BY tNum DESC;";
					pstmt = con.prepareStatement(check);
					pstmt.setString(1, tId);
					pstmt.setString(2, tName);
					pstmt.setString(3, tCity);
					rs = pstmt.executeQuery();
				}
			} else if (tGender.equals("남") || tGender.equals("여")) {
				if (tId == "") {
					check = "SELECT * FROM test1 WHERE tName = ? AND tGender = ? AND tCity = ? AND (tJoin BETWEEN ? AND ?) ORDER BY tNum DESC;";
					pstmt = con.prepareStatement(check);
					pstmt.setString(1, tName);
					pstmt.setString(2, tGender);
					pstmt.setString(3, tCity);
					pstmt.setString(4, date1);
					pstmt.setString(5, date2);
					rs = pstmt.executeQuery();
					if (tCity.equals("국가를 선택해주십시오.")) {
						check = "SELECT * FROM test1 WHERE tGender = ? AND (tJoin BETWEEN ? AND ?) ORDER BY tNum DESC;";
						pstmt = con.prepareStatement(check);
						pstmt.setString(1, tGender);
						pstmt.setString(2, date1);
						pstmt.setString(3, date2);
						rs = pstmt.executeQuery();
						if (date1 == "" || date2 == "") {
							check = "SELECT * FROM test1 WHERE tGender = ? ORDER BY tNum DESC;"; // 성별 구분
							pstmt = con.prepareStatement(check);
							pstmt.setString(1, tGender);
							rs = pstmt.executeQuery();
						}
					} else if (date1 == "" || date2 == "") {
						check = "SELECT * FROM test1 WHERE tGender = ? AND tCity = ? ORDER BY tNum DESC;";
						pstmt = con.prepareStatement(check);
						pstmt.setString(1, tGender);
						pstmt.setString(2, tCity);
						rs = pstmt.executeQuery();
					}
				} else if (tCity.equals("국가를 선택해주십시오.")) {
					check = "SELECT * FROM test1 WHERE tId = ? AND tName = ? AND tGender = ? AND (tJoin BETWEEN ? AND ?) ORDER BY tNum DESC;";
					pstmt = con.prepareStatement(check);
					pstmt.setString(1, tId);
					pstmt.setString(2, tName);
					pstmt.setString(3, tGender);
					pstmt.setString(4, date1);
					pstmt.setString(5, date2);
					rs = pstmt.executeQuery();
					if (date1 == "" || date2 == "") {
						check = "SELECT * FROM test1 WHERE tId = ? AND tName = ? AND tGender = ? ORDER BY tNum DESC;";
						pstmt = con.prepareStatement(check);
						pstmt.setString(1, tId);
						pstmt.setString(2, tName);
						pstmt.setString(3, tGender);
						rs = pstmt.executeQuery();
					}
				} else if (date1 == "" || date2 == "") {
					check = "SELECT * FROM test1 WHERE tName = ? AND tGender = ? AND tCity = ? ORDER BY tNum DESC;";
					pstmt = con.prepareStatement(check);
					pstmt.setString(1, tName);
					pstmt.setString(2, tGender);
					pstmt.setString(3, tCity);
					rs = pstmt.executeQuery();
				} else if (tName == "") {
					check = "SELECT * FROM test1 WHERE tId = ? AND tGender = ? AND tCity = ? AND (tJoin BETWEEN ? AND ?) ORDER BY tNum DESC;";
					pstmt = con.prepareStatement(check);
					pstmt.setString(1, tId);
					pstmt.setString(2, tGender);
					pstmt.setString(3, tCity);
					pstmt.setString(4, date1);
					pstmt.setString(5, date2);
					rs = pstmt.executeQuery();
					if (tCity.equals("국가를 선택해주십시오.")) {
						check = "SELECT * FROM test1 WHERE tId = ? AND tGender = ? AND (tJoin BETWEEN ? AND ?) ORDER BY tNum DESC;";
						pstmt = con.prepareStatement(check);
						pstmt.setString(1, tId);
						pstmt.setString(2, tGender);
						pstmt.setString(3, date1);
						pstmt.setString(4, date2);
						rs = pstmt.executeQuery();
						if (date1 == "" || date2 == "") {
							check = "SELECT * FROM test1 WHERE tId = ? AND tGender = ? ORDER BY tNum DESC;";
							pstmt = con.prepareStatement(check);
							pstmt.setString(1, tId);
							pstmt.setString(2, tGender);
							rs = pstmt.executeQuery();
						}
					} else if (date1 == "" || date2 == "") {
						check = "SELECT * FROM test1 WHERE tId = ? AND tGender = ? AND tCity = ? ORDER BY tNum DESC;";
						pstmt = con.prepareStatement(check);
						pstmt.setString(1, tId);
						pstmt.setString(2, tGender);
						pstmt.setString(3, tCity);
						rs = pstmt.executeQuery();
					}
				} else if (tCity.equals("국가를 선택해주십시오.")) {
					check = "SELECT * FROM test1 WHERE tId = ? AND tName = ? AND tGender = ? AND (tJoin BETWEEN ? AND ?) ORDER BY tNum DESC;";
					pstmt = con.prepareStatement(check);
					pstmt.setString(1, tId);
					pstmt.setString(2, tName);
					pstmt.setString(3, tGender);
					pstmt.setString(4, date1);
					pstmt.setString(5, date2);
					rs = pstmt.executeQuery();
					if (date1 == "" || date2 == "") {
						check = "SELECT * FROM test1 WHERE tId = ? AND tName = ? AND tGender = ? ORDER BY tNum DESC;";
						pstmt = con.prepareStatement(check);
						pstmt.setString(1, tId);
						pstmt.setString(2, tName);
						pstmt.setString(3, tGender);
						rs = pstmt.executeQuery();
					}
				} else if (date1 == "" || date2 == "") {
					check = "SELECT * FROM test1 WHERE tId = ? AND tName = ? AND tGender = ? AND tCity = ? ORDER BY tNum DESC;";
					pstmt = con.prepareStatement(check);
					pstmt.setString(1, tId);
					pstmt.setString(2, tName);
					pstmt.setString(3, tGender);
					pstmt.setString(4, tCity);
					rs = pstmt.executeQuery();
				}
			}
			
			while(rs.next()) {
				Test1VO user = new Test1VO();
				
				user.settNum(rs.getInt(1));
				user.settId(rs.getString(2));
				user.settName(rs.getString(3));
				user.settGender(rs.getString(4));
				user.settCountry(rs.getString(5));
				user.settCity(rs.getString(6));
				
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
	} // 모든 조건 조회
	
}