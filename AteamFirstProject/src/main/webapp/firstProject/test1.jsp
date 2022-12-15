<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test1</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

<div class="container">

	<h1>Test1</h1>
	
	<form action="#" method="post">
	
		<div class="row">
			<div class="col">
				<input type="text" class="form-control" name="tId" placeholder="아이디" aria-label="First name">
			</div>
			<div class="col">
				<input type="text" class="form-control" name="tName" placeholder="이름" aria-label="Last name">
			</div>
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
				<div class="form-check form-check-inline">
		  			<input class="form-check-input" type="radio" name="tGender" id="inlineRadio3" value="회원 전체보기">
		  			<label class="form-check-label" for="inlineRadio3">회원 전체보기</label>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col">
				<select class="form-select country" aria-label="Default select example" name="tCountry">
					<option value="선택">선택</option>
			  		<option value="대한민국">대한민국</option>
			  		<option value="미국">미국</option>
			  		<option value="일본">일본</option>
				</select>
			</div>
			<div class="col">
				<select class="form-select city" aria-label="Default select example" name="tCity">
				</select>
			</div>
			<div class="col">
				<input type="date" name="date1" value="">
			</div>
			to
			<div class="col">
				<input type="date" name="date2" value="">
			</div>
		</div>
		
		<div class="btn-group" role="group" aria-label="Basic outlined example">
			<button type="button" class="btn btn-outline-primary">
				<input type="submit" value="조회" formaction="/AteamFirstProject/firstProject/search.test1">
			</button>
			<button type="button" class="btn btn-outline-primary">
				<input type="submit" value="업데이트" onclick="return up()" formaction="/AteamFirstProject/firstProject/update.test1">
	  		</button>
			<button type="button" class="btn btn-outline-primary">
				<input type="submit" value="엑셀 다운로드" onclick="exportTableToExcel('tblData', 'test1Excel')" formaction="/AteamFirstProject/firstProject/excel.test1">
			</button>
	  		<button type="button" class="btn btn-outline-primary">
		  		<input type="submit" value="삭제" onclick="return test()" name="selected" formaction="/AteamFirstProject/firstProject/delete.test1">
	  		</button>
	  	</div>
	
	
		<table class="table table-hover" id="tblData" border=1>
			<thead>
				<tr bgcolor=yellow>	
					<th>
						<input id="allCheck" type="checkbox" onclick="allChk(this);"/>
						선택
					</th>
					<th>아이디</th>
					<th>이름</th>
					<th>성별</th>
					<th>국가</th>
					<th>도시</th>	
				</tr>
			</thead>				
			<tbody>
				<c:forEach var="list" items="${list}">
					<tr>
						<td>
							<input type="checkbox" name="tNum" class="tNum" value="${list.tNum}">
						</td>
						<td>${list.tId}</td>
						<td>${list.tName}</td>
						<td>${list.tGender}</td>
						<td>${list.tCountry}</td>
						<td>${list.tCity}</td>
					</tr>
				</c:forEach>
			</tbody>	
		</table>
		
	</form>
</div><!-- div.container -->


<script type="text/javascript">

	function allChk(obj) {
		
		var chkObj = document.getElementsByName("tNum");
		var rowCnt = chkObj.length - 1;
		var check = obj.checked;
		
		if (check) {﻿
			for (var i = 0; i <= rowCnt; i++){
				if(chkObj[i].type === "checkbox") {
					chkObj[i].checked = true;
				}
			}
		} else {
			for (var i = 0; i <= rowCnt; i++) {
				if(chkObj[i].type === "checkbox") {
					chkObj[i].checked = false;
				}
			}
		}
		
	}

﻿ ﻿ 

	// 체크박스 선택된 것 삭제 처리
	function fn_userDel() {
	
		var userid = "";
		var memberChk = document.getElementsByName("tNum");
		var chked = false;
		var indexid = false;
		
		for(i=0; i < memberChk.length; i++){
			if(memberChk[i].checked){
				if(indexid){
					userid = userid + ', ';
				}
				userid = userid + memberChk[i].value;
				indexid = true;
			}
		}
	  
		if(!indexid){
			return;
		}
	     
		return userid;
	}
	
	
	
	function exportTableToExcel(tableID, filename = ''){
	    var downloadLink;
	    var dataType = 'application/vnd.ms-excel';
	    var tableSelect = document.getElementById(tableID);
	    var tableHTML = "<body>" + tableSelect.outerHTML.replace(/ /g, '%20') + "</body>";
	    
	    // Specify file name
	    filename = filename ? filename + '.xls' : 'excel_data.xls';
	    
	    // Create download link element
	    downloadLink = document.createElement("a");
	    
	    document.body.appendChild(downloadLink);
	    
	    if(navigator.msSaveOrOpenBlob){
	        var blob = new Blob(['\ufeff', tableHTML], {
	            type: dataType
	        });
	        navigator.msSaveOrOpenBlob( blob, filename);
	    } else {
	        // Create a link to the file
	        downloadLink.href = 'data:' + dataType + ', ' + tableHTML;
	    
	        // Setting the file name
	        downloadLink.download = filename;
	        
	        //triggering the function
	        downloadLink.click();
	    }
	}

	
	var mainCountry = document.querySelector('.country');
	var mainOption = mainCountry.options[mainCountry.selectedIndex].value
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
			console.log(subOptions);
			var option = document.createElement("option");
			option.innerText = subOption[i];
			subCity.append(option);
		}
		﻿
	}
	
    function test() {
    	
    	let count = 0;
    	
    	for (let i = 0; i < document.getElementsByClassName("tNum").length; i++) {
    		if (document.getElementsByClassName("tNum")[i].checked) {
    			count++;
    		}
    	}
    	
    	if (count === 0) {
    		alert("삭제하실 회원을 선택해주십시오.");
    		return false;
    	}
    	
        if (window.confirm("선택하신 회원을 삭제하시겠습니까?")) {
        	alert("선택하신 회원정보가 삭제되었습니다.");
        	return true;
        } else {
        	alert("취소되었습니다.");
        	return false;
        }
        
    }
    
    function up() {
    	
    	let count = 0;
    	
    	for (let i = 0; i < document.getElementsByClassName("tNum").length; i++) {
    		if (document.getElementsByClassName("tNum")[i].checked) {
    			count++;
    		}
    	}
    	
    	if (count > 1) {
    		alert("한명의 회원정보만 수정할 수 있습니다.");
    		return false;
    	} else if (count === 0) {
    		if (document.getElementsByName("tId")[0].value === "") {
    			alert("아이디를 입력하시거나 수정할 회원을 고르십시오.");
    			return false;
    		} else if (document.getElementsByName("tName")[0].value === "") {
    			alert("이름을 입력해주십시오.");
    			return false;
    		} else if (!(document.getElementsByName("tGender")[0].checked) && !(document.getElementsByName("tGender")[1].checked)) {
    			alert("성별을 선택해주십시오.");
    			return false;
    		} else if (document.getElementsByClassName("city")[0].innerText === "국가를 선택해주십시오.") {
	    		alert("국가를 선택해주십시오.");
	    		return false;
	    	} else {
    			if (window.confirm("회원정보를 추가하시겠습니까?")) {
	    			return true;
    			} else {
    				alert("취소되었습니다.");
    			}
    		}
    	} else if (count === 1) {
	    	if (document.getElementsByName("tId")[0].value === "") {
	    		alert("아이디를 입력해 주십시오.");
	    		return false;
	    	} else if (document.getElementsByName("tName")[0].value === "") {
	    		alert("이름을 입력해주십시오.");
	    		return false;
	    	} else if (!(document.getElementsByName("tGender")[0].checked) && !(document.getElementsByName("tGender")[1].checked)) {
	    		alert("성별을 선택해주십시오.");
	    		return false;
	    	} else if (document.getElementsByClassName("city")[0].innerText === "국가를 선택해주십시오.") {
	    		alert("국가를 선택해주십시오.");
	    		return false;
	    	} else {
	    		if (window.confirm("선택하신 회원의 정보를 수정하시겠습니까?")) {
		    		return true;
	    		}
	    	}
	    } else {
	        alert("취소되었습니다.");
	        return false;
	    }
        
    }

</script>




</body>
</html>