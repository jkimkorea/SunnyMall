package com.sunny.service;

import java.util.List;
import java.util.Map;

import com.sunny.domain.ProductVO;
import com.sunny.util.SearchCriteria;

public interface Stock_Service {

	//상품 재고 리스트
	public List<ProductVO> readStockList(SearchCriteria cri) throws Exception;
	//상품 재고량 수정
	public void setProductAmount(Map<String,Object> map) throws Exception;
}
