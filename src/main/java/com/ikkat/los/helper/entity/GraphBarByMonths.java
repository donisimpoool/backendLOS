package com.ikkat.los.helper.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.ikkat.los.enumeration.DateFormatEnum;
import com.ikkat.los.service.LoanProductService;
import com.ikkat.los.utils.Utils;

public class GraphBarByMonths {
	private String month;
	private double jlmapllicant;
	private double jlmapllicantpending;
	private double jlmapllicantapprove;
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public double getJlmapllicant() {
		return jlmapllicant;
	}
	public void setJlmapllicant(double jlmapllicant) {
		this.jlmapllicant = jlmapllicant;
	}
	public double getJlmapllicantpending() {
		return jlmapllicantpending;
	}
	public void setJlmapllicantpending(double jlmapllicantpending) {
		this.jlmapllicantpending = jlmapllicantpending;
	}
	public double getJlmapllicantapprove() {
		return jlmapllicantapprove;
	}
	public void setJlmapllicantapprove(double jlmapllicantapprove) {
		this.jlmapllicantapprove = jlmapllicantapprove;
	}
	public List<GraphBarByMonths> listgraphs(LoanProductService service){
		List<GraphBarByMonths> list = new ArrayList<GraphBarByMonths>();
		int year = Calendar.getInstance().get(Calendar.YEAR);
		for(int month=1 ; month <= 12 ; month++) {
			GraphBarByMonths graphs = new GraphBarByMonths();
			String strmonth = String.valueOf(month);
			if(month < 10) {
				strmonth = "0"+String.valueOf(month);
			}
			String strfrom = year+"-"+strmonth+"-01";
			String strthru = year+"-"+strmonth+"-31";
			Date from = Utils.StringToDate(strfrom, DateFormatEnum.FORMAT_DATE.value());
			Date thru = Utils.StringToDate(strthru, DateFormatEnum.FORMAT_DATE.value());
			java.sql.Date sqlfrom = new java.sql.Date(from.getTime());
			java.sql.Date sqlthru = new java.sql.Date(thru.getTime());
			
			double appAll = service.jumlahapplicant(sqlfrom, sqlthru);
			double appApprove = service.jumlahapplicantbystatus(sqlfrom, sqlthru, "A");
			double appUnderwriting = service.jumlahapplicantbystatus(sqlfrom, sqlthru, "U");
			graphs.setMonth(Utils.namabulan(month));
//			if(month == 12) {
//				appAll = 8;
//				appApprove = 9;
//				appUnderwriting = 10;
//			}
//			System.out.println(appAll+" - "+appApprove+" - "+appUnderwriting);
			graphs.setJlmapllicant(appAll);
			graphs.setJlmapllicantapprove(appApprove);
			graphs.setJlmapllicantpending(appUnderwriting);
			list.add(graphs);
		}
		
		return list;
	}
	
}
