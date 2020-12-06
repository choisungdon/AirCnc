package com.project.aircnc.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.project.aircnc.common.TUserVO;

@Controller
public class UserController {
	@Autowired
	private UserService service;
	
	@PostMapping("/login")
	public @ResponseBody Map<String, Object> login (@RequestBody TUserVO param,
			Model model, HttpSession hs) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", service.login(param,hs));
		return map;
	}
	
    
    @PostMapping("/join")
	public @ResponseBody Map<String, Object> join (@RequestBody TUserVO param,
			Model model, HttpSession hs) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", service.join(param));
		return map;
	}
	
	
	@RequestMapping(value="/user/userSetting", method=RequestMethod.GET)
	public String userSetting (Model model, HttpSession hs) {
		return "/user/userSetting";
	}
	// 프로필 이동  페이지 
	@RequestMapping(value="/user/userShow", method=RequestMethod.GET)
	public String userShow (Model model, HttpSession hs) {
		return "/user/userShow";
	}
	// 개인 정보 수정 페이지 
	@RequestMapping(value="/user/userInfo", method=RequestMethod.GET)
	public String userInfo (Model model, HttpSession hs) {
		return "/user/userInfo";
	}
	// 개인정보 수정 비동기 
	@RequestMapping(value="/user/info", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> upInfo(@RequestBody TUserVO param , Model model, HttpSession hs){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", service.upUserVO(param,hs));
		return map;
	}
	/*
	@RequestMapping(value="/user/info", method=RequestMethod.POST)
	public String upinfo(TUserVO param,Model model, HttpSession hs){
		int result = service.upUserVO(param);
		if(result == 1) {
			hs.removeAttribute("loginUser");
		}
		return "redirect: /aircnc";
	}
	*/
	// 프로필 수정 페이지 이동 
	@RequestMapping(value="/user/userProfile", method=RequestMethod.GET)
	public String userProfile (Model model, HttpSession hs) {
		return "/user/userProfile";
	}
	// 프로필 수정 
	@RequestMapping(value="/user/userProfile", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> userProChange (@RequestParam("userPro")  MultipartFile userPro ,Model model, HttpSession hs) {
		Map<String, Object> map = new HashMap();
		map.put("result", service.upUserPro(userPro, hs));
		return map;
	}
	// 프로필 삭제 
	@RequestMapping(value="/user/delProfile", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> delProfile (Model model, HttpSession hs) {
		Map<String, Object> map = new HashMap();
		map.put("result", service.delProfile(hs));
		return map;
	}
	// 로그인 보안(PW 변경) 페이지 
	@RequestMapping(value="/user/userPW", method=RequestMethod.GET)
	public String userPW (Model model, HttpSession hs) {
		return "/user/userPW";
	}
	
	// 로그인 보안(PW 변경) 페이지 
	@RequestMapping(value="/user/userPWCahnge", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> userPWCahnge (@RequestParam String c_pw ,@RequestParam String r_pw, 
															Model model, HttpSession hs) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", service.upUserPW(c_pw, r_pw, hs));
		return map;
	}
	// 좋아요 활성화 
	@RequestMapping(value="/user/likelist", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> userLike (@RequestParam int i_host,  @RequestParam String title  
			,Model model, HttpSession hs) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", service.inslikeList(i_host, title, hs));
		return map;
	}
	
	// 좋아용 활성화 (기존 저장 목록에 추가)
	@RequestMapping(value="/user/llSave", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> llSave (@RequestParam int i_host,  @RequestParam int i_list  
			,Model model, HttpSession hs){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", service.insLikeUser(i_host, i_list, hs));
		return map;
	}
	
	// 좋아요 비활성화
	@RequestMapping(value="/user/disLike", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> userDisLike (@RequestParam int i_host, Model model, HttpSession hs) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", service.delLikeUser(i_host,hs));
		return map;
	}
}
