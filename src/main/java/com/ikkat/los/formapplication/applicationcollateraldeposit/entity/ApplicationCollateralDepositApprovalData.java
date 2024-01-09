package com.ikkat.los.formapplication.applicationcollateraldeposit.entity;

import com.ikkat.los.bank.entity.BankData;

import java.sql.Date;

public class ApplicationCollateralDepositApprovalData {
    private String applicationid;
    private String bankid;

    private BankData bank;
    private double amount;
    private String currency;
    private String accountnumber;
    private Date duedate;

    public BankData getBank() {
        return bank;
    }

    public void setBank(BankData bank) {
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

    public Date getDuedate() {
        return duedate;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }
}
