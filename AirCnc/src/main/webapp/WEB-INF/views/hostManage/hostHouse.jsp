<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://kit.fontawesome.com/ea36f2192f.js" crossorigin="anonymous"></script>
<script type="text/javascript" src="/resources/js/hostHouse.js"></script>
<link rel="stylesheet" href="/resources/css/hostHouse.css">
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<title>Host_House</title>
</head>
<body>
<input type="hidden" id="i_user" value="${loginUser.i_user}">
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
	    <div class="title">
	        <h2>숙소 5개</h2>
	        <form action="/hostManage/hostHouse" method="GET" class="search">
	        	<input type="hidden" name="i_user" value="${loginUser.i_user}">
	            <div class="sh_cotainer">
	                <div class="sh_main">
	                    <button type="submit"><i class="fas fa-search fa-lg"></i></button> 
	                    <input type="text" id="room_title" name="room_title" value="${shData.room_title}" placeholder="숙소 이름으로 검색">
	                </div>
	            </div>
	        </form>
	    </div>
	    <table class="host_table">
	        <thead>
	            <tr class="trBorder">
	                <th class="host_house">숙소</th>
	                <th class="hostWork">해야 할 일</th>
	                <th class="br_qty">침실</th>
	                <th class="bed_qty">침대</th>
	                <th class="wr_qty">욕실</th>
	                <th class="addr">위치</th>
	                <th class="r_dt">최종 수정일</th>
	                <th class="sysMenu"><i class="fas fa-cogs"></i></th>
	            </tr>
	        </thead>
	        <tbody class="tb">
	        <c:choose>
		        <c:when test="${fn:length(data) eq 0}">
		            <tr class="void_tr">
	                    <td class="void_td" colspan="8">
	                        <div class="void_text">숙소 없음</div>
	                        <div class="void_item">에어비앤비에 숙소를 등록해 예약을 받아보세요.<a href="/host/hosting?i_user=${loginUser.i_user}">숙소 등록하기</a></div>
	                    </td>
                	</tr>
		        </c:when>
		        <c:otherwise>
		        	<c:forEach items="${data}" var="item">
						<tr class="trBorder">
						<td class="host_house" onclick="goHouse(${item.i_host})"><img  src="${item.img_url}"  width="71px"> ${item.room_title}</td>
						<td class="hostWork">${item.state eq 'o' ? '없음' : '등록 완료하기' }</td>
						<td class="br_qty">${item.b_room}</td>
						<td class="bed_qty">${item.bed_qty}</td>
						<td class="wr_qty">${item.bth_room}</td>
						<td class="addr">${item.addr}</td>
						<td class="r_dt">${item.m_dt}</td>
						<td class="sysMenu" onclick="dropSysMenu(this)">
							<i class="fas fa-ellipsis-h"></i>
							<div class="sysMenu_item">
								<a href="/host/duplicate?i_host=${item.i_host}" target="_blank">수정</a>
								<div onclick="delHost(${item.i_host})">삭제</div>
							</div>
						</td>
						</tr>
		            </c:forEach>
		        </c:otherwise>
	        </c:choose>
	        </tbody>
	    </table>
	</div>
	
	<div class="del_pop">
        <div class="dp_main">
            <div class="close-modal" onclick="close_modal(this)">
                <span>X</span>
            </div>
            <div class="dp_item1">
                	숙소 삭제
            </div>
            <div class="dp_item2">
                	숙소를 정말 삭제하시겠어요? 삭제하신 후에는 되살릴 수 없습니다.
            </div>
            <div class="dp_item3">
                <span class="delete">숙소 삭제하기</span>
                <span class="cancel" onclick="delClose()">취소</span>
            </div>
        </div>
    </div>
    
	<footer>
	
	</footer>
</body>
</html>