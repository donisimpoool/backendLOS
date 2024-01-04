package com.ikkat.los.formapplication.applicationbank.entity;

public class ApplicationApprovalBank {
    private String applicationid;
    private String accountnumber;
    private String accounttype;
    private BankData bank;
    private String bankcc;
    private BankData bankcredit;
    private String bankid;
    private String iscreditcard;
    private String numbercc;
    private String typecredittcard;

    public String getApplicationid() {
        return applicationid;
    }

    public void setApplicationid(String applicationid) {
        this.applicationid = applicationid;
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    public String getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(String accounttype) {
        this.accounttype = accounttype;
    }

    public BankData getBank() {
        return bank;
    }

    public void setBank(BankData bank) {
        this.bank = bank;
    }

    public String getBankcc() {
        return bankcc;
    }

    public void setBankcc(String bankcc) {
        this.bankcc = bankcc;
    }

    public BankData getBankcredit() {
        return bankcredit;
    }

    public void setBankcredit(BankData bankcredit) {
        this.bankcredit = bankcredit;
    }

    public String getBankid() {
        return bankid;
    }

    public void setBankid(String bankid) {
        this.bankid = bankid;
    }

    public String getIscreditcard() {
        return iscreditcard;
    }

    public void setIscreditcard(String iscreditcard) {
        this.iscreditcard = iscreditcard;
    }

    public String getNumbercc() {
        return numbercc;
    }

    public void setNumbercc(String numbercc) {
        this.numbercc = numbercc;
    }

    public String getTypecredittcard() {
        return typecredittcard;
    }

    public void setTypecredittcard(String typecredittcard) {
        this.typecredittcard = typecredittcard;
    }
}
