package com.project.aircnc.common;

import org.apache.ibatis.type.Alias;

@Alias("RsvViewData")
public class RsvViewData extends ReservationVO{
	private String img_url;// 숙소 이미지 
	private String room_title; // 숙소 제목
	private String live_type; //'집전체 all, 개인실 single, 다인실  share',
	private String typ;// '아파트 apt, 별채 outbuild',
	private String bed_qty ; // 침대 개수 
	private String nm ;// 예약자 이름 
	private String pro_img;// 예약자 사진 
	private int fee;
	private String r_dt;
	private String m_dt;
	
	
	public String getTyp() {
		return typ;
	}
	public void setTyp(String typ) {
		this.typ = typ;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	public String getRoom_title() {
		return room_title;
	}
	public void setRoom_title(String room_title) {
		this.room_title = room_title;
	}
	public String getLive_type() {
		return live_type;
	}
	public void setLive_type(String live_type) {
		this.live_type = live_type;
	}
	public String getBed_qty() {
		return bed_qty;
	}
	public void setBed_qty(String bed_qty) {
		this.bed_qty = bed_qty;
	}
	public String getNm() {
		return nm;
	}
	public void setNm(String nm) {
		this.nm = nm;
	}
	public String getPro_img() {
		return pro_img;
	}
	public void setPro_img(String pro_img) {
		this.pro_img = pro_img;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
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
