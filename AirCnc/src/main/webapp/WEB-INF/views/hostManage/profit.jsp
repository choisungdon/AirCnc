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
    <title>Profit</title>
    <script src="https://kit.fontawesome.com/ea36f2192f.js" crossorigin="anonymous"></script>
	<script type="text/javascript" src="/resources/js/profit.js"></script>
	<link rel="stylesheet" href="/resources/css/profit.css">
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
                <div class="notice"	onclick="goManage()">알림</div>
                <div class="rsv"	onclick="goRSV(${loginUser.i_user})">예약</div>
                <div class="house"	onclick="goHouse(${loginUser.i_user})">숙소</div>
                <div class="profit" onclick="goProfit(${loginUser.i_user})">실적</div>
            </div>

            <div class="top_menu">
               <a href="/host/hosting?i_user=${loginUser.i_user}" class="hSaveBtn">
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
        <div class="ctnt_main">
           <div class="ctnt_title">
               <a href="/hostManage/profit?i_user=${loginUser.i_user}" class="review">후기</a>
               <a href="/hostManage/earnings?i_user${loginUser.i_user}" class="income">수입</a>
           </div>
           <div class="ctnt_item">
				<div class="search">
				    <div class="sh_title">숙소 선택</div>
				    <select name="i_host" class="i_host" onchange="search_host(this)">
				        <option value="0">모두 보기</option>
				        <c:forEach items="${host_title}" var="item">
				        <option value="${item.i_host}">${item.room_title}</option>
				        </c:forEach>
				    </select>
				</div>
                <div class="ctnt_menu">
                    <span class="sco_all" onclick="ctnt_menu(this)">
                        <span>모두</span><span></span>
                    </span>
                    <span class="sco_5" onclick="ctnt_menu(this)">
                        <span>5</span><i class="fas fa-star"></i>
                    </span>
                    <span class="sco_4" onclick="ctnt_menu(this)">
                        <span>4</span><i class="fas fa-star"></i>
                    </span>
                    <span class="sco_3" onclick="ctnt_menu(this)">
                        <span>3</span><i class="fas fa-star"></i>
                    </span>
                    <span class="sco_2" onclick="ctnt_menu(this)">
                        <span>2</span><i class="fas fa-star"></i>
                    </span>
                    <span class="sco_1" onclick="ctnt_menu(this)">
                        <span>1</span><i class="fas fa-star"></i>
                    </span>
                </div>

                <div class="review_main">
	                <c:choose>
		                <c:when test="${fn:length(data) eq 0}">
		                	<h2>아직 후기 없음</h2>
	                    
	                    	<div>첫 번째 후기를 받으면 여기에 표시됩니다.</div>
		                </c:when>
	                </c:choose>
                    
                    <div class="rv_ctnt">
                        <section class="rv_item1">
                        <c:choose>
                        	<c:when test="${fn:length(data) eq 0}">
                        		<!-- 없을때  -->
	                            <div class="rv_void"></div>
	                            <div class="rv_void"></div>
	                            <div class="rv_void"></div>
                        	</c:when>
                        	<c:otherwise>
                        		<!-- 있을때  -->
                        		<c:forEach var="item" items="${data}">
                        			<div class="rv_main">
		                                <div class="host_room">
		                                    <img  src="${item.img_url}" >
		                                    <div class="rv_room_title">${item.room_title}</div>
		                                </div>
		                                <div class="host_review">
		                                    <div class="host_rv_nm">
		                                        <img  src="${item.pro_img}"  >
		                                        <div class="rv_nm">
		                                            <div class="nm">${item.nm}</div>
		                                            <div class="day">${item.m_dt}</div>
		                                        </div>
		                                    </div>
		                                   
		                                    <div>
							                	${item.contents}
		                                    </div>
		                                </div>
		                            </div>
                        		</c:forEach>
                        	</c:otherwise>
                        </c:choose>
                       
                        </section>
                        <section class="rv_item2">
                            <div class="score_avg">
                                <div class="avg">
                                	${reviewAvg.avg_val > 0 ? reviewAvg.avg_val : '-'}
                                    <i class="fas fa-star"></i>
                                </div>
                                <div class="avg_text">전체 평점</div>
                            </div>
                            <div class="review_qty">
                                <div class="qty">${reviewAvg.ctnt_qty}</div>
                                <div class="qty_text">총 후기 수</div>
                            </div>
                        </section>
                    </div>
                </div>
           </div>
            
        </div>
    </div>
    <footer>

    </footer>
    
</body>
</html>