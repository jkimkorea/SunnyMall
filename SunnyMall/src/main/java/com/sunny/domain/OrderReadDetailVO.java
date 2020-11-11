package com.sunny.domain;

import java.util.Date;

public class OrderReadDetailVO {

	private int ord_amount;
	private int prd_no;
	private int ord_price;
	private int prd_price;
	private int prd_discount;
	private String prd_name;
	private String prd_img;
	
	public int getOrd_amount() {
		return ord_amount;
	}
	public void setOrd_amount(int ord_amount) {
		this.ord_amount = ord_amount;
	}
	public int getPrd_no() {
		return prd_no;
	}
	public void setPrd_no(int prd_no) {
		this.prd_no = prd_no;
	}
	public int getOrd_price() {
		return ord_price;
	}
	public void setOrd_price(int ord_price) {
		this.ord_price = ord_price;
	}
	public int getPrd_price() {
		return prd_price;
	}
	public void setPrd_price(int prd_price) {
		this.prd_price = prd_price;
	}
	public String getPrd_name() {
		return prd_name;
	}
	public void setPrd_name(String prd_name) {
		this.prd_name = prd_name;
	}
	public String getPrd_img() {
		return prd_img;
	}
	public void setPrd_img(String prd_img) {
		this.prd_img = prd_img;
	}
	public int getPrd_discount() {
		return prd_discount;
	}
	public void setPrd_discount(int prd_discount) {
		this.prd_discount = prd_discount;
	}
	
	@Override
	public String toString() {
		return "OrderReadDetailVO [ord_amount=" + ord_amount + ", prd_no=" + prd_no + ", ord_price=" + ord_price
				+ ", prd_price=" + prd_price + ", prd_discount=" + prd_discount + ", prd_name=" + prd_name
				+ ", prd_img=" + prd_img + "]";
	}
	
}
