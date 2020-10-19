package com.sunny.domain;

import java.util.Date;

public class MemberVO {

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
	private Date    mb_date_firs;
	private Date	mb_date_up;
	private Date	mb_date_last;
	private String 	mb_authcode;
	private String  mb_session_key;
	private Date	mb_session_limit;
	
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
	public Date getMb_date_firs() {
		return mb_date_firs;
	}
	public void setMb_date_firs(Date mb_date_firs) {
		this.mb_date_firs = mb_date_firs;
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
	public String getMb_authcode() {
		return mb_authcode;
	}
	public void setMb_authcode(String mb_authcode) {
		this.mb_authcode = mb_authcode;
	}
	public String getMb_session_key() {
		return mb_session_key;
	}
	public void setMb_session_key(String mb_session_key) {
		this.mb_session_key = mb_session_key;
	}
	public Date getMb_session_limit() {
		return mb_session_limit;
	}
	public void setMb_session_limit(Date mb_session_limit) {
		this.mb_session_limit = mb_session_limit;
	}
	@Override
	public String toString() {
		return "MemberVO [mb_id=" + mb_id + ", mb_name=" + mb_name + ", mb_pw=" + mb_pw + ", mb_email=" + mb_email
				+ ", mb_zipcode=" + mb_zipcode + ", mb_add=" + mb_add + ", mb_add_d=" + mb_add_d + ", mb_phone="
				+ mb_phone + ", mb_nickname=" + mb_nickname + ", mb_email_accept=" + mb_email_accept + ", mb_point="
				+ mb_point + ", mb_date_firs=" + mb_date_firs + ", mb_date_up=" + mb_date_up + ", mb_date_last="
				+ mb_date_last + ", mb_authcode=" + mb_authcode + ", mb_session_key=" + mb_session_key
				+ ", mb_session_limit=" + mb_session_limit + "]";
	}
	
	
}
