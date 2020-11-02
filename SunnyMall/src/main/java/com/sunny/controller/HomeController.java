package com.sunny.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sunny.domain.ProductVO;
import com.sunny.domain.ReviewVO;
import com.sunny.service.Product_Service;
import com.sunny.service.Review_Service;
import com.sunny.util.Criteria;
import com.sunny.util.PageMaker;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Inject
	private Product_Service service;
	@Inject
	private Review_Service revService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws Exception 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model,@ModelAttribute("cri") Criteria cri) throws Exception {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		List<ProductVO> vo = service.allProductList(cri);
		logger.info("===============vo:"+vo);
		model.addAttribute("vo",vo);
		
		PageMaker pm=new PageMaker();
		pm.setCri(cri);
		pm.setTotalCount(service.allProductCount());
		model.addAttribute("pm",pm);
		
		return "index";
	}

}
