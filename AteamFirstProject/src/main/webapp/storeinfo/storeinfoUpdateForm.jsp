<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${storeinfo}<hr/>
<form action="http://localhost:8181/AteamFirstProject/storeinfoupdate" method="post">
가게이름 :<input type="text" name="storeName" value="${storeinfo.storeName }"/></br>
소개 :<textarea cols="50" rows="15" name="storeContent" ${storeinfo.storeContent }></textarea></br>
가게주소 :<input type="text" name="storeAdd" value="${storeinfo.storeAdd }"/></br>
전화번호 :<input type="text" name="storePhone" value="${storeinfo.storePhone }"/></br>
영업시간 : <input type="text" name="storeTime" value="${storeinfo.storeTime }"/></br>
<input type="submit" value="제출"/>
<input type="reset" value="초기화"/>
</body>
</html>
