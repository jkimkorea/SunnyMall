package com.sunny.domain;

import java.util.Date;

public class ReviewVO {

	private int    rev_no;
	private String mb_id;
	private int    prd_no;
	private String rev_cont;
	private int    rev_score;
	private Date   rev_Date;
	
	public int getRev_no() {
		return rev_no;
	}
	public void setRev_no(int rev_no) {
		this.rev_no = rev_no;
	}
	public String getMb_id() {
		return mb_id;
	}
	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}
	public int getPrd_no() {
		return prd_no;
	}
	public void setPrd_no(int prd_no) {
		this.prd_no = prd_no;
	}
	public String getRev_cont() {
		return rev_cont;
	}
	public void setRev_cont(String rev_cont) {
		this.rev_cont = rev_cont;
	}
	public int getRev_score() {
		return rev_score;
	}
	public void setRev_score(int rev_score) {
		this.rev_score = rev_score;
	}
	public Date getRev_Date() {
		return rev_Date;
	}
	public void setRev_Date(Date rev_Date) {
		this.rev_Date = rev_Date;
	}
	
	@Override
	public String toString() {
		return "ReviewVO [rev_no=" + rev_no + ", mb_id=" + mb_id + ", prd_no=" + prd_no + ", rev_cont=" + rev_cont
				+ ", rev_score=" + rev_score + ", rev_Date=" + rev_Date + "]";
	}
	
	
}
