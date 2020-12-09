function viewMenu(){
    var drop_menu = document.querySelector('.drop_menu');

    if(drop_menu.style.display != 'block'){
        drop_menu.style.display= 'block';
    }else{
        drop_menu.style.display = 'none';
    }
}




// 후기 작성 popup창 뛰우기 
function hostReview(i_host,i_reser,i_contents){
   // 팝업 태그 
   var review_pop = document.querySelector('.review_pop');
   review_pop.style.display='block';

	// 후기 내용 
    var contents = document.querySelector('#contents');
	// 점수 체크 박스 
	var score = document.querySelectorAll('.score');
    console.log(i_contents);
	// 후기 있으면 기존 후기 가져와서 삽입 
	if(i_contents != 0){
		axios.post('/trip/selReview', {
	    i_host: i_host,
	    i_reser: i_reser
	  })
	  .then(function (res) {
	    //console.log(res.data.result);
		score.forEach(element => {
	        // 기존 점수  체크 
	        if(element.value == res.data.result.evaluate_val){
				element.checked = true;
			}
	    });
		// 기본 후기 삽입 
		contents.innerHTML = res.data.result.contents;
	  })
	  .catch(function (error) {
	    console.log(error);
	  });
	}
 
    // 후기 작성 완료 버튼에 이벤튼 삽입 
    var re_btn_main = document.querySelector('.re_btn_main');
    re_btn_main.onclick= function() { goHostReview(i_host,i_reser)};
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
 function goHostReview(i_host,i_reser){
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

		// 비동기 요청 후기 저장 및 수정 
		axios.post('/trip/review', {
	    i_host: i_host,
	    i_reser: i_reser,
		evaluate_val: review_score,
		contents: contents.value
	  })
	  .then(function (res) {
	    //console.log(res.data.result);

		if(res.data.result > 0){
			alert('후기작성 완료');
			window.location.reload();
			// 후기 팝업창 숨기기 
		     var review_pop = document.querySelector('.review_pop');
		     review_pop.style.display='none';
		}
		
	  })
	  .catch(function (error) {
	    console.log(error);
	  });
       
 }