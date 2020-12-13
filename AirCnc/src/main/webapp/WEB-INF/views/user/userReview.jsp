<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userReview</title>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script src="https://kit.fontawesome.com/ea36f2192f.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="/resources/css/userReview.css">
<script type="text/javascript" src="/resources/js/userReview.js"></script>
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

    <div class="container">
        <div class="set_title">
            <div class="setLinck">
                <a class="linckPro" href="/user/userShow">프로필</a>
                <span class="aroow">></span>
                <span class="pro_text">후기</span>
            </div>

            <h1 class="setTitleMain">
                	내가 작성한 후기
            </h1>

            <div class="profile_container">
               <div class="panel_header">
                	작성해야 할 후기
               </div>
               <div class="pro_img_ctnt">
                     <table class="review_write_table">
                         <thead class="write_title">
                             <tr class="title_main">
                                 <th class="no">No</th>
                                 <th class="host_title">숙소이름</th>
                                 <th class="host_nm">호스트명</th>
                                 <th class="host_addr">주소</th>
                                 <th class="host_date">체크인/체크아웃</th>
                                 <th class="host_qty">예약인원</th>
                                 <th class="host_btn"></th>
                             </tr>
                         </thead>
                         <tbody class="review_text">
                         <c:choose>
                         	<c:when test="${fn:length(writeReview) > 0}">
                         		<c:forEach var="data" items="${writeReview}">
									 <tr class="text_main">
		                                 <td class="no">${data.row_num}</td>
		                                 <td class="host_title">${data.room_title}</td>
		                                 <td class="host_nm">${data.nm}</td>
		                                 <td class="host_addr">${data.addr}</td>
		                                 <td class="host_date">${data.chin} ~ ${data.chout}</td>
		                                 <td class="host_qty">${data.qty}명</td>
		                                 <td class="host_btn">
		                                     <span class="insReview" onclick ="hostReview(${data.i_host},${data.i_reser},this)">후기쓰기</span>
		                                 </td>
		                             </tr>
								 </c:forEach>
                         	</c:when>
                         	<c:otherwise>
                         		 <tr class="void_writeReview">
	                                <td colspan="7">현재 작성할 후기가 없습니다. 여행을 한번 다녀올 때가 된 것 같네요!</td>
	                             </tr>
                         	</c:otherwise>
                         </c:choose>
                         
                         </tbody>
                     </table>
               </div>
            </div>

            <div class="profile_container">
                <div class="panel_header">
                    	내가 작성한 후기
                </div>
                <div class="pro_img_ctnt">
                <c:choose>
                	<c:when test="${fn:length(upReview) > 0}">
                		<c:forEach var="data" items="${upReview}">
                			<div class="rv_main">
		                        <div class="host_room">
		                            <img  src="${data.img_url}" >
		                            <div class="rv_room_title">${data.room_title}</div>
		                        </div>
		                        <div class="host_review">
		                            <div class="host_rv_nm">
		                                <div class="host_rv_nm_main">
		                                    <img  src="${data.pro_img}"  >
		                                    <div class="rv_nm">
		                                        <div class="nm">${data.nm }</div>
		                                        <div class="day">${data.m_dt}</div>
		                                    </div>
		                                </div>
		                                
		                                <span class="upReview">
		                                    <span onclick ="reviewUpdate(${data.i_contents},this)">후기 수정</span>
		                                </span>
		                            </div>
		                           
		                            <div class="contents">
		                                ${data.contents}
		                            </div>
		                        </div>
		                    </div>
                		</c:forEach>
                	</c:when>
                	<c:otherwise>
                		 <div class="void_upReview">
			                       	아직 후기를 남기지 않으셨습니다.
			             </div>
                	</c:otherwise>
                </c:choose>
                    
                    
                </div>
             </div>
        </div>
    </div>

    <footer>
        <i class="fab fa-airbnb fa-lg"></i>© 2020 Airbnb, Inc. All rights reserved.
    </footer>


    <!--숙소 후기 popup창 -->
    <div class="review_pop">
        <div class="pop_main">

            <div class="close-modal" onclick="close_modal(this)">
                <img src="/resources/img/aircncLog.png">
                <span>X</span>
            </div>
            
            <div class="reText">
                <div class="re_title">이 숙소에 후기를 남겨주세요.</div> 
                <div class="re_score">
                  <div class="re_score_title">숙소의 총 평점을 선택해주세요.</div> 
                  <label><input type="checkbox" class="score"  value="1" onclick="reviewCheck(this)">1점</label>
                  <label><input type="checkbox" class="score" value="2" onclick="reviewCheck(this)">2점</label>
                  <label><input type="checkbox" class="score" value="3" onclick="reviewCheck(this)">3점</label>
                  <label><input type="checkbox" class="score" value="4" onclick="reviewCheck(this)">4점</label>
                  <label><input type="checkbox" class="score" value="5" onclick="reviewCheck(this)">5점</label>
                </div>
                <div class="re_text_main">
                    <div class="re_text_main_title">
                       	 구체적인 후기 내용을 남겨주세요.
                    </div>
                  
                   <textarea id="contents" name="contents"></textarea>
                </div>
                        
            
            </div>
            
            <div class="re_btn">
                <span class="re_btn_main">후기 작성 완료</span>
            </div>
         
        </div>
    </div>
</body>
</html>