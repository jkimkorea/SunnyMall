package com.sunny.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sunny.domain.ReviewVO;

@Repository
public class Review_DAOImpl implements Review_DAO {

	@Inject
	private SqlSession session;
	
	private static final String NS="com.sunny.mappers.Review_Mapper";

	//리뷰 작성
	@Override
	public void writeReview(ReviewVO vo) throws Exception {
		session.insert(NS+".writeReview", vo);
	}
	//리뷰 리스트 출력
	@Override
	public List<ReviewVO> reviewList(Map<String, Object> map) throws Exception {
		return session.selectList(NS+".reviewList", map);
	}
	//리뷰 갯수 출력
	@Override
	public int reviewCount(int prd_no) throws Exception {
		return session.selectOne(NS+".reviewCount", prd_no);
	}
	//리뷰 삭제
	@Override
	public void deleteReview(int rev_no) throws Exception {
		session.delete(NS+".deleteReview", rev_no);
	}
	
	

	
}
