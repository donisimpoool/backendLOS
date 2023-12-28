package com.ikkat.los.formapplication.applicationfinancial.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "formapplication_financial", schema = "public")
public class ApplicationFinancial implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="formapplication_financial_id_seq")
    private Long id;
    private Long idcompany;
    private Long idapplication;
    private String typeincome;
    private Double mainincome;
    private Double sideincome;
    private Double expense;
    private Double additionalexpense;
    private Boolean vehicleowner;
    private String typevehicle;

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

    public String getTypeincome() {
        return typeincome;
    }

    public void setTypeincome(String typeincome) {
        this.typeincome = typeincome;
    }

    public Double getMainincome() {
        return mainincome;
    }

    public void setMainincome(Double mainincome) {
        this.mainincome = mainincome;
    }

    public Double getSideincome() {
        return sideincome;
    }

    public void setSideincome(Double sideincome) {
        this.sideincome = sideincome;
    }

    public Double getExpense() {
        return expense;
    }

    public void setExpense(Double expense) {
        this.expense = expense;
    }

    public Double getAdditionalexpense() {
        return additionalexpense;
    }

    public void setAdditionalexpense(Double additionalexpense) {
        this.additionalexpense = additionalexpense;
    }

    public Boolean getVehicleowner() {
        return vehicleowner;
    }

    public void setVehicleowner(Boolean vehicleowner) {
        this.vehicleowner = vehicleowner;
    }

    public String getTypevehicle() {
        return typevehicle;
    }

    public void setTypevehicle(String typevehicle) {
        this.typevehicle = typevehicle;
    }
}
