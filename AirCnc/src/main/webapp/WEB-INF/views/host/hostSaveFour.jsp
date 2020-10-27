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
	
	<p>${loginUser.nm}님  5 단계 </p>
	<div>게스트에게 숙소에 대해 설명해주세요.</div>
	<div>숙소의 장점, 특별한 편의시설(예: 빠른 와이파이 또는 주차 시설)과 주변 지역의 매력을 소개해주세요.</div>
	<form action="/host/hostSaveFive" method="post">
		<input type="hidden" name="i_host" value="${i_host }">
		<input type="hidden" name="i_user" value="${loginUser.i_user}">
		<c:if test="${vo.i_sinfo != null}">
			<input type="hidden" name="i_sinfo" value="${vo.i_sinfo}">
		</c:if>
		<div>숙소 장점 및 주변 시설 설명..</div>
		<div>
			<textarea name="expa" cols="30" rows="5" >${(vo.expa != null ) ? vo.expa : null}</textarea>
		</div>
		<div>숙소 정보 설명..</div>
		<div>
			<textarea  name="room_info" cols="30" rows="5"  >${(vo.room_info != null )?vo.room_info:''}</textarea>
		</div>
		<div>지역 정보 설명..</div>
		<div>
			<textarea  name="loca_info" cols="30" rows="5" >${(vo.loca_info != null )?vo.loca_info:''}</textarea>	
		</div>
		<div>교통편 정보 설명..</div>
		<div>
			<textarea  name="traf_info" cols="30" rows="5">${(vo.traf_info != null )?vo.traf_info:''}</textarea>
		</div>
		
		<input type="submit" value="다음">
	</form>

</body>
</html>