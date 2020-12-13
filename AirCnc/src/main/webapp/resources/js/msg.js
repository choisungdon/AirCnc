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

function viewMenu(){
    var drop_menu = document.querySelector('.drop_menu');

    if(drop_menu.style.display != 'block'){
        drop_menu.style.display= 'block';
    }else{
        drop_menu.style.display = 'none';
    }
}

function hide_retalk(){
    var msg_ctnt3 = document.querySelector(".msg_ctnt3");
    var arrow = document.querySelector(".arrow");

    msg_ctnt3.style.display= 'none';
    arrow.style.display = 'block';
}

function arrowButton(){
    var msg_ctnt3 = document.querySelector(".msg_ctnt3");
    var arrow = document.querySelector(".arrow");

    msg_ctnt3.style.display= 'flex';
    arrow.style.display = 'none';

}

function goHome(){
    location.href="/";
}

function viewFilter(){
    var drop_filter = document.querySelector(".drop_filter");
    if(drop_filter.style.display != 'block'){
        drop_filter.style.display= 'block';
    }else{
        drop_filter.style.display = 'none';
    }
}

function alllMsg(){
    var msg_title = document.querySelector(".th_msg_title");
    var m_msg_ctnt1_1 = document.querySelector(".m_msg_ctnt1_1");//보이는 태그 
    var m_msg_ctnt1_2 = document.querySelector(".m_msg_ctnt1_2");// 숨기는 태그
    var drop_filter = document.querySelector(".drop_filter"); // filter 메뉴 

    m_msg_ctnt1_1.style.display= 'block';
    m_msg_ctnt1_2.style.display= 'none';
    drop_filter.style.left= '260px';

    msg_title.childNodes[1].innerHTML = '메시지 주고받기' // 제목 태그 
    
}

function unreadMsg(){
    var msg_title = document.querySelector(".th_msg_title");
    var m_msg_ctnt1_1 = document.querySelector(".m_msg_ctnt1_1"); // 숨기는 태그
    var m_msg_ctnt1_2 = document.querySelector(".m_msg_ctnt1_2"); // 보이는 태그
    var drop_filter = document.querySelector(".drop_filter"); // filter 메뉴 
    
    m_msg_ctnt1_1.style.display= 'none';
    m_msg_ctnt1_2.style.display= 'block';
    drop_filter.style.left = '150px';

    msg_title.childNodes[1].innerHTML = '읽지 않음' // 제목 태그 

}

var socket  = 0;



function viewMsg(i_mlist,my_i_user){
	var void_msg 	= document.querySelector(".void_msg");
	var msg_text 	= document.querySelector(".msg_text");
	var msg_throws	= document.querySelector(".msg_throws");
	// 메시지 창 보이기 
	void_msg.style.display= 'none';
	msg_text.style.display= 'flex';
	msg_throws.style.display= 'flex';
	// msg_text 메시지 내용 지우기 
	msg_text.innerHTML= '';
	
	axios.get('/message/selMsgList', {
		    params: {
		      i_mlist: i_mlist
		    }
	  })
	  .then(function (res) {
	    //console.log(res.data.result);
		var input1 = document.createElement("input");
		var input2 = document.createElement("input");
		res.data.result.forEach(function(items){
			var div = document.createElement("div");
			
			if(my_i_user != items.i_user){
				div.setAttribute('class','arrow_box_left');
			}else{
				div.setAttribute('class','arrow_box_right');
			}
			//console.log(items.cmt);
			div.innerHTML = items.cmt;
			// 톡 내용 삽입 
			msg_text.appendChild(div);
			
		});
		//console.log(res.data.opt);
		// 상대방 i_user, 방 번호 i_mlist 삽입
		input1.setAttribute('type','hidden');
		input1.setAttribute('id','opponent');
		input1.setAttribute('value',res.data.opt == null ? 0 : res.data.opt.i_user ); //상대방 i_user 삽입  
		msg_text.appendChild(input1);
		input2.setAttribute('type','hidden');
		input2.setAttribute('id','i_mlist');
		input2.setAttribute('value',i_mlist);
		msg_text.appendChild(input2);
		
	  })
	// 소켓 연결 실행 
	connect(i_mlist);
}

// 메시지 전송 버튼 
function msg_thorow(){
	var msg_text 	= document.querySelector(".msg_text"); // 메시지 담길 태그
	if (socket.readyState !== 1) return;
	
  	var msgData  = document.getElementById('msg').value; // 보낸 text
	msgData += "/"+opponent.value+"/"+i_mlist.value; // 받는 사람 i_user, 대화방 번호 
 	socket.send(msgData); // 소켓 sendmsg 
	saveMsg(document.getElementById('msg').value,i_mlist.value);
}
// 메시지 입력한 데이터 저장 
function saveMsg(cmt,i_mlist){
	axios.get('/message/saveMsg', {
	    params: {
			cmt : cmt,
	      	i_mlist: i_mlist
	    }
	})
	  .then(function (res) {
			//console.log(res.data.result);
			if(res.data.result != 0){
				var msg_text = document.querySelector(".msg_text");
				var div = document.createElement("div");
				div.setAttribute('class','arrow_box_right');
				div.innerHTML = document.getElementById('msg').value;
				msg_text.append(div);
				document.getElementById('msg').value = '';
				div.focus();
			}
	})
}


function msgOut(i_mlist,my_i_user,ele){

	var void_msg 	= document.querySelector(".void_msg");
	var msg_text 	= document.querySelector(".msg_text");
	var msg_throws	= document.querySelector(".msg_throws");
	
	if (socket.readyState !== 1) {
		alert('톡방을 클릭 해주세요.');
		return ;
	};
	
	ele.parentNode.remove();
	void_msg.style.display= 'block';
	msg_text.style.display= 'none';
	msg_throws.style.display= 'none';
	
	var msgData  = '유저가 카톡방을 나갔습니다.'; // 보낸 text
	msgData += "/"+opponent.value+"/"+i_mlist; // 받는 사람 i_user, 대화방 번호 
 	socket.send(msgData); // 소켓 sendmsg 
	
	// 메시지 내용 삭제 
	axios.get('/message/msgout', {
		 params: {
		      i_mlist: i_mlist,
			  i_user : my_i_user
		    }
	})
	.then(function (res) {
		//console.log(res.data.result);
		if(res.data.result != 0){
			saveMsg('유저가 카톡방을 나갔습니다.',i_mlist);
		}
	})
	
}
		


// 소켓 연결 
function connect(i_mlist){
	// 소켓 연결 uri
	var ws = new WebSocket("ws://www.aircnc.co.kr:8090/echo?i_mlist="+i_mlist);
	socket = ws;
	
	ws.onopen = function () {
	    console.log('Info: 소켓 연결.');
		
		ws.onmessage = function (event) {
	        //console.log(event.data+'\n');
			var data = event.data.split('/');
			 if(data[2] == i_mlist){
				var msg_text = document.querySelector(".msg_text");
				var div = document.createElement("div");
				div.setAttribute('class','arrow_box_left');
				div.innerHTML = data[1];
				msg_text.append(div);
				console.log(data[0]+'님이 :'+data[1]+'라고 보냈습니다.');
			}
	   	};
	};

	ws.onclose = function (event) { 
		console.log('Info: 소켓 끊어짐.'); 
		setTimeout( function(){ connect(i_mlist); }, 1000); // retry connection!!
	};
	
	ws.onerror = function (erro) { console.log('Erro: ',erro); };

}





