<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userPW</title>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script src="https://kit.fontawesome.com/ea36f2192f.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="/resources/css/userPW.css">
<script type="text/javascript" src="/resources/js/userPW.js"></script>
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
            <div class="setLinck">
                <a class="linckPro" href="/#">계정</a>
                <span class="aroow">></span>
                <span class="pro_text">로그인 및 보안</span>
            </div>

            <h1 class="setTitleMain">
                	로그인 및 보안
            </h1>
        </div>


        <div class="ctnt_main">
            <div class="ctnt_items">

                <div class="ctnt_item_title">
                    <div class="title_main">
                        	로그인 
                    </div>
                </div>

                <h1>로그인</h1>

                <div class="ctnt_item">
                    
                    <div class="item1">
                        <span class="item1_text">비밀번호</span>
                        <button type="button" class="item_btn" onclick="dropData(this)">업데이트</button>
                    </div>

                    <div class="itme3">
                        <div class="itme3_title">
                            	현재 비밀번호
                        </div>
                        
                        <div class="itme3_data">    
                            <input type="password"  id="c_pw" value="" >
                            <a href="#" class="pwAtag">비밀번호를 새로 설정하시겠어요?</a>
                        </div>

                        <div class="itme3_title">
                            	새 비밀번호
                        </div>

                        <div class="itme3_data">
                            <input type="password"  id="r_pw" value="" >
                        </div>

                        <div class="itme3_title">
                           	 비밀번호 확인
                        </div>

                        <div class="itme3_data">
                            <input type="password"  id="ck_pw" value="" >
                        </div>

                        <div class="itme3_data_btn">
                            <span class="data_btn_main" onclick="saveEmail(this)">
                                	비밀번호 변경  
                            </span>
                        </div>
                    </div>
                    
                    <div class="item2">
                        	최종 수정일: 2020-12-06
                    </div>
                    
                </div>

                
            </div>

            
            <div class="ctnt_item_text">
                <div class="tagEmoge"><i class="fas fa-shield-alt fa-2x"></i></div>
                <div class="itemTitle">계정 보안 유지</div>
                <div class="itemText">에어비앤비는 최고의 보안을 위해 계정을 정기적으로 검토합니다. <br>계정 보안을 강화할 수 있는 조치가 더 있다면 알려드리겠습니다.</div>
            </div>
        </div>
    </div>

    <footer>

    </footer>
</body>
</html>