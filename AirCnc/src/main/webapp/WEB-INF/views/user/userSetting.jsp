<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userSetting</title>
<script src="https://kit.fontawesome.com/ea36f2192f.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="/resources/css/userSetting.css">
<script type="text/javascript" src="/resources/js/userSetting.js"></script>
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
    
                <div class="drop_menu" id="drop_menu">
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
    </header>

    <div class="container">
        <div class="set_title">
            <h1 class="setTitleMain">
                	계정
            </h1>
            <div class="setUserData">
                <span class="user_name">${loginUser.nm },</span>
                <span class="userEmail">${loginUser.e_mail } ·</span>
                <a class="linckPro" href="/user/userShow">프로필 이동</a>
            </div>
            <div class="linckTags">
                <di class="tags">
                    <a class="tag_item" href="/user/userInfo">
                        <div class="tagEmoge"><i class="fas fa-id-card fa-2x"></i></div>
                        <div class="itemTitle">개인 정보 ></div>
                        <div class="itemText">개인 정보및 연락처를 알려주세요.</div>
                    </a>
                    <a class="tag_item" href="/user/userPW">
                        <div class="tagEmoge"><i class="fas fa-shield-alt fa-2x"></i></div>
                        <div class="itemTitle">로그인 및 보안 ></div>
                        <div class="itemText">비밀번호를 변경하고 계정을 안전하게 보호하세요</div>
                    </a>
                </di>   
            </div>
        </div>
    </div>

    <footer>

    </footer>
</body>
</html>