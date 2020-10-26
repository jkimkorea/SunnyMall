package com.sunny.service;

import java.util.List;
import java.util.Map;

import com.sunny.domain.ReviewVO;
import com.sunny.util.Criteria;

public interface Review_Service {

	//리뷰 작성
	public void writeReview(ReviewVO vo,String mb_id) throws Exception;
	//리뷰 리스트 출력
	public List<ReviewVO> reviewList(int prd_no,Criteria cri) throws Exception;
	//리뷰 갯수 출력
	public int reviewCount(int prd_no) throws Exception;
	//리뷰 삭제
	public void deleteReview(int rev_no) throws Exception;
}
