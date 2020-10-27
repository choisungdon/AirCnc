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
    <title>rsvCancel</title>
    <script src="https://kit.fontawesome.com/ea36f2192f.js" crossorigin="anonymous"></script>
    <script type="text/javascript" src="/resources/js/rsvCancel.js"></script>
    <link rel="stylesheet" href="/resources/css/rsvCancel.css">
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
        <div class="ctnt">
            <h1 class="title">취소 할려는 이유가 무엇인가요?</h1>

            <div class="text">이유를 선택 하세요.</div>
			
            <div class="text_option">
            <form action="/reservation/rsvCancel" method="post" class="reason">
            	<input type="hidden" name="i_reser" value="${data.i_reser}"> 
            	<input type="hidden" name="i_host" value="${data.i_host}"> 
            	<input type="hidden" name="i_user" value="${loginUser.i_user}">
                <select name="reason" >
                    <option value="기타" selected>기타</option>
                    <option value="숙소가 필요 없어졌어요.">숙소가 필요 없어졌어요.</option>
                    <option value="실수로 예약 했어요.">실수로 예약 했어요.</option>
                    <option value="정상 참작이 가능한 상황이 생겼어요.">정상 참작이 가능한 상황이 생겼어요.</option>
                    <option value="호스트가 예약 취소를 원해요.">호스트가 예약 취소를 원해요.</option>
                    <option value="호스트가 맘에 들지 않아요.">호스트가 맘에 들지 않아요.</option>
                    <option value="예약 날짜가 변경되었어요.">예약 날짜가 변경되었어요.</option>
                </select>
                
            </div>
            <div class="ctnt_btn">
            	<input type="submit" value="계속" class="btn">
            </div>
            </form>
            
        </div>
        <div class="ctnt_data">
            <div class="data">
                <div class="host_title">
                    <div class="title_item">
                        <h1>${data.room_title }의 ${data.date}박</h1>
                        <div>
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
							. 침대 ${data.bed_qty}개 . 욕실수 ${data.bth_room}개
                        
                        </div>
                    </div>
                    <div class="title_img">
                        <img src="${data.room_poto}" style="width: 200px; ">
                    </div>
                </div>

                <div class="host_data">
                    <div class="qty">
                        <span><i class="fas fa-user-friends fa-lg"></i></span>
                        <span>게스트 ${data.qty }명</span>
                    </div>
                    <div class="date">
                        <span><i class="far fa-calendar fa-lg"></i></span>
                        <span class="day">
                            <span>${data.chin}</span>
                            <span><i class="fas fa-arrow-right"></i></span>
                            <span>${data.chout}</span>
                        </span>

                    </div>
                </div>

                <div class="host_fee">
                    <span>변경 전 중 예약금 </span>
                    <span><fmt:setLocale value="ko_KR"/><fmt:formatNumber type="currency" value="${data.total_fee}" /></span>
                </div>

                <div class="host_total">
                    <span>총환불 금액 </span>
                    <span><fmt:setLocale value="ko_KR"/><fmt:formatNumber type="currency" value="${data.total_fee}" /></span>
                </div>
            </div>
        </div>
    </div>

    <footer>

    </footer>
    
</body>
</html>