package com.sunny.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class Review_DAOImpl implements Review_DAO {

	@Inject
	private SqlSession session;
	
	private static final String NS="com.sunny.mappers.Review_Mapper";

	//리뷰 작성
	@Override
	public void writeReview(int prd_no) throws Exception {
		session.insert(NS+".writeReview", prd_no);
	}
	

	
}
