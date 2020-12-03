package com.project.aircnc.common;

import org.apache.ibatis.type.Alias;

@Alias("HostReviewVO")
public class HostReviewVO {
	
	private int i_contents;
	private int i_host;
	private int i_user;
	private int i_reser;
	private String contents; // 후기 글
	private String r_dt;
	private String m_dt;
	private int evaluate_val;
	private String pro_img; // 댓글 단 유저 이미지 
	private String cmt_user_poto; // 이미지 경로 
	private String nm; // 댓글 단 유저 이름
	
	private int count;
	private float avg;
	
	
	public int getI_reser() {
		return i_reser;
	}
	public void setI_reser(int i_reser) {
		this.i_reser = i_reser;
	}
	public String getPro_img() {
		return pro_img;
	}
	public void setPro_img(String pro_img) {
		this.pro_img = pro_img;
	}
	public String getCmt_user_poto() {
		return cmt_user_poto;
	}
	public void setCmt_user_poto(String cmt_user_poto) {
		this.cmt_user_poto = cmt_user_poto;
	}
	public String getNm() {
		return nm;
	}
	public void setNm(String nm) {
		this.nm = nm;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public float getAvg() {
		return avg;
	}
	public void setAvg(float avg) {
		this.avg = avg;
	}
	public int getI_contents() {
		return i_contents;
	}
	public void setI_contents(int i_contents) {
		this.i_contents = i_contents;
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
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
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
	public float getEvaluate_val() {
		return evaluate_val;
	}
	public void setEvaluate_val(int evaluate_val) {
		this.evaluate_val = evaluate_val;
	}
	
	@Override
	public String toString() {
		return "HostReviewVO [i_host=" + i_host + ", i_reser=" + i_reser + ", contents=" + contents + ", evaluate_val="
				+ evaluate_val + "]";
	}
	
}
