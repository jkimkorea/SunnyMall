package com.sunny.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sunny.domain.CartProductVO;
import com.sunny.domain.CartVO;

@Repository
public class Cart_DAOImpl implements Cart_DAO {
	
	@Inject
	private SqlSession session;
	
	private static final String NS="com.sunny.mappers.Cart_Mapper";

	//카트에 상품 담기
	@Override
	public void addToCart(CartVO vo) throws Exception {
		session.insert(NS+".addToCart", vo);
	}
	//장바구니 리스트
	@Override
	public List<CartProductVO> cartList(String mb_id) throws Exception {
		return session.selectList(NS+".cartList", mb_id);
	}
	//장바구니 갯수 출력
	@Override
	public int countCart(String mb_id) throws Exception {
		return session.selectOne(NS+".countCart", mb_id);
	}
	//장바구니 상품 삭제
	@Override
	public void deleteCart(int cart_code) throws Exception {
		session.delete(NS+".deleteCart", cart_code);
	}
	//장바구니 상품 수량 변경
	@Override
	public void changeAmount(CartVO vo) throws Exception {
		session.update(NS+".changeAmount", vo);
	}
	//결제후 장바구니 비우기
	@Override
	public void deleteCartAfterPay(Map map) throws Exception {
		session.delete(NS+".deleteCartAfterPay", map);
	}
	
	
}
