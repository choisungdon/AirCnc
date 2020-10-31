package com.project.aircnc.hostmanage;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
		model.addAttribute("data", service.selRsv(param));
		return "/hostManage/rsv";
	}
	// 예약 숙박 내용 확인 
	@RequestMapping(value="/viewData", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> selViewData (@RequestParam int i_reser,Model model, HttpSession hs){
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", service.selViewData(i_reser));		
		return map;
	}
	// 예정 예약(숙소 관리)데이터 가져오기 비동기 
	@RequestMapping(value = "/rsv", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> selRSV(@RequestBody TUserVO param, HttpSession hs, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", service.selRsv(param));
		return map;
	}
		
	// 예약 완료 데이터 가져오기 비동기
	@RequestMapping(value="/completeData", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> selCompleteData(@RequestBody TUserVO param,Model model, HttpSession hs){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", service.selCompleteData(param));		
		return map;
	}
	
	// 취소된 예약 정보 데이터 가져오기 비동기 
	@RequestMapping(value = "/cancelData", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> selCancelData(@RequestBody TUserVO param, HttpSession hs, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", service.selCancelData(param));
		return map;
	}
	// 예약 변경 및 취소 요청 데이터가져오기 비동기 
	@RequestMapping(value = "/rsvCcData", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> selrsvCcData(@RequestBody TUserVO param, HttpSession hs, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", service.selrsvCcData(param));
		return map;
	}
	
}
