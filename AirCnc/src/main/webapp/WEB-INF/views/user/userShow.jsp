<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userShow</title>
<script src="https://kit.fontawesome.com/ea36f2192f.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="/resources/css/userShow.css">
<script type="text/javascript" src="/resources/js/userShow.js"></script>
</head>
<body>
	<header>
        <div class="head_main">
            <a href="/" class="logo"> 
                <span>
                   <img src="/resources/img/aircncLog.png">
                </span>
            </a>
            <span class="top_menu" onclick="viewMenu()">
                <img class="hamMenu" src="/resources/img/bars-solid.svg"  height="16px" width="16px">
            	<img class="my_profile" src="${loginUser.my_profile}" height="30px" width="30px">
    
                <div class="drop_menu" >
					<div class="main_menu">
						<div class="menu_item1" onclick="goMsg()">메시지</div>
						<div class="menu_item2" onclick="goTrb()">여행</div>
						<div class="menu_item3" onclick="goWish()">저장 목록</div>
						<div class="menu_item4" onclick="goHost()">숙소 관리</div>
						<div class="menu_item5" onclick="goUser()">계정</div>
						<div class="menu_item6" onclick="goLogOut()">로그아웃</div>
				    </div>
				</div>
            </span>
        </div>
    </header>

    <div class="container">
        <div class="pro_ctnt">
            <div class="pro_ctnt_main">
                <img  src="${loginUser.my_profile}">
                <a href="/user/userProfile">사진 업데이트하기</a>
            </div>

            <div class="pro_ctnt_sube">
                <div class="sube_item1">${loginUser.nm} 인증 완료</div>
                <c:choose>
                	<c:when test="${data.emailConfirm eq null && data.emailConfirm eq ''}">
                		<div class="sube_item2"><i class="fas fa-ban"></i> 이메일 주소</div>
                	</c:when>
                	<c:otherwise>
                		<div class="sube_item2"><i class="fas fa-check"></i> 이메일 주소</div>
                	</c:otherwise>
                </c:choose>
                <c:choose>
                	<c:when test="${data.phConfirm eq null && data.phConfirm eq ''}">
                		<div class="sube_item3"><i class="fas fa-ban"></i> 전화번호</div>
                	</c:when>
                	<c:otherwise>
                		<div class="sube_item3"><i class="fas fa-check"></i> 전화번호</div>
                	</c:otherwise>
                </c:choose>
            </div>
        </div>

        <div class="user_info">
            <div class="info_main">
                <h1>안녕하세요. 저는 ${loginUser.nm}입니다.</h1>
                <div>회원 가입: ${data.join_date}</div>
            </div>
            <div class="review_qty">
                <h2><i class="fas fa-star"></i> 후기 ${data.count}개</h2>
            </div>
            <div class="review_linck">
                <a href="/user/userReview">내가 작성한 후기 </a>
            </div>
        </div>
    </div>

    <footer>

    </footer>

</body>
</html>