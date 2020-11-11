package com.sunny.domain;

import java.util.List;

public class OrderDetailVOList {

	private List<OrderDetailVO> orderDetailVOList;
	
	
	public List<OrderDetailVO> getOrderDetailVOList(){
		return orderDetailVOList;
	}
	public void setOrderDetailVOList(List<OrderDetailVO> orderDetailVOList) {
		this.orderDetailVOList = orderDetailVOList;
	}
	
	@Override
	public String toString() {
		return "OrderDetailVOList [orderDetailVOList=" + orderDetailVOList + "]";
	}
	
	
}
