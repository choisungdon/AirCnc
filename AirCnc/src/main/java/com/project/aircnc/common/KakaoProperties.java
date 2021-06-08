package com.project.aircnc.common;
//여기 있는 프로필 정보 안씁니다.
public class KakaoProperties {
	private String nickname; // 닉네임 
	private String profile_image; // 프로필 이미지
	private String thumbnail_image; // 프로필 이미지
	
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getProfile_image() {
		return profile_image;
	}
	public void setProfile_image(String profile_image) {
		this.profile_image = profile_image;
	}
	public String getThumbnail_image() {
		return thumbnail_image;
	}
	public void setThumbnail_image(String thumbnail_image) {
		this.thumbnail_image = thumbnail_image;
	}
	
	
}
