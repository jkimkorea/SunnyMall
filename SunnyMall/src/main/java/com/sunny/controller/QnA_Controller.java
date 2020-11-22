package com.sunny.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@ResponseBody
	@RequestMapping(value = "qnaAdd",method=RequestMethod.POST)
	public String insertQnA(HttpSession session,
							String qna_title,String qna_content,
							@RequestParam("prd_no") int prd_no) throws Exception{
		logger.info("============qnaAdd() execute=============");
		MemberDTO dto=(MemberDTO) session.getAttribute("user");
		String str="";
		//수동 로그인 체크
		if(dto != null) {
		
			QnAVO vo=new QnAVO();
			vo.setPrd_no(prd_no);
			vo.setQna_title(qna_title);
			vo.setQna_content(qna_content);
			vo.setMb_id(dto.getMb_id());
			service.qnaAdd(vo);
			logger.info("===============vo:"+vo);
			str="ok";
		}else {
			str="null";
		}
		
		return str;
	}
	
	
	
	
}
