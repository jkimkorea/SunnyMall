package com.sunny.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sunny.domain.OrderDetailVO;
import com.sunny.domain.OrderListVO;
import com.sunny.domain.OrderReadDetailVO;
import com.sunny.domain.OrderVO;

@Repository
public class Order_DAOImpl implements Order_DAO {

	@Inject
	private SqlSession session;
	
	private final static String NS="com.sunny.mappers.Order_Mapper";

	//주문 넘버 가저오기
	@Override
	public int readOrderNo() throws Exception {
		return session.selectOne(NS+".readOrderNo");
	}
	//주문 정보 저장
	@Override
	public void addOrder(OrderVO order) throws Exception {
		session.insert(NS+".addOrder", order);
	}
	//주문 상세 정보 저장
	@Override
	public void addOrderDetail(OrderDetailVO orderDetail) throws Exception {
		session.insert(NS+".addOrderDetail", orderDetail);
	}
	//주문 정보 리스트 출력
	@Override
	public List<OrderListVO> readOrderList(String mb_id) throws Exception {
		return session.selectList(NS+".readOrderList", mb_id);
		
	}
	//주문 내역 상세 출력
	@Override
	public List<OrderReadDetailVO> readOrder(int ord_no) throws Exception {
		return session.selectList(NS+".readOrder", ord_no);
	}
	//주문자 정보
	@Override
	public OrderVO getOrder(int ord_no) throws Exception {
		return session.selectOne(NS+".getOrder",ord_no);
	}
	//관지자 주문정보 추가
	@Override
	public void addToDelivery(int ord_no) throws Exception {
		session.insert(NS+".addToDelivery", ord_no);
	}
	//결제 확인
	@Override
	public void payOK(int ord_no) throws Exception {
		session.update(NS+".payOK", ord_no);
	}
	//주문 페이지에 뿌려줄 장바구니 수량 불러오기
	@Override
	public int readCartAmount(int cart_code) throws Exception {
		return session.selectOne(NS+".readCartAmount",cart_code);
	}
	//주문 총 수량 저장
	@Override
	public void addTotalAmount(int ord_no) throws Exception {
		System.out.println("==========addTotalAmount() execute=================="+ord_no);
		session.update(NS+".addTotalAmount", ord_no);
	}


	
	
}
