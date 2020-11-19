package com.sunny.domain;

import java.util.Date;

public class QnAVO {
	
	private int    qna_no;
	private int    prd_no;
	private String mb_id;
	private String qna_title;
	private String qna_content;
	private Date   qna_reg_date;
	
	public int getQna_no() {
		return qna_no;
	}
	public void setQna_no(int qna_no) {
		this.qna_no = qna_no;
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
	public String getQna_title() {
		return qna_title;
	}
	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}
	public String getQna_content() {
		return qna_content;
	}
	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}
	public Date getQna_reg_date() {
		return qna_reg_date;
	}
	public void setQna_reg_date(Date qna_reg_date) {
		this.qna_reg_date = qna_reg_date;
	}
	
	@Override
	public String toString() {
		return "QnAVO [qna_no=" + qna_no + ", prd_no=" + prd_no + ", mb_id=" + mb_id + ", qna_title=" + qna_title
				+ ", qna_content=" + qna_content + ", qna_reg_date=" + qna_reg_date + "]";
	}
	
}
