function viewMenu(){
    var drop_menu = document.querySelector('.drop_menu');

    if(drop_menu.style.display != 'block'){
        drop_menu.style.display= 'block';
    }else{
        drop_menu.style.display = 'none';
    }
}

window.onload = goComfirm();


// up down button
function countUp(qty){
    qty.value = parseInt(qty.value) + 1;
}

function countDw(qty){
    qty.value = parseInt(qty.value) - 1;
    if(qty.value < 0) {
        qty.value = 0;
    }
}
//

// 상단 후기 버튼 
function focusCment(){
    var comment_button = document.querySelector(".ctnt_comment");
    comment_button.scrollIntoView();
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


// 검색
function goSearch(){
	var addr	= document.getElementById("s_addr").value;
	var chin	= document.getElementById("searchin").value;
	var chout	= document.getElementById("searchout").value;
	var qty 	= document.getElementById('qty').value;
	
	// 검색 옵션 없을시 return 
	if(addr == '') return alert('위치를 입력하시오.');
	if(chin == '') return alert('날짜를 추가하시오.');
	if(chout == '') return alert('날짜를 추가하시오.');
	if(qty < 1)  return alert('인원수를 추가하시오.');
	
	location.href = "/search/searchMain?addr="+addr+"&chin="+chin+"&chout="+chout+"&qty="+qty;
}

// slidebox
var slideIndex = 1;
showSlides(slideIndex);

function plusSlides(n) {
  showSlides(slideIndex += n);
}

function currentSlide(n) {
  showSlides(slideIndex = n);
}

function showSlides(n) {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("dot");
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
//

//**************conven_popup***********************************//

function close_modal(ele){
    var parent = ele.parentNode.parentNode;
	 parent.style.display='none';

}

function conven_popup(){
    var conven_popup = document.querySelector('.conven_popup');
    if(conven_popup.style.display != 'block'){
        conven_popup.style.display= 'block';
    }else{
        conven_popup.style.display = 'none';
    }
}

function comment_popup(){
    var comment_popup = document.querySelector('.comment_popup');
    if(comment_popup.style.display != 'block'){
        comment_popup.style.display= 'block';
    }else{
        comment_popup.style.display = 'none';
    }
}

function rule_popup(){
	var rule_popup = document.querySelector('.rule_popup');
	if(rule_popup.style.display != 'block'){
	    rule_popup.style.display= 'block';
	}else{
	    rule_popup.style.display = 'none';
	}
	
}
// 좋아요 버튼 
function like(likeTag){
	likeTag 		= likeTag.firstChild.nextElementSibling;
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
		    element.addEventListener('click', SaveLList);
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

function SaveLList(){
	var i_list = this.nextElementSibling.value;
	var popup1		= document.querySelector(".popup1");
	var likeTag		= document.querySelector(".fa-heart");
	
	axios.get('/user/llSave', {
		params: {
			i_host	: i_host.value,
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
					like_user.value = 1// 좋아요 활성화 
				}
		 })
	
}


// class = payment 예약 날짜 변경시 
$(function() {
 //체크인 눌렀을때  달력 출력 

  $('#r_chin').daterangepicker({
      autoUpdateInput: false,
      locale: {
          cancelLabel: 'Clear'
      }
  });



// apply 누른 순간 input value에 날짜 값 삽입 
  $('#r_chin').on('apply.daterangepicker', function(ev, picker) {
      	$(this).html(picker.startDate.format('YYYY-MM-DD'));
		$('input[name="chin"]').val(picker.startDate.format('YYYY-MM-DD'));
		
	  	$('#r_chout').html(picker.endDate.format('YYYY-MM-DD'));
		$('input[name="chout"]').val(picker.endDate.format('YYYY-MM-DD'));
		changeFee();
		goComfirm();
  });
//  Clear 눌렀을때 삽입된 값 비우기 
  $('#r_chin').on('cancel.daterangepicker', function(ev, picker) {
      	$(this).html('');
		$('input[name="chin"]').val('');
		
	  	$('#r_chout').html('');
		$('input[name="chout"]').val('');
		changeFee();
		goComfirm();
  });

$('#r_chout').daterangepicker({
      autoUpdateInput: false,
      locale: {
          cancelLabel: 'Clear'
      }
  });
// apply 누른 순간 input value에 날짜 값 삽입 
  $('#r_chout').on('apply.daterangepicker', function(ev, picker) {
      	$(this).html(picker.endDate.format('YYYY-MM-DD')); 
		$('input[name="chout"]').val(picker.endDate.format('YYYY-MM-DD'));	
		  
		$('#r_chin').html(picker.startDate.format('YYYY-MM-DD'));
		$('input[name="chin"]').val(picker.startDate.format('YYYY-MM-DD'));	
		changeFee();
		goComfirm();
	});
//  Clear 눌렀을때 삽입된 값 비우기 
  $('#r_chout').on('cancel.daterangepicker', function(ev, picker) {
      	$(this).html('');
	  	$('input[name="chout"]').val('');	
	  	$('#r_chin').html('');
		$('input[name="chin"]').val('');	
		changeFee();
		goComfirm();
  });

});

// 예약 금 변경 
function changeFee(){
	// 체크인 날짜
	var dateArray = r_chin.innerHTML.split("-");  
	var stDate = new Date(dateArray[0],parseInt(dateArray[1])-1,parseInt(dateArray[2]) ) ;
	// 체크아웃 날짜 
	dateArray	=   r_chout.innerHTML.split("-");
	var endDate = new Date(dateArray[0],parseInt(dateArray[1])-1,parseInt(dateArray[2]) ) ;
 
    var btMs = endDate.getTime() - stDate.getTime() ;

    var btDay = btMs / (1000*60*60*24) ; // 일수($박)
	date.value = btDay;
	var qty = parseInt(r_qty.innerHTML); // 인원
	var b_fee = fee.value; // 기본 요금
	
	// 일수 결과 삽입 
	pqy_date.innerHTML = '￦'+b_fee.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")+'X'+btDay+'박';
	pqy_date_fee.innerHTML = '￦'+(b_fee*btDay).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	
	// 명수 결과 삽입 
 	pqy_qty.innerHTML = '￦'+(b_fee*btDay).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")+'X'+qty+'명';
	pqy_qty_fee.innerHTML = '￦'+(b_fee*btDay*qty).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	
	// 총 합계 삽입 
	total_fee.innerHTML = '￦'+(b_fee*btDay*qty).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	
}



// 예약  인원 UP Dwon 함수  
function qtyUp(qty){
    document.getElementsByName("qty")[0].value = parseInt(qty.innerHTML) + 1;
	qty.innerHTML = parseInt(qty.innerHTML) + 1;
	changeFee();
	goComfirm();
}

function qtyDW(qty){
	
   	document.getElementsByName("qty")[0].value = parseInt(qty.innerHTML) - 1;
	qty.innerHTML = parseInt(qty.innerHTML) - 1;
    if(parseInt(qty.innerHTML) < 0) {
        document.getElementsByName("qty")[0].value = 0;
		qty.innerHTML = 0;
    }
	changeFee();
	goComfirm();
}



// 숙박 인원 및 날짜 변경시 가능 여부 함수 
function goComfirm(){
	
	var submit 	= document.querySelector('#sub'); // 예약하기 버튼
	var erro	= document.querySelector('.erro'); // 에러 태그
	var chin	= $('input[name="chin"]').val(); // 체크인 날짜
	var chout	= $('input[name="chout"]').val(); // 체크아웃 날짜
	var date 	= $('input[name="date"]').val(); // 일수($박)
	var qty 	= $('input[name="qty"]').val(); // 인원
	
	if(chin == '' || chout == ''){
		erro.innerHTML = '날짜를 입력하세요.'; // 오류 메시지 
		
		submit.disabled='true';// 예약 버튼 비활성화
		return false;
	}else if(qty <= 0){
		erro.innerHTML = '인원수를 입력하세요.'; // 오류 메시지 
		submit.disabled='true';// 예약 버튼 비활성화
		return false;
	}
	
	axios.get('/search/goComfirm', {
    params: {
		i_host	:	i_host.value,// 숙소(PK)
		chin	:	chin,
		chout	:	chout,
		date	:	date,
		qty		:	qty
    }
  })
  .then(function (res) {
	//console.log(res.data.result);
    if(res.data.result != 'o'){
		erro.innerHTML = res.data.result; // 오류 메시지 
		submit.disabled='true';// 예약 버튼 비활성화
	
	}else{
		erro.innerHTML = ''; // 오류 메시지 지우기 
		submit.disabled=''; // 예약 버튼 활성화
		
	}
  })
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





