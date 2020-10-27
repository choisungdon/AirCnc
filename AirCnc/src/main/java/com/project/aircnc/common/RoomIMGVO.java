package com.project.aircnc.common;

import org.apache.ibatis.type.Alias;

@Alias("RoomIMGVO")
public class RoomIMGVO {
	private int i_img;
	private int i_host;
	private int i_user;
	private String img_url;
	private String room_poto;
	
	
	public String getRoom_poto() {
		return room_poto;
	}
	public void setRoom_poto(String room_poto) {
		this.room_poto = room_poto;
	}
	public int getI_img() {
		return i_img;
	}
	public void setI_img(int i_img) {
		this.i_img = i_img;
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
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	
	
}
