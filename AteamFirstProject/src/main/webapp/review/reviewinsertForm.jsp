<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="http://localhost:8181/AteamFirstProject/reviewrinsert" method="post">
리뷰를 쓸 번호<input type="number" name="boardNum"/></br>
글쓴이 :<input type="text" name="ruser"/></br>
글제목 :<input type="text" name="reviewName"/></br>
본문:<textarea cols="50" rows="15" name="content"></textarea>
별점 :<input type="number" min="0" max="5" name="score"></br>
<input type="submit" value="제출"/>
<input type="reset" value="초기화"/>

</body>
</html>