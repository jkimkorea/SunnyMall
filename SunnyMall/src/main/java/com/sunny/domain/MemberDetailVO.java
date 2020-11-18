package com.sunny.domain;

import java.util.Date;

public class MemberDetailVO {

	private String  mb_id;
	private String  mb_name;
	private String  mb_pw;
	private String  mb_email;
	private String  mb_zipcode;
	private String  mb_add;
	private String  mb_add_d;
	private String  mb_phone;
	private String  mb_nickname;
	private String  mb_email_accept;
	private int	    mb_point;
	private String  ad_comment;
	private Date    mb_date_first;
	private Date	mb_date_up;
	private Date	mb_date_last;
	private int    ord_total_price;
	private int    ord_total_amount;
	
	public String getMb_id() {
		return mb_id;
	}
	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}
	public String getMb_name() {
		return mb_name;
	}
	public void setMb_name(String mb_name) {
		this.mb_name = mb_name;
	}
	public String getMb_pw() {
		return mb_pw;
	}
	public void setMb_pw(String mb_pw) {
		this.mb_pw = mb_pw;
	}
	public String getMb_email() {
		return mb_email;
	}
	public void setMb_email(String mb_email) {
		this.mb_email = mb_email;
	}
	public String getMb_zipcode() {
		return mb_zipcode;
	}
	public void setMb_zipcode(String mb_zipcode) {
		this.mb_zipcode = mb_zipcode;
	}
	public String getMb_add() {
		return mb_add;
	}
	public void setMb_add(String mb_add) {
		this.mb_add = mb_add;
	}
	public String getMb_add_d() {
		return mb_add_d;
	}
	public void setMb_add_d(String mb_add_d) {
		this.mb_add_d = mb_add_d;
	}
	public String getMb_phone() {
		return mb_phone;
	}
	public void setMb_phone(String mb_phone) {
		this.mb_phone = mb_phone;
	}
	public String getMb_nickname() {
		return mb_nickname;
	}
	public void setMb_nickname(String mb_nickname) {
		this.mb_nickname = mb_nickname;
	}
	public String getMb_email_accept() {
		return mb_email_accept;
	}
	public void setMb_email_accept(String mb_email_accept) {
		this.mb_email_accept = mb_email_accept;
	}
	public int getMb_point() {
		return mb_point;
	}
	public void setMb_point(int mb_point) {
		this.mb_point = mb_point;
	}
	public String getAd_comment() {
		return ad_comment;
	}
	public void setAd_comment(String ad_comment) {
		this.ad_comment = ad_comment;
	}
	public Date getMb_date_first() {
		return mb_date_first;
	}
	public void setMb_date_first(Date mb_date_first) {
		this.mb_date_first = mb_date_first;
	}
	public Date getMb_date_up() {
		return mb_date_up;
	}
	public void setMb_date_up(Date mb_date_up) {
		this.mb_date_up = mb_date_up;
	}
	public Date getMb_date_last() {
		return mb_date_last;
	}
	public void setMb_date_last(Date mb_date_last) {
		this.mb_date_last = mb_date_last;
	}
	public int getOrd_total_price() {
		return ord_total_price;
	}
	public void setOrd_total_price(int ord_total_price) {
		this.ord_total_price = ord_total_price;
	}
	public int getOrd_total_amount() {
		return ord_total_amount;
	}
	public void setOrd_total_amount(int ord_total_amount) {
		this.ord_total_amount = ord_total_amount;
	}
	
	@Override
	public String toString() {
		return "MemberDetailVO [mb_id=" + mb_id + ", mb_name=" + mb_name + ", mb_pw=" + mb_pw + ", mb_email=" + mb_email
				+ ", mb_zipcode=" + mb_zipcode + ", mb_add=" + mb_add + ", mb_add_d=" + mb_add_d + ", mb_phone="
				+ mb_phone + ", mb_nickname=" + mb_nickname + ", mb_email_accept=" + mb_email_accept + ", mb_point="
				+ mb_point + ", ad_comment=" + ad_comment + ", mb_date_first=" + mb_date_first + ", mb_date_up="
				+ mb_date_up + ", mb_date_last=" + mb_date_last + ", ord_total_price=" + ord_total_price
				+ ", ord_total_amount=" + ord_total_amount + "]";
	}
	
}
