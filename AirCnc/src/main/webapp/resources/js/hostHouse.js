// 메시지 화면 이동
function goMsg() {
	location.href = '/message/message';
}
// 여행 
function goTrb(){
	location.href="/trip/trip";
}
// 메뉴-저장 목록으로 이동
function goWish() {
	location.href = '/wishlists';
}
// 숙소 관리 
function goHost(){
	location.href='/hostManage/manage';
}
// 계정 
function goUser(){
	location.href="/user/userSetting";
}
// 로그아웃 
function goLogOut(){
	location.href="/logOut";
}

window.onclick = function(event) {
    // 숙소 시스템 메뉴 클릭 안할시 dropDown menu 안보이게 
    if (!event.target.matches('.sysMenu') && !event.target.matches('.fa-ellipsis-h')) {
        // 다른 숙소 시스템 메뉴 일괄 닫기 
        var arr_item = document.querySelectorAll('.sysMenu_item');
        arr_item.forEach(element => {
            element.style.display = 'none';
        });
    }
    // 유저 메뉴 클릭 안할시 dropDown menu 안보이게 
    if (!event.target.matches('.userMenu') && !event.target.matches('.menu_img') && !event.target.matches('.my_profile')) {
        var item = document.querySelector('.drop_menu');
        item.style.display = 'none';
    }
}


// 사용자 상단 메뉴 
function viewMenu(){
    var drop_menu = document.querySelector('.drop_menu');

    if(drop_menu.style.display != 'block'){
        drop_menu.style.display= 'block';
    }else{
        drop_menu.style.display = 'none';
    }
}

// 알림판(숙소 관리 )화면 이동  
function goManage(){
	location.href="/hostManage/manage";
}
// 예약(숙소 관리)화면 이동 
function goRSV(i_user){
	location.href="/hostManage/rsv?i_user="+i_user;
}
// 등록중 및 등록한 숙소 화면 이동 (숙소 관리) 
function goHouse(i_user){
	location.href="/hostManage/hostHouse?i_user="+i_user;
}
// 실적 (숙소 수입) 화면  (숙소 관리) 
function goProfit(i_user){
	location.href="/hostManage/profit?i_user="+i_user;
}


// 숙소 시스템 메뉴 (수정 삭제) 보이기 
 function dropSysMenu(ele){
    // 선택 숙소 시스템 메뉴 열기 
    var sysMenu_item = ele.children[1];
    
    if(sysMenu_item.style.display != 'flex'){
        sysMenu_item.style.display= 'flex';
    }else{
        sysMenu_item.style.display = 'none';
    }
  
 }

 // 해당 숙소 삭제 버튼 
 function delHost(i_host){
     // 삭제 팝업 창 뛰우기 
    var del_pop = document.querySelector('.del_pop');
    del_pop.style.display = 'block';
    // 이벤트 삽입 
    var del = document.querySelector('.delete');
    del.onclick = function() { delHostHouse(i_host) };
 }

 // 숙소 삭제 실행 
 function delHostHouse(i_host){
	var cacel = document.querySelector('.del_pop'); // 팝업 태그 
    axios.post('/hostManage/delHostHouse', {
	    i_host	: i_host
	})
  	.then(function (res) {
		//console.log(res.data.result);
		
    	if(res.data.result > 0){
			// 팝업창 닫기 
    		cacel.style.display='none';
			newHostHose(i_host);
		}else{
			alert('삭제 실패');
			// 팝업창 닫기
    		cacel.style.display='none';
		}
  	})
  	.catch(function (error) {
    	console.log(error);
  	});
 }

// 숙소 삭제 후 등록한 숙소 데이터 갱신 함수  
function newHostHose(i_host){
	// 데이터 담을 테이블 태그
	var tb	= document.querySelector('.tb');
	tb.innerHTML = ''; // 있던 데이터 지우기 
	// 데이터 가져오기 ㄴ
    axios.post('/hostManage/shHsotHouse', {
	    i_host		: i_host,
		room_title	: room_title.value,
		i_user		: i_user.value
		
	})
  	.then(function (res) {
		//console.log(res.data.result.length);
		if(res.data.result.length > 0){
			res.data.result.forEach(function(element){
				// tr 생성 
		    	var tb_tr	= document.createElement("tr");
				// td 생성 
				var tb_td1	= document.createElement("td");
				var tb_td2	= document.createElement("td");
				var tb_td3	= document.createElement("td");
				var tb_td4	= document.createElement("td");
				var tb_td5	= document.createElement("td");
				var tb_td6	= document.createElement("td");
				var tb_td7	= document.createElement("td");
				var tb_td8	= document.createElement("td");
				// class 삽입 
				tb_tr.setAttribute("class", "trBorder");
				tb_td1.setAttribute("class", "host_house");
				tb_td2.setAttribute("class", "hostWork");
				tb_td3.setAttribute("class", "br_qty");
				tb_td4.setAttribute("class", "bed_qty");
				tb_td5.setAttribute("class", "wr_qty");
				tb_td6.setAttribute("class", "addr");
				tb_td7.setAttribute("class", "r_dt");
				tb_td8.setAttribute("class", "sysMenu");
				
				tb_td1.onclick = function() { goHouse(element.i_host) };
				var img = document.createElement("img");
				img.setAttribute("width", "71px");
				img.src = element.img_url;
				tb_td1.appendChild(img); // 이미지 삽입 
				tb_td1.innerHTML = tb_td1.innerHTML +' '+ element.room_title; // 숙소 삽입
				// 해야 할 일 삽입 
				if(element.state == 'o'){
					tb_td2.innerHTML = '없음';
				}else{
					tb_td2.innerHTML = '등록 완료하기';
				}
				
				// 객실 수 
				tb_td3.innerHTML = element.b_room;
				// 침실 수 
				tb_td4.innerHTML = element.bed_qty;
				// 욕실 수 
				tb_td5.innerHTML = element.bth_room;
				// 주소
				tb_td6.innerHTML = element.addr;
				// 수정 날짜
				tb_td7.innerHTML = element.m_dt;
				
				// 수정 날짜
				tb_td8.onclick = function() { dropSysMenu(element.i_host) };
				// 이모지 
				var i = document.createElement("i");
				i.setAttribute("class", "fas fa-ellipsis-h");
				
				// 수정 삭제 dropDown menu
				var sysMenu_item = document.createElement("div");
				sysMenu_item.setAttribute("class", "sysMenu_item");
				
				var a		=  document.createElement("a");
				a.href		= "/host/duplicate?i_host="+element.i_host;
				a.target	= '_blank';
				a.innerHTML = '수정';
				
				var div1 	= document.createElement("div");
				div1.innerHTML = '삭제';
				div1.onclick = function(){ delHost(element.i_host) };
				
				sysMenu_item.appendChild(a);
				sysMenu_item.appendChild(div1);
				
				tb_td8.appendChild(i);
				tb_td8.appendChild(sysMenu_item);
				
				tb_tr.appendChild(tb_td1);
				tb_tr.appendChild(tb_td2);
				tb_tr.appendChild(tb_td3);
				tb_tr.appendChild(tb_td4);
				tb_tr.appendChild(tb_td5);
				tb_tr.appendChild(tb_td6);
				tb_tr.appendChild(tb_td7);
				tb_tr.appendChild(tb_td8);
				// 최종 
				tb.appendChild(tb_tr);
			});
		}else{ // 숙소  없을때 
			var tr = document.createElement("tr");
			var td = document.createElement("td");
			var div1 = document.createElement("div");
			var div2 = document.createElement("div");
			var a = document.createElement("a");
			
			tr.setAttribute("class","void_tr");
			td.setAttribute("class","void_td");
			td.setAttribute("colspan","8");
			
			div1.setAttribute("class","void_text");
			div2.setAttribute("class","void_item");
			
			div1.innerHTML = '숙소 없음';
			div2.innerHTML = '에어비앤비에 숙소를 등록해 예약을 받아보세요.';
			a.href = "/host/hosting?i_user="+i_user.value;
			
			div2.appendChild(a)
			
			td.appendChild(div1);
			td.appendChild(div2);
			
			tr.appendChild(td);
			// 최종 
			tb.appendChild(tr);
		}
  	})
  	.catch(function (error) {
    	console.log(error);
  	});
}

 // 수정 화면 
function goHouse(i_host){
	location.href="/host/duplicate?i_host="+i_host;
}

//  팝업창 (X) close 버튼 
function close_modal(ele){
    var parent = ele.parentNode.parentNode;
	 parent.style.display='none';
}

//  팝업창 취소 버튼 
function delClose(){
    var cacel = document.querySelector('.del_pop');
    cacel.style.display='none';
}
