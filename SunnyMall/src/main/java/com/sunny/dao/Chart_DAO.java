package com.sunny.dao;

import java.util.List;

import com.sunny.dto.SalesDTO;

public interface Chart_DAO {

	//챠트값 불러오기
	public List<SalesDTO> readChart() throws Exception;
}
