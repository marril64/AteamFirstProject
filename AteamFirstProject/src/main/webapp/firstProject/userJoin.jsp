<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${sessionScope.user.id ne null}">
	<% response.sendRedirect("http://localhost:8181/AteamFirstProject/firstProject/userLogout.jsp"); %>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="http://localhost:8181/AteamFirstProject/userJoin" method="post">
		id : <input type="text" name="id">
		<input type="button" name="idcheck" value="id 중복 확인"><br/>
		pw : <input type="password" name="pw"><br/>
		pw확인 : <input type="password" name="pwcheck"><br/>
		nick : <input type="text" name="nick">
		<input type="button" name="nickcheck" value="nick 중복 확인"><br/>
		phone : <input type="tel" name="phone">
		<input type="button" name="phonecheck" value="phone 중복 확인"><br/>
		<input type="submit" value="회원가입">
	</form>
</body>
</html>