<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
세션값 : ${sessionScope.user.id}<br/>
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
	<form action="http://localhost:8181/AteamFirstProject/storeinfoinsert.do" method="post">
	가게이름 :<input type="text" name="storeName"/></br>
	음식종류 :<input type="text" name="menu"/></br>
	소개:<textarea cols="50" rows="15" name="storeContent"></textarea></br>
	가게주소 :<input type="text" name="storeAdd"/></br>
	전화번호 :<input type="text" name="storePhone"/></br>
	영업시간 :<input type="time" name="storeStartTime"/>
			<input type="time" name="storeEndTime"/>
	
	<input type="submit" value="글쓰기"/>
	<input type="reset" value="초기화"/>
</form>

</body>
</html>