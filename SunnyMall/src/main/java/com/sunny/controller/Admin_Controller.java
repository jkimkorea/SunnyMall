package com.sunny.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sunny.domain.AdminVO;
import com.sunny.dto.AdminDTO;
import com.sunny.service.Admin_Service;

@Controller
@RequestMapping("/admin/*")
public class Admin_Controller {
	
	@Inject
	private Admin_Service service;
	private static final Logger logger = LoggerFactory.getLogger(Admin_Controller.class);
	
	//관리자 로그인 페이지
	@RequestMapping(value = "/admin_main",method = RequestMethod.GET)
	public void adminLogin() {
	}

	//로그인
	@RequestMapping(value = "adminLogin",method=RequestMethod.POST)
	public String adminLogin(AdminDTO dto,HttpSession session,RedirectAttributes rttr) throws Exception {
		logger.info("===============adminLogin() success======");
		logger.info("===============dto:"+dto);
		
		AdminVO vo=service.adminLogin(dto);
		logger.info("===============vo:"+vo);
		
		String msg="";
		
		if(vo!=null){
			session.setAttribute("admin", vo);
			//관리자 로그인 시간 업데이트 작업(보완)
			msg="LOGIN_SUCCESS";
		}else {
			msg="LOGIN_FAIL";
		}
		rttr.addFlashAttribute("msg", msg);
		return "redirect:/admin/admin_main";
	}
	//로그 아웃
	@RequestMapping(value = "/adminLogout",method = RequestMethod.GET)
	public String adminLogout(HttpSession session,RedirectAttributes rttr) {
		logger.info("===============adminLogout() success======");
		session.invalidate();
		rttr.addFlashAttribute("msg","LOGOUT_SUCCESS");
		return "redirect:/admin/admin_main";
	}

}
