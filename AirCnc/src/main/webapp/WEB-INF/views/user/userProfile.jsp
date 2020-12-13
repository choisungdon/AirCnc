<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userProfile</title>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script src="https://kit.fontawesome.com/ea36f2192f.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="/resources/css/userProfile.css">
<script type="text/javascript" src="/resources/js/userProfile.js"></script>
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
        <div class="set_title">
            <div class="setLinck">
                <a class="linckPro" href="/user/userShow">프로필</a>
                <span class="aroow">></span>
                <span class="pro_text">프로필 사진</span>
            </div>

            <h1 class="setTitleMain">
                	프로필 사진
            </h1>

            <div class="profile_container">
               <div class="panel_header">
                 	프로필 사진
               </div>
               <div class="pro_img_ctnt">

                    <div class="img_ctnt_main">
                        <div class="img_ctnt_main_item">
                            <button type="button" onclick="delImg()"><i class="far fa-trash-alt"></i></button>
                            <img class="userPro"  src="${loginUser.my_profile}" >
                        </div>
                        
                    </div>

                    <div class="img_ctnt_sub">
                        <div class="sub1">
                           	 얼굴이 나온 프로필 사진을 통해서 다른 호스트와 게스트에게 나를 알릴 수 있습니다. 모든 에어비앤비 호스트는 프로필 사진이 있어야 합니다. 에어비앤비는 게스트에게 프로필 사진을 요청하지 않지만, 호스트는 요청할 수 있습니다. 호스트가 게스트에게 사진을 요청하는 경우에도, 예약이 확정된 후에만 사진을 볼 수 있습니다.
                        </div>
                        <div class="sub2">
                            <input type="file" id="img_url" onchange="saveImg()" accept="image/*" style="display:none" >
                            <button type="button" onclick="document.getElementById('img_url').click();">파일 업로드하기</button>
                        </div>
                    </div>

               </div>
            </div>
        </div>
    </div>

    <footer>
        <i class="fab fa-airbnb fa-lg"></i>© 2020 Airbnb, Inc. All rights reserved.
    </footer>
</body>
</html>