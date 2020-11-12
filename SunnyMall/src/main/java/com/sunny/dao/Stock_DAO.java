package com.sunny.dao;

import java.util.List;

import com.sunny.domain.ProductVO;
import com.sunny.util.SearchCriteria;

public interface Stock_DAO {

	//상품 재고 리스트
	public List<ProductVO> readStockList(SearchCriteria cri) throws Exception;
}
