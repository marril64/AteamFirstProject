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

	<%
		request.setCharacterEncoding("EUC-KR");
	
		Connection conn = null;
		try{
			String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
			String user = "c##mydata";
			String password = "halfspace";
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password); // url, user, password를 변수로 처리해도됨
			System.out.println("데이터베이스 연결이 성공했습니다.");
		} catch (SQLException ex) {
			System.out.println("데이터베이스 연결이 실패했습니다.");
			out.print("SQLException : " + ex.getMessage());
		} finally {
			if(conn != null) {
				conn.close();
			}
		}
		
		String tGender = request.getParameter("tGender");
		tGender = "회원 전체보기";
		
	%>

<div class="container">

	<h1>Test2</h1>
	
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
		  			<input class="form-check-input" type="radio" name="tGender" id="inlineRadio1" value="남" OnClick="window.location.href='/AteamFirstProject/firstProject/gender.test2?tGender=남';">
		  			<label class="form-check-label" for="inlineRadio1">남</label>
				</div>
				<div class="form-check form-check-inline">
		  			<input class="form-check-input" type="radio" name="tGender" id="inlineRadio2" value="여" OnClick="window.location.href='/AteamFirstProject/firstProject/gender.test2?tGender=여';">
		  			<label class="form-check-label" for="inlineRadio2">여</label>
				</div>
				<div class="form-check form-check-inline">
		  			<input class="form-check-input" type="radio" name="tGender" id="inlineRadio3" value="회원 전체보기" OnClick="window.location.href='/AteamFirstProject/firstProject/gender.test2?tGender=회원 전체보기';">
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
				<input type="submit" value="조회" formaction="/AteamFirstProject/firstProject/search.test2">
			</button>
			<button type="button" class="btn btn-outline-primary">
				<input type="button" value="추가" onclick="rowUp()">
	  		</button>
	  		<button type="button" class="btn btn-outline-primary">
				<input type="submit" value="저장" onclick="return up()" formaction="/AteamFirstProject/firstProject/update.test2">
	  		</button>
			<button type="button" class="btn btn-outline-primary">
				<input type="submit" value="엑셀 다운로드" onclick="exportTableToExcel('tblData', 'test1Excel')" formaction="/AteamFirstProject/firstProject/excel.test2">
			</button>
	  		<button type="button" class="btn btn-outline-primary">
		  		<input type="submit" value="삭제" onclick="return test()" name="selected" formaction="/AteamFirstProject/firstProject/delete.test2">
	  		</button>
	  	</div>
	
	
		<table class="table table-hover" id="tblData" border=1>
			<thead>
				<tr bgcolor=blue>	
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
			<tbody id="tBody">
				<c:forEach var="list" items="${list}" varStatus="status">
					<tr ondblclick="dbRow('${list.tNum}', '${list.tId}', '${list.tName}', '${list.tGender}', '${list.tCountry}', '${list.tCity}');">
						<td>
							<input type="checkbox" name="tNum" class="tNum" value="${list.tNum}" id="tNum">
						</td>
						<td id="tId">${list.tId}</td>
						<td id="tName">${list.tName}</td>
						<td id="tGender">${list.tGender}</td>
						<td id="tCountry">${list.tCountry}</td>
						<td id="tCity">${list.tCity}</td>
						<input type="hidden" name="${status.index}"  value="${list.tNum}"/>
						<input type="hidden" value="${status.index}" name="tIndex" id="tIndex">
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
		
		for(let i = 0; i < memberChk.length; i++){
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

	if (<%= request.getParameter("tGender").equals("남") %>) {
		document.getElementsByName("tGender")[0].checked = true;
	} else if (<%= request.getParameter("tGender").equals("여") %>) {
		document.getElementsByName("tGender")[1].checked = true;
	} else if (<%= request.getParameter("tGender").equals("회원 전체보기") %>) {
		document.getElementsByName("tGender")[2].checked = true;
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
	
    function test() {
    	
    	let count = 0;
    	let remove = 0;
    	
    	for (let i = 0; i < document.getElementsByClassName("tNum").length; i++) {
    		if (document.getElementsByClassName("tNum")[i].checked) {
    			count++;
    		}
    	}
    	
    	for (let i = 0; i < document.getElementsByClassName("rNum").length; i++) {
    		if (document.getElementsByClassName("rNum")[i].checked) {
    			remove++;
    		}
    	}
    	
    	if (count === 0 && remove === 0) {
    		alert("삭제하실 회원을 선택해주십시오.");
    		return false;
    	}
    	
    	if (remove > 0) {
    		for (let j = 0; j < document.getElementsByClassName("rNum").length; j++) {
    			if (document.getElementsByClassName("rNum")[j].checked) {
    				document.getElementsByClassName("rNum")[j].parentNode.parentNode.remove()
    			}
    		}
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
    
    let genderCount = 0;
    
    function up() {
    	
    	let count = 0;
    	
    	for (let i = 0; i < document.getElementsByClassName("rNum").length; i++) {
    		if (document.getElementsByClassName("rNum")[i].checked) {
    			count++;
    		}
    	}
	    
	    if (document.getElementsByName("rId1")[0] === undefined) {
	    	alert("추가 버튼을 눌러 생성하십시오.");
	    	return false;
	    }
	    
	    for (let i = 1; i <= genderCount; i++) {
	    	if (document.getElementsByName("rId" + i)[0].value === "") {
	    		alert("아이디를 빠짐없이 입력해주세요.");
	    		return false;
	    	} else if (document.getElementsByName("rName" + i)[0].value === "") {
	    		alert("이름을 빠짐없이 입력해주세요.");
	    		return false;
	    	} else if (!(document.getElementsByName("rGender" + i)[0].checked) && !(document.getElementsByName("rGender" + i)[1].checked)) {
	    		alert("성별을 선택해주세요.");
	    		return false;
	    	} else if (document.getElementsByName("rCountry" + i)[0].value === "선택") {
	    		alert("국가를 정해주세요.");
	    		return false;
	    	} else if (document.getElementsByName("rCity" + i)[0].value === "국가를 선택해주십시오.") {
	    		alert("살고계신 도시를 정해주세요");
	    		return false;
	    	}
	    }
	    
	   
    }
    
    var openWin;
    
    function dbRow(num, id, name, gender, country, city) {
    	var width = 500;
    	var height = 500;
    	
    	window.name = "Form";
    	var left = (window.screen.width / 2) - (width/2);
    	var top = (window.screen.height / 4);
    	var windowStatus = 'width='+width+', height='+height+', left='+left+', top='+top+', scrollbars=yes, status=yes, resizable=yes, titlebar=yes';
        	const url = "http://localhost:8181/AteamFirstProject/firstProject/test2Popup.jsp?tNum=" + num + "&tId=" + id + "&tName=" + name + "&tGender=" + gender + "&tCountry=" + country + "&tCity=" + city;
        	openWin = window.open(url, "Test2", windowStatus);
    }
    
    function setChildText(num) {
    	openWin.document.getElementById("tNum").value = num;
    }
    
    function rowUp() {
    	
    	genderCount++;
    	
    	let table = document.getElementById("tBody");
    	let newRow = table.insertRow(0);
    	
      let newCell1 = newRow.insertCell(0);
      let newCell2 = newRow.insertCell(1);
      let newCell3 = newRow.insertCell(2);
      let newCell4 = newRow.insertCell(3);
      let newCell5 = newRow.insertCell(4);
      let newCell6 = newRow.insertCell(5);
      
      newCell1.innerHTML = '<td><input type="checkbox" name="rNum' + genderCount + '" class="col rNum" value="' + genderCount + '"></td>';
      newCell2.innerHTML = '<input type="text" class="col" name="rId' + genderCount + '" placeholder="아이디" aria-label="First name">';
      newCell3.innerHTML = '<input type="text" class="col" name="rName' + genderCount + '" placeholder="이름" aria-label="Last name">';
      newCell4.innerHTML = '<div class="form-check form-check-inline"><input class="form-check-input" type="radio" name="rGender' + genderCount + '" id="inlineRadio1" value="남">남</div><div class="form-check form-check-inline"><input class="form-check-input" type="radio" name="rGender' + genderCount + '" id="inlineRadio2" value="여">여</div>';
      newCell5.innerHTML = '<div class="col"><select class="form-select country' + genderCount + '" aria-label="Default select example" name="rCountry' + genderCount + '"><option value="선택">선택</option><option value="대한민국">대한민국</option><option value="미국">미국</option><option value="일본">일본</option></select></div>';
      newCell6.innerHTML = '<div class="col"><select class="form-select city' + genderCount + '" aria-label="Default select example" name="rCity' + genderCount + '"></select></div>';
      
  		window[subCity + genderCount] = document.getElementsByClassName("city" + genderCount);
		window[mainCountry + genderCount] = document.getElementsByClassName("country" + genderCount);
		
		if (window[mainCountry + genderCount][0].value === "선택") {
			subOption = subOptions.none;
		} else if (window[mainCountry + genderCount][0].value === "대한민국") {
			subOption = subOptions.korea;
		} else if (window[mainCountry + genderCount][0].value === "미국") {
			subOption = subOptions.usa;
		} else if (window[mainCountry + genderCount][0].value === "일본") {
			subOption = subOptions.japan;
		}
		
		document.getElementsByClassName("city" + genderCount)[0].options.length = 0;
		
		for (let i = 0; i < subOption.length; i++) {
			var option = document.createElement("option");
			option.innerText = subOption[i];
			document.getElementsByClassName("city" + genderCount)[0].append(option);
		}
		
		const inner = genderCount;
		
		document.getElementsByClassName("country" + genderCount)[0].onchange = function () {
			
			console.log(inner);
			
			if (window[mainCountry + inner][0].value === "선택") {
				subOption = subOptions.none;
			} else if (window[mainCountry + inner][0].value === "대한민국") {
				subOption = subOptions.korea;
			} else if (window[mainCountry + inner][0].value === "미국") {
				subOption = subOptions.usa;
			} else if (window[mainCountry + inner][0].value === "일본") {
				subOption = subOptions.japan;
			}
			
			document.getElementsByClassName("city" + inner)[0].options.length = 0;
			
			for (let i = 0; i < subOption.length; i++) {
				let option = document.createElement("option");
				option.innerText = subOption[i];
				document.getElementsByClassName("city" + inner)[0].append(option);
			}
			﻿
		}
		

    }

		

    
</script>




</body>
</html>