package com.sunny.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/cart/*")
public class Cart_Controller {

	private static final Logger logger = LoggerFactory.getLogger(Cart_Controller.class);
	
	//관리자 리스트
	@RequestMapping(value = "/cart_main",method = RequestMethod.GET)
	public void cartPage() {
	}
}
