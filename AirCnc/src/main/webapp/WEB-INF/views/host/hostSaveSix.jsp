<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
<title></title>
</head>
<body>
	<p>7단계 ${loginUser.nm}님  체크인 가능 시간을 선택해 주세요.</p>
	<div>체크인 (시작)시간 체크인  (마감) 시간</div>
	<form action="/host/hostSaveSeven" method="post">
		<input type="hidden" name="i_host" value="${i_host}">
		<input type="hidden" name="i_user" value="${loginUser.i_user}">
		<c:if test="${vo.i_ck != null}"> 
			<input type="hidden"  name="i_ck" value="${vo.i_ck}">
		</c:if>
		
		<div>
			<input type="time" id="checkin_t" name="checkin_t" value="${(vo.checkin_t != null && vo.checkin_t != '') ? vo.checkin_t :''}">
			<input type="time" id="finich_t" name="finich_t" value="${(vo.finich_t != null && vo.finich_t != '') ? vo.finich_t :''}">
		</div>
		
		<div>최소 숙박 기간</div>
		<div>
			<button type="button"	onclick="countDw(document.getElementById('ieast_day'))">-</button>
	     		<input 	id="ieast_day" 	name="ieast_day"		type="number"	size="10"	value="${(vo.ieast_day != null && vo.ieast_day != 0) ? vo.ieast_day : 1 }" >
	        <button type="button" 	onclick="countUp(document.getElementById('ieast_day'))">+</button>
		</div>
		
		<div>최대 숙박 기간</div>
		<div>
			<button type="button"	onclick="countDw(document.getElementById('max_day'))">-</button>
	     		<input 	id="max_day" 	name="max_day"		type="number"	size="10"	value="${(vo.max_day != null && vo.max_day != 0) ? vo.max_day : 1 }" >
	        <button type="button" 	onclick="countUp(document.getElementById('max_day'))">+</button>
		</div>
		
		<div> </div>
		
		 <li class="sli">
			 <label>예약 가능 날짜
	               <div>
	                  <input id="reser_date" name="reser_date" type="text" value="${(vo.reser_date != null && vo.reser_date != '') ? vo.reser_date : '' }" placeholder="날짜 추가" readonly="readonly">
	               </div>
	         </label>
         </li>
         <li class="sli">
	         <label>예약 마감 날짜
	               <div>
	                  <input id="reser_end_t" name="reser_end_t" type="text" value="${(vo.reser_end_t != null && vo.reser_end_t != '') ? vo.reser_end_t : '' }" placeholder="날짜 추가" readonly="readonly">
	               </div>
	         </label>
         </li>
		
		
		<input type="submit" value="다음">
	</form>
	
<script type="text/javascript">

//달력 
$(function() {
 //예약 가능 날짜  달력 출력 
  $('input[id="reser_date"]').daterangepicker({
      autoUpdateInput: false,
      locale: {
          cancelLabel: 'Clear'
      }
  });
// apply 누른 순간 input value에 날짜 값 삽입 
  $('input[id="reser_date"]').on('apply.daterangepicker', function(ev, picker) {
      $(this).val(picker.startDate.format('YYYY-MM-DD'));
	  $('input[id="reser_end_t"]').val(picker.endDate.format('YYYY-MM-DD'));
  });
//  Clear 눌렀을때 삽입된 값 비우기 
  $('input[id="reser_date"]').on('cancel.daterangepicker', function(ev, picker) {
      $(this).val('');
	  $('input[id="reser_end_t"]').val('');
  });
 //예약 마감 날짜 눌렀을때  달력 출력 
  $('input[id="reser_end_t"]').daterangepicker({
      autoUpdateInput: false,
      locale: {
          cancelLabel: 'Clear'
      }
  });
// apply 누른 순간 input value에 날짜 값 삽입 
  $('input[id="reser_end_t"]').on('apply.daterangepicker', function(ev, picker) {
      $(this).val(picker.endDate.format('YYYY-MM-DD')); 
	  $('input[id="reser_date"]').val(picker.startDate.format('YYYY-MM-DD'));
  });
//  Clear 눌렀을때 삽입된 값 비우기 
  $('input[id="reser_end_t"]').on('cancel.daterangepicker', function(ev, picker) {
      $(this).val('');
	  $('input[id="reser_date"]').val('');
  });

});


 
function countUp(d) {
    d.value = parseInt(d.value) + 1;
}
	
function countDw(d) {
    d.value = parseInt(d.value) - 1;
    if(d.value < 1) {
        d.value = 1;
    }
}
 
</script>
</body>
</html>