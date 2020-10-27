package com.project.aircnc.common;

public class CheckHostingVO {
	private int i_user;
	private int i_host;
	private int host_user;
	private String room_title;
	private int build_type;
	private int facilite;
	private int safe_plant;
	private int gest_space;
	private int space_info;
	private int room_rule;
	private int room_dt_rule; 
	private int check_inout;
	private int room_fee;
	private int workplace_ph;
	private int dtl_rule;
	private int rooms_img;
	
	
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
	public int getI_user() {
		return i_user;
	}
	public void setI_user(int i_user) {
		this.i_user = i_user;
	}
	public int getHost_user() {
		return host_user;
	}
	public void setHost_user(int host_user) {
		this.host_user = host_user;
	}
	public int getBuild_type() {
		return build_type;
	}
	public void setBuild_type(int build_type) {
		this.build_type = build_type;
	}
	public int getFacilite() {
		return facilite;
	}
	public void setFacilite(int facilite) {
		this.facilite = facilite;
	}
	public int getSafe_plant() {
		return safe_plant;
	}
	public void setSafe_plant(int safe_plant) {
		this.safe_plant = safe_plant;
	}
	public int getGest_space() {
		return gest_space;
	}
	public void setGest_space(int gest_space) {
		this.gest_space = gest_space;
	}
	public int getSpace_info() {
		return space_info;
	}
	public void setSpace_info(int space_info) {
		this.space_info = space_info;
	}
	public int getRoom_rule() {
		return room_rule;
	}
	public void setRoom_rule(int room_rule) {
		this.room_rule = room_rule;
	}
	public int getRoom_dt_rule() {
		return room_dt_rule;
	}
	public void setRoom_dt_rule(int room_dt_rule) {
		this.room_dt_rule = room_dt_rule;
	}
	public int getCheck_inout() {
		return check_inout;
	}
	public void setCheck_inout(int check_inout) {
		this.check_inout = check_inout;
	}
	public int getRoom_fee() {
		return room_fee;
	}
	public void setRoom_fee(int room_fee) {
		this.room_fee = room_fee;
	}
	public int getWorkplace_ph() {
		return workplace_ph;
	}
	public void setWorkplace_ph(int workplace_ph) {
		this.workplace_ph = workplace_ph;
	}
	public int getDtl_rule() {
		return dtl_rule;
	}
	public void setDtl_rule(int dtl_rule) {
		this.dtl_rule = dtl_rule;
	}
	public int getRooms_img() {
		return rooms_img;
	}
	public void setRooms_img(int rooms_img) {
		this.rooms_img = rooms_img;
	}
	
	@Override
	public String toString () {
		return "host_user : "+host_user+" room_title:"+room_title+" build_type : "
				+build_type+" facilite: "+facilite+" safe_plant: "+safe_plant+" gest_space :"+gest_space
				+" space_info : "+space_info+" room_rule : "+room_rule+" room_dt_rule : "+room_dt_rule
				+"check_inout : "+check_inout+" room_fee : "+room_fee+" workplace_ph :"+workplace_ph
				+"dtl_rule : "+dtl_rule+" rooms_img : "+rooms_img;
	}
	
}