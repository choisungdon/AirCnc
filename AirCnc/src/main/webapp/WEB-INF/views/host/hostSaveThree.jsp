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
<script type="text/javascript" src="/resources/js/hostSaveThree.js"></script>
<link rel="stylesheet" href="/resources/css/hostSaveThree.css">
<title>HostSaveThree</title>
</head>
<body>
	 <header>
        <span class="log_img">
            <a href="/" class="logo">
                <i class="fab fa-airbnb fa-2x"></i>
            </a>
            <span>숙소 등록 4단계 </span>
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
                    <div class="title_text"> ${loginUser.nm} 님 어떤 게스트가 어떤 공간을 사용할 수 있나요?</div>
                    <div class="text_arr">
                        	등록하고자 하는 숙소에서 게스트가 이용 가능한 공용 공간을 선택하세요.
                    </div>
                </div>
                <form class="hostSaveThree" action="/host/hostSaveFour" method="post">
                    <input type="hidden" name="i_host" value="${i_host}">
                    <input type="hidden" name="i_user" value="${loginUser.i_user}">
                    <c:if test="${vo.i_gest != null}">
                        <input type="hidden" name="i_gest" value="${vo.i_gest}">
                    </c:if>

                    <div class="b_room">
                        <div class="checkBoxMain" onclick="checkBox(document.getElementById('checkBox1'),document.getElementById('liviroom'))">
                            <input type="checkbox" name="liviroom" id="liviroom" value="o" ${vo.liviroom != 'o' ? '' : 'checked="checked"'} >
							
							<c:choose>
                            	<c:when test="${vo.liviroom eq 'o'}">
                            		<label class="far fa-check-square fa-2x" id="checkBox1" ></label>
                            	</c:when>
                            	<c:otherwise>
                            		<label class="far fa-square fa-2x" id="checkBox1" ></label>
                            	</c:otherwise>
                            </c:choose>
                            
                            <div class="checkBoxRemark">
                                <div class="checkBoxRemark1">
                                    	단독 사용하는 거실
                                </div>
                             </div>
                        </div>
                        
                        <div class="checkBoxMain" onclick="checkBox(document.getElementById('checkBox2'),document.getElementById('cooking'))">
                            <input type="checkbox" name="cooking" id="cooking" value="o" ${vo.cooking != 'o' ? '' : 'checked="checked"'}>
		
                            <c:choose>
                            	<c:when test="${vo.cooking eq 'o'}">
                            		<label class="far fa-check-square fa-2x" id="checkBox2" ></label>
                            	</c:when>
                            	<c:otherwise>
                            		<label class="far fa-square fa-2x" id="checkBox2" ></label>
                            	</c:otherwise>
                            </c:choose>
                            
                            <div class="checkBoxRemark">
                                <div class="checkBoxRemark1">
                                    	주방
                                </div>
                             </div>
                        </div>

                        <div class="checkBoxMain" onclick="checkBox(document.getElementById('checkBox3'),document.getElementById('waching'))">
                            <input type="checkbox" name="waching" id="waching" value="o" ${vo.waching != 'o' ? '' : 'checked="checked"'}>
		
                            <c:choose>
							    <c:when test="${vo.waching eq 'o'}">
							        <label class="far fa-check-square fa-2x" id="checkBox3" ></label>
							    </c:when>
							    <c:otherwise>
							        <label class="far fa-square fa-2x" id="checkBox3" ></label>
							    </c:otherwise>
							</c:choose>
                            
                            <div class="checkBoxRemark">
                                <div class="checkBoxRemark1">
                                    	세탁 공간 - 세탁기
                                </div>
                             </div>
                        </div>

                        <div class="checkBoxMain" onclick="checkBox(document.getElementById('checkBox4'),document.getElementById('drying'))">
                            <input type="checkbox" name="drying" id="drying" value="o" ${vo.drying != 'o' ? '' : 'checked="checked"'}>
		
                            <c:choose>
							    <c:when test="${vo.drying eq 'o'}">
							        <label class="far fa-check-square fa-2x" id="checkBox4" ></label>
							    </c:when>
							    <c:otherwise>
							        <label class="far fa-square fa-2x" id="checkBox4" ></label>
							    </c:otherwise>
							</c:choose>
                            
                            <div class="checkBoxRemark">
                                <div class="checkBoxRemark1">
                                    	세탁 공간 - 건조기
                                </div>
                             </div>
                        </div>

                        <div class="checkBoxMain" onclick="checkBox(document.getElementById('checkBox5'),document.getElementById('paking'))">
                            <input type="checkbox" name="paking" id="paking" value="o" ${vo.paking != 'o' ? '' : 'checked="checked"'}>
		
                            <c:choose>
							    <c:when test="${vo.paking eq 'o'}">
							        <label class="far fa-check-square fa-2x" id="checkBox5" ></label>
							    </c:when>
							    <c:otherwise>
							        <label class="far fa-square fa-2x" id="checkBox5" ></label>
							    </c:otherwise>
							</c:choose>
                            
                            <div class="checkBoxRemark">
                                <div class="checkBoxRemark1">
                                    	주차
                                </div>
                             </div>
                        </div>

                        <div class="checkBoxMain" onclick="checkBox(document.getElementById('checkBox6'),document.getElementById('gym'))">
                            <input type="checkbox" name="gym" id="gym" value="o" ${vo.gym != 'o' ? '' : 'checked="checked"'}>
		
                            <c:choose>
							    <c:when test="${vo.gym eq 'o'}">
							        <label class="far fa-check-square fa-2x" id="checkBox6" ></label>
							    </c:when>
							    <c:otherwise>
							        <label class="far fa-square fa-2x" id="checkBox6" ></label>
							    </c:otherwise>
							</c:choose>
                            
                            <div class="checkBoxRemark">
                                <div class="checkBoxRemark1">
                                    	헬스장
                                </div>
                             </div>
                        </div>

                        <div class="checkBoxMain" onclick="checkBox(document.getElementById('checkBox7'),document.getElementById('swim_pool'))">
                            <input type="checkbox" name="swim_pool" id="swim_pool" value="o" ${vo.swim_pool != 'o' ? '' : 'checked="checked"'}>
		
                            <c:choose>
							    <c:when test="${vo.swim_pool eq 'o'}">
							        <label class="far fa-check-square fa-2x" id="checkBox7" ></label>
							    </c:when>
							    <c:otherwise>
							        <label class="far fa-square fa-2x" id="checkBox7" ></label>
							    </c:otherwise>
							</c:choose>
                            
                            <div class="checkBoxRemark">
                                <div class="checkBoxRemark1">
                                   	 수영장
                                </div>
                             </div>
                        </div>

                        <div class="checkBoxMain" onclick="checkBox(document.getElementById('checkBox8'),document.getElementById('jacuzzi'))">
                            <input type="checkbox" name="jacuzzi" id="jacuzzi" value="o" ${vo.jacuzzi != 'o' ? '' : 'checked="checked"'}>
		
                            <c:choose>
							    <c:when test="${vo.jacuzzi eq 'o'}">
							        <label class="far fa-check-square fa-2x" id="checkBox8" ></label>
							    </c:when>
							    <c:otherwise>
							        <label class="far fa-square fa-2x" id="checkBox8" ></label>
							    </c:otherwise>
							</c:choose>
                            
                            <div class="checkBoxRemark">
                                <div class="checkBoxRemark1">
                                    	자쿠지
                                </div>
                             </div>
                        </div>

                    </div>
                    
                    <div class="nepre_tag">
                        <span class="previous" onclick="backPage(${hostingPkVo.i_host},${hostingPkVo.i_fct},${hostingPkVo.i_spt})"><i class="fas fa-chevron-left"></i> 뒤로</span>
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