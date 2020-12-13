<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RecComfirm</title>
    <script src="https://kit.fontawesome.com/ea36f2192f.js" crossorigin="anonymous"></script>
    <script type="text/javascript" src="/resources/js/recomfirm.js"></script>
    <link rel="stylesheet" href="/resources/css/recomfirm.css">
</head>
<body>
    <header>
        <div class="sub_header">
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
        <h1 class="title">예약 취소 및 변경 절차</h1>
        <div class="step1_emoge">
            <i class="fas fa-check-circle fa-lg"></i> 
            <span>- 예약 변경 및 취소 신청</span>
        </div>
        <div class="step1"></div>
        <div class="step2_emoge">
            <i class="fas fa-check-circle fa-lg"></i>
            <span>- Host 숙소 주인 확인</span>
        </div>
        <div class="step2"></div>
        <div class="step3_emoge">
            <i class="fas fa-check-circle fa-lg"></i>
            <span>- 예약 취소 및 변경 완료</span>
        </div>
        <div class="ctnt_btn">
            <span class="btn" onclick="goTrb()">확인</span>
        </div>
    </div>

    <footer>
        
    </footer>
    
</body>
</html>