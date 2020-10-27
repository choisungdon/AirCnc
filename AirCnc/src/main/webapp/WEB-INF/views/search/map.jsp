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
			uluru = {lat: ${item.c_lat} , lng: ${item.c_lng} };
		</c:forEach>
		// 지도 생성 
		var map = new google.maps.Map(
	  		      document.getElementById('map'), {zoom: 7, center: uluru});
   	 	
  		// 마커 표시 (forEach문 )
  		 <c:forEach items="${data}" var="item">
  		 	uluru 	= {lat: ${item.s_lat}, lng: ${item.s_lng} };
  		 	marker 	= new google.maps.Marker({
  		 					map: map,
  		 					draggable: true,
  		 		          	animation: google.maps.Animation.DROP,
  		 					position: uluru, 
  		 					
  		 			});
  		 	var infowindow = new google.maps.InfoWindow({
  	  		    content: "${item.room_title}"
  	  		  });
  		 	 
  		 	google.maps.event.addListener(marker,'click', (function(marker,infowindow){ 
  	  		    return function() {
  	  		        infowindow.open(map,marker);
  	  		    };
  	  		})(marker,infowindow));
  		 	 
  		 </c:forEach>
  		 
		}
	</script>
</body>
</html>