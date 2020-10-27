package com.project.aircnc.common;

import org.apache.ibatis.type.Alias;

@Alias("WorkplacePhVO")
public class WorkplacePhVO {
	private int i_ph; // pk
	private int i_host;
	private int i_user;
	private String wp_ph; // 사업장 전화 번호
	private String gest_ok; //게스트 연락 가능 여부
	private String r_dt;
	private String m_dt;
	
	public int getI_ph() {
		return i_ph;
	}
	public void setI_ph(int i_ph) {
		this.i_ph = i_ph;
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
	public String getWp_ph() {
		return wp_ph;
	}
	public void setWp_ph(String wp_ph) {
		this.wp_ph = wp_ph;
	}
	public String getGest_ok() {
		return gest_ok;
	}
	public void setGest_ok(String gest_ok) {
		this.gest_ok = gest_ok;
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