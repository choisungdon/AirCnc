package com.project.aircnc.user.reservation;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Mapper;

import com.project.aircnc.common.AircncMsg;
import com.project.aircnc.common.AircncMsglist;
import com.project.aircnc.common.DTLRuleVO;
import com.project.aircnc.common.MsgRoomVO;
import com.project.aircnc.common.ReservationVO;
import com.project.aircnc.common.RoomIMGVO;
import com.project.aircnc.common.RsvCancelVO;
import com.project.aircnc.common.RsvChangeVO;
import com.project.aircnc.common.SearchDetaileVO;
import com.project.aircnc.common.SearchVO;
import com.project.aircnc.common.TripVO;
import com.project.aircnc.common.UserRsvCancelVO;
import com.project.aircnc.common.UserRsvChangeVO;

@Mapper
public interface ReservationMapper {
	
	public SearchDetaileVO selReservation(SearchVO param);
	public List<RoomIMGVO> selRoomImg(SearchVO param);
	public List<DTLRuleVO> selDtRule(SearchVO param);
	public int inserRSV(ReservationVO param);
	public int inserMsglist(AircncMsglist param);
	public int inserMsgUsers(AircncMsglist param);
	public int inserMsg(AircncMsg param);
	public int upRSV(ReservationVO param);
	public List<MsgRoomVO>selMsgRoom(AircncMsg param);
	public TripVO selRsv(ReservationVO param);
	public RsvCancelVO selrsvCancel(ReservationVO param);
	public int inserRsvCancel(UserRsvCancelVO param);
	public int upRsv(UserRsvCancelVO param);
	public RsvChangeVO selRsvChange(ReservationVO param);
	public int inserRsvChange(UserRsvChangeVO param);
	public int upRsvChange(UserRsvChangeVO param);
	
	/// 예약 가능 여부 확인 쿼리 실행 
	public int existInOut(SearchVO param);
	public int existInOutDate(SearchVO param);
	public int existRvation(SearchVO param);
	// 기존 예약  숙박 일 . 인원 출력 (submit 확인용)
	public RsvChangeVO checkData(RsvChangeVO param);
	
}
