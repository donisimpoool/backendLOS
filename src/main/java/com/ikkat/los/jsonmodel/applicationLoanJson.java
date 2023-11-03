package com.ikkat.los.jsonmodel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class applicationLoanJson {
	
	@JsonProperty(value = "loanProductId")
	private String loanproductID;
	@JsonProperty(value = "loanPurpose")
	private String purposeofloan;
	
	@JsonProperty(value = "loanTenor")
	private int tenor;
	
	@JsonProperty(value = "loanAmount")
	private String loanAmount;
	private String filterid;
	private int maxreject;
	
	public int getMaxreject() {
		return maxreject;
	}
	public void setMaxreject(int maxreject) {
		this.maxreject = maxreject;
	}
	public String getFilterid() {
		return filterid;
	}
	public void setFilterid(String filterid) {
		this.filterid = filterid;
	}
	public String getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(String loanAmount) {
		this.loanAmount = loanAmount;
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
	@Override
	public String toString() {
		return "applicationLoanJson [loanproductID=" + loanproductID + ", purposeofloan=" + purposeofloan + ", tenor="
				+ tenor + ", loanAmount=" + loanAmount + "]";
	}
	
}
