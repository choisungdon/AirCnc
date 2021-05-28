function checkBox (label,checkBox){
    // 이모티콘 check uncheck 변경
    if(label.className == 'far fa-square fa-2x'){ // 체크가 안되있으면 
        label.className = 'far fa-check-square fa-2x'; // 체크 
    }else{
        label.className = 'far fa-square fa-2x'; // 체크 X
    }
    // 서버에 넘길 input checkbox true false 결정 
    if(checkBox.checked == false){
        checkBox.checked = true;
    }else{
        checkBox.checked = false;
    }
    
}

function insRul(){
    // 추가 규칙 내용
    var rule	= document.getElementById('dtl_text'); // 내용
    var i_host	= document.getElementById("i_host").value; // 숙소 pk
	//console.log(rule);
	
    //규칙 넣을 태그
    var dtl_cnt = document.querySelector('.dtl_cnt');
    

	// db 저장 
		axios.get('/host/insDtlRule', {
		    params: {
		    	i_host: i_host,
				rule: rule.value
		    }
		  })
		  .then(function (res) {
		    console.log(res.data.result);
		    var pk 		= res.data.result.i_drule;
		    var rule	= res.data.result.rule;
		    
		   // 추가  규칙 삽입 
		    var div 	= document.createElement("div");
		    div.setAttribute("class","dtl");
		    // 추가 규칙 내용
		    var span 	= document.createElement("span");
		    span.setAttribute("class","dtl_text");
		    span.innerHTML= rule;
		    // 버튼 이벤트 함수에 규칙 테이블 pk 삽입 
		    var button = document.createElement("i");
		    button.setAttribute("class","fas fa-times fa-lg");
		    button.setAttribute("onclick","delRule(this,"+pk+")");
		    
		    div.appendChild(span);
		    div.appendChild(button);
		    dtl_cnt.appendChild(div);
			
		  })
		  
		rule.value=""; //입력된 내용 지우기
		return false;	 
    
}

function delRule(el,pk){
	// 추가 규칙을 감싸고 있는 부모태그 
	var dtl = el.parentElement;
    //console.log(dtl);
	
	// db 삭제 
	axios.get('/host/delDtlRule', {
	    params: {
	    	i_drule: pk
	    }
	  })
	  .then(function (res) {
	    console.log(res.data.result);
	  })
		
    // 규칙 삭제 
    dtl.remove(); 

}

// 뒤로 가기 (5단계로 갑니다.)
function backPage(i_host,i_sinfo){
    location.href = " /host/hostSaveFour?i_host="+i_host+"&i_sinfo="+i_sinfo;
}


window.onload = function(){
	var next		=	document.querySelector('.next'); // 다음 태그 
	var hostSave	=	document.querySelector('.hostSaveFive'); // form 태그 
	
	
	next.onclick = function(){ // 다음 
		hostSave.submit();
	}
}