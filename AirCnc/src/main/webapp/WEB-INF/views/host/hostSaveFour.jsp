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
<script type="text/javascript" src="/resources/js/hostSaveFour.js"></script>
<link rel="stylesheet" href="/resources/css/hostSaveFour.css">
<title>HostSaveFour</title>
</head>
<body>
 <header>
        <span class="log_img">
            <a href="/" class="logo">
                <i class="fab fa-airbnb fa-2x"></i>
            </a>
            <span>숙소 등록 5단계 </span>
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
                    <div class="title_text"> ${loginUser.nm} 님 게스트에게 숙소에 대해 설명해주세요.</div>
                    <div class="text_arr">
                        	숙소의 장점, 특별한 편의시설(예: 빠른 와이파이 또는 주차 시설)과 
                        <br>
                        	주변 지역의 매력을 소개해주세요.
                    </div>
                </div>
                <form class="HostSaveFour" action="/host/hostSaveFive" method="post">
                    <input type="hidden" name="i_host" value="${i_host }">
                    <input type="hidden" name="i_user" value="${loginUser.i_user}">
                    <c:if test="${vo.i_sinfo != null}">
                        <input type="hidden" name="i_sinfo" value="${vo.i_sinfo}">
                    </c:if>

                    <div class="b_room">
                        <textarea name="expa" rows="8" >${(vo.expa != null ) ? vo.expa : null}</textarea>

                        <div class="text_info_main">
                            <div class="text_title">    
                               	 숙소
                            </div>
                            <div class="text_sub">
                                	숙소의 모습과 느낌을 설명해주세요. 독서를 즐길 수 있는 아늑한 모퉁이나 야외 좌석 등 특별한 디자인 요소나 공간이 있다면, 이에 대해 알려주세요.
                            </div>
                        </div>

                        <textarea name="room_info" row="8"  spellcheck="true">${(vo.room_info != null )?vo.room_info:''}</textarea>

                        <div class="text_info_main">
                            <div class="text_title">    
                                	지역 정보
                            </div>
                            <div class="text_sub">
                                	숙소가 위치한 지역에 대해 알려주세요. 분위기, 주변의 카페, 독특한 명소와 도보 거리에 있는 생활편의시설 등 동네를 특별하게 만드는 장소를 소개해주세요.
                            </div>
                        </div>

                        <textarea name="loca_info" row="8"  spellcheck="true">${(vo.loca_info != null )?vo.loca_info:''}</textarea>

                        <div class="text_info_main">
                            <div class="text_title">    
                                	교통편 정보
                            </div>
                            <div class="text_sub">
                                	근처의 대중교통 수단, 운전 정보, 편리한 도보 경로 등 도시와 동네를 돌아다니는 방법을 알려주세요.
                            </div>
                        </div>

                        <textarea name="traf_info" row="8"  spellcheck="true">${(vo.traf_info != null )?vo.traf_info:''}</textarea>

                    </div>
                    
                    <div class="nepre_tag">
                        <span class="previous" onclick="backPage(${hostingPkVo.i_host},${hostingPkVo.i_gest}"><i class="fas fa-chevron-left"></i> 뒤로</span>
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