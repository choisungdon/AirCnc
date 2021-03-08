// 차트 담을 변수 
var myChart
var ctx

// 사용자 상단 메뉴 
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


// 차트 기준 날짜 바꾸기 
function chDate(ele){
    var  thisDate = new Date(); // 현재 날짜 
    var thisYear = thisDate.getFullYear(); // 현재 년도 

	// 월선택 select 태그 
	var check_out = document.querySelector('.check_out');
	check_out.options[0].selected = true; // 월선택 으로 변경
	
	var cpt = document.querySelector('caption'); // 세부정보 태크 

	// 년도 선택 태그 
    var cal_button = document.querySelector('.cal_button');
    var arr_cb = cal_button.children;
    arr_cb[0] // left_date
    arr_cb[1] // main_date
    arr_cb[2] // right_date

    arr_date1 = arr_cb[0].children;
    arr_date2 = arr_cb[2].children;

    arr_date1[1] // left_date > date
    arr_date2[0] //right_date > date

    //console.log(arr_date1[1].innerHTML);
    //console.log(arr_date2[0].innerHTML);

    if(ele.className == 'left_date'){
        arr_cb[1].innerHTML = arr_date1[1].innerHTML;// maind_date
        arr_date2[0].innerHTML = Number(arr_cb[1].innerHTML)+1; // right_date > date
        arr_date1[1].innerHTML =  Number(arr_date1[1].innerHTML) -1 //left_date > date
        cpt.innerHTML = arr_cb[1].innerHTML+' 세부정보' // 년도 세부 정보 
		// chart 및 세부 정보 검색 
		shChart(arr_cb[1].innerHTML.replace(' ',''));
		getTtTable(arr_cb[1].innerHTML.replace(' ',''));
    }else if(ele.className == 'right_date'){
        if(Number(arr_date2[0].innerHTML) > Number(thisYear)) return alert('해당 년도는 알수가 없습니다.')
        
        var temp_date = arr_date2[0].innerHTML;

        arr_date2[0].innerHTML = Number(temp_date)+1; // right_date > date
        arr_date1[1].innerHTML =  Number(temp_date) -1 //left_date > date

        arr_cb[1].innerHTML = temp_date; // main_date
		cpt.innerHTML = temp_date+' 세부정보' // 년도 세부 정보 
		// chart 및 세부 정보 검색 
		shChart(temp_date.replace(' ',''));
		getTtTable(temp_date.replace(' ',''));
    }
}

// 해당 년월 수입 차트 검색 
function shearchDate(ele){
	
	// month_fee ~년 ~월 예상 수입 
	var month_fee = document.querySelector('.month_fee');
	var arr_month_fee = month_fee.children;
	
	// 차트 밑에 있는 검색 년도
	var left_date = document.querySelector('.left_date');
	var right_date = document.querySelector('.right_date');
	var main_date = document.querySelector('.main_date');
	var arr_left_date = left_date.children;
	var arr_right_date = right_date.children;
	
	// 현재 년도  세부정보 title 
	var cpt = document.querySelector('caption');
	
	var  thisDate = new Date(); // 현재 날짜 
    var thisYear = thisDate.getFullYear(); // 현재 년도 
	
	if(ele.value != thisYear){ 
		var arr_ym = ele.value.split('-');
		arr_month_fee[1].innerHTML = arr_ym[0]+'년 '+arr_ym[1]+'월 예약 수입';
		main_date.innerHTML = arr_ym[0];
		arr_left_date[1].innerHTML = Number(arr_ym[0])-1;
		arr_right_date[0].innerHTML = Number(arr_ym[0])+1;
		cpt.innerHTML = arr_ym[0]+'년 '+arr_ym[1]+'월 세부정보';
	}else{ // 모두 보기 선택 
		var today = new Date(); // 기준  현재시간 
		arr_month_fee[1].innerHTML = getFormatDate(today)+'년  예약 수입'; // 연도 예약 수입 
		main_date.innerHTML = getFormatDate(today);
		arr_left_date[1].innerHTML = Number(getFormatDate(today))-1;
		arr_right_date[0].innerHTML = Number(getFormatDate(today))+1;
		cpt.innerHTML = getFormatDate(today)+' 세부정보';
	}
	
	shChart(ele.value.replace(' ',''));
	getTtTable(ele.value.replace(' ',''));
	
}

// 검색 비동기 
function shChart(check_out){
	//chart 태그 비우기 
	myChart.destroy()  
	
	axios.post('/hostManage/earnings', {
    check_out: check_out
  })
  .then(function (res) {
	var b_arr_mon = new Array(0,0,0,0,0,0,0,0,0,0,0,0); // 도표에 들어갈 지급예정 수입 들어갈 변수 
	var c_arr_mon = new Array(0,0,0,0,0,0,0,0,0,0,0,0); // 도표에 들어갈 지급완료 수입 들어갈 변수 
	
   if(res.data.chart.length > 0){
	// 데이터 담기 
	res.data.chart.forEach(function(ele){
		
		for(var i=0 ; i<b_arr_mon.length; i++){
				if(i == Number(ele.check_out)-1){ // 해당 월 지급예정 수입 있으면 수입 삽입 
					if(ele.reser_state == null){
						b_arr_mon[i] = ele.fee;
					}
					
				}
			}
			
		for(var i=0 ; i<c_arr_mon.length; i++){
			if(i == Number(ele.check_out)-1){ // 해당 월 지급완료 수입 있으면 수입 삽입 
				if(ele.reser_state == 'o'){
					c_arr_mon[i] = ele.fee;
				}
				
			}
		}
		
	});
		
	//console.log(ele.check_out);
		myChart = new Chart(ctx, {
		type: 'bar',
		data: {
			labels: ['1월', '2월', '3월', '4월', '5월', '6월','7월','8월','9월','10월','11월','12월'],
			datasets: [{
				label: '지급 완료',
				data: [c_arr_mon[0], c_arr_mon[1], c_arr_mon[2], c_arr_mon[3], c_arr_mon[4], c_arr_mon[5], c_arr_mon[6],c_arr_mon[7],c_arr_mon[8],c_arr_mon[9],c_arr_mon[10],c_arr_mon[11] ],
				backgroundColor: [
					'rgb(0, 132, 137, 0.2)',
					'rgb(0, 132, 137, 0.2)',
					'rgb(0, 132, 137, 0.2)',
					'rgb(0, 132, 137, 0.2)',
					'rgb(0, 132, 137, 0.2)',
					'rgb(0, 132, 137, 0.2)',
					'rgb(0, 132, 137, 0.2)',
					'rgb(0, 132, 137, 0.2)',
					'rgb(0, 132, 137, 0.2)',
					'rgb(0, 132, 137, 0.2)',
					'rgb(0, 132, 137, 0.2)',
					'rgb(0, 132, 137, 0.2)'
				],
				borderColor: [
					'rgb(0, 132, 137, 1)',
					'rgb(0, 132, 137, 1)',
					'rgb(0, 132, 137, 1)',
					'rgb(0, 132, 137, 1)',
					'rgb(0, 132, 137, 1)',
					'rgb(0, 132, 137, 1)',
					'rgb(0, 132, 137, 1)',
					'rgb(0, 132, 137, 1)',
					'rgb(0, 132, 137, 1)',
					'rgb(0, 132, 137, 1)',
					'rgb(0, 132, 137, 1)',
					'rgb(0, 132, 137, 1)'
				],
				borderWidth: 1
				
			}, {

				label: '지급 예정',
				data: [b_arr_mon[0], b_arr_mon[1], b_arr_mon[2], b_arr_mon[3], b_arr_mon[4], b_arr_mon[5], b_arr_mon[6],b_arr_mon[7],b_arr_mon[8],b_arr_mon[9],b_arr_mon[10],b_arr_mon[11] ],
				backgroundColor: [
					'rgba(132, 210, 203, 0.2)',
					'rgba(132, 210, 203, 0.2)',
					'rgba(132, 210, 203, 0.2)',
					'rgba(132, 210, 203, 0.2)',
					'rgba(132, 210, 203, 0.2)',
					'rgba(132, 210, 203, 0.2)',
					'rgba(132, 210, 203, 0.2)',
					'rgba(132, 210, 203, 0.2)',
					'rgba(132, 210, 203, 0.2)',
					'rgba(132, 210, 203, 0.2)',
					'rgba(132, 210, 203, 0.2)',
					'rgba(132, 210, 203, 0.2)'
				],
				borderColor: [
					'rgba(132, 210, 203, 1)',
					'rgba(132, 210, 203, 1)',
					'rgba(132, 210, 203, 1)',
					'rgba(132, 210, 203, 1)',
					'rgba(132, 210, 203, 1)',
					'rgba(132, 210, 203, 1)',
					'rgba(132, 210, 203, 1)',
					'rgba(132, 210, 203, 1)',
					'rgba(132, 210, 203, 1)',
					'rgba(132, 210, 203, 1)',
					'rgba(132, 210, 203, 1)',
					'rgba(132, 210, 203, 1)'
				],
				borderWidth: 1
			
			}]
		},
		options: {
			legend: { display: false },
			responsive: true,
			scales: {
				yAxes: [{
					// 좌측 돈 표기 
					ticks: {
						beginAtZero: true,
						userCallback: function(value, index, values) {
						value = value.toString();
						value = value.split(/(?=(?:...)*$)/);
						value = value.join(',');
						return '￦'+value;
						}
					}
				}]
			},
			tooltips: {
            	callbacks: {
					label: function(tooltipItem,data) {
						// 해당 bar 가격 표기 수정 
						value = tooltipItem.yLabel.toString();
						value = value.split(/(?=(?:...)*$)/);
						value = value.join(',');
						// 가격 표기 + bar 종류 표기 
						return "￦" + value +" "+data.datasets[tooltipItem.datasetIndex].label ;
					}
				}
        	}
		},
	
	});
		
	}else{
			myChart = new Chart(ctx, {
			type: 'bar',
			data: {
				labels: ['1월', '2월', '3월', '4월', '5월', '6월','7월','8월','9월','10월','11월','12월'],
				datasets: [{
					label: '지급 완료',
					data: [0, 0, 0, 0, 0, 0, 0,0,0,0,0,0],
					backgroundColor: [
						'rgb(0, 132, 137, 0.2)',
						'rgb(0, 132, 137, 0.2)',
						'rgb(0, 132, 137, 0.2)',
						'rgb(0, 132, 137, 0.2)',
						'rgb(0, 132, 137, 0.2)',
						'rgb(0, 132, 137, 0.2)',
						'rgb(0, 132, 137, 0.2)',
						'rgb(0, 132, 137, 0.2)',
						'rgb(0, 132, 137, 0.2)',
						'rgb(0, 132, 137, 0.2)',
						'rgb(0, 132, 137, 0.2)',
						'rgb(0, 132, 137, 0.2)'
					],
					borderColor: [
						'rgb(0, 132, 137, 1)',
						'rgb(0, 132, 137, 1)',
						'rgb(0, 132, 137, 1)',
						'rgb(0, 132, 137, 1)',
						'rgb(0, 132, 137, 1)',
						'rgb(0, 132, 137, 1)',
						'rgb(0, 132, 137, 1)',
						'rgb(0, 132, 137, 1)',
						'rgb(0, 132, 137, 1)',
						'rgb(0, 132, 137, 1)',
						'rgb(0, 132, 137, 1)',
						'rgb(0, 132, 137, 1)'
					],
					borderWidth: 1
					
				}, {
		
					label: '지급 예정',
					data: [0, 0, 0, 0, 0, 0, 0,0,0,0,0,0],
					backgroundColor: [
						'rgba(132, 210, 203, 0.2)',
						'rgba(132, 210, 203, 0.2)',
						'rgba(132, 210, 203, 0.2)',
						'rgba(132, 210, 203, 0.2)',
						'rgba(132, 210, 203, 0.2)',
						'rgba(132, 210, 203, 0.2)',
						'rgba(132, 210, 203, 0.2)',
						'rgba(132, 210, 203, 0.2)',
						'rgba(132, 210, 203, 0.2)',
						'rgba(132, 210, 203, 0.2)',
						'rgba(132, 210, 203, 0.2)',
						'rgba(132, 210, 203, 0.2)'
					],
					borderColor: [
						'rgba(132, 210, 203, 1)',
						'rgba(132, 210, 203, 1)',
						'rgba(132, 210, 203, 1)',
						'rgba(132, 210, 203, 1)',
						'rgba(132, 210, 203, 1)',
						'rgba(132, 210, 203, 1)',
						'rgba(132, 210, 203, 1)',
						'rgba(132, 210, 203, 1)',
						'rgba(132, 210, 203, 1)',
						'rgba(132, 210, 203, 1)',
						'rgba(132, 210, 203, 1)',
						'rgba(132, 210, 203, 1)'
					],
					borderWidth: 1
				
				}]
			},
			options: {
				legend: { display: false },
				responsive: true,
				scales: {
					yAxes: [{
						// 좌측 돈 표기 
						ticks: {
							beginAtZero: true,
							userCallback: function(value, index, values) {
							value = value.toString();
							value = value.split(/(?=(?:...)*$)/);
							value = value.join(',');
							return '￦'+value;
							}
						}
					}]
				},
				tooltips: {
		        	callbacks: {
						label: function(tooltipItem,data) {
							// 해당 bar 가격 표기 수정 
							value = tooltipItem.yLabel.toString();
							value = value.split(/(?=(?:...)*$)/);
							value = value.join(',');
							// 가격 표기 + bar 종류 표기 
							return "￦" + value +" "+data.datasets[tooltipItem.datasetIndex].label ;
						}
					}
		    	}
			},
		
		});
		
	}
	
  })
  .catch(function (error) {
    console.log(error);
  });
}

// 숙소 통계 table 생성 함수 
function getTtTable(check_out){
		// 데이터 받을 tbody
		tb = document.querySelector('tbody');
		tb.innerHTML = ''; // 지우기 
		
		axios.post('/hostManage/getTtTable', {
	     check_out: check_out
	  })
	  .then(function (res) {
	    if(res.data.table.length > 0){
			res.data.table.forEach(function(ele){
				var tr = document.createElement('tr');
				var td1 = document.createElement('td');
				var td2 = document.createElement('td');
				var td3 = document.createElement('td');
				var td4 = document.createElement('td');
				var td5 = document.createElement('td');
				var td6 = document.createElement('td');
				
				td1.setAttribute('class','house_info');
				td2.setAttribute('class','data_state');
				td3.setAttribute('class','date_info');
				td4.setAttribute('class','user_info');
				td5.setAttribute('class','gest_qty');
				td6.setAttribute('class','incom_info');
				
				var img1 = document.createElement('img');
				img1.src = ele.img_url;
				
				var span1 = document.createElement('span');
				span1.innerHTML = ele.room_title;
				
				td1.appendChild(img1);
				td1.appendChild(span1);
				
				if(ele.reser_state == null){
					td2.innerHTML = '지금 완료 승인';
				}else{
					td2.innerHTML = '없음';
				}
				
				td3.innerHTML = ele.check_in+' ~ '+ele.check_out;
				
				img2 = document.createElement('img');
				img2.src = ele.pro_img;
				
				var span2 = document.createElement('span');
				span2.innerHTML = ele.nm;
				
				td4.appendChild(img2);
				td4.appendChild(span2);
				
				td5.innerHTML= ele.gest_qty+'명';
				
				td6.innerHTML = '￦'+ele.total_fee;
				
				tr.appendChild(td1);
				tr.appendChild(td2);
				tr.appendChild(td3);
				tr.appendChild(td4);
				tr.appendChild(td5);
				tr.appendChild(td6);
				
				tb.appendChild(tr);
				
				if(ele.fee > 0){
					var tt_tr = document.createElement('tr');
					var tt_td1 = document.createElement('td');
					var tt_td2 = document.createElement('td');
					
					tt_td1.setAttribute('class','total');
					tt_td1.setAttribute('colspan', '5');
					
					tt_td1.innerHTML = '합계 : ';
					
					tt_td2.setAttribute('class','total_fee');
					tt_td2.innerHTML = '￦'+ele.fee;
					
					tt_tr.appendChild(tt_td1);
					tt_tr.appendChild(tt_td2);
					
					tb.appendChild(tt_tr);
				}
				
			});
		}else{ // 검색 결과 없으면 '검색 결과가 없습니다.' 문구 삽입 
			var tr = document.createElement('tr');
			var td = document.createElement('td');
			td.setAttribute('class','void_td');
			td.setAttribute('colspan', '6');
			td.innerHTML = '검색 결과가 없습니다.';
			
			tr.appendChild(td);
			tb.appendChild(tr);
		}

		
	  })
	  .catch(function (error) {
	    console.log(error);
	  });
}

// chart 표기 
window.onload = function(){
	
	var  check_out = new Date(); // 현재 날짜 
	
    var check_out = check_out.getFullYear(); // 현재 년도 
	// 숙소 통계 table 생성 함수 실행 
	getTtTable(check_out);
	
	ctx = document.querySelector('.myChart');// chart 담는 태그 

	axios.post('/hostManage/earnings', {
	    check_out: check_out
	  })
	  .then(function (res) {
	    var b_arr_mon = new Array(0,0,0,0,0,0,0,0,0,0,0,0); // 도표에 들어갈 지급예정 수입 들어갈 변수 
		var c_arr_mon = new Array(0,0,0,0,0,0,0,0,0,0,0,0); // 도표에 들어갈 지급완료 수입 들어갈 변수 
		
	   if(res.data.chart.length > 0){
		// 데이터 담기 
		
		res.data.chart.forEach(function(ele){
			
			for(var i=0 ; i<b_arr_mon.length; i++){
				
				if(i == Number(ele.check_out)-1){ // 해당 월 지급예정 수입 있으면 수입 삽입 
					if(ele.reser_state == null){
						b_arr_mon[i] = ele.fee;
						
					}
				}
			}
			
			for(var i=0 ; i<c_arr_mon.length; i++){
				if(i == Number(ele.check_out)-1){ // 해당 월 지급완료 수입 있으면 수입 삽입 
					if(ele.reser_state == 'o'){
						c_arr_mon[i] = ele.fee;
					}
				}
			}
			
		});
			
		//console.log(ele.check_out);
			myChart = new Chart(ctx, {
			type: 'bar',
			data: {
				labels: ['1월', '2월', '3월', '4월', '5월', '6월','7월','8월','9월','10월','11월','12월'],
				datasets: [{
					label: '지급 완료',
					data: [c_arr_mon[0], c_arr_mon[1], c_arr_mon[2], c_arr_mon[3], c_arr_mon[4], c_arr_mon[5], c_arr_mon[6],c_arr_mon[7],c_arr_mon[8],c_arr_mon[9],c_arr_mon[10],c_arr_mon[11] ],
					backgroundColor: [
						'rgb(0, 132, 137, 0.2)',
						'rgb(0, 132, 137, 0.2)',
						'rgb(0, 132, 137, 0.2)',
						'rgb(0, 132, 137, 0.2)',
						'rgb(0, 132, 137, 0.2)',
						'rgb(0, 132, 137, 0.2)',
						'rgb(0, 132, 137, 0.2)',
						'rgb(0, 132, 137, 0.2)',
						'rgb(0, 132, 137, 0.2)',
						'rgb(0, 132, 137, 0.2)',
						'rgb(0, 132, 137, 0.2)',
						'rgb(0, 132, 137, 0.2)'
					],
					borderColor: [
						'rgb(0, 132, 137, 1)',
						'rgb(0, 132, 137, 1)',
						'rgb(0, 132, 137, 1)',
						'rgb(0, 132, 137, 1)',
						'rgb(0, 132, 137, 1)',
						'rgb(0, 132, 137, 1)',
						'rgb(0, 132, 137, 1)',
						'rgb(0, 132, 137, 1)',
						'rgb(0, 132, 137, 1)',
						'rgb(0, 132, 137, 1)',
						'rgb(0, 132, 137, 1)',
						'rgb(0, 132, 137, 1)'
					],
					borderWidth: 1
					
				}, {
	
					label: '지급 예정',
					data: [b_arr_mon[0], b_arr_mon[1], b_arr_mon[2], b_arr_mon[3], b_arr_mon[4], b_arr_mon[5], b_arr_mon[6],b_arr_mon[7],b_arr_mon[8],b_arr_mon[9],b_arr_mon[10],b_arr_mon[11] ],
					backgroundColor: [
						'rgba(132, 210, 203, 0.2)',
						'rgba(132, 210, 203, 0.2)',
						'rgba(132, 210, 203, 0.2)',
						'rgba(132, 210, 203, 0.2)',
						'rgba(132, 210, 203, 0.2)',
						'rgba(132, 210, 203, 0.2)',
						'rgba(132, 210, 203, 0.2)',
						'rgba(132, 210, 203, 0.2)',
						'rgba(132, 210, 203, 0.2)',
						'rgba(132, 210, 203, 0.2)',
						'rgba(132, 210, 203, 0.2)',
						'rgba(132, 210, 203, 0.2)'
					],
					borderColor: [
						'rgba(132, 210, 203, 1)',
						'rgba(132, 210, 203, 1)',
						'rgba(132, 210, 203, 1)',
						'rgba(132, 210, 203, 1)',
						'rgba(132, 210, 203, 1)',
						'rgba(132, 210, 203, 1)',
						'rgba(132, 210, 203, 1)',
						'rgba(132, 210, 203, 1)',
						'rgba(132, 210, 203, 1)',
						'rgba(132, 210, 203, 1)',
						'rgba(132, 210, 203, 1)',
						'rgba(132, 210, 203, 1)'
					],
					borderWidth: 1
				
				}]
			},
			options: {
				legend: { display: false },
				responsive: true,
				scales: {
					yAxes: [{
						// 좌측 돈 표기 
						ticks: {
							beginAtZero: true,
							userCallback: function(value, index, values) {
							value = value.toString();
							value = value.split(/(?=(?:...)*$)/);
							value = value.join(',');
							return '￦'+value;
							}
						}
					}]
				},
				tooltips: {
	            	callbacks: {
						label: function(tooltipItem,data) {
							// 해당 bar 가격 표기 수정 
							value = tooltipItem.yLabel.toString();
							value = value.split(/(?=(?:...)*$)/);
							value = value.join(',');
							// 가격 표기 + bar 종류 표기 
							return "￦" + value +" "+data.datasets[tooltipItem.datasetIndex].label ;
						}
					}
	        	}
			},
		
		});
			
		}else{
				myChart = new Chart(ctx, {
				type: 'bar',
				data: {
					labels: ['1월', '2월', '3월', '4월', '5월', '6월','7월','8월','9월','10월','11월','12월'],
					datasets: [{
						label: '지급 완료',
						data: [0, 0, 0, 0, 0, 0, 0,0,0,0,0,0],
						backgroundColor: [
							'rgb(0, 132, 137, 0.2)',
							'rgb(0, 132, 137, 0.2)',
							'rgb(0, 132, 137, 0.2)',
							'rgb(0, 132, 137, 0.2)',
							'rgb(0, 132, 137, 0.2)',
							'rgb(0, 132, 137, 0.2)',
							'rgb(0, 132, 137, 0.2)',
							'rgb(0, 132, 137, 0.2)',
							'rgb(0, 132, 137, 0.2)',
							'rgb(0, 132, 137, 0.2)',
							'rgb(0, 132, 137, 0.2)',
							'rgb(0, 132, 137, 0.2)'
						],
						borderColor: [
							'rgb(0, 132, 137, 1)',
							'rgb(0, 132, 137, 1)',
							'rgb(0, 132, 137, 1)',
							'rgb(0, 132, 137, 1)',
							'rgb(0, 132, 137, 1)',
							'rgb(0, 132, 137, 1)',
							'rgb(0, 132, 137, 1)',
							'rgb(0, 132, 137, 1)',
							'rgb(0, 132, 137, 1)',
							'rgb(0, 132, 137, 1)',
							'rgb(0, 132, 137, 1)',
							'rgb(0, 132, 137, 1)'
						],
						borderWidth: 1
						
					}, {
			
						label: '지급 예정',
						data: [0, 0, 0, 0, 0, 0, 0,0,0,0,0,0],
						backgroundColor: [
							'rgba(132, 210, 203, 0.2)',
							'rgba(132, 210, 203, 0.2)',
							'rgba(132, 210, 203, 0.2)',
							'rgba(132, 210, 203, 0.2)',
							'rgba(132, 210, 203, 0.2)',
							'rgba(132, 210, 203, 0.2)',
							'rgba(132, 210, 203, 0.2)',
							'rgba(132, 210, 203, 0.2)',
							'rgba(132, 210, 203, 0.2)',
							'rgba(132, 210, 203, 0.2)',
							'rgba(132, 210, 203, 0.2)',
							'rgba(132, 210, 203, 0.2)'
						],
						borderColor: [
							'rgba(132, 210, 203, 1)',
							'rgba(132, 210, 203, 1)',
							'rgba(132, 210, 203, 1)',
							'rgba(132, 210, 203, 1)',
							'rgba(132, 210, 203, 1)',
							'rgba(132, 210, 203, 1)',
							'rgba(132, 210, 203, 1)',
							'rgba(132, 210, 203, 1)',
							'rgba(132, 210, 203, 1)',
							'rgba(132, 210, 203, 1)',
							'rgba(132, 210, 203, 1)',
							'rgba(132, 210, 203, 1)'
						],
						borderWidth: 1
					
					}]
				},
				options: {
					legend: { display: false },
					responsive: true,
					scales: {
						yAxes: [{
							// 좌측 돈 표기 
							ticks: {
								beginAtZero: true,
								userCallback: function(value, index, values) {
								value = value.toString();
								value = value.split(/(?=(?:...)*$)/);
								value = value.join(',');
								return '￦'+value;
								}
							}
						}]
					},
					tooltips: {
			        	callbacks: {
							label: function(tooltipItem,data) {
								// 해당 bar 가격 표기 수정 
								value = tooltipItem.yLabel.toString();
								value = value.split(/(?=(?:...)*$)/);
								value = value.join(',');
								// 가격 표기 + bar 종류 표기 
								return "￦" + value +" "+data.datasets[tooltipItem.datasetIndex].label ;
							}
						}
			    	}
				},
			
			});
			
		}
	  })
	  .catch(function (error) {
	    console.log(error);
	  });

}


	
// 날짜 포맷 바꾸기 
function getFormatDate(date){
    var year = date.getFullYear();              //yyyy
    var month = (1 + date.getMonth());          //M
    month = month >= 10 ? month : '0' + month;  //month 두자리로 저장
    var day = date.getDate();                   //d
    day = day >= 10 ? day : '0' + day;          //day 두자리로 저장
    return  year       //'-' 추가하여 yyyy-mm-dd 형태 생성 가능 현재 yyyy로 사용
}
