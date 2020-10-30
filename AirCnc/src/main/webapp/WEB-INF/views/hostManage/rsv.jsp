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
<title>rsv</title>
<script src="https://kit.fontawesome.com/ea36f2192f.js" crossorigin="anonymous"></script>
<script type="text/javascript" src="/resources/js/rsv.js"></script>
<link rel="stylesheet" href="/resources/css/rsv.css">
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
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
                <a href="/" class="hSaveBtn">
                    <span class="hSaveBtn">숙소 등록하기</span>
                </a>
               

                <span class="userMenu" onclick="viewMenu()">
                    <img class="menu_img" src="/resources/img/bars-solid.svg"  height="16px" width="16px">
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
            <h1>예약</h1>
        </div>
        <div class="data_menu">
            <span class="af_trip" onclick="af_trip(this)">예정된 여행</span>
            <span class="complete" onclick="complete(this)">완료</span>
            <span class="cancel" onclick="cancel(this)">취소됨</span>
            <span class="rsv_cc" onclick="rsv_cc(this)">변경및 취소 요청</span>
            <span class="all" onclick="allView(this)">모두 보기</span>
        </div>
        <div class="data">
        <c:choose>
	        <c:when test="${fn:length(data) eq 0}">
	        	<div class="data_notice">
					<i class="fas fa-shield-virus fa-2x"></i>
					<div>
					    <div class="dn_title">호스트와 게스트를 위한 보건·안전 가이드라인</div>
					    <div class="dn_text">여행이 점차 회복되는 가운데, 에어비앤비는 호스트와 게스트의 안전을 중요하게 생각합니다. 게스트를 만날 때에는 보건·안전 가이드라인을 따라주시기 바랍니다.</div>
					</div>
				</div>
				<div class="void_data">
					<h3>
					    예정된 예약이 없습니다
					</h3>
				</div>
	        </c:when>
	        <c:otherwise>
	        	<table >
	                <thead>
	                    <tr>
	                        <th class="loebl7r">숙소</th>
	                        <th class="_8ggqw1">숙박 날짜</th>
	                        <th class="_isoiixu">게스트</th>
	                        <th class="_1l0umdhh">총 요금</th>
	                        <th class="_8ggqw2">해야할 일</th>
	                        <th class="_8ggqw2">위치</th>
	                        <th class="_8ggqw2">예약 신청일</th>
	                        <th class="_n7vhew5"></th>
	                    </tr>
	                </thead>
	                
	                <tbody>
	                	<c:forEach items="${data}" var="item">
							<tr>
							      <td class="loebl7r"> 
							          <span class="host_img"><img  src="${item.img_url}"  width="71px"></span>
							          <span class="host_title">${item.room_title}</span>
							      </td>
							
							      <td class="_8ggqw1">${item.chin} ~ ${item.chout}</td>
							
							      <td class="_isoiixu"> ${item.qty}명 </td>
							
							      <td class="_1l0umdhh"><fmt:setLocale value="ko_KR"/><fmt:formatNumber type="currency" value="${item.total_fee}" /></td>
							
							      <td class="prom">없음</td>
							
							      <td class="_8ggqw2">${item.addr }</td>
							
							      <td class="_8ggqw2">${item.r_dt}</td>
									
								  <td class="_n7vhew5"> 
									    <span onclick="viewData(${item.i_reser})">내용 확인</span>
								  </td>
							</tr>
	                	</c:forEach>
	                </tbody>
            	</table>
	        </c:otherwise>
	    </c:choose>
            
        </div>
    </div>
    <footer>

    </footer>
	<div class="vd_pop">
		<div class="popup_main">
			<div class="close-modal" onclick="close_modal(this)">
			    <span>X</span>
			</div>
			<div class="pay_ctnt1">
			    <div class="pay_info">
			        <div class="pay_info1">
			          
			        </div>
			        
			        <div class="pay_info3">
			            	
			        </div>
			    </div>
			    <div class="pay_img">
			            <img class="home_img" src=""  width="100px">
			    </div>
			</div>
			<div class="pay_ctnt2" ></div>
			<div class="pay_ctnt3">
				<div class="user_info">
                    <img class="user_photo" src="" height="30px" width="30px">
                    <div></div>
                    <div></div>
                </div>
                <div class="solid" ></div>
			    <div class="date_main">
			        <div class="qty">
			                <span>
			                    <i class="fas fa-user-friends"></i>
			                </span>
			                <span></span>
			        </div>
			        <div class="date">
			                <span>
			                    <i class="far fa-calendar"></i>
			                </span>
			                <span>
			                    
			                </span>
			        </div>
			    </div>
			    <div class="solid" ></div>
			    <div class="fee_info">
			            <div class="fee-main">
			                <div class="date_fee"> 
			                <span></span>
			                <span></span>
			                </div>
			                <div class="qty_fee">
			                    <span></span>
			                    <span></span>
			                </div>
			                <div class="solid" ></div>
			                <div class="total_fee">
			                    <span>총 합계 (KRW)</span>
			                    <span></span>
			                </div>
			            </div>
			    </div>
			</div>
		</div>
	</div>
</body>
</html>