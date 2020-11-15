package com.sunny.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunny.dao.Product_DAO;
import com.sunny.domain.CategoryVO;
import com.sunny.domain.ProductVO;
import com.sunny.util.Criteria;
import com.sunny.util.SearchCriteria;

@Service
public class Product_ServiceImpl implements Product_Service {

	@Autowired
	private Product_DAO dao;

	//1차 카테고리 불러오기
	@Override
	public List<CategoryVO> mainCGList() throws Exception {
		return dao.mainCGList();
	}
	//2차 카테고리 불러오기
	@Override
	public List<CategoryVO> subCGList(String cg_code) throws Exception {
		return dao.subCGList(cg_code);
	}
	//카테고리에 따른 상품 출력
	@Override
	public List<ProductVO> productListCG(Map map) throws Exception {
		return dao.productListCG(map);
	}
	//카테고리명 출력
	@Override
	public String getCGName(String cg_code) throws Exception {
		return dao.getCGName(cg_code);
	}
	//상품 갯수 출력
	@Override
	public int productCount(String cg_code) throws Exception {
		return dao.productCount(cg_code);
	}
	//상품 상세 출력
	@Override
	public ProductVO readProduct(int prd_no) throws Exception {
		return dao.readProduct(prd_no);
	}
	//모든 상품 출력
	@Override
	public List<ProductVO> allProductList(SearchCriteria cri) throws Exception {
		return dao.allProductList(cri);
	}
	//모든 상품 갯수 출력
	@Override
	public int allProductCount(SearchCriteria cri) throws Exception {
		return dao.allProductCount(cri);
	}
}
