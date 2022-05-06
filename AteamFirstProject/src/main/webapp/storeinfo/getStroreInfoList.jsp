<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>/StoreInfoList 로 연결된 임시페이지입니다.</h1>
	<table border="1">
		<thead>
			<tr>
				<td>글번호</td>
				<td>가게이름</td>
				<td>영업시간</td>
				<td>주소</td>
				<td>전화번호</td>
				<td>음식종류</td>
				<td>매장소개</td>
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
						<td>${storeinfo.storeNum}</td>
						<!-- <td>${storeinfo.storeName}</td> -->
						<td><a href="http://localhost:8181/AteamFirstProject/getStoreInfoDetail?storeNum=${storeinfo.storeNum}">${storeinfo.storeName}</a></td>
						<td>${storeinfo.storeTime}</td>
						<td>${storeinfo.storeAdd}</td>
						<td>${storeinfo.storePhone}</td>
						<td>${storeinfo.menu}</td>
						<td>${storeinfo.storeContent}</td>
					</tr>
				</c:forEach>
			</tbody>
	</table>
	<form action="http://localhost:8181/AteamFirstProject/storeinfo/storeinfoInsertForm.jsp" method="post">
	<button class="btn btn-primary" type="submit" >글쓰기</button>
	</form>
</body>
</html>