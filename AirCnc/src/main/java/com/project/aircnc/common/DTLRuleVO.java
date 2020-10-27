package com.project.aircnc.common;

import org.apache.ibatis.type.Alias;

@Alias("DTLRuleVO")
public class DTLRuleVO {
	private int i_drule; // pk
	private int i_host;
	private int i_user;
	private String rule; // 추가 규칙 제목
	
	
	
	public int getI_host() {
		return i_host;
	}
	public void setI_host(int i_host) {
		this.i_host = i_host;
	}
	public int getI_user() {
		return i_user;
	}
	public void setI_user(int i_user) {
		this.i_user = i_user;
	}
	public int getI_drule() {
		return i_drule;
	}
	public void setI_drule(int i_drule) {
		this.i_drule = i_drule;
	}
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	
	
}
