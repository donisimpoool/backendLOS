package com.ikkat.los.jsonmodel;


public class ApplicationCollateralDepositJson {
	private String bankid;
	private String amount;
	private String currency;
	private String accountnumber;
	private long duedate;
	public String getBankid() {
		return bankid;
	}
	public void setBankid(String bankid) {
		this.bankid = bankid;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
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
	public long getDuedate() {
		return duedate;
	}
	public void setDuedate(long duedate) {
		this.duedate = duedate;
	}
}
