package com.sunny.service;

import java.util.List;

import com.sunny.domain.QnAVO;

public interface QnA_Service {

	//문의글 등록
	public void qnaAdd(QnAVO vo) throws Exception;
	//qna갯수 출력
	public int qnaCount(int prd_no) throws Exception;
	//문의글 목록 출력
	public List<QnAVO> qnaList(int prd_no) throws Exception;
}
