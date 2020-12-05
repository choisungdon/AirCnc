function viewMenu(){
    var drop_menu = document.querySelector('.drop_menu');

    if(drop_menu.style.display != 'block'){
        drop_menu.style.display= 'block';
    }else{
        drop_menu.style.display = 'none';
    }
}

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

function saveNm(ele){
    var ctnt_itme = ele.parentNode.parentNode.parentNode;
    var arr_ctnt = ctnt_itme.children;
    // 수정한 이름 
    var nm = document.querySelector('#nm');

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



}

function saveDate(ele){
    var ctnt_itme = ele.parentNode.parentNode.parentNode;
    var arr_ctnt = ctnt_itme.children;
    // 수정한 생년월일 
    var month   = document.querySelector('#month');
    var day     = document.querySelector('#day');
    var year    = document.querySelector('#year');

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
}

function saveEmail(ele){
    var ctnt_itme = ele.parentNode.parentNode.parentNode;
    var arr_ctnt = ctnt_itme.children;
    // 수정한 생년월일 
    var e_mail   = document.querySelector('#e_mail');

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
}

function savePh(ele){
    var ctnt_itme = ele.parentNode.parentNode.parentNode;
    var arr_ctnt = ctnt_itme.children;
    // 수정한 생년월일 
    var ph  =   document.querySelector('#ph');

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
}

function dateFilter(year,month,day){
    year = year+'년';
    month = (month > 9 ?  month : '0'+month)+'월';
    day = day+'일';

    return year+' '+month+' '+day;
}
