package com.sunny.dto;

import java.util.Date;
import java.util.GregorianCalendar;

public class DateDTO {

	private int date_s;
	private GregorianCalendar date_e;
	public int getDate_s() {
		return date_s;
	}
	public void setDate_s(int last_date) {
		this.date_s = last_date;
	}
	public GregorianCalendar getDate_e() {
		return date_e;
	}
	public void setDate_e(GregorianCalendar today) {
		this.date_e = today;
	}
	@Override
	public String toString() {
		return "DateDTO [date_s=" + date_s + ", date_e=" + date_e + "]";
	}
	
	
	
}
