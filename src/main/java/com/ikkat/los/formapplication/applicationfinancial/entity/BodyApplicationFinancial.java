package com.ikkat.los.formapplication.applicationfinancial.entity;

public class BodyApplicationFinancial {
    private String typeincome;
    private Double mainincome;
    private Double sideincome;
    private Double expense;
    private Double additionalexpense;
    private Boolean vehicleowner;
    private String typevehicle;

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
