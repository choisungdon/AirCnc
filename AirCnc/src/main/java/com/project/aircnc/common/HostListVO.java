package com.project.aircnc.common;

import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("HostListVO")
public class HostListVO {
	private int i_host; // 수고 pk
	private int i_user;
	private int like_user; // 좋아요 한 i_user
	private String addr; // 주소
	private String c_lat;// 나라 위도
	private String c_lng; // " 경도
	private String s_lat;// 주소  위도
	private String s_lng; // " 경도
	private String room_title; // 숙소제목
	private int b_room; //방수
	private int bed_qty; // 침대 수
	private int bth_room; // 샤워실 수
	private int fee; // 1사람당 1박 요금
	private int h_fee;// 사람수당 1박 요금
	private int tt_fee; // 총 요금 (fee * 사람수 * 몇박)
	private List<RoomIMGVO> list;
	
	
	
	
	public int getI_user() {
		return i_user;
	}
	public void setI_user(int i_user) {
		this.i_user = i_user;
	}
	public List<RoomIMGVO> getList() {
		return list;
	}
	public void setList(List<RoomIMGVO> list) {
		this.list = list;
	}
	public int getLike_user() {
		return like_user;
	}
	public void setLike_user(int like_user) {
		this.like_user = like_user;
	}
	public int getI_host() {
		return i_host;
	}
	public void setI_host(int i_host) {
		this.i_host = i_host;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getC_lat() {
		return c_lat;
	}
	public void setC_lat(String c_lat) {
		this.c_lat = c_lat;
	}
	public String getC_lng() {
		return c_lng;
	}
	public void setC_lng(String c_lng) {
		this.c_lng = c_lng;
	}
	public String getS_lat() {
		return s_lat;
	}
	public void setS_lat(String s_lat) {
		this.s_lat = s_lat;
	}
	public String getS_lng() {
		return s_lng;
	}
	public void setS_lng(String s_lng) {
		this.s_lng = s_lng;
	}
	public String getRoom_title() {
		return room_title;
	}
	public void setRoom_title(String room_title) {
		this.room_title = room_title;
	}
	public int getB_room() {
		return b_room;
	}
	public void setB_room(int b_room) {
		this.b_room = b_room;
	}
	public int getBed_qty() {
		return bed_qty;
	}
	public void setBed_qty(int bed_qty) {
		this.bed_qty = bed_qty;
	}
	public int getBth_room() {
		return bth_room;
	}
	public void setBth_room(int bth_room) {
		this.bth_room = bth_room;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	
	public int getH_fee() {
		return h_fee;
	}
	public void setH_fee(int h_fee) {
		this.h_fee = h_fee;
	}
	public int getTt_fee() {
		return tt_fee;
	}
	public void setTt_fee(int tt_fee) {
		this.tt_fee = tt_fee;
	}
	
	
}
