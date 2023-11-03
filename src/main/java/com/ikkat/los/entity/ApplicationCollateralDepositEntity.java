package com.ikkat.los.entity;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "application_collateral_deposit", schema = "public")
public class ApplicationCollateralDepositEntity implements Serializable{
	@Id
	private String applicationid;
	private String bankid;
	private double amount;
	private String currency;
	private String accountnumber;
	private ZonedDateTime duedate;
	@OneToOne()
    @JoinColumn(name="bankid",insertable = false, updatable = false)
    private BankEntity bank;
	public BankEntity getBank() {
		return bank;
	}
	public void setBank(BankEntity bank) {
		this.bank = bank;
	}
	public String getApplicationid() {
		return applicationid;
	}
	public void setApplicationid(String applicationid) {
		this.applicationid = applicationid;
	}
	public String getBankid() {
		return bankid;
	}
	public void setBankid(String bankid) {
		this.bankid = bankid;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}
	public ZonedDateTime getDuedate() {
		return duedate;
	}
	public void setDuedate(ZonedDateTime duedate) {
		this.duedate = duedate;
	}
	
}
