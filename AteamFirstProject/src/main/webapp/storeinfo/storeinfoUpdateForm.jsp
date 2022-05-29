<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${sessionScope.user.id eq null }">
	<% response.sendRedirect("http://localhost:8181/AteamFirstProject/getstoreinfoList.do"); %>
</c:if>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="http://localhost:8181/AteamFirstProject/StoreInfoUpdate.do" method="post">

<input type="hidden" name="storeNum" value="${storeinfo.storeNum}">
가게이름 :<input type="text" name="storeName" value="${storeinfo.storeName }"/></br>
소개 :<textarea cols="50" rows="15" name="storeContent"> ${storeinfo.storeContent }</textarea></br>
가게주소 :<input type="text" name="storeAdd" value="${storeinfo.storeAdd }"/></br>
전화번호 :<input type="text" name="storePhone" value="${storeinfo.storePhone }"/></br>
메뉴 : <input type="text" name="menu" value="${storeinfo.menu}"><br/>
영업시간 : <input type="time" name="storeStartTime" value="${storeinfo.storeTime }"/>
		<input type="time" name="storeEndTime" value="${storeinfo.storeTime }"/> <br>
    	<input type="hidden" name= "id" value="${sessionScope.user.id }"/>
<input type="submit" value="글쓰기"/>
<input type="reset" value="초기화"/>
</body>
</html>
