<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://kit.fontawesome.com/ea36f2192f.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/resources/css/trip.css">
    <script type="text/javascript" src="/resources/js/trip.js"></script>
    
    <title>trip</title>
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
    </header>
    <div class="container">
        <section class="ctnt_main">
            <h1 class="main_title">여행</h1>

            <div class="main_button">
                <span class="btn_1" onclick="mButton(this)">
                    	예정된 예약
                </span>
                <span class="btn_2" onclick="mButton(this)">
                    	이전 예약
                </span>
            </div>
			
            <div class="main">
            <c:choose>
            	<c:when test="${fn:length(af_data) != 0}">
            	<div class="main_container">
		           	<c:forEach items="${af_data}" var="item">
			           	<div class="main_ctnt">
			           	
							<div class="items">
							
								<div class="items_ctnt">
								    <div class="items_title">
								        	${item.room_title}
								</div>
								
								<div class="items_1">
								    ${item.addr } 게스트 ${item.qty}명
								    </div>
								</div>
								
								<div class="items_ctnt_1">
								
								     <div>
								         <div class="day">${item.chin}</div>
								<div>체크인 시간 : ${item.checkin_t}</div>
								</div>
								
								<div>▷ </div>
								
								<div>
								    <div class="day">
								       ${item.chout}
								</div>
								<div>
								   	 체크아웃 시간 : ${item.finich_t}
								                          </div>
								                      </div>
								
								                  </div>
								
								<div class="tt_fee">
									<span>총 합계 : </span>
									<span><fmt:setLocale value="ko_KR"/><fmt:formatNumber type="currency" value="${item.total_fee}" /></span>
								               </div>
								                 
								<div class="items_btn">
									<span onclick="goMsg()">
								    <i class="far fa-comment-dots"></i>
								    <span>메시지 보내기</span> 
								</span>
								<span onclick="goChangeRV(${item.i_reser},'${item.reser_state }')">
									    <i class="far fa-calendar-alt"></i>
									    <span>변경 또는 취소</span>
									</span>
									
								</div>
								
								<c:choose>
									<c:when test="${item.reser_state eq 'cc'}">
										<div class="state">예약 취소중 </div>
									</c:when>
									
									<c:when test="${item.reser_state eq 'ch'}">
										<div class="state">예약 변경중 </div>
									</c:when>
								</c:choose>
								
															
							</div>
			
							<div class="items_img">
							    <img src="${item.room_poto}" style="width: 200px; ">
							</div>
		                   
						</div>
		            </c:forEach> 
            	</div>
            	 
            	</c:when>
            	
				<c:otherwise>
					<h1 class="main_container">예정된 여행이 없습니다.</h1>
				</c:otherwise>
            </c:choose>

                <div class="trip_before">
                <c:choose>
                	<c:when test="${fn:length(bf_data) != 0}">
                		<c:forEach items="${bf_data}" var="item">
		                	<div class="tb_items">
		                        <div class="tb_items_main">
		
		                            <div class="tb_itmes_ctnt1">
		                                <div class="tb_title">
		                                   	${item.room_title }
		                                </div>
		                                <div>
		                                      ${item.addr } 게스트 ${item.qty}명
		                                </div>
		                            </div>
		
		                            <div class="tb_itmes_ctnt2">
		                                 <div>
			                                <div class="day">
			                                	${item.chin}
			                                </div>
			                                <div>
			                                	체크인 시간 : ${item.checkin_t}
			                                </div>
			                            </div>
			
			                            <div>▷ </div>
			
			                            <div>
			                                <div class="day">
			                                   ${item.chout}
			                                </div>
			                                <div>
			                                   	 체크아웃 시간 : ${item.finich_t}
			                                </div>
			                            </div>
		                            </div>
		                            
		                            <div class="tt_fee">
		                                <span>총 합계 : </span>
		                                <span><fmt:setLocale value="ko_KR"/><fmt:formatNumber type="currency" value="${item.total_fee}" /></span>
		                            </div>
		                            
		                            
									<c:choose>
									    <c:when test="${item.review_state eq 0 }">
									        <div class="tb_items_btn" onclick="goHostReview(${item.i_host},${item.i_reser})">
				                            	<i class="fas fa-user-edit"></i>
				                            	<span>
				                            		후기 쓰기 
				                            	</span>
				                            </div>
									    </c:when>
									    
									    <c:otherwise>
									        <div class="tb_items_btn" onclick="goReviewUpdate(${item.i_host},${item.i_reser})">
				                            	<i class="fas fa-user-edit"></i>
				                            	<span>
				                            		후기 수정
				                            	</span>
				                            </div>
									    </c:otherwise>
									</c:choose>
		
		                        </div>
		
		                        <div class="tb_items_img">
		                            <img src="${item.room_poto}" style="width: 200px;">
		                        </div>
		                    </div>
	                    </c:forEach>
                	</c:when>
                	<c:otherwise>
                		<div class="tb_title">
                        	과거 여행이 없습니다. 하지만 여행을 완료하면 여기에서 확인하실 수 있습니다.
	                    </div>
	                    <div class="tb_ctnt">
	                        <img src="/resources/img/trip.png" >
	                    </div>
                	</c:otherwise>
                </c:choose>
                   
                </div>

            </div>

            <div class="other_btn" onclick="goHome()">
                <div>
                    <u>
                        	에어비엔비 여행지 둘러보기 
                    </u>
                    <span>▶</span>
                </div>
            </div>

        </section>
    </div>
    <footer>

    </footer>
</body>
</html>