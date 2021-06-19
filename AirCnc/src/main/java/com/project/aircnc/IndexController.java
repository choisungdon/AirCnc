package com.project.aircnc;


import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.aircnc.auth.SNSLogin;
import com.project.aircnc.auth.SnsValue;

@Controller
public class IndexController {
	
	@Inject
	private SnsValue naverSns;
	
	@Inject
	private SnsValue googleSns;

	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String index (@RequestParam(value="interceptor", defaultValue="true") Boolean interceptor, HttpServletResponse response
			,Model model, HttpSession hs) {
		// naver login url reseponse
		SNSLogin snsLogin = new SNSLogin(naverSns);
		model.addAttribute("naver_url", snsLogin.getAuthURL());
		
		/* 구글code 발행을 위한 URL 생성 */
		
		snsLogin = new SNSLogin(googleSns);
		model.addAttribute("google_url", snsLogin.getAuthURL());
		
//		OAuth2Operations oauthOperations = googleConnectionFactory.getOAuthOperations();
//		String url = oauthOperations.buildAuthorizeUrl(GrantType.AUTHORIZATION_CODE, googleOAuth2Parameters);
//
//		model.addAttribute("google_url", url);
		
		
		
		System.out.println("누군가 접속했습니다.");
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
