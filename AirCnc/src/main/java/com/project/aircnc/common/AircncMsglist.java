package com.project.aircnc.common;

import org.apache.ibatis.type.Alias;

@Alias("AircncMsglist")
public class AircncMsglist {
	int i_mlist;  //'pk', 
	int i_user;	// t_user pk
	int i_reser; //'user_reser(pk)',
	int i_host; // 'host_user pk 건물 ',
	String ms_title;  //'톡방 이름',
	String r_dt;  //'톡방 생성 날짜',
	String m_dt;   //'수정 날짜',
	
	
	public int getI_user() {
		return i_user;
	}
	public void setI_user(int i_user) {
		this.i_user = i_user;
	}
	public int getI_mlist() {
		return i_mlist;
	}
	public void setI_mlist(int i_mlist) {
		this.i_mlist = i_mlist;
	}
	public int getI_reser() {
		return i_reser;
	}
	public void setI_reser(int i_reser) {
		this.i_reser = i_reser;
	}
	public int getI_host() {
		return i_host;
	}
	public void setI_host(int i_host) {
		this.i_host = i_host;
	}
	public String getMs_title() {
		return ms_title;
	}
	public void setMs_title(String ms_title) {
		this.ms_title = ms_title;
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
	@Override
	public String toString() {
		return "AircncMsglist [i_mlist=" + i_mlist + ", i_user=" + i_user + ", i_reser=" + i_reser + ", i_host="
				+ i_host + ", ms_title=" + ms_title + ", r_dt=" + r_dt + ", m_dt=" + m_dt + ", getI_user()="
				+ getI_user() + ", getI_mlist()=" + getI_mlist() + ", getI_reser()=" + getI_reser() + ", getI_host()="
				+ getI_host() + ", getMs_title()=" + getMs_title() + ", getR_dt()=" + getR_dt() + ", getM_dt()="
				+ getM_dt() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
}
