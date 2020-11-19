package com.sunny.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sunny.dto.SalesDTO;

@Repository
public class Chart_DAOImpl implements Chart_DAO {

	@Inject
	private SqlSession session;
	
	private final static String NS = "com.sunny.mappers.Chart_Mapper";

	//챠트값 불러오기
	@Override
	public List<SalesDTO> readChart() throws Exception {
		return session.selectList(NS+".readChart");
	}
	
	
}
