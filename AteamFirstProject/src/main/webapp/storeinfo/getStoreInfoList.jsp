<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <!-- 세션값 : ${sessionScope.user.id }<br/>-->
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
		<a href="/" class="m_logo">
			<img src="file:///C:/eclipse2/workspace_prj/AteamFirstProject/src/main/webapp/storeinfo/제목을%20입력해주세요_-001%20(1).png" alt="맛EAT썰">
		</a>
	 <div id="serch_cont">
	 	<from method="GET" action="/search.jsp" id= "frm-search">
	 		<input type = "hidden" name="lat" value>
	 		<input type = "hidden" name="lng" value>
	 		<div id="m_search">
	 		<input id="txt_keyword" name="query" placeholder="음식 또는 식당명 입력" type="text" value autocomplete="off" maxlength="40">
	 		<img id="closeSearch" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADwAAAA8CAYAAAA6/NlyAAAACXBIWXMAAC4jAAAuIwF4pT92AAAFAElEQVRogd3bW6hUdRTH8c8ZDxllSpBhpFg9WPmQdDO01FIsooKuhpbHS4YvFtVDT9VLL0H1EEJQYeaF5BQalBRFqNnRLlLZjaIbqSiCkWb5oB49PawZzjjObd+my/flzPz3zNq/H7P3f6+1/v/T1dfXpyBG4GpcigkYizEYhjMwgAP4E/vwC77BZ9hSPpY7XTkbHoO7cQeuxJCUcY7hU6zDa9iZizr5GO7CTDyEG1DKGrCG43gHT+ODrMGyipuJj/EubswhXj1KuAmbsBnXZg2WhjF4A+9hYhYBCZmCjViNc9IESGN4rphcbk1zwpy4B9/hrqRfTGJ4KF7BSgxPeqICGCEmtKU4pd0vtWv4LGzAvOS6CmcJ3haPupa0Y3iUmB0nZxBVNDPEvT2y1QdbGR4pZsfx2TUVzuVYLy71hjQzfBrewoU5iiqaiSJZaXhPNzO8FFflragDTMezjQ42MjwPCwuR0xmWiPT2JOoZHo3nCpXTGV4SE+4J1DP8vBY3/n+EM/FM7WCt4Rm4pSNyOsMcTK0eqDX8VOe0dIQuPFk9UG14Jq7IEHxAVDPL8XOGOBV+KsfakjHOVFF04ETDD2cIOiAS+Wlidr9YVDRpWVGOsRDXYFGGWPBo5UXF8ChcnyHgRqyten8U80WhkZTlwmh/1dgyfJJWnKjVRzNoeLb07RjYXWfsmBCexPRy8Wser3PsxxS6KgzBLAYNJ64ra5iifjqXxHQzs0NV3YcpuY0wPEw03LJwnrjs6l0l7ZhuZnaIuKfHZpNoEkaURCu1O2MwuBcvS266ldlVohOalSGYVJJvndsjmel2zM7OUd+EbvnXuj3lvwuFyWoqpgeEyWZmV8rXLFzUjQtyDkpr0/cZNF1LxeycAnSN68bZBQSmtel6FGkWRpe02fxKSbN7upaizVKepYsuBXs0fmRV6IRZyoY7wXFxzzajv8XxPOgv4UjBJ2n26KmQJg1Nw6ESfi/wBO2YrdAJ0wdL6if+edAqqWiWnKwqSNOuknyK9VpamV2peUa2QDGmd3Tj25yDtmO2ejZu9JxeUH49N0dtX5awLceASc22yr3z/qW/KIkV/EaZTxJWSGa2Qjum1+Sg7yi2lrBfbCDJwm4slj43bmV6Pn7NpJCP8Fcl8ejNGGwbDtcZT5JBNTN9BB+mVhesY7DF0yvbZT1e9ICrSZMuNjN9fjppCG+9DBreK3bipGUcHq+Kd6po06bJjXvE1orqHtn9ol2blvXC4wn7tKaJxe8sfC82m0xSZyErITtEY3+c7Mu21yl7q92YtlWI/T/Rp8HKAzzRWS0d4bHqN7WG38ebndNSOL1qtivWq4eX4I+OyCmWA3ikdrCe4V0iifivsxh7agcbdTx68WKhcorlBbFL7ySatXgekG3F7p9iAx5sdLCZ4SO4GV/nrahAtuN2TdpWrZp4v4l14+25SSqOr4TWphNuO13LvSIL25iDqKLYKDTua/XBdtu0B8Uq+rIMoopimdB2oJ0PJ+lLHxYF/lz/juf0frFRfJH6pWld0jTiV4tycI3WzfWiWFvW8GrSL6ZdedgjSr/psm8rSsJWca/eqVzuJSXrUssmUadOETl4Hr2xWo6WY08TuxU2ZwmWx1YHogTrE0uvs8QmmckZ4veLX/N1kfW1nH3bJe//TKtmuDB9GS4RG1/OFZs+Ty9/5pCYfHbiB7E16XNh9mARov4G+bUgkzuhJHIAAAAASUVORK5CYII=" style="display: none;">
	 		<button type="submit"></button>
	 		<div id="div_search" class="search-info"></div>
	 		</div>	
	 	</from>
	 </div>
	 <ul class="t-gnb">
	 	<li>
	 		<a href="/AteamFirstProject/userLoginForm.user">로그인</a>
	 	</li>
	 	<li>
	 		<a href="http://localhost:8181/AteamFirstProject/userJoinForm.user">회원가입</a>
	 	</li>
	 </ul>
	 </div>
</header>
<div class="container">
	<h1>/StoreInfoList 로 연결된 임시페이지입니다.</h1>
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
				<li class="page-item"><a class="page-link" href="http://localhost:8181/AteamFirstProject/getStoreInfoList.do?pageNum=${buttons.startPage - 1}">Previous</a></li>
			</c:if>   
			
			<!-- foreach문의 begin, end속성을 이용해 숫자를 알맞게 깔아주세요. -->
			<c:forEach var="pageNum" begin="${buttons.startPage }" end="${buttons.endPage }">
				<li class="page-item ${buttons.currentPage eq pageNum ? 'active' : ''}"><a class="page-link" href="http://localhost:8181/AteamFirstProject/getStoreInfoList.do?pageNum=${pageNum}">${pageNum}</a></li>
			</c:forEach>
			
			<!-- 이후 페이지 조회버튼을 출력합니다.
			현재 조회중인 페이지그룹과 전체 글의 마지막 페이지의 관계에 대해서 생각해보시면 됩니다. -->
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
	</div><!-- div.container -->
	
</body>
</html>