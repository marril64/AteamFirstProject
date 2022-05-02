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
${reviewr}<hr/>
<form action="http://localhost:8181/AteamFirstProject/reviewrupdate" method="post">
<<<<<<< HEAD
=======
번호 : <input type="text" name="reviewNum" readonly value="${reviewr.reviewNum}"><br/>
>>>>>>> fbe50eca4c03ee9edb07b2940db41d60c75990a2
글쓴이 :<input type="text" name="ruser" readonly value="${reviewr.ruser }"/></br>
글제목 :<input type="text" name="reviewrName" value="${reviewr.reviewName }"/></br>
본문:<textarea cols="50" rows="15" name="content" ${reviewr.content }></textarea>
별점 :<input type="number" min="0" max="5" name="score" value="${reviewr.score }"></br>
<input type="submit" value="제출"/>
<input type="reset" value="초기화"/>
</form>
</body>
</html>