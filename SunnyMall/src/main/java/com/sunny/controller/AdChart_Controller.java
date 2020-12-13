package com.sunny.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sunny.dto.SalesDTO;
import com.sunny.service.AdChart_Service;

@Controller
@RequestMapping("/admin/chart/*")
public class AdChart_Controller {

	@Inject
	private AdChart_Service service;
	
	private static final Logger logger = LoggerFactory.getLogger(AdChart_Controller.class);
	
	
	//챠트불러오기 
	@RequestMapping(value = "readChart",method=RequestMethod.GET)
	public ModelAndView addChart(Model model) throws Exception {
	
		logger.info("=================chartAdd() execute===============");
		
		ModelAndView mv = new ModelAndView();
		
		
		//현재달 정보 가져오기
		Timestamp currentDate = new Timestamp(System.currentTimeMillis());
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String targetDate = format.format(currentDate);//2020-12-12
		
		//Timestamp형식으로 저장하기위해 형변환 /해당 달의 첫째날 셋팅
		String ord_date = targetDate.substring(0, 7)+"-01";
		
		//이달에 첫날부터 접속날 add
		model.addAttribute("date_s", ord_date);
		model.addAttribute("date_e", targetDate);
		
		
		List<SalesDTO> monthlyList= service.readChart(ord_date);
		
		String str="";
		
		str += "[['Date','Sales'],";

		logger.info("==========list:"+monthlyList.toString());
		int num = 0;
		//향상된 for문
		for(SalesDTO totalSales:monthlyList) {
			
			str += "['";
			str += totalSales.getOrdDate()+"',"+totalSales.getSales()+"]";
			num ++;
			
			if(num < monthlyList.size()) {
			
				str += ",";
			}
		}
		str +="]";
		
		logger.info("===================str:"+str);
		
		mv.addObject("monthlyList",monthlyList);
		mv.addObject("str", str);
		mv.setViewName("/admin/chart/readChart");
		return mv;
	}
	//원하는 날짜에 따른 매출 검색
		@RequestMapping(value = "searchChart",method=RequestMethod.POST)
		public ModelAndView searchChart(String date_s,String date_e,Model model) throws Exception {
		
			logger.info("=================chartAdd() execute===============");
			//검색한날짜 재전달
			model.addAttribute("date_s", date_s);
			model.addAttribute("date_e", date_e);
			
			ModelAndView mv = new ModelAndView();
			
			Map<String,Object> map = new HashMap<String, Object>();
			
			map.put("date_s", date_s);
			map.put("date_e", date_e);
			
			//검색한 날에 해당하는 리스트 불러옴
			List<SalesDTO> monthlyList= service.searchChart(map);
			
			String str="";
			
			str += "[['Date','Sales'],";

			logger.info("==========list:"+monthlyList.toString());
			int num = 0;
			//향상된 for문
			for(SalesDTO totalSales:monthlyList) {
				
				str += "['";
				str += totalSales.getOrdDate()+"',"+totalSales.getSales()+"]";
				num ++;
				
				if(num < monthlyList.size()) {
				
					str += ",";
				}
			}
			str +="]";
			
			logger.info("===================str:"+str);
			
			mv.addObject("monthlyList",monthlyList);
			mv.addObject("str", str);
			mv.setViewName("/admin/chart/readChart");
			return mv;
		}

}
