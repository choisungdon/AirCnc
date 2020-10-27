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
	<form action="/host/hostSaveTwo" method="post">
		<input type="hidden" name="i_user" value="${loginUser.i_user}">
		<input type="hidden" name="i_host" value="${i_host}">
		<c:if test="${vo.i_build != null}">
			<input type="hidden" name="i_build" value="${vo.i_build}">
		</c:if>
		<div>2단계 ${loginUser.nm}님 등록하실 숙소 종류는 무엇인가요? </div>
		<div>
			<p>건물 유형을 선택하세요</p>
			<select name="typ">
				<option value="" >하나를 선택하세요.</option>
				<option value="apt" ${vo.typ eq 'apt' ? 'selected="selected"' : ''} >아파트</option>
				<option value="outbuild" ${vo.typ eq 'outbuild' ? 'selected="selected"' : ''} >별채</option>
			</select>
		</div>
		<div>
			<p>게스트가 묵게 될 숙소 유형을 골라주세요.</p>
			<input type="radio" name="live_type" value="all" ${vo.live_type eq 'all' ? 'checked="checked"' : ''} > 집 전체
			<input type="radio" name="live_type" value="single" ${vo.live_type eq 'single' ? 'checked="checked"' : ''} >개인실
			<input type="radio" name="live_type" value="share" ${vo.live_type eq 'share' ? 'checked="checked"' : ''}>다인실
		</div>
		
		<input type="submit" value="다음">
	</form>
</body>
</html>