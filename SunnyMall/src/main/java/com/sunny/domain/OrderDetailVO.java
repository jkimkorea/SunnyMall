package com.sunny.domain;

public class OrderDetailVO {

	private int ord_no;
	private int prd_no;
	private int ord_amount;
	private int ord_price;
	
	
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
	public int getOrd_amount() {
		return ord_amount;
	}
	public void setOrd_amount(int ord_amount) {
		this.ord_amount = ord_amount;
	}
	public int getOrd_price() {
		return ord_price;
	}
	public void setOrd_price(int ord_price) {
		this.ord_price = ord_price;
	}
	
	@Override
	public String toString() {
		return "OrderDetailVO [ord_no=" + ord_no + ", prd_no=" + prd_no + ", ord_amount=" + ord_amount + ", ord_price="
				+ ord_price + "]";
	}
	
	
}
