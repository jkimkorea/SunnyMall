package com.sunny.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MemberInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(MemberInterceptor.class);
	private static final String LOGIN = "user";  
	
	private void saveDest(HttpServletRequest req) {
		logger.info("==========saveDest() execute==========");
		String uri = req.getRequestURI();
		String query = req.getQueryString();
		
		if(query == null || query.equals("null")) {
			query = "";
		}else {
			query = "?" + query;
		}
		
		if(req.getMethod().equals("GET")) {
			logger.info("dest: " + (uri + query));
			req.getSession().setAttribute("dest", uri+query);
		}
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		
		// 인증된 사용자가 아닌경우 로그인 페이지로 이동
		if(session.getAttribute(LOGIN) == null) {
			logger.info("인증이 안된 경우");
			
			saveDest(request); // 원래요청된 주소를 세션형태로 저장하는 메서드
			
			response.sendRedirect("/member/loginPage");
			
			return false;
		}
		
		return true; // 요청된 주소의 해당 컨트롤러 메서드로 진행이 이루어진다.
		
		// return false; 구문이 로직에 의하여 작동이 되면, 해당 컨트롤러로 진행이 되지않는다.
	}

	
}
