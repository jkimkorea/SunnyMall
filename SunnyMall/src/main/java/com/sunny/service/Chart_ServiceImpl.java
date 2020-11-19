package com.sunny.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sunny.dao.Chart_DAO;
import com.sunny.dto.SalesDTO;

@Service
public class Chart_ServiceImpl implements Chart_Service {

	@Inject
	private Chart_DAO dao;

	//챠트값 불러오기
	@Override
	public List<SalesDTO> readChart() throws Exception {
		return dao.readChart();
	}
	
	
}
