<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>이미 즐겨찾기에 추가된 가게입니다. 사랑해주셔서 감사합니다.</h3>
	<form action="/AteamFirstProject/getStoreInfoDetail.do" method="post">
		<input type="hidden" name="storeNum" value="${storeNum}">
		<input type="submit" value="돌아가기">
	</form>
</body>
</html>