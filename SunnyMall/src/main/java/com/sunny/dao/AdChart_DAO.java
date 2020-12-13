package com.sunny.dao;

import java.util.List;
import java.util.Map;

import com.sunny.dto.SalesDTO;

public interface AdChart_DAO {

	//매출 챠트값 불러오기
	public List<SalesDTO> readChart(String ord_date) throws Exception;
	
	//지정한 날짜에 대한 매출 현황 챠트값 불러오기
	public List<SalesDTO> searchChart(Map map) throws Exception;
	
}
