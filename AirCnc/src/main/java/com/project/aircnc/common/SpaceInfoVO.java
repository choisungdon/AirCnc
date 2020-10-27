package com.project.aircnc.common;

import org.apache.ibatis.type.Alias;

@Alias("SpaceInfoVO")
public class SpaceInfoVO {
	private int i_sinfo; // pk
	private int i_host;
	private int i_user;
	private String expa; //  설명란
	private String room_info; //숙소 정보
	private String loca_info; //숙소 위치 정보
	private String traf_info; //교통편 정보
	
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
	public int getI_sinfo() {
		return i_sinfo;
	}
	public void setI_sinfo(int i_sinfo) {
		this.i_sinfo = i_sinfo;
	}
	public String getExpa() {
		return expa;
	}
	public void setExpa(String expa) {
		this.expa = expa;
	}
	public String getRoom_info() {
		return room_info;
	}
	public void setRoom_info(String room_info) {
		this.room_info = room_info;
	}
	public String getLoca_info() {
		return loca_info;
	}
	public void setLoca_info(String loca_info) {
		this.loca_info = loca_info;
	}
	public String getTraf_info() {
		return traf_info;
	}
	public void setTraf_info(String traf_info) {
		this.traf_info = traf_info;
	}
	
	
}
