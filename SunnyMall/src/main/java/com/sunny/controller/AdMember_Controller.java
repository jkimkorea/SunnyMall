package com.sunny.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sunny.controller.AdMember_Controller;
import com.sunny.domain.MemberVO;
import com.sunny.service.AdMember_Service;
import com.sunny.util.PageMaker;
import com.sunny.util.SearchCriteria;

@Controller
@RequestMapping("/admin/member/*")
public class AdMember_Controller {

	@Inject
	private AdMember_Service service;
	private static final Logger logger = LoggerFactory.getLogger(AdMember_Controller.class);
	
	@RequestMapping(value = "memberList",method=RequestMethod.GET)
	public String memberList(@ModelAttribute("cri") SearchCriteria cri,Model model) throws Exception {
		logger.info("============memberList() execute============");
		List<MemberVO> list = service.memberList();
		logger.info("============List:"+list);
		
		model.addAttribute("memberVO", list);
		
		PageMaker pm = new PageMaker();
		int count = service.memberCount(cri);

		pm.setCri(cri);
		pm.setTotalCount(count);
		
		model.addAttribute("pm", pm);
		
		return "/admin/member/member_List";
	}
	
}
