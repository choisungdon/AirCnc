package com.project.aircnc.common;

import org.apache.ibatis.type.Alias;

@Alias("HostUserVO")
public class HostUserVO {
	
	private int i_host;
	private int i_user;
	private String country;
	private String c_lat;
	private String c_lng;
	private String addr;
	private String s_lat;
	private String s_lng;
	private int r_vastion;
	private int rv_state;
	private int b_room;
	private int bed_qty;
	private String bed_type;
	private String bth_room;
	private String room_title;
	private String acc;
	private String acc_bank;
	private String acc_owner;
	private String r_dt;
	private String m_dt;
	
	public int getRv_state() {
		return rv_state;
	}
	public void setRv_state(int rv_state) {
		this.rv_state = rv_state;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getC_lat() {
		return c_lat;
	}
	public void setC_lat(String c_lat) {
		this.c_lat = c_lat;
	}
	public String getC_lng() {
		return c_lng;
	}
	public void setC_lng(String c_lng) {
		this.c_lng = c_lng;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getS_lat() {
		return s_lat;
	}
	public void setS_lat(String s_lat) {
		this.s_lat = s_lat;
	}
	public String getS_lng() {
		return s_lng;
	}
	public void setS_lng(String s_lng) {
		this.s_lng = s_lng;
	}
	public int getR_vastion() {
		return r_vastion;
	}
	public void setR_vastion(int r_vastion) {
		this.r_vastion = r_vastion;
	}
	public int getB_room() {
		return b_room;
	}
	public void setB_room(int b_room) {
		this.b_room = b_room;
	}
	public int getBed_qty() {
		return bed_qty;
	}
	public void setBed_qty(int bed_qty) {
		this.bed_qty = bed_qty;
	}
	public String getBed_type() {
		return bed_type;
	}
	public void setBed_type(String bed_type) {
		this.bed_type = bed_type;
	}
	public String getBth_room() {
		return bth_room;
	}
	public void setBth_room(String bth_room) {
		this.bth_room = bth_room;
	}
	public String getRoom_title() {
		return room_title;
	}
	public void setRoom_title(String room_title) {
		this.room_title = room_title;
	}
	public String getAcc() {
		return acc;
	}
	public void setAcc(String acc) {
		this.acc = acc;
	}
	public String getAcc_bank() {
		return acc_bank;
	}
	public void setAcc_bank(String acc_bank) {
		this.acc_bank = acc_bank;
	}
	public String getAcc_owner() {
		return acc_owner;
	}
	public void setAcc_owner(String acc_owner) {
		this.acc_owner = acc_owner;
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
