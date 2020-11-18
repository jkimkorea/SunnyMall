package com.sunny.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunny.controller.Delivery_Controller;
import com.sunny.service.Delivery_Service;
import com.sunny.util.PageMaker;
import com.sunny.util.SearchCriteria;

@Controller
@RequestMapping("/admin/delivery/*")
public class Delivery_Controller {

	@Inject
	private Delivery_Service service;
	
	private static final Logger logger = LoggerFactory.getLogger(Delivery_Controller.class);
	
	//배송 리스트 출력
	@RequestMapping(value = "deliveryList",method=RequestMethod.GET)
	public void deliveryList(Model model,@ModelAttribute("cri") SearchCriteria cri) throws Exception {
		logger.info("=================deliveryListALl() execute=============");
		
		model.addAttribute("deliveryListVO",service.deliveryListAll(cri));
		
		PageMaker pm = new PageMaker();
		pm.setCri(cri);
		logger.info("=================cri:"+cri);
		
		int count = service.deliveryCount(cri);
		pm.setTotalCount(count);
	
		logger.info("=================pm:"+pm);
		model.addAttribute("pm", pm);
	}
	//배송 상태 확인
	@ResponseBody
	@RequestMapping(value = "delivery_check", method=RequestMethod.POST)
	public String deliveryCheck(@RequestParam("ord_no") int ord_no,
								@RequestParam("delivery_check") String delivery_check) throws Exception {
		logger.info("============deliveryCheck() execute=============");
		
		if(delivery_check.equals("배송 완료")) {
			service.deliveryDate(ord_no);
			
		}else {}

		Map<String,Object> map= new HashMap<String,Object>();
		map.put("ord_no",ord_no);
		map.put("delivery_check", delivery_check);
		
		service.deliveryCheck(map);
		
		return delivery_check;
	}
	//배송상태에 따른 목록 출력
	@RequestMapping(value = "checkedList",method=RequestMethod.GET)
	public void checkedList(
			Model model,@RequestParam("delivery_check") String delivery_check,
			@ModelAttribute("cri") SearchCriteria cri) throws Exception{
		
		logger.info("======================checkedList() execute=============");
		
		model.addAttribute("deliveryListVO",service.deliveryListAll(cri));
		
		Map<String,Object> map = new HashMap<String, Object>();
		PageMaker pm = new PageMaker();
		pm.setCri(cri);
		
		if(delivery_check.equals("주문 전체")) {
			model.addAttribute("deliveryListVO", service.deliveryListAll(cri));
			int count = service.deliveryCount(cri);
			pm.setTotalCount(count);
			
		}else {
			map.put("cri", cri);
			map.put("delivery_check", delivery_check);
			model.addAttribute("deliveryListVO",service.deliveryCheckedList(map));
			int count = service.deliveryCheckedCount(delivery_check);
			pm.setTotalCount(count);
		}
		model.addAttribute("pm", pm);
		model.addAttribute("delivery_check", delivery_check);
	}
	
}
