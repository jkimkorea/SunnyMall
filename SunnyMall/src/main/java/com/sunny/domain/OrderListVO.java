package com.sunny.domain;

import java.util.Date;

public class OrderListVO {

	private String prd_img;
	private String prd_name;
	private int prd_discount;
	private int ord_no;
	private int prd_no;
	private int ord_amount;
	private int ord_price;
	private Date ord_date;
	
	public String getPrd_img() {
		return prd_img;
	}
	public void setPrd_img(String prd_img) {
		this.prd_img = prd_img;
	}
	public String getPrd_name() {
		return prd_name;
	}
	public void setPrd_name(String prd_name) {
		this.prd_name = prd_name;
	}
	public int getPrd_discount() {
		return prd_discount;
	}
	public void setPrd_discount(int prd_discount) {
		this.prd_discount = prd_discount;
	}
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
	public Date getOrd_date() {
		return ord_date;
	}
	public void setOrd_date(Date ord_date) {
		this.ord_date = ord_date;
	}
	
	@Override
	public String toString() {
		return "OrderListVO [prd_img=" + prd_img + ", prd_name=" + prd_name + ",prd_discount"+prd_discount+", ord_no=" + ord_no + ", prd_no="
				+ prd_no + ", ord_amount=" + ord_amount + ", ord_price=" + ord_price + ", ord_date=" + ord_date + "]";
	}
	
}
