package com.sunny.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sunny.domain.DeliveryReadVO;
import com.sunny.util.SearchCriteria;

@Repository
public class Delivery_DAOImpl implements Delivery_DAO {

	@Inject
	private SqlSession session;
	
	private final static String NS="com.sunny.mappers.Delivery_Mapper";

	//모든 배송정보 불러오기
	@Override
	public List<DeliveryReadVO> deliveryListAll(SearchCriteria cri) throws Exception {
		return session.selectList(NS+".deliveryList",cri);
	}
	//배송 정보 갯수 출력
	@Override
	public int deliveryCount(SearchCriteria cri) throws Exception {
		return session.selectOne(NS+".deliveryCount",cri);
	}
	//배송 상태 업데이트
	@Override
	public void deliveryCheck(Map<String,Object> map) throws Exception {
		session.update(NS+".deliveryCheck", map);
	}
	//총 주문 수량
	@Override
	public int countTotalOrderAmount(int ord_no) throws Exception {
		return session.selectOne(NS+".countTotalOrderAmount", ord_no);
	}
	//주문 번호
	@Override
	public List<Integer> readOrd_no() throws Exception {
		return session.selectList(NS+".readOrd_no");
	}
	//배송 날짜 업데이트
	@Override
	public void deliveryDate(int ord_no) throws Exception {
		session.update(NS+".deliveryDate", ord_no);
	}
}
