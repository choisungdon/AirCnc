<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<p>6단계 ${loginUser.nm}님 게스트가 지켜야 할 숙소 이용규칙을 정하세요</p>
	<form id="fom" action="/host/hostSaveSix" method="post">
		<input type="hidden" id="i_host" name="i_host" value="${i_host}">
		<input type="hidden" id="i_user" name="i_user" value="${loginUser.i_user}">
		<c:if test="${vo2.i_rule != null && vo3.i_dtr != null}">
			<input type="hidden"  name="i_rule" value="${vo2.i_rule}">
			<input type="hidden"  name="i_dtr" value="${vo3.i_dtr}">
		</c:if>
		<div>
			어린이(2~12세) 숙박에 적합함
			<input type="checkbox" name="child_ok" value="o" ${vo2.child_ok != 'o' ? '' : 'checked="checked"' }> 
		</div>
		
		<div>
			유아(2세 미만) 숙박에 적합함
			<input type="checkbox" name="y_ch_ok" value="o" ${vo2.y_ch_ok != 'o' ? '' : 'checked="checked"' }> 
		</div>
		
		<div>
			반려동물 동반에 적합함
			<input type="checkbox" name="animal_ok" value="o" ${vo2.animal_ok != 'o' ? '' : 'checked="checked"' }> 
		</div>
		
		<div>
			흡연 가능
			<input type="checkbox" name="smoking" value="o" ${vo2.smoking != 'o' ? '' : 'checked="checked"' }> 
		</div>
		
		<div>
			행사나 파티 허용
			<input type="checkbox" name="party" value="o" ${vo2.party != 'o' ? '' : 'checked="checked"' }> 
		</div>
		<div id="dtl">
			<c:forEach items="${vo1}" var="item">
				<div id="rule${item.i_drule}">
					<span>${item.rule}</span>
					<button onclick ="delRule(this,${item.i_drule})">X</button>
				</div>
			</c:forEach>
		</div>
		<div>
			<input type="text" id="tt" value="" placeholder="조용히 해야 하는 시간, 실내 신발 착용 여부 등">
			<button type="button" onclick="insRul()">추가하기</button>		
		</div>
		<p>게스트가 숙소에 대해 알아두어야 할 세부 사항</p>
		<div>
			계단을 올라가야 함 <input type="checkbox" name="stairs" value="o" ${vo3.stairs != 'o' ? '' : 'checked="checked"' }> 
		</div>
		<div>
			소음이 발생할 수 있음 <input type="checkbox" name="noise" value="o" ${vo3.noise != 'o' ? '' : 'checked="checked"' }> 
		</div>
		<div>
			숙소에 반려동물 있음 <input type="checkbox" name="animal" value="o" ${vo3.animal != 'o' ? '' : 'checked="checked"' }> 
		</div>
		<div>
			건물 내 주차 불가 <input type="checkbox" name="in_pking" value="o" ${vo3.in_pking != 'o' ? '' : 'checked="checked"' }> 
		</div>
		<div>
			일부 공용 공간 있음 <input type="checkbox" name="public_space" value="o" ${vo3.public_space != 'o' ? '' : 'checked="checked"' }> 
		</div>
		<div>
			편의시설 제한 <input type="checkbox" name="plant" value="o" ${vo3.plant != 'o' ? '' : 'checked="checked"' }> 
		</div>
		<div>
			숙소에 감시 또는 녹화 장치 설치 <input type="checkbox" name="cctv" value="o" ${vo3.cctv != 'o' ? '' : 'checked="checked"' }> 
		</div>
		<div>
			숙소에 무기 있음 <input type="checkbox" name="weapon" value="o" ${vo3.weapon != 'o' ? '' : 'checked="checked"' }> 
		</div>
		<div>
			숙소에 위험한 동물 있음 <input type="checkbox" name="denger_dog" value="o" ${vo3.denger_dog != 'o' ? '' : 'checked="checked"' }> 
		</div>
		
		<input type="submit" value="다음">
	</form>
</body>
<script>
	function insRul(){
		// 추가 규칙 내용
		var rule	= document.getElementById("tt").value;
		var i_host	= document.getElementById("i_host").value;
		//규칙 넣을 태그
		var dtl = document.getElementById("dtl");
		
		// db 저장 
		axios.get('/host/insDtlRule', {
		    params: {
		    	i_host: i_host,
				rule: rule
		    }
		  })
		  .then(function (res) {
		    console.log(res.data.result);
		    var pk 		= res.data.result.i_drule;
		    var rule	= res.data.result.rule;
		    
		    var div 	= document.createElement("div");
		    div.setAttribute("id","rule"+pk);
		    
		    var span 	= document.createElement("span");
		    span.innerHTML= rule;
			
			var button = document.createElement("button");
			button.setAttribute("type","button");
			button.setAttribute("onclick","delRule(this,'"+pk+"')");
			button.innerHTML = "X";
			
			div.appendChild(span);
			div.appendChild(button);
			dtl.appendChild(div);
			
		  })
		  
		return false;	
		
	}
	function delRule(el,pk){
		var div = document.getElementById("rule"+pk);
		// db 삭제 
		axios.get('/host/delDtlRule', {
		    params: {
		    	i_drule: pk
		    }
		  })
		  .then(function (res) {
		    console.log(res.data.result);
		  })
		  
		
		// 규칙 삭제 
		div.remove();
		el.remove();
	}
</script>
</html>