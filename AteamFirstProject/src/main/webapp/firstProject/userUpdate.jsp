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
	<form action="http://localhost:8181/AteamFirstProject/userPasswordCheckForm" method="post">
		<h2>회원정보 변경</h2>
		id : ${sessionScope.user.id}<br/>
		변경하실 pw : <input type="password" name="newPw"><br/>
		변경하실 nick : <input type="text" name="nick" value="${sessionScope.user.nick}"><br/>
		변경하실 phone : <input type="tel" name="phone" value="${sessionScope.user.phone}"><br/>
		<input type="submit" value="바꾸기">
	</form>
</body>
</html>