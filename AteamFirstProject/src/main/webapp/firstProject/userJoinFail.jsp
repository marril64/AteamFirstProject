<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row" style="float: none; margin:0 auto;">
			<h3 class="col-md-12">ID나 Nick이 중복되었습니다. 다시 확인해주십시오.</h3>
		</div>
        <div class="col-md-1" style="float: none; margin:0 auto;">
			<form action="/AteamFirstProject/userJoinForm.user" method="get">
				<input type="submit" value="회원가입 화면">
			</form>
		</div>
	</div>
</body>
</html>