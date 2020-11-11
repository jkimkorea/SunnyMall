package com.sunny.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunny.domain.CartProductVO;
import com.sunny.domain.CartVO;
import com.sunny.dto.MemberDTO;
import com.sunny.service.Cart_Service;

@Controller
@RequestMapping("/cart/*")
public class Cart_Controller {

	@Inject
	private Cart_Service service;
	
	private static final Logger logger = LoggerFactory.getLogger(Cart_Controller.class);
	
	//관리자 리스트
	@ResponseBody
	@RequestMapping(value = "/addToCart",method = RequestMethod.POST)
	public ResponseEntity<String> addToCart(int cart_amount,int prd_no,
											HttpSession session) throws Exception {
		logger.info("=============addToCart() execute============");
		ResponseEntity<String> entity=null;
		CartVO vo = new CartVO();
		try {
			MemberDTO dto =(MemberDTO)session.getAttribute("user");
			logger.info("================dto:"+dto);
				vo.setMb_id(dto.getMb_id());
				vo.setPrd_no(prd_no);
				vo.setCart_amount(cart_amount);
				
				service.addToCart(vo);
				
				entity = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	//장바구니 리스트
	@RequestMapping(value = "cartList",method=RequestMethod.GET)
	public void cartList(HttpSession session, Model model) throws Exception{
		
		logger.info("============cartList() execute=============");
		
		MemberDTO dto=(MemberDTO)session.getAttribute("user");
			String mb_id=dto.getMb_id();
			List<CartProductVO> list=service.cartList(mb_id);
			model.addAttribute("cartProList",list);
			
			logger.info("============list:"+list);
			
			int count=service.countCart(mb_id);
			
			logger.info("============count:"+count);
			
			model.addAttribute("countCart", count);
			
	}
	//장바구니 상품 삭제
	@ResponseBody
	@RequestMapping(value = "deleteCart", method = RequestMethod.POST)
	public ResponseEntity<String> deleteCart(@RequestParam("cart_code") int cart_code) throws Exception {
		logger.info("=============deleteCart() execute============");
		ResponseEntity<String> entity = null;
		
		try {
			service.deleteCart(cart_code);
			entity = new ResponseEntity<String>(HttpStatus.OK);
		}catch(Exception e) {
			
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	//상품 리스트페이지에서 장바구니로 바로 담기
	@ResponseBody
	@RequestMapping(value = "add",method=RequestMethod.POST)
	public ResponseEntity<String> addProduct(HttpSession session,int prd_no) throws Exception{
		logger.info("================add() execute=============");
		
		ResponseEntity<String> entity=null;
		MemberDTO dto = (MemberDTO) session.getAttribute("user");
		try {
			CartVO vo = new CartVO();
			vo.setMb_id(dto.getMb_id());
			vo.setPrd_no(prd_no);
			vo.setCart_amount(1);
			service.addToCart(vo);
			entity = new ResponseEntity<String>(HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	//선택한 상품 삭제하기
	@ResponseBody
	@RequestMapping(value = "deleteChecked",method=RequestMethod.POST)
	public ResponseEntity<String> deleteChecked(@RequestParam("checkArr[]") List<Integer> checkArr){
		
		logger.info("===============deleteChecked() execute================");
		
		ResponseEntity<String> entity = null;
		try {
			for(int cart_code : checkArr) {
				service.deleteCart(cart_code);
			}
			entity = new ResponseEntity<String>(HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	//주문 수량 변경하기
	@RequestMapping(value = "changeAmount",method=RequestMethod.POST)
	public ResponseEntity<String> changeAmount(@RequestParam("cart_amount") Integer cart_amount,
											   @RequestParam("cart_code") Integer cart_code){
		
		logger.info("===============changeAmount() execute================");
		
		ResponseEntity<String> entity = null;
		CartVO vo = new CartVO();
		vo.setCart_amount(cart_amount);
		vo.setCart_code(cart_code);
		logger.info("================vo:"+vo);
		try {
			service.changeAmount(vo);
			entity = new ResponseEntity<String>(HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
		
}
