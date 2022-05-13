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
	<form action="http://localhost:8181/AteamFirstProject/userPasswordCheck" method="post">
		비밀번호를 다시 입력해주세요.<br/>
		<input type="hidden" name="id" value="${sessionScope.user.id}">
		<input type="hidden" name="newPw" value="${param.newPw}">
		<input type="hidden" name="nick" value="${param.nick}">
		<input type="hidden" name="phone" value="${param.phone}">
		<input type="password" name="pw"><br/>
		<input type="submit" value="확인">
	</form>
</body>
</html>