package com.sunny.domain;

import java.util.Date;

public class DeliveryVO {

	private int 	ord_no;
	private String	delivery_check;
	private String	ord_pay;
	private String 	ord_name;
	private String 	ord_phone;
	private String 	ord_email;
	private String 	ord_zipcode;
	private String 	ord_add;
	private String  ord_add_d;
	private int 	ord_amount;
	private int 	ord_total_price;
	private Date 	delivery_date;
	
	public int getOrd_no() {
		return ord_no;
	}
	public void setOrd_no(int ord_no) {
		this.ord_no = ord_no;
	}
	public String getDelivery_check() {
		return delivery_check;
	}
	public void setDelivery_check(String delivery_check) {
		this.delivery_check = delivery_check;
	}
	public String getOrd_pay() {
		return ord_pay;
	}
	public void setOrd_pay(String ord_pay) {
		this.ord_pay = ord_pay;
	}
	public Date getDelivery_date() {
		return delivery_date;
	}
	public void setDelivery_date(Date delivery_date) {
		this.delivery_date = delivery_date;
	}
	public String getOrd_name() {
		return ord_name;
	}
	public void setOrd_name(String ord_name) {
		this.ord_name = ord_name;
	}
	public String getOrd_phone() {
		return ord_phone;
	}
	public void setOrd_phone(String ord_phone) {
		this.ord_phone = ord_phone;
	}
	public String getOrd_email() {
		return ord_email;
	}
	public void setOrd_email(String ord_email) {
		this.ord_email = ord_email;
	}
	public String getOrd_zipcode() {
		return ord_zipcode;
	}
	public void setOrd_zipcode(String ord_zipcode) {
		this.ord_zipcode = ord_zipcode;
	}
	public String getOrd_add() {
		return ord_add;
	}
	public void setOrd_add(String ord_add) {
		this.ord_add = ord_add;
	}
	public int getOrd_amount() {
		return ord_amount;
	}
	public void setOrd_amount(int ord_amount) {
		this.ord_amount = ord_amount;
	}
	public int getOrd_total_price() {
		return ord_total_price;
	}
	public void setOrd_total_price(int ord_total_price) {
		this.ord_total_price = ord_total_price;
	}
	public String getOrd_add_d() {
		return ord_add_d;
	}
	public void setOrd_add_d(String ord_add_d) {
		this.ord_add_d = ord_add_d;
	}
	
	@Override
	public String toString() {
		return "DeliveryVO [ord_no=" + ord_no + ", delivery_check=" + delivery_check + ", ord_pay=" + ord_pay
				+ ", delivery_date=" + delivery_date + ", ord_name=" + ord_name + ", ord_phone=" + ord_phone
				+ ", ord_email=" + ord_email + ", ord_zipcode=" + ord_zipcode + ", ord_add=" + ord_add + ", ord_add_d="
				+ ord_add_d + ", ord_amount=" + ord_amount + ", ord_total_price=" + ord_total_price + "]";
	}

}
