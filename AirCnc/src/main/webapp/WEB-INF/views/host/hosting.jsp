<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<p>새로운 숙소 등록 </p>
	<a href="/host/hostSave?i_user=${loginUser.i_user}"><button type="button">등록</button></a>
	<p>숙소 등록중</p>
	<c:forEach items="${data1}" var="item">
		<a href="/host/duplicate?i_host=${item.host_user}"><div>${item.room_title }</div></a>
	</c:forEach>
	
	<p>등록 완료</p>
	
	<c:forEach items="${data2}" var="item">
	<div>
		<a href="/host/duplicate?i_host=${item.host_user}">${item.room_title }</a>
		<button type="button" onclick="delHost(${item.host_user})">삭제</button>
	</div>
	</c:forEach>
	
</body>
	<script>
		function delHost(i_host){
			location.href="/host/delHost?i_host="+i_host;
		}
	</script>
</html>