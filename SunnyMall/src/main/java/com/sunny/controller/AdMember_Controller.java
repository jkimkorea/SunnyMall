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
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunny.controller.AdMember_Controller;
import com.sunny.domain.BackupMemberVO;
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
	
	//회원관리 리스트 페이지
	@RequestMapping(value = "memberList",method=RequestMethod.GET)
	public String memberList(@ModelAttribute("cri") SearchCriteria cri,Model model) throws Exception {
		logger.info("============memberList() execute============");
		logger.info("============cri:"+cri);
		List<MemberVO> list = service.memberList(cri);
		
		model.addAttribute("memberVO", list);
		
		PageMaker pm = new PageMaker();
		int count = service.memberCount(cri);
		model.addAttribute("mbCount", count);
		pm.setCri(cri);
		pm.setTotalCount(count);
		
		model.addAttribute("pm", pm);
		
		return "/admin/member/member_List";
	}
	//멤버 탈퇴시키기
	@ResponseBody
	@RequestMapping(value = "deleteMember",method=RequestMethod.POST)
	public String deleteMember(@RequestParam("mb_id") String mb_id)throws Exception{
		service.deleteMember(mb_id);
		return "ok";
	}
	//탈퇴회원 리스트
	@RequestMapping(value = "delMemberList",method=RequestMethod.GET)
	public String delMemberList(@ModelAttribute("cri") SearchCriteria cri,Model model) throws Exception {
		logger.info("============delMemberList() execute============");
		logger.info("=================cri"+cri);
		List<BackupMemberVO> list = service.delMemberList(cri);
			
		model.addAttribute("delMemVO", list);
			
		PageMaker pm = new PageMaker();
		int count = service.delMemberCount(cri);
		model.addAttribute("mbCount", count);
		pm.setCri(cri);
		pm.setTotalCount(count);
			
		model.addAttribute("pm", pm);
		return "/admin/member/delMember_List";
	}
	
}
