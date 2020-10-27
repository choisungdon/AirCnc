package com.project.aircnc.common;

import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("SearchDetaileVO")
public class SearchDetaileVO extends FaciliteVO{
	
	// TuserVo
	private String e_mail;
	private int  host_i_user ;
	private String nm;
	private String pro_img;
	private String my_profile;
	private String ph;
	private String r_dt; // hostUser 회원가입 날짜
	// hostUser
	private int like_user; // 좋아요 상태 값
	private String country;
	private String c_lat;
	private String c_lng;
	private String addr;
	private String s_lat;
	private String s_lng;
	private int b_room;
	private int bed_qty;
	private String bed_type;
	private String bth_room;
	private String room_title; // 제목
	private int r_vastion; // 최대 인원 
	private int rsv_qty; // 현재 예약 가능인원
	// buildeType
	private String typ;
	private String live_type;
	// room img
	private List<RoomIMGVO> roomImgList ;// 이미지 경로 데이터 
	// SafePlantVO
	private String fire_emble; // 화제 경보기 o/null
	private String carbon_alarm; //일산화 탄소 경보기 o/null
	private String madic_kit; //구급 상자 o/null
	private String fire_exting; //소화기o/null
	private String bad_lock; //침실 잠금장치 o/null
	// GestSpaceVO
	private String liviroom;
	private String cooking;
	private String waching;
	private String drying;
	private String paking;
	private String gym;
	private String swim_pool;
	private String jacuzzi;
	// SpaceInfoVO
	private String expa; //  설명란
	private String room_info; //숙소 정보
	private String loca_info; //숙소 위치 정보
	private String traf_info; //교통편 정보
	// RoomRuleVO
	private String child_ok; //어린이(2~12세) 숙박에 적합함 o/null
	private String y_ch_ok; // 유아(2세 미만) 숙박에 적합함 o/null
	private String smoking; //흡연 가능 여부  o/null
	private String animal_ok; // 반려 동물동반에 적합함
	private String party; //행사나 파티 허용 o/null
	//DTL_RULE
	private List<DTLRuleVO> dtlRuleList;
	//Room_Dt_RuleVO
	private String stairs; //계단을 올라가야 함
	private String noise; // 소음이 발생할 수 있음
	private String animal; //숙소에 반려동물 있음
	private String in_pking; //건물 내 주차 불가
	private String public_space; //일부 공용 공간 있음
	private String plant; //편의시설 제한
	private String cctv; //숙소에 감시 또는 녹화 장치 설치
	private String weapon; //숙소에 무기 있음
	private String denger_dog; // 숙소에 위험한 동물 있음
	// CheckInOutVO
	private String checkin_t; //체크인 (시작)시간
	private String finich_t; //체크인  (마감) 시간
	private int ieast_day; //최소 숙박기간
	private int max_day; //최대 숙박 기간
	private String reser_date; //예약 가능 날짜
	private String reser_end_t; //예약 마감 날짜
	//RoomFeeVO
	private int fee;
	private String sale;
	private int w_sale;
	private int m_sale;
	// HostReviewVO
	private int cmtCount; // 후기 갯수
	private float comtAvg; // 후기 평점 평균 소수점 2자리
	private List<HostReviewVO> hostReviewList;
	// likeList
	private List<UserLListVO> userLList;
	
	public List<UserLListVO> getUserLList() {
		return userLList;
	}
	public void setUserLList(List<UserLListVO> userLList) {
		this.userLList = userLList;
	}
	public int getR_vastion() {
		return r_vastion;
	}
	public void setR_vastion(int r_vastion) {
		this.r_vastion = r_vastion;
	}
	
	public int getRsv_qty() {
		return rsv_qty;
	}
	public void setRsv_qty(int rsv_qty) {
		this.rsv_qty = rsv_qty;
	}
	public int getCmtCount() {
		return cmtCount;
	}
	public void setCmtCount(int cmtCount) {
		this.cmtCount = cmtCount;
	}
	public float getComtAvg() {
		return comtAvg;
	}
	public void setComtAvg(float comtAvg) {
		this.comtAvg = comtAvg;
	}
	
	public List<HostReviewVO> getHostReviewList() {
		return hostReviewList;
	}
	public void setHostReviewList(List<HostReviewVO> hostReviewList) {
		this.hostReviewList = hostReviewList;
	}
	public int getHost_i_user() {
		return host_i_user;
	}
	public void setHost_i_user(int host_i_user) {
		this.host_i_user = host_i_user;
	}
	public int getLike_user() {
		return like_user;
	}
	public void setLike_user(int like_user) {
		this.like_user = like_user;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getC_lat() {
		return c_lat;
	}
	public void setC_lat(String c_lat) {
		this.c_lat = c_lat;
	}
	public String getC_lng() {
		return c_lng;
	}
	public void setC_lng(String c_lng) {
		this.c_lng = c_lng;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getS_lat() {
		return s_lat;
	}
	public void setS_lat(String s_lat) {
		this.s_lat = s_lat;
	}
	public String getS_lng() {
		return s_lng;
	}
	public void setS_lng(String s_lng) {
		this.s_lng = s_lng;
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
	public String getBed_type() {
		return bed_type;
	}
	public void setBed_type(String bed_type) {
		this.bed_type = bed_type;
	}
	public String getBth_room() {
		return bth_room;
	}
	public void setBth_room(String bth_room) {
		this.bth_room = bth_room;
	}
	public String getRoom_title() {
		return room_title;
	}
	public void setRoom_title(String room_title) {
		this.room_title = room_title;
	}
	public String getTyp() {
		return typ;
	}
	public void setTyp(String typ) {
		this.typ = typ;
	}
	public String getLive_type() {
		return live_type;
	}
	public void setLive_type(String live_type) {
		this.live_type = live_type;
	}
	public List<RoomIMGVO> getRoomImgList() {
		return roomImgList;
	}
	public void setRoomImgList(List<RoomIMGVO> roomImgList) {
		this.roomImgList = roomImgList;
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
	public String getExpa() {
		return expa;
	}
	public void setExpa(String expa) {
		this.expa = expa;
	}
	public String getRoom_info() {
		return room_info;
	}
	public void setRoom_info(String room_info) {
		this.room_info = room_info;
	}
	public String getLoca_info() {
		return loca_info;
	}
	public void setLoca_info(String loca_info) {
		this.loca_info = loca_info;
	}
	public String getTraf_info() {
		return traf_info;
	}
	public void setTraf_info(String traf_info) {
		this.traf_info = traf_info;
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
	
	public List<DTLRuleVO> getDtlRuleList() {
		return dtlRuleList;
	}
	public void setDtlRuleList(List<DTLRuleVO> dtlRuleList) {
		this.dtlRuleList = dtlRuleList;
	}
	public String getStairs() {
		return stairs;
	}
	public void setStairs(String stairs) {
		this.stairs = stairs;
	}
	public String getNoise() {
		return noise;
	}
	public void setNoise(String noise) {
		this.noise = noise;
	}
	public String getAnimal() {
		return animal;
	}
	public void setAnimal(String animal) {
		this.animal = animal;
	}
	public String getIn_pking() {
		return in_pking;
	}
	public void setIn_pking(String in_pking) {
		this.in_pking = in_pking;
	}
	public String getPublic_space() {
		return public_space;
	}
	public void setPublic_space(String public_space) {
		this.public_space = public_space;
	}
	public String getPlant() {
		return plant;
	}
	public void setPlant(String plant) {
		this.plant = plant;
	}
	public String getCctv() {
		return cctv;
	}
	public void setCctv(String cctv) {
		this.cctv = cctv;
	}
	public String getWeapon() {
		return weapon;
	}
	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}
	public String getDenger_dog() {
		return denger_dog;
	}
	public void setDenger_dog(String denger_dog) {
		this.denger_dog = denger_dog;
	}
	public String getCheckin_t() {
		return checkin_t;
	}
	public void setCheckin_t(String checkin_t) {
		this.checkin_t = checkin_t;
	}
	public String getFinich_t() {
		return finich_t;
	}
	public void setFinich_t(String finich_t) {
		this.finich_t = finich_t;
	}
	public int getIeast_day() {
		return ieast_day;
	}
	public void setIeast_day(int ieast_day) {
		this.ieast_day = ieast_day;
	}
	public int getMax_day() {
		return max_day;
	}
	public void setMax_day(int max_day) {
		this.max_day = max_day;
	}
	public String getReser_date() {
		return reser_date;
	}
	public void setReser_date(String reser_date) {
		this.reser_date = reser_date;
	}
	public String getReser_end_t() {
		return reser_end_t;
	}
	public void setReser_end_t(String reser_end_t) {
		this.reser_end_t = reser_end_t;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public String getSale() {
		return sale;
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
	public String getPro_img() {
		return pro_img;
	}
	public void setPro_img(String pro_img) {
		this.pro_img = pro_img;
	}
	public String getMy_profile() {
		return my_profile;
	}
	public void setMy_profile(String my_profile) {
		this.my_profile = my_profile;
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
	
	
}
