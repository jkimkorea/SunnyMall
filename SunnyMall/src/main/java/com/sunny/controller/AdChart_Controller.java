package com.sunny.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sunny.dto.DateDTO;
import com.sunny.dto.RecentDateDTO;
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
	public void chartAdd(Model model,RecentDateDTO dto,DateDTO date) throws Exception {
	
		logger.info("=================chartAdd() execute===============");
		SimpleDateFormat Format = new SimpleDateFormat("yyyy-mm-dd");
		 int nYear;
	     int nMonth;
	     int nDay;
		Calendar calendar = new GregorianCalendar(Locale.KOREA);
        nYear = calendar.get(Calendar.YEAR);
        nMonth = calendar.get(Calendar.MONTH)+1;
        nDay = calendar.get(Calendar.DAY_OF_MONTH);
		String today = (String)(nYear+"-"+nMonth+"-"+nDay);
		calendar.add(Calendar.MONTH, 1);
		
		nMonth = calendar.get(Calendar.MONTH)+1;
		if(nYear == 12) {
			calendar.add(Calendar.YEAR, 1);
		}
		logger.info("======================"+ today);
		
		String month_lastday = (String)(nYear+"-"+nMonth+"-"+nDay);

		logger.info("======================"+ month_lastday );


		model.addAttribute("date_s", today);
		model.addAttribute("date_e", month_lastday);
		
		Date date_start = Format.parse(today);
		Date date_end = Format.parse(month_lastday);
		dto.setDate_s(date_start);
		dto.setDate_e(date_end);
		
		
		String str="";
		
		str += "[[Date,Sales],";
		
		
		List<SalesDTO> list= service.readChart(dto);
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
