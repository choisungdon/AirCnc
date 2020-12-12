package com.project.aircnc.common;

import org.apache.ibatis.type.Alias;

@Alias("CheckInOutVO")
public class CheckInOutVO {
	private int i_ck; // pk
	private int i_host;
	private int i_user;
	private String checkin_t; //체크인 (시작)시간
	private String finich_t; //체크인  (마감) 시간
	private int ieast_day; //최소 숙박기간
	private int max_day; //최대 숙박 기간
	private String reser_date; //예약 가능 날짜
	private String reser_end_t; //예약 마감 날짜
	
	
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
	public int getI_ck() {
		return i_ck;
	}
	public void setI_ck(int i_ck) {
		this.i_ck = i_ck;
	}
	public String getCheckin_t() {
		return checkin_t;
	}
	public void setCheckin_t(String checkin_t) {
		this.checkin_t = checkin_t;
	}
	public String getFinich_t() {
		return finich_t;
	}
	public void setFinich_t(String finich_t) {
		this.finich_t = finich_t;
	}
	public int getIeast_day() {
		return ieast_day;
	}
	public void setIeast_day(int ieast_day) {
		this.ieast_day = ieast_day;
	}
	public int getMax_day() {
		return max_day;
	}
	public void setMax_day(int max_day) {
		this.max_day = max_day;
	}
	public String getReser_date() {
		return reser_date;
	}
	public void setReser_date(String reser_date) {
		this.reser_date = reser_date;
	}
	public String getReser_end_t() {
		return reser_end_t;
	}
	public void setReser_end_t(String reser_end_t) {
		this.reser_end_t = reser_end_t;
	}
	
	
}