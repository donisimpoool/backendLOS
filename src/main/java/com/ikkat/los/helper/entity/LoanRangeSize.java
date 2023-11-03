package com.ikkat.los.helper.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ikkat.los.entity.LoanProductEntity;

public class LoanRangeSize {
	private String loanID;
	private String loanname;
	private String loandesc;
	private BigDecimal amount;
	private double appall;
	private double appapprove;
	private double appunderwriting;
	
	public double getAppall() {
		return appall;
	}
	public void setAppall(double appall) {
		this.appall = appall;
	}
	public double getAppapprove() {
		return appapprove;
	}
	public void setAppapprove(double appapprove) {
		this.appapprove = appapprove;
	}
	public double getAppunderwriting() {
		return appunderwriting;
	}
	public void setAppunderwriting(double appunderwriting) {
		this.appunderwriting = appunderwriting;
	}
	public String getLoanID() {
		return loanID;
	}
	public void setLoanID(String loanID) {
		this.loanID = loanID;
	}
	public String getLoanname() {
		return loanname;
	}
	public void setLoanname(String loanname) {
		this.loanname = loanname;
	}
	public String getLoandesc() {
		return loandesc;
	}
	public void setLoandesc(String loandesc) {
		this.loandesc = loandesc;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	public List<LoanRangeSize> SetLoanRangeSize(List<Object> listobj,double appAll,double appUnderwrinting,double appApprove ) {
		List<LoanRangeSize> listentity = new ArrayList<LoanRangeSize>();
		for(Object obj : listobj) {
			Object[] arobj = (Object[]) obj;
			System.out.println("arobj : "+arobj.length);
			LoanRangeSize entity = new LoanRangeSize();
			String loanid = String.valueOf(arobj[0]);
			String loandesc = String.valueOf(arobj[1]);
			String loanname = String.valueOf(arobj[2]);
			Double dlbAmount = (Double) arobj[29];
			BigDecimal amount = new BigDecimal(dlbAmount);
			entity.setLoanID(loanid);
			entity.setLoanname(loanname);
			entity.setLoandesc(loandesc);
			entity.setAmount(amount);
			entity.setAppall(appAll);
			entity.setAppapprove(appApprove);
			entity.setAppunderwriting(appUnderwrinting);
			listentity.add(entity);
			
		}
		return listentity;
	}
	
}
