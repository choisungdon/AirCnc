<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>안녕하세요 . ${loginUser.nm }님</p>
<div>
	<img src="${loginUser.my_profile}" width="300px" height="300px">
</div>
<div>
	<button type="button" onclick="goProfile()">사진 업데이트</button>
</div>
<div>후기</div>
<section>
	유저가 작성한 후기 들
</section>

</body>
<script>
	function goProfile(){
		location.href="/user/userProfile";
	}
</script>
</html>