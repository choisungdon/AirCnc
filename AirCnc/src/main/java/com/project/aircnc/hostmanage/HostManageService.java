package com.project.aircnc.hostmanage;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.aircnc.common.HostRsvCancelVO;
import com.project.aircnc.common.MyUtils;
import com.project.aircnc.common.RsvVO;
import com.project.aircnc.common.RsvViewData;
import com.project.aircnc.common.TUserVO;

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
	public List<RsvVO> selRsv(TUserVO param) {
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
}
