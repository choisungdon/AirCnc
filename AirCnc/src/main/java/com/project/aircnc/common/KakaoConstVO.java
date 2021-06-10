package com.project.aircnc.common;

public class KakaoConstVO {
	public static final String KAKAO_CLIENT_ID = "787f223db6a3d1e71762c4bcbc9adb59";
	public static final String KAKAO_LOGIN_REDIRECT_URI = "http://www.aircnc.co.kr:8090/loginKAKAO01";
	public static final String KAKAO_JOIN_REDIRECT_URI = "http://www.aircnc.co.kr:8090/joinKAKAO01";
	public static final String KAKAO_ACCESS_TOKEN_HOST = "https://kauth.kakao.com/oauth/token";
	public static final String KAKAO_API_HOST = "https://kapi.kakao.com"; // 토큰 발급 요청 url
	public static final String KAKAO_REQUIRED_SCOPES = "profile,account_email,gender,age_range,birthday";// 정보 발급 동의 항목

}
