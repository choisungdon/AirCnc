function goIndex() {
	location.href="/";
}
function myMenu() {
	display = document.getElementById("menuctnt").style.display;
	if(display == 'block'){
		document.getElementById("menuctnt").style.display='none';
	}else{
		document.getElementById("menuctnt").style.display='block';
	}
}
// 뒤로 가기 function 
function goBack(){
	window.history.back();
}
// slide Show box 
var slideIndex = 1;

function nextSlides(n,index){
	showSlides(slideIndex += n,index);
}

function showSlides(n,index){
	var sContainer = document.querySelector('#slideContents'+index);
	var slides = sContainer.getElementsByClassName("roomSlide");
	// 숙소 이미지 갯수보다 많거나 적으면 index 변경 
	if (n > slides.length) {slideIndex = 1} 
  	if (n < 1) {slideIndex = slides.length} 
	
	for (var i = 0; i < slides.length; i++) {
      slides[i].style.display = "none";  
  	}
	
	slides[slideIndex-1].style.display = "block"; 
}

// layer popup Like
function like(likeTag){
	var popup1 = document.querySelector(".popup1");
	var popup1 = document.querySelector(".popup1");
	var ctButton = document.getElementById("ctButton"); // 목록 만들기 버튼 
	var sLikeButton = document.getElementById("sLikeButton"); // 새로 만들기 번튼 
	var likUser = likeTag.nextElementSibling; // 좋아요 상태 값 태그 
	var i_host	= likUser.nextElementSibling; // 숙소 pk
	var titleTag = popup1.querySelectorAll(".like_list");
	var title = document.getElementById("list_title");// 저장 목록 title
	var afList = document.getElementById("afList");// hr 태그 
	
	if(likUser.value == 0){
		popup1.style.display= 'block';
		
		// 기존 목록에 저장 이벤트 추가
		titleTag.forEach(function(element){
			element.onclick = function() { SaveLList(element.nextElementSibling.value,i_host.value,popup1,likeTag,likUser) };
		});
		
		// 목록 만들기 클릭시 
		ctButton.addEventListener('click', function(event){
        	//alert('Hello world, '+event.target.value);
			popup1.style.display = 'none';
			popup2.style.display = 'block';
    	});
		// 새로 만들기 
		sLikeButton.addEventListener('click', function(event){
        	//alert('Hello world, '+event.target.value);
			if(title.value == ''){
				alert("제목을 설정하세요.");
				title.focus();
				return false;
			}
			axios.get('/user/likelist', {
				params: {
					i_host	: i_host.value,
					title 	: title.value
				}
			 })
			  .then(function (res) {
			    console.log(res.data.result);
				if(res.data.result == 0){
					alert("DB 오류");
					return false;
				}else{
					popup2.style.display='none';
					likeTag.style.color = 'red';
					likUser.value = 1;
					// 저장 목록 태그 생성 
					var div = document.createElement("div");
					div.setAttribute("class","like_list")
					div.innerHTML = title.value;
					var input = document.createElement("input");
					input.setAttribute("type","hidden");
					input.setAttribute("id","i_list");
					input.setAttribute("value",res.data.result);
					afList.after(input);
					afList.after(div);
				}
			  })
    	});
		
	}
	else{
		axios.get('/user/disLike', {
			params: {
				i_host	: i_host.value
			}
		  })
		  .then(function (res) {
		    console.log(res.data.result);
				if(res == 0){
					alert("DB 오류");
				}else{
					likeTag.style.color = 'gray';
					likUser.value = 0// 좋아요 비활성화 
				}
		  })
	}

}

function SaveLList(i_list,i_host,popup1,likeTag,likUser){
	axios.get('/user/llSave', {
		params: {
			i_host	: i_host,
			i_list	: i_list
		}
	 })
	 .then(function (res) {
		    console.log(res.data.result);
				if(res == 0){
					alert("DB 오류");
				}else{
					popup1.style.display = 'none';
					likeTag.style.color = 'red';
					likUser.value = 1// 좋아요 활성화 
				}
			
		})
	
}

function popClose(ele){
	 var parent = ele.parentNode.parentNode;
	 parent.style.display='none';
}

function reser(i_host){
	location.href="/search/searchDetail?i_host="+i_host
}

// menuctnt 버튼 함수 

// 메뉴-저장 목록으로 이동
function goWish() {
	location.href = '/wishlists';
}
// 메시지 화면 이동
function goMsg() {
	location.href = '/aircnc/message';
}
// 숙소 관리 
function goHost(){
	location.href='/hostManage/manage';
}
// 계정 
function goUser(){
	location.href="/user/userSetting";
}
// logout
function goLogOut(){
	location.href="/logOut";
}