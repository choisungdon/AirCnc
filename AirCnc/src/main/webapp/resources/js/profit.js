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

function ctnt_menu(ele){
    var ctnt_menu = document.querySelector('.ctnt_menu'); //  후기 메뉴 부모 태그 
    menu_arr = ctnt_menu.children; // 후기 메뉴 자식 태그들(배열)
   
    // menu 태그 접근 
    for(var i=0; i<menu_arr.length; i++){
           
            arr_ele = menu_arr[i].children;
    
            arr_ele[0].style.color ='#EBEBEB'; // 평점  text
            arr_ele[1].style.color = '#EBEBEB'; // 별 이모지 
            menu_arr[i].style.borderBottom = 'solid 1px #EBEBEB';
    }
    // 클릭 메뉴버튼 style 변경 

    //console.log(ele.children);

    // 메뉴 버튼 자식 태그 
    arr_ele = ele.children;
    
    arr_ele[0].style.color ='#008489'; // 평점  text
    arr_ele[1].style.color = '#FFB400'; // 별 이모지 
    ele.style.borderBottom = 'solid 2px #008489';

	// 데이터 가져오기 
	
	
	// 검색 데이터 뽑기 
	var evaluate_val// 후기 점수  0: 모두 보기 1: 1점, 2: 2점, 3: 3점, 4: 4점, 5: 5점
	var i_host = document.querySelector('.i_host').value; // 숙소 pk
	// 선택 후기 점수 데이터 판별
	switch(ele.className){
		case 'sco_all': 
			evaluate_val = 0;
		break;
		case 'sco_1': 
			evaluate_val = 1;
		break;
		case 'sco_2': 
			evaluate_val = 2;
		break;
		case 'sco_3': 
			evaluate_val = 3;
		break;
		case 'sco_4': 
			evaluate_val = 4;
		break;
		case 'sco_5': 
			evaluate_val = 5;
		break;
	}
	
	selectReview(evaluate_val,i_host);
}

// 숙소  선택시 검색 함수 
function search_host(ele){
    //console.log(ele.value);
}

// 비동기 후기 출력 
function selectReview(evaluate_val,i_host){
	
		axios.post('/hostManage/profit', {
	    evaluate_val: evaluate_val,
	    i_host: i_host
	  })
	  .then(function (res) {
		
		// 후기 평균 점수 개수 삽입 
		var avg 	= document.querySelector('.avg'); // 평균 점수 태그 
		var qty 	= document.querySelector('.qty'); //  후기 개수  태그 
		
		var i = document.createElement('i'); // 이모지 (별)
		i.setAttribute('class','fas fa-star');
		
		avg.innerHTML = res.data.rvAvg.avg_val; // 점수 삽입 
		avg.appendChild(i); // 이모지 삽입 
		
		qty.innerHTML = res.data.rvAvg.ctnt_qty; // 후기 개수 삽입 
		
		
		if(res.data.review.length >0){
			res.data.review.forEach(function(ele){
			    //console.log(ele.i_host); 
			});
		}else{
			// 후기 들어갈 최상위 태그 
			var review_main = document.querySelector('.review_main');
			// 후기 없을때 들어가는 문구 
			var div = document.createElement('div');
				div.innerHTML= '첫 번째 후기를 받으면 여기에 표시됩니다.';
				
			var h2 = document.createElement('h2');
				h2.innerHTML= '아직 후기 없음';
			// 문구 삽입 
				review_main.prepend(div)
				review_main.prepend(h2)
		}
		
		
	  })
	  .catch(function (error) {
	    console.log(error);
	  });
	
}