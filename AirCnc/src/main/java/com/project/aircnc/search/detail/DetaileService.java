package com.project.aircnc.search.detail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.aircnc.common.HostReviewVO;
import com.project.aircnc.common.MyUtils;
import com.project.aircnc.common.RoomIMGVO;
import com.project.aircnc.common.SearchDetaileVO;
import com.project.aircnc.common.SearchVO;
import com.project.aircnc.common.TUserVO;


@Service
public class DetaileService {
	
	@Autowired
	private DetaileMapper mapper;
	
	public SearchDetaileVO selDetaile(SearchVO param, HttpSession hs){
		TUserVO loginUser = (TUserVO)hs.getAttribute("loginUser");
		param.setI_user(loginUser.getI_user()); 
		
		SearchDetaileVO dbVO= mapper.selDetaile(param);
		
		// host 유저 profile 경로 수정 
		String profileImg = dbVO.getPro_img();
		
		if(profileImg == null || profileImg.equals("")) {
			profileImg = "/resources/img/pimg.jpg";
		} else {
			profileImg = "/resources/user_img/user" + dbVO.getHost_i_user() + "/" + profileImg;
		}
		dbVO.setMy_profile(profileImg);
		//
		
		// room IMG 경로 수정,HostReviewVO cmt_user_poto 수정 및 추가 규칙,HostReviewVO select
		dbVO.setRoomImgList(mapper.selRoomImg(param));
		dbVO.setDtlRuleList(mapper.selDtRule(param));
		dbVO.setHostReviewList(mapper.selHostReview(param));
		dbVO.setUserLList(mapper.selLikeList(loginUser)); // 좋아용 list 출력 
		
		for (RoomIMGVO roomImgVO : dbVO.getRoomImgList()) {
			String room_poto = "/resources/room_img/host" + roomImgVO.getI_host() + "/" + roomImgVO.getImg_url();
			roomImgVO.setRoom_poto(room_poto);
		}
		
		for (HostReviewVO reViewVO : dbVO.getHostReviewList()) {
			profileImg = reViewVO.getPro_img();
			
			if(profileImg == null || profileImg.equals("")) {
				profileImg = "/resources/img/pimg.jpg";
			} else {
				profileImg = "/resources/user_img/user" + reViewVO.getI_user() + "/" + profileImg;
			}
			reViewVO.setCmt_user_poto(profileImg);
			
		}
		
		// 일수 계산 
		try {
			long date = MyUtils.changeDate(param.getChin(), param.getChout());
			param.setDate(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dbVO;
	}
	
	// 숙박 여부 확인 
	public String selExist(int i_host,String chin, String chout, int date , int qty) {
		SearchVO param = new SearchVO();
		
		param.setI_host(i_host);
		param.setChin(chin);
		param.setChout(chout);
		param.setDate(date);
		param.setQty(qty);
		
		int inout = mapper.existInOut(param); // 해당 날짜 예약 가능 여부
		int inoutDate = mapper.existInOutDate(param); // 숙박 일 가능여부
		int Rvation = mapper.existRvation(param); // 인원 가능여부 
		
		if(inout != 1) {
			return "해당 날짜에 숙박이 불가 합니다.";
		}else if(inoutDate != 1) {
			return "최소, 최대 숙박 일수를 초과 했습니다.";
		}else if(Rvation != 1) {
			return "현재 숙박 가능인원을 초과 했습니다.";
		}else {
			return "o";
		}
		
	}
	
	
	
}
