package com.project.aircnc.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CheckInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception{
		
		HttpSession hs = request.getSession();
		TUserVO loginUser = (TUserVO)hs.getAttribute("loginUser");
		// 로그인 세션 정보있으면 return true
		if(loginUser != null) {
			return true;
		}
		//아니면 return false 및 첫화면 이동
		System.out.println("인터셉터 ~!!");
		response.sendRedirect("/?interceptor="+false);
		return false;
	}

}
