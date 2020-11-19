package com.sunny.dao;

import java.util.List;

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
	//문의글 갯수 출력
	@Override
	public int qnaCount(int prd_no) throws Exception {
		return session.selectOne(NS+".qnaCount", prd_no);
	}
	//문의글 목록 출력
	@Override
	public List<QnAVO> qnaList(int prd_no) throws Exception {
		return session.selectList(NS+".qnaList", prd_no);
	}
	
	
}
