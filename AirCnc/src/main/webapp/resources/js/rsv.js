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
	location.href="/hostManage/house?i_user="+i_user;
}
// 실적 (숙소 수입) 화면  (숙소 관리) 
function goProfit(i_user){
	location.href="/hostManage/profit?i_user="+i_user;
}

// 예정된 여행
function af_trip(ele){
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
    
}

//완료
function complete(ele){
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
}

// 취소됨 
function cancel(ele){
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
    
}

//변경및 취소 요청
function rsv_cc(ele){
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
   
}

//모두 보기
function allView(ele){
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
	
	/*
	console.log(total_fee[1]); //총 합계
	
	
	*/
	
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

// 모든 팝업창 (X) close 버튼 
function close_modal(ele){
    var parent = ele.parentNode.parentNode;
	 parent.style.display='none';

}