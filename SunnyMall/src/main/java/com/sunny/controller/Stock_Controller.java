package com.sunny.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunny.domain.ProductVO;
import com.sunny.service.AdProduct_Service;
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
	private AdProduct_Service adProService;
	
	private static final Logger logger = LoggerFactory.getLogger(Stock_Controller.class);

	//재고 리스트
	@RequestMapping(value = "stockList",method=RequestMethod.GET)
	public void stockPage(@ModelAttribute("cri") SearchCriteria cri,Model model) throws Exception {
		logger.info("===================stockList() execute===============");
		
		List<ProductVO> list = service.readStockList(cri);
		model.addAttribute("list",list);
		logger.info("===============list:"+list);
		
		PageMaker pm = new PageMaker();
		pm.setCri(cri);
		int count = adProService.searchListCount(cri);
		pm.setTotalCount(count);
		model.addAttribute("pm",pm);
	}
	//상품 재고량 수정
	@ResponseBody
	@RequestMapping(value = "edit",method=RequestMethod.POST)
	public String edit(@ModelAttribute("cri") SearchCriteria cri,
					   @RequestParam("prd_no") int prd_no,
					   @RequestParam("prd_stock") int prd_stock
					   ) throws Exception {
		logger.info("=================edit() execute=================");
		
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("prd_no", prd_no);
		map.put("prd_stock", prd_stock);
		service.setProductAmount(map);
		
		return "ok";
	}
}
