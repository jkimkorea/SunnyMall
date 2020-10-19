package com.sunny.domain;

public class CategoryVO {

	private String cg_code;
	private String cg_parent;
	private String cg_name;
	
	
	public String getCg_code() {
		return cg_code;
	}
	public void setCg_code(String cg_code) {
		this.cg_code = cg_code;
	}
	public String getCg_parent() {
		return cg_parent;
	}
	public void setCg_parent(String cg_parent) {
		this.cg_parent = cg_parent;
	}
	public String getCg_name() {
		return cg_name;
	}
	public void setCg_name(String cg_name) {
		this.cg_name = cg_name;
	}
	@Override
	public String toString() {
		return "CategoryVO [cg_code=" + cg_code + ", cg_parent=" + cg_parent + ", cg_name=" + cg_name + "]";
	}
	

	
	
}
