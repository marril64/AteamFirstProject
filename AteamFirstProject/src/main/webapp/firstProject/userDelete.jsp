<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="http://localhost:8181/AteamFirstProject/userDelete" method="post">
		탈퇴를 진행하겠습니다. id와 비밀번호를 입력해 주십시오.<br/>
		id : <input type="text" name="id">
		pw : <input type="password" name="pw">
		<input type="submit" value="탈퇴하기">
	</form>
</body>
</html>