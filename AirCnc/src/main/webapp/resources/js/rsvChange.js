function viewMenu(){
    var drop_menu = document.querySelector('.drop_menu');

    if(drop_menu.style.display != 'block'){
        drop_menu.style.display= 'block';
    }else{
        drop_menu.style.display = 'none';
    }
}

function countUp(d) {
    d.value = parseInt(d.value) + 1;
	changeText();
}

function countDw(d) {
    d.value = parseInt(d.value) - 1;
    if(d.value < 0) {
        d.value = 0;
    }
	changeText();
}

// 달력 
$(function() {
 //체크인 눌렀을때  달력 출력 
  $('input[id="chin"]').daterangepicker({
      autoUpdateInput: false,
      locale: {
          cancelLabel: 'Clear'
      }
  });
// apply 누른 순간 input value에 날짜 값 삽입 
  $('input[id="chin"]').on('apply.daterangepicker', function(ev, picker) {
      $(this).val(picker.startDate.format('YYYY-MM-DD'));
	  $('input[id="chout"]').val(picker.endDate.format('YYYY-MM-DD'));
	  changeText();
  });
//  Clear 눌렀을때 삽입된 값 비우기 
  $('input[id="chin"]').on('cancel.daterangepicker', function(ev, picker) {
      $(this).val('');
	  $('input[id="chout"]').val('');
	  changeText();
  });
 //체크아웃 눌렀을때  달력 출력 
  $('input[id="chout"]').daterangepicker({
      autoUpdateInput: false,
      locale: {
          cancelLabel: 'Clear'
      }
  });
// apply 누른 순간 input value에 날짜 값 삽입 
  $('input[id="chout"]').on('apply.daterangepicker', function(ev, picker) {
      $(this).val(picker.endDate.format('YYYY-MM-DD')); 
	  $('input[id="chin"]').val(picker.startDate.format('YYYY-MM-DD'));
	  changeText();
  });
//  Clear 눌렀을때 삽입된 값 비우기 
  $('input[id="chout"]').on('cancel.daterangepicker', function(ev, picker) {
      $(this).val('');
	  $('input[id="chin"]').val('');
	  changeText();
  });

});

// 요금 및 날짜 태그 변경 
function changeText(){
	//console.log(gest_qty.value);
	//console.log(chin.value);
	//console.log(chout.value);
	
	// 명수 변경 
	var qty = document.querySelector(".gest_qty");
	qty.innerHTML = '게스트 '+gest_qty.value;
	
	// 날짜 변경 
	var day = document.querySelector(".day");
	var date_text = '';
	var dateArray = chin.value.split("-");
	date_text = dateArray[0]+'년 '+dateArray[1]+'월 '+dateArray[2]+'일 → ';
	dateArray = chout.value.split("-");
	date_text += dateArray[0]+'년 '+dateArray[1]+'월 '+dateArray[2]+'일';
	
	if(dateArray[0] == ''){
		day.innerHTML = '날짜를 설정 하세요.';
	}else{
		day.innerHTML = date_text;
	}
	
	
	// 요금 text 변경
	var pqy_date = document.querySelector(".pqy_date");
	var pqy_date_fee = document.querySelector(".pqy_date_fee");
	var pqy_qty = document.querySelector(".pqy_qty");
	var pqy_qty_fee = document.querySelector(".pqy_qty_fee");
	var last_fee = document.querySelector(".last_fee");
	
	dateArray = chin.value.split("-");  
	var stDate = new Date(dateArray[0],parseInt(dateArray[1])-1,parseInt(dateArray[2]) ) ;
	dateArray	=   chout.value.split("-");
	var endDate = new Date(dateArray[0],parseInt(dateArray[1])-1,parseInt(dateArray[2]) ) ;
 
    var btMs = endDate.getTime() - stDate.getTime() ;

    var btDay = btMs / (1000*60*60*24) ; // 일수 (박)
	
	if(isNaN(parseInt(btDay))){
		btDay = 0;
	}
	date.value = btDay;
	
	var qty = parseInt(gest_qty.value); // 인원
	var b_fee = fee.value; // 기본 요금
	
	// 일수 결과 삽입 
	pqy_date.innerHTML = '￦'+b_fee.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")+'X'+btDay+'박';
	pqy_date_fee.innerHTML = '￦'+(b_fee*btDay).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	
	// 명수 결과 삽입 
 	pqy_qty.innerHTML = '￦'+(b_fee*btDay).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")+'X'+qty+'명';
	pqy_qty_fee.innerHTML = '￦'+(b_fee*btDay*qty).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	
	// 총 합계 삽입 
	last_fee.innerHTML = '￦'+(b_fee*btDay*qty).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	
	total_fee.value = b_fee*btDay*qty;
	
	goComfirm(); //숙박 인원 및 날짜 변경시 가능 여부 검사
}

// 숙박 인원 및 날짜 변경시 가능 여부 검사 
function goComfirm(){
	var submit 	= document.querySelector('.ch_btn');
	var erro	= document.querySelector('.erro');
	
	if(date.value == 0){
		erro.innerHTML = '날짜를 입력하세요.';
		submit.disabled='true';
		return false;
	}
	
	if(gest_qty.value < 1){
		erro.innerHTML = '인원을  입력하세요.';
		submit.disabled='true';
		return false
	}
	
	axios.get('/reservation/goComfirm', {
    params: {
		i_host	:	i_host.value,
		i_reser : 	i_reser.value,
		chin	:	chin.value,
		chout	:	chout.value,
		date	:	date.value,
		qty		:	gest_qty.value
    }
  })
  .then(function (res) {
	console.log(res.data.result);
    if(res.data.result != 'o'){
		erro.innerHTML = res.data.result;
		submit.disabled='true';
	
	}else{
		erro.innerHTML = '';
		submit.disabled='';
		
	}
  })
}

function checkData(){
	var val // 조건문 쓰일 변수  0,1
	
	axios.post('/reservation/checkData', {
    i_host	:	i_host.value,
	i_reser : 	i_reser.value,
	chin	:	chin.value,
	chout	:	chout.value,
	qty		:	gest_qty.value
  })
  .then(function (res) {
	if(res.data.result > 0){
		var frm = document.querySelector('#frm');
		frm.submit();
	}else{
		alert('변경된 내용이 없습니다.');
	}
	 
  })
  .catch(function (error) {
    
  });

	return false;
}

function cancel(){
	window.history.back();
}
