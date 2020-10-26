package com.sunny.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sunny.dao.Review_DAO;
import com.sunny.domain.ReviewVO;
import com.sunny.util.Criteria;

@Service
public class Review_ServiceImpl implements Review_Service {

	@Inject
	private Review_DAO dao;

	//리뷰 작성
	@Override
	public void writeReview(ReviewVO vo,String mb_id) throws Exception {
		vo.setMb_id(mb_id);
		dao.writeReview(vo);
	}
	//리뷰 리스트 출력
	@Override
	public List<ReviewVO> reviewList(int prd_no,Criteria cri) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("prd_no",prd_no);
		map.put("cri",cri);
		return dao.reviewList(map);
	}
	//리뷰 갯수 출력
	@Override
	public int reviewCount(int prd_no) throws Exception {
		return dao.reviewCount(prd_no);
	}
	//리뷰 삭제
	@Override
	public void deleteReview(int rev_no) throws Exception {
		dao.deleteReview(rev_no);
	}
}
