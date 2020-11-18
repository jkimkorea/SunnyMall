package com.sunny.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sunny.dao.Delivery_DAO;
import com.sunny.domain.DeliveryReadVO;
import com.sunny.domain.OrderVO;
import com.sunny.util.SearchCriteria;

@Service
public class Delivery_ServiceImpl implements Delivery_Service{
	
	@Inject
	private Delivery_DAO dao;

	//모든 배송정보 불러오기
	@Override
	public List<DeliveryReadVO> deliveryListAll(SearchCriteria cri) throws Exception {
		return dao.deliveryListAll(cri);
	}
	//배송 정보 갯수 출력
	@Override
	public int deliveryCount(SearchCriteria cri) throws Exception {
		return dao.deliveryCount(cri);
	}
	//배송 완료시 배송날짜 업데이트
	@Override
	public void deliveryCheck(Map<String,Object> map) throws Exception {
		dao.deliveryCheck(map);
	}
	//총 주문 수량
	@Override
	public int countTotalOrderAmount(int ord_no) throws Exception {
		return dao.countTotalOrderAmount(ord_no);
	}
	@Override
	public List<Integer> readOrd_no() throws Exception {
		return dao.readOrd_no();
	}
	//배송 날짜 업데이트
	@Override
	public void deliveryDate(int ord_no) throws Exception {
		dao.deliveryDate(ord_no);
	}
	//배송 상태에 따른 목록 총 갯수
	@Override
	public int deliveryCheckedCount(String delivery_check) throws Exception {
		return dao.deliveryCheckedCount(delivery_check);
	}
	//배송 상태에 따른 목록출력
	@Override
	public List<DeliveryReadVO> deliveryCheckedList(Map<String, Object> map) throws Exception {
		return dao.deliveryCheckedList(map);
	}
	

}
