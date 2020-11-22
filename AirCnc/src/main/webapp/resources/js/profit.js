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
			document.querySelector('#val').value = 0;
		break;
		case 'sco_1': 
			evaluate_val = 1;
			document.querySelector('#val').value = 1;
		break;
		case 'sco_2': 
			evaluate_val = 2;
			document.querySelector('#val').value = 2;
		break;
		case 'sco_3': 
			evaluate_val = 3;
			document.querySelector('#val').value = 3;
		break;
		case 'sco_4': 
			evaluate_val = 4;
			document.querySelector('#val').value = 4;
		break;
		case 'sco_5': 
			evaluate_val = 5;
			document.querySelector('#val').value = 5;
		break;
	}
		
	
	selectReview(evaluate_val,i_host);
}

// 숙소  선택시 검색 함수 
function search_host(ele){
	// 숙소  pk
	var i_host = ele.value;
	// 별점 
	var evaluate_val = document.querySelector('#val').value;
	// 비동기 후기 출력 함수 실행
	selectReview(evaluate_val,i_host);
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
		
		// 후기 없음 문구 지우기 
		var void_title = document.querySelector('.void_title');
		void_title.innerHTML = '';
		
		// 후기 글 내용이 있으면 태그  삽입  없으면 비워 두기 
		//console.log(res.data.review.length);
		if(res.data.review.length >0){
			// 후기 들어갈 태그 비우기 
			var rv_item1 = document.querySelector('.rv_item1');
			rv_item1.innerHTML = ''; // main 후기들 담는 태그  비우기 ㄴ
			
			res.data.review.forEach(function(ele){
				
				// 후기 담는 부모 태그  
				var rv_main = document.createElement('div');
				rv_main.setAttribute('class','rv_main');
				
				
				// 그 안에 들어갈 태그 
				var host_room	= document.createElement('div');
				var host_review = document.createElement('div');
				
				host_room.setAttribute('class','host_room');
				host_review.setAttribute('class','host_review');
				
				// 숙소 이미지 이름 삽입 
				var img1 = document.createElement('img');
				img1.src = ele.img_url; // 이미지 경로 
				var rv_room_title = document.createElement('dvi');
				rv_room_title.setAttribute('class','rv_room_title');
				rv_room_title.innerHTML = ele.room_title; // 숙소 이름 
				
				// 최종 숙소 이름 이미지 담는 태그 완성 
				host_room.appendChild(img1);
				host_room.appendChild(rv_room_title);
				
				// 유저 후기 태그 들어갈  유저 이미지 만들기&&내용 삽입 
				var host_rv_nm = document.createElement('host_rv_nm');
				host_rv_nm.setAttribute('class','host_rv_nm');
				
				var img2 = document.createElement('img');
				img2.src = ele.pro_img; // 유저 이미지 경로 
				
				var rv_nm = document.createElement('div');
				rv_nm.setAttribute('class','rv_nm');
				
				var nm = document.createElement('div');
				var day = document.createElement('div');
				
				nm.setAttribute('class','nm');
				day.setAttribute('class','day');
				
				nm.innerHTML = ele.nm; // 유저 이름 
				day.innerHTML = ele.m_dt; // 후기 작성 날짜 
				
				rv_nm.appendChild(nm);
				rv_nm.appendChild(day);
				
				// 유저 이름 이미지 삽입 
				host_rv_nm.appendChild(img2);
				host_rv_nm.appendChild(rv_nm);
				
				// 유저 후기글 
				var contents = document.createElement('div');
				contents.setAttribute('class','contents');
				contents.innerHTML = ele.contents;
				
				// 최종 유저  후기 담는 태그 완성 
				host_review.appendChild(host_rv_nm);
				host_review.appendChild(contents);
				
				// 후기 담는 태그 완성 
				rv_main.appendChild(host_room);
				rv_main.appendChild(host_review);
				
				rv_item1.appendChild(rv_main);
			});
		}else{
			// 후기 없을때 들어가는 문구 
			var div = document.createElement('div');
				div.innerHTML= '첫 번째 후기를 받으면 여기에 표시됩니다.';
				
			var h2 = document.createElement('h2');
				h2.innerHTML= '아직 후기 없음';
			// 문구 삽입 
				void_title.prepend(div);
				void_title.prepend(h2);
				
			// 후기 없을때 문구 밑에 빈칸 삽입  
			var rv_item1 = document.querySelector('.rv_item1');
			rv_item1.innerHTML = ''; // main 후기들 담는 태그  비우기 
			// 빈칸 후기 만들기 
			div	= document.createElement('div');
			var div1	= document.createElement('div');
			var div2	= document.createElement('div');
			// class 삽입 
			div.setAttribute('class','rv_void');
			div1.setAttribute('class','rv_void');
			div2.setAttribute('class','rv_void');
			// 빈칸 삽입 
			rv_item1.appendChild(div);
			rv_item1.appendChild(div1);
			rv_item1.appendChild(div2);
		}
		
		
	  })
	  .catch(function (error) {
	    console.log(error);
	  });
	
}