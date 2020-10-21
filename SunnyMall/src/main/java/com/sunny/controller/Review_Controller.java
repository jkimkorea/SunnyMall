package com.sunny.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sunny.service.Review_Service;

@Controller
public class Review_Controller {

	@Autowired
	private Review_Service service;
	
	private static final Logger logger = LoggerFactory.getLogger(Review_Controller.class);
	
	
	
}
