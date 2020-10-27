<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage</title>
    <script src="https://kit.fontawesome.com/ea36f2192f.js" crossorigin="anonymous"></script>
    <script type="text/javascript" src="/resources/js/manage.js"></script>
    <link rel="stylesheet" href="/resources/css/manage.css">
</head>
<body>
    <header>
        <div class="sub_header">
            <div class="log_menu">
                <a href="/" class="logo">
                    <span >
                        <img src="/resources/img/aircncLog.png">
                    </span>
                </a>
                <div class="notice" onclick="goManage()">알림</div>
                <div class="rsv" onclick="goRSV(${loginUser.i_user})">예약</div>
                <div class="house" onclick="goHouse(${loginUser.i_user})">숙소</div>
                <div class="profit" onclick="goProfit(${loginUser.i_user})">실적</div>
            </div>

            <div class="top_menu">
                <a href="/host/hosting?i_user=${loginUser.i_user}" class="hSaveBtn">
                    <span class="hSaveBtn">숙소 등록하기</span>
                </a>
               

                <span class="userMenu" onclick="viewMenu()">
                    <img class="hamMenu" src="/resources/img/bars-solid.svg"  height="16px" width="16px">
            		<img class="my_profile" src="${loginUser.my_profile}" height="30px" width="30px">

                    <div class="drop_menu" >
                        <div class="main_menu">
    
                            <div class="menu_item">
                                <div>메시지</div>
                                <div>저장 목록</div>
                            </div>
    
                            <div class="menu_item">
                                <div>숙소 관리</div>
                                <div>계정</div>
                            </div>
    
                            <div class="menu_item">
                              <div>로그아웃</div>
                            </div>
    
                        </div>
                    </div>
                </span>
            </div>
        </div>
    </header>
    <div class="container"> 
        <div class="mwt4r90">
            <h1>알림판</h1>
            <section>
                <div class="box_rsvcc">
                    <h1>예약 변경및 취소 요청</h1>
                    <c:if test="${rsvCcData <= 0}">
                    	<div class="null">지금 회원님이 취하실 조치는 없습니다. 전부 준비됐습니다.</div>
                    </c:if>
                    
                    <c:if test="${rsvCcData > 0}">
                    	<div class="issue" onclick="goRSV(${loginUser.i_user})">
                    		지금 회원님이 취하실 조치 ${rsvCcData}개
                    	</div>
                    </c:if>
                </div>
                <div class="box_rsv">
                    <h1>예약</h1>
                    <c:if test="${rsvData <= 0}">
                    	<div class="null">예정된 예약이 없습니다.</div>
                    </c:if>
                    
                    <c:if test="${rsvData > 0}">
                    	<div class="issue" onclick="goRSV(${loginUser.i_user})">예정된 예약 ${rsvData}개 </div>
                    </c:if>
                    
                </div>
            </section>
        </div>
    </div>
    <footer>

    </footer>
</body>
</html>