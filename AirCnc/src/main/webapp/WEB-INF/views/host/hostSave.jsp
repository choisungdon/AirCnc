<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>
<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBYMK6J-N5yiDhf8Z3Bipzewlm5bOzs_iU"
  type="text/javascript"></script>
<title></title>
</head>
<body>
	<div>${loginUser.nm} 님 안녕하세요! 숙소 등록을 시작해볼까요?</div>
	<div>1단계 등록하시려는 숙소의 유형을 선택하세요.</div>
	<form action="/host/hostSaveOne" method="post">
		<input type="hidden" name="i_user" value="${loginUser.i_user}">
		<c:if test="${vo.i_host != null}">
		 <input type="hidden" name="i_host" value="${vo.i_host}">
		</c:if>
		
		<div>
			<input type="text" name="country" value="${vo.country}"  onkeydown="c_GetLatLng(this)" onchange="c_GetLatLng(this)" placeholder="국가" >
			<input type="hidden" id="c_lat" name="c_lat" value="${vo.c_lat}">
			<input type="hidden" id="c_lng" name="c_lng" value="${vo.c_lng}">
		</div>
		
		<div>
			 <input type="text" name="addr" value="${vo.addr}" onkeydown="s_GetLatLng(this)" onchange="s_GetLatLng(this)" placeholder="상세 주소">
			<input type="hidden" id="s_lat" name="s_lat" value="${vo.s_lat}">
			<input type="hidden" id="s_lng" name="s_lng" value="${vo.s_lng}">
		</div>
		
		<div>
			<select name="r_vastion">
			<c:forEach var="i" begin="1" end="16">
				<option value="${i}" ${vo.r_vastion == i ? 'selected="selected"' : '' }>최대 ${i}명 숙박 가능</option>
			</c:forEach>
			</select>
		</div>
		<div>
			<select name="b_room">
			<c:forEach var="i" begin="1" end="50">
				<option value="${i}" ${vo.b_room == i ? 'selected="selected"' : '' }>침실 ${i}개</option>
			</c:forEach>
			</select>
		</div>
		
		<div>
			<p>게스트가 사용할 수 있는 침대는 몇 개인가요?</p>
			침대
			<button type="button"	onclick="countDw(document.getElementById('bed_qty'))">-</button>
     			<input 	id="bed_qty" 	name="bed_qty"		type="number"	size="10"	value="${vo.bed_qty != null ? vo.bed_qty : 1}" >
        	<button type="button" 	onclick="countUp(document.getElementById('bed_qty'))">+</button>
		</div>
		
		<div>
			<p>침대 유형</p>
			<select name="bed_type">
				 <option value="double" ${vo.bed_type eq 'double' ? 'selected="selected"' : '' }>더블</option>
				 <option value="queen" ${vo.bed_type eq 'queen' ? 'selected="selected"' : '' }>퀸</option>
				 <option value="single" ${vo.bed_type eq 'single' ? 'selected="selected"' : '' }>싱글</option>
			</select>
		</div>
		<div>
			<p>욕실수</p>
			<button type="button"	onclick="countDw(document.getElementById('bth_room'))">-</button>
     			<input 	id="bth_room" 	name="bth_room"		type="number"	size="10"	value="${vo.bth_room != null ? vo.bth_room : 1}" >
        	<button type="button" 	onclick="countUp(document.getElementById('bth_room'))">+</button>
			
		</div>
		
		<div>
			<p>숙소 제목</p>
			<input type="text" name="room_title" value="${vo.room_title != null ? vo.room_title : '' }" placeholder="숙소 제목">
		</div>
		
		<div>
			<p>은행</p>
			<select name="acc_bank">
				<option value="국민은행" ${vo.acc_bank eq '국민은행' ? 'selected="selected"' : '' }>국민은행</option>
				<option value="농협" ${vo.acc_bank eq '농협' ? 'selected="selected"' : '' }>농협</option>
				<option value="신한은행" ${vo.acc_bank eq '신한은행' ? 'selected="selected"' : '' }>신한은행</option>
			</select>
			<p>계좌</p>
			<input type="text" name="acc" value="${vo.acc}" placeholder="계좌">
			<p>예금주</p>
			<input type="text" name="acc_owner" value="${vo.acc_owner != null ? vo.acc_owner : loginUser.nm}" placeholder="예금주">
		</div>
		<div>
			
		</div>
		<input type="submit" value="다음">
	</form>
</body>
<script type="text/javascript" >
	function countUp(d) {
	    d.value = parseInt(d.value) + 1;
	}
	
	function countDw(d) {
	    d.value = parseInt(d.value) - 1;
	    if(d.value < 1) {
	        d.value = 1;
	    }
	}
	var addr;
	
	function s_GetLatLng(obj){
		console.log(obj.value);
		
		addr =obj.value; 
		
		const geocoder = new google.maps.Geocoder();

    	const address = addr;
    	geocoder.geocode(
    	  {
    	    address: address
    	  },
    	  (results, status) => {
    	    if (status === "OK") {
    	    	var Latitude = results[0].geometry.location.lat(); // 위도 
    	    	var longitude = results[0].geometry.location.lng();// 경도 
    	    	
    	    	// hidden 테그에 삽입 (위도 경도)
    	    	s_lat.value = Latitude; 
    	    	s_lng.value = longitude;
    	    	
    	    } else {
    	      
    	    }
    	  }
    	);
	}
	
	function c_GetLatLng(obj){
		
		addr =obj.value; 
		
		const geocoder = new google.maps.Geocoder();

    	const address = addr;
    	geocoder.geocode(
    	  {
    	    address: address
    	  },
    	  (results, status) => {
    	    if (status === "OK") {
    	    	var Latitude = results[0].geometry.location.lat(); // 위도 
    	    	var longitude = results[0].geometry.location.lng();// 경도 
    	    	
    	    	// hidden 테그에 삽입 (위도 경도)
    	    	c_lat.value = Latitude; 
    	    	c_lng.value = longitude;
    	    	
    	    } else {
    	      
    	    }
    	  }
    	);
		
	}

</script>
</html>