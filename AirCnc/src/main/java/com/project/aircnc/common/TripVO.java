package com.project.aircnc.common;

import org.apache.ibatis.type.Alias;

@Alias("TripVO")
public class TripVO extends ReservationVO{
	private String room_title;
	private String addr;
	private String checkin_t;
	private String finich_t;
	private String img_url;
	private String room_poto;
	private String reser_state; // 예약 변경및 취소중 상태 값 
	private int review_state; // 리뷰 썼다 안썼다 상태 
	
	
	public String getReser_state() {
		return reser_state;
	}
	public void setReser_state(String reser_state) {
		this.reser_state = reser_state;
	}
	public int getReview_state() {
		return review_state;
	}
	public void setReview_state(int review_state) {
		this.review_state = review_state;
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
	public String getCheckin_t() {
		return checkin_t;
	}
	public void setCheckin_t(String checkin_t) {
		this.checkin_t = checkin_t;
	}
	public String getFinich_t() {
		return finich_t;
	}
	public void setFinich_t(String finich_t) {
		this.finich_t = finich_t;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	public String getRoom_poto() {
		return room_poto;
	}
	public void setRoom_poto(String room_poto) {
		this.room_poto = room_poto;
	}
	
}
