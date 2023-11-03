package com.ikkat.los.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_risk_level", schema = "public")
public class RiskLevelEntity implements Serializable{
	
	@Id
	private long id;
	private String namerisk;
	private String odds;
	private double probabilityofdefault;
	private double min;
	private double max;
	private String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public double getProbabilityofdefault() {
		return probabilityofdefault;
	}
	public void setProbabilityofdefault(double probabilityofdefault) {
		this.probabilityofdefault = probabilityofdefault;
	}
	public double getMin() {
		return min;
	}
	public void setMin(double min) {
		this.min = min;
	}
	public double getMax() {
		return max;
	}
	public void setMax(double max) {
		this.max = max;
	}
	
}
