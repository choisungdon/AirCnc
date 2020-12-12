<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="/resources/css/hosting.css">
<script type="text/javascript" src="/resources/js/hosting.js"></script>
</head>
<body>
	<div class="container">
      <div class="ctnt_main">
        <div class="hosting_title'">
            <h1>어떻게 시작하고 싶으세요?</h1>
            <div class="host_save_tag">
                <input type="radio" name="hosting" id="new_host" value="${loginUser.i_user}"/>
                <img src='https://a0.muscache.com/pictures/acbbe4a6-18b3-4c73-a7f6-891dbdb4d97b.jpg'>
                <span>새로운숙소 등록하기</span>
            </div>
        </div>
        <div class="hosting">
            <div class="hosting_title">숙소 등록 중</div>
            <c:choose>
            	<c:when test="${fn:length(data1)>0}">
            		<c:forEach items="${data1}" var="item">
			            <div class="host_save_tag">
			                <input type="radio" name="hosting" id="hosting"  value="${item.i_host}"/>
			                
			                <img src='${item.img_url}'>
			                <span>
			                    <div>${item.room_title }</div>			                </span>
			            </div>
		            </c:forEach>
            	</c:when>
            	
            	<c:otherwise>
		         	<div class="host_save_tag">
		                <span>
		                    <div>숙소가 없습니다.</div>
		                </span>
		            </div>
            	</c:otherwise>
            </c:choose>
            
            
        </div>

        <div class="hosting_conf">
            <div class="hosting_conf_title">숙소 등록 완료</div>
        <c:choose>
            	<c:when test="${fn:length(data2)>0}">
            		<c:forEach items="${data2}" var="item">
						<div class="host_save_tag">
						    <input type="radio" name="hosting" id="host_save"  value="${item.i_host}"/>
						
							<img src='${item.img_url}'>
							<span>
						    	<div>${item.room_title }</div>
						    </span>
						</div>
					</c:forEach>
            	</c:when>
            	<c:otherwise>
            		<div class="host_save_tag">
		                <span>
		                    <div>숙소가 없습니다.</div>
		                </span>
		            </div>
            	</c:otherwise>
        </c:choose>
        
                      
        </div>

        <div class="host_btn">
            <button class="next" onclick="next()">다음</button>
            <button class="delete" onclick="host_delete()">삭제</button>
        </div>
      </div>
    </div>   
	
</body>
</html>