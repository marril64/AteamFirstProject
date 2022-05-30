<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<c:if test="${sessionScope.user.id eq null}">
	<% //response.sendRedirect("http://localhost:8181/AteamFirstProject/userLoginForm.user"); %>
</c:if>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8">
<title>오늘 한끼도 맛있게, 맛EAT썰 </title>

</head>
<body>
<header id="header-wrap" class="div-cont">
	<div id = "header">
		<a href="http://localhost:8181/AteamFirstProject/getStoreInfoList.do" class="m_logo">
			<img src="http://localhost:8181/AteamFirstProject/storeinfo/title.png" width=150px; alt="맛EAT썰">
		</a>
	<!--  <div id="serch_cont">
	 	<from method="GET" action="/btn_h_sch.png" id= "frm-search">
	 		<input type = "hidden" name="lat" value>
	 		<input type = "hidden" name="lng" value>
	 		<div id="m_search">
	 		<input id="txt_keyword" name="query" placeholder="음식 또는 식당명 입력" type="text" value autocomplete="off" maxlength="40">
	 		<img id="closeSearch" src="http://localhost:8181/AteamFirstProject/storeinfo/btn_h_sch.png" style="display: none;">
	 		<button type="submit"></button>
	 		<div id="div_search" class="search-info"></div>
	 		</div>	
	 	</from>
	 </div> -->
	 
	  <ul id="nav3" class="nav justify-content-end bg-light">

	 	<li>
	 		<a href="/AteamFirstProject/userLoginForm.user">로그인</a>
	 	</li></br>
	 	<li>
	 		<a href="http://localhost:8181/AteamFirstProject/userJoinForm.user">회원가입</a>
	 	</li>
	 </ul>
	
	 </div>
</header>
<div class="container">
	<h1>맛집 List</h1>
	<table class="table table-hover">
	
		<thead>
			<tr>			
				<td>가게이름</td>
				<td>영업시간</td>
				<td>전화번호</td>
				<td>음식종류</td>
				<td>조회수</td>
			</tr>
		</thead>
		<form method="post" action="/storeinfo/search.jsp">
			<input type="text" class="form-control pull-right" placeholder="Search" name="searchWord" />
			<button class="btn btn-primary" type="submit" >검색</button>
		</form>
			<!-- JSTL c:forEach와 ${boardList}를 활용하면 됩니다.
			전체 글 정보를 테이블 형식으로 보여주세요. getAllBoardList.jsp 참고해주세요.-->
			<tbody>
				<c:forEach var="storeinfo" items="${storeinfoList}">
					<tr>
						
						<!-- <td>${storeinfo.storeName}</td> -->
						<td><a href="http://localhost:8181/AteamFirstProject/getStoreInfoDetail.do?storeNum=${storeinfo.storeNum}">${storeinfo.storeName}</a></td>
						<td>${storeinfo.storeTime}</td>
						<td>${storeinfo.storePhone}</td>
						<td>${storeinfo.menu}</td>
						<td>${storeinfo.storeHit}</td>
						
					</tr>
				</c:forEach>
			</tbody>
	</table>
	
	<br/>
	
	<ul class="pagination justify-content-center">		
			<c:if test="${buttons.startPage ne 1}">
				<li class="page-item"><a class="page-link" href="http://localhost:8181/AteamFirstProject/getStoreInfoList.do?pageNum=${buttons.startPage - 1}">Previous</a></li>
			</c:if>   
			
			<c:forEach var="pageNum" begin="${buttons.startPage }" end="${buttons.endPage }">
				<li class="page-item ${buttons.currentPage eq pageNum ? 'active' : ''}"><a class="page-link" href="http://localhost:8181/AteamFirstProject/getStoreInfoList.do?pageNum=${pageNum}">${pageNum}</a></li>
			</c:forEach>
			
			<c:if test="${buttons.endPage ne buttons.totalPages}">
				<li class="page-item"><a class="page-link" href="http://localhost:8181/AteamFirstProject/getStoreInfoList.do?pageNum=${buttons.endPage + 1}">Next</a></li>
			</c:if>
		</ul>
		<br/>
		
		<c:if test="${sessionScope.user.id ne null}">
			<form action="/AteamFirstProject/userLoginForm.user" method="post">
				<input type="submit" value="회원정보">
			</form>
		</c:if>
		<c:if test="${sessionScope.user.id eq 'Admin'}">	
			<a href="http://localhost:8181/AteamFirstProject/storeinfo/storeinfoInsertForm.jsp"><button>글쓰기</button></a>
		</c:if>
		<a href="http://localhost:8181/AteamFirstProject/getreviewrlist"><button>리뷰보러가기</a></button><br/>
	</div><!-- div.container -->
	
</body>
</html>