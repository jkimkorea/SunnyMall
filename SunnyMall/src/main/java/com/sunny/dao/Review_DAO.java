package com.sunny.dao;

import java.util.List;
import java.util.Map;

import com.sunny.domain.ReviewVO;

public interface Review_DAO {

	//리뷰 작성
	public void writeReview(ReviewVO vo) throws Exception;
	//리뷰 갯수 추가
	public void addRevCount(ReviewVO vo) throws Exception;
	//리뷰 리스트 출력
	public List<ReviewVO> reviewList(Map<String,Object> map) throws Exception;
	//리뷰 갯수 출력
	public int reviewCount(int prd_no) throws Exception;
	//리뷰 삭제
	public void deleteReview(int rev_no) throws Exception;
	//리뷰 갯수 빼기
	public void minusRev(int prd_no) throws Exception;
	//리뷰 수정
	public void modify(ReviewVO vo) throws Exception;
}
