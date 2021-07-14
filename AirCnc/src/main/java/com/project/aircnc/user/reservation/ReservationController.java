package com.project.aircnc.user.reservation;

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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.aircnc.common.KakaoPayMentReady;
import com.project.aircnc.common.KakaoUserInfo;
import com.project.aircnc.common.ReservationVO;
import com.project.aircnc.common.RsvChangeVO;
import com.project.aircnc.common.SearchVO;
import com.project.aircnc.common.UserRsvCancelVO;
import com.project.aircnc.common.UserRsvChangeVO;


@Controller
@RequestMapping(value = "/reservation")
public class ReservationController {
	
	@Autowired
	ReservationService service;
	// 예약 화면 
	@RequestMapping(value = "/reservation", method = RequestMethod.GET)
	public String goRservation(SearchVO param, Model model, HttpSession hs) {
		
		model.addAttribute("data",service.selReservation(param));
		model.addAttribute("sData",param); // 예약 정보  
		return "/reservation/reservation";
	}
	// 예약 저장 
	@RequestMapping(value="/rsvSave", method=RequestMethod.POST)
	public String rsvSave(ReservationVO param, Model model, HttpSession hs) {
			
			model.addAttribute("data",service.inserRSV(param,hs));
			return "/message/message";
	}
	
	// 예약 취소 변경 메인 화면 
	@RequestMapping(value = "/rsvcc", method = RequestMethod.GET)
	public String rsvCC(ReservationVO param, Model model, HttpSession hs) {
		//System.out.println("i_reser : "+param.getI_reser());
		model.addAttribute("data",service.selRsv(param,hs));
		return "/reservation/rsvcc";
	}
	// 예약 변경 화면 
	@RequestMapping(value = "/rsvChange", method = RequestMethod.GET)
	public String rsvCahnge(ReservationVO param, Model model, HttpSession hs) {
		//System.out.println("i_reser : "+param.getI_reser());
		model.addAttribute("data",service.selRsvChange(param,hs));
		return "/reservation/rsvChange";
	}
	
	// 예약 변경 실행 
	@RequestMapping(value = "/rsvChange", method = RequestMethod.POST)
	public String cahngeRsv(UserRsvChangeVO param, Model model, HttpSession hs) {
		//System.out.println("i_reser : "+param.getI_reser());
		model.addAttribute("data",service.upInserRsvChange(param,hs));
		return "/reservation/recomfirm";
	}
	
	// 예약 취소 화면 
	@RequestMapping(value = "/rsvCancel", method = RequestMethod.GET)
	public String rsvCancel(ReservationVO param, Model model, HttpSession hs) {
		//System.out.println("i_reser : "+param.getI_reser());
		model.addAttribute("data",service.selrsvCancel(param,hs));
		return "/reservation/rsvCancel";
	}
	
	// 예약 취소 실행 
	@RequestMapping(value = "/rsvCancel", method = RequestMethod.POST)
	public String CancelRsv(UserRsvCancelVO param, Model model, HttpSession hs) {
		//System.out.println("reason : "+param.getReason());
		model.addAttribute("data",service.upInserRsv(param));
		return "/reservation/recomfirm"; // 확인 절차 화면 
	}
	
	// 현재 숙박 일 . 인원 가능 여부 확인 
	@RequestMapping(value="/goComfirm", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> goComfirm (@RequestParam int i_host,@RequestParam String chin,
			@RequestParam String chout,@RequestParam int date, @RequestParam int qty, @RequestParam int i_reser,
			Model model, HttpSession hs){
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", service.selExist(i_host,i_reser,chin,chout,date,qty));
		
		return map;
	}
	
	// 기존 예약  숙박 일 . 인원 출력 (submit 확인용) 
	@RequestMapping(value="/checkData", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> checkData (@RequestBody RsvChangeVO param, Model model, HttpSession hs){
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", service.checkData(param,hs));
		
		return map;
	}
	
	// 카카오 페이 결제 준비  
	@RequestMapping(value="/redKakaoPay", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> redKakaoPay (@RequestBody ReservationVO param, Model model, HttpSession hs){
		
		//System.out.println("test : "+param.toString());
		Map<String, Object> map = new HashMap<String, Object>();
		
		//String kkPayMentURL = String.format("redirect:%s", service.redKakaoPay(param,hs));
		
		map.put("result", service.redKakaoPay(param,hs));
		
		return map;
		//return kkPayMentURL;
	}
	
	// 카카오 페이 결제 성공 
	@RequestMapping(value="/kakaoApproval", method=RequestMethod.GET)
	public String kakaoApprove (@RequestParam("pg_token") String pg_token , Model model, HttpSession hs){
		
		model.addAttribute("data",service.kakaoApprove(pg_token,hs));
		return "/message/message";
		
	}
	
	
}
