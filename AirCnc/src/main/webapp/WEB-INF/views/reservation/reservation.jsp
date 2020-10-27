<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://kit.fontawesome.com/ea36f2192f.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="/resources/css/reservation.css">
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script type="text/javascript" src="/resources/js/reservation.js"></script>
<title>Reservation</title>
</head>
<body>
	<fmt:parseDate value="${sData.chin } ${data.checkin_t}" var="chin" pattern="yyyy-MM-dd HH:mm:ss"/>
	<fmt:parseDate value="${sData.chout} ${data.finich_t}" var="chout" pattern="yyyy-MM-dd HH:mm:ss"/>
	 <header>
        <div class="banner">
            <a href="/" class="logo"> 
                <span>
                    <img src="/resources/img/aircncLog.png">
                </span>
            </a>
            
            
            <span class="top_menu">
                <u onclick="nextPage1()">
                    1. 숙소 이용규칙 확인
                </u>
                <span> > </span>

                <u onclick="nextPage2()">
                    2. 게스트 정보 입력 
                </u>

                <span> > </span>

                <u onclick="nextPage3()">
                    3. 확인 및 결제
                </u>
            </span>

        </div>
    </header>
    <form action="/reservation/rsvSave" class="container" method="post" id="frm">
        
        <section class="main1">
            <div class="title">
                <h2>숙소 이용규칙 확인하기</h2>
            </div>
            <div class="host_state">
                <div class="host_state_main">
                    <span class="state_main_emog">
                        <i class="fas fa-gem fa-lg"></i>
                    </span>
                    <span class="state_main_text">
                        <span>	흔치 않은 기회입니다. ${data.nm}님의 숙소는 보통 예약이 가득 차 있습니다.</span>
                    </span>
                </div>
            </div>
            <div class="top_info">
                <div class="addr_title">
                    <h3>${sData.addr} ${sData.date}박</h3>
                </div>
                <div class="re_date">
                    <span class="re_date_item1">
                        <div class="date_sub1">
                            <div>${fn:substring(sData.chin,5,7) }월</div>
                            <div class="date">${fn:substring(sData.chin,8,10) }</div>
                        </div>
                        <div class="date_sub2">
                            <div>체크인: <fmt:formatDate value="${chin}" pattern="E"/>요일 </div>
                            <div><fmt:formatDate value="${chin}" type="time"/></div>
                        </div>
                    </span>
                    <span class="re_date_item2">
                        <div class="date_sub1">
                            <div>${fn:substring(sData.chout,5,7) }월</div>
                            <div class="date">${fn:substring(sData.chout,8,10) }</div>
                        </div>
                        <div class="date_sub2">
                            <div>체크아웃: <fmt:formatDate value="${chout}" pattern="E"/>요일</div>
                            <div><fmt:formatDate value="${chout}" type="time"/></div>
                        
                        </div>
                    </span>
                </div>
                <div class="self_checkin">
                    <c:if  test="${data.self_checkin eq 'o'}">                
	                    <span class="key_fakey"><i class="fas fa-key"></i></span>
	                    <span class="checkin_text">
	                        	키패드(으)로 셀프 체크인
	                    </span>
                	</c:if>
                </div>
            </div>
            <div class="care_ctnt">
                <h3>주의할 사항</h3>
                <div class="care_main">
					<c:if test="${data.child_ok eq 'o' }">
				     	<div class="rule_dt_itmes">
					      	<span class="rule_dt_itmes1">
								<i class="fas fa-child fa-lg"></i>
							</span>
						<span class="rule_dt_itmes2">어린이(2~12세) 숙박에 적합함</span>
					</div>
					    	</c:if>
					
					<c:if test="${data.y_ch_ok eq 'o' }">
			    	<div class="rule_dt_itmes">
			     		<span class="rule_dt_itmes1">
							<i class="fas fa-baby fa-lg"></i>
						</span>
						<span class="rule_dt_itmes2">유아(2세 미만) 숙박에 적합함 </span>
					</div>
					     </c:if>
					
					<c:choose>
					<c:when test="${data.smoking eq 'o'}">
			    	<div class="rule_dt_itmes">
			     		<span class="rule_dt_itmes1">
							<i class="fas fa-smoking fa-lg"></i>
						</span>
						<span class="rule_dt_itmes2">숙소 내 흡연 가능</span>
					</div>
					    	</c:when>
					<c:otherwise>
					<div class="rule_dt_itmes">
					    <span class="rule_dt_itmes1">
					        <i class="fas fa-smoking-ban fa-lg"></i>
					    </span>
					
					    <span class="rule_dt_itmes2">흡연 금지</span>
					</div>
					</c:otherwise>
					</c:choose>
					
					<c:choose>
					<c:when test="${data.animal_ok eq 'o'}">
				    	<div class="rule_dt_itmes">
			    			<span class="rule_dt_itmes1">
								<i class="fas fa-dog fa-lg"></i>
							</span>
							<span class="rule_dt_itmes2">반려 동물동반에 적합함</span>
						</div>
					</c:when>
					<c:otherwise>
						<STRIKE class="rule_dt_itmes">
						    <span class="rule_dt_itmes1">
						        <i class="fas fa-dog fa-lg"></i>
						    </span>
						    
						    <span class="rule_dt_itmes2">반려 동물동반에 부적합</span>
						</STRIKE>
					</c:otherwise>
					</c:choose>
					
					<c:if test="${data.party eq 'o' }">
						<div class="rule_dt_itmes">
						    <span class="rule_dt_itmes1">
						        <i class="fas fa-birthday-cake fa-lg"></i>
						    </span>
						    
						    <span class="rule_dt_itmes2">파티나 이벤트 허용</span>
						</div>
					</c:if>	
                </div>
            </div>
            <div class="plus_care">
                <div class="plus_care_item">
                    <h5>추가 규칙</h5>
                    <c:forEach items="${data.dtlRuleList}" var="item">
						<div>
							*	${item.rule}
						</div> 
					</c:forEach>
                </div>
                <div class="care_button" onclick="dropText()">더 보기↓</div>
            </div>
            <div>
                <div class="agree_Button" onclick="nextPage2()">동의 및 계속 하기</div>
            </div>
        </section>

        <section class="main2">
            <div class="main2_item">
                <div class="main2_item1">
                    <h2> 일행이 있나요? </h2>
                </div>
                <div class="main2_item2">
                    <div class="main2_item2_box">
                        <h3>인원</h3>
                        <div>
                            <button type="button" onclick="countDw(document.getElementById('qty'))">-</button>
                            <input type="number" id="qty" name="qty" size="10" value="${sData.qty}" readonly>
                            <button type="button" onclick="countUp(document.getElementById('qty'))">+</button>
                            <span class="qty_erro"></span>
                        </div>
                        
                    </div>
                </div>
                <div class="main2_item3">
                <div>
                        <div>
                            <div class="chinTimeText">
                                <div>
                                    <h3>체크인 시간</h3>
                                </div>
                                <div>지금 예약하려면, <fmt:formatDate value="${chin}" type="time"/> 이후에 체크인해야 합니다.</div>
                            </div>
                            <div class="chinTime">
                                <div class="chinTimeMain"><fmt:formatDate value="${chin}" type="time"/> - <fmt:formatDate value="${chout}" type="time"/></div>
                                <div></div>
                                <div></div>
                            </div>
                        </div>
                </div>
                </div>
                <div class="main2_item4">
                    <div>
                        <div class="userMsg">
                            <div class="MsgTitle">
                                <h4>호스트에게 인사하기</h4>
                                <div>
                                    ${data.nm}님에게 간단히 자신을 소개하고 여행 목적에 대해 알려주세요.
                                </div>
                            </div>
                            <div class="hostPoto">
                                <img class="host_profile" src="${data.my_profile}">
                            </div>
                        </div>

                        <div class="userMsgText">
                        	<input type="hidden" name="ms_title" value="${data.room_title}(${loginUser.nm})"> 
                            <div>
                                <textarea name="cmt" id="cmt" placeholder="${data.nm}님, 안녕하세요! 숙소에서 보낼 멋진 6박이 기다려집니다!"></textarea>
                            </div>
                            <div class="msg_erro"></div>
                        </div>
                    </div>
                </div>
                <div class="main2_item5">
                    <div>
                        <div>
                            <div class="agree_Button" onclick="nextPage3()">계속 하기</div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section class="main3">
        <div class="main3_item">
            <div class="main3_item1">
                <h1>확인 및 결제</h1>
            </div>
            <div class="main3_item2">
                <div class="payment-options-selector">
                        <div class="selector_title">
                            <span>결제 수단</span>
                            <span>
                                <i class="fab fa-cc-visa fa-lg"></i>
                                <i class="fab fa-cc-amex fa-lg"></i>
                                <i class="fab fa-cc-mastercard fa-lg"></i>
                            </span>
                        </div>
                        <div class="selector_text">
                            <span><i class="far fa-credit-card fa-lg"></i></span>
                            <span>신용카드 또는 체크카드</span>
                        </div>
                </div>

                <div class="user_card_info">
                    <div>
                        <div class="user_nm">
                            <div>
                                <div class="nm_main">
                                    <span>
                                        <div class="nm_title">이름</div>
                                        <div class="nm">
                                            <input type="text" name="card_user_nm" value="${loginUser.nm}" placeholder="이름(홍길동)">
                                        </div>
                                    </span>
                                </div>
                            </div>
                        </div>
                        <div class="card_info">
                            <div class="card_title">
                               		 캬드 정보
                            </div>
                            <div>
                                <div class="cardnum">
                                    <input type="text" name="card_num" id="card_num" onfocus="goComfirm()" onkeypress="return onlyNumber(event)" onkeyup="changeCard_num(this)"  placeholder="카드번호" >
                                </div>
                                <div class="card_info_main">
                                    <input type="text" name="ym" id="ym" onfocus="goComfirm()" onkeypress="return onlyNumber(event)" onkeyup="changeYm(this)"  placeholder="만료일"  >
                                    <input type="number" name="cvv" id="cvv" onfocus="goComfirm()" onkeypress="return onlyNumber(event)" onkeyup="changeCvv(this)"  placeholder="CVV" >
                                </div>

                            </div>
                        </div>
                        
                        <div class="erro1"></div>

                        <div class="addr_info">

                            <div class="addr_info_title">
                                <div>청구지 정보</div>
                                <div>국가</div>
                            </div>

                            <div class="addr_info_main">
                                <input type="text" name="zip_code" id="zip_code" onfocus="goComfirm()" onkeypress="return onlyNumber(event)" onkeyup="changeZip_code(this)" placeholder="우편번호">
                                
                                <select name="country" onfocus="goComfirm()" >
                                    <option value="korea" selected >한국</option>
                                    <option value="jappan">일본</option>
                                    <option value="china">중국</option>
                                </select>
                                    
                            </div>

                        </div>
                        <div class="erro2"></div>
                    </div>
                </div>

            </div>
            <div class="main3_item3">
                    <div>
                        <div>
                            <div class="agree_Button" onclick="goReservation()">
                                <i class="fas fa-lock"></i>
                                <div>예약 요청하기</div>
                            </div>
                        </div>
                    </div>
            </div>
        </div>
        </section>
        
        <section class="pay">
        <div class="pay_container">
            <div class="pay_ctnt">
                <div>
                    <div class="pay_ctnt1">
                        <div class="pay_info">
                            <div class="pay_info1">
                                ${data.room_title }
                            </div>
                            <div class="pay_info2">${sData.addr}의 
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
                                    <i class="fas fa-star"></i>
                                    <span>${data.comtAvg}점(후기 ${data.cmtCount}개)</span>
                            </div>
                        </div>
                        <div class="pay_img">
						<c:forEach items="${data.roomImgList}" var="roomImglist">
							<img class="home_img" src="${roomImglist.room_poto}">
						</c:forEach>
                        </div>
                    </div>
                    <div class="pay_ctnt2" ></div>
                    <div class="pay_ctnt3">
                        <div class="date_main">
                            <div class="qty">
                                    <span>
                                        <i class="fas fa-user-friends"></i>
                                    </span>
                                    <span>게스트 ${sData.qty}명</span>
                            </div>
                            <div class="date">
                                    <span>
                                        <i class="far fa-calendar"></i>
                                    </span>
                                    <span>
                                        ${fn:substring(sData.chin,0,4)}년 ${fn:substring(sData.chin,5,7)}월 ${fn:substring(sData.chin,8,10)}일 → ${fn:substring(sData.chout,0,4)}년 ${fn:substring(sData.chout,5,7)}월 ${fn:substring(sData.chout,8,10)}일
                                    </span>
                            </div>
                        </div>
                        <div class="solid" ></div>
                        <input type="hidden" name="i_host" 		id="i_host" 	value="${sData.i_host}">
                        <input type="hidden" name="chin"		id="chin" 		value="${sData.chin}">
                        <input type="hidden" name="chout"		id="chout" 		value="${sData.chout}">
                        <input type="hidden" name="total_fee"	id="total_fee"	value="${data.fee*sData.date*sData.qty}">
                        <input type="hidden" name="op_i_user"	value="${data.i_user}">
                        <input type="hidden" name="date" 		id="date"  		value="${sData.date}">
                        <input type="hidden" id="fee" 			value="${data.fee}">
                        
                        
                        <div class="fee_info">
                                <div class="fee-main">
                                    <div class="date_fee"> 
                                    <span><fmt:setLocale value="ko_KR"/><fmt:formatNumber type="currency" value="${data.fee}" /> X ${sData.date}박</span>
                                    <span><fmt:setLocale value="ko_KR"/><fmt:formatNumber type="currency" value="${data.fee*sData.date}" /></span>
                                    </div>
                                    <div class="qty_fee">
                                        <span><fmt:setLocale value="ko_KR"/><fmt:formatNumber type="currency" value="${data.fee*sData.date}" /> X ${sData.qty}명</span>
                                        <span><fmt:setLocale value="ko_KR"/><fmt:formatNumber type="currency" value="${data.fee*sData.date*sData.qty}" /></span>
                                    </div>
                                    <div class="solid" ></div>
                                    <div class="total_fee">
                                        <span>총 합계 (KRW)</span>
                                        <span><fmt:setLocale value="ko_KR"/><fmt:formatNumber type="currency" value="${data.fee*sData.date*sData.qty}" /></span>
                                    </div>
                                </div>
                        </div>
                    </div>
                </div>
                </div>
        </div>
        </section>

    </form>
   
    <footer>
        푸터
    </footer>
</body>
</html>