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
	
	<p>${loginUser.nm } 숙소 등록 4단계</p>
	<div>게스트가 어떤 공간을 사용할 수 있나요?</div>
	<form action="/host/hostSaveFour" method="post">
		<input type="hidden" name="i_host" value="${i_host}">
		<input type="hidden" name="i_user" value="${loginUser.i_user}">
		<c:if test="${vo.i_gest != null}">
			<input type="hidden" name="i_gest" value="${vo.i_gest}">
		</c:if>
		<div>
			<input type="checkbox" name="liviroom" value="o" ${vo.liviroom != 'o' ? '' : 'checked="checked"'} >단독 사용하는 거실
		</div>
		<div>
			<input type="checkbox" name="cooking" value="o" ${vo.cooking != 'o' ? '' : 'checked="checked"'}>주방
		</div>
		<div>	
			<input type="checkbox" name="waching" value="o" ${vo.waching != 'o' ? '' : 'checked="checked"'}>세탁 공간 - 세탁기
		</div>
		<div>
			<input type="checkbox" name="drying" value="o" ${vo.drying != 'o' ? '' : 'checked="checked"'}>세탁 공간 - 건조기
		</div>
		<div>
			<input type="checkbox" name="paking" value="o" ${vo.paking != 'o' ? '' : 'checked="checked"'}>주차
		</div>
		<div>
			<input type="checkbox" name="gym" value="o" ${vo.gym != 'o' ? '' : 'checked="checked"'}>헬스장
		</div>
		<div>
			<input type="checkbox" name="swim_pool" value="o" ${vo.swim_pool != 'o' ? '' : 'checked="checked"'}>수영장
		</div>
		<div>
			<input type="checkbox" name="jacuzzi" value="o" ${vo.jacuzzi != 'o' ? '' : 'checked="checked"'}>자쿠지
		</div>
		
		<input type="submit" value="다음">
	</form>

</body>
</html>