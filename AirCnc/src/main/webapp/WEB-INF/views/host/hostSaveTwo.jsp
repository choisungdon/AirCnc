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
	<p>${loginUser.nm } 숙소 등록 3단계 </p>
	<p>어떤 편의시설을 제공하시나요?</p>
	<form action="/host/hostSaveThree" method="post">
	<input type="hidden" name="i_host" value="${i_host}">
	<input type="hidden" name="i_user" value="${loginUser.i_user}">
	<c:if test="${vo1.i_fct != null && vo2.i_spt != null }">
		<input type="hidden" name="i_fct" value="${vo1.i_fct }">
		<input type="hidden" name="i_spt" value="${vo2.i_spt }">
	</c:if>
	<div>
		<input type="checkbox" name="requier"		value="o" ${(vo1.requier != 'o') ? 'checked="checked"' : 'checked="checked"'}checked="checked"> 필수 품목(수건, 침대 시트, 비누, 화장지, 베개)
	</div>
	<div>
		<input type="checkbox" name="wifi"			value="o" ${(vo1.aircon != 'o') ? '' : 'checked="checked"'}> 무선인터넷
	</div>
	<div>
		<input type="checkbox" name="tv" 			value="o" ${(vo1.tv != 'o') ? '' : 'checked="checked"'}> TV
	</div>
	<div>
		<input type="checkbox" name="hiter" 		value="o" ${(vo1.hiter != 'o') ? '' : 'checked="checked"'}> 난방
	</div>
	<div>
		<input type="checkbox" name="aircon" 		value="o" ${(vo1.aircon != 'o') ? '' : 'checked="checked"'}> 에어컨
	</div>
	<div>
		<input type="checkbox" name="iron" 			value="o" ${(vo1.iron != 'o') ? '' : 'checked="checked"'}> 다리미
	</div>
	<div>
		<input type="checkbox" name="sampoo" 		value="o" ${(vo1.sampoo != 'o') ? '' : 'checked="checked"'}> 샴푸
	</div>
	<div>
		<input type="checkbox" name="hiar_dry" 		value="o" ${(vo1.hiar_dry != 'o') ? '' : 'checked="checked"'}> 헤어 드라이어
	</div>
	<div>
		<input type="checkbox" name="breakfast" 	value="o" ${(vo1.breakfast != 'o') ? '' : 'checked="checked"'}> 조식(커피,차)
	</div>
	<div>
		<input type="checkbox" name="place_lattop" 	value="o" ${(vo1.place_lattop != 'o') ? '' : 'checked="checked"'}> 업무 가능 공간
	</div>
	<div>
		<input type="checkbox" name="in_hiter" 		value="o" ${(vo1.in_hiter != 'o') ? '' : 'checked="checked"'}> 벽난로
	</div>
	<div>
		<input type="checkbox" name="hanger" 		value="o" ${(vo1.hanger != 'o') ? '' : 'checked="checked"'}> 옷장/서랍장
	</div>
	<div>
		<input type="checkbox" name="door" 			value="o"  ${(vo1.door != 'o') ? '' : 'checked="checked"'}> 게스트 전용 출입문
	</div>
	<div>
		<input type="checkbox" name="baby_bad" 		value="o" ${(vo1.baby_bad != 'o') ? '' : 'checked="checked"'}> 유아용 침대
	</div>
	<div>
		<input type="checkbox" name="baby_chairs" 	value="o" ${(vo1.baby_chairs != 'o') ? '' : 'checked="checked"'}> 유아용 의자
	</div>
	<div>
		<input type="checkbox" name="self_checkin"	value="o" ${(vo1.self_checkin != 'o') ? '' : 'checked="checked"'}> 셀프 체크인
	</div>
	<div>
		<input type="checkbox" name="self_bth_room"	value="o" ${(vo1.self_checkin != 'o') ? '' : 'checked="checked"'}> 욕실 단독 사용
	</div>
	
	<p>안전 시설</p>
	<div>
		<input type="checkbox" name="fire_emble" 	value="o" ${(vo2.fire_emble != 'o') ? '' : 'checked="checked"'}> 화재 감지기
	</div>
	<div>
		<input type="checkbox" name="carbon_alarm"	value="o" ${(vo2.carbon_alarm != 'o') ? '' : 'checked="checked"'}> 일산화탄소 감지기
	</div>
	<div>
		<input type="checkbox" name="madic_kit" 	value="o" ${(vo2.madic_kit != 'o') ? '' : 'checked="checked"'}> 구급상자
	</div>
	<div>
		<input type="checkbox" name="fire_exting" 	value="o" ${(vo2.fire_exting != 'o') ? '' : 'checked="checked"'}> 소화기
	</div>
	<div>
		<input type="checkbox" name="bad_lock" 		value="o" ${(vo2.bad_lock != 'o') ? '' : 'checked="checked"'}> 침실문 잠금장치
	</div>
	
	<input type="submit" value="다음">
	</form>
</body>
</html>