package com.project.aircnc.common;

import org.apache.ibatis.type.Alias;

@Alias("EarningsSeachVO")
public class EarningsSeachVO {
	private String check_out; // 년/월 
	private int i_user; // 접속 유저 pk
	
	
	public int getI_user() {
		return i_user;
	}
	public void setI_user(int i_user) {
		this.i_user = i_user;
	}
	
	public String getCheck_out() {
		return check_out;
	}
	public void setCheck_out(String check_out) {
		this.check_out = check_out;
	}
	
}
