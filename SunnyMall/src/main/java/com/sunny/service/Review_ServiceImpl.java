package com.sunny.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sunny.dao.Review_DAO;

@Service
public class Review_ServiceImpl implements Review_Service {

	@Inject
	private Review_DAO dao;

	//리뷰 작성
	@Override
	public void writeReview(int prd_no) throws Exception {
		dao.writeReview(prd_no);
	}
}
