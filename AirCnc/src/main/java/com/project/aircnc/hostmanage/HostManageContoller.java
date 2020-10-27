package com.project.aircnc.hostmanage;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.aircnc.common.TUserVO;

@Controller
@RequestMapping("/hostManage")
public class HostManageContoller {
	
	@Autowired
	HostManageService service;
	// 알림판  화면 이동 
	@RequestMapping(value = "/manage", method = RequestMethod.GET)
	public String main(HttpSession hs, Model model) {
		model.addAttribute("rsvCcData", service.selUserReserCc(hs)); // 예약 변경 및 취소 요청 data 가져오기
		model.addAttribute("rsvData", service.selUserReser(hs)); // 예약 요청 data 가져요기  status가 null 인 요청
		return "/hostManage/manage";
	}
	// 예약(숙소 관리)화면 이동 
	@RequestMapping(value = "/rsv", method = RequestMethod.GET)
	public String main(TUserVO param, HttpSession hs, Model model) {
		
		return "/hostManage/rsv";
	}
	
}
