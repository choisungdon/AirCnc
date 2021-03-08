

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

	// 숙소 i_host
	var i_host = document.getElementById("i_host").value;
	
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
			var i_img	= res.data.result.i_img;
			var img_url	= res.data.result.img_url;
			check_img = document.querySelector('.main_real_img');
	        if(check_img == undefined){ 
	            var main_real_img = createMRI(img_url,i_img);
	            nepre_tag.before(main_real_img);
	        }else{
	           var side_real_img = createAddSri(img_url,i_img);
	           nepre_tag.before(side_real_img);
				 nepre_tag.before(createAddImg());
	        }
			 
		})
		
    });
   
   
}

//사진 추가 
function addImg(inputFile){
    // nav_bar (다음 이전 버튼)
    var nepre_tag = document.querySelector('.nepre_tag');

    arr_files = inputFile.files;
    for (var i = 0; i < arr_files.length; i++) {
        nepre_tag.before(createAddSri(arr_files[i]));
        
    }
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
    // 버튼 이미지 
    var i = document.createElement('i');
    i.setAttribute('class','far fa-trash-alt');
    button.appendChild(i);

    // 이미지 숙소 pk 들 (input)
    var i_img = document.createElement('input');
    i_img.setAttribute('type','hidden');
    i_img.setAttribute('id','i_img');
    i_img.value = i_img;

   

    var img = document.createElement('img');
    img.src = img_url;

    // 이미지 태그 완성 

    main_real_img.appendChild(button);
    main_real_img.appendChild(i_img);
    main_real_img.appendChild(img);

    return main_real_img;
}

// 추가하기 버튼 태그 생성 함수 
function createAddSri(img_url,i_img){
    //이미지 넣을 메인 태그 
    var side_real_img = document.createElement('div');   
    side_real_img.setAttribute('class','side_real_img');
    // 버튼 
    var button = document.createElement('button');
    button.setAttribute('type','button');
    // 버튼 이미지 
    var i = document.createElement('i');
    i.setAttribute('class','far fa-trash-alt');
    button.appendChild(i);

    // 이미지 숙소 pk 들 (input)
    var i_img = document.createElement('input');
    i_img.setAttribute('type','hidden');
    i_img.setAttribute('id','i_img');
    i_img.value = i_img;

    var img = document.createElement('img');
    img.src = img_url;

    // 이미지 태그 완성 
    side_real_img.appendChild(button);
    side_real_img.appendChild(i_img);
    side_real_img.appendChild(i_host);
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


