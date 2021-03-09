package com.project.aircnc.hostmanage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.aircnc.common.EarnChartVO;
import com.project.aircnc.common.EarningsDataVO;
import com.project.aircnc.common.EarningsSeachVO;
import com.project.aircnc.common.HostHouseVO;
import com.project.aircnc.common.HostRsvCancelVO;
import com.project.aircnc.common.HostUserVO;
import com.project.aircnc.common.MyUtils;
import com.project.aircnc.common.ProfitReviewVO;
import com.project.aircnc.common.ReviewAvgQtyVO;
import com.project.aircnc.common.RsvVO;
import com.project.aircnc.common.RsvViewData;
import com.project.aircnc.common.SelChangeDataVO;
import com.project.aircnc.common.TUserVO;
import com.project.aircnc.common.UserRsvCancelVO;
import com.project.aircnc.common.UserRsvChangeVO;

@Service
public class HostManageService {
	
	@Autowired 
	HostManageMapper mapper;
	//예약 변경 및 취소 요청 data 가져오기
	public int selUserReserCc(HttpSession hs) {
		TUserVO loginUser = (TUserVO) hs.getAttribute("loginUser");
		return mapper.selUserReserCc(loginUser);
	}
	// 예약 요청 data 가져요기  status가 null 인 요청
	public int selUserReser(HttpSession hs) {
		TUserVO loginUser = (TUserVO) hs.getAttribute("loginUser");
		return mapper.selUserReser(loginUser);
	}
	
	// 숙소 관리 예약 화면 및 비동기 테이터 받아올때도 같이 씀
	public List<RsvVO> selRsv(TUserVO param , HttpSession hs) {
		// parameter에 유저 정보가  없으면  유저 pk 삽입 시켜줍니다. 
		if(param.getI_user() < 0) param.setI_user(MyUtils.getSesstion(hs));
		
		List<RsvVO> list = mapper.selRsv(param);
		// 숙소 이미지 경로 변경 
		for(RsvVO dbVO : list) {
			dbVO.setImg_url(imgUrlChange(dbVO.getImg_url(), dbVO.getI_host()));
		}
		return list;// 예정된 예약 불러오기(현재 로그인 한 숙소 주인이 볼수 있는)  
	}
	
	// 예약 숙박 내용 확인 
	public RsvViewData selViewData(int i_reser) {
		RsvViewData dbVO = mapper.selViewData(i_reser);
		// 숙소  이미지 경로 변경 
		dbVO.setImg_url(imgUrlChange(dbVO.getImg_url(), dbVO.getI_host()));
		// 유저   이미지 경로 변경 
		dbVO.setPro_img(proImgChange(dbVO.getPro_img(), dbVO.getI_user()));
		// 일수 계산 
		long date = 0;
		try {
			date = MyUtils.changeDate(dbVO.getChin(),dbVO.getChout());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		dbVO.setDate(date);
		
		return dbVO;
	}
	
	// 예약 완료 데이터 가져오기
	public List<RsvVO> selCompleteData(TUserVO param){
		List<RsvVO> list = mapper.selCompleteData(param); // 예약 완료 데이터 가져오기 
		// 숙소 이미지 경로 변경 
		for(RsvVO dbVO : list) {
			dbVO.setImg_url(imgUrlChange(dbVO.getImg_url(), dbVO.getI_host()));
		}
		return list;
	}
	
	// 취소된 예약 정보 데이터 가져오기 비동기 
	public List<HostRsvCancelVO> selCancelData(TUserVO param){
		List<HostRsvCancelVO> list = mapper.selCancelData(param); // 예약 완료 데이터 가져오기 
		// 숙소 이미지 경로 변경 
		for(HostRsvCancelVO dbVO : list) {
			dbVO.setImg_url(imgUrlChange(dbVO.getImg_url(), dbVO.getI_host()));
			dbVO.setPro_img(proImgChange(dbVO.getPro_img(), dbVO.getI_user()));
		}
		return list;
	}
	// 예약 변경 및 취소 요청 데이터가져오기 비동기 
	public List<RsvVO> selrsvCcData(TUserVO param) {
		
		List<RsvVO> list = mapper.selrsvCcData(param); // 예약 완료 데이터 가져오기 
		// 숙소 이미지 경로 변경 
		for(RsvVO dbVO : list) {
			dbVO.setImg_url(imgUrlChange(dbVO.getImg_url(), dbVO.getI_host()));
		}
		return list;
	}
	// 예약 모두 보기 데이터 가져오기 비동기 
	public List<RsvVO> selAllViewData(TUserVO param){
		List<RsvVO> list = mapper.selAllViewData(param); // 예약 완료 데이터 가져오기 
		// 숙소 이미지 경로 변경 
		for(RsvVO dbVO : list) {
			dbVO.setImg_url(imgUrlChange(dbVO.getImg_url(), dbVO.getI_host()));
		}
		return list;
	}
	
	// 숙소 예약 변경 내용 확인 
	public SelChangeDataVO selChangeData(UserRsvChangeVO param){
		SelChangeDataVO dbVO = mapper.selChangeData(param); // 예약 완료 데이터 가져오기 
		
		// 숙소 예약자  이미지 경로 변경 
		dbVO.setImg_url(imgUrlChange(dbVO.getImg_url(), dbVO.getI_host()));
		dbVO.setPro_img(proImgChange(dbVO.getPro_img(), dbVO.getI_user()));
		
		return dbVO;
	}
	// 숙소 예약 취소 사유  확인 
	public UserRsvCancelVO selCcelReason(UserRsvCancelVO param){
		return mapper.selCcelReason(param);
	}
	
	// 숙소 변경 승인 비동기
	public int upRsvChange(UserRsvChangeVO param, HttpSession hs) {
		int result = 0;
		// 변경 날짜 확인 이미 지난 날짜면 예약 취소 
		result = checkOutComfirm(param);
		
		if(result == 0) {
			result = mapper.rsvChOverDate(param); // 프로시져 호출  
			//System.out.println("result : "+result);
			if(result >0) return -2; // 변경 날짜 지남 
			else return result; // db 오류 
		}else {
			result = mapper.existGestQty(param); // 예약 가능 명수 확인  (1 : 예약 가능 , 0 : 예약 불가능)
			if(result > 0) {
				result = mapper.upRsvChange(param); // 예약 변경 실행 
				if(result > 0) { // 1이상 이면  update 성공  i_user 보냅니다. 
					return MyUtils.getSesstion(hs); 
				}else return result; // 0 이면 실패 - > return 0 보냅니다. 
			}else return -1; // 예약 불가능 / 인원 초과 
		}
			
		
	}
	
	// 숙소 취소 승인 비동기 
	public int RsvCancel(UserRsvCancelVO param, HttpSession hs) {
		
		int result = mapper.RsvCancel(param.getI_reser()); // 성공 : 1 ,실패 : 0 
		//System.out.println("result : "+result);
		if(result > 0) {
			result = mapper.upRsvCancel(param);// 성공 : 1 ,실패 : 0 
			if(result > 0) {
				result = mapper.delRsvCancel(param.getI_reser()); // 성공 : 1 ,실패 : 0 
				if(result > 0) {
					TUserVO loginUser = (TUserVO)hs.getAttribute("loginUser");
					return loginUser.getI_user();
				}else return result;
			}else return result;
		}else return result;
		
	}
	// 유저 가 등록한 숙소 데이터 들고 오기 
	public List<HostHouseVO> selHostHouse(HostHouseVO param) {
		List<HostHouseVO> list = mapper.selHostHouse(param);
		// 숙소 사진 추가 
		for(HostHouseVO dbVO : list) {
			dbVO.setImg_url(imgUrlChange(dbVO.getImg_url(), dbVO.getI_host()));	
		}
		return list;
	}
	//숙소 삭제 실행  비동기 
	public int delHostHouse(HostHouseVO param){
		int result = mapper.delHostHouse(param);
		result = mapper.delHostUser(param);
		return result; // 0 : 실패  1 : 성공 
	}
	
	//숙소 숙박 완료 승인 (비동기)
	public int completeRsv(UserRsvChangeVO param,HttpSession hs) {
		// 현재 로그인 정보(i_user) 가져오기 
		param.setI_user(MyUtils.getSesstion(hs));
		
		return mapper.completeRsv(param);// 0 : 실패  1 : 성공 
	}
	
	// 실적 > 후기 (host_title 출력)
	public List<HostUserVO> selHost(ReviewAvgQtyVO param){
		return mapper.selHost(param);
	}
	// 실적 > 후기 (후기 평균 점수 및 개수 출력)
	public ReviewAvgQtyVO selReviewAvg(ReviewAvgQtyVO param){
		return mapper.selReviewAvg(param);
	}
	// 실적 > 후기 (실제 후기 데이터 출력)
	public List<ProfitReviewVO> selReview(ReviewAvgQtyVO param){
		List<ProfitReviewVO> list = mapper.selReview(param);
		for(ProfitReviewVO dbVO : list) {
			// 숙소 사진 경로 변경 
			dbVO.setImg_url(imgUrlChange(dbVO.getImg_url(), dbVO.getI_host()));
			// 유저 사진 경로 변경 
			dbVO.setPro_img(proImgChange(dbVO.getPro_img(), dbVO.getI_user()));
		}
		return list;
	}
	
	// 실적 > 후기  (실제 후기 데이터 출력 ) 비동기 
	public List<ProfitReviewVO> selectReview(ReviewAvgQtyVO param, HttpSession hs){
		// 로그인 유저 i_user 가져오기 
		param.setI_user(MyUtils.getSesstion(hs));
		
		List<ProfitReviewVO> list = mapper.selReview(param);
		
		// 숙소 이미지 유저 이미지 경로 변경 
		for(ProfitReviewVO dbVO : list) {
			// 숙소 사진 경로 변경 
			dbVO.setImg_url(imgUrlChange(dbVO.getImg_url(), dbVO.getI_host()));
			// 유저 사진 경로 변경 
			dbVO.setPro_img(proImgChange(dbVO.getPro_img(), dbVO.getI_user()));
		}
		
		return list;
	}
	//실적 > 후기 (검색 평균 후기 점수 출력)
	public ReviewAvgQtyVO selectReviewAvg(ReviewAvgQtyVO param, HttpSession hs) {
		// 로그인 유저 i_user 가져오기 
		param.setI_user(MyUtils.getSesstion(hs));
		// 검색 평균 후기 점수 
		return mapper.selReviewAvg(param);
	}
	
	// 실적 > 수입 비동기(검색)  년도 총 수입 및 지급완료 , 예정 수입  
	public List<EarningsSeachVO> selProfitData(EarningsSeachVO param, HttpSession hs) {
		// 로그인 유저 i_user 가져오기 
		param.setI_user(MyUtils.getSesstion(hs));
		
		// 데이터 출력 
		List<EarningsSeachVO> list = mapper.selProfit0(param);
		list.add(mapper.selProfit1(param));
		
		return list;
	}
	
	
	// 실적 > 수입 비동기(검색) chart 
	public List<EarnChartVO> selChart(EarningsSeachVO param, HttpSession hs) {
		// 로그인 유저 i_user 가져오기 
		param.setI_user(MyUtils.getSesstion(hs));
		
		// 데이터 출력 
		return mapper.selChart(param);
	}
	
	// 실적 > 수입 비동기(검색) 월별 통계
	public List<EarningsDataVO> selTable(EarningsSeachVO param, HttpSession hs){
		// 로그인 유저 i_user 가져오기 
		param.setI_user(MyUtils.getSesstion(hs));
		
		List<EarningsDataVO> list = mapper.selTable(param);
		
		for (EarningsDataVO dataVO : list) {
			dataVO.setPro_img(proImgChange(dataVO.getPro_img(),dataVO.getI_user()));
			dataVO.setImg_url(imgUrlChange(dataVO.getImg_url(), dataVO.getI_host()));
		}
		
		return list;
	}
	
	// 숙소  이미지 경로 변경 
	public String imgUrlChange(String url,int i_host) {
		String room_poto = "/resources/room_img/host" + i_host + "/" + url;
		if(url== null|| url.equals("")) { // 이미지 파일이 없으면 기본 이미지 출력
			room_poto = "/resources/room_img/roomDfault.png";
		}
		return room_poto;
	}
	
	// 유저   이미지 경로 변경 
	public String proImgChange(String url,int i_user) {
		String pro_img = "/resources/user_img/user" + i_user + "/" + url;
		if(url== null|| url.equals("")) {// 이미지 파일이 없으면 기본 이미지 출력
			pro_img = "/resources/img/pimg.jpg";
		}
		return pro_img;
	}
	
	// 해당 숙소 변경 날짜 확인 메소드 (예약 변경날짜가 이미 지났는지 않지났는지)
	public int checkOutComfirm(UserRsvChangeVO param) { 
		// table chout 가져오기 
		String check_out = mapper.checkOutComfirm(param);
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		// table toDate 오늘 날짜 
		Calendar cal= Calendar.getInstance();
	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    // 최종 chout,오늘날짜 담을 변수 
	    Date to = null;
	    Date toDate = null; 
	    
		// 문자열 date 타입이로 형변환 
		try {
			to = transFormat.parse(check_out);
			toDate =transFormat.parse(df.format(cal.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int compare = to.compareTo(toDate);
		
		if(compare < 0 ) {  // 오늘 날짜 기준으로 변경 날짜는 지남  
			return 0;
		}else { // 변경 날짜가 오늘 날짜보다 미래 
			return 1;
		}
		
	}
	
}
