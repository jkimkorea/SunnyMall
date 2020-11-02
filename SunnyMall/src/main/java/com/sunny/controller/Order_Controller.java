package com.sunny.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sunny.domain.ProductVO;
import com.sunny.dto.MemberDTO;
import com.sunny.service.Member_Service;
import com.sunny.service.Order_Service;
import com.sunny.service.Product_Service;

@Controller
@RequestMapping("/order/*")
public class Order_Controller {

	@Inject
	private Order_Service service;
	@Inject
	private Product_Service proService;
	@Inject
	private Member_Service memService;
	
	private static final Logger logger = LoggerFactory.getLogger(Order_Controller.class);
	
	//주문 페이지
	@RequestMapping(value = "/orderPage",method = RequestMethod.POST)
	public void orderPage(@RequestParam("check") List<Integer> checkList,
						  @RequestParam("prd_no") List<Integer> prd_noList,
						  @RequestParam("cart_amount") List<Integer> cart_amountList,
						  @RequestParam("cart_code") List<Integer> cart_codeList,
						  HttpSession session,Model model) throws Exception {
				
		logger.info("=============orderForm() execute============");
		
		List<ProductVO> productList = new ArrayList<ProductVO>();
		List<Integer> amountList =  new ArrayList<Integer>();
		
		for(int i=0;i<cart_codeList.size(); i++) {
			for(int j=0; j<checkList.size(); j++) {
				
				if(cart_codeList.get(i)==checkList.get(j)) {
					productList.add(proService.readProduct(prd_noList.get(i)));
					amountList.add(cart_amountList.get(i));
			
					continue;
				}else {
					continue;
				}
			}
		}
		model.addAttribute("productList",productList);
		model.addAttribute("amountList",amountList);
	
		MemberDTO dto = (MemberDTO) session.getAttribute("user");
		model.addAttribute("user", memService.readUserInfo(dto.getMb_id()));
	}
	
	public String orderFromCart() {
		return null;
		
	}
	
}
