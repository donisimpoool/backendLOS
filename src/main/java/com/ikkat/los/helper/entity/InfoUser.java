package com.ikkat.los.helper.entity;

import java.util.List;

public class InfoUser {
	private String name;
	private int level;
	private int code;
	private String isapproval;
	private String firstroute;
	private int limitsizefile;
	private Menu items;
	private String companyid;
	private long idtable;
	
	
	public long getIdtable() {
		return idtable;
	}
	public void setIdtable(long idtable) {
		this.idtable = idtable;
	}
	public String getCompanyid() {
		return companyid;
	}
	public void setCompanyid(String companyid) {
		this.companyid = companyid;
	}
	public int getLimitsizefile() {
		return limitsizefile;
	}
	public void setLimitsizefile(int limitsizefile) {
		this.limitsizefile = limitsizefile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getIsapproval() {
		return isapproval;
	}
	public void setIsapproval(String isapproval) {
		this.isapproval = isapproval;
	}
	public Menu getItems() {
		return items;
	}
	public void setItems(Menu items) {
		this.items = items;
	}
	public String getFirstroute() {
		return firstroute;
	}
	public void setFirstroute(String firstroute) {
		this.firstroute = firstroute;
	}
	
}
