package com.ikkat.los.helper.entity;

import java.util.Calendar;
import java.util.Date;

import com.ikkat.los.enumeration.DateFormatEnum;
import com.ikkat.los.service.LoanProductService;
import com.ikkat.los.utils.Utils;

public class DoghnutChartData {
	private double jmlapplied;
	private double jmlpending;
	private double jmlapprove;
	public double getJmlapplied() {
		return jmlapplied;
	}
	public void setJmlapplied(double jmlapplied) {
		this.jmlapplied = jmlapplied;
	}
	public double getJmlpending() {
		return jmlpending;
	}
	public void setJmlpending(double jmlpending) {
		this.jmlpending = jmlpending;
	}
	public double getJmlapprove() {
		return jmlapprove;
	}
	public void setJmlapprove(double jmlapprove) {
		this.jmlapprove = jmlapprove;
	}
	
	public DoghnutChartData setdata(LoanProductService service) {
		DoghnutChartData data = new DoghnutChartData();
		int year = Calendar.getInstance().get(Calendar.YEAR);
		String strfrom = year+"-01"+"-01";
		String strthru = year+"-12"+"-31";
		Date from = Utils.StringToDate(strfrom, DateFormatEnum.FORMAT_DATE.value());
		Date thru = Utils.StringToDate(strthru, DateFormatEnum.FORMAT_DATE.value());
		java.sql.Date sqlfrom = new java.sql.Date(from.getTime());
		java.sql.Date sqlthru = new java.sql.Date(thru.getTime());
		
		double appAll = service.jumlahapplicant(sqlfrom, sqlthru);
		double appApprove = service.jumlahapplicantbystatus(sqlfrom, sqlthru, "A");
		double appUnderwriting = service.jumlahapplicantbystatus(sqlfrom, sqlthru, "U");
		System.out.println(appAll+" - "+appApprove+" - "+appUnderwriting);
		data.setJmlapplied(appAll);
		data.setJmlapprove(appApprove);
		data.setJmlpending(appUnderwriting);
		
		return data;
	}
}
