package com.ikkat.los.formapplication.applicationcollateraldeposit.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "formapplication_collateral_deposit", schema = "public")
public class ApplicationCollateralDeposit implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="formapplication_collateral_deposit_id_seq")
    private Long id;
    private Long idcompany;
    private Long idapplication;
    private String bankid;
    private Double amount;
    private String currency;
    private String accountnumber;
    private Date duedate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdcompany() {
        return idcompany;
    }

    public void setIdcompany(Long idcompany) {
        this.idcompany = idcompany;
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

    public Date getDuedate() {
        return duedate;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }
}
