//check 숨기기 보이기 
function dropMenu(drop_select){
    if(drop_select.style.display != 'block'){
        drop_select.style.display= 'block';
    }else{
        drop_select.style.display = 'none';
    }
}

// 숙소 건물유형 선택 상자 이벤트
function selType(div){
    // 숙소 건물유형 선택 유형 표시 태그 (주택,별채)
    // 최상위 부모태그 접근 
    var parent = div.parentNode.parentNode.parentNode.parentNode;
    // 숙소 건물유형 선택 유형 표시 태그
    var selText = parent.children[0];
    
    var div_typ  = div.children[0];
    var div_typ =  div_typ.innerHTML.trim();// 공백 제거
    var div_typ =  div_typ.replace(/(\r\n\t|\n|\r\t)/gm,''); // 줄바꿈 제거
    
    var typ = document.querySelector('#typ');

    if(div_typ == '아파트'){ // 서버에 넘길 input 데이터 삽입  & // 숙소 건물유형 유형 선택 표시 태그
		typ.value = 'apt';
        selText.innerHTML='아파트'; 
    }else{
        typ.value = 'outbuild';
        selText.innerHTML='별채';
    }
    // 체크 박스 부모 태그 접근 
    parent_div = div.parentElement.parentElement;
    // 체크 박스 자식태그 접근 
    parent_div = parent_div.children;

    // 체크 박스의 체크 이모티콘 전체 숨기기 
    Array.prototype.forEach.call(parent_div, (elem, index) => {
        // 호스트가 선택한 숙소 건물유형 확인 
        arrelem = elem.children;
        text_elem = arrelem[0].firstElementChild;
        var text =  text_elem.innerHTML.trim();// 공백 제거
        text =  text.replace(/(\r\n\t|\n|\r\t)/gm,''); // 줄바꿈 제거
        // 체크 이모티콘 
        var checkEmoge= elem.lastElementChild;
        if(text!=div_typ){ // 선택 유형 빼고 체크 이모티콘 숨기기  
            checkEmoge.style.display="none";
        }else{
            checkEmoge.style.display="block";
        }

    });
}
    
// 숙소 유형 선택 상자 이벤트
function selLiveType(div){
    // 숙소 선택 유형 표시 태그 (주택,별채)
    // 최상위 부모태그 접근 
    var parent = div.parentNode.parentNode.parentNode.parentNode;
    // 숙소 선택 유형 표시 태그
    var selText = parent.children[0];
    
    var div_typ  = div.children[0];
    var div_typ =  div_typ.innerHTML.trim();// 공백 제거
    var div_typ =  div_typ.replace(/(\r\n\t|\n|\r\t)/gm,''); // 줄바꿈 제거
    
    var live_type = document.querySelector('#live_type');

    if(div_typ == '집전체'){ // 서버에 넘길 input 데이터 삽입  & // 숙소 선택 유형 표시 태그
        live_type.value = 'all';
        selText.innerHTML='집전체'; 
    }else if(div_typ == '개인실'){
        live_type.value = 'single';
        selText.innerHTML='개인실';
    }else {
        live_type.value = 'share';
        selText.innerHTML='다인실';
    }
    // 체크 박스 부모 태그 접근 
    parent_div = div.parentElement.parentElement;
    // 체크 박스 자식태그 접근 
    parent_div = parent_div.children;

    // 체크 박스의 체크 이모티콘 전체 숨기기 
    Array.prototype.forEach.call(parent_div, (elem, index) => {
        // 호스트가 선택한 숙소유형 확인 
        arrelem = elem.children;
        text_elem = arrelem[0].firstElementChild;
        var text =  text_elem.innerHTML.trim();// 공백 제거
        text =  text.replace(/(\r\n\t|\n|\r\t)/gm,''); // 줄바꿈 제거
        // 체크 이모티콘 
        var checkEmoge= elem.lastElementChild;
        if(text!=div_typ){ // 선택 유형 빼고 체크 이모티콘 숨기기  
            checkEmoge.style.display="none";
        }else{
            checkEmoge.style.display="block";
        }

    });
}



window.onload = function(){
	var previous	=	document.querySelector('.previous');// 뒤로 
	var next		=	document.querySelector('.next'); // 다음 
	var hostSave	=	document.querySelector('.hostSaveTwo'); // form 태그 
	
	previous.onclick = function(){ // 뒤로
		location.href = "/host/hostSave?i_host="+i_host.value;
		
	}
	next.onclick = function(){ // 다음 
		hostSave.submit();
	}
}