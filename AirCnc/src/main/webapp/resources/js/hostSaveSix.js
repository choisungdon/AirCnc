function countUp(d) {
    d.value = parseInt(d.value) + 1;
    dateCheck(d);
}

function countDw(d) {
    d.value = parseInt(d.value) - 1;
    if(d.value < 1) {
        d.value = 1;
    }
    dateCheck(d);
}




// 다음 뒤로 버튼 이벤트 
window.onload = function(){
	var next		=	document.querySelector('.next'); // 다음 태그 
	var hostSave	=	document.querySelector('.hostSaveSix'); // form 태그 

    var ieast_day = document.getElementById("ieast_day") // 최소 숙박일수 태그 
    var max_day = document.getElementById("max_day") // 최대 숙박일수 태그

    next.onclick = function(){ // 다음 이벤트 
		hostSave.submit();
	}

    // 숙박 일수 입력 했을때 (최소)
    ieast_day.onkeyup = function(e){
        if(e.path[0].value != '' || e.key == 'Backspace'){ // 숫자일때만
            //console.log(e.path[0]);
            //console.log(e);
            dateCheck(e.path[0]);
        }
        
    }
    // 숙박 일수 입력 했을때 (최대)
    max_day.onkeyup = function(e){
        if(e.path[0].value != '' || e.key == 'Backspace'){
            //console.log(e.path[0]);
           //console.log(e);
           dateCheck(e.path[0]);
        }
    }

}

// 뒤로 가기 (6단계로 갑니다.)
function backPage(i_host,i_rule,i_dtr){
    location.href = "/host/hostSaveFive?i_host="+i_host+"&i_rule="+i_rule+"&i_dtr="+i_dtr;
}


// 숙박 가능 일수 체크 
function dateCheck(element){
   

    var ieast_day = document.getElementById("ieast_day"); // 최소 숙박일수 태그 
    var max_day = document.getElementById("max_day"); // 최대 숙박일수 태그
    var next = document.querySelector('.next'); // 다음 버튼 

    if(element.value < 1) { // 0보다 작으면 1+
        element.value = 1;
    }

    if(parseInt(ieast_day.value) > parseInt(max_day.value)){ // 최소 숙박일이 최대 숙박일 보다 크면 이벤트 삭제
       
       //console.log(element.parentElement.nextElementSibling );
        hideErrorTag(element.parentElement.parentElement); //// 에러 박스 숨기기 

        date_box = element.parentElement // 숙박 일수 전체 태그
        date_input_box = date_box.children[0] // 숙박 input box (태그)  
        erro_ctnt = element.parentElement.nextElementSibling; // 에러 태그

        
        erro_ctnt.style.display = 'flex'; // 에러 박스 보이기
        date_box.style.borderColor = 'rgb(253, 226, 219)' ; // 테두리 색상 빨강
        date_box.style.backgroundColor = 'rgb(253, 226, 219)' ; // 배경색 빨강
        date_input_box.style.backgroundColor = 'rgb(253, 226, 219)'; // input box도 빨강
        next.style.pointerEvents = "none"; // 다음 버튼 이벤트 삭제

       console.log('최소 숙박일수는 최대 숙박일수를 넘을 수 없습니다.'); // 아니면 이벤트 삽입 
   
    }else{
        next.style.pointerEvents = "auto"; // 다음 버튼 이벤트 삽입 
        //console.log(element.parentElement.nextElementSibling );
        hideErrorTag(element.parentElement.parentElement); // 에러 박스 숨기기 
        console.log('ok');
    }
}
// 에러 박스 숨기기 및 원래 태그 색깔로 변경
function hideErrorTag(element){
    //console.log(element.children);

    Array.prototype.forEach.call(element.children, (elem, index) => {
        //console.log(elem, index);
        switch (index) {
            case 1:
            case 3:
                elem.style.display = 'none'; // 에러 박스 숨기기 
                break;
            
            case 0:
            case 2:
                elem.style.borderColor = 'rgb(216, 214, 214)' ; // 테두리 색상 노멀
                elem.style.backgroundColor = 'white' ;// 배경색 흰색
                var date_input_box = elem.firstElementChild;
                date_input_box.style.backgroundColor = 'white';// input box도 흰색
                break;
        }
    });
    
}


//달력 
$(function() {
    //예약 가능 날짜  달력 출력 
     $('input[id="reser_date"]').daterangepicker({
         autoUpdateInput: false,
         locale: {
             cancelLabel: 'Clear'
         },
           minDate: new Date(), // 과거 날짜는 선택 못하게 합니다. 
           drops: 'up' // 달력 위치 위로
     });
   // apply 누른 순간 input value에 날짜 값 삽입 
     $('input[id="reser_date"]').on('apply.daterangepicker', function(ev, picker) {
         $(this).val(picker.startDate.format('YYYY-MM-DD'));
         $('input[id="reser_end_t"]').val(picker.endDate.format('YYYY-MM-DD'));
     });
   //  Clear 눌렀을때 삽입된 값 비우기 
     $('input[id="reser_date"]').on('cancel.daterangepicker', function(ev, picker) {
         $(this).val('');
         $('input[id="reser_end_t"]').val('');
     });
    //예약 마감 날짜 눌렀을때  달력 출력 
     $('input[id="reser_end_t"]').daterangepicker({
         autoUpdateInput: false,
         locale: {
             cancelLabel: 'Clear'
         },
          minDate: new Date(), // 과거 날짜는 선택 못하게 합니다. 
          drops: 'up' // 달력 위치 위로
     });
   // apply 누른 순간 input value에 날짜 값 삽입 
     $('input[id="reser_end_t"]').on('apply.daterangepicker', function(ev, picker) {
         $(this).val(picker.endDate.format('YYYY-MM-DD')); 
         $('input[id="reser_date"]').val(picker.startDate.format('YYYY-MM-DD'));
     });
   //  Clear 눌렀을때 삽입된 값 비우기 
     $('input[id="reser_end_t"]').on('cancel.daterangepicker', function(ev, picker) {
         $(this).val('');
         $('input[id="reser_date"]').val('');
     });
   
   });