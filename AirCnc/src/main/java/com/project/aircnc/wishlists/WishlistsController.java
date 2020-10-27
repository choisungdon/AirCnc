package com.project.aircnc.wishlists;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.aircnc.common.UserLListVO;

@Controller
@RequestMapping(value="/wishlists")
public class WishlistsController {

	@Autowired
	private WishlistsService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public String wishlists (Model model,HttpSession hs) {
		
		model.addAttribute("lists", service.selWishL(hs));
		
		return "wish/wishlists";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String wishlists (Model model, HttpSession hs, UserLListVO param) {
		service.insWishL(param,hs);
		model.addAttribute("lists", service.selWishL(hs));
		
		return "wish/wishlists";
	}
	
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String wishdetail (UserLListVO param, Model model,HttpSession hs) {
		
		// 리스트 정보
		model.addAttribute("list", service.selLinfo(param));
		
		model.addAttribute("hinfo", service.selHInfo(param));
		
		model.addAttribute("wList", service.selUserLList(hs));

		return "wish/wishdetail";
	}
}
