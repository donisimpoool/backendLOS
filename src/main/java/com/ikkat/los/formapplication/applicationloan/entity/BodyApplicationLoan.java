package com.ikkat.los.formapplication.applicationloan.entity;

public class BodyApplicationLoan {
    private Long loanproductid;
    private String purposeofloan;
    private int tenor;
    private Double amount;

    public Long getLoanproductid() {
        return loanproductid;
    }

    public void setLoanproductid(Long loanproductid) {
        this.loanproductid = loanproductid;
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
