package com.project.aircnc.common;

import org.apache.ibatis.type.Alias;

@Alias("UserShowVO")
public class UserShowVO extends TUserVO {
	private String join_date;// 회원 가입일 
	private String emailConfirm; // 이메일 인증
	private String phConfirm; // 전화번호  인증 
	private int count; // 후기  개수 
	
	public String getJoin_date() {
		return join_date;
	}
	public void setJoin_date(String join_date) {
		this.join_date = join_date;
	}
	public String getEmailConfirm() {
		return emailConfirm;
	}
	public void setEmailConfirm(String emailConfirm) {
		this.emailConfirm = emailConfirm;
	}
	public String getPhConfirm() {
		return phConfirm;
	}
	public void setPhConfirm(String phConfirm) {
		this.phConfirm = phConfirm;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
