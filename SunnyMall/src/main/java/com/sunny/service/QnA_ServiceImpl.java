package com.sunny.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sunny.dao.QnA_DAO;
import com.sunny.domain.QnAVO;

@Service
public class QnA_ServiceImpl implements QnA_Service {

	@Inject
	private QnA_DAO dao;
		
	//문의글 등록
	@Override
	public void qnaAdd(QnAVO vo) throws Exception {
		dao.qnaAdd(vo);
	}
	
	
}
