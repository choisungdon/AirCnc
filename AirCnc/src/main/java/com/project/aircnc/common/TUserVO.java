package com.project.aircnc.common;

import org.apache.ibatis.type.Alias;

@Alias("TUserVO")
public class TUserVO {
	private int i_user;
	private int i_host;// 좋아용 활성화시 필요
	private String e_mail;
	private String nm;
	private String c_pw;
	private String r_pw;
	private String salt;
	private String bir_day;
	private String pro_img;
	private String my_profile;
	private String ph;
	private String r_dt;
	private String m_dt;
	private String logintype; // kakao, nomal, naver
	private String key; // 개인 정보 수정할때 (수정 keyWord)
	
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public int getI_host() {
		return i_host;
	}
	public void setI_host(int i_host) {
		this.i_host = i_host;
	}
	public String getR_pw() {
		return r_pw;
	}
	public void setR_pw(String r_pw) {
		this.r_pw = r_pw;
	}
	public String getMy_profile() {
		return my_profile;
	}
	public void setMy_profile(String my_profile) {
		this.my_profile = my_profile;
	}
	public int getI_user() {
		return i_user;
	}
	public void setI_user(int i_user) {
		this.i_user = i_user;
	}
	public String getE_mail() {
		return e_mail;
	}
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	public String getNm() {
		return nm;
	}
	public void setNm(String nm) {
		this.nm = nm;
	}
	public String getC_pw() {
		return c_pw;
	}
	public void setC_pw(String c_pw) {
		this.c_pw = c_pw;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getBir_day() {
		return bir_day;
	}
	public void setBir_day(String bir_day) {
		this.bir_day = bir_day;
	}
	public String getPro_img() {
		return pro_img;
	}
	public void setPro_img(String pro_img) {
		this.pro_img = pro_img;
	}
	public String getPh() {
		return ph;
	}
	public void setPh(String ph) {
		this.ph = ph;
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
	
	public String getLogintype() {
		return logintype;
	}
	public void setLogintype(String logintype) {
		this.logintype = logintype;
	}
	@Override
	public String toString() {
		return "i_user : "+this.i_user+"/ nm : "+nm+"/ bir_day : "+bir_day+" /ph : "+ph;
	}
	


}
