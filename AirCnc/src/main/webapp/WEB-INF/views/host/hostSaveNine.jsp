<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>hostSaveNine</title>
    <script src="https://kit.fontawesome.com/ea36f2192f.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <script type="text/javascript" src="/resources/js/hostSaveNine.js"></script>
    <link rel="stylesheet" href="/resources/css/hostSaveNine.css">
</head>
<body>
    <header>
        <span class="log_img">
            <a href="/" class="logo">
                <i class="fab fa-airbnb fa-2x"></i>
            </a>
            <span>사진</span>
        </span>
        
        <a href="/host/hostSaveEight" class="his_back">  
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
    	<input type="hidden" id="i_host" value="${i_host}">
        <div class="ctnt_img">
            <section class="img_ctnt_main">
                <div class="img_title">
                    <div class="title_text">멋진 사진으로 숙소가 돋보이게 해주세요.</div>
                    <div class="title_texts">
                        	휴대전화나 카메라를 사용하여 사진을 찍으세요. 
                        <br>
                        	숙소를 등록하려면 1장 이상의 사진이 필요합니다. 
                        <br>
                        	나중에 언제든 사진을 추가하거나 수정하실 수 있습니다.
                    </div>
                </div>
                <!--사진 유무 확인 -->
                <c:choose>
                	
				    <c:when test="${fn:length(vo)>0}">
				    
					    <c:forEach items="${vo}" var="item" varStatus="status">
					    	
					    	<c:choose>
					    		
					    		<c:when test="${status.first}">
					    			<div class="main_real_img">
					                    <button type="button" onclick="delImg(this,${item.i_img})"><i class="far fa-trash-alt"></i></button>
					                    <img src="${item.img_url}">
					                </div>
					    		</c:when>
					    		
					    		<c:when test="${status.last}">
					    			<div class="side_real_img">
					    					
						                    <button type="button" onclick="delImg(this,${item.i_img})"><i class="far fa-trash-alt"></i></button>
						                    <img src="${item.img_url}">
						            </div>
						             
					    			 <div class="add_img" onclick="document.getElementById('img_url').click();">
					                    <input type="file" multiple="multiple" id="img_url"  name ="img_url[]" onchange="addImg(this)" accept="image/*" >
					                    <i class="fas fa-plus"></i>
					                    <div>추가하기</div> 
					                </div>
					    		</c:when>
					    		
					    		<c:otherwise>
					    				<div class="side_real_img">
						                    <button type="button" onclick="delImg(this,${item.i_img})"><i class="far fa-trash-alt"></i></button>
						                    <img src="${item.img_url}">
						                </div>
					    		</c:otherwise>
					    	
					    	</c:choose>
					    	
							
						</c:forEach>
				       
				    </c:when>
	
				    <c:otherwise>
				       <div class="img_ctnt_item">
		                    <div class="img_save_container">
		                        <input type="file" multiple="multiple" id="img_url"  name ="img_url[]" onchange="saveImg(this)" accept="image/*" >
		                        <div class="img_up_btn" onclick="document.getElementById('img_url').click();">
		                            <i class="fas fa-cloud-upload-alt"></i>
		                            	사진 업로드
		                        </div>
		                    </div>
		                </div>
				    </c:otherwise>
				
				</c:choose>

                <div class="nepre_tag">
                    <span class="previous"><i class="fas fa-chevron-left"></i> 뒤로</span>
                    <span class="next">저장</span>
                </div>
                 
            </section>
        </div>
        <div class="ctnt_exp">
            <div class="exp_main">
                <div class="exp_ctnt">
                    <div class="ctnt_emg">
                        <i class="fas fa-lightbulb fa-2x"></i>
                    </div>
                    <div class="help-panel__text">
                        <div class="_1p3joamp">
                            	퀄리티 높은 사진을 촬영하기 위한 팁
                        </div>
                        <div class="exp">
                            <li>잡동사니를 치운 깔끔한 상태에서 촬영하세요.</li>
                            <li>자연광을 사용하고 플래시 사용은 되도록 피하세요.</li>
                            <li>화면을 가로로 두고 공간의 구석에서 사진을 찍으세요.</li>
                            <li>사진에 보이는 바닥과 천장 공간의 균형을 맞추세요.</li>
                            <li>특별한 인테리어와 편의시설을 강조하세요.</li>
                            <li>게스트가 사용할 수 있는 모든 공간의 사진을 추가하세요.</li>
                        </div>
                        
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>