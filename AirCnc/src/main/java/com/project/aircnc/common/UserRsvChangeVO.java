package com.project.aircnc.common;

import org.apache.ibatis.type.Alias;

@Alias("UserRsvChangeVO")
public class UserRsvChangeVO {
	private int i_change ;
	private int i_host;
	private int i_user;
	private int i_reser;
	private String chin;
	private String chout;
	private int gest_qty;
	private int total_fee;
	private String be_chin;
	private String be_chout;
	private int be_gest_qty;
	private int be_total_fee;
	private String state;
	private String r_dt;
	private String m_dt;
	private int returnVal;//프로시져  실행 리턴 값
	
	public int getReturnVal() {
		return returnVal;
	}
	public void setReturnVal(int returnVal) {
		this.returnVal = returnVal;
	}
	public int getI_change() {
		return i_change;
	}
	public void setI_change(int i_change) {
		this.i_change = i_change;
	}
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
	public int getI_reser() {
		return i_reser;
	}
	public void setI_reser(int i_reser) {
		this.i_reser = i_reser;
	}
	public String getChin() {
		return chin;
	}
	public void setChin(String chin) {
		this.chin = chin;
	}
	public String getChout() {
		return chout;
	}
	public void setChout(String chout) {
		this.chout = chout;
	}
	public int getGest_qty() {
		return gest_qty;
	}
	public void setGest_qty(int gest_qty) {
		this.gest_qty = gest_qty;
	}
	public int getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(int total_fee) {
		this.total_fee = total_fee;
	}
	public String getBe_chin() {
		return be_chin;
	}
	public void setBe_chin(String be_chin) {
		this.be_chin = be_chin;
	}
	public String getBe_chout() {
		return be_chout;
	}
	public void setBe_chout(String be_chout) {
		this.be_chout = be_chout;
	}
	public int getBe_gest_qty() {
		return be_gest_qty;
	}
	public void setBe_gest_qty(int be_gest_qty) {
		this.be_gest_qty = be_gest_qty;
	}
	public int getBe_total_fee() {
		return be_total_fee;
	}
	public void setBe_total_fee(int be_total_fee) {
		this.be_total_fee = be_total_fee;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
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
