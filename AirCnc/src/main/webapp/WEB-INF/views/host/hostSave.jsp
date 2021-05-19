<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="/resources/js/hostSave.js"></script>
<link rel="stylesheet" href="/resources/css/hostSave.css">
<script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>
<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBA5JUTsSB7h9_YaHu00RdgVxJAssRbO0M"
  type="text/javascript"></script>
<script src="https://kit.fontawesome.com/ea36f2192f.js" crossorigin="anonymous"></script>


<title>HostSave</title>
</head>
<body>
    <header>
        <span class="log_img">
            <a href="/" class="logo">
                <i class="fab fa-airbnb fa-2x"></i>
            </a>
            <span>숙소 등록 1단계</span>
        </span>
        
        <a href="/" class="his_back">  
            나가기 
        </a>
    </header>
    <div class="ctnt_step">
        <span class="step01"></span>
        <span class="step02"></span>
        <span class="step03"></span>
        <span class="step04"></span>
        <span class="step05"></span>
        <span class="step06"></span>
        <span class="step07"></span>
        <span class="step08"></span>
        <span class="step09"></span>
        <span class="step10"></span>
    </div>
    <div class="container">
        <div class="ctnt_host">
            <section class="host_ctnt_main">
                <div class="host_title">
                    <div class="title_text">${loginUser.nm} 님 안녕하세요! 숙소 등록을 시작해볼까요?</div>
                    <div class="title_texts">
                        1단계 등록하시려는 숙소의 유형을 및 숙소 위치를 작성하세요.
                    </div>
                </div>
                <form class="hostSave" action="/host/hostSaveOne" method="post">
                    <input type="hidden" name="i_user" value="${loginUser.i_user}">
                    <c:if test="${vo.i_host != null}">
                    <input type="hidden" id="i_host" name="i_host" value="${vo.i_host}">
                    </c:if>

                    <div class="title01">
                        	국가/지역
                    </div>
                    <input type="text" class="country" name="country" value="${vo.country}"  onkeydown="c_GetLatLng(this)" onchange="c_GetLatLng(this)" placeholder="국가" >
                    <input type="hidden" id="c_lat" name="c_lat" value="${vo.c_lat}">
                    <input type="hidden" id="c_lng" name="c_lng" value="${vo.c_lng}">
                    
                    <div class="title02">
                        	상세 주소
                    </div>
                    <input type="text" name="addr" value="${vo.addr}" onkeydown="s_GetLatLng(this)" onchange="s_GetLatLng(this)" placeholder="상세 주소 : 서울특별시 강남구 언주로 406 301동 505호">
                    <input type="hidden" id="s_lat" name="s_lat" value="${vo.s_lat}">
                    <input type="hidden" id="s_lng" name="s_lng" value="${vo.s_lng}">
                   
                    <div class="r_vastion">
                        <div class="title03">
                            	최대 숙박 인원
                        </div>

                        <div class="button01">
                            <button type="button"	onclick="countDwr_vation(document.getElementById('r_vastion'))">-</button>
                            	<input 	id="r_vastion" 	name="r_vastion"		type="number"	min="1" max="16"	value="${vo.r_vastion}"  readonly>
                            <button type="button" 	onclick="countUpr_vation(document.getElementById('r_vastion'))">+</button>
                        </div>
                    </div>

                    <div class="b_room">
                        <div class="title04">
                            	게스트가 사용할 수 있는 침실은 몇 개인가요?
                        </div>
                        <select name="b_room">
                            <c:forEach var="i" begin="1" end="50">
								<option value="${i}" ${vo.b_room == i ? 'selected="selected"' : '' }>침실 ${i}개</option>
							</c:forEach>
                        </select>
                    </div>

                    <div class="bed_qty">
                        <div class="title05">
                            	게스트가 사용할 수 있는 침대는 몇 개인가요?
                        </div>

                        <div class="bed_qty_ctnt">
                            <div class="title06">
                                	침대
                            </div>
                            <div class="button02">
                                <button type="button"	onclick="countUp02(document.getElementById('bed_qty'))">-</button>
                                    <input 	id="bed_qty" 	name="bed_qty"		type="number"	min="1" 	value="${vo.bed_qty != null ? vo.bed_qty : 1}"  readonly>
                                <button type="button" 	onclick="countDw02(document.getElementById('bed_qty'))">+</button>
                            </div>
                        </div>
                       
                    </div>

                    <div class="b_room">
                        <div class="title07">
                            	침대 유형
                        </div>
                        <select name="bed_type">
                            <option value="double" ${vo.bed_type eq 'double' ? 'selected="selected"' : '' }>더블</option>
				 			<option value="queen" ${vo.bed_type eq 'queen' ? 'selected="selected"' : '' }>퀸</option>
				 			<option value="single" ${vo.bed_type eq 'single' ? 'selected="selected"' : '' }>싱글</option>
                       </select>
                    </div>

                    <div class="r_vastion">
                        <div class="title03">
                            	욕실수 
                        </div>

                        <div class="button02">
                            <button type="button"	onclick="countUp02(document.getElementById('bth_room'))">-</button>
                            	<input 	id="bth_room" 	name="bth_room"		type="number"	min="1" 	value="${vo.bth_room != null ? vo.bth_room : 1}"  readonly>
                            <button type="button" 	onclick="countDw02(document.getElementById('bth_room'))">+</button>
                        </div>
                    </div>

                    <div class="title01">
                        	숙소 제목
                    </div>

                    <input type="text" name="room_title" value="${vo.room_title != null ? vo.room_title : '' }" placeholder="깔끔하고 편안한 원룸스튜디오" >
                    
                    <div class="b_room">
                        <div class="title07">
                           	 은행
                        </div>
                        <select name="acc_bank">
							<option value="국민은행" ${vo.acc_bank eq '국민은행' ? 'selected="selected"' : '' }>국민은행</option>
							<option value="농협" ${vo.acc_bank eq '농협' ? 'selected="selected"' : '' }>농협</option>
							<option value="신한은행" ${vo.acc_bank eq '신한은행' ? 'selected="selected"' : '' }>신한은행</option>
						</select>
                    </div>

                    <div class="title01">
                        	계좌
                    </div>
			        <input type="text" name="acc" value="${vo.acc}" placeholder="계좌">

                    <div class="title01">
                        	예금주
                    </div>

			        <input type="text" name="acc_owner" value="${vo.acc_owner != null ? vo.acc_owner : loginUser.nm}" placeholder="예금주">

                    <div class="nepre_tag">
                        <span class="previous"><i class="fas fa-chevron-left"></i> 뒤로</span>
                        <span class="next">다음</span>
                    </div>
                </form>
            </section>
        </div>
        <div class="ctnt_exp">
           
        </div>
    </div>
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
	// 주소 좌표 구하기 
	function s_GetLatLng(obj){
		//console.log(obj.value);
		// 주소
		addr =obj.value; 
		
		const geocoder = new google.maps.Geocoder();

    	const address = addr;
    	geocoder.geocode( //주소 좌표(위도 경도) 찾기 
    	  {
    	    address: address // 주소 좌표(위도 경도) 찾기 
    	  },
    	  (results, status) => { // results-> index 0 : 위도  index 1-> 경도
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
	// 나라 좌표 주하기 
	function c_GetLatLng(obj){
		
		addr =obj.value; // 나라이름 
		
		const geocoder = new google.maps.Geocoder();

    	const address = addr;
    	geocoder.geocode(
    	  {
    	    address: address
    	  },
    	  (results, status) => { // results-> index 0 : 위도  index 1-> 경도
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