<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${sessionScope.user.id eq null}">
	<% response.sendRedirect("/AteamFirstProject/userLoginForm.user"); %>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/AteamFirstProject/userDelete.user" method="post">
		탈퇴를 진행하겠습니다. 비밀번호를 입력해 주십시오.<br/>
		id : ${sessionScope.user.id}<br/>
		<input type="hidden" name="id" value="${sessionScope.user.id}">
		pw : <input type="password" name="pw">
		<input type="submit" value="탈퇴하기">
	</form>
	<form action="/AteamFirstProject/userLoginForm.user" method="post">
		<input type="submit" value="돌아가기">
	</form>
</body>
</html>