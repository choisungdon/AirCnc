package com.project.aircnc.common;

import org.apache.ibatis.type.Alias;

@Alias("HostRsvCancelVO")
public class HostRsvCancelVO extends UserRsvCancelVO{
	private String img_url;
	private String room_title;
	private String nm; // 예약자 ㄴ 이름
	private String pro_img;// 예약자 사진 
	
	
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
