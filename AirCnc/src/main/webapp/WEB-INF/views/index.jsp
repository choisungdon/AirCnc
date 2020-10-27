<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<link rel="shortcut icon" href="/resources/img/pinklogo.ico">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/resources/css/index.css">
<script src="https://kit.fontawesome.com/ea36f2192f.js" crossorigin="anonymous"></script>
<!--달력 css & js https://www.daterangepicker.com/ 라이브러리  -->
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
<!--달력 css & js https://www.daterangepicker.com/ 라이브러리  -->
<script type="text/javascript" src="/resources/js/index.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<title>Document</title>
</head>
<body>
   <container id="container">
   <div id="join">
      <div class="flex">
         <div class="popup">
            <div class="joinTitle">
               <div class="joinClose" onclick="joinClose()">
                  <i class="fas fa-times"></i>
               </div>
               회원 가입
            </div>
            <div class="joinCore" id="showJoin">
               <div class="joinCtnt">카카오 계정으로 회원가입</div>
               <div class="line">――――――――――――――― 또는 ―――――――――――――――</div>
               <div class="mailJoin" onclick="mailJoin()">
                  <i class="far fa-envelope"></i> 이메일로 회원 가입
               </div>
               <div class="line">――――――――――――――――――――――――――――――――――</div>
               <div class="joinFooter">
                  이미 에어비앤비 계정이 있나요? <span class="jToL"> 로그인</span>
               </div>
            </div>

				<div class="joinCore" id="joinSubmit" name="joinSubmit"
					method="post">
					<div class="joinFooter" id="JST">
						<span class="jToL">카카오</span>로 회원 가입하세요.
					</div>
					<div class="line">――――――――――――――― 또는 ―――――――――――――――</div>
					<div id="joinForm" name="joinSubmit">
						<div class="joinCtnt">
							<div class="joinBox">
								<div>
									<input type="email" id="s_e_mail" placeholder="이메일 주소">
								</div>
								<div>
									<input type="text" id="s_nm" placeholder="이름 (예: 홍길동)">
								</div>
								<div>
									<input type="password" id="s_c_pw" placeholder="비밀번호 설정하기">
								</div>
							</div>
							<div id="birthTitle">생일</div>
							<div class="birthCtnt">만 18세 이상의 성인만 회원으로 가입할 수 있습니다. 생일은
								다른 에어비앤비 이용자에게 공개되지 않습니다.</div>
							<div class="joinBox">
								<input type="number" id="bir_day"
									placeholder="생년월일 (예: 19900315)">
							</div>
							
							<button type="button" class="mailJoin" onclick="join()">가입하기</button>
							
							<div class="erro"></div>
							
							<div class="line">――――――――――――――――――――――――――――――――――</div>
							<div class="joinFooter">
								이미 에어비앤비 계정이 있나요? <span class="jToL"> 로그인</span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="login">
		<div class="flex">
			<div class="popup">
				<div class="joinTitle">
					<div class="joinClose" onclick="loginClose()">
						<i class="fas fa-times"></i>
					</div>
					로그인
				</div>
				<div class="joinCore">
					<div class="loginCtnt">카카오 로그인</div>
					<div class="line">―――――――――――――――― 또는 ―――――――――――――――</div>
					<div>
						<div class="joinCtnt">
							<input type="text" id="e_mail" placeholder="이메일 주소"> 
							<input type="password" id="c_pw" placeholder="비밀번호"> 
							<button type="button" class="mailJoin" onclick="login()">로그인</button>
						</div>
						<div class="erro1"></div>
					</div>
					<div class="line">――――――――――――――――――――――――――――――――――</div>
					<div>
						에어비앤비 계정이 없으세요? <span class="jToL">회원 가입</span>
					</div>
				</div>
			</div>
		</div>
	</div>
	<header>
		<div>에어비앤비의 코로나19 대응 방안에 대한 최신 정보를 확인하세요.</div>
	</header>

       
   <nav id="core">
      <div>
         <img id="logo" src="/resources/img/mainlogo.png">
      </div>
      <div id="menu">
         <li class="menuli">숙소</li>
         <li class="menuli">월 단위 숙박</li>
         <li class="menuli">체험</li>
         <li class="menuli">온라인 체험</li>
      </div>
      <div id="menubutton" onclick="myMenu()">
         <div>
            <img id="ham" src="/resources/img/bars-solid.svg">
         </div>
         <div id="profile">
            <img src="${loginUser.my_profile != null ? loginUser.my_profile : '/resources/img/pimg.jpg'}">
         </div>
      </div>
      
      <div id="menuctnt">
     	 <c:if test="${loginUser.i_user == null}">
         <li class="b" onclick="popupJoin()">회원가입</li>
		 <li class="b" onclick="popupLogin()">로그인</li>
		 <li class="b" onclick="autoLogin()">자동 로그인</li>
		 </c:if>
		 <div class="line">――――――――――――――――</div>
		 <c:if test="${loginUser.i_user != null}">
         <li class="b" onclick="goMsg()">메시지</li>
         <li class="b" onclick="goTrb()">여행</li>
         <li class="b" onclick="goWish()">저장 목록</li>
         <div class="line">――――――――――――――――</div>
         <li class="b" onclick="goHost()">숙소 관리</li>
         <li class="b" onclick="goUser()">계정</li>
         <div class="line">――――――――――――――――</div>
         <li>도움말</li>
         <li class="b" onclick="goLogOut()">로그아웃</li>
         </c:if>
         
      </div>
      <div id="search">
         <li class="sli">
         <label>위치
               <div>
                  <input id="s_addr" class="searchin" type="text" onkeyup="goAddr()"
                     placeholder="어디로 여행가세요?">
               </div>
         </label>
         </li>
         <li class="sli"><label>체크인
               <div>
                  <input id="searchin" class="searchin" type="text" value=""
                     placeholder="날짜 추가" readonly="readonly">
               </div>
         </label></li>
         <li class="sli"><label>체크아웃
               <div>
                  <input id="searchout" class="searchin" type="text" value=""
                     placeholder="날짜 추가" readonly="readonly">
               </div>
         </label></li>
         <li class="sli"><label>인원
               <div>
                  <button onclick="countDw(document.getElementById('dd'))">-</button>
                  <input id="dd" class="searchin" type="number" size="10" value="0">
                  <button onclick="countUp(document.getElementById('dd'))">+</button>
               </div>
         </label></li>
         <li id="sbutton" onclick="goSearch()"><i class="fas fa-search"></i>
         </li>
    </div>
</nav>
</container>


</body>
</html>