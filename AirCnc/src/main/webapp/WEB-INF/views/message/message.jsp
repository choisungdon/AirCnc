<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!--jquery  -->
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<!-- msg.js,msg.css -->
<script src="https://kit.fontawesome.com/ea36f2192f.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="/resources/css/msg.css">

<title>Message</title>
</head>
<body>
    <header>
        <a href="/" class="logo">
            <span>
                <img src="/resources/img/aircncLog.png">
            </span>
        </a>
        <span class="top_menu" onclick="viewMenu()">
            <img class="hamMenu" src="/resources/img/bars-solid.svg"  height="16px" width="16px">
            <img class="my_profile" src="${loginUser.my_profile}" height="30px" width="30px">

            <div class="drop_menu">
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
    </header>

    <div class="container">
        <div class="msg_ctnt1">
            <div class="th_msg_title">
                <h2>메시지 주고받기</h2>
               
            </div>
            

            <div class="m_msg_ctnt1_1">
            	<c:choose>

				<c:when test="${data eq null || data eq ''}">
					<div class="void_msg" >
	                    <h3>메시지가 없습니다.</h3>
	                    <p>
	                        	여행이나 체험을 예약한 경우, 호스트가 보낸
	                        <br>
	                        	톡방이 여기에 표시됩니다.
	                    </p>
	                    <span onclick="goHome()">에어씨엔씨 둘러보기</span>
                	</div>
				</c:when>
				
				<c:otherwise>
					<div class="msg_items" >
					<c:forEach items="${data}" var="item">
	                	<div >
	                		<span class="msg_item_img" onclick="viewMsg(${item.i_mlist},${loginUser.i_user})">
	                			<img src="${item.room_poto}">
	                		</span>
	                		<span class="msg_item_title" onclick="viewMsg(${item.i_mlist},${loginUser.i_user})">
	                			${item. ms_title}
	                		</span>
	                		<span class="msg_item_r_dt"onclick="viewMsg(${item.i_mlist},${loginUser.i_user})">
	                			${item.r_dt}
	                		</span>
	                		<span class="msg_out" onclick="msgOut(${item.i_mlist},${loginUser.i_user},this)"><i class="fas fa-door-open"></i></span>
	                	</div>
	                </c:forEach>
	                </div>
				</c:otherwise>
				
				</c:choose>

            </div>
            
            <div class="m_msg_ctnt1_2">
                <div>결과 없음</div>
            </div>
        </div>

        <div class="msg_ctnt2">
            <div class="msg_main_title">
                <h2 >메시지 제목</h2>
            </div>

            <div class="m_msg_ctnt2">
                <div class="void_msg">
                    <h3>톡방을 클릭하여 주세요.</h3>
                    <p>
                        	여행을 예약한 경우, 호스트가 보낸
                        <br>
                       	 메시지가 여기에 표시됩니다.
                    </p>
                </div>
                <div class="msg_text">
                <!-- 메시지 담을 태그 -->
                </div>
                

                <div class="msg_throws">
                    <textarea id="msg"></textarea>
                    <button type="button" id="msg_thorow" onclick="msg_thorow()">전송</button>
                </div>
                
            </div>

        </div>

      
    </div>
</body>
<script type="text/javascript" src="/resources/js/msg.js"></script>
</html>