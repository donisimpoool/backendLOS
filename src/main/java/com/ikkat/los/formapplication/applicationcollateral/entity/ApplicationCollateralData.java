package com.ikkat.los.formapplication.applicationcollateral.entity;

public class ApplicationCollateralData {
    private Long id;
    private Long idapplication;
    private String collateral;

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

    public String getCollateral() {
        return collateral;
    }

    public void setCollateral(String collateral) {
        this.collateral = collateral;
    }
}
