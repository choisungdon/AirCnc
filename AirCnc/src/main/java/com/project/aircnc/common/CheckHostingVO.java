package com.project.aircnc.common;

import org.apache.ibatis.type.Alias;

@Alias("CheckHostingVO")
public class CheckHostingVO {
	
	private int i_host;
	private int i_user;
	private String room_title;
	private String img_url;
	
	
	public int getI_user() {
		return i_user;
	}
	public void setI_user(int i_user) {
		this.i_user = i_user;
	}
	public int getI_host() {
		return i_host;
	}
	public void setI_host(int i_host) {
		this.i_host = i_host;
	}
	public String getRoom_title() {
		return room_title;
	}
	public void setRoom_title(String room_title) {
		this.room_title = room_title;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	
}