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


// 차트 기준 날짜 바꾸기 
function chDate(ele){
    var  thisDate = new Date(); // 현재 날짜 
    var thisYear = thisDate.getFullYear(); // 현재 년도 

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
        sh_chart(arr_cb[1].innerHTML); // 차트 검색 
    }else if(ele.className == 'right_date'){
        if(Number(arr_date2[0].innerHTML) > Number(thisYear)) return alert('해당 년도는 알수가 없습니다.')
        
        var temp_date = arr_date2[0].innerHTML;

        arr_date2[0].innerHTML = Number(temp_date)+1; // right_date > date
        arr_date1[1].innerHTML =  Number(temp_date) -1 //left_date > date

        arr_cb[1].innerHTML = temp_date; // main_date

        sh_chart(temp_date); // 차트 검색 
    }
}
// 해당 년도 수입 차트 검색 
function sh_chart(main_date){
    console.log(main_date);
}   
// chart 표기 
window.onload = function(){
    var ctx = document.querySelector('.myChart');
	var myChart = new Chart(ctx, {
		type: 'bar',
		data: {
			labels: ['1월', '2월', '3월', '4월', '5월', '6월','7월','8월','9월','10월','11월','12월'],
			datasets: [{
				label: '지급 완료',
				data: [352000, 352000, 352000, 352000, 352000, 352000, 352000,352000,352000,352000,352000,352000],
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
				data: [1, 352000, 352000, 352000, 352000, 352000, 352000,352000,352000,352000,352000,352000],
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
			responsive: false,
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
