package com.project.aircnc.common;

import java.util.Arrays;

public class KakaoTokenVO {
	private String token_type ;				// 토큰 타입, bearer로 고정(사용 안함)
	private String access_token;			// 사용자 액세스 토큰 값
	private int expires_in;					// 액세스 토큰 만료 시간(초)
	private String refresh_token;			// 사용자 리프레시 토큰 값
	private int refresh_token_expires_in;	// 리프레시 토큰 만료 시간(초)
	private String scope;					/* 인증된 사용자의 정보 조회 권한 범위
											 범위가 여러 개일 경우, 공백으로 구분*/
	private String[] scope_list;
	
	
	
	@Override
	public String toString() {
		return "KakaoTokenVO [token_type=" + token_type + ", access_token=" + access_token + ", expires_in="
				+ expires_in + ", refresh_token=" + refresh_token + ", refresh_token_expires_in="
				+ refresh_token_expires_in + ", scope=" + scope + ", scope_list=" + Arrays.toString(scope_list) + "]";
	}
	
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		
		this.setScope_list(scope.split(" ")); // 문자열 공백으로 구분한 String 배열 저장
		
		this.scope = scope;
	}
	public String[] getScope_list() {
		return scope_list;
	}
	public void setScope_list(String[] scope_list) {
		this.scope_list = scope_list;
	}
	public String getToken_type() {
		return token_type;
	}
	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public int getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}
	public String getRefresh_token() {
		return refresh_token;
	}
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}
	public int getRefresh_token_expires_in() {
		return refresh_token_expires_in;
	}
	public void setRefresh_token_expires_in(int refresh_token_expires_in) {
		this.refresh_token_expires_in = refresh_token_expires_in;
	}
	
	

}
