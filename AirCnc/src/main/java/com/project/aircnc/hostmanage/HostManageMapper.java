package com.project.aircnc.hostmanage;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Mapper;

import com.project.aircnc.common.HostHouseVO;
import com.project.aircnc.common.HostRsvCancelVO;
import com.project.aircnc.common.HostUserVO;
import com.project.aircnc.common.ProfitReviewVO;
import com.project.aircnc.common.ReviewAvgQtyVO;
import com.project.aircnc.common.RsvVO;
import com.project.aircnc.common.RsvViewData;
import com.project.aircnc.common.SelChangeDataVO;
import com.project.aircnc.common.TUserVO;
import com.project.aircnc.common.UserRsvCancelVO;
import com.project.aircnc.common.UserRsvChangeVO;

@Mapper
public interface HostManageMapper {
	
	public int selUserReserCc(TUserVO param);
	
	public int selUserReser(TUserVO param);
	// 숙소 관리 예약 화면 
	public List<RsvVO> selRsv(TUserVO param);// 예정된 예약 불러오기(현재 로그인 한 숙소 주인이 볼수 있는)
	// 예약 숙박 내용 확인 
	public RsvViewData selViewData(int i_reser);
	// 예약 완료 데이터 가져오기
	public List<RsvVO> selCompleteData(TUserVO param);
	// 취소된 예약 정보 데이터 가져오기 비동기
	public List<HostRsvCancelVO> selCancelData(TUserVO param);
	// 예약 변경 및 취소 요청 데이터가져오기 비동기 
	public List<RsvVO> selrsvCcData(TUserVO param);
	// 예약 모두 보기 데이터 가져오기 비동기 
	public List<RsvVO> selAllViewData(TUserVO param);
	// 숙소 예약 변경 내용 확인 
	public SelChangeDataVO selChangeData(UserRsvChangeVO param);
	// 숙소 예약 취소 사유  확인 
	public UserRsvCancelVO selCcelReason(UserRsvCancelVO param);
	// 숙소 변경 승인 비동기
	public int upRsvChange(UserRsvChangeVO param);
	// 현재 숙소가 예약 가능 한지 확인 
	public int existGestQty(UserRsvChangeVO param);
	
	
	// 숙소 취소 승인 비동기 삭제  (예약 테이블 빼고)
	public int RsvCancel(UserRsvCancelVO param);
	// 숙소 취소 승인 비동기 update 
	public int upRsvCancel(UserRsvCancelVO param);
	// 숙소 예약 테이블 삭제 (최종 예약 테이블 삭제)
	public int delRsvCancel(UserRsvCancelVO param);
	
	// 유저 가 등록한 숙소 데이터 들고 오기 
	public List<HostHouseVO> selHostHouse(HostHouseVO param);
	//숙소 삭제 실행  비동기 
	public int delHostHouse(HostHouseVO param);
	//숙소 삭제 실행  비동기 (마지막)hostUser 테이블 지우기 
	public int delHostUser(HostHouseVO param);
	
	// 실적 > 후기 (host_title 출력)
	public List<HostUserVO> selHost(ReviewAvgQtyVO param);
	// 실적 > 후기 (후기 평균 점수 및 개수 출력)
	public ReviewAvgQtyVO selReviewAvg(ReviewAvgQtyVO param);
	// 실적 > 후기 (실제 후기 데이터 출력)
	public List<ProfitReviewVO> selReview(ReviewAvgQtyVO param);
	
}
