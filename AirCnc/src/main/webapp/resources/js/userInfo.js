function viewMenu(){
    var drop_menu = document.querySelector('.drop_menu');

    if(drop_menu.style.display != 'block'){
        drop_menu.style.display= 'block';
    }else{
        drop_menu.style.display = 'none';
    }
}


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

// 변경란 none block 조절 함수 
function dropData(ele){
    var ctnt_itme = ele.parentNode.parentNode;
    var cit_arr = ctnt_itme.children;

    var itme3 = cit_arr[1]; // 정보 수정란 
    var item2 =  cit_arr[2]; // 정보 수정 완료란
    // 수정 버튼 배열
    var itme1_btn = document.querySelectorAll('.itme1_btn');
   

    if(ele.innerHTML == '수정'){
        // 수정 중인 정보가 있을시 다른 정보는 수정 불가능으로 만들기 
        itme1_btn.forEach(element => {
            if(ele != element){
                element.disabled = true;
            }
        });

        ele.innerHTML = '취소';
        item2.style.display = 'none';
        itme3.style.display = 'block';
    }else{
        itme1_btn.forEach(element => {
            if(ele != element){
                element.disabled = false;
            }
        });

        ele.innerHTML = '수정';
        item2.style.display = 'block';
        itme3.style.display = 'none';
    }
}
// 이름 변경 함수 
function saveNm(ele){
    var ctnt_itme = ele.parentNode.parentNode.parentNode;
    var arr_ctnt = ctnt_itme.children;
    // 수정한 이름 
    var nm = document.querySelector('#nm');

	if(nm.value == ''){
		alert('이름을 정확히 입력하세요.');
		nm.focus();
		return false;
	}
	

		axios.post('/user/info', {
	    nm: nm.value,
		key: 'nm'
	  })
	  .then(function (res) {
	    if(res.data.result > 0){
			// 수정 버튼 배열
		    var itme1_btn = document.querySelectorAll('.itme1_btn');
		    // 수정 버튼 사용하는것으로 변경 
		    itme1_btn.forEach(element => {
		         element.disabled = false;
		    });
		    // div 태그 (기존 개인 정보) 수정 내용으로  삽입 
		    var item2 = arr_ctnt[2];
		    item2.innerHTML = nm.value;
		    item2.style.display = 'block';
		
		    // 취소 버튼  -> 수정 버튼 변경
		    var itme1_btn = arr_ctnt[0].children[1];
		    itme1_btn.innerHTML = '수정';
		
		    // 수정란 숨기기 
		    var itme3_data = arr_ctnt[1];
		    itme3_data.style.display = 'none';
		}else{
			alert("변경 실패");
		}
	  })
	  .catch(function (error) {
	    console.log(error);
	  });

}
// 생일 변경 함수 
function saveDate(ele){
    var ctnt_itme = ele.parentNode.parentNode.parentNode;
    var arr_ctnt = ctnt_itme.children;
    // 수정한 생년월일 
    var month   = document.querySelector('#month');
    var day     = document.querySelector('#day');
    var year    = document.querySelector('#year');
	
	axios.post('/user/info', {
	    bir_day: serverFilter(year.value,month.value,day.value),
		key: 'bir_day'
	  })
	  .then(function (res) {
	    if(res.data.result > 0){
			// 수정 버튼 배열
		    var itme1_btn = document.querySelectorAll('.itme1_btn');
		    // 수정 버튼 사용하는것으로 변경 
		    itme1_btn.forEach(element => {
		         element.disabled = false;
		    });
		
		    // div 태그 (기존 개인 정보) 수정 내용으로  삽입 
		    var item2 = arr_ctnt[2];
		    item2.innerHTML = dateFilter(year.value,month.value,day.value);
		    item2.style.display = 'block';
		
		    // 취소 버튼  -> 수정 버튼 변경
		    var itme1_btn = arr_ctnt[0].children[1];
		    itme1_btn.innerHTML = '수정';
		
		    // 수정란 숨기기 
		    var itme3_data = arr_ctnt[1];
		    itme3_data.style.display = 'none';
			
		}else{
			alert("변경 실패");
		}
	  })
	  .catch(function (error) {
	    console.log(error);
	  });

}
// email 변경 함수 
function saveEmail(ele){
    var ctnt_itme = ele.parentNode.parentNode.parentNode;
    var arr_ctnt = ctnt_itme.children;
    // 수정한 생년월일 
    var e_mail   = document.querySelector('#e_mail');

	// 전화번호 유효성 검사 
	var check = checkEmail(e_mail);
	// 유효 하지 않을때 함수 종료 
	if(check == false){
		return check;
	}

	axios.post('/user/info', {
	    e_mail: e_mail.value,
		key: 'email'
	  })
	  .then(function (res) {
	    if(res.data.result > 0){
			// 수정 버튼 배열
		    var itme1_btn = document.querySelectorAll('.itme1_btn');
		    // 수정 버튼 사용하는것으로 변경 
		    itme1_btn.forEach(element => {
		         element.disabled = false;
		    });
		
		    // div 태그 (기존 개인 정보) 수정 내용으로  삽입 
		    var item2 = arr_ctnt[2];
		    item2.innerHTML = e_mail.value;
		    item2.style.display = 'block';
		
		    // 취소 버튼  -> 수정 버튼 변경
		    var itme1_btn = arr_ctnt[0].children[1];
		    itme1_btn.innerHTML = '수정';
		    
		    // 수정란 숨기기 
		    var itme3_data = arr_ctnt[1];
		    itme3_data.style.display = 'none';

		}else{
			alert("변경 실패");
		}
	  })
	  .catch(function (error) {
	    console.log(error);
	  });
}

//전화번호 변경 
function savePh(ele){
    var ctnt_itme = ele.parentNode.parentNode.parentNode;
    var arr_ctnt = ctnt_itme.children;
    // 수정한 생년월일 
    var ph  =   document.querySelector('#ph');

	// 전화번호 유효성 검사 
	var check = checkPh(ph);
	// 유효 하지 않을때 함수 종료 
	if(check == false){
		return check;
	}
	
	axios.post('/user/info', {
	    ph: ph.value,
		key: 'ph'
	  })
	  .then(function (res) {
	    if(res.data.result > 0){
			// 수정 버튼 배열
		    var itme1_btn = document.querySelectorAll('.itme1_btn');
		    // 수정 버튼 사용하는것으로 변경 
		    itme1_btn.forEach(element => {
		         element.disabled = false;
		    });
		
		    // div 태그 (기존 개인 정보) 수정 내용으로  삽입 
		    var item2 = arr_ctnt[2];
		    item2.innerHTML = ph.value;
		    item2.style.display = 'block';
		
		    // 취소 버튼  -> 수정 버튼 변경
		    var itme1_btn = arr_ctnt[0].children[1];
		    itme1_btn.innerHTML = '수정';
		    
		    // 수정란 숨기기 
		    var itme3_data = arr_ctnt[1];
		    itme3_data.style.display = 'none';

		}else{
			alert("변경 실패");
		}
	  })
	  .catch(function (error) {
	    console.log(error);
	  });
}
// 변경 날짜 화면에 보여지는 날짜 포맷 변경 함수 
function dateFilter(year,month,day){
    year = year+'년';
    month = (month > 9 ?  month : '0'+month)+'월';
    day = day+'일';

    return year+' '+month+' '+day;
}
// server request용 함수 ('20201006')
function serverFilter(year,month,day){
	month = (month > 9 ?  month : '0'+month);
	return year+month+day;
}

// 전화번호 유효성 검사 
function checkPh(ph){
	var regExp = /^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})-?[0-9]{3,4}-?[0-9]{4}$/;
	var tel = ph.value;
	 
	if( !regExp.test(tel) ) {
	    alert('전화번호를 정확히 입력하세요.');
		ph.focus();
		return false;
	}
}


function checkEmail(str)
{        
	 var reg_email = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
	 if(!reg_email.test(str.value)) { 
		alert('Email을 정확히 입력하세요.');
		str.focus();
		return false;      
	 }   
}           


