<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    
    <!-- 달력 -->
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
	<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
	<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
	<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
	<!-- 달력 -->
	<script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBYMK6J-N5yiDhf8Z3Bipzewlm5bOzs_iU&callback=initMap&libraries=&v=weekly" defer></script>
    <script src="https://kit.fontawesome.com/ea36f2192f.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <link rel="stylesheet" href="/resources/css/searchDetail.css">
    <link rel="stylesheet" href="/resources/css/font/fontStyle.css">
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
        <div class="searchItem">
            <span class="sch_items">
                <span class="local">
                    <div class="sch_font">위치</div>
                    <input type="text" id="s_addr" value="${sData.addr}" placeholder="어디로 여행가세요?">
                </span>
                <span>
                    <div class="sch_font">체크인</div>
                    <input type="text" id="searchin" value="${sData.chin}" placeholder="날짜 추가" readonly="readonly">
                </span>
                <span>
                    <div class="sch_font">체크아웃</div>
                    <input type="text" id="searchout" value="${sData.chout}" placeholder="날짜 추가" readonly="readonly">
                </span>
                <span class="m_sh_button">
                    <span>
                        <div class="sch_font">인원</div>
                        <div class="sch_input_num">
                            <button type="button" onclick="countDw(document.getElementById('qty'))">-</button>
                            <input type="number" id="qty" size="10" value="${sData.qty}" >
                            <button type="button" onclick="countUp(document.getElementById('qty'))">+</button>
                        </div>
                    </span>
                    <span class="button" onclick="goSearch()">
                        <i class="fas fa-search"></i> 
                    </span>
                </span>
            </span>
        </div>

    </header>
   <div class="container1">

        <h2 class="title">
           ${data.room_title}
        </h2>

        <div class="ctnt_sub1">
            <div  onclick="focusCment()">
                <i class="fas fa-star"></i>
                <span>${data.comtAvg}(${data.cmtCount})</span>
                <u>${data.country}</u>
            </div>
            <div class="like_teg" onclick="like(this)">
                <i class="fas fa-heart" style="color:${(data.like_user == 0) ? 'gray' : 'red' };" ></i>
                <input type="hidden" id="like_user" value="${data.like_user != 0 ? 1 : 0}">
		        <input type="hidden" id="i_host" value="${data.i_host}">
                <u>저장</u>
            </div>
        </div>

        <div class="ctnt_sub2">
			<c:forEach items="${data.roomImgList}" var="roomImglist">
				<div class="mySlides fade">
	               <img src="${roomImglist.room_poto}"  style="width:100%" >
	            </div>
			</c:forEach>
           
            <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
            <a class="next" onclick="plusSlides(1)">&#10095;</a>
            
            <div style="text-align:center">
                <span class="dot" onclick="currentSlide(1)"></span> 
                <span class="dot" onclick="currentSlide(2)"></span> 
                <span class="dot" onclick="currentSlide(3)"></span> 
            </div>
        </div>

        <div class="ctnt_sub_dt1">
            <div class="ctnt_detail">

              <div class="hostUser">


                <span>
                    <h3>
	                    ${data.nm }님이 호스팅하는 
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
					</h3>
                    <div>최대 인원 ${data.r_vastion}명 · 침실 ${data.b_room}개 · 침대 ${data.bed_qty}개 · 욕실 ${data.bth_room}개</div>
                </span>
                <span class="host_user_box">
                    <img class="my_profile" src="${data.my_profile}"  style="width:100%">
                </span>
              </div>

              <div class="build_type">
                <div class="hoouse">
                    <span>
                    <i class="fas fa-home"></i> 
					<c:choose>
						<c:when test="${data.live_type eq 'all'}">
							<span>집 전체 </span>
						</c:when>
						<c:when test="${data.live_type eq 'single'}">
							<span>개인실</span>
						</c:when>
						<c:when test="${data.live_type eq 'share'}">
							<span>다인실</span>
						</c:when>
						<c:otherwise></c:otherwise>
					</c:choose>
					</span>
                </div>
                <div class="self_ch">
                <c:if  test="${data.self_checkin eq 'o'}">                
                    <span>
                        <i class="fas fa-door-closed"></i>
                    </span>
                  
                    <span>
                       	 셀프 체크인
                    </span>
                </c:if>
                </div>
              </div>

                <div class="house_info">
                	<h3>소개 </h3>
                    <div class="expa">
                        ${data.expa}
                    </div>
                    <h3>숙소 </h3>
                    <div class="room_info">
                      ${data.room_info}
                    </div>
                </div>

                <div class="bed_info">
                    <h3>침대/침구 유형</h3>
                    <div class="bed">
                        <div><i class="fas fa-bed fa-lg"></i></div>
                        <div> 객실수 : ${data.b_room}개</div>
                        <div> 침대갯수 : ${data.bed_qty}개 </div>
                        <div>
                        	<c:choose>
								<c:when test="${data.bed_type eq 'double'}">
									더블 침대
								</c:when>
								<c:when test="${data.bed_type eq 'queen'}">
									퀸 침대
								</c:when>
								<c:when test="${data.bed_type eq 'single'}">
									싱글 침대
								</c:when>
								<c:otherwise></c:otherwise>
							</c:choose>
                        </div>
                    </div>
                </div>
                
                <div class="conven">
                    <h3>편의 실설</h3>
                    <div class="conven_item">
                    
                    	<c:choose>
						    <c:when test="${data.wifi eq 'o'}">
						       	<span>
			                        <i class="fas fa-wifi fa-lg"></i>
			                        <span>무선 인터넷 </span>
                       			</span> 
						    </c:when>
						    <c:otherwise>
						       <STRIKE>
						       		<i class="fas fa-wifi fa-lg"></i>
			                        <span>무선 인터넷 </span>
						       </STRIKE>
						    </c:otherwise>
						</c:choose>
						
						<c:choose>
						    <c:when test="${data.aircon eq 'o'}">
						       	<span>
			                        <i class="fas fa-fan fa-lg"></i>
			                        <span>에어컨</span>
		                        </span>
						    </c:when>
						    <c:otherwise>
						       <STRIKE>
						       		<i class="fas fa-fan fa-lg"></i>
			                        <span>에어컨</span>
						       </STRIKE>
						    </c:otherwise>
						</c:choose>
                       	
                    </div>

                    <div class="conven_item">
                    	<c:choose>
						    <c:when test="${data.hiter eq 'o'}">
						       	<span>
		                    		<i class="fas fa-fire fa-lg"></i>
		                        	<span>히터</span>
		                    	</span>
						    </c:when>
						    <c:otherwise>
						       <STRIKE>
						       		<i class="fas fa-fire fa-lg"></i>
		                        	<span>히터</span>
						       </STRIKE>
						    </c:otherwise>
						</c:choose>
						
                        <c:choose>
						    <c:when test="${data.breakfast eq 'o'}">
						       	<span>
		                        	<i class="fas fa-utensils fa-lg"></i>
		                        	<span>조식</span>
		                        </span>
						    </c:when>
						    <c:otherwise>
						       <STRIKE>
						       		<i class="fas fa-utensils fa-lg"></i>
		                        	<span>조식</span>
						       </STRIKE>
						    </c:otherwise>
						</c:choose>
                        
                    </div>

                    <div class="conven_item">
                    	<c:choose>
						    <c:when test="${data.hanger eq 'o'}">
						       	<span>
		                    		 <i class="fas fa-tshirt fa-lg"></i>
		                        	 <span>옷걸이</span>
		                    	</span>
						    </c:when>
						    <c:otherwise>
						       <STRIKE>
						       		<i class="fas fa-tshirt fa-lg"></i>
		                        	<span>옷걸이</span>
						       </STRIKE>
						    </c:otherwise>
						</c:choose>
                    	
                       <c:choose>
						    <c:when test="${data.hiar_dry eq 'o'}">
						       	<span>
		                        	<i class="fas fa-wind fa-lg"></i>
		                        	<span>헤어 드라이기</span>
		                        </span>
						    </c:when>
						    <c:otherwise>
						       <STRIKE>
						       		<i class="fas fa-wind fa-lg"></i>
		                        	<span>헤어 드라이기</span>
						       </STRIKE>
						    </c:otherwise>
						</c:choose>
                        
                    </div>

                    <div class="conven_item">
                    	<c:choose>
						    <c:when test="${data.baby_bad eq 'o'}">
						       	<span>
		                    		<i class="fas fa-baby fa-lg"></i>
		                        	<span>유아용 침대</span>
		                    	</span>
						    </c:when>
						    <c:otherwise>
						       <STRIKE>
						       		<i class="fas fa-baby fa-lg"></i>
		                        	<span>유아용 침대</span>
						       </STRIKE>
						    </c:otherwise>
						</c:choose>
                    	
                    	<c:choose>
						    <c:when test="${data.place_lattop eq 'o'}">
						       	<span>
		                    		<span class="piano"></span>
		                        	<span>피아노</span>
		                    	</span>
						    </c:when>
						    <c:otherwise>
						       <STRIKE>
						       		<span class="icon-piano"></span>
		                        	<span>피아노</span>
						       </STRIKE>
						    </c:otherwise>
						</c:choose>
                    	
                       
                    </div>

                    <div class="conven_item">
                    	<c:choose>
						    <c:when test="${data.in_hiter eq 'o'}">
						       	<span>
		                    		<span class="icon-fireplace"></span>
		                        	<span>벽 난로</span>
		                    	</span>
						    </c:when>
						    <c:otherwise>
						       <STRIKE>
						       		<span class="icon-fireplace"></span>
		                        	<span>벽 난로</span>
						       </STRIKE>
						    </c:otherwise>
						</c:choose>
                    	
                    	<c:choose>
						    <c:when test="${data.self_bth_room eq 'o'}">
						       	<span>
		                    		<i class="fas fa-shower fa-lg"></i>
		                        	<span>욕실 단독 사용</span>
		                    	</span>
						    </c:when>
						    <c:otherwise>
						       <STRIKE>
						       		<i class="fas fa-shower fa-lg"></i>
		                        	<span>욕실 단독 사용</span>
						       </STRIKE>
						    </c:otherwise>
						</c:choose>
                    	
                    	
                    </div>
                    <div class="conven_button" onclick="conven_popup()">
                        <span>편의시설 모두보기</span>
                    </div>
                </div>
            </div>

            <form action="/reservation/reservation" method="GET" class="payment">
            	<input type="hidden" name="fee" id="fee" value="${data.fee }">
            	<input type="hidden" name="i_host" value="${data.i_host }">
            	<input type="hidden" name="addr" value="${sData.addr}">
            	
                <div class="payment_main">
                    <div class="payment_dt1">
                        <h3><fmt:setLocale value="ko_KR"/><fmt:formatNumber type="currency" value="${data.fee}" />/박</h3>
                        <span>
                        	<i class="fas fa-star"></i>
                			<span>${data.comtAvg}(${data.cmtCount})</span>
                        </span>
                    </div>
                    <div class="payment_dt2">
                        <div class="payment_date">
                            <span class="chin">
                               <span>체크인 : </span>
                               <span id="r_chin" >${sData.chin eq '' || sData.chin eq null? '날짜 없음' : sData.chin}</span>
                               <input type="hidden" name="chin"  value="${sData.chin}">
                            </span>
                            
                            <span class="chout">
                                <span>체크아웃 : </span>
                                <span id="r_chout" >${sData.chout eq '' || sData.chout eq null? '날짜 없음' : sData.chout}</span>
                                <input type="hidden" name="chout" value="${sData.chout}">
                            </span>
                        </div>
                        <input type="hidden" name="date" id="date" value="${sData.date}" >
                        <div class="qty">
                            <span >인원 : </span>
                            <span id="r_qty" >${sData.qty}</span>
                            <span>명</span>
                            <button type="button" onclick="qtyUp(document.getElementById('r_qty'))">+</button>
                            <button type="button" onclick="qtyDW(document.getElementById('r_qty'))">-</button>
                            <input type="hidden" name="qty" value="${sData.qty}" >
                        </div>
                    </div>
                    <div class="erro"></div>
                    <div class="sub_button">
                      <input id="sub" type="submit" value="예약하기">
                    </div>
                    <div>예약 확정 전에는 요금이 청구되지 않습니다.</div>
                    <div class="payment_fee">
                        <span id="pqy_date"><fmt:setLocale value="ko_KR"/><fmt:formatNumber type="currency" value="${data.fee}" /> X ${sData.date}박</span>
                        <span id="pqy_date_fee"><fmt:setLocale value="ko_KR"/><fmt:formatNumber type="currency" value="${data.fee*sData.date}" /> </span>
                    </div>
                    
                    <div class="payment_fee">
                        <span id="pqy_qty"><fmt:setLocale value="ko_KR"/><fmt:formatNumber type="currency" value="${data.fee*sData.date}" /> X ${sData.qty}명</span>
                        <span id="pqy_qty_fee"><fmt:setLocale value="ko_KR"/><fmt:formatNumber type="currency" value="${data.fee*sData.date*sData.qty}" /> </span>
                    </div>
                    
                    <div class="payment_total">
                        <span>총 합계 : </span>
                        <span id="total_fee"><fmt:setLocale value="ko_KR"/><fmt:formatNumber type="currency" value="${data.fee*sData.date*sData.qty}" /></span>
                    </div>
                </div>
            </form>
            
        </div>

   </div>
   <div class="container2">

        <div class="ctnt_comment">
            <h3 class="score">
                <i class="fas fa-star"></i> 
                ${data.comtAvg}점 (후기 ${data.cmtCount}개)
            </h3>

            <div class="comment_itmes">
				<c:forEach items="${data.hostReviewList}" var="item" begin="0" end="2">
					<div class="user_comment">
	                    <div class="user_com_item">
	                        <span>
	                            	<img class="user_plofile" src="${item.cmt_user_poto}">
	                        </span>
	                        <span>
	                            <div class="user_nm">${item.nm }</div>
	                            <div class="date">${item.r_dt}</div>
	                        </span>
	                    </div>
	                    <div>
	                        ${item.contents}
	                    </div>
	                </div>
				</c:forEach>

            </div>

            <div class="comment_button" onclick="comment_popup()">
                <span>후기 모두보기</span>
            </div>
        </div>

        <div class="location">
            <h3>
                	위치 
            </h3>
            <div class="map" id="map">map</div>
            <div class="local_items">

                <div>
                    <h4>${data.room_title}</h4>
                    <span>
                        ${data.loca_info}
                    </span>
                </div>

                <div>
                    <h4>교통편</h4>
                    <div>
                        ${data.traf_info}
                    </div>
                </div>

            </div>
        </div>

        <div class="host_info">
            <span>
                <img class="my_profile" src="${data.my_profile}"  >
            </span>
            <span>
                <h3>${data.nm}</h3>
                <div class="r_dt">회원 가입일  : ${data.r_dt}</div>
            </span>
        </div>

        <div class="rule">
            <h3>알아두어야 할 사항</h3>
            <div class="rule_items">

                <div>
                    <h4>숙소 이용 규칙</h4>
                    <c:if test="${data.child_ok eq 'o' }">
                    	<div class="rule_dt_itmes">
		            		<i class="fas fa-child fa-lg"></i>
		            		<span>어린이(2~12세) 숙박에 적합함</span>
		            	</div>
                    </c:if>
                    
                    <c:if test="${data.y_ch_ok eq 'o' }">
                    	<div class="rule_dt_itmes">
		            		<i class="fas fa-baby fa-lg"></i>
		            		<span>유아(2세 미만) 숙박에 적합함 </span>
		            	</div>
                    </c:if>
                    
                    <c:choose>
                    	<c:when test="${data.smoking eq 'o'}">
                    		<div class="rule_dt_itmes">
			            		<i class="fas fa-smoking fa-lg"></i>
			            		<span>숙소 내 흡연 가능</span>
			            	</div>
                    	</c:when>
                    	<c:otherwise>
                    		<div class="rule_dt_itmes">
			            		<i class="fas fa-smoking-ban fa-lg"></i>
			            		<span>흡연 금지</span>
			            	</div>
                    	</c:otherwise>
                    </c:choose>
	            	
	            	<c:choose>
                    	<c:when test="${data.animal_ok eq 'o'}">
                    		<div class="rule_dt_itmes">
			            		<i class="fas fa-dog fa-lg"></i>
			            		<span>반려 동물동반에 적합함</span>
			            	</div>
                    	</c:when>
                    	<c:otherwise>
                    		<STRIKE class="rule_dt_itmes">
			            		<i class="fas fa-dog fa-lg"></i>
			            		<span>반려 동물동반에 부적합</span>
			            	</STRIKE>
                    	</c:otherwise>
                    </c:choose>
	            	
	            	<c:if test="${data.party eq 'o' }">
                    	<div class="rule_dt_itmes">
		            		<i class="fas fa-birthday-cake fa-lg"></i>
		            		<span>숙소내 행상,파티 허용</span>
		            	</div>
                    </c:if>
	            	
                    <div class="rule_button" onclick="rule_popup()">
		                <span>규칙 모두보기</span>
		            </div>
                    
                </div>

                <div class="safe_health">
                    <h4>건강과 안전</h4>
                    <c:if test="${data.carbon_alarm eq 'o' }">
                    	<div class="safe_health_items">
	                        <i class="fas fa-check-circle"></i>
	                        <span>이산화탄소 경보기</span>
	                    </div>
                    </c:if>
                    
                    <c:if test="${data.fire_emble eq 'o' }">
                    	 <div class="safe_health_items">
                        	<i class="fas fa-check-circle"></i>
	                        <span>화재 경보기</span>
	                     </div>
                    </c:if>
                    
                </div>

            </div>
        </div>

   </div>
   <footer>
        푸터 
   </footer>

<div class="conven_popup" >
       
    <div class="main" >

        <div class="close-modal" onclick="close_modal(this)">
            <span>X</span>
        </div>

        <h2>편의 시설</h2>
        

        <div class = "nomal">
            <h3>기본 편의시설</h3>
			
			<c:if test="${data.wifi eq 'o' }">
				<div>
	                <div>무선 인터넷</div>
	                <div class="plus_font">숙소내 끊김없이 연결</div>
	            </div>
			</c:if>
			
			<c:if test="${data.requier eq 'o'}">
				<div>
	                <div>필수 품목</div>
	                <div class="plus_font">수건, 침태시트, 비누, 화장지</div>
	            </div>
			</c:if>
			
			<c:if test="${data.sampoo eq 'o'}">
				<div>
	                <div>샴푸</div>
	            </div>
			</c:if>
			
			<c:if test="${data.hiter eq 'o'}">
				<div>
	                <div>히터</div>
	            </div>
			</c:if>
			
			<c:if test="${data.breakfast eq 'o'}">
				<div>
	                <div>조식</div>
	            </div>
			</c:if>
			
			<c:if test="${data.hanger eq 'o'}">
				<div>
	                <div>옷걸이</div>
	            </div>
			</c:if>
			
			<c:if test="${data.iron eq 'o'}">
				<div>
	                <div>다리미</div>
	            </div>
			</c:if>
			
			<c:if test="${data.hiar_dry eq 'o'}">
				<div>
	                <div>헤어 드라이기</div>
	            </div>
			</c:if>
			
			<c:if test="${data.place_lattop eq 'o'}">
				<div>
	                <div>노트북 작업 공간</div>
	            </div>
			</c:if>
			
			<c:if test="${data.tv eq 'o'}">
				<div>
	                <div>TV</div>
	            </div>
			</c:if>
			
			<c:if test="${data.baby_bad eq 'o'}">
				<div>
	                <div>유아용 침대</div>
	            </div>
			</c:if>
			
			<c:if test="${data.baby_chairs eq 'o'}">
				<div>
	                <div>유아용 의자</div>
	            </div>
			</c:if>
			
			<c:if test="${data.self_checkin eq 'o'}">
				<div>
	                <div>셀프 체크인 </div>
	            </div>
			</c:if>
			
			<c:if test="${data.self_bth_room eq 'o'}">
				<div>
	                <div>욕실 단독 사용</div>
	            </div>
			</c:if>
			
			<c:if test="${data.piano eq 'o'}">
				<div>
	                <div>피아노</div>
	            </div>
			</c:if>
			
			<c:if test="${data.door eq 'o'}">
				<div>
	                <div>게스트 전용 출입문</div>
	            </div>
			</c:if>
			
        </div>

        <div class = "plant">
            <h3>계스트 이용 시설</h3>
            
            <c:if test="${data.liviroom eq 'o'}">
            	<div>
	                <div>거실</div>
	                <div class="plus_font" >숙소 밖 거실 게스트를 위한 거실 이용 가능 </div>
	            </div>
            </c:if>
            
            <c:if test="${data.cooking eq 'o'}">
            	<div>
	                <div>주방</div>
	                <div class="plus_font" >게스트를 위한 주방 이용 가능 </div>
	            </div>
            </c:if>
            
            <c:if test="${data.waching eq 'o'}">
            	<div>
	                <div>세탁기</div>
	                <div class="plus_font" >게스트를 위한 세탁기 이용 가능 </div>
	            </div>
            </c:if>
            
            <c:if test="${data.drying eq 'o'}">
            	<div>
	                <div>건조기</div>
	                <div class="plus_font" >게스트를 위한 건조기 이용 가능 </div>
	            </div>
            </c:if>
            
            <c:if test="${data.paking eq 'o'}">
            	<div>
	                <div>주차장</div>
	                <div class="plus_font" >게스트를 위한 주차장 이용 가능 </div>
	            </div>
            </c:if>
            
            <c:if test="${data.gym eq 'o'}">
            	<div>
	                <div>헬스장</div>
	                <div class="plus_font" >게스트를 위한 헬스장 이용 가능 </div>
	            </div>
            </c:if>
            
            <c:if test="${data.swim_pool eq 'o'}">
            	<div>
	                <div>실내 수영장</div>
	                <div class="plus_font" >게스트를 위한 실내 수영장 이용 가능 </div>
	            </div>
            </c:if>
            
            <c:if test="${data.jacuzzi eq 'o'}">
            	<div>
	                <div>자쿠지</div>
	                <div class="plus_font" >게스트를 위한 자쿠지 이용 가능 </div>
	            </div>
            </c:if>
            
            
        </div>
        
        <div class = "plant">
        	<h3>안전 시설</h3>
        	
        	<c:if test="${data.fire_emble eq 'o'}">
        		<div>
	        		<div>화재 경보기</div>
	        	</div>
        	</c:if>
        	
        	<c:if test="${data.carbon_alarm eq 'o'}">
        		<div>
	        		<div>일산화 탄소 경보기</div>
	        	</div>
        	</c:if>
        	
        	<c:if test="${data.madic_kit eq 'o'}">
        		<div>
	        		<div>구급 상자</div>
	        	</div>
        	</c:if>
        	
        	<c:if test="${data.fire_exting eq 'o'}">
        		<div>
	        		<div>소화기</div>
	        	</div>
        	</c:if>
        	
        	<c:if test="${data.bad_lock eq 'o'}">
        		<div>
	        		<div>침실 잠금장치</div>
	        	</div>
        	</c:if>
        	
        </div>

        <div class = "lack">
            <h3>숙소에 없는 시설</h3>
            
            <c:if test="${data.requier eq null || data.requier eq '' }">
            	<p><STRIKE>필수항목</STRIKE></p>
            </c:if>
			
			<c:if test="${data.aircon eq null || data.aircon eq '' }">
				<p><STRIKE>에어컨</STRIKE></p>
			</c:if>
			
			<c:if test="${data.sampoo eq null || data.sampoo eq '' }">
				<p><STRIKE>샴푸</STRIKE></p>
			</c:if>
			
			<c:if test="${data.hiter eq null || data.hiter eq '' }">
				<p><STRIKE>히터</STRIKE></p>
			</c:if>
			
			<c:if test="${data.in_hiter eq null || data.in_hiter eq '' }">
				<p><STRIKE>실내 벽난로</STRIKE></p>
			</c:if>
			
			<c:if test="${data.wifi eq null || data.wifi eq '' }">
				<p><STRIKE>WIFI</STRIKE></p>
			</c:if>
			
			<c:if test="${data.breakfast eq null || data.breakfast eq '' }">
				<p><STRIKE>조식</STRIKE></p>
			</c:if>
			
			<c:if test="${data.hanger eq null || data.hanger eq '' }">
				<p><STRIKE>옷걸이</STRIKE></p>
			</c:if>
			
			<c:if test="${data.iron eq null || data.iron eq '' }">
				<p><STRIKE>다리미</STRIKE></p>
			</c:if>
			
			<c:if test="${data.hiar_dry eq null || data.hiar_dry eq '' }">
				<p><STRIKE>헤어 드라이기</STRIKE></p>
			</c:if>
			
			<c:if test="${data.place_lattop eq null || data.place_lattop eq '' }">
				<p><STRIKE>노트북 작업 공간</STRIKE></p>
			</c:if>
			
			<c:if test="${data.tv eq null || data.tv eq '' }">
				<p><STRIKE>TV</STRIKE></p>
			</c:if>
			
			<c:if test="${data.baby_bad eq null || data.baby_bad eq '' }">
				<p><STRIKE>유아용 침대</STRIKE></p>
			</c:if>
			
			<c:if test="${data.baby_chairs eq null || data.baby_chairs eq '' }">
				<p><STRIKE>유아용 의자</STRIKE></p>
			</c:if>
			
			<c:if test="${data.self_checkin eq null || data.self_checkin eq '' }">
				<p><STRIKE>셀프 체크인</STRIKE></p>
			</c:if>
			
			<c:if test="${data.self_bth_room eq null || data.self_bth_room eq '' }">
				<p><STRIKE>욕실 단독 사용</STRIKE></p>
			</c:if>
			<c:if test="${data.piano eq null || data.piano eq '' }">
				<p><STRIKE>피아노</STRIKE></p>
			</c:if>
			
			<c:if test="${data.door eq null || data.door eq '' }">
				<p><STRIKE>게스트 전용 출입문</STRIKE></p>
			</c:if>
			
			<c:if test="${data.liviroom eq null || data.liviroom eq '' }">
				<p><STRIKE>거실</STRIKE></p>
			</c:if>
			
			<c:if test="${data.cooking eq null || data.cooking eq '' }">
				<p><STRIKE>주방</STRIKE></p>
			</c:if>
			
			<c:if test="${data.waching eq null || data.waching eq '' }">
				<p><STRIKE>세탁기</STRIKE></p>
			</c:if>
			
			<c:if test="${data.drying eq null || data.drying eq '' }">
				<p><STRIKE>건조기</STRIKE></p>
			</c:if>
			
			<c:if test="${data.paking eq null || data.paking eq '' }">
				<p><STRIKE>주차장</STRIKE></p>
			</c:if>
			
			<c:if test="${data.gym eq null || data.gym eq '' }">
				<p><STRIKE>헬스장</STRIKE></p>
			</c:if>
			
			<c:if test="${data.swim_pool eq null || data.swim_pool eq '' }">
				<p><STRIKE>실내 수영장</STRIKE></p>
			</c:if>
			
			<c:if test="${data.jacuzzi eq null || data.jacuzzi eq '' }">
				<p><STRIKE>자쿠지</STRIKE></p>
			</c:if>
			
			<c:if test="${data.fire_emble eq null || data.fire_emble eq '' }">
				<p><STRIKE>화재 경보기</STRIKE></p>
			</c:if>
			
			<c:if test="${data.carbon_alarm eq null || data.carbon_alarm eq '' }">
				<p><STRIKE>일산화탄소 경보기</STRIKE></p>
			</c:if>
			
			<c:if test="${data.madic_kit eq null || data.madic_kit eq '' }">
				<p><STRIKE>구급 상자</STRIKE></p>
			</c:if>
			
			<c:if test="${data.fire_exting eq null || data.fire_exting eq '' }">
				<p><STRIKE>소화기</STRIKE></p>
			</c:if>
			
			<c:if test="${data.bad_lock eq null || data.bad_lock eq '' }">
				<p><STRIKE>침실 잠금장치</STRIKE></p>
			</c:if>
			
        </div>

    </div>

</div>

<div class="comment_popup">
    <div>
        <div class="close-modal" onclick="close_modal(this)">
            <span>X</span>
        </div>
        <div class="ctnt_pop_main">
            <div class="pop_score">
                <i class="fas fa-star fa-lg"></i>
                <h2> ${data.comtAvg}점 (후기 ${data.cmtCount}개)</h2>
               
            </div>
    
            <div class="comment">
            	<c:forEach items="${data.hostReviewList}" var="item">
					<div class="user_comment">
	                    <div class="user_com_item">
	                        <span>
	                            <img class="user_plofile" src="${item.cmt_user_poto }" height="30px" width="30px">
	                        </span>
	                        <span>
	                            <div class="user_nm">${item.nm}</div>
	                            <div class="date">${item.r_dt}</div>
	                        </span>
	                    </div>
	                    <div>
	                       ${item.contents }
	                    </div>
	                </div>
				</c:forEach>
              
            </div>
        </div>
    </div>
</div>

<div class="rule_popup">
    <div>
        <div class="close-modal" onclick="close_modal(this)">
            <span>X</span>
        </div>
        <div class="rule_pop_main">
            <div class="rule_title">
                <h2> 숙소 이용 규칙</h2>
            </div>
    
            <div class="rule_ctnt">
            	
            	<div class="rule_ctnts">
            		<i class="far fa-clock fa-lg"></i>
            		<span>체크인 시간 ${data.checkin_t }</span>
            	</div>
            	
            	<div class="rule_ctnts">
            		<i class="far fa-clock fa-lg"></i>
            		<span>체크아웃 시간 ${data.checkin_t }</span>
            	</div>
            	
            	<c:if test="${data.child_ok eq 'o' }">
                   	<div class="rule_ctnts">
	            		<i class="fas fa-child fa-lg"></i>
	            		<span>어린이(2~12세) 숙박에 적합함</span>
	            	</div>
                </c:if>
                
                <c:if test="${data.y_ch_ok eq 'o' }">
                   	<div class="rule_ctnts">
	            		<i class="fas fa-baby fa-lg"></i>
	            		<span>유아(2세 미만) 숙박에 적합함 </span>
	            	</div>
                </c:if>
                
                <c:choose>
					<c:when test="${data.smoking eq 'o'}">
			    		<div class="rule_ctnts">
		            		<i class="fas fa-smoking fa-lg"></i>
		            		<span>숙소내 흡연 가능</span>
		            	</div>
					</c:when>
					<c:otherwise>
			    		<div class="rule_ctnts">
		            		<i class="fas fa-smoking-ban fa-lg"></i>
		            		<span>흡연 금지</span>
		            	</div>
					</c:otherwise>
				</c:choose>
           		
           		<c:choose>
					<c:when test="${data.animal_ok eq 'o'}">
					    <div class="rule_ctnts">
		            		<i class="fas fa-dog fa-lg"></i>
		            		<span>반려 동물동반에 적합함</span>
		            	</div>
					
					</c:when>
					<c:otherwise>
			    		<STRIKE class="rule_ctnts">
							<i class="fas fa-dog fa-lg"></i>
							<span>반려 동물동반에 부적합</span>
						</STRIKE>
					</c:otherwise>
				</c:choose>
            	
            	<c:if test="${data.party eq 'o'}">
            		<div class="rule_ctnts">
	            		<i class="fas fa-birthday-cake fa-lg"></i>
	            		<span>숙소내 행상,파티 허용</span>
	            	</div>
            	</c:if>
            	
            </div>
            
            <h3>게스트가 숙소에 대해 알아두어야 할 세부 사항</h3>
            
            <div class="room_dt_rule">
            	<c:if test="${data.stairs eq 'o' }">
            		<div>계단을 올라가야 함</div>
            	</c:if>
            	<c:if test="${data.noise eq 'o' }">
            		<div>소음이 발생할 수 있음(숙소 내)</div>
            	</c:if>
            	<c:if test="${data.animal eq 'o' }">
            		<div>숙소에 반려동물 있음</div>
            	</c:if>
            	<c:if test="${data.in_pking eq 'o' }">
            		<div>건물 내 주차 불가</div>
            	</c:if>
            	<c:if test="${data.public_space eq 'o' }">
            		<div>일부 공용 공간 있음</div>
            	</c:if>
            	<c:if test="${data.plant eq 'o' }">
            		<div>편의시설 제한</div>
            	</c:if>
            	<c:if test="${data.cctv eq 'o' }">
            		<div>숙소에 감시 또는 녹화 장치 설치</div>
            	</c:if>
            	
            	<c:if test="${data.weapon eq 'o' }">
            		<div>숙소에 무기 있음</div>
            	</c:if>
            	
            	<c:if test="${data.denger_dog eq 'o' }">
            		<div>숙소에 위험한 동물 있음</div>
            	</c:if>
            </div>
            
			<h3>추가 이용 규칙</h3>
			
			<c:forEach items="${data.dtlRuleList}" var="item">
				<div class="dtRule">
					${item.rule}
				</div> 
			</c:forEach>
			
        </div>
    </div>
</div>

<div class="popup1">
    <div class="likeLisPopup">
        <span class="close-modal" onclick="close_modal(this)" >X</span>
        <span class="like_title">목록에 저장하기</span>
        <hr id="afList">
        <c:forEach items="${data.userLList}" var="item" >
        	<div class="like_list" >${item.list_title}</div>
        	<input type="hidden" id="i_list" value="${item.i_list}"> 
        </c:forEach>
        
    <button type="button" id="ctButton">목록 만들기</button>
    </div>
</div>

<div class="popup2">
	<div class="likePopup">
		<span class="close-modal" onclick="close_modal(this)">X</span> 
		<span class="like_title">목록 이름 작성하기</span>
		<hr>
		<div>
			<input type="text" id="list_title" value="" placeholder="이름 : ">
		</div>
		<hr>
		<button type="button" id="sLikeButton">새로 만들기</button>
	</div>
</div>
   

</body>
<script type="text/javascript" src="/resources/js/searchDetail.js"></script>
<script type="text/javascript">
function initMap() {
	var uluru; //좌표 넣을 변수 
	var marker;// 마커 넣을 변수 
	
	// 기준점이 되는 좌표 
	
		uluru = {lat: ${data.c_lat} , lng: ${data.c_lng}};
	
	// 지도 생성 
	var map = new google.maps.Map(
  		      document.getElementById('map'), {zoom: 7, center: uluru});
	 	
		// 마커 표시 (for문 )
		 	uluru 	= {lat: ${data.s_lat}, lng: ${data.s_lng} };
		 	marker 	= new google.maps.Marker({
		 					map: map,
		 					draggable: true,
		 		          	animation: google.maps.Animation.DROP,
		 					position: uluru, 
		 					
		 			});
		 	var infowindow = new google.maps.InfoWindow({
	  		    content: " ${data.room_title} "
	  		  });
		 	 
		 	google.maps.event.addListener(marker,'click', (function(marker,infowindow){ 
	  		    return function() {
	  		        infowindow.open(map,marker);
	  		    };
	  		})(marker,infowindow));
		 	 
		 
		   
	}
</script>
</html>