package kr.co.ict.domain;

public class StoreinfoButtonDTO {
	private int storeinfoCount; //전체 글 개수
	private int currentPage; //현재 조회중인 페이지
	private int totalPages; // 전체 페이지 개수
	private int startPage; // 시작 페이지 번호
	private int endPage; // 끝 페이지 번호

	// 생성자 생성시 모든 정보를 자동으로 구하도록 처리
	public StoreinfoButtonDTO(int storeinfoCount, int currentPage) {
		// 총 글 개수와, 현재 조회중인 펭지 정보를 입력받아 아래에 딸릴 버튼개수, 현재 깔아야 하는 번호대의 버튼을 구합니다.
		// boardCount, currentPage를 멤버변수에 저장해주세요.
		this.storeinfoCount = storeinfoCount;
		this.currentPage = currentPage;
		
		// 글이 없다면
		if(this.storeinfoCount == 0) {
			// 아래에 깔리는 버튼 자체가 없어야함.
			this.totalPages = 0;
			this.startPage = 0;
			this.endPage = 0;
		} else {
			//글이 있다면
			// << 게시글 개수를 이용해 전체 페이지 개수 구하기(totalPages값 구하기)>>
			if(storeinfoCount % 10 == 0) {
				// 전체 글 개수 % 10이 0으로 떨어짐 => 10의 배수 갯수로 페이지 갯수는 10을 나눈 결과값
				this.totalPages = this.storeinfoCount / 10;
			} else {
				// 전체 글 개수 % 10이 0으로 떨어지지 않음
				this.totalPages = (this.storeinfoCount / 10) + 1;
			}// 페이지 개수 구하기 종료
			
			// << 현재 조회중인 페이지 그룹의 시작페이지 구하기(startPage값 구하기)>>
			// 시작, 끝 페이지는 게시글이 아닌 아래 깔릴 페이지 버튼임
			int navNum = 0; // 식별용으로 선언하는 변수
			
			/*
			if(currentPage % 10 == 0) {
				// 10배수 페이지는 자신이 속한 그룹보다 페이지 식별숫자가 1 크게 나옴
				navNum = (currentPage - 1) / 10;
			} else {
				navNum = currentPage / 10;
			}*/
			
			navNum = (((currentPage - 1) / 10) * 10) + 1; // 간소화 코드
			
			// 시작페이지 구하기 완료
			this.startPage = navNum;
			
			// <<현재 조회중인 페이지 그룹의 끝페이지 구하기(endPage값 구하기)>>
			this.endPage = navNum + (10 - 1); 
			// 끝페이지 관련 보정(84페이지인데 90페이지로 나오는 경우...)
			if(this.totalPages < this.endPage) {
				this.endPage = this.totalPages;
			}
			
		}// 글이 있는 경우 종료
	}

	public int getStoreinfoCount() {
		return storeinfoCount;
	}

	public void setStoreinfoCount(int storeinfoCount) {
		this.storeinfoCount = storeinfoCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	@Override
	public String toString() {
		return "StoreinfoButtonDTO [storeinfoCount=" + storeinfoCount + ", currentPage=" + currentPage + ", totalPages="
				+ totalPages + ", startPage=" + startPage + ", endPage=" + endPage + "]";
	}



}
