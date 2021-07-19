package com.project.aircnc.common;

import org.apache.ibatis.type.Alias;
@Alias("SearchVO")
public class SearchVO  extends FaciliteVO{
	private int		i_reser; // 현재 숙박 일 . 인원 가능 여부 확인  (예약 변경 할때 쓴다.)
	private String  addr; // 주소
	private String  chin;
	private String  chout;
	private int 	qty; //명수 
	private long 	date;
	private String  fire_emble; // 화제 경보기 o/null
	private String  carbon_alarm; //일산화 탄소 경보기 o/null
	private String  madic_kit; //구급 상자 o/null
	private String  fire_exting; //소화기o/null
	private String  bad_lock; //침실 잠금장치 o/null
	private String  apt;
	private String  outbuild;
	private String  all ; //집전체 all
	private String  single; // 개인실 single
	private String  share; // 다인실  share
	private int 	fee; // 요금, 최고요금
	private int 	max_fee;
	private int		min_fee; // 최저 요금
	private int  	b_room; //'객실 수'
	private int  	bed_qty; //객실당 침대갯수
	private int  	bth_room; //욕실수
	private String  liviroom; // 거실
	private String  cooking; // 주방
	private String  waching; // 세탁기 
	private String  drying; // 건조기
	private String  paking; //주차장
	private String  gym; //헬스장
	private String  swim_pool; //수영장
	private String  jacuzzi; // 자쿠지 
	private String  child_ok; //어린이(2~12세) 숙박에 적합함 o/null
	private String  y_ch_ok; // 유아(2세 미만) 숙박에 적합함 o/null
	private String  smoking; //흡연 가능 여부  o/null
	private String  animal_ok; // 반려 동물동반에 적합함
	private String  party; //행사나 파티 허용 o/null
	
	
	public int getI_reser() {
		return i_reser;
	}
	public void setI_reser(int i_reser) {
		this.i_reser = i_reser;
	}
	public int getMax_fee() {
		return max_fee;
	}
	public void setMax_fee(int max_fee) {
		this.max_fee = max_fee;
	}
	public int getMin_fee() {
		return min_fee;
	}
	public void setMin_fee(int min_fee) {
		this.min_fee = min_fee;
	}
	public String getApt() {
		return apt;
	}
	public void setApt(String apt) {
		if(!apt.equals(""))
		this.apt = apt;
	}
	public String getOutbuild() {
		return outbuild;
	}
	public void setOutbuild(String outbuild) {
		if(!outbuild.equals(""))
		this.outbuild = outbuild;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		if(!addr.equals(""))
		this.addr = addr;
	}
	public String getChin() {
		return chin;
	}
	public void setChin(String chin) {
		if(!chin.equals(""))
		this.chin = chin;
	}
	public String getChout() {
		return chout;
	}
	public void setChout(String chout) {
		if(!chout.equals(""))
		this.chout = chout;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}
	public String getFire_emble() {
		
		return fire_emble;
	}
	public void setFire_emble(String fire_emble) {
		if(!fire_emble.equals(""))
		this.fire_emble = fire_emble;
	}
	public String getCarbon_alarm() {
		return carbon_alarm;
	}
	public void setCarbon_alarm(String carbon_alarm) {
		if(!carbon_alarm.equals(""))
		this.carbon_alarm = carbon_alarm;
	}
	public String getMadic_kit() {
		return madic_kit;
	}
	public void setMadic_kit(String madic_kit) {
		if(!madic_kit.equals(""))
		this.madic_kit = madic_kit;
	}
	public String getFire_exting() {
		return fire_exting;
	}
	public void setFire_exting(String fire_exting) {
		if(!fire_exting.equals(""))
		this.fire_exting = fire_exting;
	}
	public String getBad_lock() {
		return bad_lock;
	}
	public void setBad_lock(String bad_lock) {
		if(!bad_lock.equals(""))
		this.bad_lock = bad_lock;
	}
	
	public String getAll() {
		return all;
	}
	public void setAll(String all) {
		if(!all.equals(""))
		this.all = all;
	}
	public String getSingle() {
		return single;
	}
	public void setSingle(String single) {
		if(!single.equals(""))
		this.single = single;
	}
	public String getShare() {
		return share;
	}
	public void setShare(String share) {
		if(!share.equals(""))
		this.share = share;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	
	public int getB_room() {
		return b_room;
	}
	public void setB_room(int b_room) {
		this.b_room = b_room;
	}
	public int getBed_qty() {
		return bed_qty;
	}
	public void setBed_qty(int bed_qty) {
		this.bed_qty = bed_qty;
	}
	public int getBth_room() {
		return bth_room;
	}
	public void setBth_room(int bth_room) {
		this.bth_room = bth_room;
	}
	public String getLiviroom() {
		return liviroom;
	}
	public void setLiviroom(String liviroom) {
		if(!liviroom.equals(""))
		this.liviroom = liviroom;
	}
	public String getCooking() {
		return cooking;
	}
	public void setCooking(String cooking) {
		if(!cooking.equals(""))
		this.cooking = cooking;
	}
	public String getWaching() {
		return waching;
	}
	public void setWaching(String waching) {
		if(!waching.equals(""))
		this.waching = waching;
	}
	public String getDrying() {
		return drying;
	}
	public void setDrying(String drying) {
		if(!drying.equals(""))
		this.drying = drying;
	}
	public String getPaking() {
		return paking;
	}
	public void setPaking(String paking) {
		if(!paking.equals(""))
		this.paking = paking;
	}
	public String getGym() {
		return gym;
	}
	public void setGym(String gym) {
		if(!gym.equals(""))
		this.gym = gym;
	}
	public String getSwim_pool() {
		return swim_pool;
	}
	public void setSwim_pool(String swim_pool) {
		if(!swim_pool.equals(""))
		this.swim_pool = swim_pool;
	}
	public String getJacuzzi() {
		return jacuzzi;
	}
	public void setJacuzzi(String jacuzzi) {
		if(!jacuzzi.equals(""))
		this.jacuzzi = jacuzzi;
	}
	public String getChild_ok() {
		return child_ok;
	}
	public void setChild_ok(String child_ok) {
		if(!child_ok.equals(""))
		this.child_ok = child_ok;
	}
	public String getY_ch_ok() {
		return y_ch_ok;
	}
	public void setY_ch_ok(String y_ch_ok) {
		if(!y_ch_ok.equals(""))
		this.y_ch_ok = y_ch_ok;
	}
	public String getSmoking() {
		return smoking;
	}
	public void setSmoking(String smoking) {
		if(!smoking.equals(""))
		this.smoking = smoking;
	}
	public String getAnimal_ok() {
		return animal_ok;
	}
	public void setAnimal_ok(String animal_ok) {
		if(!animal_ok.equals(""))
		this.animal_ok = animal_ok;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		if(!party.equals(""))
		this.party = party;
	}
	

}
