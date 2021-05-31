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

	console.log(checkBox);
    
}


// 뒤로 가기 (8단계로 갑니다.)
function backPage(i_host,i_fee){
    location.href = " /host/hostSaveOne?i_host="+i_host+"&i_fee="+i_fee;
}


window.onload = function(){
	var next		=	document.querySelector('.next'); // 다음 태그 
	var hostSave	=	document.querySelector('.hostSaveEight'); // form 태그 
   
	next.onclick = function(){ // 다음 
		hostSave.submit();
	}
}

