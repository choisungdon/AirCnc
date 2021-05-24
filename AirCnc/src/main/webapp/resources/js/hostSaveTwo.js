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

// 뒤로 가기 (2단계로 갑니다.)
function backPage(i_host,i_build){
    location.href = " /host/hostSaveOne?i_host="+i_host+"&i_build="+i_build;
}

// 4단계로 submit 기능 
window.onload = function(){
	var next		=	document.querySelector('.next'); // 다음 태그 
	var hostSave	=	document.querySelector('.hostSaveThree'); // form 태그 
	
	
	next.onclick = function(){ // 다음 
		hostSave.submit();
	}
}