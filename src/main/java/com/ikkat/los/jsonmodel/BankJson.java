package com.ikkat.los.jsonmodel;

import com.ikkat.los.entity.BankEntity;
import com.ikkat.los.utils.Utils;

public class BankJson {
	private String id;
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public BankEntity getEntity() {
		BankEntity entity = new BankEntity();
		String id = String.valueOf(Utils.generateNumber());
		entity.setBankId(id);
		entity.setBankName(this.name);
		return entity;
	}
}
