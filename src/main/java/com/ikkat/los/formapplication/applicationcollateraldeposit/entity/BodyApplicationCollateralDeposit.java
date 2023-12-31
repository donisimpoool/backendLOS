package com.ikkat.los.formapplication.applicationcollateraldeposit.entity;

import java.sql.Date;

public class BodyApplicationCollateralDeposit {
    private String bankid;
    private Double amount;
    private String currency;
    private String accountnumber;
//    private Date duedate;
    private Long duedatetime;

    public Long getDuedatetime() {
        return duedatetime;
    }

    public void setDuedatetime(Long duedatetime) {
        this.duedatetime = duedatetime;
    }

    public String getBankid() {
        return bankid;
    }

    public void setBankid(String bankid) {
        this.bankid = bankid;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
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

//    public Date getDuedate() {
//        return duedate;
//    }
//
//    public void setDuedate(Date duedate) {
//        this.duedate = duedate;
//    }
}
