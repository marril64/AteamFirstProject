package kr.co.ict.domain;

public class ProjectUserVO {
	
	private int userNum;
	private String id;
	private String pw;
	private int phone;
	private String rhit;
	private String userbookmark;
	private String ruser;
	
	public int getUserNum() {
		return userNum;
	}
	
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPw() {
		return pw;
	}
	
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public int getPhone() {
		return phone;
	}
	
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	public String getRhit() {
		return rhit;
	}
	
	public void setRhit(String rhit) {
		this.rhit = rhit;
	}
	
	public String getUserbookmark() {
		return userbookmark;
	}
	
	public void setUserbookmark(String userbookmark) {
		this.userbookmark = userbookmark;
	}
	
	public String getRuser() {
		return ruser;
	}
	
	public void setRuser(String ruser) {
		this.ruser = ruser;
	}
	
	@Override
	public String toString() {
		return "ProjectUserVO [userNum=" + userNum + ", id=" + id + ", pw=" + pw + ", phone=" + phone + ", rhit=" + rhit
				+ ", userbookmark=" + userbookmark + ", ruser=" + ruser + "]";
	}
	
}
