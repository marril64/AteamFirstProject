<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="http://localhost:8181/MyFirstWeb/userJoinForm" method="post">
		id : <input type="text" name="id">
		<input type="button" name="idcheck" value="id 중복 확인"><br/>
		pw : <input type="password" name="pw"><br/>
		pw확인 : <input type="password" name="pwcheck"><br/>
		nick : <input type="text" name="nick"><br/>
		phone : <input type="phone" name="phone"><br/>
		<input type="submit" value="회원가입">
	</form>
</body>
</html>