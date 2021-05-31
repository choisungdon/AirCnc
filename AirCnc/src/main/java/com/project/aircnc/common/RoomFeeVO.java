package com.project.aircnc.common;

import org.apache.ibatis.type.Alias;

@Alias("RoomFeeVO")
public class RoomFeeVO {
	
	private int i_fee;
	private int i_host;
	private int i_user;
	private int fee;
	private String sale;
	private int w_sale;
	private int m_sale;
	private String r_dt;
	private String m_dt;
	
	
	public int getI_fee() {
		return i_fee;
	}
	public void setI_fee(int i_fee) {
		this.i_fee = i_fee;
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
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public String getSale() {
		if(this.sale == null) {
			return "x";
		}else {
			return sale;
		}
	}
	public void setSale(String sale) {
		this.sale = sale;
	}
	public int getW_sale() {
		return w_sale;
	}
	public void setW_sale(int w_sale) {
		this.w_sale = w_sale;
	}
	public int getM_sale() {
		return m_sale;
	}
	public void setM_sale(int m_sale) {
		this.m_sale = m_sale;
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
