package com.sunny.interceptor;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.sunny.dto.MemberDTO;
import com.sunny.service.Member_Service;

public class AuthInterceptor extends HandlerInterceptorAdapter{

	@Inject
	private Member_Service service;
	
	private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		logger.info("=============authinterceptor preHandle() execute====");
		HttpSession session = request.getSession();
		MemberDTO user=(MemberDTO) session.getAttribute("user");
		
		//세션에 유저 정보가 없으면 로그인 화면으로
		if(user == null) {
			response.sendRedirect("/member/loginPage");
			return false;
		}
		//쿠키 확인 
		Cookie loginCookie=WebUtils.getCookie(request, "loginCookie");
		if(loginCookie != null) {
			
		}
		return true;
	}
	

}
