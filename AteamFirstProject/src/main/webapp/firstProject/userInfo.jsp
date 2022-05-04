<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${sessionScope.user.id}님 환영합니다.</h1>
	<h3>회원고유번호 : ${sessionScope.user.userNum}</h3>
	<h3>전화번호 : ${sessionScope.user.phone}</h3>
	<h3>닉네임 : ${sessionScope.user.nick}</h3>
	<form action="#" method="post">
		<input type="submit" value="즐겨찾기">
	</form>
	<form action="http://localhost:8181/AteamFirstProject/userUpdateForm" method="post">
		<input type="submit" value="수정하기">
	</form>
	<form action="#" method="post">
		<input type="submit" value="삭제">
	</form>
</body>
</html>