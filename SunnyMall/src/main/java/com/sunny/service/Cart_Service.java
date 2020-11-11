package com.sunny.service;

import java.util.List;
import java.util.Map;

import com.sunny.domain.CartProductVO;
import com.sunny.domain.CartVO;

public interface Cart_Service {
	
	//카트에 상품 담기
	public void addToCart(CartVO vo) throws Exception;
	//장바구니 리스트 출력
	public List<CartProductVO> cartList(String mb_id) throws Exception;
	//장바구니 갯수 출력
	public int countCart(String mb_id) throws Exception;
	//장바구니 상품 삭제
	public void deleteCart(int cart_code) throws Exception;
	//장바구니 상품 수량 변경
	public void changeAmount(CartVO vo) throws Exception;
	//결제 후 장바구니 비우기
	public void deleteCartAfterPay(Map map) throws Exception;
}
