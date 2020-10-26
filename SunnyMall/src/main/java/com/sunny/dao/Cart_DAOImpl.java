package com.sunny.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class Cart_DAOImpl implements Cart_DAO {
	
	@Inject
	private SqlSession session;
	
	private static final String NS="com.sunny.mappers.Cart_Mapper";
	
	
}
