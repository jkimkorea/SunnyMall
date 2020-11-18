package com.sunny.dao;

import com.sunny.domain.QnAVO;

public interface QnA_DAO {

	//문의글 등록
	public void qnaAdd(QnAVO vo) throws Exception;
}
