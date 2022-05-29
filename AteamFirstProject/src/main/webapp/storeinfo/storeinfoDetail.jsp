<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${storeinfo.storeNum}번 글 조회중입니다.</h1><br/>
	
	가게이름 :<input type="text" name="storeName" value="${storeinfo.storeName }"/>조회수 : ${storeinfo.storeHit}</br>
	음식종류 :<input type="text" name="menu" value="${storeinfo.menu }"/></br>
	소개:<textarea cols="50" rows="15" name="content">${storeinfo.storeContent }</textarea></br>
	가게주소 :<input type="text" name="storeAdd" value="${storeinfo.storeAdd }"></br>
	전화번호 :<input type="text" name="storePhone" value="${storeinfo.storePhone }"/></br>
	영업시간 :<input type="text" name="storeTime" value="${ storeinfo.storeTime}"/></br>

	
	<hr/>
	<a href="http://localhost:8181/AteamFirstProject/getStoreInfoList.do"><button>목록</a></button><br/>
	<c:if test="${sessionScope.user.id eq 'Admin'}">  
		<a href="http://localhost:8181/AteamFirstProject/storeinfo/storeinfoInsertForm.jsp"><button>작성하기</a></button>	
		
		
		<form action="http://localhost:8181/AteamFirstProject/storeinfoUpdateForm.do" method="post">
			<input type="hidden" value="${storeinfo.storeNum}" name="storeNum">
			<input type="submit" value="수정">
		</form>
		
		<form action="http://localhost:8181/AteamFirstProject/storeinfodelete.do" method="post">	
			<input type="hidden" name="storeNum" value="${storeinfo.storeNum }">
			<input type="hidden" name="id" value="${sessionScope.user.id}">	
			<input type="hidden" name="userNum" value="${sessionScope.user.userNum}">	
			<input type="submit" value="삭제"/>
		</form>
	</c:if>
	<form action="http://localhost:8181/AteamFirstProject/firstProject/userBookmarkUpdate.jsp" method="get"> 	
		<input type="hidden" name="storeNum" value="${storeinfo.storeNum}">
		<input type="hidden" name="userNum" value="${sessionScope.user.userNum}">
		<input type="submit" value="즐겨찾기 추가">
	</form>
	
</body>
</html>