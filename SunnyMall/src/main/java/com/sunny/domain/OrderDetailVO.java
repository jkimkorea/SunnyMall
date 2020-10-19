package com.sunny.domain;

public class OrderDetailVO {

	private int ord_no;
	private int prd_no;
	private int ord_count;
	private int ord_pri;
	
	
	public int getOrd_no() {
		return ord_no;
	}
	public void setOrd_no(int ord_no) {
		this.ord_no = ord_no;
	}
	public int getPrd_no() {
		return prd_no;
	}
	public void setPrd_no(int prd_no) {
		this.prd_no = prd_no;
	}
	public int getOrd_count() {
		return ord_count;
	}
	public void setOrd_count(int ord_count) {
		this.ord_count = ord_count;
	}
	public int getOrd_pri() {
		return ord_pri;
	}
	public void setOrd_pri(int ord_pri) {
		this.ord_pri = ord_pri;
	}
	
	@Override
	public String toString() {
		return "OrderDetailVO [ord_no=" + ord_no + ", prd_no=" + prd_no + ", ord_count=" + ord_count + ", ord_pri="
				+ ord_pri + "]";
	}
	
	
}
