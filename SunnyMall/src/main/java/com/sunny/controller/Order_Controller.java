package com.sunny.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/order/*")
public class Order_Controller {

	private static final Logger logger = LoggerFactory.getLogger(Order_Controller.class);
	
	//주문 페이지
	@RequestMapping(value = "/orderPage",method = RequestMethod.GET)
	public void order() {
					
	}
}
