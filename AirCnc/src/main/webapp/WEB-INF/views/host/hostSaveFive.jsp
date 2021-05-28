<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
	<script src="https://kit.fontawesome.com/ea36f2192f.js" crossorigin="anonymous"></script>
	<script type="text/javascript" src="/resources/js/hostSaveFive.js"></script>
	<link rel="stylesheet" href="/resources/css/hostSaveFive.css">
    <title>HostSaveFive</title>
</head>
<body>
	<header>
        <span class="log_img">
            <a href="/" class="logo">
                <i class="fab fa-airbnb fa-2x"></i>
            </a>
            <span>숙소 등록 6단계 </span>
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
                    <div class="title_text"> ${loginUser.nm} 님 게스트가 지켜야 할 숙소 이용규칙을 정하세요.</div>
                    <div class="text_arr">
                       	 게스트는 예약하기 전에 숙소 이용규칙에 동의해야 합니다.
                    </div>
                </div>
                <form class="hostSaveFive" action="/host/hostSaveSix" method="post">
                    <input type="hidden" id="i_host" name="i_host" value="${i_host}">
                    <input type="hidden" id="i_user" name="i_user" value="${loginUser.i_user}">
                    <c:if test="${vo2.i_rule != null && vo3.i_dtr != null}">
                        <input type="hidden"  name="i_rule" value="${vo2.i_rule}">
                        <input type="hidden"  name="i_dtr" value="${vo3.i_dtr}">
                    </c:if>

                    <div class="b_room">
                        <div class="checkBoxMain" onclick="checkBox(document.getElementById('checkBox1'),document.getElementById('child_ok'))">
                           <input type="checkbox" name="child_ok" id="child_ok" value="o" ${vo2.child_ok != 'o' ? '' : 'checked="checked"' }> 
							
							<c:choose>
								<c:when test="${vo2.child_ok eq 'o'}">
									<label class="far fa-check-square fa-2x" id="checkBox1" ></label>
								</c:when>
								<c:otherwise>
									<label class="far fa-square fa-2x" id="checkBox1" ></label>
								</c:otherwise>
							</c:choose>
                            
                            
                            <div class="checkBoxRemark">
                                <div class="checkBoxRemark1">
                                    	어린이(2~12세) 숙박에 적합함
                                </div>
                             </div>
                        </div>
                        
                        <div class="checkBoxMain" onclick="checkBox(document.getElementById('checkBox2'),document.getElementById('y_ch_ok'))">
                            <input type="checkbox" name="y_ch_ok" id="y_ch_ok" value="o" ${vo2.y_ch_ok != 'o' ? '' : 'checked="checked"' }> 

                            <c:choose>
								<c:when test="${vo2.y_ch_ok eq 'o'}">
									<label class="far fa-check-square fa-2x" id="checkBox2" ></label>
								</c:when>
								<c:otherwise>
									<label class="far fa-square fa-2x" id="checkBox2" ></label>
								</c:otherwise>
							</c:choose>
                            
                            <div class="checkBoxRemark">
                                <div class="checkBoxRemark1">
                                    	유아(2세 미만) 숙박에 적합함
                                </div>
                             </div>
                        </div>

                        <div class="checkBoxMain" onclick="checkBox(document.getElementById('checkBox3'),document.getElementById('animal_ok'))">
                            <input type="checkbox" name="animal_ok" id="animal_ok" value="o" ${vo2.animal_ok != 'o' ? '' : 'checked="checked"' }> 
                            
                           	<c:choose>
								<c:when test="${vo2.animal_ok eq 'o'}">
									<label class="far fa-check-square fa-2x" id="checkBox3" ></label>
								</c:when>
								<c:otherwise>
									<label class="far fa-square fa-2x" id="checkBox3" ></label>
								</c:otherwise>
							</c:choose>
                            
                            <div class="checkBoxRemark">
                                <div class="checkBoxRemark1">
                                    	반려동물 동반에 적합함
                                </div>
                             </div>
                        </div>

                        <div class="checkBoxMain" onclick="checkBox(document.getElementById('checkBox4'),document.getElementById('smoking'))">
                            <input type="checkbox" name="smoking" id="smoking" value="o" ${vo2.smoking != 'o' ? '' : 'checked="checked"' }> 

                            <c:choose>
								<c:when test="${vo2.smoking eq 'o'}">
									<label class="far fa-check-square fa-2x" id="checkBox4" ></label>
								</c:when>
								<c:otherwise>
									<label class="far fa-square fa-2x" id="checkBox4" ></label>
								</c:otherwise>
							</c:choose>
                            
                            <div class="checkBoxRemark">
                                <div class="checkBoxRemark1">
                                    	흡연 가능
                                </div>
                             </div>
                        </div>

                        <div class="checkBoxMain" onclick="checkBox(document.getElementById('checkBox5'),document.getElementById('party'))">
                            <input type="checkbox" name="party" id="party" value="o" ${vo2.party != 'o' ? '' : 'checked="checked"' }> 
                           
                            <c:choose>
								<c:when test="${vo2.party eq 'o'}">
									<label class="far fa-check-square fa-2x" id="checkBox5" ></label>
								</c:when>
								<c:otherwise>
									<label class="far fa-square fa-2x" id="checkBox5" ></label>
								</c:otherwise>
							</c:choose>
                            
                            <div class="checkBoxRemark">
                                <div class="checkBoxRemark1">
                                    	행사나 파티 허용
                                </div>
                             </div>
                        </div>

                        
                        <div class="title07">
                            	추가 규칙
                        </div>

                        <div class="dtl_cnt">
                        	<c:forEach items="${vo1}" var="item">
								<div class="dtl">
                                    <span class="dtl_text">${item.rule}</span>
                                    <i class="fas fa-times fa-lg" onclick ="delRule(this,${item.i_drule})"></i>
                                </div>
							</c:forEach>
                        </div>

                        <div class="text_dtl">
                            <input type="text" id="dtl_text" value="" placeholder="조용히 해야 하는 시간, 실내 신발 착용 여부 등">
                            <button type="button" onclick="insRul()">추가</button>		
                        </div>

                        <div class="title07">
                            	게스트가 숙소에 대해 알아두어야 할 세부 사항
                        </div>

                        <div class="checkBoxMain" onclick="checkBox(document.getElementById('checkBox6'),document.getElementById('stairs'))">
                            <input type="checkbox" name="stairs" id="stairs" value="o" ${vo3.stairs != 'o' ? '' : 'checked="checked"' }> 

                            <c:choose>
								<c:when test="${vo3.stairs eq 'o'}">
									<label class="far fa-check-square fa-2x" id="checkBox6" ></label>
								</c:when>
								<c:otherwise>
									<label class="far fa-square fa-2x" id="checkBox6" ></label>
								</c:otherwise>
							</c:choose>
                            
                            <div class="checkBoxRemark">
                                <div class="checkBoxRemark1">
                                    	계단을 올라가야 함 
                                </div>
                             </div>
                        </div>

                        <div class="checkBoxMain" onclick="checkBox(document.getElementById('checkBox7'),document.getElementById('noise'))">
                            <input type="checkbox" name="noise" id="noise" value="o" ${vo3.noise != 'o' ? '' : 'checked="checked"' }>

                            <c:choose>
								<c:when test="${vo3.noise eq 'o'}">
									<label class="far fa-check-square fa-2x" id="checkBox7" ></label>
								</c:when>
								<c:otherwise>
									<label class="far fa-square fa-2x" id="checkBox7" ></label>
								</c:otherwise>
							</c:choose>
                            
                            <div class="checkBoxRemark">
                                <div class="checkBoxRemark1">
                                    	소음이 발생할 수 있음
                                </div>
                             </div>
                        </div>

                        <div class="checkBoxMain" onclick="checkBox(document.getElementById('checkBox8'),document.getElementById('animal'))">
                            <input type="checkbox" name="animal" id="animal" value="o" ${vo3.animal != 'o' ? '' : 'checked="checked"' }> 
		
                            <c:choose>
								<c:when test="${vo3.animal eq 'o'}">
									<label class="far fa-check-square fa-2x" id="checkBox8" ></label>
								</c:when>
								<c:otherwise>
									<label class="far fa-square fa-2x" id="checkBox8" ></label>
								</c:otherwise>
							</c:choose>
                            
                            <div class="checkBoxRemark">
                                <div class="checkBoxRemark1">
                                    	숙소에 반려동물 있음
                                </div>
                             </div>
                        </div>

                        <div class="checkBoxMain" onclick="checkBox(document.getElementById('checkBox9'),document.getElementById('in_pking'))">
                            <input type="checkbox" name="in_pking" id="in_pking" value="o" ${vo3.in_pking != 'o' ? '' : 'checked="checked"' }> 
                            
                            <c:choose>
								<c:when test="${vo3.in_pking eq 'o'}">
									<label class="far fa-check-square fa-2x" id="checkBox9" ></label>
								</c:when>
								<c:otherwise>
									<label class="far fa-square fa-2x" id="checkBox9" ></label>
								</c:otherwise>
							</c:choose>
                            
                            <div class="checkBoxRemark">
                                <div class="checkBoxRemark1">
                                    	건물 내 주차 불가
                                </div>
                             </div>
                        </div>

                        <div class="checkBoxMain" onclick="checkBox(document.getElementById('checkBox10'),document.getElementById('public_space'))">
                            <input type="checkbox" name="public_space" id="public_space" value="o" ${vo3.public_space != 'o' ? '' : 'checked="checked"' }> 
		
                            <c:choose>
								<c:when test="${vo3.public_space eq 'o'}">
									<label class="far fa-check-square fa-2x" id="checkBox10" ></label>
								</c:when>
								<c:otherwise>
									<label class="far fa-square fa-2x" id="checkBox10" ></label>
								</c:otherwise>
							</c:choose>
                            
                            <div class="checkBoxRemark">
                                <div class="checkBoxRemark1">
                                    	일부 공용 공간 있음 
                                </div>
                             </div>
                        </div>
                        
                        <div class="checkBoxMain" onclick="checkBox(document.getElementById('checkBox11'),document.getElementById('plant'))">
                            <input type="checkbox" name="plant" id="plant" value="o" ${vo3.plant != 'o' ? '' : 'checked="checked"' }> 
		
                            <c:choose>
								<c:when test="${vo3.plant eq 'o'}">
									<label class="far fa-check-square fa-2x" id="checkBox11" ></label>
								</c:when>
								<c:otherwise>
									<label class="far fa-square fa-2x" id="checkBox11" ></label>
								</c:otherwise>
							</c:choose>
                            
                            <div class="checkBoxRemark">
                                <div class="checkBoxRemark1">
                                   	 편의시설 제한
                                </div>
                             </div>
                        </div>

                        <div class="checkBoxMain" onclick="checkBox(document.getElementById('checkBox12'),document.getElementById('cctv'))">
                            <input type="checkbox" name="cctv" id="cctv" value="o" ${vo3.cctv != 'o' ? '' : 'checked="checked"' }> 
		
                            <c:choose>
								<c:when test="${vo3.cctv eq 'o'}">
									<label class="far fa-check-square fa-2x" id="checkBox12" ></label>
								</c:when>
								<c:otherwise>
									<label class="far fa-square fa-2x" id="checkBox12" ></label>
								</c:otherwise>
							</c:choose>
                            
                            <div class="checkBoxRemark">
                                <div class="checkBoxRemark1">
                                   	 숙소에 감시 또는 녹화 장치 설치
                                </div>
                             </div>
                        </div>

                        <div class="checkBoxMain" onclick="checkBox(document.getElementById('checkBox13'),document.getElementById('weapon'))">
                            <input type="checkbox" name="weapon" id="weapon" value="o" ${vo3.weapon != 'o' ? '' : 'checked="checked"' }> 

                            <c:choose>
								<c:when test="${vo3.weapon eq 'o'}">
									<label class="far fa-check-square fa-2x" id="checkBox13" ></label>
								</c:when>
								<c:otherwise>
									<label class="far fa-square fa-2x" id="checkBox13" ></label>
								</c:otherwise>
							</c:choose>
                            
                            <div class="checkBoxRemark">
                                <div class="checkBoxRemark1">
                                    	숙소에 무기 있음 
                                </div>
                             </div>
                        </div>

                        <div class="checkBoxMain" onclick="checkBox(document.getElementById('checkBox14'),document.getElementById('denger_dog'))">
                            <input type="checkbox" name="denger_dog" id="denger_dog" value="o" ${vo3.denger_dog != 'o' ? '' : 'checked="checked"' }> 
		
                            <c:choose>
								<c:when test="${vo3.denger_dog eq 'o'}">
									<label class="far fa-check-square fa-2x" id="checkBox14" ></label>
								</c:when>
								<c:otherwise>
									<label class="far fa-square fa-2x" id="checkBox14" ></label>
								</c:otherwise>
							</c:choose>
                            
                            <div class="checkBoxRemark">
                                <div class="checkBoxRemark1">
                                    	숙소에 위험한 동물 있음 
                                </div>
                             </div>
                        </div>

                    </div>
                    
                    <div class="nepre_tag">
                        <span class="previous" onclick="backPage(${hostingPkVo.i_host},${hostingPkVo.i_sinfo})"><i class="fas fa-chevron-left"></i> 뒤로</span>
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