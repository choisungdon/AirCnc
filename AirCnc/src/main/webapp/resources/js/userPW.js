function viewMenu(){
    var drop_menu = document.querySelector('.drop_menu');

    if(drop_menu.style.display != 'block'){
        drop_menu.style.display= 'block';
    }else{
        drop_menu.style.display = 'none';
    }
}

// 업데이트 버튼 함수 
function dropData(ele){
    var ctnt_itme = ele.parentNode.parentNode;
    var cit_arr = ctnt_itme.children;

    var itme3 = cit_arr[1]; // 정보 수정란 
    var item2 =  cit_arr[2]; // 정보 수정 완료란
    
    
    if(ele.innerHTML == '업데이트'){
       
        ele.innerHTML = '취소';
        item2.style.display = 'none';
        itme3.style.display = 'block';
    }else{
       
        ele.innerHTML = '업데이트';
        item2.style.display = 'block';
        itme3.style.display = 'none';
    }
}

function saveEmail(ele){
    // 수정한 이름 
    var c_pw = document.querySelector('#c_pw'); // 현재 pw
    var r_pw = document.querySelector('#r_pw'); // 변경 pw
    var ck_pw = document.querySelector('#ck_pw');// 확인 pw
	
	switch(c_pw.value){
		case '' :
			alert("기존 PW를 기입 하시오.");
			return false;
		default :
			if(r_pw.value != ''){
				if(r_pw.value != ck_pw.value){
					alert("변경 PW와 확인 PW가 서로 맞지 않습니다.");
					return false;
				}else{
					// PW 변경 
					axios.get('/user/userPWCahnge', {
				    params: {
				    	c_pw : c_pw.value,
				    	r_pw : r_pw.value
				    }
				  })
				  .then(function (res) {
				    console.log(res.data.result);
				    switch (res.data.result) {
					case 1:
						res = "PW 변경 완료";
						alert(res);
						location.href="/logOut";
						break;
					case 2:
						res = "이전 패스워드가 정확하지 않습니다. 다시 입력해 주세요.";
						alert(res);
						c_pw.value="";
						break;
					default:
						res = "DB 오류";
						alert(res);
						break;
					}
				  })
				}
				break;
			}else{
				alert("변경 PW를 기입하시오.");
				 return false;
			}
		}

}