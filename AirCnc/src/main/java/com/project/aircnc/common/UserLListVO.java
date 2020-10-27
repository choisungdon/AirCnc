package com.project.aircnc.common;

import org.apache.ibatis.type.Alias;

@Alias("UserLListVO")
public class UserLListVO extends UserLikeVO {
	private int i_list;
	private int i_user;
	private int host_count;// 저장된 숙소 qty
	private String list_title;
	private String r_dt;
	private String m_dt;
	private String img_url;
	private String like_profile;
	

	
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	public String getLike_profile() {
		return like_profile;
	}
	public void setLike_profile(String like_profile) {
		this.like_profile = like_profile;
	}
	public int getHost_count() {
		return host_count;
	}
	public void setHost_count(int host_count) {
		this.host_count = host_count;
	}
	public int getI_list() {
		return i_list;
	}
	public void setI_list(int i_list) {
		this.i_list = i_list;
	}
	public int getI_user() {
		return i_user;
	}
	public void setI_user(int i_user) {
		this.i_user = i_user;
	}
	public String getList_title() {
		return list_title;
	}
	public void setList_title(String list_title) {
		this.list_title = list_title;
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
