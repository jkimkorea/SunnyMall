package com.sunny.dao;

import java.util.List;

import com.sunny.domain.CartProductVO;
import com.sunny.domain.CartVO;

public interface Cart_DAO {
	
	//카트에 상품 담기
	public void addToCart(CartVO vo) throws Exception;
	//장바구니 리스트
	public List<CartProductVO> cartList(String mb_id) throws Exception;
	//장바구니 갯수 출력
	public int countCart(String mb_id) throws Exception;
	//장바구니 상품 삭제
	public void deleteCart(int cart_code) throws Exception;
	//장바구니 상품 수량 변경
	public void changeAmount(CartVO vo) throws Exception;

}
