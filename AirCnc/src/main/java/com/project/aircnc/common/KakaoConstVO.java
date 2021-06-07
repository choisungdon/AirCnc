package com.project.aircnc.common;

public class KakaoConstVO {
	public static final String KAKAO_CLIENT_ID = "78042122bad236d18f1a05b6ab513eb0";
	public static final String KAKAO_AUTH_REDIRECT_URI = "http://www.aircnc.co.kr:8090/joinKAKAO";
	public static final String KAKAO_ACCESS_TOKEN_HOST = "https://kauth.kakao.com/oauth/token";
	public static final String KAKAO_TOKEN_REDIRECT_URI = "http://www.aircnc.co.kr:8090/joinKAKAO"; // 토큰 발급 request 할때 redirectURL
	public static final String KAKAO_API_HOST = "https://kapi.kakao.com"; // 토큰 발급 요청 url
	public static final String KAKAO_REQUIRED_SCOPES = "profile,account_email,gender,age_range,birthday";// 정보 발급 동의 항목

}