package com.project.aircnc.hostmanage;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
