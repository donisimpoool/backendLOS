package com.ikkat.los.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "application_loan", schema = "public")
public class LoanapplicationEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String applicationID;
	private String loanproductID;
	private String purposeofloan;
	private int tenor;
	private double amount;
	
	@OneToOne()
    @JoinColumn(name="loanproductid",insertable = false, updatable = false)
    private LoanProductEntity loanproduct;

	public LoanProductEntity getLoanproduct() {
		return loanproduct;
	}
	public void setLoanproduct(LoanProductEntity loanproduct) {
		this.loanproduct = loanproduct;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getApplicationID() {
		return applicationID;
	}
	public void setApplicationID(String applicationID) {
		this.applicationID = applicationID;
	}
	public String getLoanproductID() {
		return loanproductID;
	}
	public void setLoanproductID(String loanproductID) {
		this.loanproductID = loanproductID;
	}
	public String getPurposeofloan() {
		return purposeofloan;
	}
	public void setPurposeofloan(String purposeofloan) {
		this.purposeofloan = purposeofloan;
	}
	public int getTenor() {
		return tenor;
	}
	public void setTenor(int tenor) {
		this.tenor = tenor;
	}
	
	
}
