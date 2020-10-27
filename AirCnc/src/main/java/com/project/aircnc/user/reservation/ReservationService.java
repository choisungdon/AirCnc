package com.project.aircnc.user.reservation;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.aircnc.common.AircncMsg;
import com.project.aircnc.common.AircncMsglist;
import com.project.aircnc.common.MsgRoomVO;
import com.project.aircnc.common.MyUtils;
import com.project.aircnc.common.ReservationVO;
import com.project.aircnc.common.RoomIMGVO;
import com.project.aircnc.common.RsvCancelVO;
import com.project.aircnc.common.RsvChangeVO;
import com.project.aircnc.common.SearchDetaileVO;
import com.project.aircnc.common.SearchVO;
import com.project.aircnc.common.TUserVO;
import com.project.aircnc.common.TripVO;
import com.project.aircnc.common.UserRsvCancelVO;
import com.project.aircnc.common.UserRsvChangeVO;

@Service
public class ReservationService {
	
	@Autowired
	ReservationMapper mapper;
	// 예약 화면 
	public SearchDetaileVO selReservation(SearchVO param) {
		SearchDetaileVO dbVO= mapper.selReservation(param);
		// host 유저 profile 경로 수정 
		String profileImg = dbVO.getPro_img();
		
		if(profileImg == null || profileImg.equals("")) {
			profileImg = "/resources/img/pimg.jpg";
		} else {
			profileImg = "/resources/user_img/user" + dbVO.getHost_i_user() + "/" + profileImg;
		}
		dbVO.setMy_profile(profileImg);
		// 숙소 이미지 ,추가 규칙 추가 
		dbVO.setRoomImgList(mapper.selRoomImg(param));
		dbVO.setDtlRuleList(mapper.selDtRule(param));
		
		for(RoomIMGVO imgVO : dbVO.getRoomImgList()) {
			String room_poto = "/resources/room_img/host" + imgVO.getI_host() + "/" + imgVO.getImg_url();
			imgVO.setRoom_poto(room_poto);
		}
		
		return dbVO;
	}
	
	// 예약 (메시지 방 생성및 메시지 추가 )
	public List<MsgRoomVO> inserRSV(ReservationVO param,HttpSession hs){
		// loginUser 정보 
		TUserVO loginUser = (TUserVO)hs.getAttribute("loginUser");
		param.setI_user(loginUser.getI_user());
		
		param.setCmt(MyUtils.getSTRFilter(param.getCmt()));// text 변환 
		
		int result = 0;
		result = mapper.inserRSV(param);
		
		// 해당 숙소 인원 상태 변경(명수) 
		result = mapper.upRSV(param);
		
		
		// 메시지 방 생성 
		 // 숙소 주인과 함께 톡방 만들기 
		AircncMsglist msListVO = new AircncMsglist();
		msListVO.setI_reser(param.getI_reser()); // 예약 번호 pk
		msListVO.setI_host(param.getI_host()); // 예약 숙소 pk
		msListVO.setMs_title(param.getMs_title());// 톡방 제목 
		
		//System.out.println("i_user : "+msListVO.getI_user());
		result = mapper.inserMsglist(msListVO); // insert  
		
		//System.out.println("i_milst : "+msListVO.getI_mlist());
		
		// 톡방에 들어갈 사람들 정보 
		msListVO.setI_user(loginUser.getI_user()); // 현재 로그인 i_user
		result = mapper.inserMsgUsers(msListVO);
		msListVO.setI_user(param.getOp_i_user()); // 방주인 i_user 메시지 보낼 사람 
		result = mapper.inserMsgUsers(msListVO);
		
		AircncMsg msgVO = new AircncMsg(); // 톡방 메시지 insert 
		msgVO.setI_mlist(msListVO.getI_mlist());
		msgVO.setI_reser(msListVO.getI_reser());
		msgVO.setI_host(msListVO.getI_host());
		msgVO.setCmt(param.getCmt());
		msgVO.setI_user(loginUser.getI_user());
		result = mapper.inserMsg(msgVO); // insert 
		
		List<MsgRoomVO> list = mapper.selMsgRoom(msgVO);
		// 룸 이미지 경로 수정 
		for (MsgRoomVO dbVO : list) {
			String room_poto = "/resources/room_img/host" + dbVO.getI_host() + "/" + dbVO.getImg_url();
			dbVO.setRoom_poto(room_poto);
			
		}
		
		return list;
	}
	// 예약 취소 변경 메인 화면 
	public TripVO selRsv(ReservationVO param, HttpSession hs) {
		TUserVO loginUser = (TUserVO)hs.getAttribute("loginUser");
		param.setI_user(loginUser.getI_user());
		TripVO dbVO = mapper.selRsv(param);
		// 일수 계산 
		long date = 0;
		try {
			date = MyUtils.changeDate(dbVO.getChin(),dbVO.getChout());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbVO.setDate(date);
		
		return dbVO;
	}
	
	// 예약 취소 화면 
	public RsvCancelVO selrsvCancel(ReservationVO param,HttpSession hs) {
		TUserVO loginUser = (TUserVO) hs.getAttribute("loginUser");
		param.setI_user(loginUser.getI_user());
		
		RsvCancelVO dbVO = mapper.selrsvCancel(param);
		// 일수 계산 
		long date = 0;
		try {
			date = MyUtils.changeDate(dbVO.getChin(),dbVO.getChout());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbVO.setDate(date);
		// 사진 경로 수정 
		String room_poto = "/resources/room_img/host" + dbVO.getI_host() + "/" + dbVO.getImg_url();
		dbVO.setRoom_poto(room_poto);
		
		return dbVO;
	}
	
	// 예약 취소 실행 
	public int upInserRsv(UserRsvCancelVO param) {
		int result = 0;
		result =mapper.inserRsvCancel(param); // 취소 요청 데이터 삽입 
		
		return mapper.upRsv(param); // 예약 정보 상태값 변경 
	}
	
	// 예약 변경 화면 
	public RsvChangeVO selRsvChange(ReservationVO param, HttpSession hs) {
		TUserVO loginUser = (TUserVO)hs.getAttribute("loginUser");
		param.setI_user(loginUser.getI_user());
//		System.out.println("i_user : "+loginUser.getI_user());
		RsvChangeVO dbVO = mapper.selRsvChange(param);
		// 일수 게산 
		long date = 0;
		try {
			date = MyUtils.changeDate(dbVO.getChin(),dbVO.getChout());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbVO.setDate(date);
		// 사진 경로 수정 
		String room_poto = "/resources/room_img/host" + dbVO.getI_host() + "/" + dbVO.getImg_url();
		dbVO.setRoom_poto(room_poto);
		
		return dbVO;
	}
	
	public int upInserRsvChange(UserRsvChangeVO param, HttpSession hs) {
		TUserVO loginUser = (TUserVO)hs.getAttribute("loginUser");
		param.setI_user(loginUser.getI_user());
		int result = mapper.inserRsvChange(param); // 변경 요청 데이터 삽입 
		
		return mapper.upRsvChange(param); // 예약 정보 상태값 변경 
	}
	
	// 숙박 여부 확인 
	public String selExist(int i_host, int i_reser, String chin, String chout, int date , int qty) {
		SearchVO param = new SearchVO();
		
		param.setI_host(i_host);
		param.setI_reser(i_reser);
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
