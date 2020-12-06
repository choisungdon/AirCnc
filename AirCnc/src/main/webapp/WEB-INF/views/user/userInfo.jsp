<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userInfo</title>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script src="https://kit.fontawesome.com/ea36f2192f.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="/resources/css/userInfo.css">
<script type="text/javascript" src="/resources/js/userInfo.js"></script>
</head>
<style>
	
</style>
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
                <a class="linckPro" href="/user/userSetting">계정</a>
                <span class="aroow">></span>
                <span class="pro_text">개인정보</span>
            </div>

            <h1 class="setTitleMain">
                	개인정보
            </h1>
        </div>

        <div class="ctnt_main">
            <div class="ctnt_itmes">

                <div class="ctnt_itme">
                    <div class="itme1">
                        <span class="itme1_text">실명</span>
                        <button type="button" class="itme1_btn" onclick="dropData(this)">수정</button>
                    </div>

                    <div class="itme3">
                        <div class="itme3_title">
                           	 허가증이나 여권 등 여행 서류에 기재되어 있는 이름을 말합니다.
                        </div>
                        
                        <div class="itme3_data">
                            <div class='itme3_data_title'>
                                	이름
                            </div>
                            <input type="text"  id="nm" value="${loginUser.nm }" placeholder="홍길동">
                        </div>

                        <div class="itme3_data_btn">
                            <span class="data_btn_main" onclick="saveNm(this)">
                                	저장 
                            </span>
                        </div>
                    </div>
                    
                    <div class="item2">
                        	${loginUser.nm }
                    </div>
                    
                </div>
				
                <div class="ctnt_itme">
                    <div class="itme1">
                        <span class="itme1_text">생년월일</span>
                        <button type="button" class="itme1_btn" onclick="dropData(this)">수정</button>
                    </div>
                    <fmt:parseDate value="${loginUser.bir_day}" var="dateFmt" pattern="yyyyMMdd"/>
                    
					<c:set var="sysModth"><fmt:formatDate value="${dateFmt}" pattern="MM" /></c:set> 
					<c:set var="sysDay"><fmt:formatDate value="${dateFmt}" pattern="dd" /></c:set> 
					<c:set var="sysYear"><fmt:formatDate value="${dateFmt}" pattern="yyyy" /></c:set> 
		
                    <div class="itme3">
                        <div class="itme3_data_date">
                            <select id="month">
                                <c:forEach var="i" begin="1" end="12" step="1">
									<option value="${i}" ${sysModth == i ? 'selected="selected"' : '' }>${i}월</option>
								</c:forEach>
                            </select>
                            
                            <select id="day">
                                <c:forEach var="i" begin="1" end="31" step="1">
									<option value="${i }"  ${sysDay == i ? 'selected="selected"' : '' }>${i}일</option>
								</c:forEach>
                            </select>
                            
                            <select id="year">
                                <c:forEach var="i" begin="1900" end="2020" step="1">
									<option value="${i }" ${sysYear == i ? 'selected="selected"' : '' }>${i}년</option>
								</c:forEach>
                            </select>
                        </div>

                        <div class="itme3_data_btn">
                            <span class="data_btn_main" onclick="saveDate(this)">
                                	저장 
                            </span>
                        </div>
                    </div>
					
                    <div class="item2">
                        <fmt:formatDate value="${dateFmt}" pattern="yyyy년  MM월  dd일"/>
                    </div>
                </div>

                <div class="ctnt_itme">
                    <div class="itme1">
                        <span class="itme1_text">이메일 주소</span>
                        <button type="button" class="itme1_btn" onclick="dropData(this)">수정</button>
                    </div>

                    <div class="itme3">
                        <div class="itme3_title">
                            	언제든지 확인하실 수 있는 주소를 사용하세요.
                        </div>
                        
                        <div class="itme3_data">
                            <input type="email"  id="e_mail" value="${loginUser.e_mail }" placeholder="fdsafdsa12@naver.com">
                        </div>

                        <div class="itme3_data_btn">
                            <span class="data_btn_main" onclick="saveEmail(this)">
                                	저장 
                            </span>
                        </div>
                    </div>


                    <div class="item2">
                        ${loginUser.e_mail}
                    </div>
                </div>

                <div class="ctnt_itme">
                    <div class="itme1">
                        <span class="itme1_text">전화번호</span>
                        <button type="button" class="itme1_btn" onclick="dropData(this)">수정</button>
                    </div>

                    <div class="itme3">
                        <div class="itme3_title">
                            	알림, 미리 알림 및 로그인에 도움이 됩니다.
                        </div>
                        
                        <div class="itme3_data">
                            <input type="number"  id="ph" value="${loginUser.ph}" placeholder="01072751185">
                        </div>

                        <div class="itme3_data_btn">
                            <span class="data_btn_main" onclick="savePh(this)">
                                	저장 
                            </span>
                        </div>
                    </div>

                    <div class="item2">
                        ${loginUser.ph}
                    </div>
                </div>

            </div>
            <div class="ctnt_item_text">
                <div class="tagEmoge"><i class="fas fa-id-card fa-2x"></i></div>
                <div class="itemTitle">다른 사람에게 어떤 정보가 <br> 공개되나요?</div>
                <div class="itemText">에어비앤비는 예약이 확정된 후에만 호스트 및 게스트의 연락처 정보를 공개합니다.</div>
            </div>
        </div>
    </div>

    <footer>

    </footer>
    
</body>
</html>