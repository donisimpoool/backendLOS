package com.ikkat.los.loanproduct.entity;

import java.math.BigDecimal;

public class LoanRangeSize {
    private String loanID;
    private String loanname;
    private String loandesc;
    private BigDecimal amount;
    private Long appall;
    private Long appapprove;
    private Long appunderwriting;

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

    public Long getAppall() {
        return appall;
    }

    public void setAppall(Long appall) {
        this.appall = appall;
    }

    public Long getAppapprove() {
        return appapprove;
    }

    public void setAppapprove(Long appapprove) {
        this.appapprove = appapprove;
    }

    public Long getAppunderwriting() {
        return appunderwriting;
    }

    public void setAppunderwriting(Long appunderwriting) {
        this.appunderwriting = appunderwriting;
    }
}
