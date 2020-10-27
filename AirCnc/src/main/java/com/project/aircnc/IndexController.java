package com.project.aircnc;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String index () {
		
		return "index";
	}
	
	@RequestMapping(value = "/aircnc", method=RequestMethod.GET)
	public String home(Model model) {
		
		return "index";
	}
	
	@RequestMapping(value = "/logOut", method=RequestMethod.GET)
	public String logOut(Model model,HttpSession hs) {
		hs.removeAttribute("loginUser");
		return "index";
	}
}
