package com.sunny.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sunny.domain.ProductVO;
import com.sunny.util.SearchCriteria;

@Repository
public class Stock_DAOImpl implements Stock_DAO {

	@Inject
	private SqlSession session;
	
	private final static String NS="com.sunny.mappers.Stock_Mapper";

	//상품 재고 리스트 출력
	@Override
	public List<ProductVO> readStockList(SearchCriteria cri) throws Exception {
		return session.selectList(NS+".readStockList",cri);
	}
	//상품 재고량 수정
	@Override
	public void setProductAmount(Map<String, Object> map) throws Exception {
		session.update(NS+".setProductAmount", map);
	}
}
