package com.sunny.dao;

import java.util.List;
import java.util.Map;

import com.sunny.domain.DeliveryVO;
import com.sunny.domain.OrderVO;
import com.sunny.util.SearchCriteria;

public interface Delivery_DAO {

	//모든 배송정보 불러오기
	public List<OrderVO> deliveryListAll(SearchCriteria cri) throws Exception;
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
}
