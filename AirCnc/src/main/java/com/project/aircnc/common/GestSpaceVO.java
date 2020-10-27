package com.project.aircnc.common;

import org.apache.ibatis.type.Alias;

@Alias("GestSpaceVO")
public class GestSpaceVO {
	private int i_gest;
	private int i_host;
	private int i_user;
	private String liviroom;
	private String cooking;
	private String waching;
	private String drying;
	private String paking;
	private String gym;
	private String swim_pool;
	private String jacuzzi;
	
	
	
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
	public int getI_gest() {
		return i_gest;
	}
	public void setI_gest(int i_gest) {
		this.i_gest = i_gest;
	}
	public String getLiviroom() {
		return liviroom;
	}
	public void setLiviroom(String liviroom) {
		this.liviroom = liviroom;
	}
	public String getCooking() {
		return cooking;
	}
	public void setCooking(String cooking) {
		this.cooking = cooking;
	}
	public String getWaching() {
		return waching;
	}
	public void setWaching(String waching) {
		this.waching = waching;
	}
	public String getDrying() {
		return drying;
	}
	public void setDrying(String drying) {
		this.drying = drying;
	}
	public String getPaking() {
		return paking;
	}
	public void setPaking(String paking) {
		this.paking = paking;
	}
	public String getGym() {
		return gym;
	}
	public void setGym(String gym) {
		this.gym = gym;
	}
	public String getSwim_pool() {
		return swim_pool;
	}
	public void setSwim_pool(String swim_pool) {
		this.swim_pool = swim_pool;
	}
	public String getJacuzzi() {
		return jacuzzi;
	}
	public void setJacuzzi(String jacuzzi) {
		this.jacuzzi = jacuzzi;
	}
	
	
}

