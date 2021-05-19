package com.project.aircnc.common;

import org.apache.ibatis.type.Alias;

@Alias("HostingPkVO")
public class HostingPkVO {
	
	private int i_host;
	private int i_user;
	private int i_build;
	private int i_fct;
	private int i_spt;
	private int i_gest;
	private int i_sinfo;
	private int i_rule;
	private int i_dtr;
	private int i_ck;
	private int i_fee;
	private int i_ph;
	
	
	public int getI_user() {
		return i_user;
	}
	public void setI_user(int i_user) {
		this.i_user = i_user;
	}
	public int getI_host() {
		return i_host;
	}
	public void setI_host(int i_host) {
		this.i_host = i_host;
	}
	public int getI_build() {
		return i_build;
	}
	public void setI_build(int i_build) {
		this.i_build = i_build;
	}
	public int getI_fct() {
		return i_fct;
	}
	public void setI_fct(int i_fct) {
		this.i_fct = i_fct;
	}
	public int getI_spt() {
		return i_spt;
	}
	public void setI_spt(int i_spt) {
		this.i_spt = i_spt;
	}
	public int getI_gest() {
		return i_gest;
	}
	public void setI_gest(int i_gest) {
		this.i_gest = i_gest;
	}
	public int getI_sinfo() {
		return i_sinfo;
	}
	public void setI_sinfo(int i_sinfo) {
		this.i_sinfo = i_sinfo;
	}
	public int getI_rule() {
		return i_rule;
	}
	public void setI_rule(int i_rule) {
		this.i_rule = i_rule;
	}
	public int getI_dtr() {
		return i_dtr;
	}
	public void setI_dtr(int i_dtr) {
		this.i_dtr = i_dtr;
	}
	public int getI_ck() {
		return i_ck;
	}
	public void setI_ck(int i_ck) {
		this.i_ck = i_ck;
	}
	public int getI_fee() {
		return i_fee;
	}
	public void setI_fee(int i_fee) {
		this.i_fee = i_fee;
	}
	public int getI_ph() {
		return i_ph;
	}
	public void setI_ph(int i_ph) {
		this.i_ph = i_ph;
	}
	@Override
	public String toString() {
		return "HostingPkVO [i_host=" + i_host + ", i_user=" + i_user + ", i_build=" + i_build + ", i_fct=" + i_fct
				+ ", i_spt=" + i_spt + ", i_gest=" + i_gest + ", i_sinfo=" + i_sinfo + ", i_rule=" + i_rule + ", i_dtr="
				+ i_dtr + ", i_ck=" + i_ck + ", i_fee=" + i_fee + ", i_ph=" + i_ph + "]";
	}
	
}
