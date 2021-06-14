package com.project.aircnc.auth;

import com.github.scribejava.core.builder.api.DefaultApi20;

public class NaverAPI20 extends DefaultApi20 implements SnsUrls{
	// 생성자 싱글톤으로 만들기  
	private NaverAPI20() { 
		
	}
	// static class  생성 (NaverAPI20 객체 생성 )
	private static class InstanceHolder{
		private static final NaverAPI20 INSTANCE = new NaverAPI20();
	}
	// InstanceHolder(getInstance 에서만 부를수 있는 class) 
	public static NaverAPI20  getInstance() { 
		return new InstanceHolder().INSTANCE; // NaverAPI20 객체 리턴 
	}

	@Override // 인증 코드 요청 URL
	public String getAccessTokenEndpoint() {
		
		return NAVER_ACCESS_TOKEN;
	}

	@Override // 네이버 회원 정보 요청 URL
	protected String getAuthorizationBaseUrl() {
		
		return NAVER_AUTH;
	}

}
