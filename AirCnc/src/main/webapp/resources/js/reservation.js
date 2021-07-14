function selMop(text_items,t){
    /*
        text_items          :   결제 수단 선택한 태그 
        mop                 :   카드 결제 인지, 카카오 페이 인지 확인
        i                   :   이모티콘
        selector_text_drop  :   결제 수단 선택 박스 
		t					:	선택 박스 option
    */
    mop = document.getElementById('mop');  
    var selector_text_drop = document.querySelector('.selector_text_drop');
    text_items.innerHTML = ''; 

    if(t.innerHTML == '신용카드 또는 체크카드'){
        var i = document.createElement("i"); // 
        i.className = 'far fa-credit-card fa-lg';
        text_items.append(i);
        text_items.innerHTML += ' 신용카드 또는 체크카드';
        mop.value = 0;
        selector_text_drop.style.display = 'none';
        //console.log('신용카드')
    }else{ 
        var i = document.createElement("i");
        i.className = 'far fa-comment fa-lg';
        text_items.append(i);
        text_items.innerHTML += ' pay';
        mop.value = 1;
        selector_text_drop.style.display = 'none';
		
		
		var i_host 		= document.getElementById('i_host').value; // 숙소 번호 
		var qty			= document.getElementById('qty').value; // 인원
		var chin		= document.getElementById('chin').value; // 입실 날짜
		var chout		= document.getElementById('chout').value; // 퇴실 날짜 
		var total_fee 	= document.getElementById('total_fee').value; // 총금액 
		var ms_title	= document.getElementById('ms_title').value; // 톡방 이름
		var cmt			= document.getElementById('cmt').value;// 톡 내용
		
		
        
		axios.post('/reservation/redKakaoPay', {
			i_host		: i_host,
		 	qty			: qty,
		 	chin		: chin,
			chout		: chout,
		 	total_fee 	: total_fee,
		 	ms_title	: ms_title,
		 	cmt			: cmt
		    
		  })
		  .then(function (res) {
		    console.log(res.data.result);
 			var options = 'top=10, left=10, width=500, height=600, status=no, menubar=no, toolbar=no, resizable=no';
			window.open(res.data.result.next_redirect_pc_url, '카카오 페이', options);
		  })
		  .catch(function (error) {
		    console.log(error);
		  });
        //console.log('카카오 페이 ')
    }
}
// 결제 수단 선택 박스 
function drop_mop(){
    var selector_text_drop = document.querySelector('.selector_text_drop');

    if(selector_text_drop.style.display != 'flex'){
        selector_text_drop.style.display= 'flex';
    }else{
        selector_text_drop.style.display = 'none';
    }
}
// 추가 규칙 보기 숨기기
function dropText(){
    var care_button = document.querySelector('.care_button');
    var plus_care_item = document.querySelector('.plus_care_item');

    if(care_button.innerHTML == "더 보기↓"){
        plus_care_item.style.display = 'block';
        care_button.innerHTML = "숨기기↑"
    }else{  
        plus_care_item.style.display = 'none';
        care_button.innerHTML = "더 보기↓"
    }

}
// 페이지 이동  함수   1. 숙소 이용규칙 확인/ 2. 게스트 정보 입력/  3. 확인 및 결제
function nextPage1(){
   var mainPage = document.querySelector('.container');
   var containerArr = mainPage.childNodes;
   containerArr[1].style.display = 'flex';
   containerArr[3].style.display = 'none';
   containerArr[5].style.display = 'none';
    /*
   console.log(containerArr[1].style.display); // main1
   console.log(containerArr[3].style.display); // main2
   console.log(containerArr[5].style.display); // main3
   */


}

function nextPage2(){
    var mainPage = document.querySelector('.container');
    var containerArr = mainPage.childNodes;
    containerArr[1].style.display = 'none';
    containerArr[3].style.display = 'flex';
    containerArr[5].style.display = 'none';
    /*
    console.log(containerArr[1].style.display); // main1
    console.log(containerArr[3].style.display); // main2
    console.log(containerArr[5].style.display); // main3
    */
}

function nextPage3(){
    var msg_erro	= document.querySelector('.msg_erro'); // 에러 문구 넣을 태그 
	var qty_erro	= document.querySelector('.qty_erro'); // 인원 초과 에러 문구
    var mainPage	= document.querySelector('.container'); // 숙소 이용 규칙[0],게스트 정보 입력[1], 확인 및 결재[2] 
    var containerArr= mainPage.childNodes; //각 페이지 배열타입으로 저장 

    if(cmt.value != "") { // 메시지 내용 있으면 True
		if(qty_erro.innerHTML == ''){ // 해당 인원 숙박 가능 하면 다음 페이지 이동
			msg_erro.innerHTML= ""; // 에러 문구 삭제 
	        containerArr[1].style.display = 'none'; // 숙소 이용 규칙
	        containerArr[3].style.display = 'none'; // 게스트 정보 입력
	        containerArr[5].style.display = 'flex'; // 확인 및 결재
		}
    }else{		// 메시지 내용 없으면 다음 페이지 못감 
        msg_erro.innerHTML= "호스트에게 전할 메시지를 입력하세요."; // 에러 문구 삽입 
        document.getElementById("cmt").focus(); // 메시지 태그 Focus
    }
    
    /*
    console.log(containerArr[1].style.display); // main1
    console.log(containerArr[3].style.display); // main2
    console.log(containerArr[5].style.display); // main3
    */
}

// 인원 추가 버튼 
function countUp(qty){
    qty.value = parseInt(qty.value) + 1;
	qtyComfirm();
    changeFee(qty.value);
	
}

function countDw(qty){
    qty.value = parseInt(qty.value) - 1;
    if(qty.value <=0) {
        qty.value = 1;
    }
	qtyComfirm();
    changeFee(qty.value);
	
}

function qtyComfirm(){
	var erro	= document.querySelector('.qty_erro');
	
	axios.get('/search/goComfirm', {
    params: {
		i_host	:	i_host.value,
		chin	:	chin.value,
		chout	:	chout.value,
		date	:	date.value,
		qty		:	qty.value
    }
  })
  .then(function (res) {
	console.log(res.data.result);
    if(res.data.result != 'o'){
		erro.innerHTML = res.data.result;
	}else{
		erro.innerHTML = '';
	}
  })
}


// 금액 변경 
function changeFee(val){
	// 서버에 전달할 데이터 (전체 요금) input
	TTfee = document.getElementById('total_fee');
	
    qtyTag = document.querySelector('.qty');
    dateFee = document.querySelector('.qty_fee');
    total_fee = document.querySelector('.total_fee');
    qtyTagArr = qtyTag.childNodes;
    dateFeeArr = dateFee.childNodes;
    totalFeeArr = total_fee.childNodes;
	


    qtyTagArr[3].innerHTML = "게스트 "+val+"명"; // 가격표 태그 변경 명수 삽입 
    // 명수 변경 가격 삽입
    dateFeeArr[1].innerHTML = '￦'+(fee.value*date.value).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")+' X '+val+'명';
    dateFeeArr[3].innerHTML = '￦'+(fee.value*date.value*val).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
     // total 변경 가격 삽입
    totalFeeArr[3].innerHTML = '￦'+(fee.value*date.value*val).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
   	
	TTfee.value = fee.value*date.value*val;
   /*
    console.log(qtyTagArr[3]);
    console.log(dateFeeArr[1]);
    console.log(dateFeeArr[3]);
    console.log(totalFeeArr[3]);
    */
}

// 예약 버튼
function goReservation(){
    if(goComfirm() != 0){
        document.getElementById("frm").submit();
    }else return ;
    
}

// 카드 정보 입력란 확인 
function goComfirm(){
    var erro1               = document.querySelector('.erro1'); // 에러 문구 태그
    var erro2               = document.querySelector('.erro2'); // 에러 문구 태그
    var nm                  = document.querySelector('.nm');
    var cardnum             = document.querySelector('.cardnum');
    var card_info_main      = document.querySelector('.card_info_main');
    var addr_info_main      = document.querySelector('.addr_info_main');
	var mop 				= document.getElementById('mop').value; // 결제 수단 
    var nmArr       =  nm.childNodes;
    var cardnumArr  =  cardnum.childNodes;
    var cardInfoArr =  card_info_main.childNodes;
    var addrInfoArr =  addr_info_main.childNodes;

    ymArr = cardInfoArr[1].value.split("/");

    if(nmArr[1].value == ''){ // 이름 미기입
        erro1.innerHTML = '이름을 확인 하세요.';
    }else if(cardnumArr[1].value == '' || cardnumArr[1].value.length != 19){  // 카드 번호 오류
        erro1.innerHTML = '카드 번호를 확인하세요.';
    }else if(cardInfoArr[1].value == '' || parseInt(ymArr[0])<=0 || parseInt(ymArr[0])>12 || parseInt(ymArr[1]) <=0 ){ // 만료일 오류
        erro1.innerHTML = '카드 유효기간을 확인하세요.';
    }else if(cardInfoArr[3].value == '' || cardInfoArr[3].value.length < 3){ // 카드 CVV번호 오류
        erro1.innerHTML = '카드 CVV번호를 확인하세요.';
    }else if(addrInfoArr[1].value == '' || addrInfoArr[1].value.length < 5){ // 우편 번호 오류
        erro2.innerHTML = '우편번호를 확인하세요.';
    }else if(addrInfoArr[3].value == ''){ // 국가 오류 
        erro2.innerHTML = '국가를 확인하세요.';
    }else if(mop != 0){
		erro2.innerHTML = '결재 수단을 바꾸세요.';
	}
    
    return deleteErro();

    
    

    /*
    console.log(nmArr[1]);
    console.log(cardnumArr[1]);
    console.log(cardInfoArr[1]);
    console.log(cardInfoArr[3]);
    console.log(addrInfoArr[1]);
    console.log(addrInfoArr[3]);
    */

}
// 에러 문구 삭제 기능 
function deleteErro(){
    var erro1               = document.querySelector('.erro1'); // 에러 문구 태그
    var erro2               = document.querySelector('.erro2'); // 에러 문구 태그
    var nm                  = document.querySelector('.nm'); // 이름 태그 
    var cardnum             = document.querySelector('.cardnum'); // 카드 번호 태그
    var card_info_main      = document.querySelector('.card_info_main'); //만료일/cvv 태그
    var addr_info_main      = document.querySelector('.addr_info_main'); // 우편 번호 태그
	var mop 				= document.getElementById('mop').value; // 결제 수단 
    var nmArr       =  nm.childNodes;
    var cardnumArr  =  cardnum.childNodes;
    var cardInfoArr =  card_info_main.childNodes;
    var addrInfoArr =  addr_info_main.childNodes;
    var retval = 0; // return 값  1 성공 0 실패

    ymArr = cardInfoArr[1].value.split("/");

    if(cardnumArr[1].value == '' && cardnumArr[1].value.length != 19){
        return 0;
        
    }else if(cardInfoArr[1].value == '' || parseInt(ymArr[0])<=0 || parseInt(ymArr[0])>12 || parseInt(ymArr[1]) <=0){
        return 0
    }else if(cardInfoArr[3].value == '' || cardInfoArr[3].value.length < 3){
        return 0
    }else{
        erro1.innerHTML = '';
        retval = 1;
    }
   

    if(addrInfoArr[1].value == '' || addrInfoArr[1].value.length < 5){
        return 0;
       
    }else{
        erro2.innerHTML = '';  
        retval = 1;
    }

	if(mop == 0){
		erro2.innerHTML = '';
		retval = 1;
	}else{
		return 0;
	}

    return retval;
    
}

function onlyNumber(event){
    if((event.keyCode<48)||(event.keyCode>57)){
        event.returnValue=false;
    }
}

function changeCard_num(ele){   
    if(ele.value.length > 19){
        ele.value = ele.value.slice(0,-1);
        return ;
    } else{
        //console.log(ele.value.length);
        switch(ele.value.length){
            case 4:
                ele.value += " " ;
                break;
            case 9:
                ele.value += " " ;
                break;
            case 14:
                ele.value += " " ;
                break;           
        }
    }
}

function changeYm(ele){
    
    if(ele.value != ""){
        var arr = ele.value.split("/"); 
        if(parseInt(arr[0])>=0 && parseInt(arr[0]) <= 1){ // 0~1 사이 월수는 11~12월 가능성 염두
            return;
        }
        if(ele.value.length > 5){ // 유효기간 문자길이 5이상 한칸 삭제 
            ele.value = ele.value.slice(0,-1);
            return ;
        }
        // 만료일 월수 계산
        arr[0] = (parseInt(arr[0]) >0 && parseInt(arr[0]) < 10) ? "0"+parseInt(arr[0])+"/" :  parseInt(arr[0])+"/";
        ele.value = arr[0];
        // 만료일 년수 계산
        if(arr[1] != undefined){
            if(arr[1].length <=1){ //  0~1 사이 년수는 11~12년 가능성 염두
                ele.value += arr[1];
            }else{
                arr[1] = (parseInt(arr[1]) >0 && parseInt(arr[1]) < 10) ? "0"+parseInt(arr[1]) :  parseInt(arr[1]);
          
                ele.value += arr[1];
            }
         
        }
    }
}

function changeCvv(ele){
    // cvv 번호는 3자리 초과 안된다.
    if(ele.value.length > 3){
        ele.value = ele.value.slice(0,-1);
    } 
}

function changeZip_code(ele){
     // 우편 번호는 5자리 초과 안된다.
    if(ele.value.length > 5){
        ele.value = ele.value.slice(0,-1);
    } 
}

