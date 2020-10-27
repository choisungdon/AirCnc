package com.project.aircnc.common;

import org.apache.ibatis.type.Alias;

@Alias("AircncMsg")
public class AircncMsg {
	int i_msg ; //'pk', 
	int i_mlist;  //'aircnc_msglist(pk)',
	int i_reser; //'user_reser(pk)',
	int i_host;  //'host_user pk 건물 ',
	int i_user; //'user_reser(pk)',
	String cmt; //'메시지 내용',
	String r_dt; //'톡방 생성 날짜',
	String m_dt; //'수정 날짜',
	String state; //'읽음 상태 표시 o/x',
	
	public int getI_msg() {
		return i_msg;
	}
	public void setI_msg(int i_msg) {
		this.i_msg = i_msg;
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
	public int getI_user() {
		return i_user;
	}
	public void setI_user(int i_user) {
		this.i_user = i_user;
	}
	public String getCmt() {
		return cmt;
	}
	public void setCmt(String cmt) {
		this.cmt = cmt;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}
