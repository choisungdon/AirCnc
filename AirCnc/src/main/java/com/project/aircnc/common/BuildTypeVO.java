package com.project.aircnc.common;

import org.apache.ibatis.type.Alias;

@Alias("BuildTypeVO")
public class BuildTypeVO {
	private int i_build; // pk
	private int i_host;
	private int i_user;
	private String typ; // 아파트 apt, 별채 outbuild
	private String live_type; //집전체 all, 개인실 single, 다인실  share
	
	
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
	public int getI_build() {
		return i_build;
	}
	public void setI_build(int i_build) {
		this.i_build = i_build;
	}
	public String getTyp() {
		return typ;
	}
	public void setTyp(String typ) {
		this.typ = typ;
	}
	public String getLive_type() {
		return live_type;
	}
	public void setLive_type(String live_type) {
		this.live_type = live_type;
	}
	
	
	
	
}

