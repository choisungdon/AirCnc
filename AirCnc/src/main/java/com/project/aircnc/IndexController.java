package com.project.aircnc;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
	
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String index (@RequestParam(value="interceptor", defaultValue="true") Boolean interceptor, HttpServletResponse response) {
		if(interceptor) { // 정상 접속
			return "index";
		}else  { // 로그인 interceptor 걸렸을때 
			response.setContentType("text/html; charset=UTF-8");
            PrintWriter out;
			try {
				out = response.getWriter();
				out.println("<script>alert('로그인 해주세요.');</script>");
		        out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           
			return "index";
		}
		
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
