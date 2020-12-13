<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>rsvChange</title>
    <!-- 달력 -->
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
	<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
	<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
	<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
	<!-- 달력 -->
	<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <script src="https://kit.fontawesome.com/ea36f2192f.js" crossorigin="anonymous"></script>
    <script type="text/javascript" src="/resources/js/rsvChange.js"></script>
    <link rel="stylesheet" href="/resources/css/rsvChange.css">
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
    <form id="frm" action="/reservation/rsvChange"  onsubmit="return checkData();" method="post" class="container">
        <div class="ctn_main">

            <div class="ctnt1">
                <h1>바르셀로나의 3박</h1>
                <div class="ctnt1_data1">
                    <div class="title">게스트</div>
                    <div class="qty">
                        <button type="button" onclick="countUp(document.getElementById('gest_qty'))">+</button>
                        <input type="number" name="gest_qty" id="gest_qty" value="${data.qty}">
                        <button type="button" onclick="countDw(document.getElementById('gest_qty'))">-</button>
                    </div>
                   
                
                    <div class="title">체크인</div>
                    <div class="chin">
                        <input type="text" name="chin" id="chin" value="${data.chin}" readonly="readonly">
                    </div>
                    <div class="title">체크 아웃</div>
                    <div class="chout">
                        <input type="text" name="chout" id="chout" value="${data.chout}" readonly="readonly">
                    </div>
                    
                </div>

                <div class="ctnt1_btn">
                    <span class="cc_btn" onclick="cancel()">변경 취소</span>
                    <input class="ch_btn" type="submit" value="변경">
                </div>
                
            </div>

            <section class="pay">
                <div class="pay_container">
                    <div class="pay_ctnt">
                        <div>
                            <div class="pay_ctnt1">
                                <div class="pay_info">
                                    <div class="pay_info1">
                                        ${data.room_title}
                                    </div>
                                    <div class="pay_info2">
                                    	<c:choose>
											<c:when test="${data.live_type eq 'all'}">
												집 전체
											</c:when>
											<c:when test="${data.live_type eq 'single'}">
												개인실
											</c:when>
											<c:when test="${data.live_type eq 'share'}">
												다인실
											</c:when>
											<c:otherwise></c:otherwise>
										</c:choose> 
                                    </div>
                                    <div class="pay_info3">
                                        <div>침대 ${data.bed_qty}개 . 욕실수 ${data.bth_room}개</div>
                                    </div>
                                </div>
                                <div class="pay_img">
                                        <img class="home_img" src="${data.room_poto}"  width="100px">
                                </div>
                            </div>
                            <div class="pay_ctnt2" ></div>
                            <div class="pay_ctnt3">
                                <div class="date_main">
                                    <div class="qty">
                                            <span>
                                                <i class="fas fa-user-friends"></i>
                                            </span>
                                            <span class="gest_qty">게스트 ${data.qty }</span>
                                    </div>
                                    <div class="date">
                                            <span>
                                                <i class="far fa-calendar"></i>
                                            </span>
                                            <span class="day">
                                                ${fn:substring(data.chin,0,4)}년 ${fn:substring(data.chin,5,7)}월 ${fn:substring(data.chin,8,10)}일 → ${fn:substring(data.chout,0,4)}년 ${fn:substring(data.chout,5,7)}월 ${fn:substring(data.chout,8,10)}일
                                            </span>
                                    </div>
                                </div>
                                <div class="solid" ></div>
                                <input type="hidden" id="date" 		value="${data.date}">
                                <input type="hidden" id="fee" 		value="${data.fee}">
                                <input type="hidden" id="total_fee" name="total_fee"	value="${data.total_fee}">
                                <input type="hidden" id="i_reser" 	name="i_reser" 		value="${data.i_reser}">
                                <input type="hidden" id="i_host" 	value="${data.i_host}">
                                <div class="fee_info">
                                      <div class="fee-main">
	                                    <div class="date_fee"> 
		                                    <span class="pqy_date"><fmt:setLocale value="ko_KR"/><fmt:formatNumber type="currency" value="${data.fee}" /> X ${data.date}박</span>
		                                    <span class="pqy_date_fee"><fmt:setLocale value="ko_KR"/><fmt:formatNumber type="currency" value="${data.fee*data.date}" /></span>
	                                    </div>
	                                    <div class="qty_fee">
	                                        <span class="pqy_qty"><fmt:setLocale value="ko_KR"/><fmt:formatNumber type="currency" value="${data.fee*data.date}" /> X ${data.qty}명</span>
	                                        <span class="pqy_qty_fee"><fmt:setLocale value="ko_KR"/><fmt:formatNumber type="currency" value="${data.total_fee}" /></span>
	                                    </div>
	                                    <div class="solid" ></div>
	                                    <div class="total_fee">
	                                        <span>총 합계 (KRW)</span>
	                                        <span class="last_fee"><fmt:setLocale value="ko_KR"/><fmt:formatNumber type="currency" value="${data.total_fee}" /></span>
	                                    </div>
	                                </div>
                                </div>
                            </div>
                        </div>
                        </div>
                </div>
                <div class="erro"></div>
                </section>

        </div>

    </form>

    <footer>

    </footer>
    
</body>
</html>