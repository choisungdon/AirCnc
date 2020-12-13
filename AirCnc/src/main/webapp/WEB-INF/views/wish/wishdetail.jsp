<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<link rel="shortcut icon" href="/resources/img/pinklogo.ico">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://kit.fontawesome.com/ea36f2192f.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/resources/css/wishdetail.css">
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <title>Wishdetail</title>
</head>
<body>
    <container id="container">
        <header>
            <img id="logo" onclick="goIndex()" src="/resources/img/pinklogo.png">
            <div id="menubutton" onclick="myMenu()">
                <div><img id="ham" src="/resources/img/bars-solid.svg"></div>
                <div id="profile">
                    <img src="${loginUser.my_profile}">
                </div>
            </div>
            <div id="menuctnt">
                <c:if test="${loginUser.i_user != null}">
		         <li class="b" onclick="goMsg()">메시지</li>
		         <li class="b" onclick="goTrb()">여행</li>
		         <li class="b" onclick="goWish()">저장 목록</li>
		         <div class="line">――――――――――――――――</div>
		         <li class="b" onclick="goHost()">숙소 관리</li>
		         <li class="b" onclick="goUser()">계정</li>
		         <div class="line">――――――――――――――――</div>
		         <li class="b" onclick="goLogOut()">로그아웃</li>
		        </c:if>
            </div>
        </header>
        <div id="core">
            <div id="list">
                <div id="headicon">
                    <div class="hicon" onclick="goBack()"><i class="fas fa-arrow-left"></i></div>
                </div>
                <div id="tbox">
                    <div id="tbox1">${list.list_title}</div>
                </div>
                <div class="line">――――――――――――――――――――――――――――――――――――――――――――――――</div>
                <div id="ctntTitle">저장된 숙소 ${list.host_count}개</div>
                <c:forEach var="hinfo" items="${hinfo}">
                <div class="repeat">
                    <div class="flex"> 
                        <div class="imgbox">
                            <i class="fas fa-heart" onclick="like(this)" style="color:${(hinfo.like_user == 0) ? 'gray' : 'red' };"></i>
                            <input type="hidden" id="like_user" value="${item.like_user != 0 ? 1 : 0}">
                            <input type="hidden" id="i_host" value="${hinfo.i_host}"> 
                            <button class="left" onclick="nextSlides(-1,${hinfo.i_host})"><i class="fas fa-angle-left"></i></button>
                            <button class="right" onclick="nextSlides(1,${hinfo.i_host})"><i class="fas fa-angle-right"></i></button>
                            <div id="slideContents${hinfo.i_host}" class="slideContents">
                            <c:forEach var="roomImg" items="${hinfo.list}">
                            	  <img class="roomSlide"  src="${roomImg.room_poto}">
                            </c:forEach>
                            </div>
                        </div>
                    </div>
                    <li class="htype">${hinfo.b_room}·침대${hinfo.bed_qty}개</li>
                    <li class="room_title">${hinfo.room_title}</li>
                    <li class="fee">${hinfo.fee}/1박</li>
                    <li class="eval">${hinfo.avg} ${hinfo.count}</li>
                    <li class="reser" onclick="reser(${hinfo.i_host})">예약하기</li>
                </div>
                </c:forEach>
            </div>
            <div id="map"></div>
        </div>
    </container>
    
    <div class="popup1">
        <div class="likeLisPopup">
            <span class="close-modal" onclick="popClose(this)" >X</span>
            <span class="like_title">목록에 저장하기</span>
            <hr id="afList">
            <c:forEach items="${wList}" var="item">
            	<div class="like_list">${item.list_title}</div>
            	<input type="hidden" id="i_list" value="${item.i_list}">
            </c:forEach>
        <button type="button" id="ctButton">목록 만들기</button>
        </div>
    </div>

    <div class="popup2">
        <div class="likePopup">
            <span class="close-modal" onclick="popClose(this)">X</span>
            <span class="like_title">목록 이름 작성하기</span>
            <hr>
            <div>
            	<input type="text" id="list_title" value="" placeholder="이름 : ">
            </div>
            <hr>
            <button type="button" id="sLikeButton">새로 만들기</button>
    	</div>
    </div>
</body>
<script type="text/javascript" src="/resources/js/wishdetail.js"></script>
<script type="text/javascript">
	//화면 upload시 처음 이미지 표기 
	<c:forEach items="${hinfo}" var="item">
		// js파일 함수 호출 합니다. 
		showSlides(slideIndex,"${item.i_host}");
	</c:forEach>
	
	// googleMap
	function initMap() {
		var uluru; //좌표 넣을 변수 
		var marker;// 마커 넣을 변수 
		
		// 기준점이 되는 좌표 
		<c:forEach items="${hinfo}" var="item">
			uluru = {lat: ${item.c_lat} , lng: ${item.c_lng} };
		</c:forEach>
		// 지도 생성 
		var map = new google.maps.Map(document.getElementById('map'), {zoom: 7, center: uluru});
   	 	
  		// 마커 표시 (forEach문 )
  		 <c:forEach items="${hinfo}" var="item">
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
<script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBYMK6J-N5yiDhf8Z3Bipzewlm5bOzs_iU&callback=initMap&libraries=&v=weekly"
	defer></script>
</html>