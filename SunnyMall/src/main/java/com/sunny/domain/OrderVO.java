package com.sunny.domain;

import java.util.Date;

public class OrderVO {

	private int    ord_no;
	private String mb_id;
	private String ord_name;
	private String ord_zipcode;
	private String ord_add;
	private String ord_add_d;
	private String ord_phone;
	private int    ord_total_price;
	private int    ord_total_amount;
	private String ord_pay;
	private Date   ord_date;
	private Date   delivery_date;
	private String delivery_check;
	
	
	public String getDelivery_check() {
		return delivery_check;
	}
	public void setDelivery_check(String delivery_check) {
		this.delivery_check = delivery_check;
	}
	public int getOrd_no() {
		return ord_no;
	}
	public void setOrd_no(int ord_no) {
		this.ord_no = ord_no;
	}
	public String getMb_id() {
		return mb_id;
	}
	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}
	public String getOrd_name() {
		return ord_name;
	}
	public void setOrd_name(String ord_name) {
		this.ord_name = ord_name;
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
	public String getOrd_add_d() {
		return ord_add_d;
	}
	public void setOrd_add_d(String ord_add_d) {
		this.ord_add_d = ord_add_d;
	}
	public String getOrd_phone() {
		return ord_phone;
	}
	public void setOrd_phone(String ord_phone) {
		this.ord_phone = ord_phone;
	}
	public int getOrd_total_price() {
		return ord_total_price;
	}
	public void setOrd_total_price(int ord_total_price) {
		this.ord_total_price = ord_total_price;
	}
	public Date getOrd_date() {
		return ord_date;
	}
	public void setOrd_date(Date ord_date) {
		this.ord_date = ord_date;
	}
	public int getOrd_total_amount() {
		return ord_total_amount;
	}
	public void setOrd_total_amount(int ord_total_amount) {
		this.ord_total_amount = ord_total_amount;
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
	@Override
	public String toString() {
		return "OrderVO [ord_no=" + ord_no + ", mb_id=" + mb_id + ", ord_name=" + ord_name + ", ord_zipcode="
				+ ord_zipcode + ", ord_add=" + ord_add + ", ord_add_d=" + ord_add_d + ", ord_phone=" + ord_phone
				+ ", ord_total_price=" + ord_total_price + ", ord_total_amount=" + ord_total_amount + ", ord_pay="
				+ ord_pay + ", ord_date=" + ord_date + ", delivery_date=" + delivery_date + ", delivery_check="
				+ delivery_check + "]";
	}

	
}
