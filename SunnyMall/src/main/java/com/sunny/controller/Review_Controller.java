package com.sunny.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunny.domain.ProductVO;
import com.sunny.domain.ReviewVO;
import com.sunny.dto.MemberDTO;
import com.sunny.service.Product_Service;
import com.sunny.service.Review_Service;
import com.sunny.util.Criteria;
import com.sunny.util.PageMaker;

@Controller
@RequestMapping("/review/*")
public class Review_Controller {

	@Inject
	private Review_Service service;
	
	private static final Logger logger = LoggerFactory.getLogger(Review_Controller.class);

	//리뷰 작성
	@ResponseBody
	@RequestMapping(value = "write",method=RequestMethod.POST)
	public void write(ReviewVO vo,HttpSession session) throws Exception {
		
		logger.info("========write() execute=======");
			MemberDTO dto=(MemberDTO) session.getAttribute("user");
			service.writeReview(vo, dto.getMb_id());
	}
	//상품 후기 리스트
	@RequestMapping(value = "{prd_no}/{page}",method=RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> listReview(
									@PathVariable("prd_no") Integer prd_no,
									@PathVariable("page") Integer page)	{
		
		logger.info("============listReview() execute============");
		ResponseEntity<Map<String, Object>> entity = null;
		
		try {
			Criteria cri = new Criteria();
			cri.setPage(page);
			
			PageMaker pageMaker=new PageMaker();
			pageMaker.setCri(cri);
			
			Map<String,Object> map=new HashMap<String,Object>();
			List<ReviewVO> list=service.reviewList(prd_no,cri); 
			logger.info("===========list:"+list);
			map.put("list",list);
			int reviewCount = service.reviewCount(prd_no);
			
			pageMaker.setTotalCount(reviewCount);
			map.put("pageMaker",pageMaker);
			logger.info("=============pageMaker:"+pageMaker);
			entity= new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Map<String,Object>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	//리뷰 삭제
	@ResponseBody
	@RequestMapping(value = "{rev_no}/{prd_no}", method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteReview(@PathVariable("rev_no") Integer rev_no,
											   @PathVariable("prd_no") Integer prd_no) throws Exception{
		logger.info("===============deleteReview() execute==================");
		ResponseEntity<String> entity=null;
		try {
			service.deleteReview(rev_no,prd_no);
			entity = new ResponseEntity<String>(HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);	
		}
		return entity;
	}
	//리뷰 수정
	@ResponseBody
	@RequestMapping(value = "modify",method=RequestMethod.POST)
	public ResponseEntity<String> modify(ReviewVO vo){
		ResponseEntity<String> entity=null;
		
		try {
			service.modify(vo);
			entity=new ResponseEntity<String>(HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity=new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
	
