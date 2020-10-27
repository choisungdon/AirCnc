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
	
	if(element.className == 'fa-heart')
		return false;
			
	var url = "/search/searchDetail?i_host="+i_host+"&chin="+chin+"&chout="+chout+"&qty="+qty+"&addr="+s_addr.value;
	var win = window.open(url, '_blank');
  	win.focus();
}
function goFilter(){
	var form = document.querySelector('#ffom');
	for (var pair of formData.entries()) {
  	 console.log(pair[0] + ': ' + pair[1]);
	}
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
// 주소 검색 
function goAddr(){
	axios.get('/index/search', {
    params: {
      s_addr: s_addr.value
    }
  })
  .then(function (res) {
	//console.log(res);
	res.data.result.forEach(function(element, index, array){
    //console.log(`${element.addr}`);
		
	});

  })

}
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
	var popup1		= document.querySelector(".popup1");
	var popup2		= document.querySelector(".popup2");
	var ctButton 	= document.getElementById("ctButton"); // 목록 만들기 버튼 
	var sLikeButton = document.getElementById("sLikeButton"); // 새로 만들기 번튼 
	var likUser 	= likeTag.nextElementSibling; // 좋아요 상태 값 태그 
	var i_host		= likUser.nextElementSibling; // 숙소 pk
	var titleTag	= popup1.querySelectorAll(".like_list");
	var title 		= document.getElementById("list_title");// 저장 목록 title
	var afList 		= document.getElementById("afList");// hr 태그 
	
	
	if(likUser.value == 0){ // diLike 상태 
		popup1.style.display='block';
		
		// 기존 목록에 저장 이벤트 추가
		titleTag.forEach(function(element){
			element.onclick = function() { llSave(element.nextElementSibling.value,i_host.value,popup1,likeTag,likUser) };
		});
		
		// 목록 만들기 클릭시 
		ctButton.addEventListener('click', function(event){
        	//alert('Hello world, '+event.target.value);
			popup1.style.display = 'none';
			popup2.style.display = 'block';
    	});
		// 새로 만들기 
		sLikeButton.addEventListener('click', function(event){
        	//alert('Hello world, '+event.target.value);
			if(title.value == ''){
				alert("제목을 설정하세요.");
				title.focus();
				return false;
			}
			axios.get('/user/likelist', {
				params: {
					i_host	: i_host.value,
					title 	: title.value
				}
			 })
			  .then(function (res) {
			    console.log(res.data.result);
				if(res.data.result == 0){
					alert("DB 오류");
					return false;
				}else{
					popup2.style.display='none';
					likeTag.style.color = 'red';
					likUser.value = 1;
					// 저장 목록 태그 생성 
					var div = document.createElement("div");
					div.setAttribute("class","like_list")
					div.innerHTML = title.value;
					var input = document.createElement("input");
					input.setAttribute("type","hidden");
					input.setAttribute("id","i_list");
					input.setAttribute("value",res.data.result);
					afList.after(input);
					afList.after(div);
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
					likeTag.style.color = 'gray';
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
			i_host	: i_host,
			i_list	: i_list
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







	