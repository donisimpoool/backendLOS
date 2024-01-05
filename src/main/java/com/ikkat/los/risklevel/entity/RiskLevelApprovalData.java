package com.ikkat.los.risklevel.entity;

public class RiskLevelApprovalData {
    private Long id;
    private Double max;
    private Double min;
    private String namerisk;
    private String odds;
    private Double probabilityofdefault;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
