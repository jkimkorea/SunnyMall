package com.sunny.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunny.controller.Order_Controller;
import com.sunny.dao.Order_DAO;
import com.sunny.domain.OrderDetailVO;
import com.sunny.domain.OrderDetailVOList;
import com.sunny.domain.OrderListVO;
import com.sunny.domain.OrderReadDetailVO;
import com.sunny.domain.OrderVO;

@Service
public class Order_ServiceImpl implements Order_Service {

	@Inject
	private Order_DAO dao;

	@Inject
	private Cart_Service cartService;
	
	private static final Logger logger = LoggerFactory.getLogger(Order_ServiceImpl.class);
	//상품 바로 구매
	@Transactional
	@Override
	public void addOrder(OrderVO order, OrderDetailVOList orderDetailList) throws Exception {

		logger.info("=================addOrder() execute=================");
		int ord_no = dao.readOrderNo();
		
		order.setOrd_no(ord_no);
		dao.addOrder(order);
		dao.addToDelivery(ord_no);
		logger.info("=================addOrder()=>ord_no:"+ord_no);
		List<OrderDetailVO> list = orderDetailList.getOrderDetailVOList();
		for(int i=0; i < list.size(); i++) {
			OrderDetailVO orderDetail = list.get(i);
			orderDetail.setOrd_no(ord_no);
			dao.addOrderDetail(orderDetail);
		}
		dao.addTotalAmount(ord_no);
	}
	//장바구니->주문결제
	@Transactional
	@Override
	public void addOrderCart(OrderVO order, OrderDetailVOList orderDetailVOList,String mb_id) throws Exception {
		
		logger.info("=================addOrderCart() execute=================");
		int ord_no = dao.readOrderNo();
		order.setOrd_no(ord_no);
		dao.addOrder(order);
		dao.addToDelivery(ord_no);
		logger.info("==================orderService=>ord_no:"+ord_no);
		
		List<OrderDetailVO> list = orderDetailVOList.getOrderDetailVOList();
		for(int i=0; i<list.size(); i++) {
			OrderDetailVO orderDetail = list.get(i);
			orderDetail.setOrd_no(ord_no);
			dao.addOrderDetail(orderDetail);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("mb_id", mb_id);
		map.put("prd_no",orderDetail.getPrd_no());
		dao.addTotalAmount(ord_no);
		cartService.deleteCartAfterPay(map);	
		}
	}
	//주문 목록 
	@Override
	public List<OrderListVO> readOrderList(String mb_id) throws Exception {
		return dao.readOrderList(mb_id);
	}
	//주문 내역->주문 상세보기
	@Override
	public List<OrderReadDetailVO> readOrder(int ord_no) throws Exception {
		return dao.readOrder(ord_no);
	}
	//주문자 정보
	@Override
	public OrderVO getOrder(int ord_no) throws Exception {
		return dao.getOrder(ord_no);
	}
	//주문페이지에 뿌려줄 장바구니 수량 가져오기
	@Override
	public int readCartAmount(int cart_code) throws Exception {
		return dao.readCartAmount(cart_code);
	}


}
