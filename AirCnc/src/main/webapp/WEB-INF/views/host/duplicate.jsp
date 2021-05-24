<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>남는 방이나 공간 전체를 숙소로 등록하고 에어비엔비 호스트가 되세요.</title>
    <script src="https://kit.fontawesome.com/ea36f2192f.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/resources/css/duplicate.css">
</head>

<body>
    <div class="main">
        <div class="host_list">
            <div class="hl_ctn">
                <h2>
                   		숙소 등록을 완료하고 수입을 올려보세요.
                </h2>
                <p>
                    	숙소를 등록한 후 언제든 숙소를 수정할 수 있습니다.
                </p>
				<c:choose>
				
					<c:when test="${hostingPkVo.i_host > 0}">
						<div class="path" id="path01">
						    <i class="fas fa-check fa-lg"></i>
						    <a class="path_text" href="/host/hostSave?i_host=${hostingPkVo.i_host}"> 
						    	1단계(등록하시려는 숙소의 유형을 선택하세요.)
							</a>
						</div>
					</c:when>
		
					<c:otherwise>
						<div class="null_path" id="path01">
							<i></i>
						    <div class="path_text" > 
						        1단계(등록하시려는 숙소의 유형을 선택하세요.)
							</div>
						</div>
					</c:otherwise>
				
				</c:choose>

				<c:choose>

					<c:when test="${hostingPkVo.i_build > 0}">
						<div class="path" id="path02">
							<i class="fas fa-check fa-lg"></i> 
							<a class="path_text" href="/host/hostSaveOne?i_host=${hostingPkVo.i_host}&i_build=${hostingPkVo.i_build}"> 
								2단계(등록하실 숙소 종류는 무엇인가요?) 
							</a>
						</div>
					</c:when>

					<c:otherwise>
						<div class="null_path" id="path02">
							<i></i>
							<div class="path_text">2단계(등록하실 숙소 종류는 무엇인가요?)</div>
						</div>
					</c:otherwise>

				</c:choose>

				<c:choose>

					<c:when test="${hostingPkVo.i_spt > 0 and hostingPkVo.i_fct > 0}">
						<div class="path" id="path03">
							<i class="fas fa-check fa-lg"></i> 
							<a class="path_text" href="/host/hostSaveTwo?i_host=${hostingPkVo.i_host}&i_fct=${hostingPkVo.i_fct}&i_spt=${hostingPkVo.i_spt}">
								3단계(어떤 편의시설을 제공하시나요?) 
							</a>
						</div>
					</c:when>

					<c:otherwise>
						<div class="null_path" id="path03">
							<i></i>
							<div class="path_text">3단계(어떤 편의시설을 제공하시나요?)</div>
						</div>
					</c:otherwise>

				</c:choose>

				<c:choose>

					<c:when test="${hostingPkVo.i_gest > 0}">
						<div class="path" id="path04">
							<i class="fas fa-check fa-lg"></i> 
							<a class="path_text"
								href="/host/hostSaveThree?i_host=${hostingPkVo.i_host}&i_gest=${hostingPkVo.i_gest}">
								4단계(게스트가 어떤 공간을 사용할 수 있나요?) </a>
						</div>
					</c:when>

					<c:otherwise>
						<div class="null_path" id="path04">
							<i></i>
							<div class="path_text">4단계(게스트가 어떤 공간을 사용할 수 있나요?)</div>
						</div>
					</c:otherwise>

				</c:choose>

				<c:choose>

					<c:when test="${hostingPkVo.i_sinfo > 0}">
						<div class="path" id="path05">
							<i class="fas fa-check fa-lg"></i> <a class="path_text"
								href="/host/hostSaveFour?i_host=${hostingPkVo.i_host}&i_sinfo=${hostingPkVo.i_sinfo}">
								5단계(게스트에게 숙소에 대해 설명해주세요.) </a>
						</div>
					</c:when>

					<c:otherwise>
						<div class="null_path" id="path05">
							<i></i>
							<div class="path_text">5단계(게스트에게 숙소에 대해 설명해주세요.)</div>
						</div>
					</c:otherwise>

				</c:choose>

				<c:choose>

					<c:when test="${hostingPkVo.i_rule > 0 or hostingPkVo.i_dtr > 0}">
						<div class="path" id="path06">
							<i class="fas fa-check fa-lg"></i> <a class="path_text"
								href="/host/hostSaveFive?i_host=${hostingPkVo.i_host}&i_rule=${hostingPkVo.i_rule}&i_dtr=${hostingPkVo.i_dtr}">
								6단계(게스트가 지켜야 할 숙소 이용규칙을 정하세요.) </a>
						</div>
					</c:when>

					<c:otherwise>
						<div class="null_path" id="path06">
							<i></i>
							<div class="path_text">6단계(게스트에게 숙소에 대해 설명해주세요.)</div>
						</div>
					</c:otherwise>

				</c:choose>

				<c:choose>

					<c:when test="${hostingPkVo.i_ck > 0}">
						<div class="path" id="path07">
							<i class="fas fa-check fa-lg"></i> <a class="path_text"
								href="/host/hostSaveSix?i_host=${hostingPkVo.i_host}&i_ck=${hostingPkVo.i_ck}">
								7단계(체크인 가능 시간을 선택해 주세요.) </a>
						</div>
					</c:when>

					<c:otherwise>
						<div class="null_path" id="path07">
							<i></i>
							<div class="path_text">7단계(체크인 가능 시간을 선택해 주세요.)</div>
						</div>
					</c:otherwise>

				</c:choose>

				
				<c:choose>

					<c:when test="${hostingPkVo.i_fee > 0}">
						<div class="path" id="path08">
                    <i class="fas fa-check fa-lg"></i>
                     <a class="path_text" href="/host/hostSaveSeven?i_host=${hostingPkVo.i_host}&i_fee=${hostingPkVo.i_fee}"> 
                        8단계(숙소 요금을 지정해주세요.)
                    </a>
                </div>
					</c:when>

					<c:otherwise>
						<div class="null_path" id="path08">
							<i></i>
							<div class="path_text">8단계(숙소 요금을 지정해주세요.)</div>
						</div>
					</c:otherwise>

				</c:choose>

				<c:choose>

					<c:when test="${hostingPkVo.i_ph > 0}">
						<div class="path" id="path09">
							<i class="fas fa-check fa-lg"></i> <a class="path_text"
								href="/host/hostSaveEight?i_host=${hostingPkVo.i_host}&i_ph=${hostingPkVo.i_ph}">
								9단계(숙소 연락처를 지정하세요.) </a>
						</div>
					</c:when>

					<c:otherwise>
						<div class="null_path" id="path09">
							<i></i>
							<div class="path_text">9단계(숙소 연락처를 지정하세요.)</div>
						</div>
					</c:otherwise>

				</c:choose>

				<c:choose>

					<c:when test="${hostingPkVo.i_host > 0}">
						<div class="path" id="path10">
							<i class="fas fa-check fa-lg"></i> <a class="path_text"
								href="/host/hostSaveNine?i_host=${hostingPkVo.i_host}"> 10단계(숙소 사진을
								지정하세요.) </a>
						</div>
					</c:when>

					<c:otherwise>
						<div class="null_path" id="path10">
							<i></i>
							<div class="path_text">10단계(숙소 사진을 지정하세요.)</div>
						</div>
					</c:otherwise>

				</c:choose>

			</div>
        </div>
        <div class="back_img">
            <img class="img_ctnt_item" src="https://a0.muscache.com/airbnb/static/packages/photos.6f837cb4.png"
                data-original-uri="https://a0.muscache.com/airbnb/static/packages/photos.6f837cb4.png">
        </div>
    </div>
</body>
</html>