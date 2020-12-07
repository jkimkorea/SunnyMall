package com.sunny.dto;

import java.util.Date;
import java.util.GregorianCalendar;

public class RecentDateDTO {

	private Date date_s;
	private Date date_e;
	
	public Date getDate_s() {
		return date_s;
	}
	public void setDate_s(Date date_s) {
		this.date_s = date_s;
	}
	public Date getDate_e() {
		return date_e;
	}
	public void setDate_e(Date date_e) {
		this.date_e = date_e;
	}
	
	@Override
	public String toString() {
		return "DateDTO2 [date_s=" + date_s + ", date_e=" + date_e + "]";
	}
	

	
}
