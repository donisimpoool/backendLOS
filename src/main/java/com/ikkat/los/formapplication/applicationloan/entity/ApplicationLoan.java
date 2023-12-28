package com.ikkat.los.formapplication.applicationloan.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "formapplication_loan", schema = "public")
public class ApplicationLoan implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="formapplication_loan_id_seq")
    private Long id;
    private Long idcompany;
    private Long idapplication;
    private Long loanproductid;
    private String purposeofloan;
    private int tenor;
    private Double amount;

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
