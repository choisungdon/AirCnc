
// 숙소 선택 다음 
function next(){
    var radio_box = document.querySelector('input[name="hosting"]:checked');
  	// 새로운숙소 등록하기
	if(radio_box.id == 'new_host'){ 
		location.href="/host/hostSave?i_user="+radio_box.value;
	}else{ // 등록중 숙소, 등록완료 숙소 수정페이지 이동  
		location.href="/host/duplicate?i_host="+radio_box.value;
	}
}
// 숙소 삭제
function host_delete(){
    var radio_box = document.querySelector('input[name="hosting"]:checked');
    
	if(radio_box.id == 'next_host'){ // 새로운숙소 등록하기
		return alert('삭제할 숙소를 선택하세요.');
	}else{ // 등록중 숙소, 등록완료 숙소 수정페이지 이동  
		location.href="/host/delHost?i_host="+radio_box.value;
	}
}

window.onload = function() {
    var radio_box = document.querySelector('input[name="hosting"]:checked');
    var next_btn = document.querySelector('.next');
    var delete_btn = document.querySelector('.delete');
    // 선택된 숙소가 없으면 다음/삭제 버튼 비활성화 
    if(radio_box == null){
        next_btn.disabled = true;
        delete_btn.disabled = true;
    }

    var radio_box = document.querySelectorAll('input[name="hosting"]');
    // 숙소 선택시 다음/삭제 버튼 활성화
    radio_box.forEach(element => {
        element.onclick = function() { 
            next_btn.disabled = false;
            delete_btn.disabled = false;
        };
    });
}



