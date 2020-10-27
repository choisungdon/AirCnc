function goIndex() {
	location.href="/";
}
// dropDown 메뉴 켜기 크기
function myMenu() {
	display = document.getElementById("menuctnt").style.display;
	if(display == 'block'){
		document.getElementById("menuctnt").style.display='none';
	}else{
		document.getElementById("menuctnt").style.display='block';
	}
}
//저장목록 리스트 추가
function openCreater() {
	display = document.getElementById("creater").style.display;
	if(display =='block') {
		document.getElementById("creater").style.display='none';
	} else {
		document.getElementById("creater").style.display='block';
	}
}
function boxClose() {
	display = document.getElementById("creater").style.display = 'none';
	if (display == 'block') {
		document.getElementById("creater").style.display = 'none';
	}
}
function boxExit() {
	display = document.getElementById("creater").style.display = 'none';
	if (display == 'block') {
		document.getElementById("creater").style.display = 'none';
	}
}
// 제출할 때 이름칸이 비어있으면 alert
function subalert() {
	var name = creater.list_title.value;
	if (name == '') {
		alert("리스트 이름을 입력해주세요.");
		return false;
	}
}
function goWishDetail(i_list) {
	location.href="/wishlists/detail?i_list="+i_list;
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