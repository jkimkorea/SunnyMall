package com.sunny.domain;

import java.util.Date;

public class OrderVO {

	private int    ord_no;
	private String mb_id;
	private String ord_name;
	private String ord_zipcode;
	private String ord_add;
	private String ord_add_d;
	private String ord_phon;
	private int    ord_total_pri;
	private Date   ord_date;
	
	
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
	public String getOrd_phon() {
		return ord_phon;
	}
	public void setOrd_phon(String ord_phon) {
		this.ord_phon = ord_phon;
	}
	public int getOrd_total_pri() {
		return ord_total_pri;
	}
	public void setOrd_total_pri(int ord_total_pri) {
		this.ord_total_pri = ord_total_pri;
	}
	public Date getOrd_date() {
		return ord_date;
	}
	public void setOrd_date(Date ord_date) {
		this.ord_date = ord_date;
	}
	
	@Override
	public String toString() {
		return "OrderVO [ord_no=" + ord_no + ", mb_id=" + mb_id + ", ord_name=" + ord_name + ", ord_zipcode="
				+ ord_zipcode + ", ord_add=" + ord_add + ", ord_add_d=" + ord_add_d + ", ord_phon=" + ord_phon
				+ ", ord_total_pri=" + ord_total_pri + ", ord_date=" + ord_date + "]";
	}
	
	
}
