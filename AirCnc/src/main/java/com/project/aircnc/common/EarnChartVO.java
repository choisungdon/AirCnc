package com.project.aircnc.common;

import org.apache.ibatis.type.Alias;

@Alias("EarnChartVO")
public class EarnChartVO {
	private String check_out; // 검색 월 
	private int b_fee; // 지급 예정 요금
	private int c_fee; // 지금 완료 요금
	
	public String getCheck_out() {
		return check_out;
	}
	public void setCheck_out(String check_out) {
		this.check_out = check_out;
	}
	public int getB_fee() {
		return b_fee;
	}
	public void setB_fee(int b_fee) {
		this.b_fee = b_fee;
	}
	public int getC_fee() {
		return c_fee;
	}
	public void setC_fee(int c_fee) {
		this.c_fee = c_fee;
	}

}
