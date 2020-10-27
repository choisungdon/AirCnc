<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="/resources/img/pinklogo.ico">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/resources/css/wishlists.css">

<title>Wishlists - AirCnC</title>
<!-- axios 태그 -->
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
</head>
<body>
<container id="container">
	<header>
		<div>
			<img id="logo" onclick="goIndex()" src="/resources/img/pinklogo.png">
		</div>
        <div id="menubutton" onclick="myMenu()">
            <div><img id="ham" src="/resources/img/bars-solid.svg"></div>
            <div id="profile">
                <img src="${loginUser.my_profile}">
            </div>
        </div>
        <div id="menuctnt">
            <c:if test="${loginUser.i_user != null}">
		         <li class="b" onclick="goMsg()">메시지</li>
		         <li class="b" onclick="goWish()">저장 목록</li>
		         <div class="line">――――――――――――――――</div>
		         <li class="b" onclick="goHost()">숙소 관리</li>
		         <li class="b" onclick="goUser()">계정</li>
		         <div class="line">――――――――――――――――</div>
		         <li class="b" onclick="goLogOut()">로그아웃</li>
		    </c:if>
        </div>
	</header>
	<div id="head2">
		<div id="title">저장 목록</div>
		<div id="button" onclick="openCreater()">목록 만들기</div>
    </div>
    <div id="body">
    <form id="creater" action="/wishlists" method="post" onsubmit="return subalert()">
            <div id="box1">
                <div id="boxExit" onclick="boxExit()"><img src="/resources/img/times-solid.svg"></div>
                <div id="boxtitle">목록 만들기</div>
            </div>
            <div class="line">―――――――――――――――――――――――――</div>
            <div id="box2">
                <div id="b2textbox">
                    <div id="b2label">이름</div>
                    <input type="text" id="list_title" name="list_title" placeholder="예: 여름 휴가">
                </div>
            </div>
            <div class="line">―――――――――――――――――――――――――</div>
            <div id="box3">
                <div id="boxClose" onclick="boxClose()">취소</div>
                <input type="submit" id="insLList" onclick="subalert()" value="저장">
            </div>
        </form>
	<c:forEach var="list" items="${lists}">
		<div class="listbox" onclick="goWishDetail(${list.i_list})">
            <div class="limg"><img src="${list.like_profile}"></div>
          <div class="ltext">
			<div class="title">${list.list_title}</div>
            <div class="cnt">
            ${list.host_count == 0 ? "저장된 항목이 없습니다." : "숙소 "}
            ${list.host_count == 0 ? "" : list.host_count}
          	${list.host_count == 0 ? "" : "개"}
            </div>
         </div>
		</div>
    </c:forEach>
    </div>
</container>
<script type="text/javascript" src="/resources/js/wishlists.js"></script>
</body>
</html>