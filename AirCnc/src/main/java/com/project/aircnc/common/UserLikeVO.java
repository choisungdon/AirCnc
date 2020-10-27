package com.project.aircnc.common;

import org.apache.ibatis.type.Alias;

@Alias("UserLikeVO")
public class UserLikeVO {

	private int i_like;
	private int i_host;
	private int i_user;
	private int i_list;
	private String r_dt;
	private String m_dt;
	
	
	public int getI_list() {
		return i_list;
	}
	public void setI_list(int i_list) {
		this.i_list = i_list;
	}
	public int getI_like() {
		return i_like;
	}
	public void setI_like(int i_like) {
		this.i_like = i_like;
	}
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
	public String getR_dt() {
		return r_dt;
	}
	public void setR_dt(String r_dt) {
		this.r_dt = r_dt;
	}
	public String getM_dt() {
		return m_dt;
	}
	public void setM_dt(String m_dt) {
		this.m_dt = m_dt;
	}
	
	
}
