<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBYMK6J-N5yiDhf8Z3Bipzewlm5bOzs_iU&callback=initMap&libraries=&v=weekly"
	defer></script>
<title>map</title>

<style type="text/css">
#map {
	height: 100%;
}

html, body {
	height: 100%;
	margin: 0;
	padding: 0;
}
</style>

</head>
<body>
	<div id="map"></div>
	
	<script>
	
	function initMap() {
		var uluru; //좌표 넣을 변수 
		var marker;// 마커 넣을 변수 
		
		// 기준점이 되는 좌표 
		<c:forEach items="${data}" var="item">
			uluru = {lat: ${item.c_lat} , lng: ${item.c_lng} };// 검색 나라 좌표 
		</c:forEach>
		// 지도 생성 
		var map = new google.maps.Map(
	  		      document.getElementById('map'), {zoom: 7, center: uluru}); //  검색 나라 좌표 기준 줌 
   	 	
  		// 마커 표시 (forEach문 )
  		 <c:forEach items="${data}" var="item">
  		 	uluru 	= {lat: ${item.s_lat}, lng: ${item.s_lng} }; // 각각 숙소 좌표 
  		 	marker 	= new google.maps.Marker({ // 마커 표시 
  		 					map: map, // 기준이 되는 지도 
  		 					draggable: false, // 드래그 못하게 만들기 
  		 		          	animation: google.maps.Animation.DROP, // 마커 표시 애니메이션 효과 삽입 
  		 					position: uluru, // 숙소 좌표
  		 					
  		 			});
  		 	var infowindow = new google.maps.InfoWindow({
  	  		    content: "${item.room_title}" // 클릭시 보이는 Text박스 숙소 제목 보임 
  	  		  });
  		 	 
  		 	google.maps.event.addListener(marker,'click', (function(marker,infowindow){ // 클릭 이벤트 추가 
  	  		    return function() {
  	  		        infowindow.open(map,marker);// Text박스 숙소 제목 보임 
  	  		    };
  	  		})(marker,infowindow)); 
  		 	 
  		 </c:forEach>
  		 
		}
	</script>
</body>
</html>