<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>계정</p>
	<div>${loginUser.nm }님 ${loginUser.e_mail }<a href="/user/userShow">프로필 이동</a></div>
	<a href="/user/userInfo"><div>개인 정보</div></a>
	<a href="/user/userPW"><div>로그인 보안(PW 변경)</div></a>
</body>
</html>