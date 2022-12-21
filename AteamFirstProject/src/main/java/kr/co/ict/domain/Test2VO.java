package kr.co.ict.domain;

public class Test2VO {

	private int tNum;
	private String tId;
	private String tName;
	private String tGender;
	private String tCountry;
	private String tCity;
	
	public int gettNum() {
		return tNum;
	}

	public void settNum(int tNum) {
		this.tNum = tNum;
	}

	public String gettId() {
		return tId;
	}

	public void settId(String tId) {
		this.tId = tId;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public String gettGender() {
		return tGender;
	}

	public void settGender(String tGender) {
		this.tGender = tGender;
	}

	public String gettCountry() {
		return tCountry;
	}

	public void settCountry(String tCountry) {
		this.tCountry = tCountry;
	}

	public String gettCity() {
		return tCity;
	}

	public void settCity(String tCity) {
		this.tCity = tCity;
	}

	@Override
	public String toString() {
		return "Test2VO [tNum=" + tNum + ", tId=" + tId + ", tName=" + tName + ", tGender=" + tGender + ", tCountry="
				+ tCountry + ", tCity=" + tCity + "]";
	}
	
}
