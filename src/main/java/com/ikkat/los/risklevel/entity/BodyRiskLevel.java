package com.ikkat.los.risklevel.entity;

public class BodyRiskLevel {
    private String namerisk;
    private String odds;
    private Double probabilityofdefault;
    private Double min;
    private Double max;
    private String status;

    public String getNamerisk() {
        return namerisk;
    }

    public void setNamerisk(String namerisk) {
        this.namerisk = namerisk;
    }

    public String getOdds() {
        return odds;
    }

    public void setOdds(String odds) {
        this.odds = odds;
    }

    public Double getProbabilityofdefault() {
        return probabilityofdefault;
    }

    public void setProbabilityofdefault(Double probabilityofdefault) {
        this.probabilityofdefault = probabilityofdefault;
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
