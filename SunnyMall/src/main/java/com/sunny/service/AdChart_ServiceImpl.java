package com.sunny.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sunny.dao.AdChart_DAO;
import com.sunny.dto.SalesDTO;

@Service
public class AdChart_ServiceImpl implements AdChart_Service {

	@Inject
	private AdChart_DAO dao;

	@Override
	public List<SalesDTO> readChart(String ord_date) throws Exception {
		return dao.readChart(ord_date);
	}

	@Override
	public List<SalesDTO> searchChart(Map map) throws Exception {
		return dao.searchChart(map);
	}


	
	
}
