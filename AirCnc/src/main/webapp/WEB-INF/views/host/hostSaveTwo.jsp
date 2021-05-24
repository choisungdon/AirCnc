<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://kit.fontawesome.com/ea36f2192f.js" crossorigin="anonymous"></script>
<script type="text/javascript" src="/resources/js/hostSaveTwo.js"></script>
<link rel="stylesheet" href="/resources/css/hostSaveTwo.css">
<title>HostSaveTwo</title>
</head>
<body>
	<header>
        <span class="log_img">
            <a href="/" class="logo">
                <i class="fab fa-airbnb fa-2x"></i>
            </a>
            <span>숙소 등록 3단계 </span>
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
                    <div class="title_text"> ${loginUser.nm} 님 어떤 편의시설을 제공하시나요?</div>
                    <div class="text_arr">
                        	일반적으로 게스트가 기대하는 편의시설 목록입니다. 
                        <br>
                        	숙소를 등록한 후 언제든 편의시설을 추가할 수 있어요.
                    </div>
                </div>
                <form class="hostSaveThree" action="/host/hostSaveThree" method="post">
                    <input type="hidden" name="i_host" value="${i_host}">
                    <input type="hidden" name="i_user" value="${loginUser.i_user}">
                    <c:if test="${vo1.i_fct != null && vo2.i_spt != null }">
                        <input type="hidden" name="i_fct" value="${vo1.i_fct }">
                        <input type="hidden" name="i_spt" value="${vo2.i_spt }">
                    </c:if>

                    <div class="b_room">
                        <div class="checkBoxMain" onclick="checkBox(document.getElementById('checkBox1'),document.getElementById('requier'))">
                            <input type="checkbox" name="requier" id="requier"	value="o" ${(vo1.requier != 'o') ? 'checked="checked"' : 'checked="checked"'}> 
                            
                            <c:choose>
                            	<c:when test="${vo1.requier eq 'o'}">
                            		<label class="far fa-check-square fa-2x" id="checkBox1" ></label>
                            	</c:when>
                            	<c:otherwise>
                            		<label class="far fa-square fa-2x" id="checkBox1" ></label>
                            	</c:otherwise>
                            </c:choose>
                            
                            <div class="checkBoxRemark">
                                <div class="checkBoxRemark1">
                                    	필수 품목
                                </div>
                                <div class="checkBoxRemark2">
                                    	수건, 침대 시트, 비누, 화장지, 베개
                                </div>
                            </div>
                        </div>

                        <div class="checkBoxMain" onclick="checkBox(document.getElementById('checkBox2'),document.getElementById('wifi'))">
                            <input type="checkbox" name="wifi"	id="wifi"		value="o" ${(vo1.wifi != 'o') ? '' : 'checked="checked"'}> 
                            <c:choose>
                            	<c:when test="${vo1.wifi eq 'o'}">
                            		<label class="far fa-check-square fa-2x" id="checkBox2" ></label>
                            	</c:when>
                            	<c:otherwise>
                            		<label class="far fa-square fa-2x" id="checkBox2" ></label>
                            	</c:otherwise>
                            </c:choose>
                            
                            
                            <div class="checkBoxRemark">
                                <div class="checkBoxRemark1">
                                    	무선인터넷
                                </div>
                               
                            </div>
                        </div>

                        <div class="checkBoxMain" onclick="checkBox(document.getElementById('checkBox3'),document.getElementById('tv'))">
                            <input type="checkbox" name="tv" 	id="tv"		value="o" ${(vo1.tv != 'o') ? '' : 'checked="checked"'}> 
                            
							<c:choose>
							    <c:when test="${vo1.tv eq 'o'}">
							        <label class="far fa-check-square fa-2x" id="checkBox3" ></label>
							    </c:when>
							    <c:otherwise>
							        <label class="far fa-square fa-2x" id="checkBox3" ></label>
							    </c:otherwise>
							</c:choose>
                            
                            <div class="checkBoxRemark">
                                <div class="checkBoxRemark1">
                                    TV
                                </div>
                            </div>
                        </div>

                        <div class="checkBoxMain" onclick="checkBox(document.getElementById('checkBox4'),document.getElementById('hiter'))">
                            <input type="checkbox" name="hiter"  id="hiter"	value="o" ${(vo1.hiter != 'o') ? '' : 'checked="checked"'}> 
	
                            <c:choose>
							    <c:when test="${vo1.hiter eq 'o'}">
							        <label class="far fa-check-square fa-2x" id="checkBox4" ></label>
							    </c:when>
							    <c:otherwise>
							        <label class="far fa-square fa-2x" id="checkBox4" ></label>
							    </c:otherwise>
							</c:choose>
                            
                            <div class="checkBoxRemark">
                                <div class="checkBoxRemark1">
                                    	난방
                                </div>
                               
                            </div>
                        </div>

                        <div class="checkBoxMain" onclick="checkBox(document.getElementById('checkBox5'),document.getElementById('aircon'))">
                            <input type="checkbox" name="aircon"  id="aircon"	value="o" ${(vo1.aircon != 'o') ? '' : 'checked="checked"'}> 
                            
                            <c:choose>
							    <c:when test="${vo1.aircon eq 'o'}">
							        <label class="far fa-check-square fa-2x" id="checkBox5" ></label>
							    </c:when>
							    <c:otherwise>
							        <label class="far fa-square fa-2x" id="checkBox5" ></label>
							    </c:otherwise>
							</c:choose>
                            
                            <div class="checkBoxRemark">
                                <div class="checkBoxRemark1">
                                    	에어컨
                                </div>
                            </div>
                        </div>

                        <div class="checkBoxMain" onclick="checkBox(document.getElementById('checkBox6'),document.getElementById('iron'))">
                            <input type="checkbox" name="iron" 	id="iron"	value="o" ${(vo1.iron != 'o') ? '' : 'checked="checked"'}> 

                            <c:choose>
							    <c:when test="${vo1.iron eq 'o'}">
							        <label class="far fa-check-square fa-2x" id="checkBox6" ></label>
							    </c:when>
							    <c:otherwise>
							        <label class="far fa-square fa-2x" id="checkBox6" ></label>
							    </c:otherwise>
							</c:choose>
                            
                            <div class="checkBoxRemark">
                                <div class="checkBoxRemark1">
                                    	다리미
                                </div>
                            </div>
                        </div>

                        <div class="checkBoxMain" onclick="checkBox(document.getElementById('checkBox7'),document.getElementById('sampoo'))">
                            <input type="checkbox" name="sampoo" 	id="checkBox7"	value="o" ${(vo1.sampoo != 'o') ? '' : 'checked="checked"'}> 
                            
                            <c:choose>
							    <c:when test="${vo1.sampoo eq 'o'}">
							        <label class="far fa-check-square fa-2x" id="checkBox7" ></label>
							    </c:when>
							    <c:otherwise>
							        <label class="far fa-square fa-2x" id="checkBox7" ></label>
							    </c:otherwise>
							</c:choose>
                            
                            <div class="checkBoxRemark">
                                <div class="checkBoxRemark1">
                                   	 샴푸
                                </div>
                            </div>
                        </div>

                        <div class="checkBoxMain" onclick="checkBox(document.getElementById('checkBox8'),document.getElementById('hiar_dry'))">
                            <input type="checkbox" name="hiar_dry" 	id="hiar_dry"	value="o" ${(vo1.hiar_dry != 'o') ? '' : 'checked="checked"'}> 
                            
                            <c:choose>
							    <c:when test="${vo1.hiar_dry eq 'o'}">
							        <label class="far fa-check-square fa-2x" id="checkBox8" ></label>
							    </c:when>
							    <c:otherwise>
							        <label class="far fa-square fa-2x" id="checkBox8" ></label>
							    </c:otherwise>
							</c:choose>
                            
                            <div class="checkBoxRemark">
                                <div class="checkBoxRemark1">
                                    	헤어 드라이어
                                </div>
                            </div>
                        </div>

                        <div class="checkBoxMain" onclick="checkBox(document.getElementById('checkBox9'),document.getElementById('breakfast'))">
                            <input type="checkbox" name="breakfast" id="breakfast" value="o" ${(vo1.breakfast != 'o') ? '' : 'checked="checked"'}> 
                            
                            <c:choose>
							    <c:when test="${vo1.breakfast eq 'o'}">
							        <label class="far fa-check-square fa-2x" id="checkBox9" ></label>
							    </c:when>
							    <c:otherwise>
							        <label class="far fa-square fa-2x" id="checkBox9" ></label>
							    </c:otherwise>
							</c:choose>
                            
                            <div class="checkBoxRemark">
                                <div class="checkBoxRemark1">
                                    	조식(커피,차)
                                </div>
                            </div>
                        </div>

                        <div class="checkBoxMain" onclick="checkBox(document.getElementById('checkBox10'),document.getElementById('place_lattop'))">
                            <input type="checkbox" name="place_lattop" id="place_lattop" 	value="o" ${(vo1.place_lattop != 'o') ? '' : 'checked="checked"'}> 
                            
							<c:choose>
							    <c:when test="${vo1.place_lattop eq 'o'}">
							        <label class="far fa-check-square fa-2x" id="checkBox10" ></label>
							    </c:when>
							    <c:otherwise>
							        <label class="far fa-square fa-2x" id="checkBox10" ></label>
							    </c:otherwise>
							</c:choose>
                            
                            <div class="checkBoxRemark">
                                <div class="checkBoxRemark1">
                                    	업무 가능 공간
                                </div>
                            </div>
                        </div>

                        <div class="checkBoxMain" onclick="checkBox(document.getElementById('checkBox11'),document.getElementById('in_hiter'))">
                            <input type="checkbox" name="in_hiter"  id="in_hiter"	value="o" ${(vo1.in_hiter != 'o') ? '' : 'checked="checked"'}> 
                            
                            <c:choose>
							    <c:when test="${vo1.in_hiter eq 'o'}">
							        <label class="far fa-check-square fa-2x" id="checkBox11" ></label>
							    </c:when>
							    <c:otherwise>
							        <label class="far fa-square fa-2x" id="checkBox11" ></label>
							    </c:otherwise>
							</c:choose>
                            
                            <div class="checkBoxRemark">
                                <div class="checkBoxRemark1">
                                    	벽난로
                                </div>
                            </div>
                        </div>

                        <div class="checkBoxMain" onclick="checkBox(document.getElementById('checkBox12'),document.getElementById('hanger'))">
                            <input type="checkbox" name="hanger" id="hanger"	value="o" ${(vo1.hanger != 'o') ? '' : 'checked="checked"'}> 
                            
							<c:choose>
							    <c:when test="${vo1.hanger eq 'o'}">
							        <label class="far fa-check-square fa-2x" id="checkBox12" ></label>
							    </c:when>
							    <c:otherwise>
							        <label class="far fa-square fa-2x" id="checkBox12" ></label>
							    </c:otherwise>
							</c:choose>
                            
                            <div class="checkBoxRemark">
                                <div class="checkBoxRemark1">
                                    	옷장/서랍장
                                </div>
                            </div>
                        </div>

                        <div class="checkBoxMain" onclick="checkBox(document.getElementById('checkBox13'),document.getElementById('door'))">
                            <input type="checkbox" name="door" 	id="door"	value="o"  ${(vo1.door != 'o') ? '' : 'checked="checked"'}> 

                            <c:choose>
							    <c:when test="${vo1.door eq 'o'}">
							        <label class="far fa-check-square fa-2x" id="checkBox13" ></label>
							    </c:when>
							    <c:otherwise>
							        <label class="far fa-square fa-2x" id="checkBox13" ></label>
							    </c:otherwise>
							</c:choose>
                            
                            <div class="checkBoxRemark">
                                <div class="checkBoxRemark1">
                                    	게스트 전용 출입문
                                </div>
                            </div>
                        </div>

                        <div class="checkBoxMain" onclick="checkBox(document.getElementById('checkBox14'),document.getElementById('baby_bad'))">
                            <input type="checkbox" name="baby_bad" id="baby_bad" value="o" ${(vo1.baby_bad != 'o') ? '' : 'checked="checked"'}> 
                            
                            <c:choose>
							    <c:when test="${vo1.baby_bad eq 'o'}">
							        <label class="far fa-check-square fa-2x" id="checkBox14" ></label>
							    </c:when>
							    <c:otherwise>
							        <label class="far fa-square fa-2x" id="checkBox14" ></label>
							    </c:otherwise>
							</c:choose>
                            
                            <div class="checkBoxRemark">
                                <div class="checkBoxRemark1">
                                    	유아용 침대
                                </div>
                            </div>
                        </div>

                        <div class="checkBoxMain" onclick="checkBox(document.getElementById('checkBox15'),document.getElementById('baby_chairs'))">
                            <input type="checkbox" name="baby_chairs" id="baby_chairs"	value="o" ${(vo1.baby_chairs != 'o') ? '' : 'checked="checked"'}> 

                            <c:choose>
							    <c:when test="${vo1.baby_chairs eq 'o'}">
							        <label class="far fa-check-square fa-2x" id="checkBox15" ></label>
							    </c:when>
							    <c:otherwise>
							        <label class="far fa-square fa-2x" id="checkBox15" ></label>
							    </c:otherwise>
							</c:choose>
                            
                            <div class="checkBoxRemark">
                                <div class="checkBoxRemark1">
                                    	유아용 의자
                                </div>
                            </div>
                        </div>

                        <div class="checkBoxMain" onclick="checkBox(document.getElementById('checkBox16'),document.getElementById('self_checkin'))">
                            <input type="checkbox" name="self_checkin" id="self_checkin"	value="o" ${(vo1.self_checkin != 'o') ? '' : 'checked="checked"'}> 
                            
                            <c:choose>
							    <c:when test="${vo1.self_checkin eq 'o'}">
							        <label class="far fa-check-square fa-2x" id="checkBox16" ></label>
							    </c:when>
							    <c:otherwise>
							        <label class="far fa-square fa-2x" id="checkBox16" ></label>
							    </c:otherwise>
							</c:choose>
                            
                            <div class="checkBoxRemark">
                                <div class="checkBoxRemark1">
                                    	셀프 체크인
                                </div>
                            </div>
                        </div>

                        <div class="checkBoxMain" onclick="checkBox(document.getElementById('checkBox17'),document.getElementById('self_bth_room'))">
                            <input type="checkbox" name="self_bth_room"	id="self_bth_room" value="o" ${(vo1.self_bth_room != 'o') ? '' : 'checked="checked"'}> 

							<c:choose>
							    <c:when test="${vo1.self_bth_room eq 'o'}">
							        <label class="far fa-check-square fa-2x" id="checkBox17" ></label>
							    </c:when>
							    <c:otherwise>
							        <label class="far fa-square fa-2x" id="checkBox17" ></label>
							    </c:otherwise>
							</c:choose>
                            
                            <div class="checkBoxRemark">
                                <div class="checkBoxRemark1">
                                    	욕실 단독 사용
                                </div>
                            </div>
                        </div>

                        <h4 class="safe_text">
                            	안전시설
                        </h4>

                        <div class="checkBoxMain" onclick="checkBox(document.getElementById('checkBox18'),document.getElementById('fire_emble'))">
                            <input type="checkbox" name="fire_emble"  id="fire_emble"	value="o" ${(vo2.fire_emble != 'o') ? '' : 'checked="checked"'}> 

                            <c:choose>
							    <c:when test="${vo2.fire_emble eq 'o'}">
							        <label class="far fa-check-square fa-2x" id="checkBox18" ></label>
							    </c:when>
							    <c:otherwise>
							        <label class="far fa-square fa-2x" id="checkBox18" ></label>
							    </c:otherwise>
							</c:choose>
                            
                            <div class="checkBoxRemark">
                                <div class="checkBoxRemark1">
                                    	화재 감지기
                                </div>
                                <div class="checkBoxRemark2">
                                    	잘 작동하는 화재 감지기를 모든 방에  구비해 놓아야 하는지 현지 법규를 확인해보세요.
                                </div>
                            </div>
                        </div>

                        <div class="checkBoxMain" onclick="checkBox(document.getElementById('checkBox19'),document.getElementById('carbon_alarm'))">
                            <input type="checkbox" name="carbon_alarm" id="carbon_alarm" value="o" ${(vo2.carbon_alarm != 'o') ? '' : 'checked="checked"'}> 

							<c:choose>
							    <c:when test="${vo2.carbon_alarm eq 'o'}">
							        <label class="far fa-check-square fa-2x" id="checkBox19" ></label>
							    </c:when>
							    <c:otherwise>
							        <label class="far fa-square fa-2x" id="checkBox19" ></label>
							    </c:otherwise>
							</c:choose>
                            
                            <div class="checkBoxRemark">
                                <div class="checkBoxRemark1">
                                   	 일산화탄소 감지기
                                </div>
                                <div class="checkBoxRemark2">
                                    	일산화탄소 감지기 구비 요건에 대해 현지 법규를 확인해보세요. 
                                    <br>
                                    	지역에 따라, 정상적으로 작동하는 일산화탄소 감지기를 모든 방에 설치해야 할 수 있습니다.
                                </div>
                            </div>
                        </div>

                        <div class="checkBoxMain" onclick="checkBox(document.getElementById('checkBox20'),document.getElementById('madic_kit'))">
                            <input type="checkbox" name="madic_kit" id="madic_kit"	value="o" ${(vo2.madic_kit != 'o') ? '' : 'checked="checked"'}> 

                            <c:choose>
							    <c:when test="${vo2.madic_kit eq 'o'}">
							        <label class="far fa-check-square fa-2x" id="checkBox20" ></label>
							    </c:when>
							    <c:otherwise>
							        <label class="far fa-square fa-2x" id="checkBox20" ></label>
							    </c:otherwise>
							</c:choose>
                            
                            <div class="checkBoxRemark">
                                <div class="checkBoxRemark1">
                                    	구급상자
                                </div>
                            </div>
                        </div>

                        <div class="checkBoxMain" onclick="checkBox(document.getElementById('checkBox21'),document.getElementById('fire_exting'))">
                            <input type="checkbox" name="fire_exting" 	value="o" ${(vo2.fire_exting != 'o') ? '' : 'checked="checked"'}> 
	
                            <c:choose>
							    <c:when test="${vo2.fire_exting eq 'o'}">
							        <label class="far fa-check-square fa-2x" id="checkBox21" ></label>
							    </c:when>
							    <c:otherwise>
							        <label class="far fa-square fa-2x" id="checkBox21" ></label>
							    </c:otherwise>
							</c:choose>
                            
                            <div class="checkBoxRemark">
                                <div class="checkBoxRemark1">
                                    	소화기
                                </div>
                            </div>
                        </div>

                        <div class="checkBoxMain" onclick="checkBox(document.getElementById('checkBox22'),document.getElementById('bad_lock'))">
                            <input type="checkbox" name="bad_lock" id="bad_lock"	value="o" ${(vo2.bad_lock != 'o') ? '' : 'checked="checked"'}> 
	
                            <c:choose>
							    <c:when test="${vo2.bad_lock eq 'o'}">
							        <label class="far fa-check-square fa-2x" id="checkBox22" ></label>
							    </c:when>
							    <c:otherwise>
							        <label class="far fa-square fa-2x" id="checkBox22" ></label>
							    </c:otherwise>
							</c:choose>
                            
                            <div class="checkBoxRemark">
                                <div class="checkBoxRemark1">
                                    	침실문 잠금장치
                                </div>
                                <div class="checkBoxRemark2">
                                    	안전과 사생활 보호를 위해 방문을 잠글 수 있음
                                </div>
                            </div>
                        </div>

                    </div>
                    
                    <div class="nepre_tag">
                        <span class="previous" onclick="backPage(${hostingPkVo.i_host},${hostingPkVo.i_build})"><i class="fas fa-chevron-left"></i> 뒤로</span>
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