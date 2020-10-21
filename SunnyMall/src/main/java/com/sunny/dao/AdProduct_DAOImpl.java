package com.sunny.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sunny.domain.CategoryVO;
import com.sunny.domain.ProductVO;
import com.sunny.util.SearchCriteria;

@Repository
public class AdProduct_DAOImpl implements AdProduct_DAO {

	@Autowired
	private SqlSession session;
	
	private final static String NS="com.sunny.mappers.AdProduct_Mapper";

	//1차 카테고리 불러오기
	@Override
	public List<CategoryVO> mainCGList() {
		return session.selectList(NS+".mainCGList");
	}
	//서브 카테고리 불러오기
	@Override
	public List<CategoryVO> subCGList(String cg_code) {
		return session.selectList(NS+".subCGList",cg_code);
	}
	//상품 등록 
	@Override
	public void insertProduct(ProductVO vo) {
		session.insert(NS+".insertProduct", vo);
	}
	//상품 리스트
	@Override
	public List<ProductVO> searchListProduct(SearchCriteria cri) throws Exception {
		return session.selectList(NS+".searchListProduct", cri);
	}
	//검색 조건에 해당하는 상품 개수
	@Override
	public int searchListCount(SearchCriteria cri) throws Exception {
		return session.selectOne(NS+".searchListCount",cri);
	}
	//선택 상품 삭제
	@Override
	public void deleteProduct(int prd_no) throws Exception {
		session.delete(NS+".deleteProduct", prd_no);
	}
	//상품 정보 읽어오기
	@Override
	public ProductVO readProduct(int prd_no) throws Exception {
		return session.selectOne(NS+".readProduct", prd_no);
	}
	//상품 정보 수정하기
	@Override
	public void editProduct(ProductVO vo) throws Exception {
		session.update(NS+".editProduct", vo);
		
	}
	//선택한 상품 수량, 판매정보 수정
	@Override
	public void editChecked(Map<String, Object> map) throws Exception {
		session.update(NS+".editChecked", map);
	}
	
}
