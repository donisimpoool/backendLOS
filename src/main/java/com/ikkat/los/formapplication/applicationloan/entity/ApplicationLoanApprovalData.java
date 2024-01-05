package com.ikkat.los.formapplication.applicationloan.entity;

public class ApplicationLoanApprovalData {
    private String applicationID;
    private Double amount;
    private LoanProduct loanproduct;
    private String loanproductID;
    private String purposeofloan;
    private int tenor;

    public String getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(String applicationID) {
        this.applicationID = applicationID;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LoanProduct getLoanproduct() {
        return loanproduct;
    }

    public void setLoanproduct(LoanProduct loanproduct) {
        this.loanproduct = loanproduct;
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
