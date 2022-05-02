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
<h1>/ReviewrList 로 연결된 임시페이지입니다.</h1>
	<table border="1">
		<thead>
			<tr>
				<td>리뷰작성번호</td>
				<td>글번호</td>
				<td>리뷰 제목</td>
				<td>리뷰 작성자</td>
				<td>조회수</td>
				<td>리뷰 작성 날짜</td>
				<td>리뷰 본문</td>
				<td>별점</td>
			</tr>
		</thead>
			<!-- JSTL c:forEach와 ${boardList}를 활용하면 됩니다.
			전체 글 정보를 테이블 형식으로 보여주세요. getAllBoardList.jsp 참고해주세요.-->
			<tbody>
				<c:forEach var="reviwer" items="${reviewrList}">
					<tr>
						<td>${reviwer.reviewNum}</td>
						<td>${reviwer.boardNum}</td>
						<td><a href="http://localhost:8181/AteamFirstProject/getreviewrdetail?reviewNum=${reviwer.reviewNum}">${reviwer.reviewName}</a></td>
						<td>${reviwer.ruser}</td>
						<td>${reviwer.hit}</td>
						<td>${reviwer.bDate}</td>
						<td>${reviwer.content}</td>
						<td>${reviwer.score}</td>
					</tr>
				</c:forEach>
			</tbody>
	</table>

</body>
</html>