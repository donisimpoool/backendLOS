package com.ikkat.los.formapplication.applicationfinancial.entity;

public class ApplicationFInancialApprovalData {
    private String applicationid;
    private Double expense;
    private Double mainincome;
    private Double sideincome;
    private Double additionalexpense;
    private String typeincome;
    private String typevehicle;
    private String vehicleowner;

    public Double getAdditionalexpense() {
        return additionalexpense;
    }

    public void setAdditionalexpense(Double additionalexpense) {
        this.additionalexpense = additionalexpense;
    }

    public String getApplicationid() {
        return applicationid;
    }

    public void setApplicationid(String applicationid) {
        this.applicationid = applicationid;
    }

    public Double getExpense() {
        return expense;
    }

    public void setExpense(Double expense) {
        this.expense = expense;
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

    public String getTypeincome() {
        return typeincome;
    }

    public void setTypeincome(String typeincome) {
        this.typeincome = typeincome;
    }

    public String getTypevehicle() {
        return typevehicle;
    }

    public void setTypevehicle(String typevehicle) {
        this.typevehicle = typevehicle;
    }

    public String getVehicleowner() {
        return vehicleowner;
    }

    public void setVehicleowner(String vehicleowner) {
        this.vehicleowner = vehicleowner;
    }
}
