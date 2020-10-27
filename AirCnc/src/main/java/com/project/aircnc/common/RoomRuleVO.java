package com.project.aircnc.common;

import org.apache.ibatis.type.Alias;

@Alias("RoomRuleVO")
public class RoomRuleVO {
	private int i_rule; // pk
	private int i_host;
	private int i_user;
	private String child_ok; //어린이(2~12세) 숙박에 적합함 o/null
	private String y_ch_ok; // 유아(2세 미만) 숙박에 적합함 o/null
	private String smoking; //흡연 가능 여부  o/null
	private String animal_ok; // 반려 동물동반에 적합함
	private String party; //행사나 파티 허용 o/null
	
	
	
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
	public int getI_rule() {
		return i_rule;
	}
	public void setI_rule(int i_rule) {
		this.i_rule = i_rule;
	}
	public String getChild_ok() {
		return child_ok;
	}
	public void setChild_ok(String child_ok) {
		this.child_ok = child_ok;
	}
	public String getY_ch_ok() {
		return y_ch_ok;
	}
	public void setY_ch_ok(String y_ch_ok) {
		this.y_ch_ok = y_ch_ok;
	}
	public String getSmoking() {
		return smoking;
	}
	public void setSmoking(String smoking) {
		this.smoking = smoking;
	}
	public String getAnimal_ok() {
		return animal_ok;
	}
	public void setAnimal_ok(String animal_ok) {
		this.animal_ok = animal_ok;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	
}
