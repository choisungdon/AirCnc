<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 	<!-- daterangepiker(달력)-->
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
    <script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
    <!-- 이모티콘 라이브러리 -->
    <script src="https://kit.fontawesome.com/ea36f2192f.js" crossorigin="anonymous"></script>
	<!-- css js -->
	<script type="text/javascript" src="/resources/js/hostSaveSix.js"></script>
	<link rel="stylesheet" href="/resources/css/hostSaveSix.css">
<title>hostSaveSix</title>
</head>
<body>



	 <header>
        <span class="log_img">
            <a href="/" class="logo">
                <i class="fab fa-airbnb fa-2x"></i>
            </a>
            <span>숙소 등록 7단계 </span>
        </span>
        
        <a href="/" class="his_back">  
            	나가기 
        </a>
    </header>
    <div class="ctnt_step">
        <span class="step01"></span>
        <span class="step02"></span>
        <span class="step03"></span>
        <span class="step04"></span>
        <span class="step05"></span>
        <span class="step06"></span>
        <span class="step07"></span>
        <span class="step08"></span>
        <span class="step09"></span>
        <span class="step10"></span>
    </div>

    <div class="container">
        <div class="ctnt_host">
            <section class="host_ctnt_main">
                <div class="host_title">
                    <div class="title_text"> ${loginUser.nm} 님 체크인까지 최소한 어느 정도의 시간 여유가 있어야 하나요?</div>
                   
                </div>
                <form class="hostSaveSix" action="/host/hostSaveSeven" method="post">
                    <input type="hidden" name="i_host" value="${i_host}">
                    <input type="hidden" name="i_user" value="${loginUser.i_user}">
                    <c:if test="${vo.i_ck != null}"> 
                        <input type="hidden"  name="i_ck" value="${vo.i_ck}">
                    </c:if>

                   <div class="ctnt_main">

                        <div class="title_sub01">
                            	체크인 가능 시간을 선택해 주세요.
                        </div>

                        <div class="time_input_main">
                            <div class="start">
                                <div class="start_title">
                                    	시작 : 
                                </div>
                                <select name="checkin_t" id="checkin_t">
                                	<!--오전 8시 ~ 오후 12시 까지  option 만들기 -->
                                	<c:forEach var="i" begin="080000" end="240000" step="10000" >

										<fmt:parseNumber var="j" integerOnly="true" 
									                       type="number" value="${i/10000}" />
									     <c:choose>
									     	<c:when test="${j > 12}">
									     		<option value="${i}" ${i == fn:replace(vo.checkin_t, ':', '') ? 'selected' : '' }>오후  ${j-12}:00</option>
									     	</c:when>
									     	<c:otherwise>
									     		<option value="${i}" ${i == fn:replace(vo.checkin_t, ':', '') ? 'selected' : '' }>오전  ${ j}:00</option>
									     	</c:otherwise>
									     </c:choose>
										
									</c:forEach>
                                    
                                </select>
                            </div>

                            <div class="stop">
                                <div class="stop_title">
                                    	종료 :
                                </div>
                                <select name="finich_t" id="finich_t">
                                    <!--오전 8시 ~ 오후 12시 까지  option 만들기 -->
                                	<c:forEach var="i" begin="080000" end="240000" step="10000" >

										<fmt:parseNumber var="j" integerOnly="true" 
									                       type="number" value="${i/10000}" />
									     <c:choose>
									     	<c:when test="${j > 12}">
									     		<option value="${i}" ${i == fn:replace(vo.finich_t, ':', '') ? 'selected' : '' }>오후  ${j-12}:00</option>
									     	</c:when>
									     	<c:otherwise>
									     		<option value="${i}" ${i == fn:replace(vo.finich_t, ':', '') ? 'selected' : '' }>오전  ${ j}:00</option>
									     	</c:otherwise>
									     </c:choose>
										
									</c:forEach>
                                </select>
                            </div>  
                        </div>

                       

                        <div class="host_title">
                            <div class="title_text">게스트가 얼마 동안 숙박할 수 있나요?</div>
                            <div class="title_texts">
                                	숙박 기간이 짧으면 예약을 더 많이 받을 수 있지만, 
                                <br>
                                	새로운 게스트를 맞이하기 위한 호스팅 준비도 더 자주 해야 합니다.
                            </div>
                        </div>

                        <div class="date_ctnt">
                            <div class="ieast_items">
                                <input 	id="ieast_day" 	name="ieast_day" type="number" 		value="${(vo.ieast_day != null && vo.ieast_day != 0) ? vo.ieast_day : 1 }" >
                                
                                <span class="date_sub_text">
                                    	박(최소)
                                </span>
                                
                                <div class="up_count" onclick="countUp(document.getElementById('ieast_day'))">
                                    <i class="fas fa-plus"></i>
                                </div>
                               
                                <div class="down_count" onclick="countDw(document.getElementById('ieast_day'))">
                                    <i class="fas fa-minus"></i>
                                </div>
                               
                            </div>

                            <div class="erro_ctnt">
                                <i class="fas fa-exclamation-triangle"></i>
                                <div class="erro_text">
                                    	최소 숙박일수는 최대 <br> 숙박일수를 넘을 수 없습니다.
                                </div>
                            </div>

                            <div class="max_itmes">
                                <input 	id="max_day" 	name="max_day"		type="number"	placeholder="박(최대)"	value="${(vo.max_day != null && vo.max_day != 0) ? vo.max_day : 2 }" >
                                
                                <span class="date_sub_text">
                                   	 박(최대)
                                </span>
                                
                                <div class="up_count" onclick="countUp(document.getElementById('max_day'))">
                                    <i class="fas fa-plus"></i>
                                </div>
                               
                                <div class="down_count" onclick="countDw(document.getElementById('max_day'))">
                                    <i class="fas fa-minus"></i>
                                </div>
                            </div>

                            <div class="erro_ctnt">
                                <i class="fas fa-exclamation-triangle"></i>
                                <div class="erro_text">
                                   	 최소 숙박일수는 최대  <br> 숙박일수를 넘을 수 없습니다.
                                </div>
                            </div>

                            <div class="host_title">
                                <div class="title_text">예약 가능 여부 설정하기</div>
                                <div class="title_texts">
                                    	간단한 방법으로 달력을 수정할 수 있어요. 
                                    <br>
                                    	예약을 차단하거나 차단 해제할 날짜를 선택하기만 하면 됩니다. 
                                    <br>
                                    	숙소를 등록한 후에도 언제든지 변경할 수 있습니다.
                                </div>
                            </div>

                            <div class="time_input_main">
                                <div class="start">
                                    <div class="start_title">
                                       	 예약 가능 날짜
                                    </div>
                                    <input id="reser_date" name="reser_date" type="text" value="${(vo.reser_date != null && vo.reser_date != '') ? vo.reser_date : '' }" placeholder="날짜 추가" readonly="readonly">
                                </div>
    
                                <div class="stop">
                                    <div class="stop_title">
                                        	예약 마감 날짜
                                    </div>
                                    <input id="reser_end_t" name="reser_end_t" type="text" value="${(vo.reser_end_t != null && vo.reser_end_t != '') ? vo.reser_end_t : '' }" placeholder="날짜 추가" readonly="readonly">
                                   
                                </div>  
                            </div>

                        </div>
                        
                   </div>
                    <div class="nepre_tag">
                        <span class="previous" onclick="backPage(${hostingPkVo.i_host},${hostingPkVo.i_rule},${hostingPkVo.i_dtr})"><i class="fas fa-chevron-left"></i> 뒤로</span>
                        <span class="next">다음</span>
                    </div>
                </form>
            </section>
        </div>
        <div class="ctnt_exp">
           
        </div>
        
    </div>
    
</body>
</html>