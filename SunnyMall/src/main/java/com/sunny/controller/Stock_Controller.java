package com.sunny.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sunny.domain.ProductVO;
import com.sunny.service.Product_Service;
import com.sunny.service.Stock_Service;
import com.sunny.util.PageMaker;
import com.sunny.util.SearchCriteria;

@Controller
@RequestMapping("/admin/stock/*")
public class Stock_Controller {
	
	@Inject
	private Stock_Service service;
	@Inject
	private Product_Service proService;
	
	private static final Logger logger = LoggerFactory.getLogger(Stock_Controller.class);

	@RequestMapping(value = "stockList",method=RequestMethod.GET)
	public void stockPage(@ModelAttribute("cri") SearchCriteria cri,Model model) throws Exception {
		
		List<ProductVO> list = service.readStockList(cri);
		model.addAttribute("list",list);
		PageMaker pm = new PageMaker();
		pm.setCri(cri);
		int count = proService.allProductCount();
		pm.setTotalCount(count);
		model.addAttribute("pm",pm);
		
	}
}
