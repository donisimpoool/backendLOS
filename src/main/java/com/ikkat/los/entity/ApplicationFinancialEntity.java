package com.ikkat.los.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "application_financial", schema = "public")
public class ApplicationFinancialEntity implements Serializable{
	//applicationid,typeincome, mainincome, sideincome, expense, additionalexpense
	@Id
	private String applicationid;
	private String typeincome;
	private double mainincome;
	private double sideincome;
	private double expense;
	private double additionalexpense;
	private String vehicleowner;
	private String typevehicle;
	public String getVehicleowner() {
		return vehicleowner;
	}
	public void setVehicleowner(String vehicleowner) {
		this.vehicleowner = vehicleowner;
	}
	public String getTypevehicle() {
		return typevehicle;
	}
	public void setTypevehicle(String typevehicle) {
		this.typevehicle = typevehicle;
	}
	public String getApplicationid() {
		return applicationid;
	}
	public void setApplicationid(String applicationid) {
		this.applicationid = applicationid;
	}
	public String getTypeincome() {
		return typeincome;
	}
	public void setTypeincome(String typeincome) {
		this.typeincome = typeincome;
	}
	public double getMainincome() {
		return mainincome;
	}
	public void setMainincome(double mainincome) {
		this.mainincome = mainincome;
	}
	public double getSideincome() {
		return sideincome;
	}
	public void setSideincome(double sideincome) {
		this.sideincome = sideincome;
	}
	public double getExpense() {
		return expense;
	}
	public void setExpense(double expense) {
		this.expense = expense;
	}
	public double getAdditionalexpense() {
		return additionalexpense;
	}
	public void setAdditionalexpense(double additionalexpense) {
		this.additionalexpense = additionalexpense;
	}
	
}
