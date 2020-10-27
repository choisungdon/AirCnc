package com.project.aircnc.common;

import org.apache.ibatis.type.Alias;

@Alias("UserRsvCancelVO")
public class UserRsvCancelVO {
	private int i_cancel ;
	private int i_host;
	private int i_user;
	private int i_reser;
	private String reason;
	private String state;
	private String r_dt;
	private String m_dt;
	
	public int getI_cancel() {
		return i_cancel;
	}
	public void setI_cancel(int i_cancel) {
		this.i_cancel = i_cancel;
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
	public int getI_reser() {
		return i_reser;
	}
	public void setI_reser(int i_reser) {
		this.i_reser = i_reser;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
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
