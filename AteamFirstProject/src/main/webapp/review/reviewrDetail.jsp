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
${reviewr}
	<h1>${reviewr.reviewNum}번 글 조회중입니다.</h1><br/>
	리뷰 번호 <input type="text" value="${reviewr.reviewNum }">조회수 : ${reviewr.hit} </br>
	글 번호 <input type="text" value="${reviewr.boardNum }">s
	리뷰 제목 : <input type="text" value="${reviewr.reviewName }"><br/>
	본문 : <textarea cols="40" rows="10">${reviewr.content }</textarea><br/>
	글쓴이 : <input type="text" value="${reviewr.ruser }"><br/>
	쓴날짜 : ${reviewr.bDate }
	별점 : ${reviewr.score }
	
	<hr/>
	<a href="http://localhost:8181/AteamFirstProject/getreviewrlist"><button>목록</a></button><br/>
	<form action="http://localhost:8181/AteamFirstProject/reviewrdelete" method="post">
	<input type="hidden" value="${reviewr.reviewNum }" name="reviewNum"/>
	<input type="submit" value="삭제"/>
	</form>
	
	<form action="http://localhost:8181/AteamFirstProject/reviewrupdateform" method="post">
	<input type="hidden" value="${reviewr.reviewNum }" name="reviewNum"/>
	<input type="submit" value="수정"/>
	</form>
	<a href="http://localhost:8181/AteamFirstProject/review/reviewinsertForm.jsp">리뷰쓰기</a>
	
		
	

</body>
</html>