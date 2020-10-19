package com.sunny.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sunny.dao.AdProduct_DAO;
import com.sunny.domain.CategoryVO;
import com.sunny.domain.ProductVO;
import com.sunny.util.SearchCriteria;

@Service
public class AdProduct_ServiceImpl implements AdProduct_Service {

	@Inject
	private AdProduct_DAO dao;

	//1차 카테고리 불러오기
	@Override
	public List<CategoryVO> mainCGList() {
		return dao.mainCGList();
	}
	//서브 카테고리 불러오기
	@Override
	public List<CategoryVO> subCGList(String cg_code) {
		return dao.subCGList(cg_code);
	}
	//상품 등록
	@Override
	public void insertProduct(ProductVO vo) {
		dao.insertProduct(vo);
	}
	//상품 리스트
	@Override
	public List<ProductVO> searchListProduct(SearchCriteria cri) throws Exception {
		return dao.searchListProduct(cri);
	}
	//검색 조건에 맞는 상품 개수
	@Override
	public int searchListCount(SearchCriteria cri) throws Exception {
		return dao.searchListCount(cri);
	}
	//선택 상품 삭제
	@Override
	public void deleteProduct(int prd_no) throws Exception {
		dao.deleteProduct(prd_no);
	}
	//상품 정보 불러오기
	@Override
	public ProductVO readProduct(int prd_no) throws Exception {
		return dao.readProduct(prd_no);
	}
	//상품 정보 수정하기
	@Override
	public void editProduct(ProductVO vo) throws Exception {
		dao.editProduct(vo);
	}


}
