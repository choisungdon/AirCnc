package com.project.aircnc.common;

public class KakaoUserInfo {
	private int  id; 					// 카카오 회원번호(DB에 저장됩니다.)
	private String connected_at;		// 접소 날짜
	private KakaoProperties properties; // 닉네임 , 프로필 URL
	private KakaoAccount kakao_account; 		// 회원 세부 정보
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getConnected_at() {
		return connected_at;
	}
	public void setConnected_at(String connected_at) {
		this.connected_at = connected_at;
	}
	public KakaoProperties getProperties() {
		return properties;
	}
	public void setProperties(KakaoProperties properties) {
		this.properties = properties;
	}
	public KakaoAccount getKakao_account() {
		return kakao_account;
	}
	public void setKakao_account(KakaoAccount kakao_account) {
		this.kakao_account = kakao_account;
	}
	
	
	
}
