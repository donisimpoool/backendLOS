package com.ikkat.los.jsonmodel;

import com.ikkat.los.entity.LoanProductEntity;
import com.ikkat.los.utils.Utils;

import io.swagger.annotations.ApiModelProperty;

public class LoanProductJson {
	private String id;
	private String description;
	private String name;
	private double minamount;
	private double maxamount;
	private int mintenor;
	private int maxtenor;
	private String filterid;
	private double defaultamount;
	private int defaulttenor;
	
	public LoanProductEntity getEntity() {
		String id = String.valueOf(Utils.generateNumber());
		LoanProductEntity entity = new LoanProductEntity();
		entity.setLoanProductId(id);
		entity.setDefaultamount(this.defaultamount);
		entity.setDefaulttenor(this.defaulttenor);
		entity.setFilterid_h(this.filterid);
		entity.setHasCollateral(false);
		entity.setLoanDescription(this.description);
		entity.setLoanName(this.name);
		entity.setMaxamount(this.maxamount);
		entity.setMaxreject(0);
		entity.setMaxtenor(this.maxtenor);
		entity.setMintenor(this.mintenor);
		entity.setMinamount(this.minamount);
		entity.setMaxamount(this.maxamount);
		return entity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMinamount() {
		return minamount;
	}

	public void setMinamount(double minamount) {
		this.minamount = minamount;
	}

	public double getMaxamount() {
		return maxamount;
	}

	public void setMaxamount(double maxamount) {
		this.maxamount = maxamount;
	}

	public int getMintenor() {
		return mintenor;
	}

	public void setMintenor(int mintenor) {
		this.mintenor = mintenor;
	}

	public int getMaxtenor() {
		return maxtenor;
	}

	public void setMaxtenor(int maxtenor) {
		this.maxtenor = maxtenor;
	}

	public String getFilterid() {
		return filterid;
	}

	public void setFilterid(String filterid) {
		this.filterid = filterid;
	}

	public double getDefaultamount() {
		return defaultamount;
	}

	public void setDefaultamount(double defaultamount) {
		this.defaultamount = defaultamount;
	}

	public int getDefaulttenor() {
		return defaulttenor;
	}

	public void setDefaulttenor(int defaulttenor) {
		this.defaulttenor = defaulttenor;
	}
	
}
