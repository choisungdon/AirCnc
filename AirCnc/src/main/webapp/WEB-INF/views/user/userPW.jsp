<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
   	.m_ctnt{
		display : none;
	} 
</style>
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
</head>
<body>
	<h2>로그인 및 보안</h2>
	<p>로그인</p>
	<div class="ctnt">비밀번호 <button type="button" onclick="upPW()">업데이트</button></div>
	<div class="m_ctnt">
		<span>비밀번호 </span> <button type="button" onclick="csPW()">취소</button>
		<div>현재 비밀번호</div>
		<input type="password" value="" id="c_pw" name="c_pw"> <span id="pw_ck"></span>
		<div>새 비밀번호</div>
		<input type="password" value="" id="r_pw" name="r_pw">
		<div>비밀번호 확인</div>
		<input type="password" value="" id="ck_pw" name="ck_pw">
		<div><button type="button" onclick="pwCahnge()">비밀번호 변경 </button></div>
	</div>
</body>
<script type="text/javascript">

	function upPW(){
		var ctnt 	= document.getElementsByClassName("ctnt")[0];
		var m_ctnt	= document.getElementsByClassName("m_ctnt")[0];
		// div 태그 style 변경 
		ctnt.style.display= "none";
		m_ctnt.style.display = "block";
	}
	
	function csPW(){
		var ctnt 	= document.getElementsByClassName("ctnt")[0];
		var m_ctnt	= document.getElementsByClassName("m_ctnt")[0];
		// div 태그 style 변경  
		ctnt.style.display= "block";
		m_ctnt.style.display = "none";
	}
	
	function pwCahnge(){
	
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
</script>
</html>