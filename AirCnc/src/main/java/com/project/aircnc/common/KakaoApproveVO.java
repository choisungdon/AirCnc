package com.project.aircnc.common;

public class KakaoApproveVO {
	private ReservationVO rv; // 숙소 예약 정보
	private KakaoPayMentReady kpmr;// 결제 고유 번호 확인 참조 변수
	private String pg_token; // 결제승인 요청을 인증하는 토큰
	// redirect url로 설정한 approval_url에서 파라미터로 받을수 있음
	
	public ReservationVO getRv() {
		return rv;
	}
	public void setRv(ReservationVO rv) {
		this.rv = rv;
	}
	public KakaoPayMentReady getKpmr() {
		return kpmr;
	}
	public void setKpmr(KakaoPayMentReady kpmr) {
		this.kpmr = kpmr;
	}
	public String getPg_token() {
		return pg_token;
	}
	public void setPg_token(String pg_token) {
		this.pg_token = pg_token;
	}
	
	
}
