<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    세션값 : ${sessionScope.user.id }<br/>
<c:if test="${sessionScope.user.id eq null}">
	<% //response.sendRedirect("http://localhost:8181/AteamFirstProject/"); %>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<h1>/StoreInfoList 로 연결된 임시페이지입니다.</h1>
	<table border="1">
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
						<td><a href="http://localhost:8181/AteamFirstProject/getStoreInfoDetail?storeNum=${storeinfo.storeNum}">${storeinfo.storeName}</a></td>
						<td>${storeinfo.storeTime}</td>
						<td>${storeinfo.storePhone}</td>
						<td>${storeinfo.menu}</td>
						<td>${storeinfo.storeHit}</td>
						
					</tr>
				</c:forEach>
			</tbody>
	</table>
	
	${buttons}<br/>
	
	<ul class="pagination justify-content-center">		
			<!-- 이전 10개 페이지 조회버튼을 출력합니다.
			현재 조회중인 페이지가 1~10페이지가 아닐때만, 첫페이지 -1 을 목표주소로 해서 prev버튼을 만들면 됩니다. -->
			<c:if test="${buttons.startPage ne 1}">
				<li class="page-item"><a class="page-link" href="http://localhost:8181/AteamFirstProject/getStoreInfoList?pageNum=${buttons.startPage - 1}">Previous</a></li>
			</c:if>   
			
			<!-- foreach문의 begin, end속성을 이용해 숫자를 알맞게 깔아주세요. -->
			<c:forEach var="pageNum" begin="${buttons.startPage }" end="${buttons.endPage }">
				<li class="page-item ${buttons.currentPage eq pageNum ? 'active' : ''}"><a class="page-link" href="http://localhost:8181/AteamFirstProject/getStoreInfoList?pageNum=${pageNum}">${pageNum}</a></li>
			</c:forEach>
			
			<!-- 이후 페이지 조회버튼을 출력합니다.
			현재 조회중인 페이지그룹과 전체 글의 마지막 페이지의 관계에 대해서 생각해보시면 됩니다. -->
			<c:if test="${buttons.endPage ne buttons.totalPages}">
				<li class="page-item"><a class="page-link" href="http://localhost:8181/AteamFirstProject/getstoreinfoList?pageNum=${buttons.endPage + 1}">Next</a></li>
			</c:if>
		</ul>
		<br>
		${sessionScope.id ne null}<br/>
		<c:if test="${sessionScope.user.id ne null}">	
			<a href="http://localhost:8181/AteamFirstProject/storeinfo/storeinfoInsertForm.jsp"><button>글쓰기</button></a>
		</c:if>
	</div><!-- div.container -->
</body>
</html>