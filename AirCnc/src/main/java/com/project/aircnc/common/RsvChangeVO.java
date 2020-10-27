package com.project.aircnc.common;

import org.apache.ibatis.type.Alias;

@Alias("RsvChangeVO")
public class RsvChangeVO extends TripVO {
	private String live_type; //  '집전체 all, 개인실 single, 다인실  share',
	private int bed_qty ; // 침대 수 
	private int bth_room; // 욕실수 
	private int fee; // 1박 기본 요금 
	
	public String getLive_type() {
		return live_type;
	}
	public void setLive_type(String live_type) {
		this.live_type = live_type;
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
	
}
