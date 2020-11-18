package com.sunny.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sunny.domain.QnAVO;
import com.sunny.dto.MemberDTO;
import com.sunny.service.QnA_Service;

@Controller
@RequestMapping("/qna/*")
public class QnA_Controller {

	@Inject
	private QnA_Service service;
	
	private static final Logger logger = LoggerFactory.getLogger(QnA_Controller.class);
	
	//문의글 등록
	@RequestMapping(value = "qnaAdd",method=RequestMethod.POST)
	public void insertBoard(HttpSession session,QnAVO vo) throws Exception{
		MemberDTO dto=(MemberDTO) session.getAttribute("user");
		vo.setMb_id(dto.getMb_id());
		service.qnaAdd(vo);
	}
	//문의글 목록
	//@RequestMapping(value = "qnaList",method=RequestMethod.GET)
	//public void qnaList(Model model) throws Exception{
		
	//}
	
	
}
