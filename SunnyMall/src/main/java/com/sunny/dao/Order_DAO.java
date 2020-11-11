package com.sunny.dao;

import java.util.List;

import com.sunny.domain.OrderDetailVO;
import com.sunny.domain.OrderListVO;
import com.sunny.domain.OrderReadDetailVO;
import com.sunny.domain.OrderVO;

public interface Order_DAO {

	//주문 넘버 가져오기
	public int readOrderNo() throws Exception;
	//주문정보 저장
	public void addOrder(OrderVO order) throws Exception;
	//주문상세 정보 저장
	public void addOrderDetail(OrderDetailVO orderDetail) throws Exception;
	//주문정보 리스트 출력
	public List<OrderListVO> readOrderList(String mb_id) throws Exception;
	//주문 내역 상세
	public List<OrderReadDetailVO> readOrder(int ord_no) throws Exception;
	//주문자 정보
	public OrderVO getOrder(int ord_no) throws Exception;
	//관리자 주문정보 추가
	public void addToDelivery(int ord_no) throws Exception;
	//결제 확인
	public void payOK(int ord_no) throws Exception;
	//주문 페이지에 뿌려줄 장바구니 수량 불러오기
	public int readCartAmount(int cart_code) throws Exception;
	//주문 총 수량 저장
	public void addTotalAmount(int ord_no) throws Exception;
}
