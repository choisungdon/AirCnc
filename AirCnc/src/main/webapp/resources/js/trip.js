function viewMenu(){
    var drop_menu = document.querySelector('.drop_menu');

    if(drop_menu.style.display != 'block'){
        drop_menu.style.display= 'block';
    }else{
        drop_menu.style.display = 'none';
    }
}

function mButton(ele){
    var btn_1 = document.querySelector(".btn_1");
    var btn_2 = document.querySelector(".btn_2");

    var main_container = document.querySelector(".main_container"); // 예정된 예약 div
    var trip_before = document.querySelector(".trip_before"); // 이전 예약 div
	//console.log(main_container);
	
    if(ele.className == 'btn_1'){
        ele.style.fontWeight = "600";
        btn_2.style.fontWeight = '400';
        
        ele.style.borderBottom = 'solid 2px black';
        btn_2.style.borderBottom = 'none';
        
        main_container.style.display = 'flex';
        trip_before.style.display = 'none';

    }else{
        ele.style.fontWeight = "600";
        btn_1.style.fontWeight = '400';

        ele.style.borderBottom = 'solid 2px black';
        btn_1.style.borderBottom = 'none';

        main_container.style.display = 'none';
        trip_before.style.display = 'flex';
    }
}
//메시지 보내기
function goMsg() {
	location.href = '/message/message';
}

function goChangeRV(i_reser,reser_state){
	//console.log(reser_state);
	if(reser_state == ''){
		location.href = '/reservation/rsvcc?i_reser='+i_reser;
	}else {
		alert('예약 취소 및 변경중엔 변경및 취소가 안됩니다.');
		return false;
	}
}

function goHome(){
	location.href = '/';
}

function goHostReview(i_host,i_reser){
	
}

