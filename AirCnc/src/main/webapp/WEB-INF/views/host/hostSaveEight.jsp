<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>9단계 ${loginUser.nm}님  숙소 연락처를 지정하세요.</p>
	<form action="/host/hostSaveNine" method="post">
		<input type="hidden" name="i_host" value="${i_host}">
		<input type="hidden" name="i_user" value="${loginUser.i_user}">
		<c:if test="${vo.i_ph != null}"> 
			<input type="hidden"  name="i_ph" value="${vo.i_ph}">
		</c:if>
		<div>연락처</div>
		<div>
			<input type="text" name="wp_ph" value="${(vo.wp_ph != null && vo.wp_ph != '') ? vo.wp_ph : ''}" placeholder="ex)01085474587">
		</div>
		<div>
			게스트 연락 가능 여부 <input type="checkbox" name="gest_ok" value="o"  ${vo.gest_ok != 'o' ? '' : 'checked="checked"'}>
		</div>
		<input type="submit" value="다음">
	</form>

</body>
</html>