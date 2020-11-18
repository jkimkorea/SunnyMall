package com.sunny.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sunny.domain.QnAVO;

@Repository
public class QnA_DAOImpl implements QnA_DAO {
	
	@Inject
	private SqlSession session;
	
	private final static String NS="com.sunny.mappers.QnA_Mapper";

	//문의글 등록
	@Override
	public void qnaAdd(QnAVO vo) throws Exception {
		session.insert(NS+".qnaAdd", vo);
	}
	
	
}
