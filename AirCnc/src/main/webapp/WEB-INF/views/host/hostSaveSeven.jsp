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
	<script type="text/javascript" src="/resources/js/hostSaveSeven.js"></script>
	<link rel="stylesheet" href="/resources/css/hostSaveSeven.css">
	<title>HostSaveSeven</title>
</head>
<body>
	 <header>
        <span class="log_img">
            <a href="/" class="logo">
                <i class="fab fa-airbnb fa-2x"></i>
            </a>
            <span>숙소 등록 8단계</span>
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
                    <div class="title_text">관리자 님 숙소 요금 설정하기</div>
                </div>
                <form class="hostSaveSeven" action="/host/hostSaveEight" method="post">
                    <input type="hidden" name="i_host" value="${i_host}">
					<input type="hidden" name="i_user" value="${loginUser.i_user}">
					<c:if test="${vo.i_fee != null}"> 
						<input type="hidden"  name="i_fee" value="${vo.i_fee}">
					</c:if>

                    <div class="title01">
                        	기본 요금
                    </div>
                    <div class="fee_ctnt">
                        <div class="fee_text">₩</div>
                        <input type="number" name="fee" id="fee" value="${vo.fee != null ? vo.fee : 0}" >
                    </div>
                    <div class="feeError">
                        <i class="fas fa-exclamation-triangle"></i>
                        	최소 ₩11,139부터 최대 ₩11,138,419의 기본 요금을 설정하세요.
                    </div>

                    <button type="button" class="fee_sugg" onclick="fee_inser(document.querySelector('#fee'),92331)">제안 요금: ₩92,331</button>
                    
                    <div class="title01">
                       	 주 단위 할인율
                    </div>

                    <div class="sale_ctnt">
                        <input type="number" name="w_sale" id="w_sale" value="${vo.w_sale != null ? vo.w_sale : 0}" >
                        <div class="fee_text">%할인</div>
                    </div>

                    <button type="button" class="fee_sugg" onclick="fee_inser(document.querySelector('#w_sale'),21)">제안 요금: %21</button>

                    <div class="title01">
                       	 월 단위 할인율
                    </div>

                    <div class="sale_ctnt">
                        <input type="number" name="m_sale" id="m_sale" value="${vo.m_sale != null ? vo.m_sale : 0}" >
                        <div class="fee_text">%할인</div>
                    </div>
                   

                    <button type="button" class="fee_sugg" onclick="fee_inser(document.querySelector('#m_sale'),49)">제안 요금: %49</button>
                  
                    <div class="checkBoxMain" onclick="checkBox(document.getElementById('checkBox2'),document.getElementById('sale'))">
                        
                        <div class="checkBoxRemark">
                            <div class="checkBoxRemark1">
                                	할인 적용 여부
                            </div>
                        </div>
                        
                        <c:choose>
								<c:when test="${vo.sale eq 'o'}">
									<label class="far fa-check-square fa-2x" id="checkBox2" ></label>
								</c:when>
								<c:otherwise>
									<label class="far fa-square fa-2x" id="checkBox2" ></label>
								</c:otherwise>
						</c:choose>
                        
                        <input type="checkbox" name="sale"	id="sale"		value="o" ${vo.sale != 'o' ? '' : 'checked="checked"'}> 
                    </div>

                    <div class="nepre_tag">
                        <span class="previous" onclick="backPage(${hostingPkVo.i_host},${hostingPkVo.i_ck})"><i class="fas fa-chevron-left"></i> 뒤로</span>
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