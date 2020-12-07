package com.sunny.service;

import java.util.List;

import com.sunny.dto.RecentDateDTO;
import com.sunny.dto.SalesDTO;

public interface Chart_Service {

	//챠트값 불러오기
	public List<SalesDTO> readChart(RecentDateDTO date) throws Exception;
}
