<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h2>프로필 사진</h2>
	<section id="content">
		<div>프로필 사진</div>
		<img id="userPro"  src="${loginUser.my_profile}" width="300px" height="300px">
		<button type="button" onclick="delImg()">X</button>
		<div><input type="file" id="img_url" onchange="saveImg()" accept="image/*" ></div>
	</section> 
</body>
<script>
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
				 var userPro = document.getElementById("userPro");
				 // url 삽입 
				 userPro.setAttribute("src",res.data.result);
			})
			return false; 
	}
	function delImg(){
		axios.get('/user/delProfile')
		  .then(function (res) {
			  console.log(res.data.result);
			  if(res.data.result == 1){ // 삭제 성공시
				  var userPro = document.getElementById("userPro");
					 // url 삽입 
					 userPro.setAttribute("src"," /resources/img/pimg.jpg");
			  }else{
				  alert("삭제 실패");
			  }
			 
		  });
		
	}
</script>
</html>