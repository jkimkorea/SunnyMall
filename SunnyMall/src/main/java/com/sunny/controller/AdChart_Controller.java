package com.sunny.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sunny.dto.SalesDTO;
import com.sunny.service.Chart_Service;

@Controller
@RequestMapping("/admin/chart/*")
public class AdChart_Controller {

	@Inject
	private Chart_Service service;
	
	private static final Logger logger = LoggerFactory.getLogger(AdChart_Controller.class);
	
	
	//챠트불러오기 
	@RequestMapping(value = "readChart",method=RequestMethod.GET)
	public void chartAdd(Model model) throws Exception {
	String str="";
		
		str += "[[Date,Sales],";
		
		
		List<SalesDTO> list= service.readChart();
		logger.info("==========list:"+list.toString());
		int num = 0;
		//향상된 for문
		for(SalesDTO totalSales:list) {
			
			str += "[";
			str += totalSales.getOrdDate()+","+totalSales.getSales()+"]";
			num ++;
			if(num<list.size()) {
			str += ",";
			}
		}
		str +="]";
		logger.info("===================str:"+str);
		model.addAttribute("str", str);
	}

}
