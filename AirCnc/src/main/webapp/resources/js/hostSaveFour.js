
// 뒤로 가기 (5단계로 갑니다.)
function backPage(i_host,i_gest){
    location.href = "/host/hostSaveThree?i_host="+i_host+"&i_gest="+i_gest;
}


window.onload = function(){
	var next		=	document.querySelector('.next'); // 다음 태그 
	var hostSave	=	document.querySelector('.HostSaveFour'); // form 태그 
	
	
	next.onclick = function(){ // 다음 
		hostSave.submit();
	}
}