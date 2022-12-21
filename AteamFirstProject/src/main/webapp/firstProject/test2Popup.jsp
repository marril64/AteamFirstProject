<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test2</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Test2 Popup</h1>
		<form action="#" method="post">
			<input type="hidden" value="<%= request.getParameter("tNum") %>" name="tNum" id="tNum">
			<div class="row">
				<div class="col">
					아이디
				</div>
				<div class="col">
					<input type="text" class="form-control" name="tId" id="tId" placeholder="<%= request.getParameter("tId") %>" aria-label="First name">
				</div>
			</div>
			<div class="row">
				<div class="col">
					이름
				</div>
				<div class="col">
					<input type="text" class="form-control" name="tName" id="tName" placeholder="<%= request.getParameter("tName") %>" aria-label="Last name">
				</div>
			</div>
			<div class="row">
				<div class="col">
					성별
					<div class="form-check form-check-inline">
				  		<input class="form-check-input" type="radio" name="tGender" id="inlineRadio1" value="남">
				  		<label class="form-check-label" for="inlineRadio1">남</label>
					</div>
					<div class="form-check form-check-inline">
				  		<input class="form-check-input" type="radio" name="tGender" id="inlineRadio2" value="여">
				  		<label class="form-check-label" for="inlineRadio2">여</label>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col">
					국가
				</div>
				<div class="col">
					<select class="form-select country" aria-label="Default select example" name="tCountry">
						<option value="선택">선택</option>
				  		<option value="대한민국">대한민국</option>
				  		<option value="미국">미국</option>
				  		<option value="일본">일본</option>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="col">
					도시
				</div>
				<div class="col">
					<select class="form-select city" aria-label="Default select example" name="tCity">
					</select>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<button type="submit" class="btn btn-primary" onclick="return up();" formaction="/AteamFirstProject/firstProject/update.test2">저장</button>
				</div>
				<div class="col">
					<button type="button" class="btn btn-danger" onclick="self.close();">취소</button>
				</div>
			</div>
		</form>
	</div>
	<script type="text/javascript">
		var mainCountry = document.querySelector('.country');
		var mainOption = mainCountry.options[mainCountry.selectedIndex].value;
		var subCity = document.querySelector('.city');
		var subOptions = {
				none : ["국가를 선택해주십시오."],
				korea : ["서울", "인천", "대구", "광주", "부산", "전주"],
				usa : ["워싱턴", "뉴욕", "로스엔젤러스"],
				japan : ["도쿄", "오사카", "히로시마"]
		}
		var subOption = [];
		
		for (let i = 0; i < subOptions.none.length; i++) {
			var option = document.createElement("option");
			option.innerText = subOptions.none[i];
			subCity.append(option);
		}
		
		mainCountry.onchange = function () {
			
			subCity = document.querySelector('.city');
			mainOption = mainCountry.options[mainCountry.selectedIndex].value;
			
			if (mainOption === "선택") {
				subOption = subOptions.none;
			} else if (mainOption === "대한민국") {
				subOption = subOptions.korea;
			} else if (mainOption === "미국") {
				subOption = subOptions.usa;
			} else if (mainOption === "일본") {
				subOption = subOptions.japan;
			}
			
			subCity.options.length = 0;
			
			for (let i = 0; i < subOption.length; i++) {
				var option = document.createElement("option");
				option.innerText = subOption[i];
				subCity.append(option);
			}
			﻿
		}
		
		function up() {
		    if (document.getElementsByName("tId")[0].value === "") {
		    	alert("아이디를 빠짐없이 입력해주세요.");
		    	return false;
		    } else if (document.getElementsByName("tName")[0].value === "") {
		    	alert("이름을 빠짐없이 입력해주세요.");
		    	return false;
		    } else if (!(document.getElementsByName("tGender")[0].checked) && !(document.getElementsByName("tGender")[1].checked)) {
		    	alert("성별을 선택해주세요.");
		    	return false;
		    } else if (document.getElementsByName("tCountry")[0].value === "선택") {
		    	alert("국가를 정해주세요.");
		    	return false;
		    } else if (document.getElementsByName("tCity")[0].value === "국가를 선택해주십시오.") {
		    	alert("살고계신 도시를 정해주세요.");
		    	return false;
		    } else {
		    	opener.parent.location.reload();
		    	return true;
		    }
		}
		
		if (<%= request.getParameter("tGender").equals("남") %>) {
			document.getElementById("inlineRadio1").checked = true;
		} else if (<%= request.getParameter("tGender").equals("여") %>) {
			document.getElementById("inlineRadio2").checked = true;
		}
		
	</script>
</body>
</html>