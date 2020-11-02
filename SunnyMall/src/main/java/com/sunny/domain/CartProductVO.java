package com.sunny.domain;

public class CartProductVO {
	
	private int     cart_code;
	private int  	cart_amount;
	private String 	prd_company;
	private int 	prd_no;
	private String 	prd_name;
	private int 	prd_price;
	private int 	prd_discount;
	private String 	prd_img;
	private int 	cart_count;
	
	public int getCart_code() {
		return cart_code;
	}
	public void setCart_code(int cart_code) {
		this.cart_code = cart_code;
	}
	public int getCart_amount() {
		return cart_amount;
	}
	public void setCart_amount(int cart_amount) {
		this.cart_amount = cart_amount;
	}
	public int getPrd_no() {
		return prd_no;
	}
	public void setPrd_no(int prd_no) {
		this.prd_no = prd_no;
	}
	public String getPrd_name() {
		return prd_name;
	}
	public void setPrd_name(String prd_name) {
		this.prd_name = prd_name;
	}
	public int getPrd_price() {
		return prd_price;
	}
	public void setPrd_price(int prd_price) {
		this.prd_price = prd_price;
	}
	public int getPrd_discount() {
		return prd_discount;
	}
	public void setPrd_discount(int prd_discount) {
		this.prd_discount = prd_discount;
	}
	public String getPrd_img() {
		return prd_img;
	}
	public void setPrd_img(String prd_img) {
		this.prd_img = prd_img;
	}
	public String getPrd_company() {
		return prd_company;
	}
	public void setPrd_company(String prd_company) {
		this.prd_company = prd_company;
	}
	public int getCart_count() {
		return cart_count;
	}
	public void setCart_count(int cart_count) {
		this.cart_count = cart_count;
	}
	
	@Override
	public String toString() {
		return "CartProductVO [cart_code=" + cart_code + ", cart_amount=" + cart_amount + ", prd_company=" + prd_company
				+ ", prd_no=" + prd_no + ", prd_name=" + prd_name + ", prd_price=" + prd_price + ", prd_discount="
				+ prd_discount + ", prd_img=" + prd_img +"cart_count="+cart_count+ "]";
	}
	
	
}
