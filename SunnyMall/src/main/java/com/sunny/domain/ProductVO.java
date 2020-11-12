package com.sunny.domain;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class ProductVO {

	private int    prd_no;
	private int    rev_count;
	private String cg_code;
	private String cg_parent;
	private String prd_name;
	private int    prd_price;
	private int    prd_cost;
	private int    prd_discount;
	private String prd_company;
	private String prd_detail;
	private String prd_img;
	private int    prd_stock;
	private int    prd_total_sales;
	private String prd_buy;
	private Date   prd_date_post;
	private Date   prd_date_up;
	//업로드 파일
	private MultipartFile file1;

	public int getPrd_no() {
		return prd_no;
	}
	public void setPrd_no(int prd_no) {
		this.prd_no = prd_no;
	}
	public String getCg_code() {
		return cg_code;
	}
	public void setCg_code(String cg_code) {
		this.cg_code = cg_code;
	}
	public String getCg_parent() {
		return cg_parent;
	}
	public void setCg_parent(String cg_code_prt) {
		this.cg_parent = cg_code_prt;
	}
	public String getPrd_name() {
		return prd_name;
	}
	public void setPrd_name(String prd_name) {
		this.prd_name = prd_name;
	}
	public int getPrd_price() {
		return prd_price;
	}
	public void setPrd_price(int prd_price) {
		this.prd_price = prd_price;
	}
	public int getPrd_discount() {
		return prd_discount;
	}
	public void setPrd_discount(int prd_discount) {
		this.prd_discount = prd_discount;
	}
	public String getPrd_company() {
		return prd_company;
	}
	public void setPrd_company(String prd_company) {
		this.prd_company = prd_company;
	}
	public String getPrd_detail() {
		return prd_detail;
	}
	public void setPrd_detail(String prd_detail) {
		this.prd_detail = prd_detail;
	}
	public String getPrd_img() {
		return prd_img;
	}
	public void setPrd_img(String prd_img) {
		this.prd_img = prd_img;
	}
	public int getPrd_stock() {
		return prd_stock;
	}
	public void setPrd_stock(int prd_stock) {
		this.prd_stock = prd_stock;
	}
	public int getPrd_total_sales() {
		return prd_total_sales;
	}
	public void setPrd_total_sales(int prd_total_sales) {
		this.prd_total_sales = prd_total_sales;
	}
	public String getPrd_buy() {
		return prd_buy;
	}
	public void setPrd_buy(String prd_buy) {
		this.prd_buy = prd_buy;
	}
	public Date getPrd_date_post() {
		return prd_date_post;
	}
	public void setPrd_date_post(Date prd_date_post) {
		this.prd_date_post = prd_date_post;
	}
	public Date getPrd_date_up() {
		return prd_date_up;
	}
	public void setPrd_date_up(Date prd_date_up) {
		this.prd_date_up = prd_date_up;
	}
	public MultipartFile getFile1() {
		return file1;
	}
	public void setFile1(MultipartFile file1) {
		this.file1 = file1;
	}
	public int getRev_count() {
		return rev_count;
	}
	public void setRev_count(int rev_count) {
		this.rev_count = rev_count;
	}
	public int getPrd_cost() {
		return prd_cost;
	}
	public void setPrd_cost(int prd_cost) {
		this.prd_cost = prd_cost;
	}
	
	@Override
	public String toString() {
		return "ProductVO [prd_no=" + prd_no + ", rev_count=" + rev_count + ", cg_code=" + cg_code + ", cg_parent="
				+ cg_parent + ", prd_name=" + prd_name + ", prd_price=" + prd_price + ", prd_cost=" + prd_cost
				+ ", prd_discount=" + prd_discount + ", prd_company=" + prd_company + ", prd_detail=" + prd_detail
				+ ", prd_img=" + prd_img + ", prd_stock=" + prd_stock + ", prd_total_sales=" + prd_total_sales
				+ ", prd_buy=" + prd_buy + ", prd_date_post=" + prd_date_post + ", prd_date_up=" + prd_date_up
				+ ", file1=" + file1 + "]";
	}
	
}
