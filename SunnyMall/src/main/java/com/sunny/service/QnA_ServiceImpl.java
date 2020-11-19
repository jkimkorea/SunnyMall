package com.sunny.service;

import java.util.List;

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
	//문의글 갯수 출력
	@Override
	public int qnaCount(int prd_no) throws Exception {
		return dao.qnaCount(prd_no);
	}
	//문의글 목록 출력
	@Override
	public List<QnAVO> qnaList(int prd_no) throws Exception {
		return dao.qnaList(prd_no);
	}
	
	
}
