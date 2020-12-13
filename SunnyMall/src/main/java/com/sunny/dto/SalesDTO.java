package com.sunny.dto;


public class SalesDTO {

	private int sales;
	private String ordDate;
	
	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	public String getOrdDate() {
		return ordDate;
	}
	public void setOrdDate(String ordDate) {
		this.ordDate = ordDate;
	}
	
	@Override
	public String toString() {
		return "SalesDTO [sales=" + sales + ", ordDate=" + ordDate + "]";
	}
	
}
