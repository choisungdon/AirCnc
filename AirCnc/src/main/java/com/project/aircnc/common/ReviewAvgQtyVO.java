package com.project.aircnc.common;

import org.apache.ibatis.type.Alias;

@Alias("ReviewAvgQtyVO")
public class ReviewAvgQtyVO {
	private int avg_val; // 후기 평균 점수 
	private int ctnt_qty; // 후기 개수 
	
	// 검색 조건 
	private int i_user; // 로그인 유저 pk
	private int i_host; // 숙소 pk
	private int evaluate_val; // 숙소 후기 점수 
	
	public int getI_user() {
		return i_user;
	}
	public void setI_user(int i_user) {
		this.i_user = i_user;
	}
	public int getI_host() {
		return i_host;
	}
	public void setI_host(int i_host) {
		this.i_host = i_host;
	}
	public int getEvaluate_val() {
		return evaluate_val;
	}
	public void setEvaluate_val(int evaluate_val) {
		this.evaluate_val = evaluate_val;
	}
	public int getAvg_val() {
		return avg_val;
	}
	public void setAvg_val(int avg_val) {
		this.avg_val = avg_val;
	}
	public int getCtnt_qty() {
		return ctnt_qty;
	}
	public void setCtnt_qty(int ctnt_qty) {
		this.ctnt_qty = ctnt_qty;
	}
	
}
