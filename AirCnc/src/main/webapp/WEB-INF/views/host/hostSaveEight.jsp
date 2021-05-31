<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 이모티콘 라이브러리 -->
    <script src="https://kit.fontawesome.com/ea36f2192f.js" crossorigin="anonymous"></script>
	<!--css js  -->
	<script type="text/javascript" src="/resources/js/hostSaveEight.js"></script>
	<link rel="stylesheet" href="/resources/css/hostSaveEight.css">
<title>HostSaveEight</title>
</head>
<body>
	 <header>
        <span class="log_img">
            <a href="/" class="logo">
                <i class="fab fa-airbnb fa-2x"></i>
            </a>
            <span>숙소 등록 9단계</span>
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
                    <div class="title_text">관리자님 숙소 연락처를 지정하세요.</div>
                </div>
                <form class="hostSaveEight"  action="/host/hostSaveNine" method="post">
                    <input type="hidden" name="i_host" value="${i_host}">
                    <input type="hidden" name="i_user" value="${loginUser.i_user}">
                    <c:if test="${vo.i_ph != null}"> 
                        <input type="hidden"  name="i_ph" value="${vo.i_ph}">
                    </c:if>

                    <div class="title01">
                       	 연락처
                    </div>
                    <div class="fee_ctnt">
                        <input type="text" name="wp_ph" id="wp_ph" value="${vo.wp_ph != null ? vo.wp_ph : ''}" >
                    </div>
                    
                    <div class="checkBoxMain" onclick="checkBox(document.getElementById('checkBox2'),document.getElementById('gest_ok'))">
                        
                        <div class="checkBoxRemark">
                            <div class="checkBoxRemark1">
                                	게스트 연락 가능 여부
                            </div>
                        </div>
                        <c:choose>
								<c:when test="${vo.gest_ok eq 'o'}">
									<label class="far fa-check-square fa-2x" id="checkBox2" ></label>
								</c:when>
								<c:otherwise>
									<label class="far fa-square fa-2x" id="checkBox2" ></label>
								</c:otherwise>
						</c:choose>
                        
                        <input type="checkbox" name="gest_ok"	id="gest_ok"		value="o" ${vo.gest_ok != 'o' ? '' : 'checked="checked"'}> 
                    </div>

                    <div class="nepre_tag">
                        <span class="previous" onclick="backPage(${hostingPkVo.i_host},${hostingPkVo.i_fee})"><i class="fas fa-chevron-left"></i> 뒤로</span>
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