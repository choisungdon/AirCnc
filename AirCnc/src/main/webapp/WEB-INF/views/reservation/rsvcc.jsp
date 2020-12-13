<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Rsv Cahnge or Cancel</title>
    <script src="https://kit.fontawesome.com/ea36f2192f.js" crossorigin="anonymous"></script>
    <script type="text/javascript" src="/resources/js/rsvcc.js"></script>
    <link rel="stylesheet" href="/resources/css/rsvcc.css">
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
        <div class="ctnt_main">
            <h1 class="title">
                	${data.room_title}의 ${data.date}박
            </h1>
            <div class="date">
                ${data.chin }일 부터 ${data.chout }일 까지
            </div>
            <div class="main_item">
                <div class="change">
                    <div class="change_item">
                        <div class="imoge"><i class="fas fa-home fa-3x"></i></div>
                        <div class="item_title">예약 변경</div>
                        <div class="text">날짜나 숙박 인원 변경 요청하기</div>
                        <div class="btn" onclick="rsvChange(${data.i_reser})">
                            <span>다음 단계</span> 
                        </div>
                    </div>
                </div>

                <div class="cancel">
                    <div class="cancel_item">
                        <div class="imoge"><i class="fas fa-ban fa-3x"></i></div>
                        <div class="item_title">예약 취소</div>
                        <div class="text">예약이 최종적으로 취소되기 전에 모든 내용을 다시 검토할수 있습니다. </div>
                        <div class="btn" onclick="cancel(${data.i_reser})">
                           <span>다음 단계</span> 
                        </div>
                    </div>
                </div>
            </div>
            
        </div>
    </div>

    <footer>

    </footer>
</body>
</html>