package com.ikkat.los.formapplication.applicationbank.entity;

public class ApplicationBankData {
    private Long id;
    private Long idapplication;
    private String bankid;
    private String accounttype;
    private String accountnumber;
    private boolean iscreditcard;
    private String bankcc;
    private String numbercc;
    private String typecredittcard;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdapplication() {
        return idapplication;
    }

    public void setIdapplication(Long idapplication) {
        this.idapplication = idapplication;
    }

    public String getBankid() {
        return bankid;
    }

    public void setBankid(String bankid) {
        this.bankid = bankid;
    }

    public String getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(String accounttype) {
        this.accounttype = accounttype;
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    public boolean isIscreditcard() {
        return iscreditcard;
    }

    public void setIscreditcard(boolean iscreditcard) {
        this.iscreditcard = iscreditcard;
    }

    public String getBankcc() {
        return bankcc;
    }

    public void setBankcc(String bankcc) {
        this.bankcc = bankcc;
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
