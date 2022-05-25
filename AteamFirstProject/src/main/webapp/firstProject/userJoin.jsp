<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${sessionScope.user.id ne null}">
	<% response.sendRedirect("/AteamFirstProject/userLogout.user"); %>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/AteamFirstProject/userJoin.user" method="post">
		id : <input type="text" name="id"><br/>
		pw : <input type="password" name="pw"><br/>
		nick : <input type="text" name="nick"><br/>
		phone : <input type="tel" name="phone"><br/>
		<input type="submit" value="회원가입">
	</form>
	<form action="/AteamFirstProject/userLoginForm.user" method="get">
		<input type="submit" value="돌아가기">
	</form>
</body>
</html>