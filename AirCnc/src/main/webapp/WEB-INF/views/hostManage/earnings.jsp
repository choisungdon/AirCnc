<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Earnings</title>
<!-- chart js  -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.bundle.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"></script>
<!--이모지 -->
<script src="https://kit.fontawesome.com/ea36f2192f.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="/resources/css/earnings.css">
<script type="text/javascript" src="/resources/js/earnings.js"></script>
</head>
<body>
	<header>
		<div class="sub_header">
		    <div class="log_menu">
		        <a href="/" class="logo">
		            <span >
		                <img src="/resources/img/aircncLog.png">
		            </span>
		        </a>
		        <div class="notice"	onclick="goManage()">알림</div>
                <div class="rsv"	onclick="goRSV(${loginUser.i_user})">예약</div>
                <div class="house"	onclick="goHouse(${loginUser.i_user})">숙소</div>
                <div class="profit" onclick="goProfit(${loginUser.i_user})">실적</div>
		    </div>
		
		    <div class="top_menu">
		        <a href="/host/hosting?i_user=${loginUser.i_user}" class="hSaveBtn">
                    <span class="hSaveBtn">숙소 등록하기</span>
               	</a>
		       
		
		        <span class="userMenu" onclick="viewMenu()">
		            <img class="menu_img" src="/resources/img/bars-solid.svg"  height="16px" width="16px">
                    <img class="my_profile" src="${loginUser.my_profile}" height="30px" width="30px">
		
		            <div class="drop_menu" >
		                <div class="main_menu">
		
		                    <div class="menu_item">
		                        <div>메시지</div>
		                        <div>저장 목록</div>
		                    </div>
		
		                    <div class="menu_item">
		                        <div>숙소 관리</div>
		                        <div>계정</div>
		                    </div>
		
		                    <div class="menu_item">
		                      <div>로그아웃</div>
		                    </div>
		
		                </div>
		            </div>
		        </span>
		    </div>
		</div>
	</header>
	<div class="container">
		<div class="ctnt_main">
	        <div class="ctnt_title">
	           <a href="/hostManage/profit?i_user=${loginUser.i_user}" class="review">후기</a>
               <a href="/hostManage/earnings?i_user${loginUser.i_user}" class="income">수입</a>
	  		</div>
	  
		  <div class="ctnt_all">
			<div class="month_select">월 선택</div>
			<select name="check_out" class="check_out">
				<option value="">월 선택</option>
				<option value="2020-11">2020년 11월</option>
				<option value="2020-11">2020년 11월</option>
				<option value="2020-11">2020년 11월</option>
				<option value="2020-11">2020년 11월</option>
				<option value="2020-11">2020년 11월</option>
				<option value="2020-11">2020년 11월</option>
				<option value="2020-11">2020년 11월</option>
				<option value="2020-11">2020년 11월</option>
				<option value="2020-11">2020년 11월</option>
				<option value="2020-11">2020년 11월</option>
			</select>
		
			<div class="month_fee">
				<h1>₩0</h1>
				<div>2020 예약 수입</div>
			</div>
		
			<div class="fee_state">
				<span>
					<div class="com_fee">₩0</div>
					<div class="com_text">
						<span class="s_color1"></span>
						지급 완료
					</div>
				</span>
				<span>
					<div class="be_fee">₩0</div>
					<div class="be_text">
						<span class="s_color2"></span>
						지급 예정
					</div>
				</span>
			</div>
		
			
			<canvas class="myChart" style="width: 600px; height: 300px;"></canvas>
			
			<div class="cal_button">
				<div class="left_date" onclick="chDate(this)">
					<i class="fas fa-angle-left"></i>
					<span class="date">2019</span>
				</div>
		
				<div class="main_date">2020</div>
		
				<div class="right_date" onclick="chDate(this)">
					<span class="date">2021</span> 
					<i class="fas fa-angle-right"></i>
				</div>
			</div>
		
			<table>
				<caption>2020 세부정보</caption>
				<thead>
				  <tr>
					<th class="house_info">숙소</th>
					<th class="date_info">숙박 일</th>
					<th class="user_info">유저</th>
					<th class="gest_qty">게스트</th>
					<th class="incom_info">수입</th>
				  </tr>
				</thead>
				<tbody>
				  <tr>
					<td class="house_info"><img  src="./img/profile.jpg"  > <span>바르셀로나</span></td>
					<td class="date_info">2020-10-19 ~ 2020-10-19</td>
					<td class="user_info"><img  src="./img/profile.jpg"  > <span>바르셀로나</span></td>
					<td class="gest_qty">8명</td>
					<td class="incom_info">$152,551</td>
				  </tr>
				  <tr>
					<td class="house_info"><img  src="./img/profile.jpg"  > <span>바르셀로나</span></td>
					<td class="date_info">2020-10-19 ~ 2020-10-19</td>
					<td class="user_info"><img  src="./img/profile.jpg"  > <span>바르셀로나</span></td>
					<td class="gest_qty">8명</td>
					<td class="incom_info">$152,551</td>
				  </tr>
	
				  <tr>
					  <td class="total" colspan="4">합계 : </td>
					  <td class="total_fee">
						  $325,151
					  </td>
				  </tr>
				 
				</tbody>
	
			</table>
		
			</div> 
	  </div>
	</div>
   <footer>

   </footer>
</body>
</html>