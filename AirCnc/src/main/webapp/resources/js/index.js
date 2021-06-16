// 달력 
$(function() {
 //체크인 눌렀을때  달력 출력 
  $('input[id="searchin"]').daterangepicker({
      autoUpdateInput: false,
      locale: {
          cancelLabel: 'Clear'
      }
  });
// apply 누른 순간 input value에 날짜 값 삽입 
  $('input[id="searchin"]').on('apply.daterangepicker', function(ev, picker) {
      $(this).val(picker.startDate.format('YYYY-MM-DD'));
	  $('input[id="searchout"]').val(picker.endDate.format('YYYY-MM-DD'));
  });
//  Clear 눌렀을때 삽입된 값 비우기 
  $('input[id="searchin"]').on('cancel.daterangepicker', function(ev, picker) {
      $(this).val('');
	  $('input[id="searchout"]').val('');
  });
 //체크아웃 눌렀을때  달력 출력 
  $('input[id="searchout"]').daterangepicker({
      autoUpdateInput: false,
      locale: {
          cancelLabel: 'Clear'
      }
  });
// apply 누른 순간 input value에 날짜 값 삽입 
  $('input[id="searchout"]').on('apply.daterangepicker', function(ev, picker) {
      $(this).val(picker.endDate.format('YYYY-MM-DD')); 
	  $('input[id="searchin"]').val(picker.startDate.format('YYYY-MM-DD'));
  });
//  Clear 눌렀을때 삽입된 값 비우기 
  $('input[id="searchout"]').on('cancel.daterangepicker', function(ev, picker) {
      $(this).val('');
	  $('input[id="searchin"]').val('');
  });

});

 // 인원 수 up/down 함수 
function countUp(d) {
    d.value = parseInt(d.value) + 1;
}

function countDw(d) {
    d.value = parseInt(d.value) - 1;
    if(d.value < 0) {
        d.value = 0;
    }
}

 // 검색 함수 
function goSearch(){
	var addr = document.getElementById("s_addr").value; // 위치 
	var chin = document.getElementById("searchin").value; // 체크인
	var chout = document.getElementById("searchout").value; // 체크 아웃
	var qty = document.getElementById('dd').value; // 인원 
	
	// 검색 옵션 없을시 return 
	if(addr == '') return alert('위치를 입력하시오.');
	if(chin == '') return alert('날짜를 추가하시오.');
	if(chout == '') return alert('날짜를 추가하시오.');
	if(qty < 1)  return alert('인원수를 추가하시오.');
	
	location.href = "/search/searchMain?addr="+addr+"&chin="+chin+"&chout="+chout+"&qty="+qty;
}



//회원가입 창 팝업, 닫기
function popupJoin() {
	display = document.getElementById("join").style.display;
	if (display == 'block') {
		document.getElementById("join").style.display = 'none';
	} else {
		document.getElementById("join").style.display = 'block';
		document.getElementById("showJoin").style.display= 'block';
	}
}
function mailJoin() {
	display = document.getElementById("joinSubmit").style.display;
	if (display == 'block') {
		document.getElementById("joinSubmit").style.display = 'none';
	} else {
		document.getElementById("showJoin").style.display = 'none';
		document.getElementById("joinSubmit").style.display = 'block';
	}
}
function joinClose() {
	display = document.getElementById("join").style.display;
	if (display == 'block') {
		document.getElementById("joinSubmit").style.display = 'none';
		document.getElementById("showJoin").style.display = 'block';
		document.getElementById("join").style.display = 'none';
	} else {
		document.getElementById("join").style.display = 'block';
	}
}

// 로그인창 팝업, 닫기
function popupLogin() {
	display = document.getElementById("login").style.display;
	if (display == 'block') {
		document.getElementById("login").style.display = 'none';
	} else {
		document.getElementById("login").style.display = 'block';
	}
}
function loginClose() {
	display = document.getElementById("login").style.display;
	if (display == 'block') {
		document.getElementById("login").style.display = 'none';
	} else {
		document.getElementById("login").style.display = 'block';
	}
}

// 파업창 안에 있는 회원 가입 버튼  
function joinChildBtn(){
	// login 팝업창 숨기기 
	var login = document.getElementById("login");
	login.style.display = 'none';
	// 이메일 회원가입 창 뛰우기 
	var join = document.getElementById("join");
	join.style.display = 'block';
}
// 팝업창 안에 있는 로그인 버튼 
function loginChildBtn(){
	var login = document.getElementById("login");
	var join = document.getElementById("join");
	
	// login 팝업창 숨기기 
	join.style.display = 'none';
	// 이메일 회원가입 창 뛰우기 
	login.style.display = 'block';
}


function login(){
	erro1 = document.querySelector('.erro1');
	
	if(e_mail.value == ''){ // 이메일 확인 
		return 	erro1.innerHTML = 'E_mail을 확인하세요.';
	}else{
		erro1.innerHTML = '';
		if(c_pw.value==''){ // 비밀번호 확인 
			return 	erro1.innerHTML = '비밀번호를 확인하세요.';
		}else{
			erro1.innerHTML = '';
		}
	}
	
	axios.post('/login', {
		e_mail: e_mail.value,
	    c_pw: c_pw.value
	  })
	  .then(function (res) {
	    //console.log(res.data.result);

		if(res.data.result != 1){ // result 1 아닐 시 :  오류 판별  Text(오류) 삽입 
			erro1.innerHTML = res.data.result;
		}else{
			alert("로그인 성공"); // result 1 -> 로그인 성공 
			location.href="/";
		}
		
	  })
	  .catch(function (error) {
	    console.log(error);
	  });
}

// 로그인중 엔터키 클릭시 
function loginEnter(){
	if ( window.event.keyCode == 13 ) {
			// 로그인 함수 실행 
	        login();
	    }
}

// 회원 가입 함수 
function join(){
	erro = document.querySelector('.erro');
	
	if(chkEmail(s_e_mail.value) && s_e_mail.value != ''){ // e_mail 확인 
		erro.innerHTML = '';
		if(isDate(bir_day.value)) // 생년월일 확인 
		{
			erro.innerHTML = '';
			if(s_nm.value == ''){ // 이름 확인 
				return erro.innerHTML = '이름을 입력하세요.';
			}else{
				erro.innerHTML = '';
				if(s_c_pw.value == ''){ // 비밀번호 확인 
					return erro.innerHTML = '비밀번호를 입력하세요.';
				}else erro.innerHTML = '';
			}
		}else return erro.innerHTML = '생년월일을 확인하세요.';
		
	}else  return erro.innerHTML = 'E_mail을 다시 입력하세요.';
	
		// 회원 가입 서버로 요청 
		axios.post('/join', { 
		e_mail: s_e_mail.value,
	    nm: s_nm.value,
	    c_pw: s_c_pw.value,
		bir_day : bir_day.value,
		logintype : "nomal"
	  })
	  .then(function (res) { // 결과 값  console.log(res.data.result)
		if(res.data.result == 0){ // 0 : E_mail 중복
			erro.innerHTML = 'E_mail 중복';
		}else{ // 회원 가입 성공 
			alert("회원 가입 성공");
			location.href="/";
		}
	  })
	  .catch(function (error) { // 에러
	    console.log(error);
	  });
}


// e_mail 체크 
function chkEmail(str) {
    var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    if (regExp.test(str)) return true;
    else return false;
}

// 회원 가입 생년월일 체크 
function isDate(txtDate) {
    var currVal = txtDate;
    if (currVal == '')
        return false;
 
    var rxDatePattern = /^(\d{4})(\d{1,2})(\d{1,2})$/; // 날짜 정규식                  
    var dtArray = currVal.match(rxDatePattern); // 날짜 형식에 맞으면 배열 형식으로 데이터 저장 
 
    if (dtArray == null)
        return false;
 
    // yyyymmdd format 확인 
    dtYear = dtArray[1];
    dtMonth = dtArray[2];
    dtDay = dtArray[3];
 
    if (dtMonth < 1 || dtMonth > 12) // 월 확인 
        return false;
    else if (dtDay < 1 || dtDay > 31) // 날짜 확인 
        return false;
    else if ((dtMonth == 4 || dtMonth == 6 || dtMonth == 9 || dtMonth == 11) && dtDay == 31)
        return false;
    else if (dtMonth == 2) { // 2월달  일수 확인 
        var isleap = (dtYear % 4 == 0 && (dtYear % 100 != 0 || dtYear % 400 == 0));
        if (dtDay > 29 || (dtDay == 29 && !isleap))
            return false;
    }
    return true;
}

// 자동 로그인 
function autoLogin(){
	
	axios.post('/login', {
		e_mail: 'admin@naver.com',
	    c_pw: '1234'
	  })
	  .then(function (res) {
	    //console.log(res.data.result);

		if(res.data.result != 1){
			alert("로그인 실패");
		}else{
			location.href="/";
		}
		
	  })
	  .catch(function (error) {
	    console.log(error);
	  });
	
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


// dropDown 메뉴 함수 
function myMenu() {
	var menuctnt = document.querySelector('.menuctnt');
	
	if(menuctnt.style.display == 'block'){
		menuctnt.style.display='none';
	}else{
		menuctnt.style.display='block';
	}
}

//연관 주소 list 뽑기   
function goAddr(){
	// 서브 주소 list 태그  
	var drop_addr = document.querySelector('.drop_addr');
	
	drop_addr.innerHTML = '';
	
	// 검색 내용이 없으면 list 창 숨기기 있으면 나타내기 
	if(s_addr.value == ''){ 
		drop_addr.style.display='none';
		return false;
	}else{
		drop_addr.style.display='block';
	}
	 // 연관 주소  출력 
	axios.get('/index/search', {
    params: {
      s_addr: s_addr.value
    }
  })
  .then(function (res) {
	if(res.data.result.length < 1 ){
		drop_addr.style.display = 'none';
	}else{
		res.data.result.forEach(function(element){
			// list 태그 안에 들어갈 태그 
			var div  = document.createElement('div');
			div.setAttribute( 'class', 'addr_item' );
			
			// div 태그 안에 들어갈 태그 (이모지,주소 내용)
			var i = document.createElement('i');
			i.setAttribute( 'class', 'fas fa-map-marker-alt' );
			
			var span = document.createElement('span');
			span.innerHTML = element.hidden_addr;
			
			div.onclick =  function() { insAddr(element.addr)};
			
			// 태그 삽입 
			div.appendChild(i);
			div.appendChild(span);
			
    		drop_addr.appendChild(div);
		});
	}
	

  })

}

// 주소 검색창에  선택 주소 삽입 함수  
function insAddr(ele){
	s_addr.value = ele;
	searchin.focus();
}



// dropDown menu , 연관 주소 list 아닌 태그 클릭시 숨기기 
window.onclick = function(event) {
	var menuctnt = document.querySelector('.menuctnt');
	var drop_addr = document.querySelector('.drop_addr');
	//dropDown 메뉴
	if(event.target.className != 'menubutton' &&  event.target.className != 'ham' && event.target.className != 'profile'){
		menuctnt.style.display = 'none';
	}
	
	//연관 주소 list
	drop_addr.style.display='none';
}






