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
가게이름 :<input type="text" name="storeName" value="${stoerinfo.storeName }"/></br>
소개 :<textarea cols="50" rows="15" name="storeContent" ${stoerinfo.storeContent }></textarea>
가게주소 :<input type="text" name="storeAdd" value="${stoerinfo.storeAdd }"/></br>
전화번호 :<input type="text" name="storePhone" value="${stoerinfo.storePhone }"/></br>
영업시간 : <input type="text" name="storeTime" value="${stoerinfo.storeTime }"/></br>
<input type="submit" value="제출"/>
<input type="reset" value="초기화"/>
</body>
</html>
