package com.sunny.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sunny.dao.Stock_DAO;
import com.sunny.domain.ProductVO;
import com.sunny.util.SearchCriteria;

@Service
public class Stock_ServiceImpl implements Stock_DAO, Stock_Service {

	@Inject
	private Stock_DAO dao;
	//상품 재고 리스트 출력
	@Override
	public List<ProductVO> readStockList(SearchCriteria cri) throws Exception {
		return dao.readStockList(cri);
	}
	//상품 재고량 수정
	@Override
	public void setProductAmount(Map<String, Object> map) throws Exception {
		dao.setProductAmount(map);
	}

	
}
