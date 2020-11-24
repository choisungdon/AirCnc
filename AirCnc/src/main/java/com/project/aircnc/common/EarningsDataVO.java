package com.project.aircnc.common;

import org.apache.ibatis.type.Alias;

@Alias("EarningsDataVO")
public class EarningsDataVO {
	private int i_reser; // 예약 번호
	private int i_user; // 유저 pk
	private int i_host; // 숙소 pk
	private String room_title; // 숙소 이름
	private String img_url; // 숙소 이미지 
	private String check_in; // 체크인 날짜
	private String check_out; // 체크 아웃
	private String nm; // 예약 유저이름
	private String pro_img; // 유저 사진 
	private int gest_qty; // 숙박인원
	private int total_fee; // 요금
	private String reser_state; // 상태값 'o' : 지금 완료  null : 지급예정
	private int fee; // 해당 숙소 상태값,월별 총합 요금
	
	public int getI_reser() {
		return i_reser;
	}
	public void setI_reser(int i_reser) {
		this.i_reser = i_reser;
	}
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
	public String getCheck_in() {
		return check_in;
	}
	public void setCheck_in(String check_in) {
		this.check_in = check_in;
	}
	public String getCheck_out() {
		return check_out;
	}
	public void setCheck_out(String check_out) {
		this.check_out = check_out;
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
	public int getGest_qty() {
		return gest_qty;
	}
	public void setGest_qty(int gest_qty) {
		this.gest_qty = gest_qty;
	}
	public int getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(int total_fee) {
		this.total_fee = total_fee;
	}
	public String getReser_state() {
		return reser_state;
	}
	public void setReser_state(String reser_state) {
		this.reser_state = reser_state;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	
}
