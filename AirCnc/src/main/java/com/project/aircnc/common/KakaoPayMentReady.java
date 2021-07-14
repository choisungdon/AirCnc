package com.project.aircnc.common;

public class KakaoPayMentReady {
	private String tid;
	private String tms_result;
	private String next_redirect_app_url;
	private String next_redirect_mobile_url;
	private String next_redirect_pc_url;
	private String android_app_scheme;
	private String ios_app_scheme;
	private String created_at;
	/*
	tid							String		결제 고유 번호, 20자
	next_redirect_app_url		String		요청한 클라이언트(Client)가 모바일 앱일 경우
											카카오톡 결제 페이지 Redirect URL
	next_redirect_mobile_url	String		요청한 클라이언트가 모바일 웹일 경우
											카카오톡 결제 페이지 Redirect URL
	next_redirect_pc_url		String		요청한 클라이언트가 PC 웹일 경우
											카카오톡으로 결제 요청 메시지(TMS)를 보내기 위한 사용자 정보 입력 화면 Redirect URL
	android_app_scheme			String		카카오페이 결제 화면으로 이동하는 Android 앱 스킴(Scheme)
	ios_app_scheme				String		카카오페이 결제 화면으로 이동하는 iOS 앱 스킴
	created_at					Datetime	결제 준비 요청 시간
	 */
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getTms_result() {
		return tms_result;
	}
	public void setTms_result(String tms_result) {
		this.tms_result = tms_result;
	}
	public String getNext_redirect_app_url() {
		return next_redirect_app_url;
	}
	public void setNext_redirect_app_url(String next_redirect_app_url) {
		this.next_redirect_app_url = next_redirect_app_url;
	}
	public String getNext_redirect_mobile_url() {
		return next_redirect_mobile_url;
	}
	public void setNext_redirect_mobile_url(String next_redirect_mobile_url) {
		this.next_redirect_mobile_url = next_redirect_mobile_url;
	}
	public String getNext_redirect_pc_url() {
		return next_redirect_pc_url;
	}
	public void setNext_redirect_pc_url(String next_redirect_pc_url) {
		this.next_redirect_pc_url = next_redirect_pc_url;
	}
	public String getAndroid_app_scheme() {
		return android_app_scheme;
	}
	public void setAndroid_app_scheme(String android_app_scheme) {
		this.android_app_scheme = android_app_scheme;
	}
	public String getIos_app_scheme() {
		return ios_app_scheme;
	}
	public void setIos_app_scheme(String ios_app_scheme) {
		this.ios_app_scheme = ios_app_scheme;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	@Override
	public String toString() {
		return "KakaoPayMentReady [tid=" + tid + ", tms_result=" + tms_result + ", next_redirect_app_url="
				+ next_redirect_app_url + ", next_redirect_mobile_url=" + next_redirect_mobile_url
				+ ", next_redirect_pc_url=" + next_redirect_pc_url + ", android_app_scheme=" + android_app_scheme
				+ ", ios_app_scheme=" + ios_app_scheme + ", created_at=" + created_at + "]";
	}
	
	
}
