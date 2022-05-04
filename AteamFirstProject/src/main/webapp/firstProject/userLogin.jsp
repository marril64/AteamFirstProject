<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${sessionScope.user.id ne null}">
	<% response.sendRedirect("http://localhost:8181/AteamFirstProject/firstProject/userInfo.jsp"); %>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="http://localhost:8181/AteamFirstProject/userLogin" method="post">
		로그인 창입니다.<br/>
		id : <input type="text" name="id"><br/>
		pw : <input type="password" name="pw"><br/>
		<input type="submit" value="Login">
	</form>
</body>
</html>