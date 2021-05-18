

// 커버 사진 저장 
function saveImg(inputFile){
	
	// 첫이미지 업로드시 삭제
    var img_ctnt_item = inputFile.parentNode.parentNode;
    img_ctnt_item.remove();

    // nav_bar (다음 이전 버튼)
    var nepre_tag = document.querySelector('.nepre_tag');
	 // 이미지 추가하기 버튼(태그) 생성 
 	
    
    // 첫 이미지 태그 생성 
    // img 태그 

	// 숙소 i_host(pk)
	var i_host = document.getElementById("i_host").value;
	var check_index = 0;
	 Array.from(inputFile.files).forEach(file => { 
		
		var frm = new FormData();
        frm.append('photo', file);
		frm.append("i_host", i_host);
		
		// post 방식으로 전송 
		axios.post('/host/hostLast', frm, {
		  headers: {
		    'Content-Type': 'multipart/form-data'
		  }
		})
		.then((res) => {
			
			// 저장된 이미지 정보 초기화 
			var i_img	= res.data.result.i_img;
			var img_url	= res.data.result.img_url;
			// 메인 이미지 유무 체크 
			check_img = document.querySelector('.main_real_img');
	        if(check_img == undefined){ 
	            var main_real_img = createMRI(img_url,i_img);
	            nepre_tag.before(main_real_img);
	        }else{
				// 추가하기 버튼 유무 확인 
				var add_img = document.querySelector('.add_img');
				// 추가 이미지 태그 생성
	           	var side_real_img = createAddSri(img_url,i_img);
				if(add_img == undefined){ // 추가하기 버튼 없으면 버튼 생성 
					nepre_tag.before(createAddImg());
					// 만들어 놓은 추하기 버튼 태그 변수에 저장 
					add_img = document.querySelector('.add_img');
				}
				//추하기 버튼 태그 앞에 사이드 이미지 삽입 
				add_img.before(side_real_img); // 삽입 
				
	        }
			 
		})
		
    });
   
   
}

//사진 추가 
function addImg(inputFile){
    // nav_bar (다음 이전 버튼)
    var nepre_tag = document.querySelector('.nepre_tag');

    Array.from(inputFile.files).forEach(file => { 
		
		var frm = new FormData();
        frm.append('photo', file);
		frm.append("i_host", i_host.value);
		
		// post 방식으로 전송 
		axios.post('/host/hostLast', frm, {
		  headers: {
		    'Content-Type': 'multipart/form-data'
		  }
		})
		.then((res) => {
			
			// 저장된 이미지 정보 초기화 
			var i_img	= res.data.result.i_img;
			var img_url	= res.data.result.img_url;
			// 메인 이미지 유무 체크 
			check_img = document.querySelector('.main_real_img');
	        if(check_img == undefined){ 
	            var main_real_img = createMRI(img_url,i_img);
	            nepre_tag.before(main_real_img);
	        }else{
				// 추가하기 버튼 유무 확인 
				var add_img = document.querySelector('.add_img');
				// 추가 이미지 태그 생성
	           	var side_real_img = createAddSri(img_url,i_img);
				if(add_img == undefined){ // 추가하기 버튼 없으면 버튼 생성 
					nepre_tag.before(createAddImg());
					// 만들어 놓은 추하기 버튼 태그 변수에 저장 
					add_img = document.querySelector('.add_img');
				}
				//추하기 버튼 태그 앞에 사이드 이미지 삽입 
				add_img.before(side_real_img); // 삽입 
				
	        }
			 
		})
		
    });
}

// 이미지 삭제 

function delImg(el,pk){
	var img_tag = el.parentNode ;
	// db 삭제 및 파일 삭제 
	axios.get('/host/delRoomImg', {
	    params: {
	    	i_img:	pk,
	    	i_host: i_host.value
	    }
	  })
	  .then(function (res) {
		  // 성공시  img,버튼 태그 삭제 
	    if(res.data.result > 0){
	    	img_tag.remove();
	    }
		var main_real_img = document.querySelector('.main_real_img');
		if(main_real_img == undefined){
			// 메인 이미지가 없으면 새로고침 합니다. 
			location.reload();
		}
	  })
}

// 첫 이미지 태그 생성 함수
function createMRI(img_url,i_img){

    //이미지 넣을 메인 태그 
    var main_real_img = document.createElement('div');   
    main_real_img.setAttribute('class','main_real_img');
    // 버튼 
    var button = document.createElement('button');
    button.setAttribute('type','button');
	button.onclick = function(){
		delImg(button,i_img);
	}// 삭제 이벤트 삽입 
    // 버튼 이미지 
    var i = document.createElement('i');
    i.setAttribute('class','far fa-trash-alt');
    button.appendChild(i);

    var img = document.createElement('img');
    img.src = img_url;

    // 이미지 태그 완성 

    main_real_img.appendChild(button);
    main_real_img.appendChild(img);

    return main_real_img;
}

// 사이드 이미지 생성 
function createAddSri(img_url,i_img){
    //이미지 넣을 메인 태그 
    var side_real_img = document.createElement('div');   
    side_real_img.setAttribute('class','side_real_img');
    // 버튼 
    var button = document.createElement('button');
    button.setAttribute('type','button');
	button.onclick = function(){
		delImg(button,i_img);
	}// 삭제 이벤트 삽입 
	
    // 버튼 이미지 (휴지통)
    var i = document.createElement('i');
    i.setAttribute('class','far fa-trash-alt');
    button.appendChild(i);

    var img = document.createElement('img');
    img.src = img_url;

    // 이미지 태그 완성 
    side_real_img.appendChild(button);
    side_real_img.appendChild(img);

    return side_real_img;
}

// 추가하기 버튼 태그 생성 함수 
function createAddImg(){
    //이미지 넣을 메인 태그 
    var add_img = document.createElement('div');   
    add_img.setAttribute('class','add_img');
    
    // input flie
    var input = document.createElement('input');
    input.setAttribute("type",'file');
    input.setAttribute('multiple','multiple');
    input.setAttribute('id','multiple');
    input.setAttribute('name','multiple');
    input.onchange = function () {
        addImg(input);
    }
    // 추가 하기 누르면 input 박스 활성화 
    add_img.onclick = function(){
        input.click();
    }

    input.setAttribute('accept','image/*');
    // 이모지 태그 
    var i = document.createElement('i');
    i.setAttribute('class','fas fa-plus');
    // Text 
    var add_div = document.createElement('div');
    add_div.innerHTML = '추가하기';

    add_img.appendChild(input);
    add_img.appendChild(i);
    add_img.appendChild(add_div);
    
    return add_img;
}



window.onload = function(){
	// 저장 , 뒤로 버튼 이벤트 삽입 
	var previous	=	document.querySelector('.previous');
	var next		=	document.querySelector('.next');
	var nepre_tag	=	document.querySelector('.nepre_tag');
	
	previous.onclick = function(){
		location.href = "/host/hostSaveEight?i_host="+i_host.value;
		
	}
	next.onclick = function(){
		nepre_tag.submit();
	}
}
/*

*/

