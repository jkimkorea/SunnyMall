package com.sunny.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class Order_DAOImpl implements Order_DAO {

	@Inject
	private SqlSession session;
	
	private final static String NS="";
	
	
}
