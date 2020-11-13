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
    
}