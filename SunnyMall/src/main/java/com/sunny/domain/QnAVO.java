package com.sunny.domain;

import java.util.Date;

public class QnAVO {
	
	private int    bod_no;
	private int    prd_no;
	private String mb_id;
	private String bod_title;
	private String bod_content;
	private Date   bod_reg_date;
	
	public int getBod_no() {
		return bod_no;
	}
	public void setBod_no(int bod_no) {
		this.bod_no = bod_no;
	}
	public String getMb_id() {
		return mb_id;
	}
	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}
	public String getBod_title() {
		return bod_title;
	}
	public void setBod_title(String bod_title) {
		this.bod_title = bod_title;
	}
	public String getBod_content() {
		return bod_content;
	}
	public void setBod_content(String bod_content) {
		this.bod_content = bod_content;
	}
	public Date getBod_reg_date() {
		return bod_reg_date;
	}
	public void setBod_reg_date(Date bod_reg_date) {
		this.bod_reg_date = bod_reg_date;
	}
	public int getPrd_no() {
		return prd_no;
	}
	public void setPrd_no(int prd_no) {
		this.prd_no = prd_no;
	}
	@Override
	public String toString() {
		return "BoardVO [bod_no=" + bod_no + ", prd_no=" + prd_no + ", mb_id=" + mb_id + ", bod_title=" + bod_title
				+ ", bod_content=" + bod_content + ", bod_reg_date=" + bod_reg_date + "]";
	} 
	
}
