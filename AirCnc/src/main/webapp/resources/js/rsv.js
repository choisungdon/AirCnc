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

// 예정된 여행
function af_trip(ele,i_user){
    var data_menu = document.querySelector('.data_menu'); //  예약 메뉴 부모 태그 
    menu_arr = data_menu.children; // 예약 메뉴 자식 태그들(배열)
   
    // menu 태그 접근 
    for(var i=0; i<menu_arr.length; i++){
        if(menu_arr[i].className !=  ele.className){ // 클릭 메뉴 아닌것들은 글자색 , 밑줄 없애기  
            menu_arr[i].style.color='#484848';
            menu_arr[i].style.borderBottom='none';
        }
    }
    // 클릭 메뉴버튼 style 변경 
    ele.style.color='#008489'
    ele.style.borderBottom = 'solid 2px #008489';
	// 일단 테이블 내용 다지우기 
	var tb = document.querySelector('.tb');// tbody
	tb.innerHTML = '';
	var th = document.querySelector('.th'); // thd
	th.innerHTML = '';
	// 코로나 경고 문구 
	var n = document.querySelector('.data_notice');
	// 데이터 없음 문구 
	var v = document.querySelector('.void_data');
	
	if(n != null || v != null){ // 지우기 
		n.remove(); 
		v.remove();
	}
	
	// 예약 예정 데이터  불러오기 
	axios.post('/hostManage/rsv', {
		 i_user: i_user// pk
	  })
	  .then(function (res) {
		if(res.data.result.length < 1 || res.data.result == null ){
			// 코로나 경고 문고 (예약 없을때 나옵니다.) 
			var data_notice 	=	document.createElement("div");
			data_notice.setAttribute("class", "data_notice");
			var fa_shield_virus	=	document.createElement("i");
			fa_shield_virus.setAttribute("class", "fas fa-shield-virus fa-2x");
			
			var div 			=	document.createElement("div");
			
			var dn_title		=	document.createElement("div");
			dn_title.setAttribute("class", "dn_title");
			dn_title.innerHTML 	= '호스트와 게스트를 위한 보건·안전 가이드라인';
			
			var dn_text			=	document.createElement("div");
			dn_text.setAttribute("class", "dn_text");
			dn_text.innerHTML = '여행이 점차 회복되는 가운데, 에어비앤비는 호스트와 게스트의 안전을 중요하게 생각합니다. 게스트를 만날 때에는 보건·안전 가이드라인을 따라주시기 바랍니다.';
			
			div.appendChild(dn_title);
			div.appendChild(dn_text);
			
			data_notice.appendChild(fa_shield_virus);
			data_notice.appendChild(div);
			// 예약 없다는 경고문고 
			var void_data = document.createElement("div");
			var h3 = document.createElement("h3");
			
			void_data.setAttribute("class", "void_data");
			h3.innerHTML = '예정된 예약이 없습니다';
			void_data.appendChild(h3);
			
			var data = document.querySelector('.data');
			data.appendChild(data_notice);
			data.appendChild(void_data);
		}else{
		// thead 만들기 
		var th_tr	= document.createElement("tr");
		var th_th1	= document.createElement("th");
		var th_th2	= document.createElement("th");
		var th_th3	= document.createElement("th");
		var th_th4	= document.createElement("th");
		var th_th5	= document.createElement("th");
		var th_th6	= document.createElement("th");
		var th_th7	= document.createElement("th");
		var th_th8	= document.createElement("th");
		
		th_th1.setAttribute("class", "loebl7r");
		th_th2.setAttribute("class", "_8ggqw1");
		th_th3.setAttribute("class", "_isoiixu");
		th_th4.setAttribute("class", "_1l0umdhh");
		th_th5.setAttribute("class", "_8ggqw2");
		th_th6.setAttribute("class", "_8ggqw2");
		th_th7.setAttribute("class", "_8ggqw2");
		th_th8.setAttribute("class", "_n7vhew5");
		
		th_th1.innerHTML = '숙소';
		th_th2.innerHTML = '숙박 날짜';
		th_th3.innerHTML = '게스트';
		th_th4.innerHTML = '총 요금';
		th_th5.innerHTML = '해야 할 일';
		th_th6.innerHTML = '위치';
		th_th7.innerHTML = '예약 신청일';
		th_th8.innerHTML = '';
		
		th_tr.appendChild(th_th1);
		th_tr.appendChild(th_th2);
		th_tr.appendChild(th_th3);
		th_tr.appendChild(th_th4);
		th_tr.appendChild(th_th5);
		th_tr.appendChild(th_th6);
		th_tr.appendChild(th_th7);
		th_tr.appendChild(th_th8);
		
		th.appendChild(th_tr); // 컬럼 제목 
		
	    // forEach문 돌리기 (list 데이터로 받아서 그럽니다.)
		res.data.result.forEach(function(element){
		    // tbody 에 들어갈 td 만들기 
			var td1 = document.createElement("td"); // 숙소 이미지, 제목  담을 태그 
			td1.setAttribute("class", "loebl7r");
			
			var span1 = document.createElement("span");// 숙소 이미지 담을 태그 
			span1.setAttribute("class", "host_img");
			
			var img = document.createElement("img"); // 숙소 이미지 
			img.setAttribute("src",element.img_url);
			img.setAttribute("width","71px");
			span1.appendChild(img);
			
			var span2 = document.createElement("span");// 숙소 제목 
			span2.setAttribute("class", "host_title");
			span2.innerHTML = element.room_title;
			
			td1.appendChild(span1);
			td1.appendChild(span2);
			
			var td2 = document.createElement("td"); // 체크인 체크아웃 
			td2.setAttribute("class", "_8ggqw1");
			td2.innerHTML = element.chin+' ~ '+element.chout;
			
			var td3 = document.createElement("td"); // 인원 
			td3.setAttribute("class", "_isoiixu");
			td3.innerHTML = element.qty+'명';
			
			var td4 = document.createElement("td"); // 요금 
			td4.setAttribute("class", "_1l0umdhh");
			td4.innerHTML = '￦'+numberWithCommas(element.total_fee);
			
			var td5 = document.createElement("td");
			td5.setAttribute("class", "prom");
			
			if(element.reser_state == null) {// 예약 날짜가 지났는데  상태 값이 null 이면 해야 할 일 표기 
				td5.innerHTML = '없음';
			}
			
			var td6 = document.createElement("td"); // 주소 
			td6.setAttribute("class", "_8ggqw2");
			td6.innerHTML = element.addr;
						
			var td7 = document.createElement("td"); // 예약일
			td7.setAttribute("class", "_8ggqw2");
			td7.innerHTML = element.r_dt;
			
			var td8 = document.createElement("td"); // 승인 버튼 
			td8.setAttribute("class", "_n7vhew5");
			var span3 = document.createElement('span');
			span3.setAttribute("onclick","viewData('"+element.i_reser+"')");
			span3.innerHTML = '내용 확인';
			if(element.reser_state == null){// 예약 날짜가 지났는데  상태 값이 null 이면  승인 버튼 나오게 
				td8.appendChild(span3);
			}
			var tr = document.createElement("tr");
			
			tr.appendChild(td1);
			tr.appendChild(td2);
			tr.appendChild(td3);
			tr.appendChild(td4);
			tr.appendChild(td5);
			tr.appendChild(td6);
			tr.appendChild(td7);
			tr.appendChild(td8);
			tb.appendChild(tr);
		});
		}
	  })
	  .catch(function (error) {
	    console.log(error);
	  });
    
}

//완료
function complete(ele,i_user){
    var data_menu = document.querySelector('.data_menu'); //  예약 메뉴 부모 태그 
    menu_arr = data_menu.children; // 예약 메뉴 자식 태그들(배열)
   
    // menu 태그 접근 
    for(var i=0; i<menu_arr.length; i++){
        if(menu_arr[i].className !=  ele.className){ // 클릭 메뉴 아닌것들은 글자색 , 밑줄 없애기  
            menu_arr[i].style.color='#484848';
            menu_arr[i].style.borderBottom='none';
        }
    }
    // 클릭 메뉴버튼 style 변경 
    ele.style.color='#008489'
    ele.style.borderBottom = 'solid 2px #008489'; 
	// 일단 Table 내용 다지우기
	var tb = document.querySelector('.tb');// tbody
	tb.innerHTML = '';
	var th = document.querySelector('.th'); // thd
	th.innerHTML = '';
	// 코로나 경고 문구 
	var n = document.querySelector('.data_notice');
	// 데이터 없음 문구 
	var v = document.querySelector('.void_data');
	
	if(n != null || v != null){ // 지우기 
		n.remove(); 
		v.remove();
	}
	
	// 예약 완료 데이터  불러오기 
	axios.post('/hostManage/completeData', {
		 i_user: i_user// pk
	  })
	  .then(function (res) {
		if(res.data.result.length < 1 || res.data.result == null){
			// 코로나 경고 문고 (예약 없을때 나옵니다.) 
			var data_notice 	=	document.createElement("div");
			data_notice.setAttribute("class", "data_notice");
			var fa_shield_virus	=	document.createElement("i");
			fa_shield_virus.setAttribute("class", "fas fa-shield-virus fa-2x");
			
			var div 			=	document.createElement("div");
			
			var dn_title		=	document.createElement("div");
			dn_title.setAttribute("class", "dn_title");
			dn_title.innerHTML 	= '호스트와 게스트를 위한 보건·안전 가이드라인';
			
			var dn_text			=	document.createElement("div");
			dn_text.setAttribute("class", "dn_text");
			dn_text.innerHTML = '여행이 점차 회복되는 가운데, 에어비앤비는 호스트와 게스트의 안전을 중요하게 생각합니다. 게스트를 만날 때에는 보건·안전 가이드라인을 따라주시기 바랍니다.';
			
			div.appendChild(dn_title);
			div.appendChild(dn_text);
			
			data_notice.appendChild(fa_shield_virus);
			data_notice.appendChild(div);
			// 예약 없다는 경고문고 
			var void_data = document.createElement("div");
			var h3 = document.createElement("h3");
			
			void_data.setAttribute("class", "void_data");
			h3.innerHTML = '완료된 예약 없습니다.';
			void_data.appendChild(h3);
			
			var data = document.querySelector('.data');
			data.appendChild(data_notice);
			data.appendChild(void_data);
		}else{
		// thead 만들기 
		var th_tr	= document.createElement("tr");
		var th_th1	= document.createElement("th");
		var th_th2	= document.createElement("th");
		var th_th3	= document.createElement("th");
		var th_th4	= document.createElement("th");
		var th_th5	= document.createElement("th");
		var th_th6	= document.createElement("th");
		var th_th7	= document.createElement("th");
		var th_th8	= document.createElement("th");
		
		th_th1.setAttribute("class", "loebl7r");
		th_th2.setAttribute("class", "_8ggqw1");
		th_th3.setAttribute("class", "_isoiixu");
		th_th4.setAttribute("class", "_1l0umdhh");
		th_th5.setAttribute("class", "_8ggqw2");
		th_th6.setAttribute("class", "_8ggqw2");
		th_th7.setAttribute("class", "_8ggqw2");
		th_th8.setAttribute("class", "_n7vhew5");
		
		th_th1.innerHTML = '숙소';
		th_th2.innerHTML = '숙박 날짜';
		th_th3.innerHTML = '게스트';
		th_th4.innerHTML = '총 요금';
		th_th5.innerHTML = '해야 할 일';
		th_th6.innerHTML = '위치';
		th_th7.innerHTML = '예약 신청일';
		th_th8.innerHTML = '';
		
		th_tr.appendChild(th_th1);
		th_tr.appendChild(th_th2);
		th_tr.appendChild(th_th3);
		th_tr.appendChild(th_th4);
		th_tr.appendChild(th_th5);
		th_tr.appendChild(th_th6);
		th_tr.appendChild(th_th7);
		th_tr.appendChild(th_th8);
		
		th.appendChild(th_tr); // 컬럼 제목 
		
	    // forEach문 돌리기 (list 데이터로 받아서 그럽니다.)
		res.data.result.forEach(function(element){
			 // tbody 에 들어갈 tr 만들기 
			var tr = document.createElement("tr");
		    // tbody 에 들어갈 td 만들기 
			var td1 = document.createElement("td"); // 숙소 이미지, 제목  담을 태그 
			td1.setAttribute("class", "loebl7r");
			
			var span1 = document.createElement("span");// 숙소 이미지 담을 태그 
			span1.setAttribute("class", "host_img");
			
			var img = document.createElement("img"); // 숙소 이미지 
			img.setAttribute("src",element.img_url);
			img.setAttribute("width","71px");
			span1.appendChild(img);
			
			var span2 = document.createElement("span");// 숙소 제목 
			span2.setAttribute("class", "host_title");
			span2.innerHTML = element.room_title;
			
			td1.appendChild(span1);
			td1.appendChild(span2);
			
			var td2 = document.createElement("td"); // 체크인 체크아웃 
			td2.setAttribute("class", "_8ggqw1");
			td2.innerHTML = element.chin+' ~ '+element.chout;
			
			var td3 = document.createElement("td"); // 인원 
			td3.setAttribute("class", "_isoiixu");
			td3.innerHTML = element.qty+'명';
			
			var td4 = document.createElement("td"); // 요금 
			td4.setAttribute("class", "_1l0umdhh");
			td4.innerHTML = '￦'+numberWithCommas(element.total_fee);
			
			var td5 = document.createElement("td");
			td5.setAttribute("class", "prom");
			
			if(element.reser_state == null) {// 예약 날짜가 지났는데  상태 값이 null 이면 해야 할 일 표기 
				td5.innerHTML = '완료 승인';
			}else{
				td5.innerHTML = '없음';
			}
			
			var td6 = document.createElement("td"); // 주소 
			td6.setAttribute("class", "_8ggqw2");
			td6.innerHTML = element.addr;
						
			var td7 = document.createElement("td"); // 예약일
			td7.setAttribute("class", "_8ggqw2");
			td7.innerHTML = element.r_dt;
			
			var td8 = document.createElement("td"); // 승인 버튼 
			td8.setAttribute("class", "_n7vhew5");
			var span3 = document.createElement('span');
			span3.onclick = function() { rsvComplete(element.i_reser,td5,span3)};
			span3.innerHTML = '승인';
			if(element.reser_state == null){// 예약 날짜가 지났는데  상태 값이 null 이면  승인 버튼 나오게 
				td8.appendChild(span3);
			}
			
			
			tr.appendChild(td1);
			tr.appendChild(td2);
			tr.appendChild(td3);
			tr.appendChild(td4);
			tr.appendChild(td5);
			tr.appendChild(td6);
			tr.appendChild(td7);
			tr.appendChild(td8);
			tb.appendChild(tr);
		});
		}
		
	  })
	  .catch(function (error) {
	    console.log(error);
	  });

}

 // 예약 완료 승인 버튼 
function rsvComplete(i_reser,td,btn){
	axios.post('/hostManage/upRsv', {
    i_reser: i_reser
  })
  .then(function (res) {
    console.log(res.data.result);
	if(res.data.result > 0){ // 성공 
		td.innerHTML = '없음'; // 해야 할 일 문구 태그 내용 변경  
		btn.remove(); // button 태그 지우기 
	}else{
		alert('완료승인  실패 ');
	}
  })
  .catch(function (error) {
    console.log(error);
  });
}


// 취소됨 
function cancel(ele,i_user){
    var data_menu = document.querySelector('.data_menu'); //  예약 메뉴 부모 태그 
    menu_arr = data_menu.children; // 예약 메뉴 자식 태그들(배열)
   
    // menu 태그 접근 
    for(var i=0; i<menu_arr.length; i++){
        if(menu_arr[i].className !=  ele.className){ // 클릭 메뉴 아닌것들은 글자색 , 밑줄 없애기  
            menu_arr[i].style.color='#484848';
            menu_arr[i].style.borderBottom='none';
        }
    }
    // 클릭 메뉴버튼 style 변경 
    ele.style.color='#008489'
    ele.style.borderBottom = 'solid 2px #008489';
	// 일단 테이블 내용 다지우기 
	var tb = document.querySelector('.tb');// tbody
	tb.innerHTML = '';
	var th = document.querySelector('.th'); // thd
	th.innerHTML = '';
	// 코로나 경고 문구 
	var n = document.querySelector('.data_notice');
	// 데이터 없음 문구 
	var v = document.querySelector('.void_data');
	
	if(n != null || v != null){ // 지우기 
		n.remove(); 
		v.remove();
	}
	
	// 취소 완료 데이터  불러오기 
	axios.post('/hostManage/cancelData', {
		 i_user: i_user// pk
	  })
	  .then(function (res) {
		
		if(parseInt(res.data.result.length) < 1|| res.data.result ==null ){
			// 코로나 경고 문고 (데이터 없을때 나옵니다.) 
			var data_notice 	=	document.createElement("div");
			data_notice.setAttribute("class", "data_notice");
			var fa_shield_virus	=	document.createElement("i");
			fa_shield_virus.setAttribute("class", "fas fa-shield-virus fa-2x");
			
			var div 			=	document.createElement("div");
			
			var dn_title		=	document.createElement("div");
			dn_title.setAttribute("class", "dn_title");
			dn_title.innerHTML 	= '호스트와 게스트를 위한 보건·안전 가이드라인';
			
			var dn_text			=	document.createElement("div");
			dn_text.setAttribute("class", "dn_text");
			dn_text.innerHTML = '여행이 점차 회복되는 가운데, 에어비앤비는 호스트와 게스트의 안전을 중요하게 생각합니다. 게스트를 만날 때에는 보건·안전 가이드라인을 따라주시기 바랍니다.';
			
			div.appendChild(dn_title);
			div.appendChild(dn_text);
			
			data_notice.appendChild(fa_shield_virus);
			data_notice.appendChild(div);
			// 예약 없다는 경고문고 
			var void_data = document.createElement("div");
			var h3 = document.createElement("h3");
			
			void_data.setAttribute("class", "void_data");
			h3.innerHTML = '취소된 예약이 없습니다.';
			void_data.appendChild(h3);
			
			
			var data = document.querySelector('.data');
			data.appendChild(data_notice);
			data.appendChild(void_data);
		}else{
		// thead 만들기 
		var th_tr	= document.createElement("tr");
		
		var th_th1	= document.createElement("th");
		var th_th2	= document.createElement("th");
		var th_th3	= document.createElement("th");
		var th_th4	= document.createElement("th");
		
		th_th1.setAttribute("class", "host");
		th_th2.setAttribute("class", "reser_user");
		th_th3.setAttribute("class", "reason");
		th_th4.setAttribute("class", "cancel_day");
		
		th_th1.innerHTML = '숙소';
		th_th2.innerHTML = '예약자';
		th_th3.innerHTML = '이유';
		th_th4.innerHTML = '취소 요청일';
		
		
		th_tr.appendChild(th_th1);
		th_tr.appendChild(th_th2);
		th_tr.appendChild(th_th3);
		th_tr.appendChild(th_th4);
		console.log(th_tr);
		
		th.appendChild(th_tr); // 컬럼 제목 
		
	    // forEach문 돌리기 (list 데이터로 받아서 그럽니다.)
		res.data.result.forEach(function(element){
		    // tbody 에 들어갈 td 만들기 
			var td1 = document.createElement("td"); 
			var td2 = document.createElement("td");  
			var td3 = document.createElement("td");  
			var td4 = document.createElement("td"); 
			
			
			td1.setAttribute("class", "host");
			td2.setAttribute("class", "reser_user");
			td3.setAttribute("class", "reason");
			td4.setAttribute("class", "cancel_day");
			
			td3.innerHTML= element.reason; // 이유
			td4.innerHTML = element.r_dt; // 취소 요청일  
			
			var span1 = document.createElement("span");// 숙소 이미지 담을 태그 
			var span2 = document.createElement("span");// 숙소 타이틀 담을 태그 
			
			span1.setAttribute("class","host_img"); // 숙소 이미지 담을 태그 
			span2.setAttribute("class","host_title");// 숙소 타이틀 담을 태그
			
			var img1 = document.createElement("img");
			img1.setAttribute("src",element.img_url);// 숙소 이미지 
			span2.innerHTML = element.room_title;// 숙소 타이틀 ㄴ
			
			span1.appendChild(img1); // 숙소 이미지 
			td1.appendChild(span1);// 숙소 이미지  
			td1.appendChild(span2);// 숙소 타이틀 
		
			var span3 = document.createElement("span");// 예약자 이미지 담을 태그 
			var span4 = document.createElement("span");// 예약자 이름 담을 태그 
			
			span3.setAttribute("class","user_img"); // 예약자 이미지 담을 태그 
			span4.setAttribute("class","user_nm");// 예약자 이름 담을 태그
			
			var img2 = document.createElement("img");
			img2.setAttribute("src",element.pro_img);// 예약자 이미지 
			span4.innerHTML = element.nm;// 예약자  이름  ㄴ
			
			span3.appendChild(img2); // 예약자 이미지 
			td2.appendChild(span3);// 예약자 이미지  
			td2.appendChild(span4);// 예약자  이름  
			
			
			
			var tr = document.createElement("tr");
			
			tr.appendChild(td1);
			tr.appendChild(td2);
			tr.appendChild(td3);
			tr.appendChild(td4);
			
			tb.appendChild(tr);
			});
		  }
		
	  })
	  .catch(function (error) {
	    console.log(error);
	  });
    
}

//변경및 취소 요청
function rsv_cc(ele,i_user){
    var data_menu = document.querySelector('.data_menu'); //  예약 메뉴 부모 태그 
    menu_arr = data_menu.children; // 예약 메뉴 자식 태그들(배열)
   
    // menu 태그 접근 
    for(var i=0; i<menu_arr.length; i++){
        if(menu_arr[i].className !=  ele.className){ // 클릭 메뉴 아닌것들은 글자색 , 밑줄 없애기  
            menu_arr[i].style.color='#484848';
            menu_arr[i].style.borderBottom='none';
        }
    }
    // 클릭 메뉴버튼 style 변경 
    ele.style.color='#008489'
    ele.style.borderBottom = 'solid 2px #008489';
	// 일단 Table 내용 다지우기
	var tb = document.querySelector('.tb');// tbody
	tb.innerHTML = '';
	var th = document.querySelector('.th'); // thd
	th.innerHTML = '';
	// 코로나 경고 문구 
	var n = document.querySelector('.data_notice');
	// 데이터 없음 문구 
	var v = document.querySelector('.void_data');
	
	if(n != null || v != null){ // 지우기 
		n.remove(); 
		v.remove();
	}
	
	// 예약 변경 및 취소 요청 데이터 불러오기  
	axios.post('/hostManage/rsvCcData', {
		 i_user: i_user// pk
	  })
	  .then(function (res) {
		if(res.data.result.length < 1 || res.data.result == null){
			// 코로나 경고 문고 (예약 없을때 나옵니다.) 
			var data_notice 	=	document.createElement("div");
			data_notice.setAttribute("class", "data_notice");
			var fa_shield_virus	=	document.createElement("i");
			fa_shield_virus.setAttribute("class", "fas fa-shield-virus fa-2x");
			
			var div 			=	document.createElement("div");
			
			var dn_title		=	document.createElement("div");
			dn_title.setAttribute("class", "dn_title");
			dn_title.innerHTML 	= '호스트와 게스트를 위한 보건·안전 가이드라인';
			
			var dn_text			=	document.createElement("div");
			dn_text.setAttribute("class", "dn_text");
			dn_text.innerHTML = '여행이 점차 회복되는 가운데, 에어비앤비는 호스트와 게스트의 안전을 중요하게 생각합니다. 게스트를 만날 때에는 보건·안전 가이드라인을 따라주시기 바랍니다.';
			
			div.appendChild(dn_title);
			div.appendChild(dn_text);
			
			data_notice.appendChild(fa_shield_virus);
			data_notice.appendChild(div);
			// 예약 없다는 경고문고 
			var void_data = document.createElement("div");
			var h3 = document.createElement("h3");
			
			void_data.setAttribute("class", "void_data");
			h3.innerHTML = '예약 변경 및 취소 요청이 없습니다.';
			void_data.appendChild(h3);
			
			var data = document.querySelector('.data');
			data.appendChild(data_notice);
			data.appendChild(void_data);
		}else{
		// thead 만들기 
		var th_tr	= document.createElement("tr");
		var th_th1	= document.createElement("th");
		var th_th2	= document.createElement("th");
		var th_th3	= document.createElement("th");
		var th_th4	= document.createElement("th");
		var th_th5	= document.createElement("th");
		var th_th6	= document.createElement("th");
		var th_th7	= document.createElement("th");
		var th_th8	= document.createElement("th");
		
		th_th1.setAttribute("class", "loebl7r");
		th_th2.setAttribute("class", "_8ggqw1");
		th_th3.setAttribute("class", "_isoiixu");
		th_th4.setAttribute("class", "_1l0umdhh");
		th_th5.setAttribute("class", "_8ggqw2");
		th_th6.setAttribute("class", "_8ggqw2");
		th_th7.setAttribute("class", "_8ggqw2");
		th_th8.setAttribute("class", "_n7vhew5");
		
		th_th1.innerHTML = '숙소';
		th_th2.innerHTML = '숙박 날짜';
		th_th3.innerHTML = '게스트';
		th_th4.innerHTML = '총 요금';
		th_th5.innerHTML = '해야 할 일';
		th_th6.innerHTML = '위치';
		th_th7.innerHTML = '예약 신청일';
		th_th8.innerHTML = '';
		
		th_tr.appendChild(th_th1);
		th_tr.appendChild(th_th2);
		th_tr.appendChild(th_th3);
		th_tr.appendChild(th_th4);
		th_tr.appendChild(th_th5);
		th_tr.appendChild(th_th6);
		th_tr.appendChild(th_th7);
		th_tr.appendChild(th_th8);
		
		th.appendChild(th_tr); // 컬럼 제목 
		
	    // forEach문 돌리기 (list 데이터로 받아서 그럽니다.)
		res.data.result.forEach(function(element){
		    // tbody 에 들어갈 td 만들기 
			var td1 = document.createElement("td"); // 숙소 이미지, 제목  담을 태그 
			td1.setAttribute("class", "loebl7r");
			
			var span1 = document.createElement("span");// 숙소 이미지 담을 태그 
			span1.setAttribute("class", "host_img");
			
			var img = document.createElement("img"); // 숙소 이미지 
			img.setAttribute("src",element.img_url);
			img.setAttribute("width","71px");
			span1.appendChild(img);
			
			var span2 = document.createElement("span");// 숙소 제목 
			span2.setAttribute("class", "host_title");
			span2.innerHTML = element.room_title;
			
			td1.appendChild(span1);
			td1.appendChild(span2);
			
			var td2 = document.createElement("td"); // 체크인 체크아웃 
			td2.setAttribute("class", "_8ggqw1");
			td2.innerHTML = element.chin+' ~ '+element.chout;
			
			var td3 = document.createElement("td"); // 인원 
			td3.setAttribute("class", "_isoiixu");
			td3.innerHTML = element.qty+'명';
			
			var td4 = document.createElement("td"); // 요금 
			td4.setAttribute("class", "_1l0umdhh");
			td4.innerHTML = '￦'+numberWithCommas(element.total_fee);
			//console.log(td4);
			var td5 = document.createElement("td");
			td5.setAttribute("class", "prom");
			
			if(element.reser_state == 'cc') {// 상태 값이 cc면 취소 요청 // ch면 변경 요청  
				td5.innerHTML = '취소 승인'; 
			}else td5.innerHTML = '변경 승인'; // 상태값 ch 이면 
			
			var td6 = document.createElement("td"); // 주소 
			td6.setAttribute("class", "_8ggqw2");
			td6.innerHTML = element.addr;
						
			var td7 = document.createElement("td"); // 예약일
			td7.setAttribute("class", "_8ggqw2");
			td7.innerHTML = element.r_dt;
			
			var td8 = document.createElement("td"); // 승인 버튼 
			td8.setAttribute("class", "_n7vhew5");
			var span3 = document.createElement('span'); // 승인
			var span4 = document.createElement('span'); // 내용 확인 & 이유 확인 
			span3.setAttribute("onclick","goRsvCC('"+element.i_reser+"','"+element.reser_state+"')");
			
			if(element.reser_state == 'cc') {// 상태 값이 cc면 취소 요청 // ch면 변경 요청  
				span4.innerHTML = '이유 확인'; 
				span4.setAttribute("onclick","viewCancelReason('"+element.i_reser+"')");
			}else {// 상태값 ch 이면 
				span4.innerHTML = '내용 확인'; 
				span4.setAttribute("onclick","viewChangeData('"+element.i_reser+"')");
			} 
			
			span3.innerHTML = '승인';
			td8.appendChild(span3);
			td8.appendChild(span4);
			
			var tr = document.createElement("tr");
			
			tr.appendChild(td1);
			tr.appendChild(td2);
			tr.appendChild(td3);
			tr.appendChild(td4);
			tr.appendChild(td5);
			tr.appendChild(td6);
			tr.appendChild(td7);
			tr.appendChild(td8);
			tb.appendChild(tr);
		});
		}
		
	  })
	  .catch(function (error) {
	    console.log(error);
	  });
   
}
// 예약 변경 및 취소 승인 버튼 
function goRsvCC(i_reser,state){
	
	switch (state){
		case 'ch':
		  axios.post('/hostManage/exChange', {
			 i_reser: i_reser// pk
		  })
		  .then(function (res) {
			//console.log(res.data.result);
			
			if(res.data.result > 0){
				alert("변경 승인 했습니다.");
				location.href="/hostManage/rsv?i_user="+res.data.result;
			}else if(res.data.result == 0){
				alert("DB 오류");
			}else if(res.data.result == -1){
				alert("현재 숙소의 숙박 인원이 꽉 찼습니다.");
			}else if(res.data.result == -2){
				alert("변경 날짜가 지나 예약이 취소 되었습니다.");
				location.href="/hostManage/rsv";
			}
		  })
		  .catch(function (error) {
		    console.log(error);
		  });
		break;
		case 'cc':
		  axios.post('/hostManage/exCancel', {
			 i_reser: i_reser// pk
		  })
		  .then(function (res) {
			if(res.data.result > 0){
				alert("취소 승인 했습니다.");
				location.href="/hostManage/rsv?i_user="+res.data.result;
			}else alert("DB 오류");
		  })
		  .catch(function (error) {
		    console.log(error);
		  });
		break;
	}
	
}
// 예약 취소 이유 보기 
function viewCancelReason(i_reser){
	var reason = document.querySelector('.reason_pop');// 팝업 태그 
    if(reason.style.display != 'block'){// 팝업이 닫혀있으면 뛰우기 
        reason.style.display= 'block';
    }else{// 아니면 닫기 
        reason.style.display = 'none';
    }
	// 취소 사유 담는 태그 
	var rs_it_item = document.querySelector('.rs_it_item');
	// 취소 사유  데이터 출력 
	axios.post('/hostManage/viewCancelReason', {
		 i_reser: i_reser// pk
	  })
	  .then(function (res) {
		rs_it_item.innerHTML = res.data.result.reason;
	  })
	  .catch(function (error) {
	    console.log(error);
	  });
}
// 예약 변경 내용 보기 
function viewChangeData(i_reser){
	var change = document.querySelector('.change');// 팝업 태그 
    if(change.style.display != 'block'){// 팝업이 닫혀있으면 뛰우기 
        change.style.display= 'block';
    }else{// 아니면 닫기 
        change.style.display = 'none';
    }
	// 
	var h_title = document.querySelector('.h_title'); // 숙소 제목 , 유형 등등 담는 태그 
	var arr_ht = h_title.children;
	var hImg = document.querySelector('.h_img'); // 숙소 이미지 담는 태그 
	var homeImg = hImg.children;
	var user_data = document.querySelector('.user_data'); //예약자 데이터 담는 태그 
	var arrUD = user_data.children;
	// 유저 변경 전 후 데이터 담는 태그 
	var changeTB = document.querySelector('.change_tb');
	var arr_tb = changeTB.children;
	var arr_tr = arr_tb[0].children; // tr 태그 들 
	// td 태그 들
	var arr_td1 = arr_tr[1].children;
	var arr_td2 = arr_tr[2].children;
	var arr_td3 = arr_tr[3].children;
	
	// 예약 모두 보기 데이터 출력 
	axios.post('/hostManage/viewChangeData', {
		 i_reser: i_reser// pk
	  })
	  .then(function (res) {
		arr_ht[0].innerHTML = res.data.result.room_title;// 숙소 제목 
		var live_type;
		var typ;
		if(typ == 'apt'){ // 숙소 유형
			typ = '아파트';
		}else { // outbuild
			typ = '별채';
		}
		// 숙박 유형 
		if(live_type == 'all'){ 
			live_type = '전체';
		}else if(live_type == 'single') { 
			live_type = '개인실';
		}else{ // share
			live_type = '다인실';
		}
		// 숙소 유형 및 침대 개수 담기 
		arr_ht[1].innerHTML = typ +' '+ live_type + ' . 침대'+ res.data.result.bed_qty+'개';
		// 숙소 이미지 URL 담기 
		homeImg[0].src= res.data.result.img_url;
		// 예약자 데이터 담기 
		arrUD[0].src = res.data.result.pro_img; // 유저 이미지
		arrUD[1].innerHTML = res.data.result.nm; // 유저 이름
		arrUD[2].innerHTML = '(예약일) '+res.data.result.r_dt; // 예약일 
		// 게스트 명수 담기 
		arr_td1[1].innerHTML = '게스트 '+res.data.result.gest_qty+'명'; // 이전 명수 
		arr_td1[2].innerHTML = '게스트 '+res.data.result.be_gest_qty+'명'; // 변경 명수 
		// 예약 날짜 변경 담기 
		arr_td2[1].innerHTML = changeDate(res.data.result.chin)+' -> '+changeDate(res.data.result.chout); // 이전 체크인 체크아웃 
		arr_td2[2].innerHTML = changeDate(res.data.result.be_chin)+' -> '+changeDate(res.data.result.be_chout); // 변경 체크인 체크아웃 
		// 변경  총 합계 요금 담기  
		arr_td3[1].innerHTML = '￦'+numberWithCommas(res.data.result.total_fee); // 변경 전  요금
		arr_td3[2].innerHTML = '￦'+numberWithCommas(res.data.result.be_total_fee); // 변경  후  요금 
	  })
	  .catch(function (error) {
	    console.log(error);
	  });
    
}

//모두 보기
function allView(ele,i_user){
    var data_menu = document.querySelector('.data_menu'); //  예약 메뉴 부모 태그 
    menu_arr = data_menu.children; // 예약 메뉴 자식 태그들(배열)
   
    // menu 태그 접근 
    for(var i=0; i<menu_arr.length; i++){
        if(menu_arr[i].className !=  ele.className){ // 클릭 메뉴 아닌것들은 글자색 , 밑줄 없애기  
            menu_arr[i].style.color='#484848';
            menu_arr[i].style.borderBottom='none';
        }
    }
    // 클릭 메뉴버튼 style 변경 
    ele.style.color='#008489'
    ele.style.borderBottom = 'solid 2px #008489';
	// 일단 Table 내용 다지우기
	var tb = document.querySelector('.tb');// tbody
	tb.innerHTML = '';
	var th = document.querySelector('.th'); // thd
	th.innerHTML = '';
	// 코로나 경고 문구 
	var n = document.querySelector('.data_notice');
	// 데이터 없음 문구 
	var v = document.querySelector('.void_data');
	
	if(n != null || v != null){ // 지우기 
		n.remove(); 
		v.remove();
	}
	
	// 예약 모두 보기 데이터 출력 
	axios.post('/hostManage/allViewData', {
		 i_user: i_user// pk
	  })
	  .then(function (res) {
		if(res.data.result.length < 1 || res.data.result == null){
			// 코로나 경고 문고 (예약 없을때 나옵니다.) 
			var data_notice 	=	document.createElement("div");
			data_notice.setAttribute("class", "data_notice");
			var fa_shield_virus	=	document.createElement("i");
			fa_shield_virus.setAttribute("class", "fas fa-shield-virus fa-2x");
			
			var div 			=	document.createElement("div");
			
			var dn_title		=	document.createElement("div");
			dn_title.setAttribute("class", "dn_title");
			dn_title.innerHTML 	= '호스트와 게스트를 위한 보건·안전 가이드라인';
			
			var dn_text			=	document.createElement("div");
			dn_text.setAttribute("class", "dn_text");
			dn_text.innerHTML = '여행이 점차 회복되는 가운데, 에어비앤비는 호스트와 게스트의 안전을 중요하게 생각합니다. 게스트를 만날 때에는 보건·안전 가이드라인을 따라주시기 바랍니다.';
			
			div.appendChild(dn_title);
			div.appendChild(dn_text);
			
			data_notice.appendChild(fa_shield_virus);
			data_notice.appendChild(div);
			// 예약 없다는 경고문고 
			var void_data = document.createElement("div");
			var h3 = document.createElement("h3");
			
			void_data.setAttribute("class", "void_data");
			h3.innerHTML = '검색 결과가 없습니다.';
			void_data.appendChild(h3);
			
			var data = document.querySelector('.data');
			data.appendChild(data_notice);
			data.appendChild(void_data);
		}else{
		// thead 만들기 
		var th_tr	= document.createElement("tr");
		var th_th1	= document.createElement("th");
		var th_th2	= document.createElement("th");
		var th_th3	= document.createElement("th");
		var th_th4	= document.createElement("th");
		var th_th5	= document.createElement("th");
		var th_th6	= document.createElement("th");
		var th_th7	= document.createElement("th");
		var th_th8	= document.createElement("th");
		
		th_th1.setAttribute("class", "loebl7r");
		th_th2.setAttribute("class", "_8ggqw1");
		th_th3.setAttribute("class", "_isoiixu");
		th_th4.setAttribute("class", "_1l0umdhh");
		th_th5.setAttribute("class", "_8ggqw2");
		th_th6.setAttribute("class", "_8ggqw2");
		th_th7.setAttribute("class", "_8ggqw2");
		th_th8.setAttribute("class", "_n7vhew5");
		
		th_th1.innerHTML = '숙소';
		th_th2.innerHTML = '숙박 날짜';
		th_th3.innerHTML = '게스트';
		th_th4.innerHTML = '총 요금';
		th_th5.innerHTML = '해야 할 일';
		th_th6.innerHTML = '위치';
		th_th7.innerHTML = '예약 신청일';
		th_th8.innerHTML = '';
		
		th_tr.appendChild(th_th1);
		th_tr.appendChild(th_th2);
		th_tr.appendChild(th_th3);
		th_tr.appendChild(th_th4);
		th_tr.appendChild(th_th5);
		th_tr.appendChild(th_th6);
		th_tr.appendChild(th_th7);
		th_tr.appendChild(th_th8);
		
		th.appendChild(th_tr); // 컬럼 제목 
		
	    // forEach문 돌리기 (list 데이터로 받아서 그럽니다.)
		res.data.result.forEach(function(element){
			//  tbody 에 들어갈 tr 만들기 
			var tr = document.createElement("tr");
		    // tbody 에 들어갈 td 만들기 
			var td1 = document.createElement("td"); // 숙소 이미지, 제목  담을 태그 
			td1.setAttribute("class", "loebl7r");
			
			var span1 = document.createElement("span");// 숙소 이미지 담을 태그 
			span1.setAttribute("class", "host_img");
			
			var img = document.createElement("img"); // 숙소 이미지 
			img.setAttribute("src",element.img_url);
			img.setAttribute("width","71px");
			span1.appendChild(img);
			
			var span2 = document.createElement("span");// 숙소 제목 
			span2.setAttribute("class", "host_title");
			span2.innerHTML = element.room_title;
			
			td1.appendChild(span1);
			td1.appendChild(span2);
			
			var td2 = document.createElement("td"); // 체크인 체크아웃 
			td2.setAttribute("class", "_8ggqw1");
			td2.innerHTML = element.chin+' ~ '+element.chout;
			
			var td3 = document.createElement("td"); // 인원 
			td3.setAttribute("class", "_isoiixu");
			td3.innerHTML = element.qty+'명';
			
			var td4 = document.createElement("td"); // 요금 
			td4.setAttribute("class", "_1l0umdhh");
			td4.innerHTML = '￦'+numberWithCommas(element.total_fee);
			
			var td5 = document.createElement("td");
			td5.setAttribute("class", "prom");
			
			//console.log(element.reser_state);
			
			switch (element.reser_state) { // 상태 값에 따라 해야 할 일 표시 변경 
			  case 'o':
			    td5.innerHTML = '없음'; 
			    break;
 			  case 'complete':
			    td5.innerHTML = '완료 승인'; 
			    break;
			  case 'cc':
			    td5.innerHTML = '취소 승인'; 
			    break;
 			  case 'ch':
			    td5.innerHTML = '변경 승인';
			    break;
			}
			
			var td6 = document.createElement("td"); // 주소 
			td6.setAttribute("class", "_8ggqw2");
			td6.innerHTML = element.addr;
						
			var td7 = document.createElement("td"); // 예약일
			td7.setAttribute("class", "_8ggqw2");
			td7.innerHTML = element.r_dt;
			
			var td8 = document.createElement("td"); // 승인 버튼 
			td8.setAttribute("class", "_n7vhew5");
			var span3 = document.createElement('span'); // 승인
			var span4 = document.createElement('span'); // 내용 확인 & 이유 확인 
			
			
			switch (element.reser_state) { // 상태 값에 따라 버튼 함수 변경 
			  case null:
			    span3.setAttribute("onclick","viewData('"+element.i_reser+"')");
				span3.innerHTML = '내용 확인';
				td8.appendChild(span3);
			    break;
 			  case 'complete':
				span3.onclick = function() { rsvComplete(element.i_reser,td5,span3)};
				span3.innerHTML = '승인';
				td8.appendChild(span3);
			    break;
			  case 'cc':
				span3.innerHTML = '승인';
				span3.setAttribute("onclick","goRsvCC('"+element.i_reser+"','"+element.reser_state+"')");
			    span4.innerHTML = '이유 확인'; 
				span4.setAttribute("onclick","viewCancelReason('"+element.i_reser+"')");
				td8.appendChild(span3);
				td8.appendChild(span4);			    
				break;
 			  case 'ch':
				span3.innerHTML = '승인';
				span3.setAttribute("onclick","goRsvCC('"+element.i_reser+"','"+element.reser_state+"')");
			    span4.innerHTML = '변경 내용 확인'; 
				span4.setAttribute("onclick","viewChangeData('"+element.i_reser+"')");
				td8.appendChild(span3);
				td8.appendChild(span4);
			    break;
			}
			
			tr.appendChild(td1);
			tr.appendChild(td2);
			tr.appendChild(td3);
			tr.appendChild(td4);
			tr.appendChild(td5);
			tr.appendChild(td6);
			tr.appendChild(td7);
			tr.appendChild(td8);
			tb.appendChild(tr);
		});
		}
		
	  })
	  .catch(function (error) {
	    console.log(error);
	  });
    
}


// 예정된 예약 내용 확인 
function viewData(i_reser){
	
    var conven_popup = document.querySelector('.vd_pop');// 팝업 태그 
    if(conven_popup.style.display != 'block'){// 팝업이 닫혀있으면 뛰우기 
        conven_popup.style.display= 'block';
    }else{// 아니면 닫기 
        conven_popup.style.display = 'none';
    }
	// 정보 담은 태그 들 
	var pqy_ctnt1 = document.querySelector('.pay_ctnt1');
	var pctnt_arr = pqy_ctnt1.children;
	var pay_info_arr = pctnt_arr[0].children;
	var pay_img_arr =pctnt_arr[1].children;
	/*
	
	*/
	// 정보 담은 태그 들 
	var pay_ctnt3 = document.querySelector('.pay_ctnt3');
	var pctnt3_arr = pay_ctnt3.children;
	var user_info = pctnt3_arr[0].children;
	var date_main = pctnt3_arr[2].children;
	var fee_info = pctnt3_arr[4].children;
	var qty = date_main[0].children;
	var date = date_main[1].children;
	var fee_main = fee_info[0].children;
	var date_fee = fee_main[0].children;
	var qty_fee = fee_main[1].children;
	var total_fee = fee_main[3].children;
	// 내용 확인 데이터 가져오기 
	axios.get('/hostManage/viewData', {
        params: {
          i_reser: i_reser
        }
      })
      .then(function (res) {
		pay_info_arr[0].innerHTML = res.data.result.room_title; //// 숙소 title
		if(res.data.result.typ == 'apt'){ //// 숙소 유형 , 침대 , 숙박 유형 
			switch (res.data.result.live_type) {
				case 'all':
					pay_info_arr[1].innerHTML= '아파트 집 전체. 침대 '+res.data.result.bed_qty+'개';
				break;
				case 'single':
					pay_info_arr[1].innerHTML= '아파트 개인실. 침대 '+res.data.result.bed_qty+'개';
				break;
		   
				case 'share':
					pay_info_arr[1].innerHTML= '아파트 다인실. 침대 '+res.data.result.bed_qty+'개';
				break;
		   }
			
		}else{
			switch (res.data.result.live_type) {
				case 'all':
					pay_info_arr[1].innerHTML= '별채 집 전체. 침대 '+res.data.result.bed_qty+'개';
				break;
				case 'single':
					pay_info_arr[1].innerHTML= '별채 개인실. 침대 '+res.data.result.bed_qty+'개';
				break;
		   
				case 'share':
					pay_info_arr[1].innerHTML= '별채 다인실. 침대 '+res.data.result.bed_qty+'개';
				break;
		   }
		}
		
		pay_img_arr[0].src = res.data.result.img_url;// 숙소 이미지 
		user_info[0].src = res.data.result.pro_img; //유저 이미지 
		user_info[1].innerHTML = res.data.result.nm;// 이름
		user_info[2].innerHTML = '(예약일) '+res.data.result.r_dt;// 예약일 
		qty[1].innerHTML = '게스트 '+res.data.result.qty+'명';// 인원 
		// 체크인 체크아웃 날짜 
		var chinArr = res.data.result.chin.split("-");
		var choutArr = res.data.result.chout.split("-");
		date[1].innerHTML = chinArr[0]+'년'+chinArr[1]+'월'+chinArr[2]+'일 → '+choutArr[0]+'년'+choutArr[1]+'월'+choutArr[2]+'일'
		
		date_fee[0].innerHTML= '￦'+numberWithCommas(res.data.result.fee)+' X '+ res.data.result.date+'박'; //// ￦30,000 X 6박
		date_fee[1].innerHTML= '￦'+numberWithCommas(res.data.result.date*res.data.result.fee);//// ￦180,000
		qty_fee[0].innerHTML= '￦'+numberWithCommas(res.data.result.date*res.data.result.fee)+' X '+res.data.result.qty+'명';// ￦180,000 X 2명
		qty_fee[1].innerHTML= '￦'+numberWithCommas(res.data.result.date*res.data.result.fee*res.data.result.qty)// ￦360,000
		total_fee[1].innerHTML='￦'+numberWithCommas(res.data.result.total_fee)//총 합계
		/*
        	console.log(res.data.result.date);
		*/
      })
}

// 숫자 콤마 찍기
function numberWithCommas(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

// 날짜 년 월 일  출력 함수 
function changeDate(date) {
    var arrDate = date.split("-");
	return arrDate[0]+'년'+arrDate[1]+'월'+arrDate[2]+'일'; 
}

// 모든 팝업창 (X) close 버튼 
function close_modal(ele){
    var parent = ele.parentNode.parentNode;
	 parent.style.display='none';

}
