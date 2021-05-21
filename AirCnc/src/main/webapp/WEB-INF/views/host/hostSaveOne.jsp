<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://kit.fontawesome.com/ea36f2192f.js" crossorigin="anonymous"></script>
<script type="text/javascript" src="/resources/js/hostSaveOne.js"></script>
<link rel="stylesheet" href="/resources/css/hostSaveOne.css">

<title></title>
</head>
<body>
	<header>
        <span class="log_img">
            <a href="/" class="logo">
                <i class="fab fa-airbnb fa-2x"></i>
            </a>
            <span>숙소 등록 2단계 </span>
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
                    <div class="title_text"> ${loginUser.nm} 님 등록하실 숙소 종류는 무엇인가요?</div>
                </div>
                <form class="hostSaveTwo" action="/host/hostSaveTwo" method="post">
                    <input type="hidden" name="i_user" value="${loginUser.i_user}">
                    <input type="hidden" id="i_host" name="i_host" value="${i_host}">
                    <c:if test="${vo.i_build != null}">
                        <input type="hidden" name="i_build" value="${vo.i_build}">
                    </c:if>

                    <div class="b_room">
                        <div class="title07">
                            	숙소의 건물 유형을 선택해주세요.
                        </div>
                        
                       
                        <div class="SelTypeMain" onclick="dropMenu(this.children[2])">
                            <div class="selText">
                            	<c:choose>
                            		<c:when test="${vo.typ eq 'apt'}">
                            			아파트
                            		</c:when>
                            		
                            		<c:when test="${vo.typ eq 'outbuild'}">
                            			별채
                            		</c:when>
                            		
                            		<c:otherwise>
								        
								    </c:otherwise>
                            	</c:choose>
                            </div>
                            <i class="fas fa-arrow-down"></i>

                            <div class="drop_select" >
                                <div class="main_select">
                                    <div class="select_item" >
                                        <div class="yn551" onclick="selType(this)">
                                            <div class="item_title">
                                                	아파트
                                            </div>
                                            <div class="item_remark">
                                                 	일반적으로 다세대가 거주하는 건물 또는 여러 사람이 함께 거주하는 단지를 의미합니다.
                                            </div>
                                        </div>
                                        <i class="fas fa-check" style="display: ${vo.typ eq 'apt' ? 'block' : 'none'};"></i>
                                    </div>

                                    <div class="select_item">
                                        <div class="yn551" onclick="selType(this)">
                                            <div class="item_title">
                                                	별채
                                            </div>
                                            <div class="item_remark">
                                                	게스트용 전용 출입구가 있으며, 보통 다른 구조물과 필지를 공유합니다.
                                            </div>
                                        </div>
                                        <i class="fas fa-check" style="display: ${vo.typ eq 'outbuild' ? 'block' : 'none'};"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--서버에 넘길 데이터 태그 -->
                        <input type="hidden" id="typ"  name="typ" value="${vo.typ}"> 
                        
                        <div class="title07">
                            	게스트가 이용할 숙소 유형을 확인해주세요.
                        </div>

                        <div class="SelTypeMain" onclick="dropMenu(this.children[2])">
                            <div class="selText">
                            	<c:choose>
                            		<c:when test="${vo.live_type eq 'all'}">
                            			집전체
                            		</c:when>
                            		
                            		<c:when test="${vo.live_type eq 'single'}">
                            			개인실
                            		</c:when>
                            		
                            		<c:when test="${vo.live_type eq 'share'}">
                            			다인실
                            		</c:when>
                            		
                            		<c:otherwise>
								        
								    </c:otherwise>
                            	</c:choose>
                            </div>
                            <i class="fas fa-arrow-down"></i>

                            <div class="drop_select01" >
                                <div class="main_select01">

                                    <div class="select_item01" >
                                        <div class="yn55101" onclick="selLiveType(this)">
                                            <div class="item_title">
                                                	집전체
                                            </div>
                                            <div class="item_remark">
                                                	게스트가 숙소 전체를 다른 사람과 공유하지 않고 단독으로 이용합니다. 게스트 전용 출입구가 있고 공용 공간이 없습니다.  일반적으로 침실, 욕실, 부엌이 포함됩니다.
                                            </div>
                                        </div>
                                        <i class="fas fa-check" style="display: ${vo.live_type eq 'all' ? 'block' : 'none'};"></i>
                                    </div>

                                    <div class="select_item01">
                                        <div class="yn55101" onclick="selLiveType(this)">
                                            <div class="item_title">
                                                	개인실
                                            </div>
                                            <div class="item_remark">
                                                	게스트에게 개인 침실이 제공됩니다. 침실 이외의 공간은 공용일 수 있습니다.
                                            </div>
                                        </div>
                                        <i class="fas fa-check" style="display: ${vo.live_type eq 'single' ? 'block' : 'none'};"></i>
                                    </div>

                                    <div class="select_item01" >
                                        <div class="yn55101" onclick="selLiveType(this)">
                                            <div class="item_title">
                                                	다인실
                                            </div>
                                            <div class="item_remark">
                                                	게스트는 개인 공간 없이, 다른 사람과 함께 쓰는 침실이나 공용 공간에서 숙박합니다.
                                            </div>
                                        </div>
                                        <i class="fas fa-check" style="display: ${vo.live_type eq 'share' ? 'block' : 'none'};"></i>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <!--서버에 넘길 데이터 태그 -->
                        <input type="hidden" id="live_type"  name="live_type" value="${vo.live_type}"> 
                    </div>

                    <div class="nepre_tag">
                        <span class="previous"><i class="fas fa-chevron-left"></i> 뒤로</span>
                        <span class="next">다음</span>
                    </div>
                </form>
            </section>
        </div>
        <div class="ctnt_exp">
           
        </div>
    </div>
    <!-- 
	<form action="/host/hostSaveTwo" method="post">
		<input type="hidden" name="i_user" value="${loginUser.i_user}">
		<input type="hidden" name="i_host" value="${i_host}">
		<c:if test="${vo.i_build != null}">
			<input type="hidden" name="i_build" value="${vo.i_build}">
		</c:if>
		<div>2단계 ${loginUser.nm}님 등록하실 숙소 종류는 무엇인가요? </div>
		<div>
			<p>건물 유형을 선택하세요</p>
			<select name="typ">
				<option value="apt" ${vo.typ eq 'apt' ? 'selected="selected"' : ''} >아파트</option>
				<option value="outbuild" ${vo.typ eq 'outbuild' ? 'selected="selected"' : ''} >별채</option>
			</select>
		</div>
		<div>
			<p>게스트가 묵게 될 숙소 유형을 골라주세요.</p>
			<input type="radio" name="live_type" value="all" ${vo.live_type eq 'all' ? 'checked="checked"' : ''} > 집 전체
			<input type="radio" name="live_type" value="single" ${vo.live_type eq 'single' ? 'checked="checked"' : ''} >개인실
			<input type="radio" name="live_type" value="share" ${vo.live_type eq 'share' ? 'checked="checked"' : ''}>다인실
		</div>
		
		<input type="submit" value="다음">
	</form>
	 -->
</body>
</html>