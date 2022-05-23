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
	<form action="/AteamFirstProject/userPasswordCheckForm.user" method="post">
		<h2>회원정보 변경</h2>
		<h4>${sessionScope.user.id}님의 회원정보를 변경합니다.</h4>
		변경하실 pw : <input type="password" name="newPw"><br/>
		변경하실 nick : <input type="text" name="nick" value="${sessionScope.user.nick}"><br/>
		변경하실 phone : <input type="tel" name="phone" value="${sessionScope.user.phone}"><br/>
		<input type="submit" value="바꾸기">
	</form>
	<form action="/AteamFirstProject/userLoginForm.user" method="post">
		<input type="submit" value="돌아가기">
	</form>
</body>
</html>