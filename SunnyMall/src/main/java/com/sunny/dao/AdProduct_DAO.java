package com.sunny.dao;

import java.util.List;

import com.sunny.domain.CategoryVO;
import com.sunny.domain.ProductVO;
import com.sunny.util.SearchCriteria;

public interface AdProduct_DAO {
	
	//1차 카테고리 불러오기
	public List<CategoryVO> mainCGList();
	//서브 카테고리 불러오기
	public List<CategoryVO> subCGList(String cg_code);
	//상품 등록
	public void insertProduct(ProductVO vo);
	//상품 리스트
	public List<ProductVO> searchListProduct(SearchCriteria cri) throws Exception;
	//검색조건에 해당하는 상품 개수
	public int searchListCount(SearchCriteria cri) throws Exception;
	//선택 상품 삭제
	public void deleteProduct(int prd_no) throws Exception;
	//상품 정보 읽어오기
	public ProductVO readProduct(int prd_no) throws Exception;
	//상품 정보 수정하기
	public void editProduct(ProductVO vo) throws Exception;
}
