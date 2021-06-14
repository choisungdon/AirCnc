package com.project.aircnc.auth;

public class NaverReponse {
	private String id;
	private String nickname;
	private String email;
	private String mobile;
	private String mobile_e164;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email.trim();
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getMobile_e164() {
		return mobile_e164;
	}
	public void setMobile_e164(String mobile_e164) {
		this.mobile_e164 = mobile_e164;
	}
	
	@Override
	public String toString() {
		return "NaverReponse [id=" + id + ", nickname=" + nickname + ", email=" + email + ", mobile=" + mobile
				+ ", mobile_e164=" + mobile_e164 + "]";
	}
	
	
}
