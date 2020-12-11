package com.project.aircnc.common;

import org.apache.ibatis.type.Alias;

@Alias("ProfitReviewVO")
public class ProfitReviewVO {
	
	private int i_contents; // pk
	private int i_host; // 숙소 pk
	private int i_reser; // 예약 번호 
	private int i_user; //  후기 쓴 user pk
	private String pro_img;// 후기 쓴 user 사진 
	private String nm;// 후기 쓴 user 이름
	private String contents; // 후기 글
	private String r_dt; // 작성 날짜 
	private String m_dt; // 수정 날짜 
	private String room_title; // 숙소  제목 
	private String img_url; // 숙소  이미지 
	private int evaluate_val; //  후기 점수 
	
	public String getNm() {
		return nm;
	}
	public void setNm(String nm) {
		this.nm = nm;
	}
	public int getI_contents() {
		return i_contents;
	}
	public void setI_contents(int i_contents) {
		this.i_contents = i_contents;
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
	public String getPro_img() {
		return pro_img;
	}
	public void setPro_img(String pro_img) {
		this.pro_img = pro_img;
	}
	public int getI_reser() {
		return i_reser;
	}
	public void setI_reser(int i_reser) {
		this.i_reser = i_reser;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
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
	public int getEvaluate_val() {
		return evaluate_val;
	}
	public void setEvaluate_val(int evaluate_val) {
		this.evaluate_val = evaluate_val;
	}
	
	@Override
	public String toString() {
		return "ProfitReviewVO [i_contents=" + this.i_contents + ", i_host=" + this.i_host + ", i_reser=" + this.i_reser + "]";
	}
	
	
	
}
