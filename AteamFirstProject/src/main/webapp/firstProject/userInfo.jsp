<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${sessionScope.user.id eq null}">
	<% response.sendRedirect("/AteamFirstProject/userLoginForm.user"); %>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>${sessionScope.user.id}님 환영합니다.</h1>
		<h3>회원고유번호 : ${sessionScope.user.userNum}</h3>
		<h3>전화번호 : ${sessionScope.user.phone}</h3>
		<h3>닉네임 : ${sessionScope.user.nick}</h3>
		<div class="btn-group" role="group" aria-label="First group">
			<form action="/AteamFirstProject/userBookmarkForm.user" method="post">
				<input type="hidden" name=id value="${sessionScope.user}">
				<input type="hidden" name="userNum" value="${sessionScope.user.userNum}">
				<input type="submit" value="즐겨찾기">
			</form>
		</div>
		<div class="btn-group" role="group" aria-label="Second group">
			<form action="/AteamFirstProject/userUpdateForm.user" method="post">
				<input type="hidden" name="id" value="${sessionScope.user}">
				<input type="submit" value="수정하기">
			</form>
		</div>
		<div class="btn-group" role="group" aria-label="Third group">
			<form action="/AteamFirstProject/userDeleteForm.user" method="post">
				<input type="hidden" name="id" value="${sessionScope.user}">
				<input type="submit" value="회원탈퇴">
			</form>
		</div>
		<div class="btn-group" role="group" aria-label="fourth group">
			<form action="/AteamFirstProject/userLogoutForm.user" method="post">
				<input type="submit" value="로그아웃">
			</form>
		</div>
		<div class="btn-group" role="group" aria-label="fifth group">
			<form action="/AteamFirstProject/getStoreInfoList.do" method="post">
				<input type="submit" value="목록으로 돌아가기">
			</form>
		</div>
	</div>
</body>
</html>