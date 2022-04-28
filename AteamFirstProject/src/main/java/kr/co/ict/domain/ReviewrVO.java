package kr.co.ict.domain;

import java.sql.Date;

public class ReviewrVO {
	
	private int ReviewNum;
	private int boardNum;	
	private String reviewName;
	private String ruser;
	private String content;
	private Date bDate;
	private int hit;
	private int score;
	public int getReviewNum() {
		return ReviewNum;
	}
	public void setReviewNum(int reviewNum) {
		ReviewNum = reviewNum;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getReviewName() {
		return reviewName;
	}
	public void setReviewName(String reviewName) {
		this.reviewName = reviewName;
	}
	public String getRuser() {
		return ruser;
	}
	public void setRuser(String ruser) {
		this.ruser = ruser;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getbDate() {
		return bDate;
	}
	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "ReviewVO [ReviewNum=" + ReviewNum + ", boardNum=" + boardNum + ", reviewName=" + reviewName + ", ruser="
				+ ruser + ", content=" + content + ", bDate=" + bDate + ", hit=" + hit + ", score=" + score + "]";
	}
	
	
}
