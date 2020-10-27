package com.project.aircnc.common;

import org.apache.ibatis.type.Alias;

@Alias("SafePlantVO")
public class SafePlantVO {
	private int i_spt; // pk 
	private int i_host;
	private int i_user;
	private String fire_emble; // 화재 경보기 o/null
	private String carbon_alarm; //일산화 탄소 경보기 o/null
	private String madic_kit; //구급 상자 o/null
	private String fire_exting; //소화기o/null
	private String bad_lock; //침실 잠금장치 o/null
	
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
	public int getI_spt() {
		return i_spt;
	}
	public void setI_spt(int i_spt) {
		this.i_spt = i_spt;
	}
	public String getFire_emble() {
		return fire_emble;
	}
	public void setFire_emble(String fire_emble) {
		this.fire_emble = fire_emble;
	}
	public String getCarbon_alarm() {
		return carbon_alarm;
	}
	public void setCarbon_alarm(String carbon_alarm) {
		this.carbon_alarm = carbon_alarm;
	}
	public String getMadic_kit() {
		return madic_kit;
	}
	public void setMadic_kit(String madic_kit) {
		this.madic_kit = madic_kit;
	}
	public String getFire_exting() {
		return fire_exting;
	}
	public void setFire_exting(String fire_exting) {
		this.fire_exting = fire_exting;
	}
	public String getBad_lock() {
		return bad_lock;
	}
	public void setBad_lock(String bad_lock) {
		this.bad_lock = bad_lock;
	}
	
	
}

