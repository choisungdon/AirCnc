package com.project.aircnc.common;

import org.apache.ibatis.type.Alias;

@Alias("FaciliteVO")
public class FaciliteVO {
	private int i_fct;
	private int i_host;
	private int i_user;
	private String requier; // '필수항목 o/null'
	private String aircon; // 에어컨 o/null
	private String sampoo; //샴푸 o/null
	private String hiter; // 히터 o/null
	private String in_hiter; //실내 벽난로 o/null
	private String wifi; // wifi
	private String breakfast; // 조식
	private String hanger;
	private String iron; //다리미 o/null
	private String hiar_dry; //헤어 드라이기 o/null
	private String place_lattop; // 노트북 작업 공간 o/null
	private String tv; //tv
	private String baby_bad; //유아용 침대 o/null
	private String baby_chairs; //유아용 의자 o/null
	private String self_checkin; //셀프 체크인 o/null
	private String self_bth_room; // 욕실 단독 사용 o/null
	private String piano; // 피아노
	private String door; //'게스트 전용 출입문 o/null',
	
	
	
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
	public int getI_fct() {
		return i_fct;
	}
	public void setI_fct(int i_fct) {
		this.i_fct = i_fct;
	}
	public String getRequier() {
		return requier;
	}
	public void setRequier(String requier) {
		if(!requier.equals(""))
		this.requier = requier;
	}
	public String getAircon() {
		return aircon;
	}
	public void setAircon(String aircon) {
		if(!aircon.equals(""))
		this.aircon = aircon;
	}
	public String getSampoo() {
		return sampoo;
	}
	public void setSampoo(String sampoo) {
		if(!sampoo.equals(""))
		this.sampoo = sampoo;
	}
	public String getHiter() {
		return hiter;
	}
	public void setHiter(String hiter) {
		if(!hiter.equals(""))
		this.hiter = hiter;
	}
	public String getIn_hiter() {
		return in_hiter;
	}
	public void setIn_hiter(String in_hiter) {
		if(!in_hiter.equals(""))
		this.in_hiter = in_hiter;
	}
	public String getWifi() {
		return wifi;
	}
	public void setWifi(String wifi) {
		if(!wifi.equals(""))
		this.wifi = wifi;
	}
	public String getBreakfast() {
		return breakfast;
	}
	public void setBreakfast(String breakfast) {
		if(!breakfast.equals(""))
		this.breakfast = breakfast;
	}
	public String getHanger() {
		return hanger;
	}
	public void setHanger(String hanger) {
		if(!hanger.equals(""))
		this.hanger = hanger;
	}
	public String getIron() {
		return iron;
	}
	public void setIron(String iron) {
		if(!iron.equals(""))
		this.iron = iron;
	}
	public String getHiar_dry() {
		return hiar_dry;
	}
	public void setHiar_dry(String hiar_dry) {
		if(!hiar_dry.equals(""))
		this.hiar_dry = hiar_dry;
	}
	public String getPlace_lattop() {
		return place_lattop;
	}
	public void setPlace_lattop(String place_lattop) {
		if(!place_lattop.equals(""))
		this.place_lattop = place_lattop;
	}
	public String getTv() {
		return tv;
	}
	public void setTv(String tv) {
		if(!tv.equals(""))
		this.tv = tv;
	}
	public String getBaby_bad() {
		return baby_bad;
	}
	public void setBaby_bad(String baby_bad) {
		if(!baby_bad.equals(""))
		this.baby_bad = baby_bad;
	}
	public String getBaby_chairs() {
		return baby_chairs;
	}
	public void setBaby_chairs(String baby_chairs) {
		if(!baby_chairs.equals(""))
		this.baby_chairs = baby_chairs;
	}
	public String getSelf_checkin() {
		return self_checkin;
	}
	public void setSelf_checkin(String self_checkin) {
		if(!self_checkin.equals(""))
		this.self_checkin = self_checkin;
	}
	public String getSelf_bth_room() {
		return self_bth_room;
	}
	public void setSelf_bth_room(String self_bth_room) {
		if(!self_bth_room.equals(""))
		this.self_bth_room = self_bth_room;
	}
	public String getPiano() {
		return piano;
	}
	public void setPiano(String piano) {
		if(!piano.equals(""))
		this.piano = piano;
	}
	public String getDoor() {
		return door;
	}
	public void setDoor(String door) {
		if(!door.equals(""))
		this.door = door;
	}
	
	
}


