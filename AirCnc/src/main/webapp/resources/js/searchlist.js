
// 메시지 화면 이동
function goMsg() {
	location.href = '/message/message';
}
// 여행 
function goTrb(){
	location.href="/trip/trip";
}
// 메뉴-저장 목록으로 이동
function goWish() {
	location.href = '/wishlists';
}
// 숙소 관리 
function goHost(){
	location.href='/hostManage/manage';
}
// 계정 
function goUser(){
	location.href="/user/userSetting";
}
// 로그아웃 
function goLogOut(){
	location.href="/logOut";
}

// drop down menu
function viewMenu(){
    var drop_menu = document.querySelector('.drop_menu');

    if(drop_menu.style.display != 'block'){
        drop_menu.style.display= 'block';
    }else{
        drop_menu.style.display = 'none';
    }
}
// 검색
function goSearch(){
	var addr	= document.getElementById("s_addr").value;
	var chin	= document.getElementById("searchin").value;
	var chout	= document.getElementById("searchout").value;
	var qty 	= document.getElementById('qty').value;
	location.href = "/search/searchMain?addr="+addr+"&chin="+chin+"&chout="+chout+"&qty="+qty;
}

// filter 검색 
function gosubmit(){
	var frm = document.frmFiter;
	frm.addr	=	document.getElementById("s_addr").value;
	frm.qty		= 	document.getElementById('qty').value;
	frm.chin	=	document.getElementById("searchin").value;	
	frm.chout	=	document.getElementById("searchout").value;
	frm.submit();
}


// Detaile  화면 
function goDetail(i_host,chin,chout,qty,element){
	var url = "/search/searchDetail?i_host="+i_host+"&chin="+chin+"&chout="+chout+"&qty="+qty+"&addr="+s_addr.value;
	var win = window.open(url, '_blank');
  	win.focus();
}


// 초기 검색 인원 증감함수
function countUp(d) {
	d.value = parseInt(d.value) + 1;
}

function countDw(d) {
    d.value = parseInt(d.value) - 1;
    if(d.value < 0) {
        d.value = 0;
    }
}

// 달력 
$(function() {
 //체크인 눌렀을때  달력 출력 
  $('input[id="searchin"]').daterangepicker({
      autoUpdateInput: false,
      locale: {
          cancelLabel: 'Clear'
      }
  });
// apply 누른 순간 input value에 날짜 값 삽입 
  $('input[id="searchin"]').on('apply.daterangepicker', function(ev, picker) {
      $(this).val(picker.startDate.format('YYYY-MM-DD'));
	  $('input[id="searchout"]').val(picker.endDate.format('YYYY-MM-DD'));
  });
//  Clear 눌렀을때 삽입된 값 비우기 
  $('input[id="searchin"]').on('cancel.daterangepicker', function(ev, picker) {
      $(this).val('');
	  $('input[id="searchout"]').val('');
  });
 //체크아웃 눌렀을때  달력 출력 
  $('input[id="searchout"]').daterangepicker({
      autoUpdateInput: false,
      locale: {
          cancelLabel: 'Clear'
      }
  });
// apply 누른 순간 input value에 날짜 값 삽입 
  $('input[id="searchout"]').on('apply.daterangepicker', function(ev, picker) {
      $(this).val(picker.endDate.format('YYYY-MM-DD')); 
	  $('input[id="searchin"]').val(picker.startDate.format('YYYY-MM-DD'));
  });
//  Clear 눌렀을때 삽입된 값 비우기 
  $('input[id="searchout"]').on('cancel.daterangepicker', function(ev, picker) {
      $(this).val('');
	  $('input[id="searchin"]').val('');
  });

});

var slideIndex = 1;
	
// 이미지 화살표 버튼 클릭시 
function plusSlides(n,sIndex) {
  showSlides(slideIndex += n,sIndex);
}
// class dot 클릭시 
function currentSlide(n,sIndex) {
  showSlides(slideIndex = n,sIndex);
}

// 이미지 활성화
function showSlides(n,sIndex) {
  var i;
  // calss -> dot mySlides 의 부모 태그 정보 가지고 오기 
  var sContainer = document.querySelector('#s_'+sIndex);
  var dotCont = document.querySelector('#d_'+sIndex);
  // id ="s_${item.i_host}" , id="d_${item.i_host}" 밑에 있는  class 요소 다 가지고 오기 
  var slides =  sContainer.getElementsByClassName("mySlides");
  var dots = dotCont.getElementsByClassName("dot");
  // 사진 표기 
  if (n > slides.length) {slideIndex = 1}    
  if (n < 1) {slideIndex = slides.length}
  for (i = 0; i < slides.length; i++) {
      slides[i].style.display = "none";  
  }
  for (i = 0; i < dots.length; i++) {
      dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " active";
}

// layer popup  필터 
function filter(){
	var modal = document.getElementById('myModal');
	var fiter_type = document.getElementById("fiter_type");
	var filter_fee = document.getElementById("fiter_fee");
	modal.style.display = "block";
	fiter_type.style.display = "none";
	filter_fee.style.display = "none";
}

function filter_close(){
	var modal = document.getElementById('myModal');
	 modal.style.display = "none";
}
// 침대수 침실수 욕실수 갯수 증감 함수 
function searchUp(d) {
	d.value = parseInt(d.value) + 1;
}

function searchDw(d) {
    d.value = parseInt(d.value) - 1;
    if(d.value < 0) {
        d.value = 0;
    }
}
// 필터 검색 데이터 초기화 함수 
function fiter_del(){
	bed_qty.value	=0;
	b_room.value	=0;
	bth_room.value	=0;
	var pmCon = document.querySelector('#myModal');
	var mContainer = pmCon.getElementsByClassName('f_ch');
	for (i = 0; i < mContainer.length; i++) {
		mContainer[i].checked = "";
	}
}



// 요금 버튼 
function filter_fee(){
	var modal = document.getElementById('myModal');
	var fiter_type = document.getElementById("fiter_type");
	var filter_fee = document.getElementById("fiter_fee");
	modal.style.display = "none";
	fiter_type.style.display = "none";
	filter_fee.style.display = "block";
	
}
//요금 닫기 
function fee_close(){
	var filter_fee = document.getElementById("fiter_fee");
	filter_fee.style.display = "none";
}

function fevalue(v){
	var viewVal = document.getElementById('fee_value');
	viewVal.innerHTML = '￦'+v.value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}
// 요금 검색 데이터 초기화 
function fee_del(){
	var viewVal = document.getElementById('fee_value');
	var feeCon = document.querySelector('#fiter_fee');
	var feeContainer = document.getElementsByClassName('f_fe');
	feeContainer[0].value = feeContainer[0].max;
	viewVal.innerHTML = '￦'+feeContainer[0].max.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

// 숙소 유형 버튼 
function filter_type(){
	var modal = document.getElementById('myModal');
	var fiter_type = document.getElementById("fiter_type");
	var filter_fee = document.getElementById("fiter_fee");
	modal.style.display = "none";
	filter_fee.style.display = "none";
	fiter_type.style.display = "block";
}
// 숙소 유형 닫기 
function type_close(){
	var fiter_type = document.getElementById("fiter_type");
	fiter_type.style.display = "none";
}
// 숙소 유형 검색 데이터 초기화 
function type_del(){
	var ftpCon = document.querySelector('#fiter_type');
	var ftpContainer = ftpCon.getElementsByClassName('f_tp');
	for (i = 0; i < ftpContainer.length; i++) {
		ftpContainer[i].checked = "";
	}
}
// layer popup (like)
// 좋아요 버튼 
 function like(likeTag){
	var popup1		= document.querySelector(".popup1"); // 좋아요 목록 Popup
	var popup2		= document.querySelector(".popup2"); // 새로 만들기 Popup
	var ctButton 	= document.getElementById("ctButton"); // 목록 만들기 버튼 
	var sLikeButton = document.getElementById("sLikeButton"); // 새로 만들기 번튼 
	var likUser 	= likeTag.nextElementSibling; // 좋아요 상태 값 태그 
	var i_host		= likUser.nextElementSibling; // 숙소 pk
	var titleTag	= popup1.querySelectorAll(".like_list");// 좋아요 목록 태그 
	var title 		= document.getElementById("list_title");// 저장 목록 title input Text 태그 
	var afList 		= document.getElementById("afList");// 좋아요 목록 위 hr 태그 
	
	
	if(likUser.value == 0){ // diLike 상태 
		popup1.style.display='block';
		
		// 기존 목록에 저장 이벤트 추가
		titleTag.forEach(function(element){
			element.onclick = function() { llSave(element.nextElementSibling.value,i_host.value,popup1,likeTag,likUser) };
		});
		
		// 목록 만들기 클릭시 
		ctButton.addEventListener('click', function(event){
        	//alert('Hello world, '+event.target.value);
			popup1.style.display = 'none'; // 좋아요 목록 Popup
			popup2.style.display = 'block';// 새로 만들기 Popup 
    	});

		// 목록 새로 만들기 
		sLikeButton.addEventListener('click', function(event){
        	//alert('Hello world, '+event.target.value);
			if(title.value == ''){ // 제목 없으면 return 
				alert("제목을 설정하세요.");
				title.focus();
				return false;
			}
			axios.get('/user/likelist', {
				params: {
					i_host	: i_host.value, // 해당 숙소 pk
					title 	: title.value // 좋아요 제목 
				}
			 })
			  .then(function (res) {
			    console.log(res.data.result);
				if(res.data.result == 0){ // 저장 안됨 
					alert("DB 오류");
					return false;
				}else{ //  저장 성공 (res.data.result -> 좋아요 목록 PK 가지고 옵니다.)
					popup2.style.display='none'; // 새로 만들기 popup none
					likeTag.style.color = 'red'; // 해당 숙소 하트 이모지 색 지정 
					likUser.value = 1;// 좋아요 상태 값 
					// 저장 목록 태그 생성 
					var div = document.createElement("div"); // 좋아요 목록 Popup 내용 추가 태그 생성 
					div.setAttribute("class","like_list")
					div.innerHTML = title.value; // 좋아요 목록 제목 삽입 
					var input = document.createElement("input"); // 좋아요 클릭 이벤트때 i_list(pk) 사용 합니다. 
					input.setAttribute("type","hidden");
					input.setAttribute("id","i_list"); 
					input.setAttribute("value",res.data.result); 
					afList.after(input);
					afList.after(div); //좋아요 목록 Popup 내용 추가 
				}
			  })
    	});
		
	}else{ // dislike로 변경  
		axios.get('/user/disLike', {
			params: {
				i_host	: i_host.value
			}
		  })
		  .then(function (res) {
		    console.log(res.data.result);
				if(res == 0){
					alert("DB 오류");
				}else{
					likeTag.style.color = 'gray'; // 이모지 색깔 변경 
					likUser.value = 0// 좋아요 비활성화 
				}
		  })
	}
	
	return false;
  }

// 기존 좋아요 목록에 추가 
function llSave(i_list,i_host,popup1,likeTag,likUser){
	axios.get('/user/llSave', {
		params: {
			i_host	: i_host, // 해당 숙소 pk
			i_list	: i_list // 좋아용 목록 pk
		}
	 })
	 .then(function (res) {
		    console.log(res.data.result);
				if(res == 0){
					alert("DB 오류");
				}else{
					popup1.style.display = 'none';
					likeTag.style.color = 'red';
					likUser.value = 1// 좋아요 활성화 
				}
			
		})
			
}

// 닫기 
  function popClose(ele){
    var parent = ele.parentNode.parentNode;
    parent.style.display='none';
  }


//연관 주소 list 뽑기   
function goAddr(){
	// 서브 주소 list 태그  
	var drop_addr = document.querySelector('.drop_addr');
	
	drop_addr.innerHTML = '';
	
	// 검색 내용이 없으면 list 창 숨기기 있으면 나타내기 
	if(s_addr.value == ''){ 
		drop_addr.style.display='none';
		return false;
	}else{
		drop_addr.style.display='block';
	}
	 // 연관 주소  출력 
	axios.get('/index/search', {
    params: {
      s_addr: s_addr.value
    }
  })
  .then(function (res) {
	if(res.data.result.length < 1 ){
		drop_addr.style.display = 'none';
	}else{
		res.data.result.forEach(function(element){
			// list 태그 안에 들어갈 태그 
			var div  = document.createElement('div');
			div.setAttribute( 'class', 'addr_item' );
			
			// div 태그 안에 들어갈 태그 (이모지,주소 내용)
			var i = document.createElement('i');
			i.setAttribute( 'class', 'fas fa-map-marker-alt' );
			
			var span = document.createElement('span');
			span.innerHTML = element.hidden_addr;
			
			div.onclick =  function() { insAddr(element.addr)};
			
			// 태그 삽입 
			div.appendChild(i);
			div.appendChild(span);
			
    		drop_addr.appendChild(div);
		});
	}
	

  })

}

// 주소 검색창에 삽입  삽입 함수  
function insAddr(ele){
	s_addr.value = ele;
	searchin.focus();
}


// dropDown menu , 연관 주소 list 아닌 태그 클릭시 숨기기 
window.onclick = function(event) {
	var drop_menu = document.querySelector('.drop_menu');
	var drop_addr = document.querySelector('.drop_addr');
	//dropDown 메뉴
	if(event.target.className != 'top_menu' &&  event.target.className != 'hamMenu' && event.target.className != 'my_profile'){
		drop_menu.style.display = 'none';
	}
	
	//연관 주소 list
	drop_addr.style.display='none';
}






	