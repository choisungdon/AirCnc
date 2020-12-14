<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<title></title>
</head>
<body>
	<p>10단계 ${loginUser.nm}님  숙소 사진을 지정하세요.</p>
	<div id="get_img">
		<c:forEach items="${vo}" var="item">
			<img src="${item.img_url}" id="poth${item.i_img}" width="245">
			<button type="button" onclick="delImg(this,${item.i_img})">X</button>
		</c:forEach>
	</div>
	<div>
		<div>
			<label>
				사진 선택 :
				<input type="file" id="img_url"  name ="img_url" onchange="saveImg()" accept="image/*" > <!-- image 파일만 보이게 하는 기능 -->
				<input type="hidden" id="i_user" value="${loginUser.i_user}">
				<input type="hidden" id="i_host" value="${i_host}">
			</label>
		</div>
		<form action="/host/hosting" method="get">
			<input type="submit" value="다음">
		</form>
 	</div>
<script type="text/javascript">

function saveImg(){
	var frm = new FormData();
	// 파일 이름 
	var photoFile = document.getElementById("img_url");
	// 숙소 i_host
	var i_host = document.getElementById("i_host").value;
	// form 객체 
	frm.append("photo", photoFile.files[0]);
	frm.append("i_host", i_host);
	// post 방식으로 전송 
	axios.post('/host/hostLast', frm, {
	  headers: {
	    'Content-Type': 'multipart/form-data'
	  }
	})
	.then((res) => {
		  var i_img		= res.data.result.i_img;
		  var img_url	= res.data.result.img_url;
		  // 부모 태그 
		  var dtl = document.getElementById("get_img");
		  // img 태그 생성 
		  var img = document.createElement("img")
		  img.setAttribute("src",img_url);
		  img.setAttribute("id","poto"+i_img) // i_img 구분용 
		  img.setAttribute("width","245");
		  // 버튼 생성 
		  var button = document.createElement("button");
		  button.setAttribute("type","button");
		  button.setAttribute("onclick","delImg(this,'"+i_img+"')")
		  button.innerHTML = "X";
		  // 완성 태그 생성 
		  dtl.appendChild(img);
		  dtl.appendChild(button);
		  
	})
	
	
}

function delImg(el,pk){
	var img_tag = el.previousSibling.previousSibling ;
	// db 삭제 및 파일 삭제 
	axios.get('/host/delRoomImg', {
	    params: {
	    	i_img:	pk,
	    	i_host: i_host.value,
			i_user: i_user.value
	    }
	  })
	  .then(function (res) {
		  // 성공시  img,버튼 태그 삭제 
	    if(res.data.result > 0){
	    	img_tag.remove();
	    	el.remove();
	    }
	  })
	
	
}

	
</script>
</body>
</html>