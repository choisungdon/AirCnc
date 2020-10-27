package com.project.aircnc.search.detail;



import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.aircnc.common.SearchVO;

@Controller
@RequestMapping(value = "/search")
public class DetaileController {
	
	@Autowired
	private DetaileService service;
	
	@RequestMapping(value = "/searchDetail", method = RequestMethod.GET)
	public String goAddr(SearchVO param, Model model, HttpSession hs) {
		
		model.addAttribute("data",service.selDetaile(param,hs)); // 건물 정보 
		model.addAttribute("sData",param); // 검색 조건 
		
		return "/search/searchDetail";
	}
	
	// 현재 숙박 일 . 인원 가능 여부 확인 
	@RequestMapping(value="/goComfirm", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> goComfirm (@RequestParam int i_host,@RequestParam String chin,
			@RequestParam String chout,@RequestParam int date, @RequestParam int qty,
			Model model, HttpSession hs){
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", service.selExist(i_host,chin,chout,date,qty));
		
		return map;
	}
	
	
}
