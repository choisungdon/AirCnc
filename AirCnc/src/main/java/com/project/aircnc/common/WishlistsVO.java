package com.project.aircnc.common;

import java.util.List;

public class WishlistsVO {
	private int i_list;
	private int i_user;
	private String list_title;
	private int i_host;
	private int b_room; // 방수 
	private int bed_qty; // 침대 수
	private int bth_room;// 화장실 수
	private String room_title;
	// 국가 위도 경로
	private String c_lat; 
	private String c_lng;
	// 상세 주소 위도 경로 
	private String s_lat;
	private String s_lng;
	private int hum_count;// 현재 예약 가능 인원 
	private int count;// 후기 수 
	private int fee;
	private float avg;
	private int like_user; // 좋아요 상태 
	private List<RoomIMGVO> list;
	
	
	public int getLike_user() {
		return like_user;
	}
	public void setLike_user(int like_user) {
		this.like_user = like_user;
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
	public List<RoomIMGVO> getList() {
		return list;
	}
	public void setList(List<RoomIMGVO> list) {
		this.list = list;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
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
	public int getI_host() {
		return i_host;
	}
	public void setI_host(int i_host) {
		this.i_host = i_host;
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
	public String getRoom_title() {
		return room_title;
	}
	public void setRoom_title(String room_title) {
		this.room_title = room_title;
	}
	public int getHum_count() {
		return hum_count;
	}
	public void setHum_count(int hum_count) {
		this.hum_count = hum_count;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public float getAvg() {
		return avg;
	}
	public void setAvg(float avg) {
		this.avg = avg;
	}
		
}
