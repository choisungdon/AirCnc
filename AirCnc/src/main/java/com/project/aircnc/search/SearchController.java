package com.project.aircnc.search;

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

import com.google.protobuf.TextFormat.ParseException;
import com.project.aircnc.common.SearchVO;
import com.project.aircnc.common.TUserVO;

@Controller
public class SearchController {
	
	@Autowired
	private SearchSearvice service;
	
	// 검색창 자동 완성  
	@RequestMapping(value = "/index/search", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> goAddr(@RequestParam String s_addr) {// @ResponseBody 모든 객체 데이터
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", service.searchList(s_addr));
		
		return map;
	}
	// 검색 내용 출력 
	@RequestMapping(value = "/search/searchMain", method = RequestMethod.GET)
	public String goSearchMain(SearchVO param, Model model ,HttpSession hs) {
		
		// 세션의 i_user 로그인 유저 정보 
		TUserVO vo = (TUserVO)hs.getAttribute("loginUser");
		param.setI_user(vo.getI_user()); // 좋아요 상태 값을 위해 필요합니다.(i_user) 
		
		model.addAttribute("data",service.hostList(param)); // list data
		model.addAttribute("sData", param); // 검색 옵션  
		model.addAttribute("likeList",service.selLikeList(hs)); // 좋아용 목록 
		
		return "search/searchMain";
		
	}
	
	// Google Map 
	@RequestMapping(value = "/search/map", method = RequestMethod.GET)
	public String goSearchMap( SearchVO param, Model model ,HttpSession hs) 
	{
		// 세션의 i_user 로그인 유저 정보 
		TUserVO vo = (TUserVO)hs.getAttribute("loginUser");
		param.setI_user(vo.getI_user());
		
		model.addAttribute("data",service.hostList(param)); // list data 각 숙소당 위도 경도/ 숙소 제목 출력 
		model.addAttribute("sData", param); // 검색 옵션 
		
		return "search/map";
	}
	
	
}
