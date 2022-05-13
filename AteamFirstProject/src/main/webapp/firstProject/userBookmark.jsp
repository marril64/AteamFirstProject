<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${sessionScope.user.id eq null}">
	<% response.sendRedirect("http://localhost:8181/AteamFirstProject/userLoginForm"); %>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${sessionScope.user.nick}님의 북마크 페이지입니다.
	<table border="1">
		<thead>
			<tr>
				<th>가게번호</th>
				<th>가게이름</th>
				<th>영업시간</th>
				<th>가게주소</th>
				<th>전화번호</th>
				<th>메뉴</th>
				<th>즐겨찾기 삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="store" items="${store}">
				<tr>
					<td>${store.storeNum}</td>
					<td><a href="http://localhost:8181/AteamFirstProject/getStoreInfoDetail?storeNum=${store.storeNum}">${store.storeName}</a></td>
					<td>${store.storeTime}</td>
					<td>${store.storeAdd}</td>
					<td>${store.storePhone}</td>
					<td>${store.menu}</td>
					<td>
						<form action="http://localhost:8181/AteamFirstProject/firstProject/userBookmarkDelete.jsp" method="post">
							<input type="hidden" name="storeNum" value="${store.storeNum}">
							<input type="submit" value="삭제">
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<form action="http://localhost:8181/AteamFirstProject/firstProject/userInfo.jsp" method="post">
		<input type="submit" value="돌아가기">
	</form>
</body>
</html>