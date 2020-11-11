package com.sunny.service;

import java.util.List;

import com.sunny.domain.OrderDetailVO;
import com.sunny.domain.OrderDetailVOList;
import com.sunny.domain.OrderListVO;
import com.sunny.domain.OrderReadDetailVO;
import com.sunny.domain.OrderVO;

public interface Order_Service {

	//바로 구매
	public void addOrder(OrderVO order,OrderDetailVOList orderDetailList) throws Exception; 
	//장바구니->상품 구매
	public void addOrderCart(OrderVO order, OrderDetailVOList orderDetailVOList,String mb_id) throws Exception;
	//주문  정보 리스트 출력
	public List<OrderListVO> readOrderList(String mb_id) throws Exception;
	//주문 상세 보기
	public List<OrderReadDetailVO> readOrder(int ord_no) throws Exception;
	//주문자 정보
	public OrderVO getOrder(int ord_no) throws Exception;
	//주문 페이지에 뿌려줄 장바구니 수량 가져오기
	public int readCartAmount(int cart_code) throws Exception;
	
}
