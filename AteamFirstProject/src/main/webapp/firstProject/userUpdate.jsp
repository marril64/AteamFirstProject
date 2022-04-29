<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="http://localhost:8181/AteamFirstProject/userUpdate" method="post">
		변경하실 id를 입력해주시고 비밀번호와 닉네임, 전화번호를 변경해 주십시오.<br/>
		id : <input type="text" name="id"><br/>
		pw : <input type="password" name="pw"><br/>
		nick : <input type="text" name="nick"><br/>
		phone : <input type="tel" name="phone"><br/>
		<input type="submit" value="바꾸기">
	</form>
</body>
</html>