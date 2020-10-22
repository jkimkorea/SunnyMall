package com.sunny.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sunny.domain.CategoryVO;
import com.sunny.domain.ProductVO;

@Repository
public class Product_DAOImpl implements Product_DAO {

	@Inject
	private SqlSession session;
	
	private static final String NS="com.sunny.mappers.Product_Mapper";

	//1차 카테고리 출력
	@Override
	public List<CategoryVO> mainCGList() throws Exception {
		return session.selectList(NS+".mainCGList");
	}
	//2차 카테고리 출력
	@Override
	public List<CategoryVO> subCGList(String cg_code) throws Exception {
		return session.selectList(NS+".subCGList", cg_code);
	}
	//카테고리에 따른 상품 출력
	@Override
	public List<ProductVO> productListCG(Map map) throws Exception {
		return session.selectList(NS+".productListCG", map);
	}
	//카테고리명 출력
	@Override
	public String getCGName(String cg_code) throws Exception {
		return session.selectOne(NS+".getCGName", cg_code);
	}
	//상품 갯수 출력
	@Override
	public int productCount(String cg_code) throws Exception {
		return session.selectOne(NS+".productCount", cg_code);
	}
	//상품 상세 출력
	@Override
	public ProductVO readProduct(int prd_no) throws Exception {
		return session.selectOne(NS+".readProduct", prd_no);
	}

	

}
