package com.sunny.service;

import java.util.List;
import java.util.Map;

import com.sunny.domain.DeliveryReadVO;
import com.sunny.util.SearchCriteria;

public interface Delivery_Service {
	
	//모든 배송정보 불러오기
	public List<DeliveryReadVO> deliveryListAll(SearchCriteria cri) throws Exception;
	//배송 정보 갯수 출력
	public int deliveryCount(SearchCriteria cri) throws Exception;
	//배송 상태 업데이트
	public void deliveryCheck(Map<String,Object> map) throws Exception;
	//총 주문 수량
	public int countTotalOrderAmount(int ord_no) throws Exception;
	//주문 번호
	public List<Integer> readOrd_no() throws Exception;
	//배송 날짜 업데이트
	public void deliveryDate(int ord_no) throws Exception;
	//배송 상태에 따른 목록 총갯수
	public int deliveryCheckedCount(String delivery_check) throws Exception ;
	//배송 상태에 따른 목록 출력
	public List<DeliveryReadVO> deliveryCheckedList(Map<String,Object> map) throws Exception;
}
