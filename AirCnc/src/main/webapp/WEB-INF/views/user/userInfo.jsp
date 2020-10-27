<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	
</style>
<body>
	<h1>개인정보</h1>
	<form action="/user/info" method="post" >
		<input type="hidden" value="${loginUser.i_user }" name="i_user">
		<div>실명</div>
		<div>수정 전 : ${loginUser.nm }</div>
		<div><input type="text" value="${loginUser.nm }" name="nm"></div>
		<hr>
		<div>E_mail</div>
		<div >수정 전 : ${loginUser.e_mail } </div>
		<div><input type="text" value="${loginUser.e_mail }" name="e_mail"></div>
		<hr>
		<div>생년월일</div>
		<fmt:parseDate value="${loginUser.bir_day}" var="dateFmt" pattern="yyyyMMdd"/>
		<div>수정 전 :<fmt:formatDate value="${dateFmt}" pattern="yyyy년 MM월 dd일"/> </div>
		<div><input type="hidden" value="${loginUser.bir_day }" id="bir_day" name="bir_day"></div>
		<div>
		
		<c:set var="sysModth"><fmt:formatDate value="${dateFmt}" pattern="MM" /></c:set> 
		<c:set var="sysDay"><fmt:formatDate value="${dateFmt}" pattern="dd" /></c:set> 
		<c:set var="sysYear"><fmt:formatDate value="${dateFmt}" pattern="yyyy" /></c:set> 
		
		<select id="month"  onchange="getBir()">
			<c:forEach var="i" begin="1" end="12" step="1">
					 <option value="${i}" ${sysModth == i ? 'selected="selected"' : '' }>${i}월</option>
			</c:forEach>
		</select>
		
		<select id="day" onchange="getBir()">
			<c:forEach var="i" begin="1" end="31" step="1">
					 <option value="${i }"  ${sysDay == i ? 'selected="selected"' : '' }>${i}일</option>
			</c:forEach>
		</select>
		
		<select id="year" onchange="getBir()">
			<c:forEach var="i" begin="1900" end="2020" step="1">
					 <option value="${i }" ${sysYear == i ? 'selected="selected"' : '' }>${i}년</option>
			</c:forEach>
		</select>
		
		</div>
		<hr>
		<div>연락처</div>
		<div>수정 전 : ${loginUser.ph} </div>
		<div><input type="text" value="${loginUser.ph }" name="ph"></div>
		
		<input type="submit" value="수정">
	</form>
</body>
<script>
	
	function getBir(){
		var date = new Date();
		var year 	=  document.getElementById("year").value;
		var month 	=  document.getElementById("month").value;
		var day 	=  document.getElementById("day").value;
		 	month 	=  month >= 10 ? month : '0' + month;
		 	day 	=  day >= 10 ? day : '0' + day; 
		 	
		bir_day.value= year+month+day;
		
	}
</script>
</html>