package com.project.aircnc.auth;

public interface SnsUrls {
	static final String NAVER_ACCESS_TOKEN = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code"; // 토큰 요청 URL
	static final String NAVER_AUTH = "https://nid.naver.com/oauth2.0/authorize"; // 인증 코드 요청 URL

	static final String GOOGLE_PROFILE_URL = "https://www.googleapis.com/plus/v1/people/me";
	static final String NAVER_PROFILE_URL = "https://openapi.naver.com/v1/nid/me"; // 네이버 회원 정보 요청 URL

}
