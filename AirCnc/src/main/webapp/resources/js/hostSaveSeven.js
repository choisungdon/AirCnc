function checkBox (label,checkBox){
    // 이모티콘 check uncheck 변경
    if(label.className == 'far fa-square fa-2x'){
        label.className = 'far fa-check-square fa-2x';
    }else{
        label.className = 'far fa-square fa-2x';
    }
    // 서버에 넘길 input checkbox true false 결정 
    if(checkBox.checked == false){
        checkBox.checked = true;
    }else{
        checkBox.checked = false;
    }
    
}

// 제안 요금 ,제안 할인률
function fee_inser(el,num){
    // el : 태그 , num : 숫자
    el.value = num;
}



window.onload = function(){
	var next		=	document.querySelector('.next'); // 다음 태그 
	var hostSave	=	document.querySelector('.hostSaveSeven'); // form 태그 
    var fee = document.getElementById("fee") // 기본요금 input 태그

    
    // 기본요금 입력 했을때  
    fee.onkeyup = function(e){
        if(e.path[0].value != '' || e.key == 'Backspace'){ // 숫자일때만
            // console.log(e.path[0]);
            //console.log(e);
            feeCheck(e.path[0]); 
        }
        
    }
   
	next.onclick = function(){ // 다음 
		hostSave.submit();
	}
}


// 숙박 기본요금 체크 
function feeCheck(element){
   
    var next = document.querySelector('.next'); // 다음 버튼 

    if(parseInt(element.value) < 11139 || parseInt(element.value) > 11138419){ // 최소 숙박일이 최대 숙박일 보다 크면 이벤트 삭제
       
       //console.log(element.parentElement.nextElementSibling );
        
        fee_ctnt = element.parentElement // 기본요금 전체 태그 
        fee_input_box = element // 요금 input box (태그)  
        erro_ctnt = element.parentElement.nextElementSibling; // 에러 태그

        hideErrorTag(fee_ctnt,fee_input_box,erro_ctnt); //// 에러 박스 숨기기 

        
        erro_ctnt.style.display = 'flex'; // 에러 박스 보이기
        fee_ctnt.style.borderColor = 'rgb(193 53 21)' ; // 테두리 색상 빨강
        fee_ctnt.style.backgroundColor = 'rgb(253, 226, 219)' ; // 배경색 빨강
        fee_input_box.style.backgroundColor = 'rgb(253, 226, 219)'; // input box도 빨강
        next.style.pointerEvents = "none"; // 다음 버튼 이벤트 삭제

       console.log('최소 ₩11,139부터 최대 ₩11,138,419의 기본 요금을 설정하세요.'); // 아니면 이벤트 삽입 
   
    }else{
        next.style.pointerEvents = "auto"; // 다음 버튼 이벤트 삽입 
        //console.log(element.parentElement.nextElementSibling );
        hideErrorTag(fee_ctnt,fee_input_box,erro_ctnt); // 에러 박스 숨기기 
        console.log('ok');
    }
}

// 에러 박스 숨기기 및 원래 태그 색깔로 변경
function hideErrorTag(fee_ctnt,fee_input_box,erro_ctnt){
    //console.log(element.children);
    erro_ctnt.style.display = 'none'; 
    fee_ctnt.style.borderColor = 'rgb(216, 214, 214)' ; // 테두리 색상 흰색
    fee_ctnt.style.backgroundColor = 'white' ; // 배경색 흰색
    fee_input_box.style.backgroundColor = 'white'; // input box도 흰색

    
}


// 뒤로 가기 (7단계로 갑니다.)
function backPage(i_host,i_ck){
    location.href = " /host/hostSaveSix?i_host="+i_host+"&i_ck="+i_ck;
}
