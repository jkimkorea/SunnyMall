package com.sunny.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sunny.dao.Cart_DAO;
import com.sunny.domain.CartProductVO;
import com.sunny.domain.CartVO;

@Service
public class Cart_ServiceImpl implements Cart_Service {

	@Inject
	private Cart_DAO dao;

	//카트에 상품 담기
	@Override
	public void addToCart(CartVO vo) throws Exception {
		dao.addToCart(vo);
	}
	//장바구니 리스트 출력
	@Override
	public List<CartProductVO> cartList(String mb_id) throws Exception {
		return dao.cartList(mb_id);
	}
	//장바구니 갯수 출력
	@Override
	public int countCart(String mb_id) throws Exception {
		return dao.countCart(mb_id);
	}
	//장바구니 상품 삭제
	@Override
	public void deleteCart(int cart_code) throws Exception {
		dao.deleteCart(cart_code);
	}
	//장바구니 상품 수량 변경
	@Override
	public void changeAmount(CartVO vo) throws Exception {
		dao.changeAmount(vo);
	}
	//상품 결제 후에 장바구니 비우기
	@Override
	public void deleteCartAfterPay(Map map) throws Exception {
		dao.deleteCartAfterPay(map);
	}
	
	
}
