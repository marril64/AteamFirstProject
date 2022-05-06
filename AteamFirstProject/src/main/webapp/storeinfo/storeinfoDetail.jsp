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
${storeinfo }
	<h1>${storeinfo.storeNum}번 글 조회중입니다.</h1><br/>
	가게 소개 번호 : <input type="text" name="storeNum" value="${storeinfo.storeNum }"/><br/>
	가게이름 :<input type="text" name="storeName" value="${storeinfo.storeName }"/></br>
	음식종류 :<input type="text" name="menu" value="${storeinfo.menu }"/></br>
	소개:<textarea cols="50" rows="15" name="content">${storeinfo.storeContent }</textarea>
	가게주소 :<input type="text" name="storeAdd" value="${storeinfo.storeAdd }"></br>
	전화번호 :<input type="text" name="storePhone" value="${storeinfo.storePhone }"/></br>
	영업시간 :<input type="text" name="storeTime" value="${ storeinfo.storeTime}"/></br>
	
	<c:if test="${sessionScope.user.id ne null}">
	<hr/>
	<a href="http://localhost:8181/AteamFirstProject/getstoreinfoList"><button>목록</a></button><br/>
	<form action="http://localhost:8181/AteamFirstProject/storeinfodelete" method="post">
	<input type="hidden" value="${storeinfo.storeNum }" name="storeNum"/>
	<input type="submit" value="삭제"/>
	</form>
	
	<form action="http://localhost:8181/AteamFirstProject/StroreInfoUpdateForm" method="post">
	<input type="hidden" value="${storeinfo.storeNum }" name="storeNum"/>
	<input type="submit" value="수정"/>
	</form>
	<a href="http://localhost:8181/AteamFirstProject/storeinfo/storeinfoInsertForm.jsp"><button>작성하기</a></button>	
	</c:if>
</body>
</html>