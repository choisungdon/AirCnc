package com.project.aircnc.common;

import org.apache.ibatis.type.Alias;

@Alias("SelChangeDataVO")
public class SelChangeDataVO extends UserRsvChangeVO{
	private String img_url; // 숙소 이미지 
	private String room_title; // 숙소 제목 
	private String addr; // 주소 
	private int bed_qty; // 침대 개수
	private String live_type; // 숙박 유형 
	private String typ; // 집 유형
	private String nm; // 숙소 예약자 이름
	private String pro_img; // 숙소 예약자 이미지 
	
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
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getBed_qty() {
		return bed_qty;
	}
	public void setBed_qty(int bed_qty) {
		this.bed_qty = bed_qty;
	}
	public String getLive_type() {
		return live_type;
	}
	public void setLive_type(String live_type) {
		this.live_type = live_type;
	}
	public String getTyp() {
		return typ;
	}
	public void setTyp(String typ) {
		this.typ = typ;
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
	
}
