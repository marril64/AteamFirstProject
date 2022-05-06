<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="http://localhost:8181/AteamFirstProject/userPasswordCheck" method="post">
		비밀번호를 다시 입력해주세요.<br/>
		<input type="hidden" name="id" value="${sessionScope.user.id}">
		<input type="password" name="pw"><br/>
		<input type="submit" value="확인">
	</form>
</body>
</html>