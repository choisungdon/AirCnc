package com.project.aircnc.common;

import org.apache.ibatis.type.Alias;

@Alias("EarnChartVO")
public class EarnChartVO {
	private String check_out; // 검색 월 
	private int fee; // 지급 예정 요금
	private String reser_state;// 상태 값  'o' : 지급 완료  null : 지급 예정
	
	public String getCheck_out() {
		return check_out;
	}
	public void setCheck_out(String check_out) {
		this.check_out = check_out;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public String getReser_state() {
		return reser_state;
	}
	public void setReser_state(String reser_state) {
		this.reser_state = reser_state;
	}
}
