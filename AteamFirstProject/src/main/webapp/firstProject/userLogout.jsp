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
	<form action="/AteamFirstProject/userLogout.user" method="post">
		로그아웃을 진행하시겠습니까?<br/>
		<input type="submit" name="yes" value="네">
		<input type="submit" name="no" value="아니오">
	</form>
</body>
</html>