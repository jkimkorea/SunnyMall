package com.sunny.domain;

public class CartVO {

	private int cart_code;
	private int prd_no;
	private String mb_id;
	private int cart_amount;
	
	
	public int getCart_code() {
		return cart_code;
	}
	public void setCart_code(int cart_code) {
		this.cart_code = cart_code;
	}
	public int getPrd_no() {
		return prd_no;
	}
	public void setPrd_no(int prd_no) {
		this.prd_no = prd_no;
	}
	public String getMb_id() {
		return mb_id;
	}
	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}
	public int getCart_amount() {
		return cart_amount;
	}
	public void setCart_amount(int cart_amount) {
		this.cart_amount = cart_amount;
	}
	@Override
	public String toString() {
		return "CartVO [cart_code=" + cart_code + ", prd_no=" + prd_no + ", mb_id=" + mb_id + ", cart_amount="
				+ cart_amount + "]";
	}
	
	

}
