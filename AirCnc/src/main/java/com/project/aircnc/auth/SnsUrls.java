package com.project.aircnc.auth;

public interface SnsUrls {
	// 토큰 요청 URL
	public static final String NAVER_ACCESS_TOKEN = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code"; 
	// 인증 코드 요청 URL
	public static final String NAVER_AUTH = "https://nid.naver.com/oauth2.0/authorize"; 
	
	// google 회원 정보 요청 URL 
	public static final String GOOGLE_PROFILE_URL = "https://people.googleapis.com/v1/people/me?personFields=emailAddresses";
	// 네이버 회원 정보 요청 URL
	public static final String NAVER_PROFILE_URL = "https://openapi.naver.com/v1/nid/me"; 
	
	
	// google api key
	public static final String GOOGLE_API_KEY = "AIzaSyALYeMPrcaw2eu6f5f1KNrKAwDfdAgfrKQ";
}
