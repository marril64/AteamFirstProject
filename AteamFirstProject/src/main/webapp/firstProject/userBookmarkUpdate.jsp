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
	<form action="http://localhost:8181/AteamFirstProject/userBookmarkUpdate" method="post">
		이 가게를 즐겨찾기에 추가하시겠습니까?<br/>
		<input type="hidden" name="userNum" value="${sessionScope.user.userNum}">
		<input type="hidden" name="storeNum" value="${param.storeNum}">
		<input type="submit" name="yes" value="네">
		<input type="submit" name="no" value="아니오">
	</form>
</body>
</html>