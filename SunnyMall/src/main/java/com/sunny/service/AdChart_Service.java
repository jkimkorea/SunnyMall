package com.sunny.service;

import java.util.List;
import java.util.Map;

import com.sunny.dto.SalesDTO;

public interface AdChart_Service {

	//매출 챠트값 불러오기
	public List<SalesDTO> readChart(String ord_date) throws Exception;
	
	//선택한 날짜에 해당하는 매출챠트값 불러오기
	public List<SalesDTO> searchChart(Map map) throws Exception;

}
