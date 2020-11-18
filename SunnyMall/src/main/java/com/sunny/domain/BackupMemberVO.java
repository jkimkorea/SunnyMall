package com.sunny.domain;

import java.util.Date;

public class BackupMemberVO {

	private String  mb_id;
	private String  mb_name;
	private String  mb_email;
	private String  mb_phone;
	private String  comment;
	private Date 	del_date;
	
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
	public String getMb_email() {
		return mb_email;
	}
	public void setMb_email(String mb_email) {
		this.mb_email = mb_email;
	}
	public String getMb_phone() {
		return mb_phone;
	}
	public void setMb_phone(String mb_phone) {
		this.mb_phone = mb_phone;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getDel_date() {
		return del_date;
	}
	public void setDel_date(Date del_date) {
		this.del_date = del_date;
	}
	@Override
	public String toString() {
		return "BackupMemberVO [mb_id=" + mb_id + ", mb_name=" + mb_name + ", mb_email=" + mb_email  + ", mb_phone=" + mb_phone + ", comment=" + comment + ", del_date=" + del_date + "]";
	}
	
}
