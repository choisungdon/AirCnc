package com.project.aircnc.common;

import org.apache.ibatis.type.Alias;

@Alias("RsvVO")
public class RsvVO extends ReservationVO{
	private String reser_state; // 예약 정보 확인 (호스팅 유저가 완료하면 매출에 잡힘 )  o(숙박 완료)/ch(change)/cc(cancel)/NULL(예정 숙박)'
	private String img_url; // 숙소 사진 URL
	private String room_title;// 숙소 title
	private String addr; // 숙소 주소 
	private String r_dt;// 예약 날짜
	private String m_dt;
	
	
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getRoom_title() {
		return room_title;
	}
	public void setRoom_title(String room_title) {
		this.room_title = room_title;
	}
	public String getReser_state() {
		return reser_state;
	}
	public void setReser_state(String reser_state) {
		this.reser_state = reser_state;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
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
