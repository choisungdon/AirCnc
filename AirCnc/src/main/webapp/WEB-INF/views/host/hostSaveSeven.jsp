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
	<p>8단계 ${loginUser.nm}님  숙소 요금을 지정해주세요.</p>
	<form action="/host/hostSaveEight" method="post">
		<input type="hidden" name="i_host" value="${i_host}">
		<input type="hidden" name="i_user" value="${loginUser.i_user}">
		<c:if test="${vo.i_fee != null}"> 
			<input type="hidden"  name="i_fee" value="${vo.i_fee}">
		</c:if>
		<div>기본 요금</div>
		<div>스마트 요금 기능을 사용하지 않을 때 적용되는 기본 요금입니다.</div>
		<div>
			<input type="text" name="fee" value="${vo.fee != null ? vo.fee : ''}" placeholder="원">
		</div>
		<div>주 단위 할인율</div>
		<div>
			<input type="text" name="w_sale" value="${vo.w_sale != null ? vo.w_sale : ''}" placeholder="%">
		</div>
		<div>월 단위 할인율</div>
		<div>
			<input type="text" name="m_sale" value="${vo.m_sale != null ? vo.m_sale : ''}" placeholder="%">
		</div>
		
		<div>
			할인 적용 여부
			<input type="checkbox" name="sale" value="o" ${vo.sale != 'o' ? '' : 'checked="checked"'}>
		</div>
		
		<div>
			<input type="submit" value="다음">
		</div>
	</form>
	
	
</body>
</html>