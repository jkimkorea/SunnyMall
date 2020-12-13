package com.sunny.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sunny.dto.SalesDTO;

@Repository
public class AdChart_DAOImpl implements AdChart_DAO {

	@Inject
	private SqlSession session;
	
	private final static String NS = "com.sunny.mappers.AdChart_Mapper";

	//챠트값 불러오기
	@Override
	public List<SalesDTO> readChart(String ord_date) throws Exception {
		return session.selectList(NS+".readChart",ord_date);
	}

	@Override
	public List<SalesDTO> searchChart(Map map) throws Exception {
		return session.selectList(NS+".searchChart", map);
	}
	
	
}
