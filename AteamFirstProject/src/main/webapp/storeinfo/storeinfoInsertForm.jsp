<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="http://localhost:8181/AteamFirstProject/storeinfoinsert" method="post">
	가게이름 :<input type="text" name="storeName"/></br>
	음식종류 :<input type="text" name="menu"/></br>
	소개:<textarea cols="50" rows="15" name="content"></textarea>
	가게주소 :<input type="text" name="storeAdd"/></br>
	전화번호 :<input type="text" name="storePhone"/></br>
	영업시간 :<input type="text" name="storeTime"/></br>
	
<input type="submit" value="목록"/>
</body>
</html>