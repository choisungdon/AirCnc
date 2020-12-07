function viewMenu(){
    var drop_menu = document.querySelector('.drop_menu');

    if(drop_menu.style.display != 'block'){
        drop_menu.style.display= 'block';
    }else{
        drop_menu.style.display = 'none';
    }
}


function saveImg(){
    var frm = new FormData();
    // 파일 이름 
    var userPro = document.getElementById("img_url");
    
    frm.append("userPro", userPro.files[0]);
    
    axios.post('/user/userProfile', frm, {
          headers: {
            'Content-Type': 'multipart/form-data'
          }
        })
        .then((res) => {
             var userPro = document.querySelector('.userPro');
			 var my_profile = document.querySelector('.my_profile');
             // url 삽입 
             userPro.setAttribute("src",res.data.result);
			 my_profile.setAttribute("src",res.data.result);
        })
        return false; 
}
function delImg(){
    axios.get('/user/delProfile')
      .then(function (res) {
          console.log(res.data.result);
          if(res.data.result == 1){ // 삭제 성공시
              	var userPro = document.querySelector('.userPro');
 				var my_profile = document.querySelector('.my_profile');
                 // url 삽입 
                 userPro.setAttribute("src","/resources/img/pimg.jpg");
				 my_profile.setAttribute("src",'/resources/img/pimg.jpg');
          }else{
              alert("삭제 실패");
          }
         
      });
    
}