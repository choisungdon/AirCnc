package com.project.aircnc.trip;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.aircnc.common.HostReviewVO;

@Controller
@RequestMapping("/trip")
public class TripController {
	
	@Autowired 
	private TripService service;
	
	@RequestMapping(value = "/trip", method = RequestMethod.GET)
	public String trip (HttpSession hs, Model model) {
		model.addAttribute("af_data",service.selReser(hs)); // 여행 예정 data
		model.addAttribute("bf_data",service.selBfReser(hs)); // 이전 여행 data
		
		return "/trip/trip";
	}
	// 후기 작성 비동기(수정,삽입 )
	@RequestMapping(value = "/review", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> review (@RequestBody HostReviewVO param,HttpSession hs, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", service.goReview(param,hs));
		return map;
		
	}
	
	// 기존 후기 select  비동기
	@RequestMapping(value = "/selReview", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> selReview (@RequestBody HostReviewVO param,HttpSession hs, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", service.selReview(param,hs));
		return map;
		
	}
	
}
