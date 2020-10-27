<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>숙소 등록을 완료하고 수입을 올려보세요.</h2>
<p>숙소를 등록한 후 언제든 숙소를 수정할 수 있습니다.</p>
	<a href="/host/hostSave?i_host=${data.i_host}">
		<div>1단계(등록하시려는 숙소의 유형을 선택하세요.)</div>
	</a>
	<a href="/host/hostSaveOne?i_host=${data.i_host}&i_build=${data.i_build}">
		<div>2단계(등록하실 숙소 종류는 무엇인가요?)</div>
	</a>
	<a href="/host/hostSaveTwo?i_host=${data.i_host}&i_fct=${data.i_fct}&i_spt=${data.i_spt}">
		<div>3단계(어떤 편의시설을 제공하시나요?)</div>
	</a>
	<a href="/host/hostSaveThree?i_host=${data.i_host}&i_gest=${data.i_gest}">
		<div>4단계(게스트가 어떤 공간을 사용할 수 있나요?)</div>
	</a>
	<a href="/host/hostSaveFour?i_host=${data.i_host}&i_sinfo=${data.i_sinfo}">
		<div>5단계(게스트에게 숙소에 대해 설명해주세요.)</div>
	</a>
	<a href="/host/hostSaveFive?i_host=${data.i_host}&i_rule=${data.i_rule}&i_dtr=${data.i_dtr}">
		<div>6단계(게스트가 지켜야 할 숙소 이용규칙을 정하세요.)</div>
	</a>
	<a href="/host/hostSaveSix?i_host=${data.i_host}&i_ck=${data.i_ck}">
		<div>7단계(체크인 가능 시간을 선택해 주세요.)</div>
	</a>
	<a href="/host/hostSaveSeven?i_host=${data.i_host}&i_fee=${data.i_fee}">
		<div>8단계(숙소 요금을 지정해주세요.)</div>
	</a>
	<a href="/host/hostSaveEight?i_host=${data.i_host}&i_ph=${data.i_ph}">
		<div>9단계(숙소 연락처를 지정하세요.)</div>
	</a>
	<a href="/host/hostSaveNine?i_host=${data.i_host}">
		<div>10단계(숙소 사진을 지정하세요.)</div>
	</a>
	
	
</body>
</html>