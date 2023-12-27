package com.ikkat.los.formapplication.applicationcollateralvehicle.entity;

public class ApplicationCollateralVehicleData {
    private Long id;
    private Long idapplication;
    private String typevehicle;
    private String brand;
    private String typetransmision;
    private int years;
    private String mileage;
    private String model;

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

    public String getTypevehicle() {
        return typevehicle;
    }

    public void setTypevehicle(String typevehicle) {
        this.typevehicle = typevehicle;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getTypetransmision() {
        return typetransmision;
    }

    public void setTypetransmision(String typetransmision) {
        this.typetransmision = typetransmision;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
