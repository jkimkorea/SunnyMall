package com.sunny.dao;

import java.util.List;
import java.util.Map;

import com.sunny.domain.CategoryVO;
import com.sunny.domain.ProductVO;
import com.sunny.util.Criteria;

public interface Product_DAO {
	
	//1차 카테고리 출력
	public List<CategoryVO> mainCGList() throws Exception;
	//2차 카테고리 출력
	public List<CategoryVO> subCGList(String cg_code) throws Exception;
	//카테고리에 따른 상품 출력
	public List<ProductVO> productListCG(Map map) throws Exception;
	//카테고리명 출력
	public String getCGName(String cg_code) throws Exception;
	//상품 갯수 출력
	public int productCount(String cg_code) throws Exception;
	//상품 상세 출력
	public ProductVO readProduct(int prd_no) throws Exception;
	//모든 상품 출력
	public List<ProductVO> allProductList(Criteria cri) throws Exception;
	//모든 상품 갯수 출력
	public int allProductCount() throws Exception;
}
