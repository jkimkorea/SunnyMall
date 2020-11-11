package com.sunny.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sunny.domain.OrderDetailVOList;
import com.sunny.domain.OrderListVO;
import com.sunny.domain.OrderReadDetailVO;
import com.sunny.domain.OrderVO;
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
	
	//장바구니->주문 페이지
	@RequestMapping(value = "/orderPage",method = RequestMethod.POST)
	public String orderPage(
						  @RequestParam("prd_no") List<Integer> prd_noList,
						  @RequestParam("cart_code") List<Integer> cart_codeList,
						  HttpSession session,Model model) throws Exception {
				
		logger.info("=============orderForm() execute============");
		logger.info("=============cart_codeList:"+cart_codeList);
	
		List<ProductVO> productList = new ArrayList<ProductVO>();
		List<Integer> amountList =  new ArrayList<Integer>();
		for(int i = 0; i<prd_noList.size();i++) {
		productList.add(proService.readProduct(prd_noList.get(i)));
		amountList.add(service.readCartAmount(cart_codeList.get(i)));
		
		}
		model.addAttribute("productList",productList);
		model.addAttribute("amountList",amountList);
		
		String url = "";
		MemberDTO dto = (MemberDTO) session.getAttribute("user");
		if(dto != null) {
			model.addAttribute("user", memService.readUserInfo(dto.getMb_id()));
			url = "/order/orderPage";
		}else {
			url="/member/loginPage";
		}
		return url;
	}
	//장바구니->구매 결제하기
	@RequestMapping(value = "orderFromCart", method=RequestMethod.POST)
	public String orderFromCart(OrderVO order,OrderDetailVOList orderDetailList,
								HttpSession session) throws Exception {
		
		logger.info("==============orderFromcart() execute============");
		logger.info("==============OrderVO:"+order.toString());
		logger.info("==============OrderDetailVOList:"+orderDetailList.toString());
		
		MemberDTO dto = (MemberDTO) session.getAttribute("user");
		service.addOrderCart(order, orderDetailList, dto.getMb_id());
		
		return "/order/orderComplete";
	}
	//상품리스트 -> 바로구매하기
	@RequestMapping(value = "buy",method=RequestMethod.GET)
	public String buy(@RequestParam("prd_no") int prd_no,
					  @RequestParam("ord_amount") int ord_amount,
					  Model model, HttpSession session) throws Exception {
		logger.info("==============buy() execute=============");
		List<ProductVO> productList = new ArrayList<ProductVO>();
		List<Integer> amountList = new ArrayList<Integer>();
		
		productList.add(proService.readProduct(prd_no));
		amountList.add(ord_amount);
		
		model.addAttribute("productList", productList);
		model.addAttribute("amountList", amountList);
		
		String url = "";
		MemberDTO dto = (MemberDTO) session.getAttribute("user");
		if(dto != null) {
			
			model.addAttribute("user", memService.readUserInfo(dto.getMb_id()));
			
			url = "/order/buy";
		}else {
			url="/member/loginPage";
		}
		return url;
	}
	//주문완료 후 주문 내역 보기
	@RequestMapping(value = "orderList",method=RequestMethod.GET)
	public void orderList(Model model, HttpSession session) throws Exception {
		logger.info("==============orderList() execute================");
		
		MemberDTO dto = (MemberDTO) session.getAttribute("user");
		List<OrderListVO> list = service.readOrderList(dto.getMb_id());
		
		logger.info("================list:"+list.toString());
		
		model.addAttribute("orderList", list);
	}
	//주문 내역-> 주문 상세
	@RequestMapping(value = "order_read",method=RequestMethod.GET)
	public String read(int ord_no,Model model) throws Exception{
		
		logger.info("============readOrder() execute===============");
		
		List<OrderReadDetailVO> orderReadDetailVO=service.readOrder(ord_no);
		model.addAttribute("orderVO",orderReadDetailVO);
		
		logger.info("================orderReadDetailVO:"+orderReadDetailVO);
		
		model.addAttribute("customerInfo", service.getOrder(ord_no));
		return "/order/order_read";
	}
	//상품 바로구매
	@RequestMapping(value = "order",method=RequestMethod.POST)
	public String order(OrderVO order,OrderDetailVOList orderDetailList) throws Exception {
		logger.info("=================order() execute===============");
		logger.info("==================order:"+order);
		logger.info("==================orderDeratilList:"+orderDetailList);
		
		service.addOrder(order, orderDetailList); 
		
		return "/order/orderComplete";
	}
}
