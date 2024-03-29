package com.project.aircnc.hostmanage;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.aircnc.common.EarningsSeachVO;
import com.project.aircnc.common.HostHouseVO;
import com.project.aircnc.common.ReviewAvgQtyVO;
import com.project.aircnc.common.TUserVO;
import com.project.aircnc.common.UserRsvCancelVO;
import com.project.aircnc.common.UserRsvChangeVO;

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
		model.addAttribute("data", service.selRsv(param,hs));
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
		map.put("result", service.selRsv(param,hs));
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
	
	// 예약 모두 보기 데이터 가져오기 비동기 
	@RequestMapping(value = "/allViewData", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> selAllViewData(@RequestBody TUserVO param, HttpSession hs, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", service.selAllViewData(param));
		return map;
	}
	
	// 숙소 예약 변경 내용 확인 비동기 
	@RequestMapping(value = "/viewChangeData", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> RsvChangeData(@RequestBody UserRsvChangeVO param, HttpSession hs, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", service.selChangeData(param));
		return map;
	}
	
	// 숙소 예약 취소 사유  확인  비동기 
	@RequestMapping(value = "/viewCancelReason", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> RsvCcelReason(@RequestBody UserRsvCancelVO param, HttpSession hs, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", service.selCcelReason(param));
		return map;
	}
	
	// 예약 숙소 변경 승인 비동기 
	@RequestMapping(value = "/exChange", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> upRsvChange(@RequestBody UserRsvChangeVO param, HttpSession hs, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", service.upRsvChange(param,hs));
		return map;
	} 
	
	// 예약 숙소 취소 승인 비동기 
	@RequestMapping(value = "/exCancel", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> RsvCancel(@RequestBody UserRsvCancelVO param, HttpSession hs, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", service.RsvCancel(param,hs));
		return map;
	}
	
	// 저장된 숙소 메뉴 화면 이동 (숙소)
	@RequestMapping(value = "/hostHouse", method = RequestMethod.GET)
	public String goHostHouse(HostHouseVO param,HttpSession hs, Model model) {
		model.addAttribute("data", service.selHostHouse(param)); // 유저 가 등록한 숙소 데이터 들고 오기 
		model.addAttribute("shData", param); // 유저 가 등록한 숙소 데이터 들고 오기 
		return "/hostManage/hostHouse";
	}
	
	//숙소 삭제 실행  비동기 
	@RequestMapping(value = "/delHostHouse", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> delHostHouse(@RequestBody HostHouseVO param, HttpSession hs, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", service.delHostHouse(param));
		return map;
	}
	
	//숙소 숙박 완료 승인 (비동기)
	@RequestMapping(value = "/upRsv", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> completeRsv(@RequestBody UserRsvChangeVO param , HttpSession hs, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", service.completeRsv(param,hs));
		return map;
	}
		
	// 숙소 삭제 후 등록한 숙소 데이터 갱신 비동기 
	@RequestMapping(value = "/shHsotHouse", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> shHsotHouse(@RequestBody HostHouseVO param, HttpSession hs, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", service.selHostHouse(param));
		return map;
	}
	// 실적 > 후기 (실제 후기 데이터 출력 ) 동기
	@RequestMapping(value = "/profit", method = RequestMethod.GET)
	public String profit(ReviewAvgQtyVO param,HttpSession hs, Model model) {
		
		model.addAttribute("host_title", service.selHost(param)); // 실적 > 후기 (host_title 출력)
		model.addAttribute("reviewAvg", service.selReviewAvg(param)); //후기 평균 점수 및 개수 출력
		model.addAttribute("data", service.selReview(param)); // 실제 후기 데이터 출력 
		return "/hostManage/profit";
	}
	
	// 실적 > 후기  (실제 후기 데이터 출력 ) 비동기 
	@RequestMapping(value = "/profit", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> selectReview(@RequestBody ReviewAvgQtyVO param, HttpSession hs, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("review", service.selectReview(param,hs));
		map.put("rvAvg", service.selectReviewAvg(param,hs));
		return map;
	}
	
	// 실적 > 수입 
	@RequestMapping(value = "/earnings", method = RequestMethod.GET)
	public String earnings(TUserVO param,HttpSession hs, Model model) {
		return "/hostManage/earnings";
	}
	
	// 실적 > 수입 비동기(검색) chart 
	@RequestMapping(value = "/earnings", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> selChart(@RequestBody EarningsSeachVO param, HttpSession hs, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("chart", service.selChart(param,hs)); // 그래프 데이터 
		map.put("data",service.selProfitData(param,hs));// 년도 총 수입 및 지급완료 , 예정 수입 
		return map;
	}
	
	// 실적 > 수입 비동기(검색) 월별 통계
	@RequestMapping(value = "/getTtTable", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> selTable(@RequestBody EarningsSeachVO param, HttpSession hs, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("table", service.selTable(param,hs));
		return map;
	}
	
		
}
