package com.project.aircnc.common;

public class KakaoConstVO {
	public static final String KAKAO_CLIENT_ID 			= "787f223db6a3d1e71762c4bcbc9adb59";
	public static final String KAKAO_LOGIN_REDIRECT_URI = "http://www.aircnc.co.kr:8090/loginKAKAO01";
	public static final String KAKAO_ACCESS_TOKEN_HOST 	= "https://kauth.kakao.com/oauth/token";
	public static final String KAKAO_API_HOST 			= "https://kapi.kakao.com"; // 토큰 발급 요청 url
	public static final String KAKAO_REQUIRED_SCOPES 	= "profile,account_email,gender,age_range,birthday";// 정보 발급 동의 항목
	public static final String KAKAO_APP_ADMIN_KEY		= "b792a2a759af3f4f77c6090199c10b93";
	public static final String KAKAO_APPROVAL_URL		= "http://www.aircnc.co.kr:8090/reservation/kakaoApproval"; // 카카오 페이 성공 Redirect URL
	public static final String KAKAO_CANCEL_URL			= "http://www.aircnc.co.kr:8090/reservation/kakaoCancel";	// 카카오 페이 취소 Redirect URL
	public static final String KAKAO_FAIL_URL			= "http://www.aircnc.co.kr:8090/reservation/kakaoFail";		// 카카오 페이 실패 Redirect URL
			
}
