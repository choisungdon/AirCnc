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


function viewMenu(){
    var drop_menu = document.querySelector('.drop_menu');

    if(drop_menu.style.display != 'block'){
        drop_menu.style.display= 'block';
    }else{
        drop_menu.style.display = 'none';
    }
}

// 후기 작성 popup창 뛰우기 
function hostReview(i_host,i_reser,ele){
	// 후기 내용 태그 
    var contents = document.querySelector('#contents');
	// 점수 체크 박스 
	var score = document.querySelectorAll('.score');
	
	// 수정해야되는 태그 (후기 작성하거나 수정할때 컨트롤할 태그 )
    var ctr_tag
    if(ele.className == 'insReview'){ 
        ctr_tag = ele.parentNode.parentNode;
    }else { 
        ctr_tag = ele.parentNode.parentNode.parentNode.parentNode;
    }

	// 버튼 비활성로 만들기 
	score.forEach(element => {
        element.checked = false;
    });
	// 기본 후기 내용 삭제 
	contents.innerHTML = '';
	
   // 팝업 태그  보이기 
   var review_pop = document.querySelector('.review_pop');
   review_pop.style.display='block';

    // 후기 작성 완료 버튼에 이벤튼 삽입 
    var re_btn_main = document.querySelector('.re_btn_main');
    re_btn_main.onclick= function() { goHostReview(i_host,i_reser,0,ctr_tag)};
 }

// 후기 수정 함수 
function reviewUpdate(i_contents,ele){
	
	// 후기 내용 태그 
    var contents = document.querySelector('#contents');
	// 점수 체크 박스 
	var score = document.querySelectorAll('.score');
	
	// 버튼 비활성로 만들기 
	score.forEach(element => {
        element.checked = false;
    });
	
	 // 수정해야되는 태그 
    var ctr_tag
    if(ele.className == 'insReview'){ 
        ctr_tag = ele.parentNode.parentNode;
    }else {
        ctr_tag = ele.parentNode.parentNode.parentNode.parentNode;
    }

	axios.post('/user/selUserReview', {
	    i_contents : i_contents
	  })
	  .then(function (res) {
	    //console.log(res.data.result);
		score.forEach(element => {
	        // 기존 점수  체크 
	        if(element.value == res.data.result.evaluate_val){
				element.checked = true;
			}
	    });
		// 기존 후기 삽입 
		contents.innerHTML = res.data.result.contents;
	  })
	  .catch(function (error) {
	    console.log(error);
	  });

	   // 팝업 태그  보이기 
	   var review_pop = document.querySelector('.review_pop');
	   review_pop.style.display='block';

	 // 후기 작성 완료 버튼에 이벤튼 삽입 
    var re_btn_main = document.querySelector('.re_btn_main');
    re_btn_main.onclick= function() { goHostReview(0,0,i_contents,ctr_tag)};
	
}
 
 //  팝업창 (X) close 버튼 
 function close_modal(ele){
     var parent = ele.parentNode.parentNode;
      parent.style.display='none';
 } 
 
 // 후기 점수 체크 박스 함수 
 function reviewCheck(ele){
     var score = document.querySelectorAll('.score');
     score.forEach(element => {
         // 선택 check박스와 다른 태그는 unChecked
         if( ele != element){
             element.checked = false;
         }
     });
 }
 
 
 // 후기 작성완료 버튼 함수 
 function goHostReview(i_host,i_reser,i_contents,ctr_tag){
     // 후기 점수 태그 
     var score = document.querySelectorAll('.score');
     // 숙소 점수 
     var review_score = 0;
     // 후기 내용 
     var contents = document.querySelector('#contents');
 
     // 선택 점수 받아오기 
     score.forEach(element => {
         if(element.checked == true){
             review_score = element.value;
         }
     });

     // 점수 선택 안했으면 return  
     if(review_score < 1){
         alert('점수를  선택 하세요.');
         score[0].focus();
         return false;
     }else if(contents.value == ''){
         alert('후기를 작성하세요.');
         contents.focus();
         return false;
     }
	// 비동기 통신 실행(후기 삽입/수정 )
		 axios.post('/user/ctrUserReview', {
		    i_host		:	i_host,
			i_reser		:	i_reser,
			i_contents	:	i_contents,
			contents	:	contents.value,
			evaluate_val:	review_score
	  })
	  .then(function (res) {
	    //console.log(res.data.result.reviewResult);

		// 데이터가 삽입 수정 성공했을때 
		if(res.data.result.reviewResult != 0 ){
			  // 후기 작성이면 해당 태그 삭제 
		    if(ctr_tag.className == 'text_main'){
		        ctr_tag.remove();
				// 후기 태그  담을 부모 태그 
				var pic_arr = document.querySelectorAll('.pro_img_ctnt');
				var pro_img_ctnt = pic_arr[1];
				
				// 전체 후기 태그 
				var rv_main	= document.createElement('div');
				rv_main.setAttribute('class','rv_main');
				// 후기 작성 숙소 이미지 ,이름 
				var host_room = document.createElement('div');
				var hr_img = document.createElement('img');
				var rv_room_title = document.createElement('div');
				// class 이름 지정 
				host_room.setAttribute('class','host_room');
				rv_room_title.setAttribute('class','rv_room_title');
				// 숙소 이미지 삽입 
				hr_img.src = res.data.result.reviewResult.img_url; 
				// 숙소 이름 삽입 
				rv_room_title.innerHTML = res.data.result.reviewResult.room_title; 
				// 숙소 이미지 이름 태그 완성 
				host_room.appendChild(hr_img);
				host_room.appendChild(rv_room_title);
				
				// 후기 넣을 태그
				var host_review = document.createElement('div');
				var host_rv_nm	= document.createElement('div');
				var contents	= document.createElement('div');
				// class 이름 삽입 
				host_review.setAttribute('class','host_review');
				host_rv_nm.setAttribute('class','host_rv_nm');
				contents.setAttribute('class','contents');
				// 작성후기 
				contents.innerHTML = res.data.result.reviewResult.contents;
				
				// host_rv_nm 안에 넣을 태그 
				var host_rv_nm_main = document.createElement('div');
				host_rv_nm_main.setAttribute('class','host_rv_nm_main');
				// host_rv_nm_main 안에 들어갈 태그 
				var user_img = document.createElement('img');
				// 유저 이미지 
				user_img.src = res.data.result.reviewResult.pro_img;
				
				var rv_nm = document.createElement('div');
				rv_nm.setAttribute('class','rv_nm');
				// rv_nm 안에 들어갈 태그 
				var nm = document.createElement('div');
				var day = document.createElement('div');
				nm.setAttribute('class','nm');
				day.setAttribute('class','day');
				// 유저 이름 
				nm.innerHTML = res.data.result.reviewResult.nm;
				// 수정 날짜 
				day.innerHTML = res.data.result.reviewResult.m_dt;
				
				rv_nm.appendChild(nm);
				rv_nm.appendChild(day);
				
				host_rv_nm_main.appendChild(user_img);
				host_rv_nm_main.appendChild(rv_nm);
				// 후기 수정 버튼 
				var upReview 		= document.createElement('span');
				upReview.setAttribute('class','upReview');
				
				var upReview_btn = document.createElement('span');
				upReview_btn.innerHTML = '후기 수정';
				upReview_btn.onclick = function() { reviewUpdate(res.data.result.reviewResult.i_contents,this)};
				
				upReview.appendChild(upReview_btn);
				
				host_rv_nm.appendChild(host_rv_nm_main);
				host_rv_nm.appendChild(upReview);
				
				
				// 후기 넣을 태그 완성 
				host_review.appendChild(host_rv_nm);
				host_review.appendChild(contents);
				// 후기 담는 태그 (완성본) 완성
				rv_main.appendChild(host_room);
				rv_main.appendChild(host_review);
				
				// 완성본 후기  삽입 
				pro_img_ctnt.prepend(rv_main);
				
				
		    }else{
				var rv_main = ctr_tag.children;
				var host_room = rv_main[0].children;
				var host_review = rv_main[1].children;
				var host_rv_nm = host_review[0];
				var contents = host_review[1];
				var host_rv_nm_arr = host_rv_nm.children;
				var user_tag_arr = host_rv_nm_arr[0].children;
				
				// 숙소 url
				host_room[0].src = res.data.result.reviewResult.img_url;
				// 숙소 이름 
				host_room[1].innerHTML = res.data.result.reviewResult.room_title;
				// 유저 후기 
				contents.innerHTML = res.data.result.reviewResult.contents;
				// 유저 이미지 
				user_tag_arr[0].src = res.data.result.reviewResult.pro_img;
				// 후기 수정 날짜
				user_tag_arr[1].src = res.data.result.reviewResult.m_dt;
			}
			alert('후기 작성 완료');
			// 후기 팝업창 숨기기 
		     var review_pop = document.querySelector('.review_pop');
		     review_pop.style.display='none';
		}
		

	  })
	  .catch(function (error) {
	    console.log(error);
		alert('후기 작성 미완료');
	  });
     
 }