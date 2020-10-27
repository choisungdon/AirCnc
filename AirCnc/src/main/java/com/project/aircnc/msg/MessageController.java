package com.project.aircnc.msg;

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

@Controller
@RequestMapping(value = "/message")
public class MessageController {
	
	@Autowired
	private MessageService service;
	
	@RequestMapping(value = "/message", method = RequestMethod.GET)
	public String geMessage(Model model, HttpSession hs) {
		model.addAttribute("data",service.selMsg(hs));
		return "/message/message";
	}
	
	@RequestMapping(value="/selMsgList", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> selMsgList(@RequestParam int i_mlist, Model model, HttpSession hs){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", service.selMsgList(i_mlist));
		map.put("opt", service.selMsgUsers(i_mlist,hs)); // 톡방 참여 유저 정보 
		return map;
	}
	
	@RequestMapping(value="/saveMsg", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> saveMsg(@RequestParam int i_mlist, @RequestParam String cmt,
	Model model, HttpSession hs)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", service.insMsg(i_mlist,cmt,hs));
		return map;
	}
	
	@RequestMapping(value="/msgout", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> msgOut(@RequestParam int i_mlist, @RequestParam int i_user, Model model, HttpSession hs)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", service.delMsg(i_mlist,i_user));
		return map;
	}
	
}
