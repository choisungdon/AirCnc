package com.project.aircnc.common;

import org.apache.ibatis.type.Alias;

@Alias("ReservationVO")
public class ReservationVO {
	private int 	i_reser; // 예약 번호 
	private int		i_host;
	private int 	i_user;
	private int		op_i_user;
	private String  chin;
	private String  chout;
	private int 	qty; //명수 
	private int		total_fee;// 총 요금 ㄴ
	private long 	date;
	private String  ms_title; // 톡방 이름
	private String  cmt; // 메시지 내용
	// 고객 카드 정보 
	private String	card_user_nm;
	private String	card_num;
	private String	ym;
	private String	cvv;
	private String	country;
	private int 	zip_code;
	
	
	
	public int getOp_i_user() {
		return op_i_user;
	}
	public void setOp_i_user(int op_i_user) {
		this.op_i_user = op_i_user;
	}
	public int getI_reser() {
		return i_reser;
	}
	public void setI_reser(int i_reser) {
		this.i_reser = i_reser;
	}
	public String getMs_title() {
		return ms_title;
	}
	public void setMs_title(String ms_title) {
		this.ms_title = ms_title;
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
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(int total_fee) {
		this.total_fee = total_fee;
	}
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}
	public String getCard_user_nm() {
		return card_user_nm;
	}
	public void setCard_user_nm(String card_user_nm) {
		this.card_user_nm = card_user_nm;
	}
	public String getCard_num() {
		return card_num;
	}
	public void setCard_num(String card_num) {
		this.card_num = card_num;
	}
	public String getYm() {
		return ym;
	}
	public void setYm(String ym) {
		this.ym = ym;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getZip_code() {
		return zip_code;
	}
	public void setZip_code(int zip_code) {
		this.zip_code = zip_code;
	}
	
	public String getCmt() {
		return cmt;
	}
	public void setCmt(String cmt) {
		this.cmt = cmt;
	}
	
	public String toString(){
		return "i_host : "+this.getI_host()+" chin : "+this.getChin()+" chout :"+this.getChout()+
				" qty : "+this.getQty()+" total_fee : "+this.getTotal_fee()+" date : "+this.getDate()+
				" card_user_nm : "+this.getCard_user_nm()+" card_num : "+this.getCard_num()+" ym : "+this.getYm()+
				" cvv : "+this.getCvv()+" country : "+this.getCountry()+" zip_code : "+this.getZip_code()
				+" cmt : "+this.getCmt();
	}
	
}
