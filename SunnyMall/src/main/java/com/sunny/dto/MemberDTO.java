package com.sunny.dto;

import java.util.Date;

public class MemberDTO {

	private String mb_id;
	private String mb_pw;
	private String mb_nickname;
	private String mb_name;
	private String mb_point;
	private Date   mb_date_last;
	private boolean useCookie; 
	
	public String getMb_id() {
		return mb_id;
	}
	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}
	public String getMb_pw() {
		return mb_pw;
	}
	public void setMb_pw(String mb_pw) {
		this.mb_pw = mb_pw;
	}
	public String getMb_nickname() {
		return mb_nickname;
	}
	public void setMb_nickname(String mb_nickname) {
		this.mb_nickname = mb_nickname;
	}
	public String getMb_name() {
		return mb_name;
	}
	public void setMb_name(String mb_name) {
		this.mb_name = mb_name;
	}
	public String getMb_point() {
		return mb_point;
	}
	public void setMb_point(String mb_point) {
		this.mb_point = mb_point;
	}
	public Date getMb_date_last() {
		return mb_date_last;
	}
	public void setMb_date_last(Date mb_date_last) {
		this.mb_date_last = mb_date_last;
	}
	public boolean isUseCookie() {
		return useCookie;
	}
	public void setUseCookie(boolean useCookie) {
		this.useCookie = useCookie;
	}
	@Override
	public String toString() {
		return "MemberDTO [mb_id=" + mb_id + ", mb_pw=" + mb_pw + ", mb_nickname=" + mb_nickname + ", mb_name="
				+ mb_name + ", mb_point=" + mb_point + ", mb_date_last=" + mb_date_last + ", useCookie=" + useCookie
				+ "]";
	}
	
	
}
