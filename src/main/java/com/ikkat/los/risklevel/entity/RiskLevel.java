package com.ikkat.los.risklevel.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "m_risk_level", schema = "public")
public class RiskLevel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="m_risk_level_id_seq")
    private Long id;
    private Long idcompany;
    private String namerisk;
    private String odds;
    private Double probabilityofdefault;
    private Double min;
    private Double max;
    private String status;

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
