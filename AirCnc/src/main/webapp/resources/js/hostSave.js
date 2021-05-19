function countUpr_vation(d) {
    d.value = parseInt(d.value) + 1;

    if(d.value > 16) {
        d.value = 16;
    }
}

function countDwr_vation(d) {
    d.value = parseInt(d.value) - 1;
    if(d.value < 1) {
        d.value = 1;
    }
}

function countDw02(d) {
    d.value = parseInt(d.value) + 1;
}

function countUp02(d) {
    d.value = parseInt(d.value) - 1;
    if(d.value < 1) {
        d.value = 1;
    }
}

window.onload = function(){
	var previous	=	document.querySelector('.previous');// 뒤로 
	var next		=	document.querySelector('.next'); // 다음 
	var hostSave	=	document.querySelector('.hostSave'); // form 태그 
	
	previous.onclick = function(){ // 뒤로
		location.href = "/host/duplicate?i_host="+i_host.value;
		
	}
	next.onclick = function(){ // 다음 
		hostSave.submit();
	}
}
